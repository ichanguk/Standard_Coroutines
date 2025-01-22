package chapter8.Job_객체를_사용한_예외_전파_제한의_한계

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking {
    val parentJob =  launch(CoroutineName("Parent Coroutine")) {
        launch(CoroutineName("Coroutine1") + Job()) {
            launch(CoroutineName("Coroutine3")) {
                delay(100L)
                printThread("코루틴 실행")
            }
            delay(100L)
            printThread("코루틴 실행")
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
    delay(20L)
    parentJob.cancel()
    delay(1000L)
}

/*
[main @Coroutine1#3] 코루틴 실행
[main @Coroutine3#5] 코루틴 실행
 */