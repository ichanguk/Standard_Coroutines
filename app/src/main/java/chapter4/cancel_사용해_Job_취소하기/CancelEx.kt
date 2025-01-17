package chapter4.cancel_사용해_Job_취소하기

import getElapsedTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 반복횟수 $repeatTime")
        }
    }
    delay(3500L)
    longJob.cancel()
}

/*
[지난 시간: 1071ms] 반복횟수 0
[지난 시간: 2082ms] 반복횟수 1
[지난 시간: 3093ms] 반복횟수 2
 */