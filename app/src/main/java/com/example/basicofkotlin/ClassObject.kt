package com.example.basicofkotlin

import java.lang.Exception

//Class, Object and Exception Handling
fun main() {
    val operations = ArithmeticOperations() //Created new Obeject of ArithmeticOperations(Class)
    var check:Boolean = false
    try {
        println(operations.addition(20,10).toString()) //Calling ArithmeticOperations Class Function and Printing Return Value
        println(operations.subtraction(20,10).toString())
        println(operations.multiplication(20,10).toString())
        println(operations.division(20,2).toString())
    }catch (e: ArithmeticException){ //Handler
        println(e)
        check = true
    }catch (e: NumberFormatException){ //Handler
        println(e)
        check = true
    }catch (e: IllegalAccessException){//Handler
        println(e)
        check = true
    }catch (e: NullPointerException){ //Handler
        println(e)
        check = true
    }catch (e: Exception){ //Handler
        println(e)
        check = true
    }
    finally {
        if(check)
            println("Error Genrated")
        else
            println("No any Error Genrated")
    }
}

open class AdditionSubtraction{ //Creating New Class with name AdditionSubtraction
    fun addition(value1: Int, value2: Int): Int{ //Created Function in AdditionSubtraction Class
        return (value1+value2) //Returning Value
    }

    fun subtraction(value1: Int, value2: Int): Int {
        return (value1-value2)
    }
}

class ArithmeticOperations:AdditionSubtraction(){ //Extending Class ArithmeticOperations with AdditionSubtraction
    fun multiplication(value1: Int, value2: Int): Int{
        return (value1*value2)
    }

    fun division(value1: Int, value2: Int): Float {
        return (value1/value2).toFloat() //Converting Int to Float
    }
}
