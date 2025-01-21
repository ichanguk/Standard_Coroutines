package chapter7.취소의_전파

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val parentJob = launch(Dispatchers.IO) {
        val dbResultDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            async {
                delay(1000L)
                println("${it}으로부터 데이터를 가져오는데 성공했습니다")
                return@async "[${it}]data"
            }
        }
        val dbResults: List<String> = dbResultDeferred.awaitAll()

        println(dbResults)
    }
    parentJob.cancel()
}

/*
취소되서 결과 출력 x
 */