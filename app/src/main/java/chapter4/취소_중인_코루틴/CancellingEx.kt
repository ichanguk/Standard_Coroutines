package chapter4.취소_중인_코루틴

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printJobState

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {

        }
    }

    whileJob.cancel()
    printJobState(whileJob)
}

/*
Job State
isActive >> false
isCancelled >> true
isCompleted >> false
 */