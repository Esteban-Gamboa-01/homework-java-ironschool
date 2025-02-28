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

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    // Auto-generated teacherId method
    private String autoTeacherId() {
//        return "T-" + UUID.randomUUID().toString().substring(0, 3); // T-XXX
        Main.teacherId++;
        return "T" + Main.teacherId;
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

        return "  ||=|=|=|=|=| |  __..\\/ |  |_|  ||#||  |\n" +
                        "  || | | | | |   /\\ \\  \\\\|++|=|  ||#||  |            TEACHER\n" +
                        "  ||_|_|_|_|_|__/_/\\_.___\\__|_|__||_||__|            "+name+"\n" +
                        "  |___________ /\\~()/()~//\\ ____________|\n" +
                        "  | __   __    \\_  (_ .  _/ _    _ _ _ _|         Salary: "+salary+" $\n" +
                        "  ||~~|_|..| _   \\ //\\\\ /  |=|__|~|~| | |        \n" +
                        "  ||--|+|^^|| |__/\\ __ /\\__| |==|x|x| | |        \n" +
                        "  ||__|_|__|| /  \\ \\  / /  \\_|__|_|_|_|_|            ID: '"+teacherId+"'\n" +
                        "  |________ _/    \\/\\/\\/    \\_ _________|              \n" +
                        "  | _____  |/      \\../      \\|  __  ___|\n";
    }
}
