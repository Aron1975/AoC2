import java.io.File

class Day8_2023 {


    fun dataToMap(data: List<String>):Map<String, List<String>> {
        val dataMap = data.map {
            it.split("=")[0].trim() to listOf(
                it.split("=")[1].trim().substring(1, 4),
                it.split("=")[1].trim().substring(6, 9)
            )
        }.toMap()
        return dataMap
    }

    tailrec fun getShortestWay(
        dataMap: Map<String, List<String>>,
        directions: String,
        startString: String?,
        stopString: String,
        steps: Int,
        IndexInDirections: Int
    ): Int {
        var newIndexInDirections = IndexInDirections + 1
        if (IndexInDirections >= directions.length - 1) newIndexInDirections = 0

        var directionsAsInt = 0
        when (directions[newIndexInDirections]) {
            'L' -> directionsAsInt = 0
            'R' -> directionsAsInt = 1
        }

        var newStartString = dataMap[startString]?.get(directionsAsInt)
        if (newStartString.equals(stopString)) return steps
        else return getShortestWay(
            dataMap,
            directions,
            newStartString, //dataMap[startString]?.get(directionsAsInt),
            stopString,
            steps + 1,
            newIndexInDirections
        )

    }

    fun getNrOfStepsToReachEndPoint(data: List<String>, directions: String, startString: String?, stopString: String):Int{
        val map = dataToMap(data)
        return getShortestWay(map, directions, startString, stopString, 1, -1)
    }
}

fun main() {

    val day8 = Day8_2023()

    val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC2\\Data_AoC_8_2023").readLines()
    val directionsString =
        "LRLLRRRLRRLRRRLRLRRLLRRLRRLRRLRRRLLRRLRRLLLRRLLRRRLRRRLRRRLRLRRRLRRRLRLRLRRLRLRRRLRLRLRRRLLRRRLRLRRLLLRRRLLRRLLLRRRLRRLLRLRLRRRLRRLLRRLRRRLRRRLLRRRLLRRRLRRLRRLRLRRRLLLRRRLRRRLRLRRLRRLRRLRRLRRLRRRLRRRLRRLLRRLRRRLRLLRLLRRLLRRLRRRLRRRLRRRLRRRLRRLRRRLLRRLRRRLRRLRRRLRRLRRLRRLRRLRRLRLRRRR"

    val res = day8.getNrOfStepsToReachEndPoint(data, directionsString, "AAA", "ZZZ")

    println("Nr of steps to reach destination:  $res")

    /*
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

    println(testData.get(0).split("="))
    val splitted = testData.get(0).split("=")
    val key = splitted[0].trim()
    val values = listOf(splitted[1].trim().substring(1, 4), splitted[1].trim().substring(6, 9))

    println("key: $key  values: $values")

    val dataMap = data.map {
        it.split("=")[0].trim() to listOf(
            it.split("=")[1].trim().substring(1, 4),
            it.split("=")[1].trim().substring(6, 9)
        )
    }.toMap()

    println(dataMap)
    println(dataMap.get("AAA")?.get(1))

    tailrec fun getShortestWay(
        dataMap: Map<String, List<String>>,
        directions: String,
        startString: String?,
        stopString: String,
        steps: Int,
        IndexInDirections: Int
    ): Int {
        var newIndexInDirections = IndexInDirections + 1
        if (IndexInDirections >= directions.length - 1) newIndexInDirections = 0

        println("Steps: $steps")
        var directionsAsInt = 0
        when (directions[newIndexInDirections]) {
            'L' -> directionsAsInt = 0
            'R' -> directionsAsInt = 1
        }
        var newStartString = dataMap[startString]?.get(directionsAsInt)
        if (newStartString.equals(stopString)) return steps
        else return getShortestWay(
            dataMap,
            directions,
            dataMap[startString]?.get(directionsAsInt),
            stopString,
            steps + 1,
            newIndexInDirections
        )

    }

    println(getShortestWay(dataMap, directionsString, "AAA", "ZZZ", 1, -1))
*/
}