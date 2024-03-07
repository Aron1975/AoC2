import java.io.File

class Day1_2023_Efter {

    val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_1_2023.txt").readLines()

    //A Före
    fun getSumOfCodes0(list: List<String>) = list.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
        .map { s -> (s.first() + s.takeLast(1)).toInt() }.sum()

    //A Efter ->{Todd Ginsbergs}
    fun getSumOfCodes(list: List<String>):Int = list.sumOf { s -> "${s.first { it.isDigit() }}${s.last { it.isDigit() }}".toInt() }

    //B Efter ->{ https://github.com/diegogalanti/aoc-2023/blob/main/src/Day01.kt }

    val numbersMap = mapOf("one" to 1, "1" to 1, "2" to 2, "two" to 2, "3" to 3, "three" to 3, "4" to 4, "four" to 4, "5" to 5, "five" to 5, "6" to 6, "six" to 6, "7" to 7, "seven" to 7, "8" to 8, "eight" to 8, "9" to 9, "nine" to 9)
    //
    fun getSumOfCodes_B(list: List<String>) = list.sumOf { s-> "${numbersMap[s.findAnyOf(numbersMap.keys)?.second]}${numbersMap[s.findLastAnyOf(numbersMap.keys)?.second]}".toInt() }

}

fun main() {

    val day1 = Day1_2023_Efter()
    print("A: ")
    println(day1.getSumOfCodes(day1.data))
    print("B: ")
    println(day1.getSumOfCodes_B(day1.data))

    var str = "eightni.ne"
    println("${str.findAnyOf(day1.numbersMap.keys)?.second} ${str.findLastAnyOf(day1.numbersMap.keys)?.second}")
    println("${day1.numbersMap[str.findAnyOf(day1.numbersMap.keys)?.second]} ${str.findLastAnyOf(day1.numbersMap.keys)?.second}")
}