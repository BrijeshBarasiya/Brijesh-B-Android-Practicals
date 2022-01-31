package com.example.basicofkotlin

import android.widget.Toast

//Enumerations, Abstract Class and Constractor
fun main() {
    println("Enter Your Name:")
    var name: String? = readLine()
    while (true) {
        println("Enter Any One Subject from List:")
        for(i in 0..Subject.values().size -1)
            println(Subject.values().get(i))
        var sub: String? = readLine()
        if(Subject.values().map { it.name }.contains(sub.toString())) { //Checking Subject is Exist in enum or not
            val student = Student(name.toString(), sub.toString())
            student.displyDetails()
            break
        } else
            println("Wrong Input!!")
    }
}

enum class Subject { //Creating Enumerations Class witth Name Subject
    xCode,
    Java,
    Python,
    C,
    Dotnet,
    Kotlin,
    Php,
    Hyml,
    CSS //Defining constants values
}
abstract class StudentDetails { //Created abstract class with name StudentDetails
    abstract fun displyDetails() //Created abstract fuction in abstract class
}
class Student: StudentDetails { // Created new class and extends StudentDetails
    var name: String //Initialising variable
    var sub: String
    constructor(name: String, sub: String) { //Initialis Constructor for Student Clas
        println("I am in Constractor and Initialise the Value Given By You")
        this.name = name
        this.sub = sub
    }

    override fun displyDetails() {
        print("Student Name is: ${name} and Subject is: ${sub}")
    }
}