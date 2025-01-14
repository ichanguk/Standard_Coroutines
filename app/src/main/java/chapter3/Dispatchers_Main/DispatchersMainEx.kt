package chapter3.Dispatchers_Main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Main) {
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }
}

/*
    JVM 환경에서 그냥 실행하면 오류남
 */