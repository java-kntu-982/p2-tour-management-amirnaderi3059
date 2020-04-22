package ir.ac.kntu;

import java.util.Scanner;

public class Person {
    protected static Person currentUser;
    protected String userName;
    protected String password;
    protected String email;
    protected int phoneNumber;
    protected int accessLevel;
    protected boolean editedOrNot;

    public Person(){

    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public static Person getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Person currentUser) {
        Person.currentUser = currentUser;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void addAPerson(Person newPerson){
        Scanner in = new Scanner(System.in);
        System.out.println("enter his/her userName:");
        String newUserName = in.next();
        newPerson.setUserName(newUserName);
        System.out.println("enter his/her password:");
        String newPassword = in.next();
        newPerson.setPassword(newPassword);
        System.out.println("enter his/her email:");
        String newEmail = in.next();
        newPerson.setEmail(newEmail);
        System.out.println("enter his/her phone number:");
        int newPhoneNumber = in.nextInt();
        newPerson.setPhoneNumber(newPhoneNumber);
    }

    public static Person editAPerson(Person changingPerson){
        Scanner in = new Scanner(System.in);
        System.out.println("what do you want to change about him/her: \n username(1) \n password(2) \n email(3) \n phone number(4)" +
                "\n none of the above(5)");
        int choice = in.nextInt();
        switch(choice){
            case 1:
                System.out.println("the old username: " + changingPerson.userName + "\nenter the new username");
                String newUsername = in.next();
                changingPerson.setUserName(newUsername);
                changingPerson.editedOrNot = true;
                break;
            case 2:
                System.out.println("the old password: " + changingPerson.password + "\nenter the password");
                String newPassword = in.next();
                changingPerson.setPassword(newPassword);
                changingPerson.editedOrNot = true;
                break;
            case 3:
                System.out.println("the old email: " + changingPerson.email + "\nenter the new email");
                String newEmail = in.next();
                changingPerson.setEmail(newEmail);
                changingPerson.editedOrNot = true;
                break;
            case 4:
                System.out.println("the old phone number: " + changingPerson.phoneNumber + "\nenter the new phone number");
                int newPhoneNumber = in.nextInt();
                changingPerson.setPhoneNumber(newPhoneNumber);
                changingPerson.editedOrNot = true;
                break;
            case 5:
                changingPerson.editedOrNot = false;
                break;
        }
        return changingPerson;
    }

    public static boolean peopleEntrance(Person enteringPerson){
        Scanner in = new Scanner(System.in);
        System.out.println("enter your user name:");
        String username = in.next();
        System.out.println("\nenter your password:");
        String password = in.next();
        if(username.equals(enteringPerson.userName) && password.equals(enteringPerson.password)){
            System.out.println("true");
            return true;
        }else{
            System.out.println("false");
            return false;
        }
    }
}
