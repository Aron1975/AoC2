class FirstLastNr {
}

fun main() {             //   "threeightwoneeightnine"

    fun findFirstAndLastDigitOfLetters(s: String): Int {
        val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var firstDigit = s.find {it.isDigit() }.toString()
        var lastDigit = s.findLast {it.isDigit() }.toString()
        println("1. firstDigit: $firstDigit")
        println("1. lastDigit: $lastDigit")

        var lowestIndex = s.length
        var highestIndex = 0
        if(firstDigit != "null") lowestIndex = s.indexOf(firstDigit) //println("first digit $firstDigit at index = " + s.indexOf(firstDigit))
        if(lastDigit != "null") highestIndex = s.lastIndexOf(lastDigit) // println("last digit $lastDigit at index = " + s.indexOf(lastDigit))

        println("1. lowestIndex: $lowestIndex")
        println("1. highestIndex: $highestIndex")
       // var stringListToReturn = mutableListOf("", "", "", "")
        for (i in 0..numbers.size - 1) {
            println("Nr i listan: " + numbers[i] + " Index för Nr i String: " + s.indexOf(numbers[i]))
            if (s.indexOf(numbers[i]) != -1 && s.indexOf(numbers[i]) < lowestIndex) {
                lowestIndex = s.indexOf(numbers[i])
                println("lowest index" + lowestIndex)
                firstDigit = Integer.toString(i+1)
                println("first digit: $firstDigit")
                // stringListToReturn.add(0, numbers[i])
               // stringListToReturn[0] = numbers[i]
               // stringListToReturn[1] = Integer.toString(i + 1)
                // add(index, element)
            }
            println("Nr i listan: " + numbers[i] + " Index för Nr i String: " + s.lastIndexOf(numbers[i]))
            if (s.lastIndexOf(numbers[i]) != -1 && s.lastIndexOf(numbers[i]) > highestIndex) {
                highestIndex = s.lastIndexOf(numbers[i])
                println("highest index" + highestIndex)
                lastDigit = Integer.toString(i+1)
                println("last digit: $lastDigit")
                //stringListToReturn[2] = numbers[i]
                //stringListToReturn[3] = Integer.toString(i + 1)
            }
        }
        println(firstDigit + lastDigit)
        return (firstDigit+lastDigit).toInt()
    }

    //val s = "fourte23onethreeightwon1oneightone"
    val s = "oneight"
   // val newString = s.replace(findFirstAndLastDigitOfLetters(s)[0], findFirstAndLastDigitOfLetters(s)[1])
    //    .replace(findFirstAndLastDigitOfLetters(s)[2], findFirstAndLastDigitOfLetters(s)[3])

    //println(newString)
    val reg = "[0-9]".toRegex()
    println("Firs last digit")

    val firstDigit = s.find {it.isDigit() }
    val lastDigit = s.findLast {it.isDigit() }
    if(firstDigit != null) println("first digit $firstDigit at index = " + s.indexOf(firstDigit))
    if(lastDigit != null) println("last digit $lastDigit at index = " + s.indexOf(lastDigit))
    println(s.find {it.isDigit() })
    println( s.findLast {it.isDigit() })
    //println("1: " + findFirstAndLastDigitOfLetters("threeightwoneeightnine"))
    // println("2: " + findFirstAndLastDigitOfLetters("threeightwon1eight"))
    //println("3: " + findFirstAndLastDigitOfLetters("threeightwon1eight"))
    // println("4: " + findFirstAndLastDigitOfLetters("fourte23onethreeightwon1oneightone"))

    //println("threeightwoneeightnine".lastIndexOf("eight"))

    println( findFirstAndLastDigitOfLetters("oneight"))
   // println( findFirstAndLastDigitOfLetters("fourte23onethreeightwon1oneightone"))
}