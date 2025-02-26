package com.ironhack;

import java.util.Scanner;

public class InitialMenu {
    Scanner scanner = new Scanner(System.in);
    String nameSchool;
    int numberTeacher;
    int numberCourse;
    int numberStudent;

    public void startMenu(){
        System.out.println("What is the school name?");
        nameSchool = scanner.nextLine();
        System.out.println("Ok! Welcome to the " + nameSchool +"!");
    }

    public void numberTeacher() throws IllegalArgumentException{
        System.out.println("\nAnd how many teachers are going to be contracted?");
        numberTeacher = scanner.nextInt();
        System.out.println("Ok! Then, " + numberTeacher + " teacher/s will " +
                "work at the " + nameSchool +".");
    }

    public void createTeacher() throws IllegalArgumentException{
        int counter;
        String nameTeacher;
        double salaryTeacher;
        Teacher auxiliarTeacher;

        System.out.println("\nNow, add the features and properly of each teacher.");

        for(counter = 1; counter <= numberTeacher; counter++){
            System.out.println("\nTeacher "+ counter +": Fill in the following data. Firstly, introduce the name." +
                    "Secondly, introduce the salary.");
            nameTeacher = scanner.next();
            //salaryTeacher must be scanner.nextDouble, but there is a bug. I have find this code line.
            salaryTeacher = Double.parseDouble(scanner.next());
            //scanner.nextLine();
            //salaryTeacher = scanner.nextDouble();
            System.out.println("Ok! Teacher " + counter + ": "+nameTeacher+". Salary: "+salaryTeacher);

            auxiliarTeacher = new Teacher(nameTeacher, salaryTeacher);
            Main.teacherList.add(auxiliarTeacher);
        }
    }

    public void numberCourse() throws IllegalArgumentException{
        System.out.println("\nHow many courses are there?");
        numberCourse = scanner.nextInt();
        System.out.println("Ok! Then, " + numberCourse + " course/s there will " +
                "be at the " + nameSchool +".");
    }

    public void createCourse() throws IllegalArgumentException{
        int counter;
        String nameCourse;
        double priceCourse;
        Course auxiliarCourse;

        System.out.println("\nNow, add the features of each course.");

        for(counter = 1; counter <= numberCourse; counter++){
            System.out.println("\nCourse "+ counter +": Fill in the following data. Firstly, introduce the name." +
                    "Secondly, introduce the price.");
            nameCourse = scanner.next();
            //priceCourse must be scanner.nextDouble, but there is a bug. I have find this code line.
            priceCourse = Double.parseDouble(scanner.next());
            //priceCourse = scanner.nextInt();
            System.out.println("Ok! Course " + counter + ": "+nameCourse+". Price: "+priceCourse);

            auxiliarCourse = new Course(nameCourse, priceCourse);
            Main.courseList.add(auxiliarCourse);
        }
    }

    public void numberStudent() throws IllegalArgumentException{
        System.out.println("\nHow many students are inscribed?");
        numberStudent = scanner.nextInt();
        System.out.println("Ok! Then, " + numberStudent + " student/s are inscribed " +
                "at the " + nameSchool +".");
    }

    public void createStudent(){
        int counter;
        String nameStudent;
        String addressStudent;
        String emailStudent;
        Student auxiliarStudent;

        System.out.println("\nNow, add the features of each student.");

        for(counter = 1; counter <= numberStudent; counter++){
            System.out.println("\nCourse "+ counter +": Fill in the following data. Firstly, introduce the name." +
                    "Secondly, introduce the address. Finally, introduce the email.");
            nameStudent = scanner.next();
            scanner.nextLine();
            addressStudent = scanner.nextLine();
            emailStudent = scanner.next();
            scanner.nextLine();

            auxiliarStudent = new Student(nameStudent, addressStudent,emailStudent);
            //This line is for proving that email format is correct
            try{
                auxiliarStudent.setEmail(emailStudent);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("Ok! Student " + counter + ": "+nameStudent+". Address: " + addressStudent +
                   ". Email: " + emailStudent +".");

            Main.studentList.add(auxiliarStudent);
        }

    }





}
