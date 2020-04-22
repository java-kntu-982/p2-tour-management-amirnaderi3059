package ir.ac.kntu;

import java.util.Scanner;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }





    private void checkAndSetDate(int year, int month, int day) {
        if (checkInputs(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
    }


    private boolean checkInputs(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || month > 6
                && day == 31) {
            return false;
        }
        return month != 12 || day != 30 || isLeapYear(year);
    }


    public int getYear() {
        return year;
    }


    public int getMonth() {
        return month;
    }


    public int getDay() {
        return day;
    }



    public String toString() {
        return year + "-" + month + "-" + day;
    }


    public Date nextDay() {
        Date curDate = new Date(this);
        Date nextDate = new Date(this);
        if (curDate.month == 12) {
            handleTheLastMonth(curDate, nextDate);
        } else if (curDate.day < 30) {
            curDate.day++;
        } else if (curDate.day == 30 && curDate.month < 7) {
            nextDate.day++;
        } else {
            nextDate.day = 1;
            nextDate.month++;
        }
        return nextDate;
    }


    private void handleTheLastMonth(Date curDate, Date nextDate) {
        int endOfMonthDay = 29;
        if (isLeapYear(curDate.year)) {
            endOfMonthDay = 30;
        }
        if (curDate.day == endOfMonthDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    public static int compere(Date date1,Date date2){
        if(date1.year>date2.year){
            return 1;
        }
        else if(date1.year==date2.year){
            if(date1.month>date2.month){
                return 1;
            }
            else if(date1.month==date2.month){
                if(date1.day>date2.day){
                    return 1;
                }
                else if(date1.day==date2.day){
                    return 0;
                }
            }
        }
        return -1;
    }


    private static boolean isLeapYear(int year) {
        int firstFraction, secondFraction;
        final double a = 0.025d;
        final double b = 266d;
        double c, d;
        if (year > 0) {
            c = ((year + 38) % 2820) * 0.24219 + a;
            d = ((year + 39) % 2820) * 0.24219 + a;
        } else if (year < 0) {
            c = ((year + 39) % 2820) * 0.24219 + a;
            d = ((year + 40) % 2820) * 0.24219 + a;
        } else {
            return false;
        }
        firstFraction = (int) ((c - Math.floor(c)) * 1000);
        secondFraction = (int) ((d - Math.floor(d)) * 1000);
        return firstFraction <= b && secondFraction > b;
    }


    public static Date dateMaker() {
        Scanner in = new Scanner(System.in) ;
        System.out.println("enter the year:");
        int year = in.nextInt();
        System.out.println("enter the month:");
        int month = in.nextInt();
        System.out.println("enter the day:");
        int day = in.nextInt();
        return new Date(year,month,day);
    }


}
