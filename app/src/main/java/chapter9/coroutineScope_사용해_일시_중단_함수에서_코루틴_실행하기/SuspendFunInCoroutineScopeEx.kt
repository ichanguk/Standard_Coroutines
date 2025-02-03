package chapter9.coroutineScope_사용해_일시_중단_함수에서_코루틴_실행하기

import getElapsedTime
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val results = searchByKeyword("Keyword")
    println("[결과] ${results.toList()}")
    println(getElapsedTime(startTime))
}

suspend fun searchByKeyword(keyword: String): Array<String> = coroutineScope {
    val dbResultsDeferred = async {
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async {
        searchFromServer(keyword)
    }

    return@coroutineScope arrayOf(*dbResultsDeferred.await(),
        *serverResultsDeferred.await())
}

suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

suspend fun searchFromServer(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}