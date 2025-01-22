package chapter8.CoroutineExceptionHandler를_사용해야_하는_경우

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 로깅] $throwable")
    }

    CoroutineScope(Dispatchers.IO)
        .launch(CoroutineName("Coroutine1") + exceptionHandler) {
            launch(CoroutineName("Coroutine2")) {
                throw Exception("Coroutine2에 예외가 발생했습니다")
            }
            launch(CoroutineName("Coroutine3")) {
                printThread("코루틴 실행")
            }
        }
    delay(1000L)
}