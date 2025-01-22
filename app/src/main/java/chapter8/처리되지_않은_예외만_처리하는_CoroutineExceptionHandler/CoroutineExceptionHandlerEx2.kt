package chapter8.처리되지_않은_예외만_처리하는_CoroutineExceptionHandler

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 발생] $throwable")
    }

    CoroutineScope(Dispatchers.IO).launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine2") + exceptionHandler) {
            throw Exception("Coroutine2에 예외가 발생했습니다")
        }
    }
    delay(1000L)
}

/*
Exception in thread "DefaultDispatcher-worker-3" java.lang.Exception: Coroutine2에 예외가 발생했습니다
	at chapter8.처리되지_않은_예외만_처리하는_CoroutineExceptionHandler.CoroutineExceptionHandlerEx2Kt$main$1$1$1.invokeSuspend(CoroutineExceptionHandlerEx2.kt:18)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.internal.LimitedDispatcher$Worker.run(LimitedDispatcher.kt:115)
	at kotlinx.coroutines.scheduling.TaskImpl.run(Tasks.kt:103)
	at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:584)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:793)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:697)
	at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:684)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Coroutine1), StandaloneCoroutine{Cancelling}@34aa0e7f, Dispatchers.IO]
 */