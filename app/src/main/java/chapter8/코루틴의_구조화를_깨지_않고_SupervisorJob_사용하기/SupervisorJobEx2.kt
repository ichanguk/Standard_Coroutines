package chapter8.코루틴의_구조화를_깨지_않고_SupervisorJob_사용하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val supervisorJob = SupervisorJob(parent = this.coroutineContext[Job])
    launch(CoroutineName("Coroutine1") + supervisorJob) {
        launch(CoroutineName("Coroutine3")) {
            throw Exception("예외 발생")
        }
        delay(100L)
        printThread("코루틴 실행")
    }
    launch(CoroutineName("Coroutine2") + supervisorJob) {
        delay(100L)
        printThread("코루틴 실행")
    }
    supervisorJob.complete()
}

/*
Exception in thread "main" java.lang.Exception: 예외 발생
	at chapter8.코루틴의_구조화를_깨지_않고_SupervisorJob_사용하기.SupervisorJobEx2Kt$main$1$1$1.invokeSuspend(SupervisorJobEx2.kt:15)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.코루틴의_구조화를_깨지_않고_SupervisorJob_사용하기.SupervisorJobEx2Kt.main(SupervisorJobEx2.kt:11)
	at chapter8.코루틴의_구조화를_깨지_않고_SupervisorJob_사용하기.SupervisorJobEx2Kt.main(SupervisorJobEx2.kt)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Coroutine1), StandaloneCoroutine{Cancelling}@13fee20c, BlockingEventLoop@4e04a765]
[main @Coroutine2#3] 코루틴 실행
 */