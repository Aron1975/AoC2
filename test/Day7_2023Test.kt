import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day7_2023Test {

    val day7 = Day7_2023()
    val testData = listOf("32T3K 765", "T55J5 684", "KK677 28", "KTJJT 220", "QQQJA 483")

    @Test
    fun getSumOfOrderedHandsMultipliedByBidsTest() {

        assert(day7.getSumOfOrderedHandsMultipliedByBids(testData).equals(6440))
        assertNotEquals(day7.getSumOfOrderedHandsMultipliedByBids(testData), 1234)
    }
}