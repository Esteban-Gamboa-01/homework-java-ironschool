package com.ironhack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerMenu {
    Scanner scanner = new Scanner(System.in);
    public ServerMenu() {
    }

    public void showMenu() {
        System.out.println("\nFantastic! All data introduced is correct. Then, we provide a command list" +
                "for managing or adding a new information.");
        System.out.println("\nCOMMAND LIST: ");
        System.out.println(
                "- ENROLL [STUDENT_ID] [COURSE_ID]                  Example: ENROLL S3 C6" +
                    "\n- ASSIGN [TEACHER_ID] [COURSE_ID]                  Example: ASSIGN T2 C3" +
                    "\n- SHOW COURSES" +
                    "\n- LOOKUP COURSE [COURSE_ID]                        Example: LOOKUP COURSE C8" +
                    "\n- SHOW STUDENTS" +
                    "\n- LOOKUP STUDENT [STUDENT_ID]                      Example: LOOKUP STUDENT S5" +
                    "\n- SHOW TEACHERS" +
                    "\n- LOOKUP TEACHER [TEACHER_ID]                      Example: LOOKUP STUDENT T10" +
                    "\n- SHOW PROFIT" +
                    "\n- EXIT");
    }

    public boolean selectCommand(){
        boolean option = true;

        System.out.println("\nPlease introduce a command:");
        String cmd = scanner.nextLine();
        if(cmd.equals("EXIT")){
            option = false;
            scanner.close();
        }else{
            try{
                sanitize(cmd);
            } catch (Exception e) {
                //System.out.println("Command not recognized, please try again.");
                System.out.println(e.getMessage());
            }
        }
        //scanner.close();
        return option;
    }

    public void sanitize(String args){
        //boolean sanitize = false;
        String[] values = args.split( " ");
        if (values.length > 3 && !values[0].equals("EXIT")) throw new IllegalArgumentException("Too many arguments.");
        if (values.length < 2 && !values[0].equals("EXIT")) throw new IllegalArgumentException("Too few arguments.");

        CommandFunction command = new CommandFunction();

        // COMMANDO ENROLL
        if(values.length == 3 && values[0].equals("ENROLL")){
            if(isValidStudentId(values[1]) && isValidCourseId(values[2])){
                command.enroll(values[1],values[2]);
            }else{
                throw new IllegalArgumentException("Parameters for ENROLL are incorrect.");
            }
            // COMMANDO ASSIGN
        }else if (values.length == 3 && values[0].equals("ASSIGN")){
            if(isValidTeacherId(values[1]) && isValidCourseId(values[2])){
                command.assign(values[1],values[2]);
            }else{
                throw new IllegalArgumentException("Parameters for ASSIGN are incorrect.");
            }
            // COMMANDO SHOW
        }else if(values[0].equals("SHOW") && values.length == 2){
            if(values[1].equals("COURSES")){
                command.showCourses();
            }else if(values[1].equals("STUDENTS")){
                command.showStudents();
            }else if(values[1].equals("TEACHERS")){
                command.showTeachers();
            }else if(values[1].equals("PROFIT")){
                command.showProfit();
            }else{
                throw new IllegalArgumentException("Invalid parameters for SHOW.");
            }
            // COMMANDO LOOKUP
        }else if(values[0].equals("LOOKUP") && values.length == 3) {
            if (values[1].equals("STUDENT") && isValidStudentId(values[2])) {
                command.lookupStudent(values[2]);
            } else if (values[1].equals("COURSE") && isValidCourseId(values[2])) {
                command.lookupCourse(values[2]);
            } else if (values[1].equals("TEACHER") && isValidTeacherId(values[2])) {
                command.lookupTeacher(values[2]);
            } else {
                throw new IllegalArgumentException("Invalid parameters for LOOKUP");
            }
        }else{
            throw new IllegalArgumentException("Invalid Command.");
        }
        //return sanitize;
    }

    public boolean isValidStudentId(String value) {
        boolean result = false;
        for(Student s: Main.studentList){
            if(s.getStudentId().equals(value)){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isValidCourseId(String value) {
        boolean result = false;
        for(Course c: Main.courseList){
            if(c.getCourseId().equals(value)){
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean isValidTeacherId(String value) {
        boolean result = false;
        for (Teacher t : Main.teacherList) {
            if (t.getTeacherId().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void closeScanner() {
        this.scanner.close();
    }
}