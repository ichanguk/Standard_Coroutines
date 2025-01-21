package chapter7.상속되지_않는_Job

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val runBlockingJob = coroutineContext[Job]

    launch {
        val launchJob = coroutineContext[Job]

        if (runBlockingJob === launchJob) {
            println("runBlocing으로 생성된 Job과 launch로 생성된 Job이 동일합니다")
        } else {
            println("runBlocking으로 생성된 Job과 launch로 생성된 Job이 다릅니다")
        }
    }
}

/*
runBlocking으로 생성된 Job과 launch로 생성된 Job이 다릅니다
 */