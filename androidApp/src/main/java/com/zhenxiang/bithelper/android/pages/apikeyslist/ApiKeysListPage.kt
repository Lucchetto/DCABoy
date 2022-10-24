package com.zhenxiang.bithelper.android.pages.apikeyslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.zhenxiang.bithelper.db.ApiKey

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ApiKeysListPage(navController: NavController, viewModel: ApiKeysListViewModel) {

    val apiKeysListState = viewModel.apiKeysListFlow.collectAsStateWithLifecycle(
        emptyList()
    )


    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = {
            Fab {
                navController.navigate("add")
            }
        },
        content = { ApiKeysList(it, apiKeysListState) }
    )
}

@Composable
private fun TopBar() {
    return TopAppBar(
        title = { Text(text = "Api keys list") },
    )
}

@Composable
private fun Fab(onClick: () -> Unit) {
    return FloatingActionButton(
        onClick = onClick
    ) {
        Icon(imageVector = Icons.Outlined.Add, "Add")
    }
}

@Composable
private fun ApiKeysList(paddingValues: PaddingValues, state: State<List<ApiKey>>) {

    val list: List<ApiKey> by state

    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(list.size) {
            Text(list[it].toString())
        }
    }
}
