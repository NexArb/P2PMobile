package com.dag.nexarbmobile.dailogbox

import androidx.annotation.StringRes
import com.dag.nexarbmobile.base.ui.base.NexarbDialogBox

data class DefaultRepeatableModelDialog(
    @StringRes override val titleRes: Int,
    @StringRes override val messageRes: Int,
    override val negativeButton: ModelDialogButton? = null,
    override val positiveButton: ModelDialogButton,
    override val isCancelable: Boolean = true,
    override val isIconVisible: Boolean = true,
    override val dialogPrimaryColor: NexarbDialogBox.DialogPrimaryColor = NexarbDialogBox.DialogPrimaryColor.Cyan,
    override val repeatOnPositiveButtonClick: Boolean = true,
    override val repeatOnNegativeButtonClick: Boolean = false,
    override val repeatOnCancel: Boolean = false,
) : RepeatableModelDialog {
    override var onRepeatAction: ((Boolean) -> Unit)? = null
}