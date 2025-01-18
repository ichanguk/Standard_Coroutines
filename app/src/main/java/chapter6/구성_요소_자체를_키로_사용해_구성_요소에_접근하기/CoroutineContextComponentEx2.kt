package chapter6.구성_요소_자체를_키로_사용해_구성_요소에_접근하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val coroutineContext = CoroutineName("MyCoroutine") + Dispatchers.IO

    val nameFromContext = coroutineContext[CoroutineName]
    println(nameFromContext)
}

/*
CoroutineName(MyCoroutine)

 */