package chapter10.스레드를_양보하지_않으면_실행_스레드가_바뀌지_않는다

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val dispatcher = newFixedThreadPoolContext(2, "MyThread")
    launch(dispatcher) {
        repeat(5) {
            printThread("스레드를 점유한채로 100ms간 대기")
            Thread.sleep(1000L)
            printThread("점유한 스레드에서 마저 실행")
        }
    }
}

/*
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100ms간 대기
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100ms간 대기
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100ms간 대기
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100ms간 대기
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행
[MyThread-1 @coroutine#2] 스레드를 점유한채로 100ms간 대기
[MyThread-1 @coroutine#2] 점유한 스레드에서 마저 실행

 */