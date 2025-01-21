package chapter7.runBlocking과_루트_Job

import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    printThread("코루틴 실행")
}

/*
[main @coroutine#1] 코루틴 실행
 */