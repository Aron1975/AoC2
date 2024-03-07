import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2_2023Test {

    val day2 = Day2_2023()
    val testData = listOf<String>(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    )

    @Test
    fun getSumOfPossibleGameIDsTest() {
        assert(day2.getSumOfPossibleGameIDs(testData).equals(8))
        assertNotEquals(day2.getSumOfPossibleGameIDs(testData),11)
    }

    @Test
    fun getSumOfPowersOfFewestPossibleCubesTest() {
        assert(day2.getSumOfPowersOfFewestPossibleCubes(testData).equals(2286))
        assertNotEquals(day2.getSumOfPowersOfFewestPossibleCubes(testData),2211)
    }
}