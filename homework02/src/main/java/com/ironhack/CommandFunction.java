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
        System.out.println();

        if (Main.studentList.isEmpty()) {
            System.out.println( "There are no students at the school.");
        } else {
            for (Student student : Main.studentList) {
                System.out.println(student.toString());
            }
        }
    }

    public void showTeachers() {
    }

    public void lookupCourse(String courseId) {
    }

    public void lookupStudent(String studentId) {
    }

    public void lookupTeacher(String teacherId) {
        boolean isFound = false;

        if (Main.teacherList.isEmpty()) {
            System.out.println("There are no students.");
        } else {
            for (Teacher teacher : Main.teacherList) {
                if (teacher.getTeacherId().equals(teacherId)) {
                    // Store found teacher info
                    teacher.toString();
                    isFound = true;
                    break;
                }
            }
            // If not found
            if (!isFound) {
                System.out.println("Not Found student with ID ( " + teacherId + " ).");
            }
        }
    }

    public void enroll(String studentId, String courseId) {
    }

    public void assign(String teacherId, String courseId) {
        boolean isFoundTeacher = false;
        boolean isFoundCourse = false;
        int j=0;
        int k=0;

        if (Main.teacherList.isEmpty() || Main.courseList.isEmpty()) {
            System.out.println("There are no students.");
        } else {
            for (int i = 0; i<Main.teacherList.size() ;i++) {
                if (Main.teacherList.get(i).getTeacherId().equals(teacherId)) {
                    isFoundTeacher = true;
                    j=i;
                    break;
                }
            }

            for (int i = 0; i<Main.courseList.size() ;i++) {
                if (Main.courseList.get(i).getCourseId().equals(courseId)) {
                    isFoundCourse = true;
                    k=i;
                    break;//
                }
            }

            if (!isFoundTeacher) {
                System.out.println("Not Found teacher with ID ( " + teacherId + " ).");
            } else if (!isFoundCourse) {
                System.out.println("Not Found course with ID ( " + courseId + " ).");
            }else{
                Main.courseList.get(k).setTeacher(Main.teacherList.get(j));
                System.out.println(Main.courseList.get(k).toString());
            }
        }
    }
}
