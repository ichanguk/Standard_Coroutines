package chapter5.withContext의_사용_시_주의점2

import getElapsedTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking <Unit> {
    val startTime = System.currentTimeMillis()
    val helloString = async (Dispatchers.IO) {
        delay(1000L)
        return@async "Hello"
    }

    val worldString = async (Dispatchers.IO) {
        delay(1000L)
        return@async "World"
    }

    val results = awaitAll(helloString, worldString)


    println("[${getElapsedTime(startTime)}] ${results[0]} ${results[1]}")
}

/*
[지난 시간: 1090ms] Hello World

 */