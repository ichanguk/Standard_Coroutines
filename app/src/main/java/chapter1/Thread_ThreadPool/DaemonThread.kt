package chapter1.Thread_ThreadPool

fun main() {
    println("[${Thread.currentThread().name}] 메인 스레드 시작")
    ExampleThread().apply {
        isDaemon = true
    }.start()
    Thread.sleep(1000L) // 1초 동안 대기
    println("[${Thread.currentThread().name}] 메인 스레드 종료")
}
/*
// 결과:
[main] 메인 스레드 시작
[Thread-0] 새로운 스레드 시작
[main] 메인 스레드 종료

Process finished with exit code 0 // 프로세스 정상 종료

데몬 스레드는 우선도가 낮아 사용자 스레드가 모두 종료되면 강제 종료된다.
*/
