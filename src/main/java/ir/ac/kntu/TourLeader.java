package ir.ac.kntu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class TourLeader {
    private static LinkedList<TourLeader> tourLeaders = new LinkedList<>();
    private String firstName;
    private String surName;
    private String id;
    private String personalNum;
    private Date dateOfBirth;
    private Date dateOfEmployment;
    private boolean maritalStatus;
    private ArrayList<Location> familiarLocation;
    private Tour currentTour;
    private int age;


    public static void printAllTourLeader() {
        for (int i = 0; i < tourLeaders.size(); i++) {
            System.out.println(i + "-  " + tourLeaders.get(i).toString()+"\n");



        }
    }


    public static LinkedList<TourLeader> getTourLeaders() {
        return tourLeaders;
    }

    public static void setTourLeaders(LinkedList<TourLeader> tourLeaders) {
        TourLeader.tourLeaders = tourLeaders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(String personalNum) {
        this.personalNum = personalNum;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public ArrayList<Location> getFamiliarLocation() {
        return familiarLocation;
    }

    public void setFamiliarLocation(ArrayList<Location> familiarLocation) {
        this.familiarLocation = familiarLocation;
    }

    public Tour getCurrentTour() {
        return currentTour;
    }

    public void setCurrentTour(Tour currentTour) {
        this.currentTour = currentTour;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void ageCalculator(Date today){
        if(dateOfBirth.getMonth()>today.getMonth()){
            age = today.getYear()-dateOfBirth.getYear()-1;
        }
        else if(dateOfBirth.getMonth()<today.getMonth()){
            age = today.getYear()-dateOfBirth.getYear();
        }
        else{
            if(today.getDay()>today.getDay()){
                age = today.getYear() - dateOfBirth.getYear()-1;
            }
            else{
                age = today.getYear()-dateOfBirth.getYear();
            }
        }
    }

    public static void  addTourLeader(){
        Scanner in = new Scanner(System.in);
        TourLeader newTourLeader = new TourLeader();
        System.out.println("enter his/her first name:");
        String newFirstName = in.next();
        newTourLeader.setFirstName(newFirstName);
        System.out.println("enter his/her surname:");
        String newSurName = in.next();
        newTourLeader.setSurName(newSurName);
        System.out.println("enter his/her id:");
        String newId = in.next();
        newTourLeader.setId(newId);
        System.out.println("enter his/her personal number:");
        String newPersonalNum = in.next();
        newTourLeader.setPersonalNum(newPersonalNum);
        System.out.println("enter his/her year of birth:");
        int year = in.nextInt();
        System.out.println("enter his/her month of birth:");
        int month = in.nextInt();
        System.out.println("enter his/her day of birth:");
        int day = in.nextInt();
        Date dob = new Date(year,month,day);
        newTourLeader.setDateOfBirth(dob);
        System.out.println("enter the year of employment:");
        int thisYear = in.nextInt();
        System.out.println("enter the month of employment:");
        int thisMonth = in.nextInt();
        System.out.println("enter the day of employment:");
        int thisDay = in.nextInt();
        Date today = new Date(thisYear,thisMonth,thisDay);
        newTourLeader.setDateOfEmployment(today);
        System.out.println("enter true if you're married or false if otherwise:");
        boolean marriage = in.nextBoolean();
        newTourLeader.setMaritalStatus(marriage);
        System.out.println("how many locations are you familiar with?");
        int i =in.nextInt();
        ArrayList<Location> newLocations = new ArrayList<>();
        for(int t=0; t<i; t++){
            Location.printAllLocations();
            System.out.println("choose the familiar location:");
            int k = in.nextInt();
            newLocations.add(Location.locations.get(k));
        }
        newTourLeader.setFamiliarLocation(newLocations);
        tourLeaders.addLast(newTourLeader);
    }

    public static void removeTourLeader() {
        Scanner in = new Scanner(System.in);
        printAllTourLeader();
        System.out.println("enter the index of the tour leader you want to be removed:");
        int i = in.nextInt();
        System.out.println("are you sure?(in case you are enter y otherwise enter any other button and press enter afterwards)");
        String sureButton = in.next();
        if (sureButton.equals("y")) {
            tourLeaders.remove(i);
        }
    }



    public static void editTourLeader(int i) {
        Scanner in = new Scanner(System.in);
        System.out.println("choose what you want to change: \n first name(1)\n surname(2)\n id(3)" +
                "\n personal number(4)\n date of birth(5)\n date of employment(6)\n marital status(7)\n" +
                " familiar location(8)\n if you want to change the current tour you should take action threw tour access ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                System.out.println("the old first name:  " + tourLeaders.get(i).getFirstName()
                        + "\n enter the new first name:");
                String newFirstName = in.next();
                tourLeaders.get(i).setFirstName(newFirstName);
                break;
            case 2:
                System.out.println("the old surname:  " + tourLeaders.get(i).getSurName() + "\n enter the new surname:");
                String newSurName = in.next();
                tourLeaders.get(i).setSurName(newSurName);
                break;
            case 3:
                System.out.println("the old id:  " + tourLeaders.get(i).getId() + "\n enter the new id:");
                String newId = in.next();
                tourLeaders.get(i).setId(newId);
                break;
            case 4:
                System.out.println("the old personal number:  " + tourLeaders.get(i).getPersonalNum() +
                        "\n enter the new personal number:");
                String newPersonalNum = in.next();
                tourLeaders.get(i).setPersonalNum(newPersonalNum);
                break;
            case 5:
                System.out.println("the old date of birth:  " + tourLeaders.get(i).getDateOfBirth() +
                        "\n enter the new date of birth:");
                System.out.println("enter his/her new year of birth:");
                int year1 = in.nextInt();
                System.out.println("enter his/her new month of birth:");
                int month1 = in.nextInt();
                System.out.println("enter his/her new day of birth:");
                int day1 = in.nextInt();
                Date dob1 = new Date(year1, month1, day1);
                tourLeaders.get(i).setDateOfBirth(dob1);
                break;
            case 6:
                System.out.println("the old date of employment: " + tourLeaders.get(i).getDateOfEmployment() +
                        "\n enter the new date of employment:");
                System.out.println("enter his/her new year of employment:");
                int year2 = in.nextInt();
                System.out.println("enter his/her new month of employment:");
                int month2 = in.nextInt();
                System.out.println("enter his/her new day of employment:");
                int day2 = in.nextInt();
                Date dob2 = new Date(year2, month2, day2);
                tourLeaders.get(i).setDateOfEmployment(dob2);
                break;
            case 7:
                System.out.println("the old marital status:  " + tourLeaders.get(i).isMaritalStatus() +
                        "\n enter the new marital status:");
                Boolean marriage = in.nextBoolean();
                tourLeaders.get(i).setMaritalStatus(marriage);
                break;
            case 8:
                for (int t = 0; t < tourLeaders.get(i).getFamiliarLocation().size(); t++) {
                    System.out.println(t + "-  " + tourLeaders.get(i).getFamiliarLocation().get(t).toString() + "\n");
                }
                System.out.println("choose: \nadd(1)\nremove(2)\n");
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("choose the location:\n");
                        for (int j = 0; j < Location.locations.size(); j++) {
                            System.out.println(j + "-  " + Location.locations.get(j).toString() + "\n");
                        }
                        int k = in.nextInt();
                        tourLeaders.get(i).getFamiliarLocation().add(Location.locations.get(k));
                        break;
                    case 2:
                        System.out.println("choose the location:\n");
                        for (int t = 0; t < Location.locations.size(); t++) {
                            System.out.println(t + "-  " + Location.locations.get(t).toString() + "\n");
                        }
                        k = in.nextInt();
                        tourLeaders.get(i).getFamiliarLocation().remove(k);
                        break;
                }
                break;
        }
    }

    public static void searchTourLeader() {
        Scanner in = new Scanner(System.in);
        System.out.println("search based on: \n tour leader firstName(1) \n tour leader surname(2) \n" +
                " known locations(3) \n age(4)");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                System.out.println("enter the name you're looking for:");
                String searchedFirstName = in.next();
                for (int t = 0; t < tourLeaders.size(); t++) {
                    if (tourLeaders.get(t).getFirstName().equals(searchedFirstName)) {
                        editTourLeader(t);
                    }
                }
                break;
            case 2:
                System.out.println("enter the surname you're looking for:");
                String searchedSurName = in.next();
                for (int t = 0; t < tourLeaders.size(); t++) {
                    if (tourLeaders.get(t).getSurName().equals(searchedSurName)) {
                        editTourLeader(t);
                    }
                }
                break;
            case 3:
                System.out.println("choose a location:\n");
                for (int t = 0; t < Location.locations.size(); t++) {
                    System.out.println(t + "-  " + Location.locations.get(t).toString() + "\n");
                }
                int i = in.nextInt();
                ArrayList<TourLeader> searchedTourLeaders = new ArrayList<>();
                ArrayList<Integer> index = new ArrayList<>();
                for (int t = 0; t < tourLeaders.size(); t++) {
                    for (int k = 0; k < tourLeaders.get(t).getFamiliarLocation().size(); k++) {
                        if (tourLeaders.get(t).getFamiliarLocation().get(k).equals(Location.locations.get(i))) {
                            searchedTourLeaders.add(tourLeaders.get(t));
                            index.add(t);
                        }
                    }
                }
                for (int t = 0; t < searchedTourLeaders.size(); t++) {
                    System.out.println(index.get(t) + "-  " + searchedTourLeaders.get(t).toString());
                }
                System.out.println("choose a tour leader to change");
                i = in.nextInt();
                editTourLeader(i);

                break;
            case 4:
                System.out.println("how: \n specific age(1)\n older than..(2)\n younger than..(3)\n between two ages(4)");
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("enter the age you're looking for:");
                        i = in.nextInt();
                        ArrayList<TourLeader> specificAge = new ArrayList<>();
                        ArrayList<Integer> index1 = new ArrayList<>();
                        for (int t = 0; t < tourLeaders.size(); t++) {
                            if (tourLeaders.get(t).getAge() == i) {
                                specificAge.add(tourLeaders.get(t));
                                index1.add(t);
                            }
                        }
                        System.out.println("choose a tour leader to change");
                        for (int t = 0; t < specificAge.size(); t++) {
                            System.out.println(index1.get(t) + "-  " + specificAge.get(t));
                        }
                        i = in.nextInt();
                        editTourLeader(i);
                        break;
                    case 2:
                        System.out.println("enter the minimum age:");
                        i = in.nextInt();
                        ArrayList<TourLeader> minimumAge = new ArrayList<>();
                        ArrayList<Integer> index2 = new ArrayList<>();
                        for (int t = 0; t < tourLeaders.size(); t++) {
                            if (tourLeaders.get(t).getAge() >= i) {
                                minimumAge.add(tourLeaders.get(t));
                                index2.add(t);
                            }
                        }
                        System.out.println("choose a tour leader to change");
                        for (int t = 0; t < minimumAge.size(); t++) {
                            System.out.println(index2.get(t) + "-  " + minimumAge.get(t));
                        }
                        i = in.nextInt();
                        editTourLeader(i);
                        break;
                    case 3:
                        System.out.println("enter the maximum age:");
                        i = in.nextInt();
                        ArrayList<TourLeader> maximumAge = new ArrayList<>();
                        ArrayList<Integer> index3 = new ArrayList<>();
                        for (int t = 0; t < tourLeaders.size(); t++) {
                            if (tourLeaders.get(t).getAge() <= i) {
                                maximumAge.add(tourLeaders.get(t));
                                index3.add(t);
                            }
                        }
                        System.out.println("choose a tour leader to change");
                        for (int t = 0; t < maximumAge.size(); t++) {
                            System.out.println(index3.get(t) + "-  " + maximumAge.get(t));
                        }
                        i = in.nextInt();
                        editTourLeader(i);
                        break;
                    case 4:
                        System.out.println("enter the age gap first enter the minimum then the maximum:");
                        i = in.nextInt();
                        int j = in.nextInt();
                        ArrayList<TourLeader> gapAge = new ArrayList<>();
                        ArrayList<Integer> index4 = new ArrayList<>();
                        for (int t = 0; t < tourLeaders.size(); t++) {
                            if (tourLeaders.get(t).getAge() >= i && tourLeaders.get(t).getAge() <= j) {
                                gapAge.add(tourLeaders.get(t));
                                index4.add(t);
                            }
                        }
                        System.out.println("choose a tour leader to change");
                        for (int t = 0; t < gapAge.size(); t++) {
                            System.out.println(index4.get(t) + "-  " + gapAge.get(t));
                        }
                        i = in.nextInt();
                        editTourLeader(i);
                        break;
                }
                break;

        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourLeader that = (TourLeader) o;
        return maritalStatus == that.maritalStatus &&
                age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(surName, that.surName) &&
                Objects.equals(id, that.id) &&
                Objects.equals(personalNum, that.personalNum) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(dateOfEmployment, that.dateOfEmployment) &&
                Objects.equals(familiarLocation, that.familiarLocation) &&
                Objects.equals(currentTour, that.currentTour);
    }


    public int hashCode() {
        return Objects.hash(firstName, surName, id, personalNum, dateOfBirth, dateOfEmployment, maritalStatus, familiarLocation, currentTour, age);
    }

    public String toString() {
        return "TourLeader{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", id='" + id + '\'' +
                ", personalNum='" + personalNum + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEmployment=" + dateOfEmployment +
                ", maritalStatus=" + maritalStatus +
                ", familiarLocation=" + familiarLocation +
                ", currentTour=" + currentTour +
                '}';
    }
}
