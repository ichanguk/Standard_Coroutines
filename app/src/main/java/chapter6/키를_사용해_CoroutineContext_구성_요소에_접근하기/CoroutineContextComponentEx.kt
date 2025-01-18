package chapter6.키를_사용해_CoroutineContext_구성_요소에_접근하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineContext = CoroutineName("MyCoroutine") + Dispatchers.IO

    val nameFromContext = coroutineContext[CoroutineName.Key]
    println(nameFromContext)
}

/*
CoroutineName(MyCoroutine)

 */