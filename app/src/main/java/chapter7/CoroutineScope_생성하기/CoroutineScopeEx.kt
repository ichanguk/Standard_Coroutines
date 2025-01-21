package chapter7.CoroutineScope_생성하기

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import printThread
import kotlin.coroutines.CoroutineContext

class CustomCoroutineScope : CoroutineScope {
    override val coroutineContext: CoroutineContext =
        Job() + newSingleThreadContext("CustomScopeThread")
}

fun main() {
    val coroutineScope = CustomCoroutineScope()

    coroutineScope.launch {
        delay(100L)
        printThread("코루틴 실행 완료")
    }
    Thread.sleep(1000L)
}

/*
[CustomScopeThread @coroutine#1] 코루틴 실행 완료
 */