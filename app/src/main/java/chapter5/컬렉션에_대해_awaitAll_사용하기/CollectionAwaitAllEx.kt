package chapter5.컬렉션에_대해_awaitAll_사용하기

import getElapsedTime
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("James", "Jason")
    }
    val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(1000L)
        return@async arrayOf("Jenny")
    }

    val results: List<Array<String>> = listOf(participantDeferred1, participantDeferred2).awaitAll()

    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])} ")

}

/*
[지난 시간: 1084ms] 참여자 목록: [James, Jason, Jenny]

 */