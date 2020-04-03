package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;


public class Location {
    public static LinkedList<Location> locations = new LinkedList<>();
    private String nameOfTheRegion;
    private Boolean insideOrOutsideOfIran;

    public static void addALocation() {
        Scanner in = new Scanner(System.in);
        Location newLocation = new Location();
        System.out.println("enter the region name:");
        String newNameOfTheRegion = in.next();
        newLocation.setNameOfTheRegion(newNameOfTheRegion);
        System.out.println("enter true if the region is inside the country and enter false if otherwise");
        Boolean newInsideOrOutsideOfIran = in.nextBoolean();
        newLocation.setInsideOrOutsideOfIran(newInsideOrOutsideOfIran);
        Location.locations.addLast(newLocation);
    }

    public static void editALocation(int locationIndex) {
        Scanner in = new Scanner(System.in);
        System.out.println("choose what you want to change about this region:\n region's name(1)" +
                " \n whether inside or outside of the country(2) ");
        int choice = in.nextInt();
        switch(choice){
            case 1 :
                System.out.println("old name of the region:  " + locations.get(locationIndex).getNameOfTheRegion() +
                        "\n \n enter the new name:");
                String newNameOfTheRegion = in.next();
                locations.get(locationIndex).setNameOfTheRegion(newNameOfTheRegion);
                break;
            case 2 :
                System.out.println("whether it was inside or outside of the country\n " +
                        "(true means it was inside and false means outside):  " +
                        locations.get(locationIndex).getInsideOrOutsideOfIran() +
                        "\nenter the new situation of the region(true means it was inside and false means outside): ");
                Boolean newInsideOrOutsideOfIran = in.nextBoolean();
                locations.get(locationIndex).setInsideOrOutsideOfIran(newInsideOrOutsideOfIran);
                break;

        }
    }

    public static void removeALocation() {
        Scanner in = new Scanner(System.in);
        System.out.println("choose a region to remove:");
        printAllLocations();
        int choice = in.nextInt();
        locations.remove(choice);
    }

    public Boolean getInsideOrOutsideOfIran() {
        return insideOrOutsideOfIran;
    }

    public void setInsideOrOutsideOfIran(Boolean insideOrOutsideOfIran) {
        this.insideOrOutsideOfIran = insideOrOutsideOfIran;
    }

    public String getNameOfTheRegion() {
        return nameOfTheRegion;
    }

    public void setNameOfTheRegion(String nameOfTheRegion) {
        this.nameOfTheRegion = nameOfTheRegion;
    }

    public static void printAllLocations(){
        for(int i=0 ; i<locations.size();i++){
            System.out.println(i+"-  "+locations.get(i).toString()+ "\n");
        }
    }



    public String toString() {
        return "Location{" +
                "nameOfTheRegion='" + nameOfTheRegion + '\'' +
                ", insideOrOutsideOfIran=" + insideOrOutsideOfIran +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(nameOfTheRegion, location.nameOfTheRegion) &&
                Objects.equals(insideOrOutsideOfIran, location.insideOrOutsideOfIran);
    }

    public int hashCode() {
        return Objects.hash(nameOfTheRegion, insideOrOutsideOfIran);
    }
}
