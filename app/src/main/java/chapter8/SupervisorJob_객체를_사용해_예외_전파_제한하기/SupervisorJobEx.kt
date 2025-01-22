package chapter8.SupervisorJob_객체를_사용해_예외_전파_제한하기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    val supervisorJob = SupervisorJob()
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
    delay(1000L)
}

/*
Exception in thread "main @Coroutine1#2" java.lang.Exception: 예외 발생
	at chapter8.SupervisorJob_객체를_사용해_예외_전파_제한하기.SupervisorJobExKt$main$1$1$1.invokeSuspend(SupervisorJobEx.kt:14)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.SupervisorJob_객체를_사용해_예외_전파_제한하기.SupervisorJobExKt.main(SupervisorJobEx.kt:10)
	at chapter8.SupervisorJob_객체를_사용해_예외_전파_제한하기.SupervisorJobExKt.main(SupervisorJobEx.kt)
	Suppressed: kotlinx.coroutines.internal.DiagnosticCoroutineContextException: [CoroutineName(Coroutine1), CoroutineId(2), "Coroutine1#2":StandaloneCoroutine{Cancelling}@4b4523f8, BlockingEventLoop@731a74c]
[main @Coroutine2#3] 코루틴 실행
 */