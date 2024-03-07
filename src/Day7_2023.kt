import java.io.File
import kotlin.time.times

class Day7_2023 {

    var mapOfHands = mutableMapOf<HandValue, MutableList<Hand>>()

    fun addHand(hand: Hand){
        if (mapOfHands.containsKey(hand.handValue)) {
            mapOfHands[hand.handValue]?.add(hand)
        } else {
            mapOfHands[hand.handValue] = mutableListOf(hand)
        }
    }

    fun createMapOfHands(data: List<String>) {
       // val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_7_2023.txt").readLines()
        for(i in 0..data.size-1){
            val splittedData = data[i].split(" ")
            addHand(Hand(splittedData[0], Integer.parseInt(splittedData[1])))
        }
    }

    fun getOrderedHandsList(map: MutableMap<HandValue, MutableList<Hand>>):MutableList<Hand> {

        val listOfAll = mutableListOf<Hand>()
        for (entry in HandValue.entries.reversed()) {
            //print("${entry}: ")
           // map[entry]?.forEach { e -> print(e.cards + ", ") }
            val l = map[entry]?.sortedBy { e -> e.sortableCards } //lista sorterad
           // println("sorted")
          //  l?.forEach { e -> println(e.cards + " : " + e.bid + " ") }
          //  println(" ")
            l?.let { listOfAll.addAll(it) }
        }
        return listOfAll
    }

    fun getSumOfOrderedHandsMultipliedByBids(data: List<String>):Int{

        createMapOfHands(data)
        val orderedHandList = getOrderedHandsList(mapOfHands)
        val numberedList= (1 .. orderedHandList.size).toList()
        return orderedHandList.zip(numberedList){ i, v -> i.bid*v}.sum()
    }
}

class Hand(val cards:String, val bid: Int){

    private val handMap: Map<Char, Int> = cards.toList().groupingBy{it}.eachCount()
    val handValue: HandValue = checkHandValue(handMap)
    val sortableCards = changeCardValues()

    private fun changeCardValues(): String{
        var cardsReplaced = cards.replace("T", "a").replace("J", "b")
            .replace("Q", "c").replace("K", "d").replace("A", "e")
        return cardsReplaced
    }

    private fun checkHandValue(handMap: Map<Char, Int>): HandValue{

        if(handMap.any{it.value==5}) return HandValue.FIVEOFAKIND
        if(handMap.any{it.value==4}) return HandValue.FOUROFAKIND
        if(handMap.any{it.value==3} && handMap.any{it.value==2}) return HandValue.FULLHOUSE
        if(handMap.any{it.value==3}) return HandValue.THREEOFAKIND
        if(handMap.values.count()==3) return HandValue.TWOPAIR
        if(handMap.values.count()==4) return HandValue.ONEPAIR
        return HandValue.HIGHCARD
    }
}

fun main() {

    val day7 = Day7_2023()
    val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_7_2023.txt").readLines()

    val res = day7.getSumOfOrderedHandsMultipliedByBids(data)

    println("Summan av händerna i rangordning multiplicerat med dess bet:  $res")
/*
   var mapOfHands = mutableMapOf<HandValue, MutableList<Hand>>()

    var mapOfHands2 = mutableMapOf(HandValue.HIGHCARD to mutableListOf<Hand>(),
        HandValue.ONEPAIR to mutableListOf<Hand>(),
        HandValue.TWOPAIR to mutableListOf<Hand>(),
        HandValue.THREEOFAKIND to mutableListOf<Hand>(),
        HandValue.FULLHOUSE to mutableListOf<Hand>(),
        HandValue.FOUROFAKIND to mutableListOf<Hand>(),
        HandValue.FIVEOFAKIND to mutableListOf<Hand>())

    fun addHand(hand: Hand){
        if (mapOfHands.containsKey(hand.handValue)) {
            mapOfHands[hand.handValue]?.add(hand)
        } else {
            mapOfHands[hand.handValue] = mutableListOf(hand)
        }
        mapOfHands2[hand.handValue]?.add(hand)
    }

    fun readHands() {
        val data: List<String> = File("C:\\Users\\Nackademin\\Funktionell Programmering\\AoC\\Data_7_2023.txt").readLines()
        for(i in 0..data.size-1){
            val splittedData = data[i].split(" ")
            addHand(Hand(splittedData[0], Integer.parseInt(splittedData[1])))
        }
    }*/

  //  readHands()
/*
    val hand1 = Hand("32T3K", 765)
    addHand(hand1)
    val hand2 = Hand("T55J5", 684)
    addHand(hand2)
    val hand3 = Hand("KK677", 28)
    addHand(hand3)
    val hand4 = Hand("KTJJT", 220)
    addHand(hand4)
    val hand5 = Hand("QQQJA", 483)
    addHand(hand5)
    val hand6 = Hand("32T2K", 765)
    addHand(hand6)
    val hand7 = Hand("3AT3K", 765)
    addHand(hand7)
    val hand8 = Hand("T55Q5", 684)
    addHand(hand8)
    val hand9 = Hand("155J5", 684)
    addHand(hand9)
    val hand10 = Hand("KK877", 28)
    addHand(hand10)*/

/*
    println("-----------")
    val listOfAll0 = mutableListOf<Hand>()
    var sum = 0
    for (entry in HandValue.entries.reversed()) {
        print("${entry}: ")
        mapOfHands[entry]?.forEach { e -> print(e.cards + ", ") }
        val l = mapOfHands[entry]?.sortedBy { e -> e.sortableCards } //lista sorterad
        println("sorted")
        l?.forEach { e -> println(e.cards + " : " + e.bid + " ")}
        println(" ")
        l?.let { listOfAll0.addAll(it) }
       // l?.sumOf(this.forEachIndexed { i, v -> i * v.bid})
       // sum = l?.reduceIndexed { index,sum, h -> sum+index*h.bid }
       // sum = l?.reduce{ sum, item -> sum + item.bid}
       // items.reduce {sum, item -> sum + item}
         /*   run {
                sumOf(i * v.bid)

            }*/

    }

    println("sorted 2")
    val listOfAll = mutableListOf<Hand>()
    for (entry in mapOfHands2.entries.iterator()) {
        print("${entry.key}: ")
        val l2 = mapOfHands2[entry.key]?.sortedBy { e -> e.sortableCards } //lista sorterad

        l2?.let { listOfAll.addAll(it) }
        //list1.addAll(list2)
        l2?.forEach { e -> println(e.cards + " : " + e.bid + " ") }
        println(" ")
    }


    //l[HandValue.HIGHCARD]

    println("-----?------")
    */

    /*
    var myCounter = 1
    var mySum = 0
    for (item in listOfAll) {
        sum += item.bid * myCounter
        println(item.cards + " : " + item.bid + " : " + myCounter + " Sum: " + sum)
        myCounter++
    }
    myCounter = 1
    mySum = 0
    sum = 0
    for (item in listOfAll0) {
        sum += item.bid * myCounter
        myCounter++
    }
    println("Summa: $sum") */

    //println(mapOfHands.values)
   // mapOfHands.forEach{entry-> println("$it.key : $entry.value")}

   //mapOfHands.merge(hand1.handValue, )
    // myMap.merge("Chocolate", 1, Int::plus)

}



