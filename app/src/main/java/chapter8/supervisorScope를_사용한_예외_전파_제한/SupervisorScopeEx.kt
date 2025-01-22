package chapter8.supervisorScope를_사용한_예외_전파_제한

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import printThread

fun main() = runBlocking<Unit> {
    supervisorScope {
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
}

/*
Exception in thread "main @Coroutine1#2" java.lang.Exception: 예외 발생
	at chapter8.supervisorScope를_사용한_예외_전파_제한.SupervisorScopeExKt$main$1$1$1$1.invokeSuspend(SupervisorScopeEx.kt:15)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.supervisorScope를_사용한_예외_전파_제한.SupervisorScopeExKt.main(SupervisorScopeEx.kt:11)
	at chapter8.supervisorScope를_사용한_예외_전파_제한.SupervisorScopeExKt.main(SupervisorScopeEx.kt)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Coroutine1), CoroutineId(2), "Coroutine1#2":StandaloneCoroutine{Cancelling}@6325a3ee, BlockingEventLoop@1d16f93d]
[main @Coroutine2#3] 코루틴 실행
 */