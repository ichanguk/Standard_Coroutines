package chapter4.CoroutineScope_isActivie를_사용한_취소_확인

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        var i = 0
        while (this.isActive) {
            println("작업 중 $i")
            i++
        }
    }
    delay(100L)
    whileJob.cancel()
}

/*
코루틴이 중단될 일 없이 취소 확인 가능
 */