package chapter9.일시_중단_함수란_무엇인가

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delayAndPrintHelloWorld()
    delayAndPrintHelloWorld()
}

suspend fun delayAndPrintHelloWorld() {
    delay(1000L)
    println("Hello World")
}