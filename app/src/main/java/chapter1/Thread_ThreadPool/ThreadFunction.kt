package chapter1.Thread_ThreadPool

import kotlin.concurrent.thread

fun main() {
    println("[${Thread.currentThread().name}] 메인 스레드 시작")
    thread(isDaemon = false) {
        println("[${Thread.currentThread().name}] 새로운 스레드 시작")
        Thread.sleep(2000L) // 2초 동안 대기
        println("[${Thread.currentThread().name}] 새로운 스레드 종료")
    }
    Thread.sleep(1000L) // 1초 동안 대기
    println("[${Thread.currentThread().name}] 메인 스레드 종료")
}
/*
// 결과:
[main] 메인 스레드 시작
[Thread-0] 새로운 스레드 시작
[main] 메인 스레드 종료
[Thread-0] 새로운 스레드 종료

Process finished with exit code 0

thread 함수를 사용하면 새로운 스레드에서 실행돼야 하는 작업이 있을 때마다 Thread 클래스를 상속받을 필요가 없다.
default로 데몬 스레드가 만들어짐
*/