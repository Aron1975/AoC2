import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day8_2023Test {

    val day8 = Day8_2023()

    val testData = listOf(
        "AAA = (BBB, CCC)\n",
        "    BBB = (DDD, EEE)\n",
        "    CCC = (ZZZ, GGG)\n",
        "    DDD = (DDD, DDD)\n",
        "    EEE = (EEE, EEE)\n",
        "    GGG = (GGG, GGG)\n",
        "    ZZZ = (ZZZ, ZZZ)"
    )

    val testData2 = listOf("AAA = (BBB, BBB)", "BBB = (AAA, ZZZ)", "ZZZ = (ZZZ, ZZZ)")

    val testDataDirections = "RL"

    val testDataDirections2 = "LLR"

    @Test
    fun getNrOfStepsToReachEndPointTestA() {

        assertEquals(day8.getNrOfStepsToReachEndPoint(testData, testDataDirections, "AAA", "ZZZ"), 2)
        assertNotEquals(day8.getNrOfStepsToReachEndPoint(testData, testDataDirections, "AAA", "ZZZ"), 3)
    }

    @Test
    fun getNrOfStepsToReachEndPointTestB() {

        assertEquals(day8.getNrOfStepsToReachEndPoint(testData2, testDataDirections2, "AAA", "ZZZ"), 6)
        assertNotEquals(day8.getNrOfStepsToReachEndPoint(testData2, testDataDirections2, "AAA", "ZZZ"), 2)
    }
}