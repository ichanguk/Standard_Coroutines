package chapter4.실행_완료_상태의_코루틴

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printJobState

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(1000L)
    }

    delay(2000L)
    printJobState(job)
}

/*
Job State
isActive >> false
isCancelled >> false
isCompleted >> true
 */