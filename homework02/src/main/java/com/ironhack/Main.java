package com.ironhack;

public class Main {
    public static void main(String[] args) {
        int counterStudent = 1;

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