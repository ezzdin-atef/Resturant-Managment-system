
package resturant.managment.system;

import java.util.ArrayList;
import java.util.Scanner;

public class ResturantManagmentSystem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 to log in as admin\nEnter 2 to log in as emplyee");
        int log = in.nextInt();
        in.nextLine();
        switch (log) {
            case 1:
                Admin adm = new Admin();
                String user, ps;
                System.out.print("Username: ");
                user = in.nextLine();
                System.out.print("Password: ");
                ps = in.nextLine();
                if (adm.login(user, ps)) {
                    System.out.println("Enter 1 To Change Your Information\nEnter 2 to add new Emplyee\nEnter 3 to delete an emplyee with his id\nEnter 4 Seaech about emplyee\nEnter 5 Display all emplyees\nEnter 6 Update an emplyee\nEnter 7 to add new Meal\nEnter 8 to delete an Meal\nEnter 9 Seaech about Meal\nEnter 10 Display all Meals\nEnter 11 Update an Meal");
                    Admin x = new Admin();
                    int num;
                    num = in.nextInt();
                    in.nextLine();
                    switch (num) {
                        case 1:
                            System.out.print("Username: ");
                            String newuser = in.nextLine();
                            System.out.print("Password: ");
                            String newpass = in.nextLine();
                            System.out.print("First Name: ");
                            String nfname = in.nextLine();
                            System.out.print("Last Name: ");
                            String nlname = in.nextLine();
                            x.setUsername(newuser);
                            x.setPassword(newpass);
                            x.setFname(nfname);
                            x.setLname(nlname);
                            adm.UpdateAdmin(x);
                            break;
                        case 2:
                            System.out.print("First Name: ");
                            String fname = in.nextLine();
                            System.out.print("Last Name: ");
                            String lname = in.nextLine();
                            x.addNewEmplyee(fname, lname);
                            break;
                        case 3:
                            System.out.print("Enter Id: ");
                            int idtodel = in.nextInt();
                            x.deleteEmplyee(idtodel);
                            break;
                        case 4:
                            System.out.print("Enter Id: ");
                            int idsearch = in.nextInt();
                            x.searchForEmplyee(idsearch);
                            break;
                        case 5:
                            x.displayEmplyees();
                            break;
                        case 6:
                            Emplyee e = new Emplyee();
                            System.out.print("Enter Id: ");
                            int updateid = in.nextInt();
                            in.nextLine();
                            System.out.print("Enter first name: ");
                            String firstname = in.nextLine();
                            System.out.print("Enter last name: ");
                            String lastname = in.nextLine();
                            e.setFname(firstname);
                            e.setLname(lastname);
                            x.updateEmplyee(updateid, e);
                            break;   
                        case 7:
                            System.out.print("Name of the meal: ");
                            String name = in.nextLine();
                            System.out.print("Price of The meal: ");
                            double price = in.nextDouble();
                            x.addNewMeal(price, name);
                            break;
                        case 8:
                            System.out.print("Enter The Name of The Meal To Be Deleted: ");
                            name = in.nextLine();
                            x.deleteMeal(name);
                            break;
                        case 9:
                            System.out.print("Enter Name Of The Meal: ");
                            name = in.nextLine();
                            x.searchForMeal(name);
                            break;
                        case 10:
                            x.displayMeals();
                            break;
                        case 11:
                            Meal m = new Meal();
                            System.out.print("Enter The Name of The Meal Thats You want to update: ");
                            name = in.nextLine();
                            System.out.print("Enter the new price: ");
                            price = in.nextDouble();
                            m.setName(name);
                            m.setPrice(price);
                            x.updateMeal(name, m);
                            break;
                    }
                } else {
                    System.out.println("Username or Password is wrong!");
                }
                break;
            case 2:
                Emplyee e = new Emplyee();
                System.out.print("Enter Your ID: ");
                int ID = in.nextInt();
                if (e.login(ID)) {
                    System.out.println("Welcome ");
                    System.out.println("Enter 1 to update your information\nEnter 2 to add new customer\nEnter 3 to delete an customer with his id\nEnter 4 Seaech about customer\nEnter 5 Display all customers\nEnter 6 Update an customer\nEnter 7 Add new order\nEnter 8 Display all orders\nEnter 9 Cancel order");
                    int enter = in.nextInt();
                    in.nextLine();
                    switch (enter) {
                        case 1:
                            Emplyee x = new Emplyee();
                            System.out.print("Enter new first name: ");
                            String fname = in.nextLine();
                            System.out.print("Enter new last name: ");
                            String lname = in.nextLine();
                            x.setFname(fname);
                            x.setLname(lname);
                            x.setId(ID);
                            e.updateEmplyee(ID, x);
                            break;
                        case 2:
                            System.out.print("Enter new first name: ");
                            fname = in.nextLine();
                            System.out.print("Enter new last name: ");
                            lname = in.nextLine();
                            e.addNewCustomer(fname, lname);
                            break;
                        case 3:
                            System.out.print("Enter the customer id to be deleted: ");
                            int customerId = in.nextInt();
                            e.deleteCustomer(customerId);
                            break;
                        case 4:
                            System.out.print("Enter the customer id to search about him : ");
                            customerId = in.nextInt();
                            e.searchForCustomer(customerId);
                            break;
                        case 5:
                            e.displayCustomers();
                            break;
                        case 6:
                            Customer c = new Customer();
                            System.out.print("Enter the customer id to update his information : ");
                            customerId = in.nextInt();
                            in.nextLine();
                            System.out.print("Enter new first name: ");
                            fname = in.nextLine();
                            System.out.print("Enter new last name: ");
                            lname = in.nextLine();
                            c.setFname(fname);
                            c.setLname(lname);
                            e.updateCustomer(customerId, c);
                            break;
                        case 7:
                            System.out.print("Enter Customer Id:");
                            customerId = in.nextInt();
                            in.nextLine();
                            String o;
                            System.out.print("Enter Customer Orders and between an order and the other an space: ");
                            ArrayList<String> newOrder = new ArrayList<String>();
                            while (true) {
                                o = in.nextLine();
                                if (o.equals("-1")) {
                                    break;
                                } else {
                                    newOrder.add(o);
                                }
                            }
                            e.addNewOrder(customerId, newOrder);
                            break;
                        case 8:
                            e.displayOrders();
                            break;
                        case 9:
                            System.out.print("Enter Customer Id:");
                            customerId = in.nextInt();
                            e.CancelOrder(customerId);
                            break;
                    }
                } else {
                    System.out.println("ID Not Found!!");
                }
                break;
                
        }
    }
    
}
