package etc

import kotlin.math.*

class PrimeNum {

    fun main() {
        val input = readLine()!!.toDouble() // Double로 입력
        val limit = ceil(sqrt(input)).toInt() // sqrt(input)을 올림한 값
        val limitPrime = MutableList(limit) { true } // limit 크기(인덱스 최대 limit - 1)만큼 true로 찬 리스트 생성
        val prime = MutableList(input.toInt() + 1) { true } // input + 1 크기만큼(인덱스 최대 input)
        limitPrime[0] = false
        limitPrime[1] = false // 0과 1번 인덱스를 false로 (0과 1은 소수가 아님)
        prime[0] = false
        prime[1] = false // 0과 1번 인덱스를 false로 (0과 1은 소수가 아님)
        for (i in 2 until limit) { // i = 2 ~ limit - 1
            if (limitPrime[i]) { // limitPrime[i]가 true일 경우
                for (j in i + 1 until limit) { // j = i + 1 ~ limit - 1
                    if (j % i == 0) { // j가 i의 배수일 경우
                        limitPrime[j] = false // limitPrime[j]를 false로
                    }
                }
            }
        }
        for (i in 2 until limit) { // i = 2 ~ limit - 1
            if (limitPrime[i]) { // limitPrime[i]가 true일 경우
                for (j in 2..input.toInt()) { // j = 2 ~ input
                    if (i != j) { // i == j가 아닐 경우
                        if (j % i == 0) { // j가 i의 배수일 경우
                            prime[j] = false // prime[j]를 false로
                        }
                    }
                }
            }
        }
        prime.forEachIndexed { i, b ->
            if (b) {
                println(i)
            }
        } // prime에서 true를 담은 인덱스를 출력
    }
}