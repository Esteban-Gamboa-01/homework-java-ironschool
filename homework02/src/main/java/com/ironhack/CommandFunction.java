package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class CommandFunction {
    //Change the empty method.
    public void showProfit() {
    }

    public void showCourses() {
    }

    public void showStudents() {
        InitialMenu lista = new InitialMenu();

        // If no courses in list
        if (lista.studentList.isEmpty()) {
            System.out.println( "There are no students at the school.");
        } else {
            for (Student student : lista.studentList) {
                System.out.println(student.toString() + "\n");
            }
        }
    }

    public void showTeachers() {
    }

    public void lookupCourse(String idCourse) {
    }

    public void lookupStudent(String idStudent) {
    }

    public void lookupTeacher(String idTeacher) {

    }

    public void enroll(String idStudent, String idCourse) {
    }

    public void assign(String idTeacher, String idCourse) {

    }
}
