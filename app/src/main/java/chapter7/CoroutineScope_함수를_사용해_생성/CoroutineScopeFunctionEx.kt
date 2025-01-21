package chapter7.CoroutineScope_함수를_사용해_생성

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import printThread

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        delay(100L)
        printThread("코루틴 실행 완료")
    }
    Thread.sleep(1000L)
}

/*
[DefaultDispatcher-worker-1 @coroutine#1] 코루틴 실행 완료
 */