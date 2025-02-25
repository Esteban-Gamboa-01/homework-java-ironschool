package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandFunctionTest {

    private CommandFunction commandFunction;
    private List<Course> courseList;
    private List<Teacher> teacherList;
    private List<Student> studentList;

    @BeforeEach
    public void setUp() {
        courseList = new ArrayList<>();
        teacherList = new ArrayList<>();
        studentList = new ArrayList<>();

        Student student1 = new Student("Diego", "Madrid", "diego@mail.com");
        student1.setCourse(new Course("Math", 200));
        Student student2 = new Student("David", "Murcia", "dvd@mail.com");
        student2.setCourse(new Course("Programming", 300));
        studentList.add(student1);
        studentList.add(student2);

//        Teacher teacher1 = new Teacher("Alice", 1400);
//        Teacher teacher2 = new Teacher("Bob", 1300);
//        teacherList.add(teacher1);
//        teacherList.add(teacher2);
//
//        Course javaCourse = new Course("Java", 500);
//        Course pythonCourse = new Course("Python", 600);
//        courseList.add(javaCourse);
//        courseList.add(pythonCourse);

        commandFunction = new CommandFunction(courseList, studentList, teacherList);

    }

    // SHOW COURSES Command Test
    @Test
    public void testShowCourses_WithCourses() {
        Teacher teacher1 = new Teacher("Alice", 400);

        Course javaCourse = new Course("Java", 500);
        javaCourse.setTeacher(teacher1);
        Course pythonCourse = new Course("Python", 600);
        pythonCourse.setTeacher(teacher1);
        courseList.add(javaCourse);
        courseList.add(pythonCourse);

        String courses = commandFunction.showCourses();

        assertTrue(courses.contains("Java"));
        assertTrue(courses.contains("Python"));
    }

    // LOOK UP STUDENT Command Tests
    @Test
    void lookupStudent_Found() {
        String student = commandFunction.lookupStudent("C-1");

        assertTrue(student.contains("Diego"));
    }

    @Test
    public void lookupStudent_notFound() {
        String student = commandFunction.lookupStudent("C-5");

        assertEquals("Not Found student with ID ( C-5 ).", student);
    }

    // SHOW PROFIT Command Tests
    @Test
    void showProfit_noCoursesNoTeachers_zeroProfit() {
        assertEquals(0, commandFunction.showProfit());
    }

    @Test
    void showProfit_coursesEarnMoney_teachersHaveSalary_correctProfit() {
        Teacher teacher1 = new Teacher("Alice", 400);
        Teacher teacher2 = new Teacher("Bob", 200);
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        Course javaCourse = new Course("Java", 500);
        javaCourse.setMoneyEarned(500);
        Course pythonCourse = new Course("Python", 600);
        pythonCourse.setMoneyEarned(300);

        courseList.add(javaCourse);
        courseList.add(pythonCourse);

        // (500+300) - (400+200) = 200
        assertEquals(200, commandFunction.showProfit());
    }

    @Test
    void showProfit_teachersEarnMoreThanCourses_negativeProfit() {
        Teacher teacher1 = new Teacher("Alice", 1400);
        Teacher teacher2 = new Teacher("Bob", 1200);
        teacherList.add(teacher1);
        teacherList.add(teacher2);

        Course javaCourse = new Course("Java", 500);
        javaCourse.setMoneyEarned(500);
        Course pythonCourse = new Course("Python", 600);
        pythonCourse.setMoneyEarned(300);

        courseList.add(javaCourse);
        courseList.add(pythonCourse);

        // (500+300) - (1400+1200) = -1800
        assertEquals(-1800, commandFunction.showProfit());
    }
}