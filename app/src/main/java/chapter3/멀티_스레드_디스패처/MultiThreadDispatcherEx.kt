package chapter3.멀티_스레드_디스패처

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val multiThreadDispatcher = newFixedThreadPoolContext(
        nThreads = 2,
        name = "MultiThread"
    )
    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}

/*

일반적인 경우
[MultiThread-1 @coroutine#2] 실행
[MultiThread-2 @coroutine#3] 실행

MultiThread-1의 coroutine2가 coroutine3가 시작되기 전에 끝났을 경우
[MultiThread-1 @coroutine#2] 실행
[MultiThread-1 @coroutine#3] 실행
 */