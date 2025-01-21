package chapter7.새로운_루트_Job_에_취소_요청

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val newRootJob = Job()
    launch(CoroutineName("Coroutine1") + newRootJob) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            printThread("코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2") + newRootJob) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
    newRootJob.cancel()
    delay(1000L)
}

/*
결과없음
 */