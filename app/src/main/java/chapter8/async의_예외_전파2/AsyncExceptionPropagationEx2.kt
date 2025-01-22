package chapter8.async의_예외_전파2

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import printThread

fun main() = runBlocking<Unit> {
    supervisorScope {
        async(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1에 예외가 발생했습니다")
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
}

/*
[main @Coroutine2#3] 코루틴 실행
 */
