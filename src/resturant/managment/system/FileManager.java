
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
        if (FilePath.equals("Admin.txt")) {
            ArrayList<Admin> Admin = new ArrayList<Admin>();
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
                Admin.add(x);
            }
            return (ArrayList<Object>) (Object) Admin;
        }else if (FilePath.equals("Employees.txt")) {
            ArrayList<Emplyee> Emplyees = new ArrayList<Emplyee>();
            Emplyee x;
            
            while (Reader.hasNext()) {
                x = new Emplyee();
                String Line = Reader.nextLine();
                String[] seprator = Line.split("@");
                
                x.setId(Integer.parseInt(seprator[0]));
                x.setFname(seprator[1]);
                x.setLname(seprator[2]);
                Emplyees.add(x);
            }
            return (ArrayList<Object>) (Object) Emplyees;
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
                
                x.setPrice(Integer.parseInt(seprator[0]));
                x.setName(seprator[1]);
                Meals.add(x);
            }
            return (ArrayList<Object>) (Object) Meals;
        } else {
            return null;
        }
    }
}
