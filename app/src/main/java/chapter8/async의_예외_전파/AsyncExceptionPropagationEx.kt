package chapter8.async의_예외_전파

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import printThread

fun main() = runBlocking<Unit> {
    async(CoroutineName("Coroutine1")) {
        throw Exception("Coroutine1에 예외가 발생했습니다")
    }
    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        printThread("코루틴 실행")
    }
}

/*
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.async의_예외_전파.AsyncExceptionPropagationExKt$main$1$1.invokeSuspend(AsyncExceptionPropagationEx.kt:12)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.async의_예외_전파.AsyncExceptionPropagationExKt.main(AsyncExceptionPropagationEx.kt:10)
	at chapter8.async의_예외_전파.AsyncExceptionPropagationExKt.main(AsyncExceptionPropagationEx.kt)
 */