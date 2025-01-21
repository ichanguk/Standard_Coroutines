package chapter7.CoroutineScope에_속한_코루틴의_범위

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            printThread("코루틴 실행")
        }
        launch(CoroutineName("Coroutine4")) {
            printThread("코루틴 실행")
        }
    }

    launch(CoroutineName("Coroutine2")) {
        printThread("코루틴 실행")
    }
}

/*
[main @Coroutine2#3] 코루틴 실행
[main @Coroutine3#4] 코루틴 실행
[main @Coroutine4#5] 코루틴 실행
 */