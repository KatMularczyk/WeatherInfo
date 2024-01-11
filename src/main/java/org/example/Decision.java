package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decision {
    private int i=1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    Scanner in = new Scanner(System.in);
    public Decision(){
    }

    public String start(){
        System.out.print("Enter the city");
        //get the input - city name
        String input = in.nextLine();
        return input;
    }

    public void question(){
        System.out.println("Do you want to continue? y/n");
        String userDecision = in.nextLine();
        while(!(userDecision.equalsIgnoreCase("n")|userDecision.equalsIgnoreCase("y"))){
            System.out.println("Do you want to continue? y/n");
            userDecision = in.nextLine();
        }
        if(userDecision.equalsIgnoreCase("n")){
            i=0;
        }
    }



}
