import java.io.File

class Day1_2023 {

    val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_1_2023.txt").readLines()


 fun getSumOfCodes(list: List<String>) = list.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
         .map { s -> (s.first() + s.takeLast(1)).toInt() }.sum()

    fun findDigits(s: String): Int {
        val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var firstDigit = s.find {it.isDigit() }.toString()
        var lastDigit = s.findLast {it.isDigit() }.toString()
        var lowestIndex = s.length
        var highestIndex = 0
        if(firstDigit != "null") lowestIndex = s.indexOf(firstDigit)
        if(lastDigit != "null") highestIndex = s.lastIndexOf(lastDigit)

        for (i in 0..numbers.size - 1) {
            if (s.indexOf(numbers[i]) != -1 && s.indexOf(numbers[i]) < lowestIndex) {
                lowestIndex = s.indexOf(numbers[i])
                firstDigit = Integer.toString(i+1)
            }
            if (s.lastIndexOf(numbers[i]) != -1 && s.lastIndexOf(numbers[i]) > highestIndex) {
                highestIndex = s.lastIndexOf(numbers[i])
                lastDigit = Integer.toString(i+1)
            }
        }
        return (firstDigit+lastDigit).toInt()
    }

    fun getSumOfCodesB(list: List<String>):Int{

        return list.map{s->findDigits(s)}.sum()
    }

}

fun main() {

    val day1 = Day1_2023()

    val resA = day1.getSumOfCodes(day1.data)

    println("Summan av kardemumman är:  $resA")

    val resB = day1.getSumOfCodesB(day1.data)

    println("Summan B:  $resB")

    //Test data
    val data1 = "1abc2"
    val data2 = "pqr3stu8vwx"
    val data3 = "a1b2c3d4e5f"
    val data4 = "treb7uchet"
    val testData0 = listOf(data1, data2, data3, data4)

    val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_1_2023.txt").readLines()


// ------------------------------ 1a ---------------------------------------
    val nyDataList = testData0.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
    val dataIntList = nyDataList.map { s -> (s.first() + s.takeLast(1)).toInt() }
    println("Nummer: $dataIntList")
    println("Summa: " + dataIntList.sum())

    println("All together") //Ihopdraget på en rad
    println(data.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
        .map { s -> (s.first() + s.takeLast(1)).toInt() }.sum())


    //---------- Första försöket på 1b ---------

    val testData1 = "two1nine"
    val testData2 = "eightwothree"
    val testData3 = "abcone2threexyz"
    val testData4 = "4nineeightseven2"
    val testData5 = "zoneight234"
    val testData6 = "oneonetwo24eightwooneight"
    val testData7 = "5stkpqcjhxvmrn"
    val testData8 = "threeightwon1eight"

    val testData = listOf(testData1, testData2, testData3, testData7, testData4, testData5, testData6, testData8 )
/*
    println("Nya Listan")

    fun findFirstAndLastDigitOfLetters(s: String): MutableList<String> {
        val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var lowestIndex = s.length
        var highestIndex = 0
        var stringListToReturn = mutableListOf("", "", "", "")
        for (i in 0..numbers.size - 1) {
            if (s.indexOf(numbers[i]) != -1 && s.indexOf(numbers[i]) < lowestIndex) {
                lowestIndex = s.indexOf(numbers[i])
                // stringListToReturn.add(0, numbers[i])
                stringListToReturn[0] = numbers[i]
                stringListToReturn[1] = Integer.toString(i+1)
                // add(index, element)
            }
            if (s.lastIndexOf(numbers[i]) != -1 && s.lastIndexOf(numbers[i]) > highestIndex) {
                highestIndex = s.lastIndexOf(numbers[i])
                // stringListToReturn.add(1, numbers[i])
                stringListToReturn[2] = numbers[i]
                stringListToReturn[3] = Integer.toString(i+1)

                // add(index, element)
            }
        }
        return stringListToReturn
    }
    println(findFirstAndLastDigitOfLetters("threeightwon1oneighton"))

    val dataLettersReplaced = testData.map { s ->
        s.replace("one", "1")
            .replace("two", "2")
            .replace("three", "3")
            .replace("four", "4")
            .replace("five", "5")
            .replace("six", "6")
            .replace("seven", "7")
            .replace("eight", "8")
            .replace("nine", "9")
    }

    val dataLettersReplacedNew = data.map { s -> s.replace(findFirstAndLastDigitOfLetters(s)[0], findFirstAndLastDigitOfLetters(s)[1])
        .replace(findFirstAndLastDigitOfLetters(s)[2], findFirstAndLastDigitOfLetters(s)[3])}


    val nyDataList2 = dataLettersReplacedNew.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
    val dataIntList3 = nyDataList2.map { s -> (s.first() + s.takeLast(1)).toInt() }

    dataIntList3.forEach { s -> println(s) }
    println(dataIntList3.sum())

    println("okk")
    println(nyDataList2.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
        .map { s -> (s.first() + s.takeLast(1)).toInt() }.sum())

    println("Nu då")
    println(dataLettersReplacedNew.map { s -> s.trimStart { it.isLetter() }.trimEnd { it.isLetter() } }
        .map { s -> (s.first() + s.takeLast(1)).toInt() }.sum())

    println(data)
    println(dataLettersReplacedNew)
    dataIntList3.forEach{s-> }
    println(dataIntList3)
    println(dataIntList3.sum())
*/
    println("............")

    //------------------------------ 1b -----------------------------

    fun findDigits(s: String): Int {
        val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var firstDigit = s.find {it.isDigit() }.toString()
        var lastDigit = s.findLast {it.isDigit() }.toString()
        var lowestIndex = s.length
        var highestIndex = 0
        if(firstDigit != "null") lowestIndex = s.indexOf(firstDigit)
        if(lastDigit != "null") highestIndex = s.lastIndexOf(lastDigit)

        for (i in 0..numbers.size - 1) {
            if (s.indexOf(numbers[i]) != -1 && s.indexOf(numbers[i]) < lowestIndex) {
                lowestIndex = s.indexOf(numbers[i])
                firstDigit = Integer.toString(i+1)
            }
            if (s.lastIndexOf(numbers[i]) != -1 && s.lastIndexOf(numbers[i]) > highestIndex) {
                highestIndex = s.lastIndexOf(numbers[i])
                lastDigit = Integer.toString(i+1)
            }
        }
        return (firstDigit+lastDigit).toInt()
    }

    val digitList = data.map{s->findDigits(s)}
    println("Nummer lista: $digitList")
    println("Summan: " + digitList.sum())

}