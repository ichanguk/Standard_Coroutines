package chapter4.취소_완료된_코루틴

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printJobState

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(5000L)
    }

    job.cancelAndJoin()
    printJobState(job)
}

/*
Job State
isActive >> false
isCancelled >> true
isCompleted >> true
 */