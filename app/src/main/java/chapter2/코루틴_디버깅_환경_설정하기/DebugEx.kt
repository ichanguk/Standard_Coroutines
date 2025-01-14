package chapter2.코루틴_디버깅_환경_설정하기

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("[${Thread.currentThread().name}] 실행")
}

/*
옵션 추가 전 결과
[main] 실행

옵션 추가 후 결과
[main @coroutine#1] 실행
 */
