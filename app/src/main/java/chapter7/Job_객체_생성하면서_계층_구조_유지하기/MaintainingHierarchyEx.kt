package chapter7.Job_객체_생성하면서_계층_구조_유지하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val coroutine1Job = this.coroutineContext[Job]
        val newJob = Job(parent = coroutine1Job)
        launch(CoroutineName("Coroutine2") + newJob) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
}

/*
[main @Coroutine2#3] 코루틴 실행
 */