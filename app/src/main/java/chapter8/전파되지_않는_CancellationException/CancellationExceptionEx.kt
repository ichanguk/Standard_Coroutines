package chapter8.전파되지_않는_CancellationException

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit>(CoroutineName("runBlocking 코루틴")) {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine2")) {
            throw CancellationException()
        }
        delay(100L)
        printThread("코루틴 실행")
    }
    delay(100L)
    printThread("코루틴 실행")

}

/*
[main @runBlocking 코루틴#1] 코루틴 실행
[main @Coroutine1#2] 코루틴 실행
 */