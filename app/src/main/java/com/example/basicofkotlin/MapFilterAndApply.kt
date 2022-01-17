package com.example.basicofkotlin

import kotlin.random.Random

fun main(){
    //Map
    val mapList = mutableMapOf(0 to "Android") //Created New mutable Map
    mapList.set(1,"iOS") //Adding new entry to mapList
    mapList.set(2,"php")
    mapList.set(3,"C#")
    mapList.set(4,".net")
    mapList.putAll(setOf(5 to "HTML", 6 to "CSS", 7 to "Java")) //Adding Multiple Value to Map

    println("Size is: ${mapList.size}")
    println("List is: $mapList") //printing mapList
    println("Keys is: ${mapList.keys}")//printing all keys of Map
    println("Values are: ${mapList.values}")//printing all values of Map

    mapList.remove(4) //Removing Map Entry using Key
    mapList.remove(3, "C#") //Removing Map Entry using key and Value
    mapList.replace(2, "C#") //Replacing Value using Key

    println(Pair("A","Apple"))
    println(mapOf(1 to "One", 2 to "Two", 3 to "Three"))

    //Filter
    val lFilter = mapList.filter { (key, value) ->
        value.startsWith("A")
    }
    println(lFilter)

    //Let(it)
    val eString = "Welcome"
    eString.let { eLet ->
        println("Legth is: ${eLet.length}")
        println("${eLet.uppercase()}")
    }

    //Run(this)
    eString.run {
        println("Legth is: ${length}")
        println("${uppercase()}")
    }

    //Apply
    var numList = mutableListOf<Int>()
    numList.apply {
        add(52)
        add(35)
        add(25)
        add(66)
        add(23)
    }.sort()

    //Also
    numList.also {
        println("Size is: ${it.size}")
        println("List is: $it")
    }

    //TakeIf
    var rNum = Random.nextInt()
    println("TakeIf: ${rNum.takeIf { it % 2 ==0 }}")

    //TakeUnless
    println("TakeUnless: ${rNum.takeUnless { it % 2 ==0 }}")
}