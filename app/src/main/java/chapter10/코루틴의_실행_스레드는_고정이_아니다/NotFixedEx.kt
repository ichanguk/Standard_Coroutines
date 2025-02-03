package chapter10.코루틴의_실행_스레드는_고정이_아니다

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(2, "MyThread")
    launch(dispatcher) {
        repeat(5) {
            printThread("코루틴 실행이 일시 중단 됩니다")
            delay(100L)
            printThread("코루틴 실행이 재개 됩니다")
        }
    }
}

/*
[MyThread-1 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 재개 됩니다
[MyThread-2 @coroutine#2] 코루틴 실행이 일시 중단 됩니다
[MyThread-1 @coroutine#2] 코루틴 실행이 재개 됩니다
 */