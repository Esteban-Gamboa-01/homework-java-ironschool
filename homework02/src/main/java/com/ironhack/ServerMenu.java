package com.ironhack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerMenu {
    Scanner scanner = new Scanner(System.in);
    public ServerMenu() {
    }

    public void showMenu() {
        System.out.println(Style.SUCCESS+Style.BOLD + "\nFantastic! All data introduced is correct. Then, we provide a command list " +
                "for managing or adding a new information." + Style.RESET);
        System.out.println(Style.BOLD + "\n--------------------------------- COMMAND LIST ---------------------------------\n" + Style.RESET);
        System.out.println(
                "- "+Style.SUCCESS_BG+Style.BOLD+" ENROLL [STUDENT_ID] [COURSE_ID] "+Style.RESET+"                  "+Style.HIGHLIGHT+"Example: ENROLL S3 C6" + Style.RESET +
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" ASSIGN [TEACHER_ID] [COURSE_ID] "+Style.RESET+"                  "+Style.HIGHLIGHT+"Example: ASSIGN T2 C3" + Style.RESET +
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" SHOW COURSES " +Style.RESET+
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" LOOKUP COURSE [COURSE_ID] "+ Style.RESET+"                        "+Style.HIGHLIGHT+"Example: LOOKUP COURSE C8" + Style.RESET +
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" SHOW STUDENTS " +Style.RESET+
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" LOOKUP STUDENT [STUDENT_ID] "+ Style.RESET+"                      "+Style.HIGHLIGHT+"Example: LOOKUP STUDENT S5" + Style.RESET +
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" SHOW TEACHERS " +Style.RESET+
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" LOOKUP TEACHER [TEACHER_ID] "+ Style.RESET+"                      "+Style.HIGHLIGHT+"Example: LOOKUP TEACHER T10" + Style.RESET +
                    "\n- "+Style.SUCCESS_BG+Style.BOLD+" SHOW PROFIT " +Style.RESET+
                    "\n- " + Style.HIGHLIGHT + " EXIT" + Style.RESET);
        System.out.println(Style.BOLD + "\n--------------------------------------------------------------------------------" + Style.RESET);
    }

    public boolean selectCommand(){
        boolean option = true;

        System.out.println("\nPlease introduce a command:");
        String cmd = scanner.nextLine();
        cmd = cmd.toUpperCase();
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
        if (values.length > 3 && !values[0].equals("EXIT")) throw new IllegalArgumentException(Style.ERROR + "Too many arguments." + Style.RESET);
        if (values.length < 2 && !values[0].equals("EXIT")) throw new IllegalArgumentException(Style.ERROR + "Too few arguments." + Style.RESET);

        CommandFunction command = new CommandFunction();

        // COMMANDO ENROLL
        if(values.length == 3 && values[0].equals("ENROLL")){
            if(isValidStudentId(values[1]) && isValidCourseId(values[2])){
                command.enroll(values[1],values[2]);
            }else{
                throw new IllegalArgumentException(Style.ERROR + "Parameters for ENROLL are incorrect." + Style.RESET);
            }
            // COMMANDO ASSIGN
        }else if (values.length == 3 && values[0].equals("ASSIGN")){
            if(isValidTeacherId(values[1]) && isValidCourseId(values[2])){
                command.assign(values[1],values[2]);
            }else{
                throw new IllegalArgumentException(Style.ERROR + "Parameters for ASSIGN are incorrect." + Style.RESET);
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
                throw new IllegalArgumentException(Style.ERROR + "Invalid parameters for SHOW." + Style.RESET);
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
                throw new IllegalArgumentException(Style.ERROR + "Invalid parameters for LOOKUP." + Style.RESET);
            }
            //showStudentsByCourse and showTeachersByCourse
        }else if(values[0].equals("SHOW") && values.length == 3){
            if(values[1].equals("ENLISTED") && isValidCourseId(values[2])){
                command.showStudentsByCourse(values[2]);
            }else if(values[1].equals("ASSIGNED") && isValidCourseId(values[2])){
                command.showTeachersByCourse(values[2]);
            }else if(values[1].equals("MONEY") && values[2].equals("SPENT")){
                command.showMoneySpent();
            }else if(values[1].equals("MONEY") && values[2].equals("EARNED")){
                command.showMoneyEarned();
            }else{
                throw new IllegalArgumentException("Invalid parameters for SHOW");
            }
        }else{
            throw new IllegalArgumentException(Style.ERROR + "Invalid Command." + Style.RESET);
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