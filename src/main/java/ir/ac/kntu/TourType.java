package ir.ac.kntu;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class TourType {
    private static LinkedList<TourType> tourTypes = new LinkedList<>();
    private int timeLength;
    private Location region;
    private int minPeople;
    private int maxPeople;
    private int price;
    private String destination;
    private  String startingPoint;
    private  WaysOfTravel theVehicle;
    private LinkedList<String> places = new LinkedList<String>();
    private LinkedList<Tour> Tours = new LinkedList<>();

    public static void editATourType(int i) {
        Scanner in = new Scanner(System.in);
        System.out.println("choose a tour type field to edit:\n time length(1)\n region(2)\n minimum people(3)\n" +
                " maximum people(4)\n price(5)\n destination(6)\n starting point(7)\n the vehicle(8)\n places(9)");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println("this is the old time length: " + tourTypes.get(i).getTimeLength());
                System.out.println("enter the new time length: ");
                int newTimeLength = in.nextInt();
                tourTypes.get(i).setTimeLength(newTimeLength);
                break;
            case 2:
                System.out.println("this is the old location:" + tourTypes.get(i).getRegion());
                System.out.println("choose a new location:\n");
                Location.printAllLocations();
                int newRegion = in.nextInt();
                tourTypes.get(i).setRegion(Location.locations.get(newRegion));
                break;
            case 3:
                System.out.println("this is the old minimum people: " + tourTypes.get(i).getMinPeople());
                System.out.println("enter the new minimum people: ");
                int newMinPeople = in.nextInt();
                tourTypes.get(i).setMinPeople(newMinPeople);
                break;
            case 4:
                System.out.println("this is the old maximum people: " + tourTypes.get(i).getMaxPeople());
                System.out.println("enter the new maximum people: ");
                int newMaxPeople = in.nextInt();
                tourTypes.get(i).setMaxPeople(newMaxPeople);
                break;
            case 5:
                System.out.println("this is the old price: " + tourTypes.get(i).getPrice());
                System.out.println("enter the new price: ");
                int newPrice = in.nextInt();
                tourTypes.get(i).setPrice(newPrice);
                break;
            case 6:
                System.out.println("this is the old destination: " + tourTypes.get(i).getDestination());
                System.out.println("enter the new destination: ");
                String newDestination = in.next();
                tourTypes.get(i).setDestination(newDestination);
                break;
            case 7:
                System.out.println("this is the old starting point: " + tourTypes.get(i).getStartingPoint());
                System.out.println("enter the new starting point: ");
                String newStartingPoint = in.next();
                tourTypes.get(i).setDestination(newStartingPoint);
                break;
            case 8:
                System.out.println("this is the old vehicle: " + tourTypes.get(i).getTheVehicle());
                System.out.println("choose a way of traveling:\n bus(1) \n airplane(2) \n train(3) \n ferry(4)");
                int wayOfTravelingChoice = in.nextInt();
                switch (wayOfTravelingChoice){
                    case 1 :
                        tourTypes.get(i).setTheVehicle(WaysOfTravel.roadTrip);
                        break;
                    case 2 :
                        tourTypes.get(i).setTheVehicle(WaysOfTravel.flightTraveling);
                        break;
                    case 3 :
                        tourTypes.get(i).setTheVehicle(WaysOfTravel.train);
                        break;
                    case 4 :
                        tourTypes.get(i).setTheVehicle(WaysOfTravel.ferry);
                        break;
                }
            case 9:
                System.out.println("these are the places the tour was going to see on each day:");
                for(int t=0 ; t<tourTypes.get(i).getPlaces().size();t++){
                    System.out.println(t + "-  " + tourTypes.get(i).getPlaces().get(t));
                }
                System.out.println("enter the new places:");
                LinkedList<String> newPlaces = new LinkedList<>();
                for(int t=0  ; t<tourTypes.get(i).getTimeLength() ; t++){
                    String newPlace = in.next();
                    newPlaces.addLast(newPlace);
                }
                tourTypes.get(i).setPlaces(newPlaces);
                break;
        }
    }


    public int getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }

    public Location getRegion() {
        return region;
    }

    public void setRegion(Location region) {
        this.region = region;
    }

    public int getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(int minPeople) {
        this.minPeople = minPeople;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public WaysOfTravel getTheVehicle() {
        return theVehicle;
    }

    public void setTheVehicle(WaysOfTravel theVehicle) {
        this.theVehicle = theVehicle;
    }

    public LinkedList<String> getPlaces() {
        return places;
    }

    public void setPlaces(LinkedList<String> places) {
        this.places = places;
    }

    public LinkedList<Tour> getTours() {
        return Tours;
    }

    public void setTours(LinkedList<Tour> tours) {
        Tours = tours;
    }

    public static LinkedList<TourType> getTourTypes() {
        return tourTypes;
    }

    public static void setTourTypes(LinkedList<TourType> tourTypes) {
        TourType.tourTypes = tourTypes;
    }

    public static void printAllTourTypes() {
        for (int i = 0; i<tourTypes.size();i++){
            System.out.println(i+"-  " + tourTypes.get(i).toString() + "\n");
        }
    }

    public static void addATourType(){
        Scanner in = new Scanner(System.in);
        System.out.println("choose the region of the tour:");
        TourType newTourType = new TourType();
        Location.printAllLocations();
        int locationChoice = in.nextInt();
        newTourType.setRegion(Location.locations.get(locationChoice));
        System.out.println("enter the number of days:");
        int newTimeLength=in.nextInt();
        newTourType.setTimeLength(newTimeLength);
        System.out.println("enter the minimum number of people:");
        int newMinPeople = in.nextInt();
        newTourType.setMinPeople(newMinPeople);
        System.out.println("enter the maximum number of people:");
        int newMaxPeople = in.nextInt();
        newTourType.setMaxPeople(newMaxPeople);
        System.out.println("enter the price:");
        int newPrice = in.nextInt();
        newTourType.setPrice(newPrice);
        System.out.println("where is the destination:");
        String newDestination = in.next();
        newTourType.setDestination(newDestination);
        System.out.println("where does it start from:");
        String newStartingPoint = in.next();
        newTourType.setStartingPoint(newStartingPoint);
        System.out.println("choose a way of traveling:\n bus(1) \n airplane(2) \n train(3) \n ferry(4)");
        int wayOfTravelingChoice = in.nextInt();
        switch (wayOfTravelingChoice){
            case 1 :
                newTourType.setTheVehicle(WaysOfTravel.roadTrip);
                break;
            case 2 :
                newTourType.setTheVehicle(WaysOfTravel.flightTraveling);
                break;
            case 3 :
                newTourType.setTheVehicle(WaysOfTravel.train);
                break;
            case 4 :
                newTourType.setTheVehicle(WaysOfTravel.ferry);
                break;
        }
        System.out.println("enter where the tour goes on each day:");
        LinkedList<String> newPlaces = new LinkedList<>();
        for(int i=1;i<=newTimeLength;i++){
            System.out.println("day" + i + ":");
            String newPlace = in.next();
            newPlaces.addLast(newPlace);
        }
        newTourType.setPlaces(newPlaces);

        TourType.tourTypes.addLast(newTourType);
    }

    public static void search() {
        Scanner in = new Scanner(System.in);
        System.out.println("search based on:\n time length(1)\n region(2)\n places to see(3)\n minimum people(4)\n" +
                " maximum people(5)\n price(6)");
        int choice = in.nextInt();
        switch (choice){
            case 1 :
                System.out.println("enter the time length");
                int searchedTimeLength = in.nextInt();
                ArrayList<TourType> searchedTimeLengths = new ArrayList<>();
                ArrayList<Integer> index1 = new ArrayList<>();
                for(int t=0 ;t<tourTypes.size();t++){
                    if(tourTypes.get(t).getTimeLength() == searchedTimeLength){
                        searchedTimeLengths.add(tourTypes.get(t));
                        index1.add(t);
                    }
                }
                for(int t=0 ;t<searchedTimeLengths.size();t++){
                    System.out.println(index1.get(t) + "-  " + searchedTimeLengths.get(t));
                }
                System.out.println("choose a tour type to change");
                int i = in.nextInt();
                editATourType(i);
                break;
            case 2 :
                System.out.println("choose the region");
                Location.printAllLocations();
                int searchedRegion = in.nextInt();
                ArrayList<TourType> searchedRegions = new ArrayList<>();
                ArrayList<Integer> index2 = new ArrayList<>();
                for(int t=0 ;t<tourTypes.size();t++){
                    if(tourTypes.get(t).getRegion().equals(searchedRegion)){
                        searchedRegions.add(tourTypes.get(t));
                        index2.add(t);
                    }
                }
                for(int t=0 ;t<searchedRegions.size();t++){
                    System.out.println(index2.get(t) + "-  " + searchedRegions.get(t));
                }
                System.out.println("choose a tour type to change");
                i = in.nextInt();
                editATourType(i);
                break;
            case 3 :
                System.out.println("enter the place:");
                String searchedPlace = in.next();
                ArrayList<TourType> searchedPlaces = new ArrayList<>();
                ArrayList<Integer> index9 = new ArrayList<>();
                for(int t = 0 ; t<tourTypes.size();t++){
                    for(int k=0 ;k<tourTypes.get(t).getPlaces().size();k++){
                        if(tourTypes.get(t).getPlaces().get(k).equals(searchedPlace)) {
                            searchedPlaces.add(tourTypes.get(t));
                            index9.add(t);
                        }
                    }
                }
                for(int t=0 ;t<searchedPlaces.size();t++){
                    System.out.println(index9.get(t) + "-  " + searchedPlaces.get(t));
                }
                System.out.println("choose a tour type to change");
                i = in.nextInt();
                editATourType(i);
                break;

            case 4 :
                System.out.println("enter the minimum people");
                int searchedMinPerson = in.nextInt();
                ArrayList<TourType> searchedMinPeople = new ArrayList<>();
                ArrayList<Integer> index3 = new ArrayList<>();
                for(int t=0 ;t<tourTypes.size();t++){
                    if(tourTypes.get(t).getMinPeople() == searchedMinPerson){
                        searchedMinPeople.add(tourTypes.get(t));
                        index3.add(t);
                    }
                }
                for(int t=0 ;t<searchedMinPeople.size();t++){
                    System.out.println(index3.get(t) + "-  " + searchedMinPeople.get(t));
                }
                System.out.println("choose a tour type to change");
                i = in.nextInt();
                editATourType(i);
                break;
            case 5 :
                System.out.println("enter the maximum people");
                int searchedMaxPerson = in.nextInt();
                ArrayList<TourType> searchedMaxPeople = new ArrayList<>();
                ArrayList<Integer> index4 = new ArrayList<>();
                for(int t=0 ;t<tourTypes.size();t++){
                    if(tourTypes.get(t).getMaxPeople() == searchedMaxPerson){
                        searchedMaxPeople.add(tourTypes.get(t));
                        index4.add(t);
                    }
                }
                for(int t=0 ;t<searchedMaxPeople.size();t++){
                    System.out.println(index4.get(t) + "-  " + searchedMaxPeople.get(t));
                }
                System.out.println("choose a tour type to change");
                i = in.nextInt();
                editATourType(i);
                break;
            case 6 :
                System.out.println("how: \n specific price(1)\n more than a price(2)\n less than a price(3)\n" +
                        " a price gap(4)");
                choice = in.nextInt();
                switch (choice){
                    case 1 :
                        System.out.println("enter the price");
                        int searchedPrice = in.nextInt();
                        ArrayList<TourType> searchedPrices = new ArrayList<>();
                        ArrayList<Integer> index5 = new ArrayList<>();
                        for(int t=0 ;t<tourTypes.size();t++){
                            if(tourTypes.get(t).getPrice() == searchedPrice) {
                                searchedPrices.add(tourTypes.get(t));
                                index5.add(t);
                            }
                        }
                        for(int t=0 ;t<searchedPrices.size();t++){
                            System.out.println(index5.get(t) + "-  " + searchedPrices.get(t));
                        }
                        System.out.println("choose a tour type to change");
                        i = in.nextInt();
                        editATourType(i);
                        break;
                    case 2 :
                        System.out.println("enter the minimum price");
                        int searchedMinPrice = in.nextInt();
                        ArrayList<TourType> searchedMinPrices = new ArrayList<>();
                        ArrayList<Integer> index6 = new ArrayList<>();
                        for(int t=0 ;t<tourTypes.size();t++){
                            if(tourTypes.get(t).getPrice() >= searchedMinPrice)
                                searchedMinPrices.add(tourTypes.get(t));
                            index6.add(t);
                        }
                        for(int t=0 ;t<searchedMinPrices.size();t++){
                            System.out.println(index6.get(t) + "-  " + searchedMinPrices.get(t));
                        }
                        System.out.println("choose a tour type to change");
                        i = in.nextInt();
                        editATourType(i);
                        break;
                    case 3 :
                        System.out.println("enter the maximum price");
                        int searchedMaxPrice = in.nextInt();
                        ArrayList<TourType> searchedMaxPrices = new ArrayList<>();
                        ArrayList<Integer> index7 = new ArrayList<>();
                        for(int t=0 ;t<tourTypes.size();t++){
                            if(tourTypes.get(t).getPrice() <= searchedMaxPrice)
                                searchedMaxPrices.add(tourTypes.get(t));
                            index7.add(t);
                        }
                        for(int t=0 ;t<searchedMaxPrices.size();t++){
                            System.out.println(index7.get(t) + "-  " + searchedMaxPrices.get(t));
                        }
                        System.out.println("choose a tour type to change");
                        i = in.nextInt();
                        editATourType(i);
                        break;
                    case 4 :
                        System.out.println("enter the minimum then the maximum price:");
                        int searchedMinPrice1 = in.nextInt();
                        int searchedMaxPrice1 = in.nextInt();
                        ArrayList<TourType> searchedGapPrices = new ArrayList<>();
                        ArrayList<Integer> index8 = new ArrayList<>();
                        for(int t=0 ;t<tourTypes.size();t++){
                            if(tourTypes.get(t).getPrice() >= searchedMinPrice1 && tourTypes.get(t).getPrice() <=searchedMaxPrice1)
                                searchedGapPrices.add(tourTypes.get(t));
                            index8.add(t);
                        }
                        for(int t=0 ;t<searchedGapPrices.size();t++){
                            System.out.println(index8.get(t) + "-  " + searchedGapPrices.get(t));
                        }
                        System.out.println("choose a tour type to change");
                        i = in.nextInt();
                        editATourType(i);
                        break;
                }
                break;

        }
    }


    public String toString() {
        return "TourType{" +
                "timeLength=" + timeLength +
                ", region=" + region +
                ", minPeople=" + minPeople +
                ", maxPeople=" + maxPeople +
                ", price=" + price +
                ", destination='" + destination + '\'' +
                ", startingPoint='" + startingPoint + '\'' +
                ", theVehicle=" + theVehicle +
                ", places=" + places +
                '}';
    }



}
