package chapter6.CoroutineContext_구성_요소_덮어씌우기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import printThread
import kotlin.coroutines.CoroutineContext

fun main() = runBlocking<Unit> {
    val coroutineContext: CoroutineContext = newSingleThreadContext("My Thread") +
            CoroutineName("MyCoroutine")

    val newCoroutineContext: CoroutineContext = coroutineContext + CoroutineName("NewCoroutine")

    launch(context = newCoroutineContext) {
        printThread("실행")
    }
}

/*
[My Thread @NewCoroutine#2] 실행
 */