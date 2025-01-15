package chapter4.생성_상태의_코루틴

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printJobState

fun main() = runBlocking<Unit> {
    val job: Job = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
    }

    printJobState(job)
}

/*
Job State
isActive >> false
isCancelled >> false
isCompleted >> false
 */