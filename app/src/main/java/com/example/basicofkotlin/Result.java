package com.example.basicofkotlin;

import java.util.Scanner;

enum Subject {
    English,
    Hindi,
    Maths,
    Science,
    SocialScience
}
class Student {
    String sName;
    int sRollno,sContact;
    void pDetail(String sName, int sRollno, int sContact) {
        this.sName = sName;
        this.sRollno = sRollno;
        this.sContact = sContact;
    }

    int cMarks(int []sMarks) {
        int total = 0;
        for(int i=0; i < sMarks.length ; i++) {
            total += sMarks[i];
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        Subject sub[] = Subject.values();
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();

        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student Roll Number: ");
        int rno = sc.nextInt();
        System.out.println("Enter Student Contact: ");
        int contact = sc.nextInt();

        int marks[] = new int[Subject.values().length];
        for(int i=0; i < marks.length; i++) {
            System.out.println("Enter Mark of " + sub[i] + ": ");
            marks[i] = sc.nextInt();
        }

        s1.pDetail(name, rno, contact);
        int result = s1.cMarks(marks);
        System.out.println("Result is: " + result);
        float percentage = result/Subject.values().length;
        if(percentage >= 91)
            System.out.println("Grade A");
        else if (percentage <=90 && percentage >= 81)
            System.out.println("Grade B");
        else if (percentage <=80 && percentage >= 61)
            System.out.println("Grade C");
        else if (percentage <=60 && percentage >= 36)
            System.out.println("Grade D");
        else if (percentage <=35)
            System.out.println("Fail");
    }
}
