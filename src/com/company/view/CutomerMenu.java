package com.company.view;

import java.util.Scanner;

public class CutomerMenu {
    Scanner scannerForInt = new Scanner(System.in);
    Scanner scannerForString = new Scanner(System.in);

    public int mainMenu (){
        System.out.println("\nWelcome to our cinema!\n" +
                "What do you want to do?");
        System.out.println("1. Show all Movies");
        System.out.println("2. Show timetable");
        System.out.println("3. Show all shows of one film");
        System.out.println("4. Choose show and reserve tickets");
        System.out.println("5. quit the program");

        return scannerForInt.nextInt();
    }

    public int chooseFilm (){
        System.out.println("Which film are you interested in? Enter the ID.");
        return scannerForInt.nextInt();
    }

    public int chooseShow (){
        System.out.println("Choose a show and enter the show-ID.");
        return scannerForInt.nextInt();
    }

    public int chooseAmountTickts (){
        System.out.println("How many tickets do you wish to reserve?");
        return scannerForInt.nextInt();
    }

    public void farewell (){
        System.out.println("Thank you and good bye.");
    }


}
