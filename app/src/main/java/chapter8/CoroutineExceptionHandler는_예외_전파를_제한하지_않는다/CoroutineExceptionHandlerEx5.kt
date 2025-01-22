package chapter8.CoroutineExceptionHandler는_예외_전파를_제한하지_않는다

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("[예외 로깅] $throwable")
    }

    launch(CoroutineName("Coroutine1") + exceptionHandler) {
        throw Exception("Coroutine1에 예외가 발생했습니다")
    }
}

/*
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.CoroutineExceptionHandler는_예외_전파를_제한하지_않는다.CoroutineExceptionHandlerEx5Kt$main$1$1.invokeSuspend(CoroutineExceptionHandlerEx5.kt:14)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.CoroutineExceptionHandler는_예외_전파를_제한하지_않는다.CoroutineExceptionHandlerEx5Kt.main(CoroutineExceptionHandlerEx5.kt:8)
	at chapter8.CoroutineExceptionHandler는_예외_전파를_제한하지_않는다.CoroutineExceptionHandlerEx5Kt.main(CoroutineExceptionHandlerEx5.kt)
 */