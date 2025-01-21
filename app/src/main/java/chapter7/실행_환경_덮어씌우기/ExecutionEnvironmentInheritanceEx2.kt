package chapter7.실행_환경_덮어씌우기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val coroutineContext = newSingleThreadContext("MyThread") + CoroutineName("ParentCoroutine")
    launch(coroutineContext) {
        printThread("부모 코루틴 실행")
        launch(CoroutineName("ChildCoroutine")) {
            printThread("자식 코루틴 실행")
        }
    }
}

/*
[MyThread @ParentCoroutine#2] 부모 코루틴 실행
[MyThread @ChildCoroutine#3] 자식 코루틴 실행
 */