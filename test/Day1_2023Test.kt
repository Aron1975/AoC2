import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2023Test {

    //Test Data a
    val data1 = "1abc2"
    val data2 = "pqr3stu8vwx"
    val data3 = "a1b2c3d4e5f"
    val data4 = "treb7uchet"
    val testData = listOf(data1, data2, data3, data4)

    @Test
    fun getSumOfCodesTest_a() {
        val day1 = Day1_2023()
        assert( day1.getSumOfCodes(testData).equals(142))
        assertNotEquals(day1.getSumOfCodes(testData),14)
    }

    @Test
    fun getSumOfCodesTest_a_Efter() {
        val day1 = Day1_2023_Efter()
        assert( day1.getSumOfCodes(testData).equals(142))
        assertNotEquals(day1.getSumOfCodes(testData),14)
    }

    //Test Data b
    val testData1 = "two1nine"
    val testData2 = "eightwothree"
    val testData3 = "abcone2threexyz"
    val testData4 = "xtwone3four"
    val testData5 = "4nineeightseven2"
    val testData6 = "zoneight234"
    val testData7 = "7pqrstsixteen"

    val testDataB = listOf(testData1, testData2, testData3, testData4, testData5, testData6, testData7)

    @Test
    fun getSumOfCodesTest_b() {
        val day1 = Day1_2023()
        assert( day1.getSumOfCodesB(testDataB).equals(281))
        assertNotEquals(day1.getSumOfCodesB(testDataB),14)
    }

}