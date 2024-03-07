class Day6_2023_Efter {

    //Lagt till data listor och getPowerOfPosWaysToWin(...) funktion med lambda uträkning för alla race

    val dataTime: List<Long> = listOf(35, 69, 68, 87)
    val dataDist: List<Long> = listOf(213,  1168,  1086, 1248)

    val dataTimeB: List<Long> = listOf(35696887)
    val dataDistB: List<Long> = listOf(213116810861248)

    fun countNrOfPossibleWaysToWinRace(maxTime: Long, recordDistance: Long): Long {
        var time = 0
        var sträcka: Long = 0
        while (sträcka <= recordDistance) {
            sträcka = time*(maxTime - time)
            time++
        }
        time--
        val nrOfPossibleWays = maxTime+1-2*time
        return nrOfPossibleWays
    }

    fun getPowerOfPosWaysToWin(list1:List<Long>, list2: List<Long>):Long{

        return list1.zip(list2) {i,v -> countNrOfPossibleWaysToWinRace(i,v)}.reduce { accumulator, element ->
            accumulator * element}
    }
}

fun main() {

    val day6 = Day6_2023_Efter()

    val res = day6.getPowerOfPosWaysToWin(day6.dataTime, day6.dataDist)

    println("Produkten av möjliga sätt att vinna:  $res")

    val resB = day6.getPowerOfPosWaysToWin(day6.dataTimeB, day6.dataDistB)

    println("Produkten av möjliga sätt att vinna:  $resB")

}