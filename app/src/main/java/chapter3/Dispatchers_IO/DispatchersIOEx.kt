package chapter3.Dispatchers_IO

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 코루틴 실행")
    launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
}

/*
[DefaultDispatcher-worker-1 @coroutine#2] 코루틴 실행
 */