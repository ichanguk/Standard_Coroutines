package chapter3.Dispatchers_Default

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking <Unit> {
    launch(Dispatchers.Default) {
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
}

/*
[DefaultDispatcher-worker-1 @coroutine#2] 코루틴 실행
 */