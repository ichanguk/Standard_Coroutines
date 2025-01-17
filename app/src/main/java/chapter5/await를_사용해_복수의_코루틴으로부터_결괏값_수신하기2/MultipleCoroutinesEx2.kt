package chapter5.await를_사용해_복수의_코루틴으로부터_결괏값_수신하기2

import getElapsedTime
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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

    val participants1 = participantDeferred1.await()
    val participants2 = participantDeferred2.await()

    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participants1, *participants2)} ")

}

/*
[지난 시간: 1081ms] 참여자 목록: [James, Jason, Jenny]
 */