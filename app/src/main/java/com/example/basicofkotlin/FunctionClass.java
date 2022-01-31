package com.example.basicofkotlin;

public class FunctionClass {

    static int sum (int value1, int value2) {
        return value1 += value2;
    }

    static int sub (int value1, int value2) {
        return value1 -= value2;
    }

    static int mul (int value1, int value2) {
        return value1 *= value2;
    }

    static int div (int value1, int value2) {
        return value1 /= value2;
    }

    public static void main(String []a) {
        System.out.println("Hello");
    }

}
