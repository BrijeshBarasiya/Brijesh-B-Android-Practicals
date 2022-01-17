package com.example.basicofkotlin

//ForLoop, WhileLoop,DoWhileLoop,List,ArrayList
fun main(){
    var diceRange: IntRange = 1..6 //Giving Number Range 1-6 it include 1 and 6
    var diceNumber = diceRange.random() //Genrate Random Number From diceRange
    var randomNumber = (1..6).random() //Similar Method to Genrate Random Number
    println(diceNumber.toString())
    println(randomNumber)

    //ArrayList
    println("\nWelcome to ArrayList")
    val arrayList = ArrayList<String>() //Created New ArrayList
    arrayList.add("A") //Adding new Value to arrayList
    arrayList.add("B")
    arrayList.add("C")
    arrayList.add("D")
    arrayList.add("E")

    println("All Element")
    for(i in arrayList) //ForLoop Initialization
        print(i + " ")

    println("\nRemoving E")
    arrayList.remove("E") //Removing element E
    for(i in 0..arrayList.size-1) //Similor Method for ForLoop Initialization
        print(arrayList[i] + " ")

    println("\nRemoving Element on Index-2")
    arrayList.removeAt(2) //Removing element on Index-2
    for(i in 0..arrayList.size-1)
        print(arrayList[i] + " ")

    println("\nUpdating Element on Index-2")
    arrayList.set(2,"C") //Updating Element C on Index-2
    for(i in arrayList)
        print(i + " ")

    println("\nIndex of B is: ${arrayList.indexOf("B")}") //Printing Index of Element B
    arrayList.clear() //Clearing arrayList (ArrayList will empty)
    print("Size of List is: " + arrayList.size) //Printing Size of ArrayList


    //List
    println("\nWelcome to List")
    var simpleList = listOf("A","B","C","D","E") //Created New List
    var i:Int =0
    while (i < simpleList.size) {
        println("item at $i is ${simpleList[i]}")
        i++
    }
    val city = listOf("Rajkot", "Ahmadabad", "Surat","Anand", "Gandhinagar","Junagadh","Ankleshwar")
    city.filter { cityName ->
        cityName.startsWith("A") }.sortedBy {cityName -> cityName}.map { it.uppercase() }.forEach { println(it) }


    //DoWhile
    println("\nWelcome to DoWhileLoop")
    var count:Int = 0
    do {
        print(count)
        count++
    }while (count == 5)


    //FoorLoop
    println("\nWelcome to ForLoop")
    for(i in 1..50) //By Default Increment By 1
        print("$i ")
    print("\n")

    for(i in 1..50 step 2) //Increment By 2
        print("$i ")
    print("\n")

    for(i in 50 downTo 0 step 3) //Reverse Loop and Dcrement by 3
        print("$i ")


    //MutableList
    println("\nWelcome to MutableList")
    val number = mutableListOf(1,2,3,4,5,6,7,8,9)
    number.add(10) //Adding new Value
    println(number)
    number.add(0,11) //Adding new value 11 at 0 Index
    println(number)

    val cityList = mutableMapOf<Int, String>()
    cityList[1] = "Rajkot"
    cityList.put(2,"Ahmadabad")
    println(cityList)
    println("Printing All Keys of City ${cityList.keys}")
    println("Printing All Values of City ${cityList.values}")
}