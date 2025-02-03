package chapter9.일시_중단_함수는_코루틴이_아니다

import chapter9.일시_중단_함수란_무엇인가.delayAndPrintHelloWorld
import getElapsedTime
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    delayAndPrintHelloWorld()
    delayAndPrintHelloWorld()
    println(getElapsedTime(startTime))
}