package chapter5.withContext의_동작_방식

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import printThread

fun main() = runBlocking<Unit> {
    printThread("runBlocking 블록 실행")
    withContext(Dispatchers.IO) {
        printThread("withContext 블록 실행")
    }
}

/*
[main @coroutine#1] runBlocking 블록 실행
[DefaultDispatcher-worker-1 @coroutine#1] withContext 블록 실행
 */