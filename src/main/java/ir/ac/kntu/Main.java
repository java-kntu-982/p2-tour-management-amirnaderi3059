package ir.ac.kntu;


import java.util.Scanner;

import static ir.ac.kntu.Menu.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Date today =  todayCalculator();
        ageOfEveryone(today);
        System.out.println("admin information required:\n");
        Admin theAdmin = Admin.addAnAdmin();
        boolean flag = true;
        boolean flag1 = true;
        while (flag) {
            Menu.entrance(theAdmin);
            while(flag1) {
                System.out.println("\nchoose :\n access people(1)\n access tours and locations and map(2)\n log out(3)");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        peopleAccess(theAdmin);
                        break;
                    case 2:
                        tourAccess();
                        break;
                    case 3:
                        flag1 = false;
                        break;
                }
            }
            flag1 = true;
            System.out.println("\nif you want to login enter 1 and if you want to end the program enter 2");
            int bool = in.nextByte();
            if(bool==2){
                flag = false;
            }
        }
    }
}
