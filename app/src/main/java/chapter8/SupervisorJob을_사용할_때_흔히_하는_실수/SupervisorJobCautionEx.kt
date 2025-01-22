package chapter8.SupervisorJob을_사용할_때_흔히_하는_실수

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Parent Coroutine") + SupervisorJob()) {
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
Exception in thread "main @Coroutine2#4" java.lang.Exception: 예외 발생
	at chapter8.SupervisorJob을_사용할_때_흔히_하는_실수.SupervisorJobCautionExKt$main$1$1$1$1.invokeSuspend(SupervisorJobCautionEx.kt:15)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.SupervisorJob을_사용할_때_흔히_하는_실수.SupervisorJobCautionExKt.main(SupervisorJobCautionEx.kt:11)
	at chapter8.SupervisorJob을_사용할_때_흔히_하는_실수.SupervisorJobCautionExKt.main(SupervisorJobCautionEx.kt)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Parent Coroutine), CoroutineId(2), "Parent Coroutine#2":StandaloneCoroutine{Cancelling}@3a5ed7a6, BlockingEventLoop@6325a3ee]

 */