package chapter9.일시_중단_함수를_별도의_코루틴상에서_실행하기

import chapter9.일시_중단_함수란_무엇인가.delayAndPrintHelloWorld
import getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    launch {
        delayAndPrintHelloWorld()
    }
    launch {
        delayAndPrintHelloWorld()
    }
    println(getElapsedTime(startTime))
}