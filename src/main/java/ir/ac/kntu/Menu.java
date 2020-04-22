package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.Scanner;


public class Menu {
    private static int indexOfUser;




    public static Date todayCalculator(){
        Scanner in = new Scanner(System.in);
        System.out.println("enter this year:");
        int year = in.nextInt();
        System.out.println("enter this month");
        int month = in.nextInt();
        System.out.println("enter this day");
        int day = in.nextInt();
        return new Date(year,month,day);
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

    public static void entrance(Admin theAdmin){
        Scanner in = new Scanner(System.in);
        System.out.println("if it's the first time you're entering you must use admin access to be able to add other users.");
        System.out.println("\nwhich of the following are you?\n admin(1) \n employee(2) \n customer(3) \n tour leader(4)");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                if (!Person.peopleEntrance(theAdmin)) {
                    System.out.println("wrong username or password!");
                    entrance(theAdmin);
                }else{
                    Person.setCurrentUser(theAdmin);
                }
                break;
            case 2:
                System.out.println("which of the following are you?\n");
                Employee.printEmployees();
                choice = in.nextInt();
                if(!Person.peopleEntrance(Employee.getEmployees().get(choice))){
                    System.out.println("wrong username or password!");
                    entrance(theAdmin);
                }else{
                    Person.setCurrentUser(Employee.getEmployees().get(choice));
                    indexOfUser = choice;
                }
                break;
            case 3:
                System.out.println("which of the following are you?\n");
                Customer.printCustomers();
                choice = in.nextInt();
                if(!Person.peopleEntrance(Customer.getCustomers().get(choice))){
                    System.out.println("wrong username or password!");
                    entrance(theAdmin);
                }else{
                    Person.setCurrentUser(Customer.getCustomers().get(choice));
                    indexOfUser = choice;
                }
                break;
            case 4:
                System.out.println("which of the following are you?\n");
                TourLeader.printAllTourLeader();
                choice = in.nextInt();
                if(!Person.peopleEntrance(TourLeader.getTourLeaders().get(choice))){
                    System.out.println("wrong username or password!");
                    entrance(theAdmin);
                }else{
                    Person.setCurrentUser(TourLeader.getTourLeaders().get(choice));
                    indexOfUser = choice;
                }
                break;
        }
    }

    public static void peopleAccess(Admin theAdmin) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("choose to access: \n access admin(access levels:1)(1) \n access employees(access level:1,2)(2)" +
                    "\n access customers(access levels: 1,2,3,4)(3) \n access tour leaders(access level: 1,2,4)(4)" +
                    "\n back to main menu(5)");
            int choice = in.nextInt();
            switch (choice){
                case 1:
                    if(Person.getCurrentUser().getAccessLevel() == 1){
                        Admin.editAdmin(theAdmin);
                    }else{
                        System.out.println("you can't access this part");
                    }
                    break;
                case 2:
                    if(Person.getCurrentUser().getAccessLevel() == 1 ){
                        System.out.println("what do you want to change about employees:\n add an employee(1)\n edit an employee(2)" +
                                "\n remove an employee(3)");
                        choice =in.nextInt();
                        switch (choice){
                            case 1:
                                Employee.addAEmployee();
                                break;
                            case 2:
                                System.out.println("choose an employee:\n");
                                Employee.printEmployees();
                                choice = in.nextInt();
                                Employee.editAnEmployee(choice);
                                break;
                            case 3:
                                Employee.removeAnEmployee();
                                break;
                        }
                    }
                    else if(Person.getCurrentUser().getAccessLevel() == 2 ){
                        System.out.println("these changes will be implemented on yourself\n");
                        Employee.editAnEmployee(indexOfUser);

                    }
                    else{
                        System.out.println("you can't access this part");
                    }
                    break;
                case 3:
                    if(Person.getCurrentUser().getAccessLevel() == 1 || Person.getCurrentUser().getAccessLevel() == 2){
                        System.out.println("choose:\n add a customer(1) \n edit a customer(2) \n remove a customer(3)\n");
                        choice = in.nextInt();
                        switch (choice){
                            case 1:
                                Customer.addACustomer();
                                break;
                            case 2:
                                System.out.println("choose a customer:");
                                Customer.printCustomers();
                                choice = in.nextInt();
                                Customer.editACustomer(choice);
                                break;
                            case 3:
                                Customer.removeACustomer();
                                break;
                        }
                    }
                    else if(Person.getCurrentUser().getAccessLevel() == 3){
                        System.out.println("these changes will be implemented on yourself");
                        Customer.editACustomer(indexOfUser);
                    }
                    else{
                        System.out.println("you will be adding a new customer:\n");
                        Customer.addACustomer();
                    }
                    break;
                case 4:
                    if(Person.getCurrentUser().getAccessLevel() == 1 || Person.getCurrentUser().getAccessLevel() ==2){
                        System.out.println("choose to do the mentioned task:\n print all tour leaders(1)" +
                                "\n add a tour leader(2)\n delete a tour leader(3)\n edit a tour leader's fields(4)" +
                                "\n search for a tour leader(5)\n return to main menu(6)");
                        choice = in.nextInt();
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
                        }
                    }else if(Person.getCurrentUser().getAccessLevel() == 4){
                        System.out.println("you'll be changing your own account");
                        TourLeader.editTourLeader(indexOfUser);
                    }else{
                        System.out.println("you can't access this part");
                    }
                    break;
                case 5:
                    flag = false;
                    break;
            }

        }
    }


    public static void tourAccess() {
        boolean Flag=true;
        Scanner in = new Scanner(System.in);
        cls();
        while(Flag){

            System.out.println("choose to access:\n access Tour menu(1) " +
                    "\n access location menu(2) \n access map menu(3) \n back to main menu(5)");
            int choice = in.nextInt();
            cls();
            switch (choice) {
                case 1 :
                    while (Flag){
                        if(Person.getCurrentUser().getAccessLevel() == 1 || Person.getCurrentUser().getAccessLevel() ==2) {
                            System.out.println("What do you want to do with tours?" +
                                    "\n see all tour types(1)\n see all tours(2)\n add a tour type(admin access only)(3)\n add a tour(4)" +
                                    "\nedit a tour type(admin access only)(5)\n edit a tour(6)\n remove a tour(7)\n search for tour types(admin access only)(8)" +
                                    "\n search for tours(9)\nreturn to main menu(10)");
                            choice = in.nextInt();
                            cls();
                            switch (choice) {
                                case 1:
                                    TourType.printAllTourTypes();
                                    break;
                                case 2:
                                    Tour.printAllTours();
                                    break;
                                case 3:
                                    if(Person.getCurrentUser().getAccessLevel() == 1)
                                        TourType.addATourType();
                                    else
                                        System.out.println("you can't access this part");
                                    break;
                                case 4:
                                    Tour.addATour();
                                    break;
                                case 5:
                                    if(Person.getCurrentUser().getAccessLevel() == 1) {
                                        System.out.println("choose a tour type to edit:");
                                        TourLeader.printAllTourLeader();
                                        int i = in.nextInt();
                                        TourType.editATourType(i);
                                    }else{
                                        System.out.println("you can't access this part");
                                        }
                                    break;
                                case 6:
                                    System.out.println("which is the tour you want to change?" +
                                            "(first enter the index of the tour type then enter the tour index)");
                                    Tour.printAllTours();
                                    int tourTypeIndex = in.nextInt();
                                    int tourIndex = in.nextInt();
                                    Tour.editATour(tourTypeIndex, tourIndex);
                                    break;
                                case 7:
                                    Tour.removeATour();
                                    break;
                                case 8:
                                    if(Person.getCurrentUser().getAccessLevel() == 1)
                                        TourType.search();
                                    else{
                                        System.out.println("you can't access this part");
                                    }
                                    break;
                                case 9:
                                    Tour.search();
                                    break;
                                case 10:
                                    Flag = false;
                                    break;
                            }
                        }
                        else {
                            System.out.println("choose:\n see all tour types(1)\n see all tours(2)\n return to menu(3)");
                            choice = in.nextInt();
                            switch (choice){
                                case 1:
                                    TourType.printAllTourTypes();
                                    break;
                                case 2:
                                    Tour.printAllTours();
                                    break;
                                case 3:
                                    Flag = false;
                                    break;
                            }
                        }
                    }
                    Flag = true;
                    break;
                case 2 :
                    while (Flag) {
                        if(Person.getCurrentUser().getAccessLevel() == 1) {
                            System.out.println("what do you want to do with locations?\n see all locations(1)\n" +
                                    " add a location(2)\n edit a location(3)\n remove a location(4)\n return to main menu(5)");
                            choice = in.nextInt();
                            cls();
                            switch (choice) {
                                case 1:
                                    Location.printAllLocations();
                                    break;
                                case 2:
                                    Location.addALocation();
                                    break;
                                case 3:
                                    System.out.println("choose a location to edit:");
                                    Location.printAllLocations();
                                    int locationIndex = in.nextInt();
                                    Location.editALocation(locationIndex);
                                    break;
                                case 4:
                                    Location.removeALocation();
                                    break;
                                case 5:
                                    Flag = false;
                                    break;
                            }
                        }
                        else{
                            System.out.println("choose:\n see all locations(1)\n return to menu(2)");
                            choice = in.nextInt();
                            switch (choice){
                                case 1:
                                    Location.printAllLocations();
                                    break;
                                case 2:
                                    Flag = false;
                                    break;
                            }
                        }
                    }
                    Flag = true;
                    break;
                case 3 :
                    while (Flag){
                        System.out.println("which tour is the one you want to check out on the map?\n" +
                                "(first enter the tour type index then enter the tour index)");
                        Tour.printAllTours();
                        int i = in.nextInt();
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
                case 4 :
                    Flag = false;
                    break;
            }


        }
    }

}

