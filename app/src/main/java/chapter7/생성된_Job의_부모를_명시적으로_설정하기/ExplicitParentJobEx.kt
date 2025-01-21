package chapter7.생성된_Job의_부모를_명시적으로_설정하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val newJob = Job()
        launch(CoroutineName("Coroutine2") + newJob) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
    delay(1000L)
}