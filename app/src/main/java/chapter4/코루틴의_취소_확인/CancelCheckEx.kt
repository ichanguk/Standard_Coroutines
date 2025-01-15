package chapter4.코루틴의_취소_확인

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
        }
    }
    delay(100L)
    whileJob.cancel()
}

/*
whileJob 코루틴 블록 내부에 코루틴의 취소를 확인할 수 있는 시점이 없기 때문에 취소가 안됨.
 */