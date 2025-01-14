package chapter2.launch_사용해_코루틴_추가로_실행하기

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 실행")
    launch {
        println("[${Thread.currentThread().name}] 실행")
    }
    launch {
        println("[${Thread.currentThread().name}] 실행")
    }
}

/*
// 실행 결과:
[main @coroutine#1] 실행
[main @coroutine#2] 실행
[main @coroutine#3] 실행
 */