package com.ironhack;

import java.util.UUID;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    public Course() {
    }

    public Course(String name, double price) {
        this.courseId = generateCourseId();
        this.name = name;
        this.price = price;
        this.moneyEarned = 0;
        this.teacher = null; //If there's no assigned teacher
    }

    private String generateCourseId() {
//        return "C-" + UUID.randomUUID().toString().substring(0, 3); // C-XXX
        Main.courseId++;
        return "C" + Main.courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", moneyEarned=" + moneyEarned +
                ", teacher=" + teacher.getName() +
                '}';
    }
}
