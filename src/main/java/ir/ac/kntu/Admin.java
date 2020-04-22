package ir.ac.kntu;

import java.util.Scanner;

public class Admin extends Person {


    public Admin(int accessLevel) {
        this.accessLevel = accessLevel;
    }


    public static Admin addAnAdmin(){
        Admin newAdmin = new Admin(1);
        Person.addAPerson(newAdmin);
        return newAdmin;

    }

    public static void editAdmin(Admin theAdmin){
        Scanner in = new Scanner(System.in);
        System.out.println("what do you want to change about the admin?\n username(1)\n password(2)");
        int choice = in.nextInt();
        if(choice==1){
            System.out.println("this is is the old username of the admin: " + theAdmin.userName
            + "\nenter the new username");
            String newUsername = in.next();
            theAdmin.setUserName(newUsername);
        }else{
            System.out.println("this is is the old password of the admin: " + theAdmin.password
                    + "\nenter the new password");
            String newPassword = in.next();
            theAdmin.setPassword(newPassword);
        }
    }


}
