package chapter8.try_catch문을_사용해_코루틴_처리하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        try {
            throw Exception("Coroutine1에 예외가 발생했습니다")
        } catch (e: Exception) {
            println(e.message)
        }
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("Coroutine2 실행 완료")
    }
}

/*
Coroutine1에 예외가 발생했습니다
Coroutine2 실행 완료
 */