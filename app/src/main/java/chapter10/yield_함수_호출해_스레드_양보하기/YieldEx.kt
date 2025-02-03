package chapter10.yield_함수_호출해_스레드_양보하기

import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    val job = launch {
        while (this.isActive) {
            println("작업 중")
            yield()
        }
    }
    delay(100L)
    job.cancel()
}

/*
yield가 없으면 runBlocking 코루틴으로 양보되지 않아 cancel이 실행안됨

yield가 있으면 100ms 후에 취소됨
 */