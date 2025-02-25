package com.ironhack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServerMenu {

    public void showMenu(){
        System.out.println("\nFantastic! All data introduced is correct. Then, we provide a command list" +
                "for managing or adding a new information.");
        System.out.println("\nCOMMAND LIST: ");
        System.out.println(
                "- ENROLL [STUDENT_ID] [COURSE_ID]                  Example: ENROLL S3 C6" +
                "\n- ASSIGN [TEACHER_ID] [COURSE_ID]                  Example: ASSIGN T2 C3" +
                "\n- SHOW COURSES" +
                "\n- LOOKUP COURSE [COURSE_ID]                        Example: LOOKUP COURSE C8" +
                "\n- SHOW STUDENTS" +
                "\n- LOOKUP STUDENT [STUDENT_ID]                      Example: LOOKUP STUDENT S5" +
                "\n- SHOW TEACHERS" +
                "\n- LOOKUP TEACHER [TEACHER_ID]                      Example: LOOKUP STUDENT T10" +
                "\n- SHOW PROFIT");
    }

    public void selectCommand() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        //No used
        //String[] firstKeyWord = {"SHOW", "LOOKUP", "ENROLL", "ASSIGN"};
        //String[] secondKeyWord = {"COURSES", "STUDENTS", "TEACHERS"};
        String selectCommand;

        System.out.println("Select an options to consult:");
        selectCommand = scanner.nextLine();
        selectCommand = selectCommand.toUpperCase();

        String[] wordToWord = selectCommand.split(" ");
        List<String> onlyWord = new ArrayList<>();

        for (int i = 0; i<wordToWord.length; i++){
            boolean containSpace = false;
            boolean isEmptyString = false;

            containSpace = wordToWord[i].contains(" ");
            isEmptyString = wordToWord[i].equals("");

            if(!(containSpace || isEmptyString)){
                onlyWord.add(wordToWord[i]);
            }
        }

        CommandFunction command = new CommandFunction();

        if(onlyWord.get(0).equals("SHOW")){
            if(onlyWord.size()!=2){
               throw new IllegalArgumentException();
            }else if(onlyWord.get(1).equals("PROFIT")){

                //COMMAND
                command.showProfit();

            }else if(onlyWord.get(1).equals("COURSES")){

                //COMMAND
                command.showCourses();

            }else if(onlyWord.get(1).equals("STUDENTS")){

                //COMMAND
                command.showStudents();

            }else if(onlyWord.get(1).equals("TEACHERS")){

                //COMMAND
                command.showTeachers();

            }else{
                throw new IllegalArgumentException();
            }

        }else if(onlyWord.get(0).equals("LOOKUP")){
            if(onlyWord.size()!=3){
                throw new IllegalArgumentException();
            }else if(onlyWord.get(1).equals("COURSE")){
                boolean letterC = onlyWord.get(2).charAt(0)=='C';
                boolean isNumber = onlyWord.get(2).substring(1).matches("\\d+");
                if(letterC && isNumber){

                    //COMMAND
                    command.lookupCourse(onlyWord.get(2));

                }else{
                    throw new IllegalArgumentException();
                }
            }else if(onlyWord.get(1).equals("STUDENT")){
                boolean letterS = onlyWord.get(2).charAt(0)=='S';
                boolean isNumber = onlyWord.get(2).substring(1).matches("\\d+");
                if(letterS && isNumber){

                    //COMMAND
                    command.lookupStudent(onlyWord.get(2));

                }else{
                    throw new IllegalArgumentException();
                }
            }else if(onlyWord.get(1).equals("TEACHER")){
                boolean letterT = onlyWord.get(2).charAt(0)=='T';
                boolean isNumber = onlyWord.get(2).substring(1).matches("\\d+");
                if(letterT && isNumber){

                    //COMMAND
                    command.lookupTeacher(onlyWord.get(2));

                }else{
                    throw new IllegalArgumentException();
                }
            }else{
                throw new IllegalArgumentException();
            }

        }else if(onlyWord.get(0).equals("ENROLL")){
            boolean letterS = onlyWord.get(1).charAt(0)=='S';
            boolean isNumberToS = onlyWord.get(1).substring(1).matches("\\d+");
            boolean letterC = onlyWord.get(2).charAt(0)=='C';
            boolean isNumberToC = onlyWord.get(2).substring(1).matches("\\d+");
            if(onlyWord.size()!=3){
                throw new IllegalArgumentException();
            }else if(letterS && isNumberToS && letterC && isNumberToC){

                //COMMAND
                command.enroll(onlyWord.get(1),onlyWord.get(2));

            }else{
                throw new IllegalArgumentException();
            }

        }else if(onlyWord.get(0).equals("ASSIGN")){
            boolean letterT = onlyWord.get(1).charAt(0)=='T';
            boolean isNumberToT = onlyWord.get(1).substring(1).matches("\\d+");
            boolean letterC = onlyWord.get(2).charAt(0)=='C';
            boolean isNumberToC = onlyWord.get(2).substring(1).matches("\\d+");
            if(onlyWord.size()!=3){
                throw new IllegalArgumentException();
            }else if(letterT && isNumberToT && letterC && isNumberToC){

                //COMMAND
                command.assign(onlyWord.get(1),onlyWord.get(2));

            }else{
                throw new IllegalArgumentException();
            }

        }else{
            throw new IllegalArgumentException();
        }



    }


}
