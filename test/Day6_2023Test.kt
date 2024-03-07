import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6_2023Test {

    val day6 = Day6_2023_Efter()

    val testDataTime: List<Long> = listOf(7, 15, 30)
    val testDataDist: List<Long> = listOf(9, 40, 200)

    @Test
    fun getPowerOfPosWaysToWinTest() {

        assertEquals(day6.getPowerOfPosWaysToWin(testDataTime, testDataDist), 288)
        assertNotEquals(day6.getPowerOfPosWaysToWin(testDataTime, testDataDist), 188)
    }
}