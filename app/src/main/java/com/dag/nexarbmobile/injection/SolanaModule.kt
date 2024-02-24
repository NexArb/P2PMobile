package com.dag.nexarbmobile.injection

import com.solana.mobilewalletadapter.clientlib.ConnectionIdentity
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SolanaModule {
    @Provides
    fun provideWalletAdapter(): MobileWalletAdapter {
        return MobileWalletAdapter(
            connectionIdentity = ConnectionIdentity(
                identityUri = android.net.Uri.parse("https://solana.com"),
                iconUri = android.net.Uri.parse("favicon.ico"),
                identityName = "Solana"
            )
        )
    }
}