package chapter7.CoroutineScope로부터_실행_환경_상속받기

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {
    val newScope = CoroutineScope(CoroutineName("MyCoroutine") + Dispatchers.IO)

    newScope.launch(CoroutineName("LaunchCoroutine")) {
        this.coroutineContext
        this.launch {
            println("a")
        }
    }

    Thread.sleep(1000L)
}