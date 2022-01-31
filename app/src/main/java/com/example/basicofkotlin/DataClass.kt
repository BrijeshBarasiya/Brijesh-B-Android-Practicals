package com.example.basicofkotlin

data class Parson(val name: String) { //Created new dataclass
    var nickName: String = String()
    var birthDate: String = String()
    var address: String = String()

}

fun main() {
    var parson = Parson("Brijesh") //define data class
    parson.nickName = "BB"
    parson.birthDate = "July"
    parson.address = "Rajkot"
    println(parson)

    var parson1: Parson
    parson1 = parson.copy() //Copy parson to parson1
    println(parson1)

    println(parson.equals(parson1)) //To Check Value are Equal or Not

    //Apply
    var parson2 = Parson("BBs").apply {
        this.address = "Rajkot"
        nickName ="BB"
    }
    println(parson2)

    //with
    with(parson2) {
        println(nickName)
        println(birthDate)
        println(address)
    }
}

