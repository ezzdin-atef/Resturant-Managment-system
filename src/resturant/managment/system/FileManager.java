
package resturant.managment.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    public boolean write(String Query, String FilePath, boolean appendType) {
        PrintWriter writer = null;
        try {
            //System.out.print("\nwritting in ! " + FilePath);
            writer = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writer.println(Query);

            //System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writer.close();
        }
        return false;
    }
    public ArrayList<Object> read(String FilePath) {
        Scanner Reader = null;
        try {
            //System.out.println("Reading ! From " + FilePath);
            Reader = new Scanner(new File(FilePath));
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
        if (FilePath.equals("person.txt")) {
            ArrayList<Person> Persons = new ArrayList<Person>();
            Admin x;
            
            while (Reader.hasNext()) {
                x = new Admin();
                String Line = Reader.nextLine();
                String[] seprator = Line.split("@");
                
                // 1@Admin@Admin@Ezzdin@Atef
                x.setId(Integer.parseInt(seprator[0]));
                x.setUsername(seprator[1]);
                x.setPassword(seprator[2]);
                x.setFname(seprator[3]);
                x.setLname(seprator[4]);
                x.setFlag(Integer.parseInt(seprator[5]));
                Persons.add(x);
            }
            return (ArrayList<Object>) (Object) Persons;
        }else if (FilePath.equals("Customer.txt")) {
            ArrayList<Customer> Customers = new ArrayList<Customer>();
            Customer x;
            
            while (Reader.hasNext()) {
                x = new Customer();
                String Line = Reader.nextLine();
                String[] seprator = Line.split("@");
                
                x.setId(Integer.parseInt(seprator[0]));
                x.setFname(seprator[1]);
                x.setLname(seprator[2]);
                Customers.add(x);
            }
            return (ArrayList<Object>) (Object) Customers;
        }else if (FilePath.equals("Meal.txt")) {
            ArrayList<Meal> Meals = new ArrayList<Meal>();
            Meal x;
            
            while (Reader.hasNext()) {
                x = new Meal();
                String Line = Reader.nextLine();
                String[] seprator = Line.split("@");
                
                x.setPrice(Double.parseDouble(seprator[0]));
                x.setName(seprator[1]);
                x.setDiscount(Double.parseDouble(seprator[2]));
                x.setFlag(Integer.parseInt(seprator[3]));
                Meals.add(x);
            }
            return (ArrayList<Object>) (Object) Meals;
        }else if (FilePath.equals("Order.txt")) {
            ArrayList<Order> Orders = new ArrayList<Order>();
            Order x;
            
            while (Reader.hasNext()) {
                x = new Order();
                String Line = Reader.nextLine();
                String[] seprator = Line.split("@");
                
                x.setCustomerID(Integer.parseInt(seprator[0]));
                x.setPayment(Double.parseDouble(seprator[1]));
                x.setNewOrder(seprator[2]);
                Orders.add(x);
            }
            return (ArrayList<Object>) (Object) Orders;
        }else if (FilePath.equals("Gifts.txt")) {
            ArrayList<Offer> Gifts = new ArrayList<Offer>();
            Offer x;
            
            while (Reader.hasNext()) {
                x = new Offer();
                String Line = Reader.nextLine();
                String[] seprator = Line.split("@");
                
                x.setGift(seprator[0]);
                x.setMaxPayment(Double.parseDouble(seprator[1]));
                x.setFlag(Integer.parseInt(seprator[2]));
                Gifts.add(x);
            }
            return (ArrayList<Object>) (Object) Gifts;
        } else {
            return null;
        }
    }
}
