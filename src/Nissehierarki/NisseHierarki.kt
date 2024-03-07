package Nissehierarki

import java.time.Instant
import java.time.format.DateTimeFormatter

class NisseHierarki {

    val nisse1: Nisse = Nisse("Tomten")
    val nisse2: Nisse = Nisse("Glader")
    val nisse3: Nisse = Nisse("Butter")
    val nisse4: Nisse = Nisse("Blyger")
    val nisse5: Nisse = Nisse("Trötter")
    val nisse6: Nisse = Nisse("Tröger")
    val nisse7: Nisse = Nisse("Skumtomten")
    val nisse8: Nisse = Nisse("Dammråttan")
    val nisse9: Nisse = Nisse("Rådjuret")
    val nisse10: Nisse = Nisse("Nyckelpigan")
    val nisse11: Nisse = Nisse("Haren")
    val nisse12: Nisse = Nisse("Räven")
    val nisse13: Nisse = Nisse("Gråsuggan")
    val nisse14: Nisse = Nisse("Myran")
    val nisse15: Nisse = Nisse("Bladlusen")
    val nisse16: Nisse = Nisse("A")
    val nisse17: Nisse = Nisse("B")
    val nisse18: Nisse = Nisse("C")


    val nisseMap = mapOf<Nisse, List<Nisse>>(
        nisse1 to listOf<Nisse>(nisse2, nisse3),
        nisse2 to listOf<Nisse>(nisse4, nisse5, nisse6),
        nisse3 to listOf<Nisse>(nisse9, nisse10, nisse11, nisse12),
        nisse4 to listOf<Nisse>(),
        nisse5 to listOf<Nisse>(nisse7),
        nisse6 to listOf<Nisse>(),
        nisse7 to listOf<Nisse>(nisse8),
        nisse8 to listOf<Nisse>(),
        nisse9 to listOf<Nisse>(),
        nisse10 to listOf<Nisse>(nisse16, nisse17),
        nisse11 to listOf<Nisse>(),
        nisse12 to listOf<Nisse>(nisse13, nisse14),
        nisse13 to listOf<Nisse>(nisse18),
        nisse14 to listOf<Nisse>(nisse15),
        nisse15 to listOf<Nisse>()
    )

    val nisseMapByName = mapOf<String, List<String>>(
        nisse1.namn to listOf<String>(nisse2.namn, nisse3.namn),
        nisse2.namn to listOf<String>(nisse4.namn, nisse5.namn, nisse6.namn),
        nisse3.namn to listOf<String>(nisse9.namn, nisse10.namn, nisse11.namn, nisse12.namn),
        nisse4.namn to listOf<String>(),
        nisse5.namn to listOf<String>(nisse7.namn),
        nisse6.namn to listOf<String>(),
        nisse7.namn to listOf<String>(nisse8.namn),
        nisse8.namn to listOf<String>(),
        nisse9.namn to listOf<String>(),
        nisse10.namn to listOf<String>(),
        nisse11.namn to listOf<String>(),
        nisse12.namn to listOf<String>(nisse13.namn, nisse14.namn),
        nisse13.namn to listOf<String>(),
        nisse14.namn to listOf<String>(nisse15.namn),
        nisse15.namn to listOf<String>(),
        //  nisse16.namn to listOf<String>(),
        //  nisse17.namn to listOf<String>(),
        //  nisse18.namn to listOf<String>()
    )

    fun getTomteHierarki(
        namn: String,
        map: Map<String, List<String>>,
        list: MutableList<String>):  MutableList<String> {

        if (map[namn]?.size == 0) {
           // println("I if: $namn o listan: " + list)
            return list
        } else {
            for (i in map[namn]!!) {
                   //println("I For: $i")
                list.add(i)
                getTomteHierarki(i, map, list)
            }
            return list
        }
    }


    fun getUnderlings(s: String, l: List<String>): MutableList<String> {
        val nMap = nisseMapByName
        val ml: MutableList<String> = l.toMutableList()
        return getTomteHierarki(s, nMap, ml)
    }
}

fun main() {
    val nisseHierarki = NisseHierarki()

    nisseHierarki.nisseMapByName.forEach { key, value -> println(key + " " + value) }


    val list: List<String> = listOf()

    val list2: List<String> = listOf()

    println("--------------------")

    println("2: " + nisseHierarki.getUnderlings("Butter", list2))

    println("1: " + nisseHierarki.getUnderlings("Tomten", list))



}