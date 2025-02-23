package com.ironhack;

public class Main {
    public static int global_int = 0;

    public static void main(String[] args) {
        //Menu
        // Testing branch maindev01
        Teacher john = new Teacher("John",23_000);
        Teacher jane = new Teacher("Jane",24_000);
        System.out.println(john.getTeacherId());
        System.out.println(jane.getTeacherId());
    }
}