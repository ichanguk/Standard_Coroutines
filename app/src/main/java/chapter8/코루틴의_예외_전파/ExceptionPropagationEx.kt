package chapter8.코루틴의_예외_전파

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking {
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
    delay(1000L)
}

/*
Exception in thread "main" java.lang.Exception: 예외 발생
	at chapter8.코루틴의_예외_전파.ExceptionPropagationExKt$main$1$1$1.invokeSuspend(ExceptionPropagationEx.kt:12)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.코루틴의_예외_전파.ExceptionPropagationExKt.main(ExceptionPropagationEx.kt:9)
	at chapter8.코루틴의_예외_전파.ExceptionPropagationExKt.main(ExceptionPropagationEx.kt)
 */