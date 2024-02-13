package com.dag.nexarbmobile.dailogbox

import androidx.annotation.StringRes
import com.dag.nexarbmobile.base.ui.base.NexarbDialogBox

data class DefaultModelDialog(
    @StringRes override val titleRes:Int? = null,
    @StringRes override val messageRes: Int? = null,
    override val negativeButton: ModelDialogButton? = null,
    override val positiveButton: ModelDialogButton,
    override val isCancelable: Boolean = true,
    override val isIconVisible: Boolean = true,
    override val dialogPrimaryColor: NexarbDialogBox.DialogPrimaryColor = NexarbDialogBox.DialogPrimaryColor.Red,
): ModelDialog