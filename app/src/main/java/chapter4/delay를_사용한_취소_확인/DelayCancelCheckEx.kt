package chapter4.delay를_사용한_취소_확인

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        var i = 0
        while (true) {
            println("작업 중 $i")
            i++
            delay(1L)
        }
    }
    delay(100L)
    whileJob.cancel()
}

/*
100ms 뒤 whileJob 취소됨
하지만 delay(1L)로 인해 작업 중이 몇 번 안찍힘
 */