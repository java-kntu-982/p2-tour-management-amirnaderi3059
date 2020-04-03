package ir.ac.kntu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Tour {
    private Date dayOfDeparture;
    private Date dayOfArrival;
    private TourType type;
    private TourLeader theLeader;

    public static void addATour() {
        Scanner in = new Scanner(System.in);
        System.out.println("choose a tour type:");
        TourType.printAllTourTypes();
        int choice = in.nextInt();
        Tour newTour = new Tour();
        newTour.setType(TourType.getTourTypes().get(choice));
        System.out.println("enter the date of departure:");
        System.out.println("enter the year:");
        int year = in.nextInt();
        System.out.println("enter the month:");
        int month = in.nextInt();
        System.out.println("enter the day:");
        int day = in.nextInt();
        Date dateOfDeparture = new Date(year,month,day);
        newTour.setDayOfDeparture(dateOfDeparture);
        newTour.dayOfArrival = dateOfDeparture;
        for(int i = 0; i<TourType.getTourTypes().get(choice).getTimeLength(); i++){
            newTour.dayOfArrival.nextDay();
        }
        System.out.println("choose a tour leader:");
        TourLeader.printAllTourLeader();
        int i = in.nextInt();
        if(TourLeader.getTourLeaders().get(i).getCurrentTour() == null){
            TourLeader.getTourLeaders().get(i).setCurrentTour(newTour);
            newTour.setTheLeader(TourLeader.getTourLeaders().get(i));
        }
        else{
            System.out.println("he/she already has a tour,choose the leader later through edit Tours");

        }
        TourType.getTourTypes().get(choice).getTours().addLast(newTour);

    }

    public static void editATour(int tourTypeIndex,int tourIndex) {
        Scanner in = new Scanner(System.in);
        System.out.println("what do you want to change about this tour? \n tour leader(1) \n date of departure(2) \n" +
                " tour type(3)");
        int choice = in.nextInt();
        switch(choice){
            case 1 :
                System.out.println("the previous leader: " + TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex).getTheLeader());
                System.out.println("\nchoose the new leader:");
                TourLeader.printAllTourLeader();
                int i = in.nextInt();
                if(TourLeader.getTourLeaders().get(i).getCurrentTour() == null) {
                    TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex).setTheLeader(TourLeader.getTourLeaders().get(i));
                    TourLeader.getTourLeaders().get(i).setCurrentTour(TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex));
                }
                else {
                    System.out.println("this leader already has a tour");
                }
            case 2 :
                System.out.println("the previous departure date: " + TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex).getDayOfDeparture());
                System.out.println("enter the new date of departure:");
                System.out.println("enter the year:");
                int year = in.nextInt();
                System.out.println("enter the month:");
                int month = in.nextInt();
                System.out.println("enter the day:");
                int day = in.nextInt();
                Date newDateOfDeparture = new Date(year,month,day);
                TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex).setDayOfDeparture(newDateOfDeparture);
                TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex).setDayOfArrival(newDateOfDeparture);
                for(int j = 0; j<TourType.getTourTypes().get(tourTypeIndex).getTimeLength(); j++){
                    TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex).dayOfArrival.nextDay();
                }
            case 3 :
                System.out.println("the previous tour type: " + TourType.getTourTypes().get(tourTypeIndex).toString());
                System.out.println("choose a new tour type: ");
                TourType.printAllTourTypes();
                int j = in.nextInt();
                TourType.getTourTypes().get(j).getTours().addLast(TourType.getTourTypes().get(tourTypeIndex).getTours().get(tourIndex));
                TourType.getTourTypes().get(tourTypeIndex).getTours().remove(tourIndex);
        }


    }

    public static void removeATour() {
        Scanner in = new Scanner(System.in);
        System.out.println("which is the tour you want to remove?" +
                "(first enter the index of the tour type then enter the tour index)");
        printAllTours();
        int tourTypeIndex = in.nextInt();
        int tourIndex = in.nextInt();
        TourType.getTourTypes().get(tourTypeIndex).getTours().remove(tourIndex);
    }

    public static void search() {
        Scanner in = new Scanner(System.in);
        System.out.println("search based on:\n tour leader(1)\n departure date(2)\n arrival date(3) \n" +
                " time length(4) \n region(5) \n places(6)\n maximum people(7)\n minimum people(8)\n " +
                "price(9)");
        int choice = in.nextInt();
        switch (choice){
            case 1 :
                System.out.println("choose a tour leader");
                TourLeader.printAllTourLeader();
                int searchedLeader = in.nextInt();
                LinkedList<TourLeader> searchedTourLeaders = new LinkedList<>();
                LinkedList<Integer> indexTourType1 = new LinkedList<>();
                LinkedList<Integer> indexTour1 = new LinkedList<>();
                for(int t=0 ; t<TourType.getTourTypes().size();t++){
                    for (int j=0 ; j<TourType.getTourTypes().get(t).getTours().size();j++){
                        if(TourType.getTourTypes().get(t).getTours().get(j).getTheLeader().equals(searchedLeader)){
                            searchedTourLeaders.add(TourType.getTourTypes().get(t).getTours().get(j).theLeader);
                            indexTourType1.add(t);
                            indexTour1.add(j);
                        }
                    }
                }
                for(int t=0 ;t<searchedTourLeaders.size();t++){
                    System.out.println(indexTourType1.get(t) +"."+indexTour1.get(t) + "-  " + searchedTourLeaders.get(t));
                }
                System.out.println("enter the index of a tour type then enter the index of a tour");
                int i = in.nextInt();
                int j = in.nextInt();
                editATour(i,j);
                break;
            case 2 :
                System.out.println("how:\n later than(1)\n sooner than(2)\n in a gap(3)");
                choice = in.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("choose a date");
                        System.out.println("\nenter the year:");
                        int year = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day = in.nextInt();
                        Date searchedDateOfDeparture = new Date(year,month,day);
                        LinkedList<TourLeader> searchedDate = new LinkedList<>();
                        LinkedList<Integer> indexTourType2 = new LinkedList<>();
                        LinkedList<Integer> indexTour2 = new LinkedList<>();
                        for(int t=0 ; t<TourType.getTourTypes().size();t++){
                            for (int k=0 ; k<TourType.getTourTypes().get(t).getTours().size();k++){
                                if(Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfDeparture(),searchedDateOfDeparture)==1){
                                    searchedDate.add(TourType.getTourTypes().get(t).getTours().get(k).theLeader);
                                    indexTourType2.add(t);
                                    indexTour2.add(k);
                                }
                            }
                        }
                        for(int t=0 ;t<searchedDate.size();t++){
                            System.out.println(indexTourType2.get(t) +"."+indexTour2.get(t) + "-  " + searchedDate.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 2 :
                        System.out.println("choose a date");
                        System.out.println("\nenter the year:");
                        int year1 = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month1 = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day1 = in.nextInt();
                        Date searchedDateOfDeparture1 = new Date(year1,month1,day1);
                        LinkedList<TourLeader> searchedDate1 = new LinkedList<>();
                        LinkedList<Integer> indexTourType3 = new LinkedList<>();
                        LinkedList<Integer> indexTour3 = new LinkedList<>();
                        for(int t=0 ; t<TourType.getTourTypes().size();t++){
                            for (int k=0 ; k<TourType.getTourTypes().get(t).getTours().size();k++){
                                if(Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfDeparture(),searchedDateOfDeparture1)==-1){
                                    searchedDate1.add(TourType.getTourTypes().get(t).getTours().get(k).theLeader);
                                    indexTourType3.add(t);
                                    indexTour3.add(k);
                                }
                            }
                        }
                        for(int t=0 ;t<searchedDate1.size();t++){
                            System.out.println(indexTourType3.get(t) +"."+indexTour3.get(t) + "-  " + searchedDate1.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 3 :
                        System.out.println("choose the first date");
                        System.out.println("\nenter the year:");
                        int year2 = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month2 = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day2 = in.nextInt();
                        Date searchedDateOfDeparture2 = new Date(year2,month2,day2);
                        System.out.println("choose the second date");
                        System.out.println("\nenter the year:");
                        int year3 = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month3 = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day3 = in.nextInt();
                        Date searchedDateOfDeparture3 = new Date(year3,month3,day3);
                        LinkedList<TourLeader> searchedDate2 = new LinkedList<>();
                        LinkedList<Integer> indexTourType4 = new LinkedList<>();
                        LinkedList<Integer> indexTour4 = new LinkedList<>();
                        for(int t=0 ; t<TourType.getTourTypes().size();t++){
                            for (int k=0 ; k<TourType.getTourTypes().get(t).getTours().size();k++){
                                if(Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfDeparture(),searchedDateOfDeparture2)==1&&
                                        Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfDeparture(),searchedDateOfDeparture3)==-1){
                                    searchedDate2.add(TourType.getTourTypes().get(t).getTours().get(k).theLeader);
                                    indexTourType4.add(t);
                                    indexTour4.add(k);
                                }
                            }
                        }
                        for(int t=0 ;t<searchedDate2.size();t++){
                            System.out.println(indexTourType4.get(t) +"."+indexTour4.get(t) + "-  " + searchedDate2.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;


                }
                break;
            case 3 :
                System.out.println("how:\n later than(1)\n sooner than(2)\n in a gap(3)");
                choice = in.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("choose a date");
                        System.out.println("\nenter the year:");
                        int year = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day = in.nextInt();
                        Date searchedDateOfArrival = new Date(year,month,day);
                        LinkedList<TourLeader> searchedDate = new LinkedList<>();
                        LinkedList<Integer> indexTourType2 = new LinkedList<>();
                        LinkedList<Integer> indexTour2 = new LinkedList<>();
                        for(int t=0 ; t<TourType.getTourTypes().size();t++){
                            for (int k=0 ; k<TourType.getTourTypes().get(t).getTours().size();k++){
                                if(Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfArrival(),searchedDateOfArrival)==1){
                                    searchedDate.add(TourType.getTourTypes().get(t).getTours().get(k).theLeader);
                                    indexTourType2.add(t);
                                    indexTour2.add(k);
                                }
                            }
                        }
                        for(int t=0 ;t<searchedDate.size();t++){
                            System.out.println(indexTourType2.get(t) +"."+indexTour2.get(t) + "-  " + searchedDate.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 2 :
                        System.out.println("choose a date");
                        System.out.println("\nenter the year:");
                        int year1 = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month1 = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day1 = in.nextInt();
                        Date searchedDateOfArrival1 = new Date(year1,month1,day1);
                        LinkedList<TourLeader> searchedDate1 = new LinkedList<>();
                        LinkedList<Integer> indexTourType3 = new LinkedList<>();
                        LinkedList<Integer> indexTour3 = new LinkedList<>();
                        for(int t=0 ; t<TourType.getTourTypes().size();t++){
                            for (int k=0 ; k<TourType.getTourTypes().get(t).getTours().size();k++){
                                if(Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfArrival(),searchedDateOfArrival1)==-1){
                                    searchedDate1.add(TourType.getTourTypes().get(t).getTours().get(k).theLeader);
                                    indexTourType3.add(t);
                                    indexTour3.add(k);
                                }
                            }
                        }
                        for(int t=0 ;t<searchedDate1.size();t++){
                            System.out.println(indexTourType3.get(t) +"."+indexTour3.get(t) + "-  " + searchedDate1.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 3 :
                        System.out.println("choose the first date");
                        System.out.println("\nenter the year:");
                        int year2 = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month2 = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day2 = in.nextInt();
                        Date searchedDateOfArrival2 = new Date(year2,month2,day2);
                        System.out.println("choose the second date");
                        System.out.println("\nenter the year:");
                        int year3 = in.nextInt();
                        System.out.println("\nenter the month:");
                        int month3 = in.nextInt();
                        System.out.println("\nenter the day:");
                        int day3 = in.nextInt();
                        Date searchedDateOfArrival3 = new Date(year3,month3,day3);
                        LinkedList<TourLeader> searchedDate2 = new LinkedList<>();
                        LinkedList<Integer> indexTourType4 = new LinkedList<>();
                        LinkedList<Integer> indexTour4 = new LinkedList<>();
                        for(int t=0 ; t<TourType.getTourTypes().size();t++){
                            for (int k=0 ; k<TourType.getTourTypes().get(t).getTours().size();k++){
                                if(Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfDeparture(),searchedDateOfArrival2)==1&&
                                        Date.compere(TourType.getTourTypes().get(t).getTours().get(k).getDayOfDeparture(),searchedDateOfArrival3)==-1){
                                    searchedDate2.add(TourType.getTourTypes().get(t).getTours().get(k).theLeader);
                                    indexTourType4.add(t);
                                    indexTour4.add(k);
                                }
                            }
                        }
                        for(int t=0 ;t<searchedDate2.size();t++){
                            System.out.println(indexTourType4.get(t) +"."+indexTour4.get(t) + "-  " + searchedDate2.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;


                }
                break;
            case 4 :
                System.out.println("enter the time length");
                int searchedTimeLength = in.nextInt();
                ArrayList<TourType> searchedTimeLengths = new ArrayList<>();
                ArrayList<Integer> index1 = new ArrayList<>();
                for(int t=0 ;t<TourType.getTourTypes().size();t++){
                    if(TourType.getTourTypes().get(t).getTimeLength() == searchedTimeLength){
                        searchedTimeLengths.add(TourType.getTourTypes().get(t));
                        index1.add(t);
                    }
                }
                for(int t=0 ;t<searchedTimeLengths.size();t++){
                    for(int k=0 ; k<searchedTimeLengths.get(t).getTours().size();k++)
                    System.out.println(index1.get(t) + "." + k +"-  " + searchedTimeLengths.get(t));
                }
                System.out.println("enter the index of a tour type then enter the index of a tour");
                i = in.nextInt();
                j = in.nextInt();
                editATour(i,j);
                break;
            case 5 :
                System.out.println("choose the region");
                Location.printAllLocations();
                int searchedRegion = in.nextInt();
                ArrayList<TourType> searchedRegions = new ArrayList<>();
                ArrayList<Integer> index2 = new ArrayList<>();
                for(int t=0 ;t<TourType.getTourTypes().size();t++){
                    if(TourType.getTourTypes().get(t).getRegion().equals(searchedRegion)){
                        searchedRegions.add(TourType.getTourTypes().get(t));
                        index2.add(t);
                    }
                }
                for(int t=0 ;t<searchedRegions.size();t++){
                    for(int k=0 ; k<searchedRegions.get(t).getTours().size();k++)
                        System.out.println(index2.get(t) + "." + k +"-  " + searchedRegions.get(t));
                }
                System.out.println("enter the index of a tour type then enter the index of a tour");
                i = in.nextInt();
                j = in.nextInt();
                editATour(i,j);
                break;
            case 6 :
                System.out.println("enter the place:");
                String searchedPlace = in.next();
                ArrayList<TourType> searchedPlaces = new ArrayList<>();
                ArrayList<Integer> index9 = new ArrayList<>();
                for(int t = 0 ; t<TourType.getTourTypes().size();t++){
                    for(int k=0 ;k<TourType.getTourTypes().get(t).getPlaces().size();k++){
                        if(TourType.getTourTypes().get(t).getPlaces().get(k).equals(searchedPlace)) {
                            searchedPlaces.add(TourType.getTourTypes().get(t));
                            index9.add(t);
                        }
                    }
                }
                for(int t=0 ;t<searchedPlaces.size();t++){
                    for(int k=0 ; k<searchedPlaces.get(t).getTours().size();k++)
                        System.out.println(index9.get(t) + "." + k +"-  " + searchedPlaces.get(t));
                }
                System.out.println("enter the index of a tour type then enter the index of a tour");
                i = in.nextInt();
                j = in.nextInt();
                editATour(i,j);
                break;
            case 7 :
                System.out.println("enter the maximum people");
                int searchedMaxPerson = in.nextInt();
                ArrayList<TourType> searchedMaxPeople = new ArrayList<>();
                ArrayList<Integer> index4 = new ArrayList<>();
                for(int t=0 ;t<TourType.getTourTypes().size();t++){
                    if(TourType.getTourTypes().get(t).getMaxPeople() == searchedMaxPerson){
                        searchedMaxPeople.add(TourType.getTourTypes().get(t));
                        index4.add(t);
                    }
                }
                for(int t=0 ;t<searchedMaxPeople.size();t++){
                    for(int k=0 ; k<searchedMaxPeople.get(t).getTours().size();k++)
                        System.out.println(index4.get(t) + "." + k +"-  " + searchedMaxPeople.get(t));
                }
                System.out.println("enter the index of a tour type then enter the index of a tour");
                i = in.nextInt();
                j = in.nextInt();
                editATour(i,j);
                break;
            case 8 :
                System.out.println("enter the minimum people");
                int searchedMinPerson = in.nextInt();
                ArrayList<TourType> searchedMinPeople = new ArrayList<>();
                ArrayList<Integer> index3 = new ArrayList<>();
                for(int t=0 ;t<TourType.getTourTypes().size();t++){
                    if(TourType.getTourTypes().get(t).getMinPeople() == searchedMinPerson){
                        searchedMinPeople.add(TourType.getTourTypes().get(t));
                        index3.add(t);
                    }
                }
                for(int t=0 ;t<searchedMinPeople.size();t++){
                    for(int k=0 ; k<searchedMinPeople.get(t).getTours().size();k++)
                        System.out.println(index3.get(t) + "." + k +"-  " + searchedMinPeople.get(t));
                }
                System.out.println("enter the index of a tour type then enter the index of a tour");
                i = in.nextInt();
                j = in.nextInt();
                editATour(i,j);
                break;
            case 9 :
                System.out.println("how: \n specific price(1)\n more than a price(2)\n less than a price(3)\n" +
                        " a price gap(4)");
                choice = in.nextInt();
                switch (choice){
                    case 1 :
                        System.out.println("enter the price");
                        int searchedPrice = in.nextInt();
                        ArrayList<TourType> searchedPrices = new ArrayList<>();
                        ArrayList<Integer> index5 = new ArrayList<>();
                        for(int t=0 ;t<TourType.getTourTypes().size();t++){
                            if(TourType.getTourTypes().get(t).getPrice() == searchedPrice) {
                                searchedPrices.add(TourType.getTourTypes().get(t));
                                index5.add(t);
                            }
                        }
                        for(int t=0 ;t<searchedPrices.size();t++){
                            for(int k=0 ; k<searchedPrices.get(t).getTours().size();k++)
                                System.out.println(index5.get(t) + "." + k +"-  " + searchedPrices.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 2 :
                        System.out.println("enter the minimum price");
                        int searchedMinPrice = in.nextInt();
                        ArrayList<TourType> searchedMinPrices = new ArrayList<>();
                        ArrayList<Integer> index6 = new ArrayList<>();
                        for(int t=0 ;t<TourType.getTourTypes().size();t++){
                            if(TourType.getTourTypes().get(t).getPrice() >= searchedMinPrice) {
                                searchedMinPrices.add(TourType.getTourTypes().get(t));
                                index6.add(t);
                            }
                        }
                        for(int t=0 ;t<searchedMinPrices.size();t++){
                            for(int k=0 ; k<searchedMinPrices.get(t).getTours().size();k++)
                                System.out.println(index6.get(t) + "." + k +"-  " + searchedMinPrices.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 3 :
                        System.out.println("enter the maximum price");
                        int searchedMaxPrice = in.nextInt();
                        ArrayList<TourType> searchedMaxPrices = new ArrayList<>();
                        ArrayList<Integer> index7 = new ArrayList<>();
                        for(int t=0 ;t<TourType.getTourTypes().size();t++) {
                            if (TourType.getTourTypes().get(t).getPrice() <= searchedMaxPrice){
                                searchedMaxPrices.add(TourType.getTourTypes().get(t));
                                index7.add(t);
                            }
                        }

                        for(int t=0 ;t<searchedMaxPrices.size();t++){
                            for(int k=0 ; k<searchedMaxPrices.get(t).getTours().size();k++)
                                System.out.println(index7.get(t) + "." + k +"-  " + searchedMaxPrices.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                    case 4 :
                        System.out.println("enter the minimum then the maximum price:");
                        int searchedMinPrice1 = in.nextInt();
                        int searchedMaxPrice1 = in.nextInt();
                        ArrayList<TourType> searchedGapPrices = new ArrayList<>();
                        ArrayList<Integer> index8 = new ArrayList<>();
                        for(int t=0 ;t<TourType.getTourTypes().size();t++){
                            if(TourType.getTourTypes().get(t).getPrice() >= searchedMinPrice1 && TourType.getTourTypes().get(t).getPrice() <=searchedMaxPrice1){
                                searchedGapPrices.add(TourType.getTourTypes().get(t));
                                index8.add(t);
                            }
                        }
                        for(int t=0 ;t<searchedGapPrices.size();t++){
                            for(int k=0 ; k<searchedGapPrices.get(t).getTours().size();k++)
                                System.out.println(index8.get(t) + "." + k +"-  " + searchedGapPrices.get(t));
                        }
                        System.out.println("enter the index of a tour type then enter the index of a tour");
                        i = in.nextInt();
                        j = in.nextInt();
                        editATour(i,j);
                        break;
                }
                break;
        }
    }


    public Date getDayOfDeparture() {
        return dayOfDeparture;
    }

    public void setDayOfDeparture(Date dayOfDeparture) {
        dayOfDeparture = dayOfDeparture;
    }

    public Date getDayOfArrival() {
        return dayOfArrival;
    }

    public void setDayOfArrival(Date dayOfArrival) {
        dayOfArrival = dayOfArrival;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public TourLeader getTheLeader() {
        return theLeader;
    }

    public void setTheLeader(TourLeader theLeader) {
        this.theLeader = theLeader;
    }

    public static void  printAllTours(){
        for(int i = 0 ; i<TourType.getTourTypes().size();i++){
            for(int j = 0 ;j<TourType.getTourTypes().get(i).getTours().size();j++){
                System.out.println(i+"."+j+"-  "+ TourType.getTourTypes().get(i).getTours().get(j)+"\n");
            }
        }
    }





    public String toString() {
        return "InternalTour{" +
                "DayOfDeparture=" + dayOfDeparture +
                ", DayOfArrival=" + dayOfArrival +
                ", type=" + type +
                ", theLeader=" + theLeader +
                '}';
    }
}
