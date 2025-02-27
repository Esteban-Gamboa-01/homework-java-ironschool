package com.ironhack;

import java.util.Scanner;

public class InitialMenu {
    Scanner scanner = new Scanner(System.in);
    String nameSchool;
    int numberTeacher;
    int numberCourse;
    int numberStudent;

    public void startMenu(){
        showArt();
//        System.out.println("What is the school name?");
        System.out.println(Style.BOLD + "What is the " + Style.UNDERLINE+Style.SCHOOL + "school" + Style.RESET+Style.BOLD + " name?" + Style.RESET);
        nameSchool = scanner.nextLine();
        System.out.println(Style.SUCCESS_BG+Style.BOLD + " Ok! Welcome to the " + Style.SCHOOL + nameSchool + Style.RESET+Style.SUCCESS_BG+Style.BOLD + "! " + Style.RESET);
    }

    public void numberTeacher() throws IllegalArgumentException{
        System.out.println("\nAnd how many " + Style.BOLD+Style.UNDERLINE+Style.TEACHER + "teachers" + Style.RESET + " are going to be contracted?");
        numberTeacher = scanner.nextInt();
        System.out.println(Style.SUCCESS_BG+Style.BOLD +" Ok! Then, " + Style.TEACHER + numberTeacher + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " teacher/s will " +
                "work at the " + Style.SCHOOL + nameSchool + Style.RESET+Style.SUCCESS_BG+Style.BOLD + ". " + Style.RESET);
    }

    public void createTeacher() throws IllegalArgumentException{
        int counter;
        String nameTeacher;
        double salaryTeacher;
        Teacher auxiliarTeacher;

        System.out.println("\nNow, add the features and properties of each teacher.");

        for(counter = 1; counter <= numberTeacher; counter++){
            System.out.println(Style.BOLD+Style.TEACHER + "\nTeacher "+ counter + Style.RESET +
                    ": Fill in the following data. " +
                    Style.BOLD + "Firstly" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "name" + Style.RESET + ". " +
                    Style.BOLD + "Secondly" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "salary" + Style.RESET + ".");
            nameTeacher = scanner.next();
            //salaryTeacher must be scanner.nextDouble, but there is a bug. I have find this code line.
            salaryTeacher = Double.parseDouble(scanner.next());
            //scanner.nextLine();
            //salaryTeacher = scanner.nextDouble();
            System.out.println(Style.SUCCESS_BG+Style.BOLD + " Ok! Teacher " + counter + Style.RESET+Style.SUCCESS_BG+Style.BOLD + ": " +
                    Style.TEACHER + nameTeacher + Style.RESET+Style.SUCCESS_BG+Style.BOLD +
                    ". Salary: " + Style.SALARY + salaryTeacher + " " + Style.RESET);

            auxiliarTeacher = new Teacher(nameTeacher, salaryTeacher);
            Main.teacherList.add(auxiliarTeacher);
        }
    }

    public void numberCourse() throws IllegalArgumentException{
        System.out.println(Style.BOLD + "\nHow many " + Style.UNDERLINE+Style.COURSE + "courses" + Style.RESET+Style.BOLD + " are there?" + Style.RESET);
        numberCourse = scanner.nextInt();
        System.out.println(Style.SUCCESS_BG+Style.BOLD + " Ok! Then, " + Style.COURSE + numberCourse + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " course/s there will " +
                "be at the " + Style.SCHOOL + nameSchool + Style.RESET+Style.SUCCESS_BG+Style.BOLD + ". " + Style.RESET);
    }

    public void createCourse() throws IllegalArgumentException{
        int counter;
        String nameCourse;
        double priceCourse;
        Course auxiliarCourse;

        System.out.println("\nNow, add the features of each course.");

        for(counter = 1; counter <= numberCourse; counter++){
            System.out.println(Style.BOLD+Style.COURSE + "\nCourse "+ counter + Style.RESET +
                    ": Fill in the following data. " +
                    Style.BOLD + "Firstly" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "name" + Style.RESET + ". " +
                    Style.BOLD + "Secondly" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "price" + Style.RESET + ".");
            nameCourse = scanner.next();
            //priceCourse must be scanner.nextDouble, but there is a bug. I have find this code line.
            priceCourse = Double.parseDouble(scanner.next());
            //priceCourse = scanner.nextInt();
            System.out.println(Style.SUCCESS_BG+Style.BOLD + " Ok! " + Style.BOLD + "Course " + counter + Style.RESET+Style.SUCCESS_BG+Style.BOLD + ": " +
                    Style.COURSE + nameCourse + Style.RESET+Style.SUCCESS_BG+Style.BOLD +
                    ". Price: " + Style.SALARY + priceCourse + " " + Style.RESET);

            auxiliarCourse = new Course(nameCourse, priceCourse);
            Main.courseList.add(auxiliarCourse);
        }
    }

    public void numberStudent() throws IllegalArgumentException{
        System.out.println(Style.BOLD + "\nHow many " + Style.UNDERLINE+Style.STUDENT + "students" + Style.RESET+Style.BOLD + " are inscribed?" + Style.RESET);
        numberStudent = scanner.nextInt();
        System.out.println(Style.SUCCESS_BG+Style.BOLD + " Ok! Then, " + Style.STUDENT + numberStudent + Style.RESET+Style.SUCCESS_BG+Style.BOLD + " student/s are inscribed " +
                "at the " + Style.SCHOOL + nameSchool + Style.RESET+Style.SUCCESS_BG + ". " + Style.RESET);
    }

    public void createStudent(){
        int counter;
        String nameStudent;
        String addressStudent;
        String emailStudent;
        Student auxiliarStudent;

        System.out.println("\nNow, add the features of each student.");

        for(counter = 1; counter <= numberStudent; counter++){
            System.out.println(Style.BOLD+Style.STUDENT + "\nStudent "+ counter + Style.RESET +
                    ": Fill in the following data. " +
                    Style.BOLD + "Firstly" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "name" + Style.RESET + ". " +
                    Style.BOLD + "Secondly" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "address" + Style.RESET + ". " +
                    Style.BOLD + "Finally" + Style.RESET + ", introduce the " + Style.BOLD+Style.UNDERLINE + "email" + Style.RESET + ".");
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

            System.out.println(Style.SUCCESS_BG+Style.BOLD + " Ok! Student " + counter + ": " +
                    Style.STUDENT + nameStudent + Style.RESET+Style.SUCCESS_BG+Style.BOLD +
                    ". Address: " + Style.STUDENT + addressStudent + Style.RESET+Style.SUCCESS_BG+Style.BOLD +
                   ". Email: " + Style.STUDENT + emailStudent + Style.RESET+Style.SUCCESS_BG+Style.BOLD + ". " + Style.RESET);

            Main.studentList.add(auxiliarStudent);
        }

    }

    private void showArt() {
        String art =
                "                                               /\\      /\\\n" +
                        "                                               ||______||\n" +
                        "                                               || ^  ^ ||\n" +
                        "                                               \\| |  | |/\n" +
                        "                                                |______|\n" +
                        "              __                                |  __  |\n" +
                        "             /  \\       ________________________|_/  \\_|__\n" +
                        "            / ^^ \\     /=========================/ ^^ \\===|\n" +
                        "           /  []  \\   /=========================/  []  \\==|\n" +
                        "          /________\\ /=========================/________\\=|\n" +
                        "       *  |        |/==========================|        |=|\n" +
                        "      *** | ^^  ^^ |---------------------------| ^^  ^^ |--\n" +
                        "     *****| []  [] |        IRON SCHOOL        | []  [] | |\n" +
                        "     *****| []  [] |           _____           | []  [] | |\n" +
                        "    *******        |          /_____\\          |      * | |\n" +
                        "   *********^^  ^^ |  ^^  ^^  |  |  |  ^^  ^^  |     ***| |\n" +
                        "  ***********]  [] |  []  []  |  |  |  []  []  | ===***** |\n" +
                        " *************     |         @|__|__|@         |/ |*******|\n" +
                        "***************   ***********--=====--**********| *********\n" +
                        "***************___*********** |=====| **********|***********\n" +
                        " *************     ********* /=======\\ ******** | *********\n";
        System.out.println(art);
    }
}
