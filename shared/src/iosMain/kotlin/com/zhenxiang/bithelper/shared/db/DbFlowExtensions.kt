package com.zhenxiang.bithelper.shared.db

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

actual fun <T : Any> Flow<Query<T>>.mapToOneOrNullOnIO(): Flow<T?> = mapToOneOrNull(Dispatchers.Default)

actual fun <T : Any> Flow<Query<T>>.mapToListOnIO(): Flow<List<T>> = mapToList(Dispatchers.Default)
