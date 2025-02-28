package com.ironhack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandFunctionTest {

    private CommandFunction commandFunction;
//    private List<Course> courseList;
//    private List<Teacher> teacherList;
//    private List<Student> studentList;

    @BeforeEach
    public void setUp() {
//        courseList = new ArrayList<>();
//        teacherList = new ArrayList<>();
//        studentList = new ArrayList<>();

        Student student1 = new Student("Diego", "Madrid", "diego@mail.com");
        student1.setStudentId("S33");
        student1.setCourse(new Course("Math", 200));
        Student student2 = new Student("David", "Murcia", "dvd@mail.com");
        student2.setCourse(new Course("Programming", 300));
        Main.studentList.add(student1);
        Main.studentList.add(student2);

//        Teacher teacher1 = new Teacher("Alice", 1400);
//        Teacher teacher2 = new Teacher("Bob", 1300);
//        teacherList.add(teacher1);
//        teacherList.add(teacher2);
//
//        Course javaCourse = new Course("Java", 500);
//        Course pythonCourse = new Course("Python", 600);
//        courseList.add(javaCourse);
//        courseList.add(pythonCourse);

        commandFunction = new CommandFunction();

    }

    @AfterEach
    public void tearDown(){
        Main.courseList = new ArrayList<>();
        Main.teacherList= new ArrayList<>();
        Main.studentList = new ArrayList<>();

    }
    // ENROLL & ASSIGM Command Test
    @Test
    public void assignCommand_validInput_teacherAssigned(){
        Teacher teacher1 = new Teacher("Alice", 400);
        teacher1.setTeacherId("T10");
        Main.teacherList.add(teacher1);
        Course javaCourse = new Course("Java", 500);
        javaCourse.setCourseId("C55");
        Main.courseList.add(javaCourse);
        commandFunction.assign("T10","C55");
        assertEquals("Alice",Main.courseList.get(0).getTeacher().getName());
    };

    @Test
    public void enrollCommand_validInput_studentEnrolled(){
        Course javaCourse = new Course("Java", 500);
        javaCourse.setCourseId("C30");
        Main.courseList.add(javaCourse);
        Student student = new Student("John", "City", "test@mail.com");
        student.setStudentId("S75");
        Main.studentList.add(student);
        commandFunction.enroll("S75","C30");
        assertEquals("Java",Main.studentList.get(2).getCourse().getName());
    }
    // SHOW COURSES Command Test
    @Test
    public void testShowCourses_WithCourses() {
        Teacher teacher1 = new Teacher("Alice", 400);

        Course javaCourse = new Course("Java", 500);
        javaCourse.setTeacher(teacher1);
        Course pythonCourse = new Course("Python", 600);
        pythonCourse.setTeacher(teacher1);
        Main.courseList.add(javaCourse);
        Main.courseList.add(pythonCourse);

        String courses = commandFunction.showCoursesTest();

        assertTrue(courses.contains("Java"));
        assertTrue(courses.contains("Python"));
    }

    // LOOK UP STUDENT Command Tests
    @Test
    void lookupStudent_Found() {
        String student = commandFunction.lookupStudentTest("S33");
        System.out.println(Main.studentList);
        assertTrue(student.contains("Diego"));
    }

    @Test
    public void lookupStudent_notFound() {
        String student = commandFunction.lookupStudentTest("S5");
        System.out.println(Main.studentList);
        assertEquals("Not Found student with ID ( S5 ).", student);
    }

    // SHOW PROFIT Command Tests
    @Test
    void showProfit_noCoursesNoTeachers_zeroProfit() {

        Main.courseList = new ArrayList<>();
        Main.teacherList= new ArrayList<>();

        assertEquals(0, commandFunction.showProfitTest());
    }

    @Test
    void showProfit_coursesEarnMoney_teachersHaveSalary_correctProfit() {
        Teacher teacher1 = new Teacher("Alice", 400);
        Teacher teacher2 = new Teacher("Bob", 200);
        Main.teacherList.add(teacher1);
        Main.teacherList.add(teacher2);

        Course javaCourse = new Course("Java", 500);
        javaCourse.setMoneyEarned(500);
        Course pythonCourse = new Course("Python", 600);
        pythonCourse.setMoneyEarned(300);

        Main.courseList.add(javaCourse);
        Main.courseList.add(pythonCourse);

        // (500+300) - (400+200) = 200
        assertEquals(200, commandFunction.showProfitTest());
    }

    @Test
    void showProfit_teachersEarnMoreThanCourses_negativeProfit() {
        Teacher teacher1 = new Teacher("Alice", 1400);
        Teacher teacher2 = new Teacher("Bob", 1200);
        Main.teacherList.add(teacher1);
        Main.teacherList.add(teacher2);

        Course javaCourse = new Course("Java", 500);
        javaCourse.setMoneyEarned(500);
        Course pythonCourse = new Course("Python", 600);
        pythonCourse.setMoneyEarned(300);

        Main.courseList.add(javaCourse);
        Main.courseList.add(pythonCourse);

        // (500+300) - (1400+1200) = -1800
        assertEquals(-1800, commandFunction.showProfitTest());
    }
}