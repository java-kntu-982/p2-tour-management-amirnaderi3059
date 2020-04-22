package ir.ac.kntu;


import java.util.LinkedList;
import java.util.Scanner;

public class Customer extends Person{
    private static LinkedList<Customer> Customers = new LinkedList<>();

    public static LinkedList<Customer> getCustomers() {
        return Customers;
    }

    public Customer(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public static void addACustomer(){
        Customer customer = new Customer(3);
        Person.addAPerson(customer);
        Customers.add(customer);
    }

    public static void printCustomers(){
        for(int i = 0 ; i<Customers.size(); i++){
            System.out.println(i + "-" + Customers.get(i).toString() + "\n");
        }
    }

    public static void editACustomer(int i){
        Person changingPerson = Customers.get(i);
        changingPerson = editAPerson(changingPerson);
        Customers.set(i,(Customer) changingPerson);
    }

    public static void removeACustomer(){
        Scanner in = new Scanner(System.in);
        System.out.println("choose a customer to remove");
        printCustomers();
        int i = in.nextInt();
        Customers.remove(i);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
