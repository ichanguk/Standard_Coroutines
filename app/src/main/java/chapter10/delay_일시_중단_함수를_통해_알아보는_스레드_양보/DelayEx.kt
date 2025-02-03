package chapter10.delay_일시_중단_함수를_통해_알아보는_스레드_양보

import getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    launch {
        delay(1000L)
        println("[${getElapsedTime(startTime)}] 코루틴 실행 완료")
    }
}