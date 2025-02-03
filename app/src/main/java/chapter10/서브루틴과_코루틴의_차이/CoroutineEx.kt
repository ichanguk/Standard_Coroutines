package chapter10.서브루틴과_코루틴의_차이

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    launch {
        while (true) {
            println("자식 코루틴에서 작업 실행 중")
            yield()
        }
    }

    while (true) {
        println("부모 코루틴에서 작업 실행 중")
        yield()
    }
}
