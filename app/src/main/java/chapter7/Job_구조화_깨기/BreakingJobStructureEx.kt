package chapter7.Job_구조화_깨기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val newScope = CoroutineScope(Dispatchers.IO)
    newScope.launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            printThread("코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }

    newScope.launch(CoroutineName("Coroutine2")) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
    //delay(1000L)
}

/*
마지막줄에 delay가 없는 경우 runBlocking의 자식 Job이 없기 때문에 결과 없음

마지막줄에 delay가 있는 경우:
[DefaultDispatcher-worker-3 @Coroutine4#5] 코루틴 실행
[DefaultDispatcher-worker-2 @Coroutine5#6] 코루틴 실행
[DefaultDispatcher-worker-8 @Coroutine3#4] 코루틴 실행
 */