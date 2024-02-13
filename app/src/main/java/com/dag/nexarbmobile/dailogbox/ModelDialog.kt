package com.dag.nexarbmobile.dailogbox

import com.dag.nexarbmobile.base.ui.base.NexarbDialogBox
import com.dag.nexarbmobile.base.ui.base.NexarbViewState


interface ModelDialog: NexarbViewState {

    val titleRes:Int?
    val messageRes:Int?
    val negativeButton: ModelDialogButton?
    val positiveButton: ModelDialogButton
    val isCancelable:Boolean
    val isIconVisible: Boolean
    val dialogPrimaryColor: NexarbDialogBox.DialogPrimaryColor
}