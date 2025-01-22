package chapter8.코루틴_취소_시_사용되는_JobCancellationException

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val job = launch {
        delay(1000L)
    }
    job.invokeOnCompletion { exception ->
        println(exception)
    }
    job.cancel()
}

/*
kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled; job=StandaloneCoroutine{Cancelled}@3ac42916
 */