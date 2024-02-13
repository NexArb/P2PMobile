package com.dag.nexarbmobile.base.ui.base

import android.app.Activity
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
class NexarbDialogBox {

    companion object {

        private val activeDialogs = mutableListOf<ClDialog>()

        fun showAlertDialog(
            activity: Activity,
            title: String,
            message: String,
            positiveButtonTitle: String?,
            negativeButtonTitle: String?,
            buttonClickListener: ButtonClickListener = object : ButtonClickListener() {},
            isCancelable: Boolean = true,
            isIconVisible: Boolean = true,
            dialogPrimaryColor: DialogPrimaryColor = DialogPrimaryColor.Red,
            create: Boolean = false,
            dialogKey: String?,
            iconNextToText: IconStatus? = null,
            backToPreviousIcon: Boolean? = null
        ): AlertDialog? {
            if (activity.isFinishing) {
                return null
            }
            return null
        }

        fun clearDuplicateDialogs(dialogKey: String? = null) {
            dialogKey?.let { dialogKey ->
                activeDialogs.filter {
                    it.dialogKey?.equals(dialogKey) == true
                }.forEach {
                    it.dialog.dismiss()
                    activeDialogs.remove(it)
                }
            }
        }

        fun clearDialogs() {
            activeDialogs.clear()
        }

        fun dismissDialogs() {
            activeDialogs.map {
                it.dialog.dismiss()
            }
        }

        fun hasActiveDialogs() = activeDialogs.size > 0
    }

    data class ClDialog(
        val dialog: AlertDialog,
        val dialogKey: String?
    )

    data class DialogButtonData(
        val positiveButtonTitle: String?,
        val negativeButtonTitle: String?,
        val buttonClickListener: ButtonClickListener
    )

    enum class DialogPrimaryColor {
        Red, Cyan, Purple, Yellow, Green, Turquoise, Orange, RedInfo
    }

    data class IconStatus(
        @DrawableRes val primaryIcon: Int?,
        @DrawableRes val lastIcon: Int?
    )

    abstract class ButtonClickListener {
        open fun onPositiveButtonClicked() {
            clearDuplicateDialogs()
        }

        open fun onNegativeButtonClicked() {
            clearDuplicateDialogs()
        }

        open fun onIconNextToTextClicked(@DrawableRes icon: Int? = null) {
            clearDuplicateDialogs()
        }
    }
}