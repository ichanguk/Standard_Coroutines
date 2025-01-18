package chapter6.minusKey_함수_사용_시_주의할_점

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    val coroutineName = CoroutineName("MyCoroutine")
    val dispatcher = Dispatchers.IO
    val myJob = Job()
    val coroutineContext = coroutineName + dispatcher + myJob

    val deletedCoroutineContext = coroutineContext.minusKey(CoroutineName)

    println(coroutineContext[CoroutineName])
    println(coroutineContext[CoroutineDispatcher])
    println(coroutineContext[Job])
    println()

    println(deletedCoroutineContext[CoroutineName])
    println(deletedCoroutineContext[CoroutineDispatcher])
    println(deletedCoroutineContext[Job])

}

/*
CoroutineName(MyCoroutine)
Dispatchers.IO
JobImpl{Active}@60215eee

null
Dispatchers.IO
JobImpl{Active}@60215eee
 */