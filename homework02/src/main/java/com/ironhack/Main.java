package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int global_int = 0;
    public static int global_course_id = 0;
    public static int global_student_id = 0;
    public static List<Teacher> teacherList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();
    public static List<Course> courseList = new ArrayList<>();


    public static void main(String[] args) {
        //Menu
        // Testing branch maindev01
        Teacher john = new Teacher("John",23_000);
        Teacher jane = new Teacher("Jane",24_000);
        Course math = new Course("Mathematics",125.5);
        Course art = new Course("Art",38.6);
        Student johny = new Student("Johnny","Bellville Avenue","j@example.com");
        Student janey = new Student("Janey","Lakeside Boulevard","ja@example.com");
        System.out.println(john.getTeacherId());
        System.out.println(jane.getTeacherId());
        System.out.println(math.getCourseId());
        System.out.println(art.getCourseId());
        System.out.println(johny.getStudentId());
        System.out.println(janey.getStudentId());

        teacherList.add(john);
        teacherList.add(jane);
        studentList.add(johny);
        studentList.add(janey);
        courseList.add(math);
        courseList.add(art);


        CommandFunction command = new CommandFunction();
        boolean res = true;
        do{
            res = serverMenu.getUserCommand();
        }while(res);
    }
}