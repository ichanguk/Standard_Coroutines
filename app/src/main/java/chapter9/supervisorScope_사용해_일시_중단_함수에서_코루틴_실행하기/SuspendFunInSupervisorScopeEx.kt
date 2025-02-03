package chapter9.supervisorScope_사용해_일시_중단_함수에서_코루틴_실행하기

import chapter9.coroutineScope_사용해_일시_중단_함수에서_코루틴_실행하기.searchFromDB
import chapter9.coroutineScope_사용해_일시_중단_함수에서_코루틴_실행하기.searchFromServer
import getElapsedTime
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val results = searchByKeyword("Keyword")
    println("[결과] ${results.toList()}")
    println(getElapsedTime(startTime))
}

suspend fun searchByKeyword(keyword: String): Array<String> = supervisorScope {
    val dbResultsDeferred = async {
        throw Exception("dbResultsDeferred에서 예외가 발생했습니다")
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async {
        searchFromServer(keyword)
    }

    val dbResults = try {
        dbResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    val serverResults = try {
        serverResultsDeferred.await()
    } catch (e: Exception) {
        arrayOf()
    }

    return@supervisorScope arrayOf(*dbResults, *serverResults)
}
