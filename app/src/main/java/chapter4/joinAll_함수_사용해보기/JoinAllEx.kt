package chapter4.joinAll_함수_사용해보기

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val convertImageJob1: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L) // 이미지 변환 작업 실행 시간
        println("[${Thread.currentThread().name}] 이미지1 변환 완료 ${System.currentTimeMillis() - startTime}")
    }

    val convertImageJob2: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L) // 이미지 변환 작업 실행 시간
        println("[${Thread.currentThread().name}] 이미지2 변환 완료 ${System.currentTimeMillis() - startTime}")
    }

    joinAll(convertImageJob1, convertImageJob2) // 이미지1과 이미지2가 변환될 때까지 대기

    val uploadImageJob: Job = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 이미지1, 2 업로드 ${System.currentTimeMillis() - startTime}")
    }
}

/*

- sleep을 사용한 경우(코루틴2가 worker-1 스레드까지 블로킹해서 worker-2에서 코루틴3 실행)
[DefaultDispatcher-worker-1 @coroutine#2] 이미지1 변환 완료 1060
[DefaultDispatcher-worker-2 @coroutine#3] 이미지2 변환 완료 1076
[DefaultDispatcher-worker-2 @coroutine#4] 이미지1, 2 업로드 1081

- delay를 사용한 경우(코루틴2 delay 중에 코루틴3가 worker-1 사용가능)
[DefaultDispatcher-worker-1 @coroutine#2] 이미지1 변환 완료 1058
[DefaultDispatcher-worker-1 @coroutine#3] 이미지2 변환 완료 1070
[DefaultDispatcher-worker-1 @coroutine#4] 이미지1, 2 업로드 1076
 */