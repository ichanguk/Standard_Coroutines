package chapter6.구성_요소의_key_프로퍼티를_사용해_구성_요소에_접근하기

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalStdlibApi::class)
fun main() = runBlocking<Unit> {
    var coroutineName: CoroutineName = CoroutineName("MyCoroutine")

    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    var coroutineContext: CoroutineContext = coroutineName + dispatcher

    println(coroutineContext[CoroutineName])
    println(coroutineContext[CoroutineDispatcher.Key])

    println(coroutineName.key === CoroutineName.Key)
}

/*
CoroutineName(MyCoroutine)
Dispatchers.IO
true
 */