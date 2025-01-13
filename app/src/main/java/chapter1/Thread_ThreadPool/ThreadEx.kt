package chapter1.Thread_ThreadPool

class ExampleThread : Thread() {
    override fun run() {
        println("[${Thread.currentThread().name}] 새로운 스레드 시작")
        Thread.sleep(2000L) // 2초 동안 대기
        println("[${Thread.currentThread().name}] 새로운 스레드 종료")
    }
}

fun main() {
    println("[${Thread.currentThread().name}] 메인 스레드 시작")
    ExampleThread().start()
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

즉 메인 스레드가 1초간 대기 후 "[main] 메인 스레드 종료"를 출력하는 작업과
Thread-0 스레드가 "[Thread-0] 새로운 스레드 시작"을 출력한 후 2초간 대기 후
"[Thread-0] 새로운 스레드 종료"를 출력하는 작업이 동시에 실행된다.
*/