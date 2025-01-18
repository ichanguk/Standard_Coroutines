package chapter6.CoroutineContext_구성

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import printThread
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val coroutineContext: CoroutineContext = newSingleThreadContext("My Thread") +
            CoroutineName("MyCoroutine")

    launch(context = coroutineContext) {
        printThread("실행")
    }
}

/*
[My Thread @MyCoroutine#2] 실행
 */