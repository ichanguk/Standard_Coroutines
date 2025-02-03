package chapter10.delay_일시_중단_함수를_통해_알아보는_스레드_양보

import getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    repeat(10) { repeatTime ->
        launch {
            //Thread.sleep(1000L)
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 코루틴$repeatTime 실행 완료")
        }
    }
}

/*

delay 결과
[지난 시간: 1072ms] 코루틴0 실행 완료
[지난 시간: 1079ms] 코루틴1 실행 완료
[지난 시간: 1079ms] 코루틴2 실행 완료
[지난 시간: 1079ms] 코루틴3 실행 완료
[지난 시간: 1080ms] 코루틴4 실행 완료
[지난 시간: 1080ms] 코루틴5 실행 완료
[지난 시간: 1080ms] 코루틴6 실행 완료
[지난 시간: 1080ms] 코루틴7 실행 완료
[지난 시간: 1080ms] 코루틴8 실행 완료
[지난 시간: 1080ms] 코루틴9 실행 완료

sleep 결과
[지난 시간: 1044ms] 코루틴0 실행 완료
[지난 시간: 2053ms] 코루틴1 실행 완료
[지난 시간: 3068ms] 코루틴2 실행 완료
[지난 시간: 4070ms] 코루틴3 실행 완료
[지난 시간: 5071ms] 코루틴4 실행 완료
[지난 시간: 6075ms] 코루틴5 실행 완료
[지난 시간: 7086ms] 코루틴6 실행 완료
[지난 시간: 8091ms] 코루틴7 실행 완료
[지난 시간: 9096ms] 코루틴8 실행 완료
[지난 시간: 10098ms] 코루틴9 실행 완료
 */