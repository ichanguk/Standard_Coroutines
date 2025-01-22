package chapter8.SupervisorJob을_CoroutineScope와_함께_사용하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val coroutineScope = CoroutineScope(SupervisorJob())
    coroutineScope.apply {
        launch(CoroutineName("Coroutine1")) {
            launch(CoroutineName("Coroutine3")) {
                throw Exception("예외 발생")
            }
            delay(100L)
            printThread("코루틴 실행")
        }

        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            printThread("코루틴 실행")
        }
    }
    delay(1000L)
}

/*
[DefaultDispatcher-worker-3 @Coroutine2#3] 코루틴 실행
Exception in thread "DefaultDispatcher-worker-1 @Coroutine1#2" java.lang.Exception: 예외 발생
	at chapter8.SupervisorJob을_CoroutineScope와_함께_사용하기.SupervisorJobCoroutineScopeExKt$main$1$1$1$1.invokeSuspend(SupervisorJobCoroutineScopeEx.kt:17)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:584)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:793)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:697)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:684)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Coroutine1), CoroutineId(2), "Coroutine1#2":StandaloneCoroutine{Cancelling}@34016b62, Dispatchers.Default]

 */
