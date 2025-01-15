package chapter4.실행_중_상태의_코루틴

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printJobState

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(1000L)
    }

    printJobState(job)
}