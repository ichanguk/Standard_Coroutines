package chapter8.Job_객체를_사용해_예외_전파_제한하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking {
    launch(CoroutineName("Parent Coroutine")) {
        launch(CoroutineName("Coroutine1") + Job()) {
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
Exception in thread "main @Coroutine1#3" java.lang.Exception: 예외 발생
	at chapter8.Job_객체를_사용해_예외_전파_제한하기.LimitExceptionPropagationEx1Kt$main$1$1$1$1.invokeSuspend(LimitExceptionPropagationEx1.kt:14)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.Job_객체를_사용해_예외_전파_제한하기.LimitExceptionPropagationEx1Kt.main(LimitExceptionPropagationEx1.kt:10)
	at chapter8.Job_객체를_사용해_예외_전파_제한하기.LimitExceptionPropagationEx1Kt.main(LimitExceptionPropagationEx1.kt)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Coroutine1), CoroutineId(3), "Coroutine1#3":StandaloneCoroutine{Cancelling}@369f73a2, BlockingEventLoop@1f28c152]
[main @Coroutine2#4] 코루틴 실행
 */