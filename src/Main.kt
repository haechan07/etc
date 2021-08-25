import etc.*

fun main() {
    println("""아래 선택지의 숫자를 입력해주세요.
           |1. 소수 구하기
           |2. 랜덤뽑기
       """.trimMargin())

    when (readLine()!!.toInt()) {
        1 -> PrimeNum().main()
        2 -> RandomChooser().main()
    }
}
