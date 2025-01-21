package chapter7.부모_코루틴의_실행_환경_상속

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("CoroutineA")
    launch(coroutineContext) {
        printThread("부모 코루틴 실행")
        launch {
            printThread("자식 코루틴 실행")
        }
    }
}

/*
[MyThread @CoroutineA#2] 부모 코루틴 실행
[MyThread @CoroutineA#3] 자식 코루틴 실행
 */