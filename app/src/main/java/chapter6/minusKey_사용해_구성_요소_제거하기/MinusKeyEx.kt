package chapter6.minusKey_사용해_구성_요소_제거하기

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

    println(deletedCoroutineContext[CoroutineName])
    println(deletedCoroutineContext[CoroutineDispatcher])
    println(deletedCoroutineContext[Job])

}

/*
null
Dispatchers.IO
JobImpl{Active}@60215eee
 */