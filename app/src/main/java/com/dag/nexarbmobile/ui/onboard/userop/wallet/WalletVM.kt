package com.dag.nexarbmobile.ui.onboard.userop.wallet

import androidx.lifecycle.viewModelScope
import com.dag.nexarbmobile.BuildConfig
import com.dag.nexarbmobile.base.ui.base.NexarbViewModel
import com.dag.nexarbmobile.ui.onboard.userop.wallet.usecase.Connected
import com.dag.nexarbmobile.ui.onboard.userop.wallet.usecase.PersistenceUseCase
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import com.solana.publickey.SolanaPublicKey
import com.solana.mobilewalletadapter.clientlib.TransactionResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletVM @Inject constructor(): NexarbViewModel() {

    @Inject
    lateinit var walletAdapter: MobileWalletAdapter
    @Inject
    lateinit var persistenceUseCase: PersistenceUseCase

    private val rpcUri = BuildConfig.RPC_URI

    fun loadConnection() {
        val persistedConn = persistenceUseCase.getWalletConnection()

        if (persistedConn is Connected) {

            val isLoading = true
            val canTransact = true
            val userAddress = persistedConn.publicKey.base58()
            val userLabel = persistedConn.accountLabel
            walletAdapter.authToken = persistedConn.authToken
        }
    }

    fun connect(sender: ActivityResultSender) {
        viewModelScope.launch {
            when (val result = walletAdapter.connect(sender)) {
                is TransactionResult.Success -> {
                    val currentConn = Connected(
                        SolanaPublicKey(result.authResult.publicKey),
                        result.authResult.accountLabel ?: "",
                        result.authResult.authToken
                    )

                    persistenceUseCase.persistConnection(
                        currentConn.publicKey,
                        currentConn.accountLabel,
                        currentConn.authToken
                    )

                    var isLoading = true
                    var userAddress = currentConn.publicKey.base58()
                    var userLabel = currentConn.accountLabel


                    isLoading = false
                }

                is TransactionResult.NoWalletFound -> {
                    val walletFound = false
                }

                is TransactionResult.Failure -> {
                    val isLoading = false
                    val canTransact = false
                }
            }
        }
    }

}