package com.dag.nexarbmobile.base.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.dag.nexarbmobile.BR
import com.dag.nexarbmobile.base.BaseDialogBoxUtil
import com.dag.nexarbmobile.base.CanDropSession
import com.dag.nexarbmobile.dailogbox.ModelDialog
import com.dag.nexarbmobile.dailogbox.ModelDialogHandler
import javax.inject.Inject

abstract class NexarbActivity<VM : NexarbViewModel, VB : ViewDataBinding> :
    AppCompatActivity(),
    CanDropSession {

    lateinit var binding: VB
    lateinit var viewModel: VM

    abstract fun getHomeViewModel(): VM
    abstract fun getLayout(): Int?

    @Inject
    lateinit var NexarbProcessDialogManager: NexarbProgressDialogManager

    @Inject
    lateinit var dialogBoxUtil: BaseDialogBoxUtil

    @Inject
    lateinit var modelDialogHandler: ModelDialogHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getHomeViewModel()
        getLayout()?.let {
            binding = DataBindingUtil.setContentView(this, it)
            //binding.setVariable(BR.viewModel, viewModel)
        }
        if (!viewModel.viewState.hasActiveObservers()) {
            viewModel.viewState.observe(this, Observer {
                handleState(it)
            })
        }
        if (!viewModel.isLoading().hasActiveObservers()) {
            viewModel.isLoading().observe(this, Observer {
                handleLoadingState(it)
            })
        }
    }

    open fun handleState(viewState: NexarbViewState) {
        when (viewState) {
            is ModelDialog -> modelDialogHandler.showDialog(this, viewState)
        }
    }
    fun handleLoadingState(isLoading: Boolean) {
        if (isLoading) {
            NexarbProcessDialogManager.showLoadingDialog(this)
        } else {
            NexarbProcessDialogManager.stopDialog()
        }
    }

    override fun dropSession() {
        // TODO: Navigate Splash
    }

    fun hideProgress() {

    }


}