package com.ironhack;

import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        this.teacherId = autoTeacherId();
        this.name = name;
        this.salary = salary;
    }

    // Auto-generated teacherId method
    private String autoTeacherId() {
//        return "T-" + UUID.randomUUID().toString().substring(0, 3); // T-XXX
        Main.teacherId++;
        return "C-" + Main.teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
