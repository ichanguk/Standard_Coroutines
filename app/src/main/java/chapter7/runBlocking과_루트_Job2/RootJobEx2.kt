package chapter7.runBlocking과_루트_Job2

import kotlinx.coroutines.CoroutineName
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
    }

    launch(CoroutineName("Coroutine2")) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            printThread("코루틴 실행")
        }
        printThread("코루틴 실행")
    }
    delay(1000L)
}

/*
[main @Coroutine2#3] 코루틴 실행
[main @Coroutine3#4] 코루틴 실행
[main @Coroutine4#5] 코루틴 실행
[main @Coroutine5#6] 코루틴 실행
 */