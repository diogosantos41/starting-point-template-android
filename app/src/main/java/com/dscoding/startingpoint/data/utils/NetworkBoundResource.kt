package com.dscoding.startingpoint.data.utils

import com.dscoding.startingpoint.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline fromCache: () -> Flow<ResultType>,
    crossinline fromNetwork: suspend () -> RequestType,
    crossinline saveOnCache: suspend (RequestType) -> Unit,
    crossinline forceNetworkRefresh: (ResultType) -> Boolean = { true },
) = flow {
    val data = fromCache().first()

    val flow = if (forceNetworkRefresh(data)) {
        emit(Result.Loading(data))
        try {
            saveOnCache(fromNetwork())
            fromCache().map { Result.Success(it) }
        } catch (throwable: Throwable) {
            fromCache().map { Result.Error(throwable, it) }
        }
    } else {
        fromCache().map { Result.Success(it) }
    }

    emitAll(flow)
}
