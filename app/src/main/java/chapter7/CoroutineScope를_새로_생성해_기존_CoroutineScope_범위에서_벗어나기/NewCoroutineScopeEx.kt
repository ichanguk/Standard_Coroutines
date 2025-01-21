package chapter7.CoroutineScope를_새로_생성해_기존_CoroutineScope_범위에서_벗어나기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            printThread("코루틴 실행")
        }
        CoroutineScope(Dispatchers.IO).launch(CoroutineName("Coroutine4")) {
            printThread("코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2")) {
        printThread("코루틴 실행")
    }
}

/*
[DefaultDispatcher-worker-2 @Coroutine4#5] 코루틴 실행
[main @Coroutine2#3] 코루틴 실행
[main @Coroutine3#4] 코루틴 실행
 */