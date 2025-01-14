package chapter3.단일_스레드_디스패처

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val dispatcher = newSingleThreadContext(name = "SingleThread")
    launch(context = dispatcher) {
        println("[${Thread.currentThread().name}] 실행")
    }
}

/*
[SingleThread @coroutine#2] 실행
 */