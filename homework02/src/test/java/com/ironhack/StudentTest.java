package com.ironhack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    // Constructor
    @Test
    void student_validEmail_createStudent() {
        Student student = new Student("Test Student", "City", "test@mail.com");

        assertEquals("test@mail.com", student.getEmail());
    }

    // Set Method
    @Test
    void setEmail_validEmail_correctSetEmail() {
        Student student = new Student("Test Student", "City", "test@mail.com");

        student.setEmail("valid@mail.com");

        assertEquals("valid@mail.com", student.getEmail());
    }

    @Test
    void setEmail_invalidEmail_throwException() {
        Student student = new Student("Test Student", "City", "test@mail.com");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("invalid-email.com");
        });

        assertEquals("Invalid email format. Please use a valid format like 'example@mail.com'.", e.getMessage());
    }

    @Test
    void setEmail_emptyEmail_throwException() {
        Student student = new Student("Test Student", "City", "test@mail.com");

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            student.setEmail("");
        });

        assertEquals("Invalid email format. Please use a valid format like 'example@mail.com'.", e.getMessage());
    }

}