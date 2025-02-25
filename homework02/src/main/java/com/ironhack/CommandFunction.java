package com.ironhack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandFunction {
    private School school;

    public CommandFunction(School school1) {
        this.school = school1;
    }

    public boolean getUserCommand(){
        boolean option = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease introduce a command:");
        String cmd = scanner.nextLine();
        if(cmd.equals("EXIT")){
            option = false;
        }else{
            try{
                sanitize(cmd);
            } catch (Exception e) {
                //System.out.println("Command not recognized, please try again.");
                System.out.println(e.getMessage());
            }
        }
        return option;
    }

    public void sanitize(String args){
        //boolean sanitize = false;
        String[] values = args.split( " ");
        if (values.length > 3 && !values[0].equals("EXIT")) throw new IllegalArgumentException("Too many arguments.");
        if (values.length < 2 && !values[0].equals("EXIT")) throw new IllegalArgumentException("Too few arguments.");


        // COMMANDO ENROLL
        if(values.length == 3 && values[0].equals("ENROLL")){
            if(school.isValidStudentId(values[1]) && school.isValidCourseId(values[2])){
                executeCommandEnroll(values[1],values[2]);
            }else{
                throw new IllegalArgumentException("Parameters for ENROLL are incorrect.");
            }
        // COMMANDO ASSIGN
        }else if (values.length == 3 && values[0].equals("ASSIGN")){
            if(school.isValidTeacherId(values[1]) && school.isValidCourseId(values[2])){
                executeCommandAssign(values[1],values[2]);
            }else{
                throw new IllegalArgumentException("Parameters for ASSIGN are incorrect.");
            }
        // COMMANDO SHOW
        }else if(values[0].equals("SHOW") && values.length == 2){
            if(values[1].equals("COURSES") || values[1].equals("STUDENTS") || values[1].equals("TEACHERS") || values[1].equals("PROFIT")){
                executeCommandShow(values[1]);
            }else{
                throw new IllegalArgumentException("Invalid parameters for SHOW.");
            }
        // COMMANDO LOOKUP
        }else if(values[0].equals("LOOKUP") && values.length == 3) {
            if (values[1].equals("STUDENT") && school.isValidStudentId(values[2])) {
                executeCommandLookUpStudent(values[2]);
            } else if (values[1].equals("COURSE") && school.isValidCourseId(values[2])) {
                executeCommandLookUpCourse(values[2]);
            } else if (values[1].equals("TEACHER") && school.isValidTeacherId(values[2])) {
                executeCommandLookUpTeacher(values[2]);
            } else {
                throw new IllegalArgumentException("Invalid parameters for LOOKUP");
            }
        }else{
            throw new IllegalArgumentException("Invalid Command.");
        }
        //return sanitize;
    }

    private void executeCommandLookUpTeacher(String teacherId) {
        // GET TEACHER
        for (int i = 0; i < school.getTeacherList().size(); i++){
            if(school.getTeacherList().get(i).getTeacherId().equals(teacherId)){
                // TEACHER FOUND
                System.out.println(school.getTeacherList().get(i).toString());
                break;
            }
        }
    }

    private void executeCommandLookUpCourse(String courseId) {
        // GET COURSE
        for (int i = 0; i < school.getCourseList().size(); i++){
            if(school.getCourseList().get(i).getCourseId().equals(courseId)){
                // COURSE FOUND
                System.out.println(school.getCourseList().get(i).toString());
                break;
            }
        }
    }

    private void executeCommandLookUpStudent(String studentId) {
        // GET STUDENT
        for (int i = 0; i < school.getStudentList().size(); i++){
            if(school.getStudentList().get(i).getStudentId().equals(studentId)){
                // STUDENT FOUND
                System.out.println(school.getStudentList().get(i).toString());
                break;
            }
        }
    }

    private void executeCommandShow(String element) {
        if(element.equals("STUDENTS")){
            System.out.println(school.getStudentList());
        }else if(element.equals("TEACHERS")){
            System.out.println(school.getTeacherList());
        }else if(element.equals("COURSES")){
            System.out.println(school.getCourseList());
        }else{ // PROFIT
            double a = 0;
            double b = 0;
            for(Course c: school.getCourseList()){
                a+=c.getMoney_earned();
            }
            for(Teacher t: school.getTeacherList()){
                b+=t.getSalary();
            }
            double res = a - b;
            System.out.println("The total profit of the School is: "+res);
        }
    }

    private void executeCommandAssign(String teacherId, String courseId) {
        List<Teacher> list = school.getTeacherList();
        List<Course> list2 = school.getCourseList();
        Teacher teacher = new Teacher("a",1);
        Course course = new Course("c",1);
        // GET TEACHER
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getTeacherId().equals(teacherId)){
                // TEACHER FOUND
                teacher = list.get(i);
                break;
            }
        }
        for(int i = 0; i < list2.size(); i++){
            if(list2.get(i).getCourseId().equals(courseId)){
                course = list2.get(i);
                course.setTeacher(teacher);
                list2.set(i,course);
                break;
            }
        }
        school.setCourseList(list2);
    }

    private void executeCommandEnroll(String studentId, String courseId) {
        List<Student> list = school.getStudentList();
        List<Course> list2 = school.getCourseList();
        Course course = new Course("c",1);
        Student student = new Student("a","a","a");
        for(int i = 0; i < list2.size(); i++){
            if(list2.get(i).getCourseId().equals(courseId)){
                course = list2.get(i);
                course.setMoney_earned(course.getMoney_earned()+course.getPrice());
                list2.set(i,course);
                break;
            }
        }
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getStudentId().equals(studentId)){
               // STUDENT FOUND
               student = list.get(i);
               student.setCourse(course);
               list.set(i,student);
               break;
            }
        }
        school.setCourseList(list2);
        school.setStudentList(list);
    }

    private void executeCommand(String args) {
        System.out.println("The following command will be executed: " + args);
    }
}
