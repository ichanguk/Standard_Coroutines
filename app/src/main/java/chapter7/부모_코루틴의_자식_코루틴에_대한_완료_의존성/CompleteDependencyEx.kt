package chapter7.부모_코루틴의_자식_코루틴에_대한_완료_의존성

import getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch {
        launch {
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 자식 코루틴 실행 완료")
        }
        println("[${getElapsedTime(startTime)}] 부모 코루틴이 실행하는 마지막 코드")
    }
    parentJob.invokeOnCompletion {
        println("[${getElapsedTime(startTime)}] 부모 코루틴 실행 완료")
    }

}

/*
[지난 시간: 38ms] 부모 코루틴이 실행하는 마지막 코드
[지난 시간: 1075ms] 자식 코루틴 실행 완료
[지난 시간: 1076ms] 부모 코루틴 실행 완료
 */