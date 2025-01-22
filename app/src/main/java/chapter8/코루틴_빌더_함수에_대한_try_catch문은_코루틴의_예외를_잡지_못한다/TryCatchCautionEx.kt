package chapter8.코루틴_빌더_함수에_대한_try_catch문은_코루틴의_예외를_잡지_못한다

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    try {
        launch(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1에 예외가 발생했습니다")
        }
    } catch (e: Exception) {
        println(e.message)
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("Coroutine2 실행 완료")
    }
}

/*
Exception in thread "main" java.lang.Exception: Coroutine1에 예외가 발생했습니다
	at chapter8.코루틴_빌더_함수에_대한_try_catch문은_코루틴의_예외를_잡지_못한다.TryCatchCautionExKt$main$1$1.invokeSuspend(TryCatchCautionEx.kt:11)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:108)
	at kotlinx.coroutines.EventLoopImplBase.processNextEvent(EventLoop.common.kt:280)
	at kotlinx.coroutines.BlockingCoroutine.joinBlocking(Builders.kt:85)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(Builders.kt:59)
	at kotlinx.coroutines.BuildersKt.runBlocking(Unknown Source)
	at kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(Builders.kt:38)
	at kotlinx.coroutines.BuildersKt.runBlocking$default(Unknown Source)
	at chapter8.코루틴_빌더_함수에_대한_try_catch문은_코루틴의_예외를_잡지_못한다.TryCatchCautionExKt.main(TryCatchCautionEx.kt:8)
	at chapter8.코루틴_빌더_함수에_대한_try_catch문은_코루틴의_예외를_잡지_못한다.TryCatchCautionExKt.main(TryCatchCautionEx.kt)
 */