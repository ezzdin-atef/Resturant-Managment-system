
package resturant.managment.system;

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
                            System.out.println("Price of The meal: ");
                            int price = in.nextInt();
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
                            price = in.nextInt();
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
                System.out.println("Not Working Yet ^_^");
                break;
        }
    }
    
}
