package com.ironhack;

import java.util.regex.Pattern;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email = "";
    private Course course;

    public Student(String name, String address, String email) {
        this.studentId = "S" + Main.counterStudent++;
        this.name = name;
        this.address = address;
        this.email = email;
        this.course=null;
    }



//    Delete comment. This is for auto-generate the id.
//    Student myStudent1 = new Student("Ernest","we","wedfv");
//    Student myStudent2 = new Student("Erest","we34r","wsdedfv");
//
//        System.out.println(myStudent1.getStudentId());
//        System.out.println(myStudent2.getStudentId());

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    //Code Fernando
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        String courseText;
        try{
            courseText = this.course.getName();
        } catch (Exception e) {
            courseText = "assignment pending";
        }
        return "      /b_,dM\\__,_\n" +
                        "   _YMMMMMMMMMMMM(            STUDENT\n" +
                        "  `MMMMMM/   /   \\        "+name+"\n" +
                        "   MMM|  __  / __/         \n" +
                        "   YMM/_/# \\__/# \\      Lives at: "+address+"\n" +
                        "   (.   \\__/  \\__/         Email: "+email+" \n" +
                        "     )       _,  |   Enrolled in: "+ courseText +"\n" +
                        "_____/\\     _   /                   \n" +
                        "    \\  `._____,           STUDENT ID: "+studentId+" \n"+
                        "     `..___(__\n";
    }
}
