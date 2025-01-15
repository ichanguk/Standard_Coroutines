package chapter4.CoroutineStart_LAZY_사용해_코루틴_지연_시작하기

import chapter1.Thread_ThreadPool.getElapsedTime
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${getElapsedTime(startTime)}] 지연 실행")
    }
}

/*
lazyJob에 별도 실행요청이 없어서 아무 로그도 안뜸
그리고 runBlocking은 모든 사용자 정의 코루틴이 실행돼야 종료되기 때문에 프로그램이 종료되지 않음.
 */