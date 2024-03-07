class Day6_2023 {

    fun countNrOfPossibleWaysToWinRace(maxTime: Long, recordDistance: Long): Long {
        var time = 0
        var sträcka: Long = 0
        while (sträcka < recordDistance) {
            sträcka = time*(maxTime - time)
            time++
        }
        time--
        val nrOfPossibleWays = maxTime+1-2*time
        return nrOfPossibleWays
    }
}

fun main() {

    val task = Day6_2023()
    val race1 = task.countNrOfPossibleWaysToWinRace(35,213)
    val race2 = task.countNrOfPossibleWaysToWinRace(69,1168)
    val race3 = task.countNrOfPossibleWaysToWinRace(68,1086)
    val race4 = task.countNrOfPossibleWaysToWinRace(87,1248)

    println(race1*race2*race3*race4)

    val lastRace = task.countNrOfPossibleWaysToWinRace(35696887,213116810861248)
    println("Last Race: $lastRace")
}