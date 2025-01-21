package chapter7.CoroutineScope_취소하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            printThread("코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            printThread("코루틴 실행")
        }
        this.cancel()
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        printThread("코루틴 실행")
    }
}

/*
[main @Coroutine2#3] 코루틴 실행
 */