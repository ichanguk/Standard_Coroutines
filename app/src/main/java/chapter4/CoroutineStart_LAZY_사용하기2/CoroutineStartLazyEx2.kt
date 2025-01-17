package chapter4.CoroutineStart_LAZY_사용하기2

import getElapsedTime
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${Thread.currentThread().name}] [${getElapsedTime(startTime)}] 지연 실행")
    }
    delay(1000L)
    lazyJob.start()
}

/*
[main @coroutine#2] [지난 시간: 69ms] 지연 실행
 */