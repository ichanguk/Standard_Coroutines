package chapter7.생성된_Job은_자동으로_실행_완료되지_않는다

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
        newJob.complete()
    }
}

/*
[main @Coroutine2#3] 코루틴 실행
 */