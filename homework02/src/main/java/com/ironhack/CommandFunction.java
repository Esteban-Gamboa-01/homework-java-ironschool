package com.ironhack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandFunction {

    public CommandFunction() {
    }

    public void showTeachers() {
        System.out.println();

        if (Main.teacherList.isEmpty()) {
            System.out.println( "There are no teachers at the school.");
        } else {
            for (Teacher teacher : Main.teacherList) {
                System.out.println(teacher.toString());
            }
        }
    }

    public void lookupCourse(String courseId){
        boolean found = false;
        String result = "";
        // If no students in list
        if (Main.courseList.isEmpty()) {
            result = "There are no courses.";
        } else {
            for (Course course : Main.courseList) {
                if (course.getCourseId().equals(courseId)) {
                    // Store found student info
                    result = course.toString();
                    found = true;
                    break;
                }
            }
            // If not found
            if (!found) {
                result = "Not Found course with ID ( " + courseId + " ).";
            }
        }
        System.out.println(result);
    }

    public void enroll(String studentId, String courseId) {
        boolean isFoundStudent = false;
        boolean isFoundCourse = false;
        int j=0;
        int k=0;

        if (Main.studentList.isEmpty() || Main.courseList.isEmpty()) {
            System.out.println("Something went wrong.");
        } else {
            for (int i = 0; i<Main.studentList.size() ;i++) {
                if (Main.studentList.get(i).getStudentId().equals(studentId)) {
                    isFoundStudent = true;
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

            if (!isFoundStudent) {
                System.out.println("Not Found student with ID ( " + studentId + " ).");
            } else if (!isFoundCourse) {
                System.out.println("Not Found course with ID ( " + courseId + " ).");
            }else{
                Course c = Main.courseList.get(k);
                Student s = Main.studentList.get(j);
                s.setCourse(c);
                Main.studentList.set(j,s);
                System.out.println(Main.studentList.get(j).toString());
            }
        }
    }


}
