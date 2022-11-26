package com.zhenxiang.bithelper.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhenxiang.bithelper.foundation.BottomSheetDragHandle
import com.zhenxiang.bithelper.foundation.ModalBottomSheetDefaults

@Composable
fun BottomSheetContent(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .navigationBarsPadding()
            .imePadding()
            .fillMaxWidth()
            .padding(ModalBottomSheetDefaults.contentPadding),
    ) {
        BottomSheetDragHandle()
        content()
    }
}