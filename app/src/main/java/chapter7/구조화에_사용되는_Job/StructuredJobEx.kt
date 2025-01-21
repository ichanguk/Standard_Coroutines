package chapter7.구조화에_사용되는_Job

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val parentJob = coroutineContext[Job]

    launch {
        val childJob = coroutineContext[Job]

        println("1. 부모 코루틴과 자식 코루틴의 Job은 같은가? ${parentJob === childJob}")
        println("2. 자식 코루틴의 Job이 가지고 있는 parent는 부모 코루틴의 Job인가? ${childJob?.parent === parentJob}")
        println("3. 부모 코루틴의 Job은 자식 코루틴의 Job에 대한 참조를 가지는가? ${parentJob?.children?.contains(childJob)}")
    }
}

/*
1. 부모 코루틴과 자식 코루틴의 Job은 같은가? false
2. 자식 코루틴의 Job이 가지고 있는 parent는 부모 코루틴의 Job인가? true
3. 부모 코루틴의 Job은 자식 코루틴의 Job에 대한 참조를 가지는가? true
 */