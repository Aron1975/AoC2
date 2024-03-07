import java.io.File

class Day2_2023 {

    val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_2_2023.txt").readLines()
    val cubesInBag = listOf(12, 13, 14)

    fun getListWithMaxRGB(listOfList:List<List<String>>):List<Int>{
        var red = 0
        var green = 0
        var blue = 0

        for(list in listOfList){
            for(elements in list){
                val tempS = elements.trim().split(" ")
                when(tempS[1]){
                    "red" -> if(tempS[0].toInt() > red) red = tempS[0].toInt()
                    "green" -> if(tempS[0].toInt() > green) green = tempS[0].toInt()
                    "blue" -> if(tempS[0].toInt() > blue) blue = tempS[0].toInt()
                }
            }
        }
        return listOf(red,green,blue)
    }

    fun isLower(list1: List<Int>, list2: List<Int>) =  list1.zip(list2).all { (n1, n2) -> n1 >= n2 }

    //2023_2a
    fun getSumOfPossibleGameIDs(list: List<String>):Int{

        val dataMap = list.withIndex().associateBy ({ it.index+1 }, {it.value.substring(it.value.indexOf(":")+1).trim()})
        val dataMap2 = dataMap.mapValues { it.value.split(";").map{s->s.trim()}.map{s->s.split(",")} }
        val dataMap3 = dataMap2.mapValues { getListWithMaxRGB(it.value)}
        val result = dataMap3.map{ entry -> isLower(cubesInBag, entry.value) }
        var sum = 0
        result.forEachIndexed { index, element -> if(element) sum+=index+1}
        return sum
    }

    //2023_2b
    fun getSumOfPowersOfFewestPossibleCubes(list: List<String>):Int{

        //New map of list(data In) with set of cubes as values
        val dataMap = list.withIndex().associateBy ({ it.index+1 }, {it.value.substring(it.value.indexOf(":")+1).trim()})
        //New map derived from dataMap with same keys, but values are split around ';' and ',' so it forms lists of list of String
        val dataMap2 = dataMap.mapValues { it.value.split(";").map{s->s.trim()}.map{s->s.split(",")} }

        val dataMap3 = dataMap2.mapValues { getListWithMaxRGB(it.value)}
        val sumOfPowers = dataMap3.map{(_,value) -> value.fold(1){ power, element -> power * element} }.sum()
        return sumOfPowers
    }


}

fun main() {

    val day2 = Day2_2023()

    val res_A = day2.getSumOfPossibleGameIDs(day2.data)

    println("Summan av möjliga Game ID:n:  $res_A")

    val res_B = day2.getSumOfPowersOfFewestPossibleCubes(day2.data)

    println("Summan av produkten av minimum antal kuber:  $res_B")

    val dataIn: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_2_2023.txt").readLines()

    //println(dataIn)

    //2023_2a
    //New map of dataIn with set of cubes as values
    val dataMap = dataIn.withIndex().associateBy ({ it.index+1 }, {it.value.substring(it.value.indexOf(":")+1).trim()})

    //println(dataMap)

    //New map derived from dataMap with same keys, but values are split around ';' and ',' so it forms lists of list of String
    val dataMap2 = dataMap.mapValues { it.value.split(";").map{s->s.trim()}.map{s->s.split(",")} }

    //Returns the highest values of red, green and blue cubes in each game, List of lists(String) to list(Int)
    fun getListWithMaxRGB(listOfList:List<List<String>>):List<Int>{
        var red = 0
        var green = 0
        var blue = 0

        for(list in listOfList){
            for(elements in list){
                val tempS = elements.trim().split(" ")
                when(tempS[1]){
                    "red" -> if(tempS[0].toInt() > red) red = tempS[0].toInt()
                    "green" -> if(tempS[0].toInt() > green) green = tempS[0].toInt()
                    "blue" -> if(tempS[0].toInt() > blue) blue = tempS[0].toInt()
                }
            }
        }
        return listOf(red,green,blue)
    }



    val dataMap3 = dataMap2.mapValues { getListWithMaxRGB(it.value)}

    println(dataMap3)

    val cubesInBag = listOf(12, 13, 14)

    val game: Map<Int, List<Int>> = mapOf(1 to listOf(4, 2, 6), 2 to listOf(8, 15, 4), 3 to listOf(4, 1, 1), 4 to listOf(3,13,14))

    fun isLower(list1: List<Int>, list2: List<Int>) =  list1.zip(list2).all { (n1, n2) -> n1 >= n2 }

    //val result = game.map{ entry -> isLower(cubesInBag, entry.value) }

    val result = dataMap3.map{ entry -> isLower(cubesInBag, entry.value) }

    var sum = 0

    result.forEachIndexed { index, element -> if(element) sum+=index+1}

    println(result)

    println("Sum of possible game ID:s: $sum")

    //2023_2b
    println("Sum of powers: ")

    print(dataMap3.map{(_,value) -> value.fold(1){ power, element -> power * element} }.sum())
}