package com.ironhack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandFunction {

    public CommandFunction() {
    }

    //Change the empty method.
    public void showProfit() {
        double totalMoneyCourses = 0;
        double totalSalaries = 0;

        // Total money earned from all courses
        for (Course course : Main.courseList) {
            totalMoneyCourses += course.getMoneyEarned();
        }

        // Sum of all teacher's salaries
        for (Teacher teacher :  Main.teacherList) {
            totalSalaries += teacher.getSalary();
        }

//        System.out.println("Total Profit: " + (totalMoneyCourses - totalSalaries));
        System.out.println("The profit is: "+ (totalMoneyCourses - totalSalaries));
    }

    public void showCourses() {
        String result = "";
        // If no courses in list
        if (Main.courseList.isEmpty()) {
            result = "There are no courses available.";
        } else {
            for (Course course : Main.courseList) {
                // Append course to the result string
                result += course.toString() + "\n";
            }
        }
        System.out.println(result);
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

    public void lookupStudent(String studentId) {
        boolean found = false;
        String result = "";
        // If no students in list
        if (Main.studentList.isEmpty()) {
            result = "There are no students.";
        } else {
            for (Student student : Main.studentList) {
                if (student.getStudentId().equals(studentId)) {
                    // Store found student info
                    result = student.toString();
                    found = true;
                    break;
                }
            }
            // If not found
            if (!found) {
                result = "Not Found student with ID ( " + studentId + " ).";
            }
        }
        System.out.println(result);
    }

    public void lookupTeacher(String teacherId) {
        boolean isFound = false;
        String result = "";
        if (Main.teacherList.isEmpty()) {
            System.out.println("There are no teachers.");
        } else {
            for (Teacher teacher : Main.teacherList) {
                if (teacher.getTeacherId().equals(teacherId)) {
                    // Store found teacher info
                    result=teacher.toString();
                    isFound = true;
                    break;
                }
            }
            // If not found
            if (!isFound) {
                result="Not Found teacher with ID ( " + teacherId + " ).";
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
                c.setMoneyEarned(c.getMoneyEarned()+c.getPrice());
                Main.courseList.set(k,c);
                Student s = Main.studentList.get(j);
                s.setCourse(c);
                Main.studentList.set(j,s);
                System.out.println(Main.studentList.get(j).toString());
            }
        }
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

    // FOR TESTING

    public String showCoursesTest(){
        String result = "";
        // If no courses in list
        if (Main.courseList.isEmpty()) {
            result = "There are no courses available.";
        } else {
            for (Course course : Main.courseList) {
                // Append course to the result string
                result += course.toString() + "\n";
            }
        }
        return result;
    }

    public String lookupStudentTest(String studentId){
        boolean found = false;
        String result = "";
        // If no students in list
        if (Main.studentList.isEmpty()) {
            result = "There are no students.";
        } else {
            for (Student student : Main.studentList) {
                if (student.getStudentId().equals(studentId)) {
                    // Store found student info
                    result = student.toString();
                    found = true;
                    break;
                }
            }
            // If not found
            if (!found) {
                result = "Not Found student with ID ( " + studentId + " ).";
            }
        }
        return result;
    }

    public double showProfitTest() {
        double totalMoneyCourses = 0;
        double totalSalaries = 0;

        // Total money earned from all courses
        for (Course course : Main.courseList) {
            totalMoneyCourses += course.getMoneyEarned();
        }

        // Sum of all teacher's salaries
        for (Teacher teacher :  Main.teacherList) {
            totalSalaries += teacher.getSalary();
        }

//        System.out.println("Total Profit: " + (totalMoneyCourses - totalSalaries));
        return totalMoneyCourses - totalSalaries;
    }

    // EXTRA COMMANDS


}
