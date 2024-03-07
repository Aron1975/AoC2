import java.io.File

class Day2_2023_Efter {

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

    fun getMapOfMaxRGBValues(list: List<String>):Map<Int, List<Int>> { //input.substringAfter(":")

        //New map of list(data In) with set of cubes as values
       // val dataMap = list.withIndex().associateBy({ it.index + 1 }, { it.value.substring(it.value.indexOf(":") + 1).trim() })
        //Använder .substringAfter(":") efter att ha kollat på Todd Ginsbergs lösning
        val dataMap = list.withIndex().associateBy({ it.index + 1 }, { it.value.substringAfter(":")})
        //New map derived from dataMap with same keys, but values are split around ';' and ',' so it forms lists of list of String
        val dataMap2 = dataMap.mapValues { it.value.split(";").map { s -> s.split(",") } }
        return dataMap2.mapValues { getListWithMaxRGB(it.value) }
    }

    fun isLower(list1: List<Int>, list2: List<Int>) =  list1.zip(list2).all { (n1, n2) -> n1 >= n2 }

    //2023_2a
    fun getSumOfPossibleGameIDs(list: List<String>):Int{

        val map = getMapOfMaxRGBValues(list)
        //Förenklad lamba efter att ha googlat runt, inte efter någon specifik lösning
        val summa = map.filter{isLower(cubesInBag, it.value)}.map{it.key}.sum()
        return summa
    }

    //2023_2b
    fun getSumOfPowersOfFewestPossibleCubes(list: List<String>):Int{

        val map = getMapOfMaxRGBValues(list)
        return map.map{(_,value) -> value.fold(1){ power, element -> power * element} }.sum()
    }
}

fun main() {

    val day2 = Day2_2023_Efter()

    val res_A = day2.getSumOfPossibleGameIDs(day2.data)

    println("Summan av möjliga Game ID:n:  $res_A")

    val res_B = day2.getSumOfPowersOfFewestPossibleCubes(day2.data)

    println("Summan av produkten av minimum antal kuber:  $res_B")

}