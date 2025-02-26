package com.ironhack;

public class Main {
    public static int counterStudent = 1;

    public static void main(String[] args) {


        //Menu
        InitialMenu initialMenu = new InitialMenu();
        ServerMenu serverMenu = new ServerMenu();

        initialMenu.startMenu();
        initialMenu.numberTeacher();
        initialMenu.createTeacher();
        initialMenu.numberCourse();
        initialMenu.createCourse();
        initialMenu.numberStudent();
        initialMenu.createStudent();

        serverMenu.showMenu();
        serverMenu.selectCommand();
    }
}