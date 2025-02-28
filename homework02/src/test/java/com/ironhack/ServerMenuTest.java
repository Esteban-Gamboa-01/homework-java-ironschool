package com.ironhack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ServerMenuTest {

    @BeforeAll
    public static void setUp() {
        Main list = new Main();
        Student student01 = new Student("Maria","Calle Colon", "maria@gmail.com");
        Main.studentList.add(student01);
    }

    @Test
    void sanitize_Incorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            ServerMenu test01 = new ServerMenu();
            test01.sanitize("Enroll Show C4 D3");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            ServerMenu test01 = new ServerMenu();
            test01.sanitize("Enroll");
        });
    }

    @Test
    void isValidStudentId_NotExist(){
        ServerMenu test02 = new ServerMenu();

        assertFalse(test02.isValidStudentId("S2"));
    }

    @Test
    void isValidStudentId_Correct(){

        ServerMenu test03 = new ServerMenu();

        assertTrue(test03.isValidStudentId("S1"));
    }
}