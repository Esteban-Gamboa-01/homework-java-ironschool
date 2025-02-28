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

        double totalProfit = totalMoneyCourses - totalSalaries;
        if (totalProfit < 0) {
            System.out.println("The profit is: " + Style.ERROR + totalProfit + Style.RESET + "€");
        } else {
            System.out.println("The profit is: " + Style.SALARY + totalProfit + Style.RESET + "€");
        }
    }

    public void showCourses() {
        String result = "";
        // If no courses in list
        if (Main.courseList.isEmpty()) {
            result = Style.NOT_FOUND + "There are no courses available." + Style.RESET;
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
            System.out.println(Style.NOT_FOUND + "There are no students at the school." + Style.RESET);
        } else {
            for (Student student : Main.studentList) {
                System.out.println(student.toString());
            }
        }
    }

    public void showTeachers() {
        System.out.println();

        if (Main.teacherList.isEmpty()) {
            System.out.println(Style.NOT_FOUND + "There are no teachers at the school." + Style.RESET);
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
            result = Style.NOT_FOUND + "There are no courses." + Style.RESET;
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
                result = Style.NOT_FOUND + "Not Found course with ID ( " + courseId + " )." + Style.RESET;
            }
        }
        System.out.println(result);
    }

    public void lookupStudent(String studentId) {
        boolean found = false;
        String result = "";
        // If no students in list
        if (Main.studentList.isEmpty()) {
            result = Style.NOT_FOUND + "There are no students." + Style.RESET;
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
                result = Style.NOT_FOUND + "Not Found student with ID ( " + studentId + " )." + Style.RESET;
            }
        }
        System.out.println(result);
    }

    public void lookupTeacher(String teacherId) {
        boolean isFound = false;
        String result = "";
        if (Main.teacherList.isEmpty()) {
            System.out.println(Style.NOT_FOUND + "There are no teachers." + Style.RESET);
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
                result=Style.NOT_FOUND + "Not Found teacher with ID ( " + teacherId + " )." + Style.RESET;
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
            System.out.println(Style.ERROR + "Something went wrong." + Style.RESET);
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
                System.out.println(Style.NOT_FOUND + "Not Found student with ID ( " + studentId + " )." + Style.RESET);
            } else if (!isFoundCourse) {
                System.out.println(Style.NOT_FOUND + "Not Found course with ID ( " + courseId + " )." + Style.RESET);
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
            System.out.println(Style.NOT_FOUND + "There are no courses or teachers." + Style.RESET);
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
                System.out.println(Style.NOT_FOUND + "Not Found teacher with ID ( " + teacherId + " )." + Style.RESET);
            } else if (!isFoundCourse) {
                System.out.println(Style.NOT_FOUND + "Not Found course with ID ( " + courseId + " )." + Style.RESET);
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
    public void showStudentsByCourse(String courseId) {
        boolean found = false;
        for (Course course : Main.courseList) {
            if (course.getCourseId().equals(courseId)) {
                found = true;
                System.out.println("Students enrolled in the course " + courseId + ":");
                for (Student student : Main.studentList) {
                    if (student.getCourse() != null && student.getCourse().getCourseId().equals(courseId)) {
                        System.out.println(student);
                    }
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }

    public void showMoneyEarned() {
        double totalMoneyEarned = 0;
        for (Course course : Main.courseList) {
            totalMoneyEarned += course.getMoneyEarned();
        }
        System.out.println("Total money earned from all courses: " + totalMoneyEarned);
    }

    public void showMoneySpent() {
        double totalMoneySpent = 0;
        for (Teacher teacher : Main.teacherList) {
            totalMoneySpent += teacher.getSalary();
        }
        System.out.println("Total money spent on teachers' salaries: " + totalMoneySpent);
    }

    public void showTeachersByCourse(String courseId) {
        boolean found = false;
        for (Course course : Main.courseList) {
            if (course.getCourseId().equals(courseId)) {
                found = true;
                System.out.println("Teachers assigned to course " + courseId + ":");
                if (course.getTeacher() != null) {
                    System.out.println(course.getTeacher());
                } else {
                    System.out.println("No teacher assigned to this course.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }


}
