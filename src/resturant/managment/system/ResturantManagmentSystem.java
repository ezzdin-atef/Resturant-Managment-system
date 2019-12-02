
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
                    System.out.println(
                            "Enter 1 To Change Your Information\n"
                                    + "Enter 2 to add new Emplyee\n"
                                    + "Enter 3 to delete an emplyee with his id\n"
                                    + "Enter 4 Seaech about emplyee\n"
                                    + "Enter 5 Display all emplyees\n"
                                    + "Enter 6 Update an emplyee\n"
                                    + "Enter 7 to add new Meal\n"
                                    + "Enter 8 to delete an Meal\n"
                                    + "Enter 9 Seaech about Meal\n"
                                    + "Enter 10 Display all Meals\n"
                                    + "Enter 11 Update an Meal\n"
                                    + "Enter 12 add new offer\n"
                                    + "Enter 13 update an offer\n"
                                    + "Enter 14 Display all offers\n"
                                    + "Enter 15 delete an offer\n"
                                    + "Enter 16 Add Discount to a meal");
                    Admin x = new Admin();
                    int num;
                    num = in.nextInt();
                    in.nextLine();
                    switch (num) {
                        case 1: // Change Your Information
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
                        case 2: // add new Emplyee
                            System.out.print("First Name: ");
                            String fname = in.nextLine();
                            System.out.print("Last Name: ");
                            String lname = in.nextLine();
                            System.out.print("Username: ");
                            newuser = in.nextLine();
                            System.out.print("Password: ");
                            newpass = in.nextLine();
                            x.addNewEmplyee(fname, lname, newuser, newpass);
                            break;
                        case 3: // delete an emplyee with his id
                            System.out.print("Enter Id: ");
                            int idtodel = in.nextInt();
                            x.deleteEmplyee(idtodel);
                            break;
                        case 4: // Seaech about emplyee
                            System.out.print("Enter Id: ");
                            int idsearch = in.nextInt();
                            x.searchForEmplyee(idsearch);
                            break;
                        case 5: // Display all emplyees
                            x.displayEmplyees();
                            break;
                        case 6: // Update an emplyee
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
                        case 7: // add new Meal
                            System.out.print("Name of the meal: ");
                            String name = in.nextLine();
                            System.out.print("Price of The meal: ");
                            double price = in.nextDouble();
                            x.addNewMeal(price, name);
                            break;
                        case 8: // delete an Meal
                            System.out.print("Enter The Name of The Meal To Be Deleted: ");
                            name = in.nextLine();
                            x.deleteMeal(name);
                            break;
                        case 9: // Seaech about Meal
                            System.out.print("Enter Name Of The Meal: ");
                            name = in.nextLine();
                            x.searchForMeal(name);
                            break;
                        case 10: // Display all Meals
                            x.displayMeals();
                            break;
                        case 11: // Update an Meal
                            Meal m = new Meal();
                            System.out.print("Enter The Name of The Meal Thats You want to update: ");
                            name = in.nextLine();
                            System.out.print("Enter the new price: ");
                            price = in.nextDouble();
                            m.setName(name);
                            m.setPrice(price);
                            x.updateMeal(name, m);
                            break;
                        case 12: // add new offer
                            System.out.print("Enter The Gift Name: ");
                            String giftName = in.nextLine();
                            System.out.print("Enter The Max Payment That Need To Be Reach: ");
                            double maxPayment = in.nextDouble();
                            x.addNewOffer(giftName, maxPayment);
                            break;
                        case 13: // update an offer
                            System.out.print("Enter The Old Gift Name: ");
                            String oldGiftName = in.nextLine();
                            System.out.print("Enter The New Gift Name: ");
                            giftName = in.nextLine();
                            System.out.print("Enter The New Max Payment:");
                            maxPayment = in.nextInt();
                            Offer offer = new Offer(maxPayment, giftName);
                            x.updateOffer(oldGiftName, offer);
                            break;
                        case 14: // Display all offers
                            x.displayAllOffers();
                            break;
                        case 15: // delete an offer
                            System.out.print("Enter The Gift Name To Be Deleted: ");
                            giftName = in.nextLine();
                            x.deleteOffer(giftName);
                            break;
                        case 16: // Add Discount to a meal
                            System.out.print("Enter The Name of The Meal Thats You want to add discount: ");
                            name = in.nextLine();
                            System.out.print("Enter The discount: ");
                            double discount = in.nextDouble();
                            x.addDiscount(name, discount);
                            break;
                    }
                } else {
                    System.out.println("Username or Password is wrong!");
                }
                break;
            case 2:
                Emplyee e = new Emplyee();
                System.out.print("Username: ");
                user = in.nextLine();
                System.out.print("Password: ");
                ps = in.nextLine();
                if (e.login(user, ps)) {
                    System.out.println("Welcome " + e.getFname(user));
                    e.notification();
                    System.out.println(
                            "Enter 1 to update your information\n"
                                    + "Enter 2 to add new customer\n"
                                    + "Enter 3 to delete an customer with his id\n"
                                    + "Enter 4 Seaech about customer\n"
                                    + "Enter 5 Display all customers\n"
                                    + "Enter 6 Update an customer\n"
                                    + "Enter 7 Add new order\n"
                                    + "Enter 8 Display all orders\n"
                                    + "Enter 9 Cancel order\n"
                                    + "Enter 10 to show the bill of a customer");
                    int enter = in.nextInt();
                    in.nextLine();
                    switch (enter) {
                        case 1: // update your information
                            Emplyee x = new Emplyee();
                            System.out.print("Enter new first name: ");
                            String fname = in.nextLine();
                            System.out.print("Enter new last name: ");
                            String lname = in.nextLine();
                            System.out.print("Username: ");
                            user = in.nextLine();
                            System.out.print("Password: ");
                            ps = in.nextLine();
                            x.setFname(fname);
                            x.setLname(lname);
                            x.setUsername(user);
                            x.setPassword(ps);
                            x.setId(e.getId());
                            e.updateEmplyee(e.getId(), x);
                            break;
                        case 2: // add new customer
                            System.out.print("Enter new first name: ");
                            fname = in.nextLine();
                            System.out.print("Enter new last name: ");
                            lname = in.nextLine();
                            e.addNewCustomer(fname, lname);
                            break;
                        case 3: // delete an customer with his id
                            System.out.print("Enter the customer id to be deleted: ");
                            int customerId = in.nextInt();
                            e.deleteCustomer(customerId);
                            break;
                        case 4: // Seaech about customer
                            System.out.print("Enter the customer id to search about him : ");
                            customerId = in.nextInt();
                            e.searchForCustomer(customerId);
                            break;
                        case 5: // Display all customers
                            e.displayCustomers();
                            break;
                        case 6: // Update an customer
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
                        case 7: // Add new order
                            System.out.print("Enter Customer Id:");
                            customerId = in.nextInt();
                            in.nextLine();
                            String o;
                            System.out.print("Enter Customer Orders and between an order and the other an space and to end type '-1': ");
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
                        case 8: // Display all orders
                            e.displayOrders();
                            break;
                        case 9: // Cancel order
                            System.out.print("Enter Customer Id:");
                            customerId = in.nextInt();
                            e.CancelOrder(customerId);
                            break;
                        case 10: // show the bill of a customer
                            System.out.print("Enter customer id to show his bill: ");
                            customerId = in.nextInt();
                            System.out.println("the bill: " + e.getBill(customerId) + "$");
                            Offer gift = new Offer();
                            System.out.println(gift.checkPayment(e.getBill(customerId)));
                            break;
                    }
                } else {
                    System.out.println("ID Not Found!!");
                }
                break;
                
        }
    }
    
}
