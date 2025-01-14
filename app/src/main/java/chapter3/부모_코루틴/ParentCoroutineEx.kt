package chapter3.부모_코루틴

import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking <Unit> {
    val multiThreadDispatcher = newFixedThreadPoolContext(
        nThreads = 2,
        name = "MultiThread"
    )
    launch(multiThreadDispatcher) {
        println("[${Thread.currentThread().name}] 부모 코루틴 실행")
        launch {
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
        launch {
            println("[${Thread.currentThread().name}] 자식 코루틴 실행")
        }
    }
}

/*
[MultiThread-1 @coroutine#2] 부모 코루틴 실행
[MultiThread-2 @coroutine#3] 자식 코루틴 실행
[MultiThread-2 @coroutine#4] 자식 코루틴 실행
 */