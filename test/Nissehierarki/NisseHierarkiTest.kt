package Nissehierarki

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

//Nissehierarki test i Kotlin
class NisseHierarkiTest {

    val nh = NisseHierarki()

    val uTomten = listOf("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten", "Glader",
    "Butter", "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen")
    val uGlader = listOf("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten")
    val uButter = listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran",
    "Bladlusen")
    val uTrötter = listOf("Dammråttan", "Skumtomten")
    val uSkumtomten = listOf("Dammråttan")
    val uRäven = listOf("Gråsuggan", "Myran", "Bladlusen")
    val uMyran = listOf("Bladlusen")


    @Test
    fun getUnderlingsBladlusenTest(){
        val list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Bladlusen", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsTrögerTest(){
        val list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Tröger", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsBlygerTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Blyger", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsDammråttanTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Dammråttan", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsGråsugganTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Gråsuggan", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsHarenTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Haren", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsNyckelpiganTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Nyckelpigan", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsRådjuretTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Rådjuret", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, 0)
        }
    }

    @Test
    fun getUnderlingsMyranTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Myran", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uMyran.size)
            assertFalse(underlings.retainAll(uMyran))
        }
    }

    @Test
    fun getUnderlingsRävenTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Räven", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uRäven.size)
            assertFalse(underlings.retainAll(uRäven))
        }
    }



    @Test
    fun getUnderlingsSkumtomtenTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Skumtomten", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uSkumtomten.size)
            assertFalse(underlings.retainAll(uSkumtomten))
        }
    }

    @Test
    fun getUnderlingsTrötterTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Trötter", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uTrötter.size)
            assertFalse(underlings.retainAll(uTrötter))
        }
    }

    @Test
    fun getUnderlingsButterTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Butter", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uButter.size)
            assertFalse(underlings.retainAll(uButter))
        }
    }

    @Test
    fun getUnderlingsGladerTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Glader", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uGlader.size)
            assertFalse(underlings.retainAll(uGlader))
        }
    }

    @Test
    fun getUnderlingsTomtenTest(){
        var list: MutableList<String> = mutableListOf()
        val underlings: MutableList<String>? = nh.getTomteHierarki("Tomten", nh.nisseMapByName, list)
        if (underlings != null) {
            assertEquals(underlings.size, uTomten.size)
            assertFalse(underlings.retainAll(uTomten))
        }
    }

    @Test
    fun getTomteHierarki() {
    }
}
