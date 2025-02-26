package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // For auto generated IDs
    public static int courseId = 0;
    public static int teacherId = 0;
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
        //initialMenu.closeScanner();

        serverMenu.showMenu();
        boolean res = true;
        do{
            res = serverMenu.selectCommand();
        }while(res);
    }
}