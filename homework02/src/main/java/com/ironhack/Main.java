package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // For auto generated IDs
    public static int courseId = 0;
    public static int studentId = 0;
    public static int teacherId = 0;

    public static void main(String[] args) {
        //Menu

        List<Student> studentsList = new ArrayList<>();
        List<Course> coursesList = new ArrayList<>();
        List<Teacher> teachersList = new ArrayList<>();

        Student student1 = new Student("Diego", "Madrid", "diego@mail.com");
        Student student2 = new Student("David", "Murcia", "dvd@mail.com");
        studentsList.add(student1);
        studentsList.add(student2);

        Teacher teacher1 = new Teacher("Alice", 1400);
        Teacher teacher2 = new Teacher("Bob", 1300);
        teachersList.add(teacher1);
        teachersList.add(teacher2);

        Course javaCourse = new Course("Java", 500);
        Course pythonCourse = new Course("Python", 600);
        coursesList.add(javaCourse);
        javaCourse.setTeacher(teacher1);
        javaCourse.setMoneyEarned(2000);
        student1.setCourse(javaCourse);

        coursesList.add(pythonCourse);
        pythonCourse.setMoneyEarned(3200);
        pythonCourse.setTeacher(teacher2);
        student2.setCourse(pythonCourse);

        CommandFunction commandFunction = new CommandFunction(coursesList, studentsList, teachersList);

        System.out.println(commandFunction.showCourses());
//        commandFunction.showCourses();

        System.out.println(commandFunction.lookupStudent("C-1"));
//        commandFunction.lookupStudent("C-2");

        System.out.println(commandFunction.showProfit());
        commandFunction.showProfit();
    }
}