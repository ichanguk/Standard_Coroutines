package chapter5.Deferred는_특수한_형태의_Job이다

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import printJobState

fun main() = runBlocking <Unit> {
    val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
        delay(1000L)
        return@async "Dummy Response"
    }

    networkDeferred.join()
    printJobState(networkDeferred)
}

/*
Job State
isActive >> false
isCancelled >> false
isCompleted >> true
 */