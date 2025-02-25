package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class CommandFunction {
    List<Course> coursesList;
    List<Student> studentsList;
    List<Teacher> teachersList;

    public CommandFunction() {
    }

    public CommandFunction(List<Course> coursesList, List<Student> studentsList, List<Teacher> teachersList) {
        this.coursesList = coursesList;
        this.studentsList = studentsList;
        this.teachersList = teachersList;
    }

    public String showCourses(){
        String result = "";
        // If no courses in list
        if (coursesList.isEmpty()) {
            result = "There are no courses available.";
        } else {
            for (Course course : coursesList) {
                // Append course to the result string
                result += course.toString() + "\n";
            }
        }
        return result;
    }

    public String lookupStudent(String studentId){
        boolean found = false;
        String result = "";
        // If no students in list
        if (studentsList.isEmpty()) {
            result = "There are no students.";
        } else {
            for (Student student : studentsList) {
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

    public double showProfit() {
        double totalMoneyCourses = 0;
        double totalSalaries = 0;

        // Total money earned from all courses
        for (Course course : coursesList) {
            totalMoneyCourses += course.getMoneyEarned();
        }

        // Sum of all teacher's salaries
        for (Teacher teacher :  teachersList) {
            totalSalaries += teacher.getSalary();
        }

//        System.out.println("Total Profit: " + (totalMoneyCourses - totalSalaries));
        return totalMoneyCourses - totalSalaries;
    }

    // EXTRA COMMANDS


}
