package etc

class RandomChooser {
    fun main() {
        val list = readLine()!!.split(" ").toMutableList() // 입력 후 뮤타블리스트화
        val num = reTry("선택할 항목의 개수를 입력해주세요. : ") // 개수 입력
        val outList = mutableListOf<String>() // 출력값 리스트
        for (i in 1..num) {
            list.shuffle() // 리스트 섞기
            outList.add(list.removeAt(0)) // 0번 인덱스 빼기
        }
        println(outList.joinToString(" ")) // 리스트 공백분리 출력
    }

    fun reTry(str : String) : Int {
        print(str)
        val output = readLine()!!.toIntOrNull()
        if (output == null) { reTry(str) }
        return output!!
    }
}