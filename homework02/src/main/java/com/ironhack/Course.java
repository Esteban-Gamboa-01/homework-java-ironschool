package com.ironhack;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

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
        String teacherText;
        try{
            teacherText = this.teacher.getName();
        } catch (Exception e) {
            teacherText = "assignment pending";
        }

        return "(\\ \n" +
                        "\\'\\         "+name+"\n" +
                        " \\'\\     __________      By: "+ teacherText +"   \n" +
                        " / '|   ()_________)     Price: "+price+" $\n" +
                        " \\ '/    \\ ~~~~~~~~ \\    MoneyEarned: "+moneyEarned+" $ \n" +
                        "   \\       \\ ~~~~~~   \\         \n" +
                        "   ==).      \\__________\\      ID: '"+courseId+"'\n" +
                        "  (__)       ()__________)\n";
    }
}
