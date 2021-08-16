import kotlin.math.*

fun main() {
    val input = readLine()!!.toDouble()
    val limit = ceil(sqrt(input)).toInt()
    val limitPrime = MutableList(limit) { true }
    val prime = MutableList(input.toInt() + 1) { true }
    limitPrime[0] = false
    limitPrime[1] = false
    prime[0] = false
    prime[1] = false
    for (i in 2 until limit) {
        when (limitPrime[i]) {
            true -> {
                for (j in i + 1 until limit) {
                    when (j % i) {
                        0 -> limitPrime[j] = false
                        else -> continue
                    }
                }
            }
            false -> continue
        }
    }
    for (i in 2 until limit) {
        for (j in 2..input.toInt()) {
            if (limitPrime[i]) {
                if (i != j) {
                    if (j % i == 0) {
                        prime[j] = false
                    }
                }
            }
        }
    }
    prime.forEachIndexed { i, b -> if (b) { println(i) } }
}