package chapter4.yield를_사용한_취소_확인

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        var i = 0
        while (true) {
            println("작업 중 $i")
            i++
            yield()
        }
    }
    delay(100L)
    whileJob.cancel()
}

/*
    delay 대신에 yield를 사용하면 작업 중이 훨씬 많이 찍힘
 */