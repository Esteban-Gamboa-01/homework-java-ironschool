package com.ironhack;

public class Teacher {
    private String teacherId; //AUTO GEN
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.teacherId = "t" + Main.global_int;
        Main.global_int++;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
