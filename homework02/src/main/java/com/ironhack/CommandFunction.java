package com.ironhack;

public class CommandFunction {

    public static boolean sanitize(String args){
        boolean sanitize = false;
        String values[] = args.split( " ");
        if (values.length > 3) throw new IllegalArgumentException();
        if (values.length < 2) throw new IllegalArgumentException();
        if (values[0].equals("ENROLL") || values[0].equals("ASSIGN") || values[0].equals("SHOW") || values[0].equals("LOOKUP")){
            // VAMOS BIEN

        }
        return sanitize;
    }
}
