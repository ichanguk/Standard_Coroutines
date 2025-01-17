package chapter5.awaitAll을_사용한_결괏값_수신

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

    val results: List<Array<String>> = awaitAll(participantDeferred1, participantDeferred2)

    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*results[0], *results[1])} ")

}

/*
[지난 시간: 1085ms] 참여자 목록: [James, Jason, Jenny]
 */