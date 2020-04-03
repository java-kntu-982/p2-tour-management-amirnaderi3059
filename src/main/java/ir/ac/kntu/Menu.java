package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;
import net.sf.saxon.functions.ConstantFunction;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Menu {






    public static Date todayCalculator(){
        Scanner in = new Scanner(System.in);
        System.out.println("enter this year:");
        int year = in.nextInt();
        System.out.println("enter this month");
        int month = in.nextInt();
        System.out.println("enter this day");
        int day = in.nextInt();
        Date date = new Date(year,month,day);
        return date;
    }

    public static void ageOfEveryone(Date date){
        for(int i = 0;i<TourLeader.getTourLeaders().size();i++){
            TourLeader.getTourLeaders().get(i).ageCalculator(date);
        }
    }







    public static void cls() {
        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch(Exception E){
            System.out.println(E);
        }
    }


    public static void userAccess() {
        boolean Flag=true;
        Scanner in = new Scanner(System.in);
        Date today =  todayCalculator();
        cls();
        while(Flag){
            ageOfEveryone(today);
            System.out.println("choose to access:\n access Tour leader menu(1)\n access Tour menu(2) " +
                    "\n access location menu(3) \n access map menu(4) \n end the program(5)");
            int choice = in.nextInt();
            cls();
            switch (choice) {
                case 1 :
                    while (Flag) {
                        System.out.println("choose to do the mentioned task:\n print all tour leaders(1)" +
                                "\n add a tour leader(2)\n delete a tour leader(3)\n edit a tour leader's fields(4)" +
                                "\n search for a tour leader(5)\n return to main menu(6)");
                        choice = in.nextInt();
                        cls();
                        switch (choice) {
                            case 1 :
                                TourLeader.printAllTourLeader();
                                break;
                            case 2 :
                                TourLeader.addTourLeader();
                                break;
                            case 3 :
                                TourLeader.removeTourLeader();
                                break;
                            case 4 :
                                TourLeader.printAllTourLeader();
                                System.out.println("choose which tour leader you want to edit:");
                                int i = in.nextInt();
                                TourLeader.editTourLeader(i);
                                break;
                            case 5 :
                                TourLeader.searchTourLeader();
                                break;
                            case 6 :
                                Flag = false;
                                break;
                        }
                    }
                    Flag = true;
                    break;
                case 2 :
                    while (Flag){
                        System.out.println("What do you want to do with tours?" +
                                "\n see all tour types(1)\n see all tours(2)\n add a tour type(3)\n add a tour(4)" +
                                "\nedit a tour type(5)\n edit a tour(6)\n remove a tour(7)\n search for tour types(8)" +
                                "\n search for tours(9)\nreturn to main menu(10)");
                        choice = in.nextInt();
                        cls();
                        switch (choice) {
                            case 1 :
                                TourType.printAllTourTypes();
                                break;
                            case 2 :
                                Tour.printAllTours();
                                break;
                            case 3 :
                                TourType.addATourType();
                                break;
                            case 4 :
                                Tour.addATour();
                                break;
                            case 5 :
                                System.out.println("choose a tour type to edit:");
                                TourLeader.printAllTourLeader();
                                int i =in.nextInt();
                                TourType.editATourType(i);
                                break;
                            case 6 :
                                System.out.println("which is the tour you want to change?" +
                                        "(first enter the index of the tour type then enter the tour index)");
                                Tour.printAllTours();
                                int tourTypeIndex = in.nextInt();
                                int tourIndex = in.nextInt();
                                Tour.editATour(tourTypeIndex,tourIndex);
                                break;
                            case 7 :
                                Tour.removeATour();
                                break;
                            case 8 :
                                TourType.search();
                            case 9 :
                                Tour.search();
                                break;
                            case 10 :
                                Flag = false;
                                break;
                        }
                    }
                    Flag = true;
                    break;
                case 3 :
                    while (Flag) {
                        System.out.println("what do you want to do with locations?\n see all locations(1)\n add a location(2)\n edit a location(3)\n remove a location(4)\n return to main menu(5)");
                        choice = in.nextInt();
                        cls();
                        switch (choice){
                            case 1 :
                                Location.printAllLocations();
                                break;
                            case 2 :
                                Location.addALocation();
                                break;
                            case 3 :
                                System.out.println("choose a location to edit:");
                                Location.printAllLocations();
                                int locationIndex = in.nextInt();
                                Location.editALocation(locationIndex);
                                break;
                            case 4 :
                                Location.removeALocation();
                                break;
                            case 5 :
                                Flag = false;
                                break;
                        }
                    }
                    Flag = true;
                    break;
                case 4 :
                    while (Flag){
                        System.out.println("which tour is the one you want to check out on the map?\n" +
                                "(first enter the tour type index then enter the tour index)");
                        Tour.printAllTours();
                        int i = in.nextInt();
                        int j = in.nextInt();
                        System.out.println("choose what you want to do see about this tour on the map.\n" +
                                " see the starting point(1)\n see the destination(2)\n see both starting point and destination(3)\n " +
                                "where is the tour(4)\n see a city or a country on the map(5)" +
                                "see two cities on map(6)\n return to main menu(7)");
                        choice = in.nextInt();
                        cls();
                        switch (choice){
                            case 1 :
                                MapUtil.showMap(TourType.getTourTypes().get(i).getStartingPoint());
                                break;
                            case 2 :
                                MapUtil.showMap(TourType.getTourTypes().get(i).getDestination());
                                break;
                            case 3 :
                                MapUtil.showMap(TourType.getTourTypes().get(i).getStartingPoint(),TourType.getTourTypes().get(i).getDestination());
                                break;
                            case 4 :
                                System.out.println("what day of the tour are we in?(enter a number)");
                                int k = in.nextInt();
                                MapUtil.showMap(TourType.getTourTypes().get(i).getPlaces().get(k));
                                break;
                            case 5 :
                                System.out.println("enter the name of the country or city");
                                String searchedLocation = in.next();
                                MapUtil.showMap(searchedLocation);
                                break;
                            case 6 :
                                System.out.println("enter the first city");
                                String searchedCity1 = in.next();
                                System.out.println("enter the second city");
                                String searchedCity2 = in.next();
                                MapUtil.showMap(searchedCity1,searchedCity2);
                                break;
                            case 7 :
                                Flag = false;
                                break;

                        }
                    }
                    Flag = true;
                    break;
                case 5 :
                    Flag = false;
                    break;
            }


        }
    }

}

