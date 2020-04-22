package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Scanner;

public class Employee extends Person{
    private static LinkedList<Employee> employees = new LinkedList<>();
    private Date dateOfEmployment;
    private int baseSalary;

    public Employee(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public static LinkedList<Employee> getEmployees() {
        return employees;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public static void addAEmployee(){
        Scanner in = new Scanner(System.in);
        Employee newEmployee = new Employee(2);
        Person.addAPerson(newEmployee);
        System.out.println("enter the date of employment\n");
        newEmployee.setDateOfEmployment(Date.dateMaker());
        System.out.println("enter the base salary:");
        int newBaseSalary = in.nextInt();
        newEmployee.setBaseSalary(newBaseSalary);
        employees.add(newEmployee);
    }

    public static void printEmployees(){
        for(int i = 0 ; i<employees.size(); i++){
            System.out.println(i + "-" + employees.get(i).toString() + "\n");
        }
    }

    public static void removeAnEmployee(){
        Scanner in = new Scanner(System.in);
        System.out.println("choose an employee to remove");
        printEmployees();
        int i = in.nextInt();
        employees.remove(i);
    }

    public static void editAnEmployee(int i){
        Scanner in = new Scanner(System.in);
        Person changingPerson = employees.get(i);
        changingPerson = editAPerson(changingPerson);
        if(!changingPerson.editedOrNot) {
            employees.set(i, (Employee) changingPerson);
            System.out.println("what do you want to change:\n date of employment(1) \n base salary(2)");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("this is the old date of employment: " + employees.get(i).dateOfEmployment +
                            "\nenter the new date of employment");
                    System.out.println("\nenter the new year of employment:");
                    int newYear = in.nextInt();
                    System.out.println("\nenter the new month of employment:");
                    int newMonth = in.nextInt();
                    System.out.println("\nenter the new day of employment:");
                    int newDay = in.nextInt();
                    Date newDate = new Date(newYear, newMonth, newDay);
                    employees.get(i).setDateOfEmployment(newDate);
                    break;
                case 2:
                    System.out.println("this is the old base salary: " + employees.get(i).baseSalary +
                            "enter the new base salary: ");
                    int newBaseSalary = in.nextInt();
                    employees.get(i).setBaseSalary(newBaseSalary);
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
