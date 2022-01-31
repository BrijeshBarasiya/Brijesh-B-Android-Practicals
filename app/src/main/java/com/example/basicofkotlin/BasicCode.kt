package com.example.basicofkotlin

import java.util.Scanner

//Declaration of Variable ,Priting,When(KeyWord) and Fuction
fun main() {
    var name = "Brijesh" //Initialise new variable
    var number = 2503
    PrintingDetails(name, number) //Calling PrintingDetails Function

    var sc = Scanner(System.`in`) //Import Scanner Class for Scanning Value
    print("Enter Birthday Month")
    var birthMonth = sc.nextInt() //Scanning Value From User
    when(birthMonth) {
        1 -> println("Jan")
        2 -> println("Feb")
        3 -> println("Mar")
        4 -> println("April")
        5 -> println("May")
        6 -> println("Jun")
        7 -> println("Jul")
        8 -> println("Aug")
        9 -> println("Sep")
        10 -> println("Oct")
        11 -> println("Nov")
        12 -> println("Dec")
        else -> println("Wrong Input!!")
    }
}
fun PrintingDetails(name: String, number: Int) {// Created New Function
    println("Name is: $name and Number is: ${number}") //Printing "Name and Number"
}