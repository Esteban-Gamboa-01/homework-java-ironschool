package com.ironhack;

import java.util.UUID;
import java.util.regex.Pattern;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;


    public Student(String name, String address, String email) {
        this.studentId = autoStudentId();
        this.name = name;
        this.address = address;
//        this.email = email;
        setEmail(email);
//        this.course = null;
    }

    // Auto-generated teacherId method
    private String autoStudentId() {
//        return "S-" + UUID.randomUUID().toString().substring(0, 3); // S-XXX
        Main.studentId++;
        return "C-" + Main.studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    // Set email with validation
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format. Please use a valid format like 'example@mail.com'.");
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", course=" + course.getName() +
                '}';
    }
}
