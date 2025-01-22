package chapter8.withTimeOut_사용해_코루틴의_실행_시간_제한하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import printThread

fun main() = runBlocking<Unit>(CoroutineName("Parent Coroutine")) {
    launch(CoroutineName("Child Coroutine")) {
        withTimeout(1000L) {
            delay(2000L)
            printThread("코루틴 실행")
        }
    }
    delay(2000L)
    printThread("코루틴 실행")
}

/*
[main @Parent Coroutine#1] 코루틴 실행
 */