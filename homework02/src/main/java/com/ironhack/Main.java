package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int counterStudent = 1;
    public static List<Teacher> teacherList = new ArrayList<>();
    public static List<Course> courseList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

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