
package resturant.managment.system;

import java.io.Serializable;
import java.util.ArrayList;
public class Emplyee extends Person implements Serializable {
    
    public Emplyee() {}
    public Emplyee(String fname, String lname, String username, String pass) {
        super(fname, lname, username, pass);
        setFlag(0);
    }
    
    public boolean addEmplyee() {
        Persons.add(this);
        return FManager.write(PersonFileName, Persons);
    }
    private int getEmlyeeIndex(int id){
        for (int i = 0; i < Persons.size(); i++)
            if(Persons.get(i).getId()== id)
                return i;
        
        return -1;
    }
    
    public String displayAllEmplyee() {
        loadFromFile();
        String S = "\nAll Emplyees Data:\n";
        for (Person x : Persons) {
            if (x.getFlag() == 0)
                S = S + x.toString();
        }
        return S;
    }
    
    public String searchEmplyee(int id){
        loadFromFile();
        int index = getEmlyeeIndex(id);
        if(index != -1)
            return "\nFound ...!" + Persons.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateEmplyee(int oldID, Emplyee x){
        loadFromFile();
        int index = getEmlyeeIndex(oldID);
        x.id = Persons.get(index).id;
        Persons.set(index, x);
        commitToFile();
    } 
    
    public void deleteEmplyee(int id){
        loadFromFile();
        int index = getEmlyeeIndex(id);
        Persons.remove(index);
        commitToFile();
    } 
    public String getFname(String user) {
        loadFromFile();
        int index = -1;
        for (int i = 0; i < Persons.size(); i++)
            if(Persons.get(i).getUsername().equals(user))
                index = i;
        return Persons.get(index).getFname();
    }
    /*================================Start Customer Part================================*/
    public void addNewCustomer(String fname, String lname) {
        Customer x = new Customer(fname, lname);
        if (x.addCustomer()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayCustomers() {
        Customer x = new Customer();
        System.out.println(x.displayAllCustomer());
    }

    public void searchForCustomer(int id) {
        Customer x = new Customer();
        System.out.println(x.searchCustomer(id));
    }

    public void updateCustomer(int oldID, Customer newCustomerValues) {
        Customer x = new Customer();
        x.updateCustomer(oldID, newCustomerValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteCustomer(int Id) {
        Customer x = new Customer();
        x.deleteCustomer(Id);
        System.out.println("deleted Successfully ... !");
    }
    public void displayCustomerProfile(int id) {
        Customer c = new Customer();
        System.out.println(c.searchCustomer(id) + "\n");
        Order o = new Order();
        System.out.println(o.getAllOrderToCustomer(id));
    }
    /*================================End Customer Part================================*/
    /*================================Start Order Part================================*/
    public void addNewOrder(int customerId, ArrayList<String> orders) {
        Order x = new Order(customerId, orders);
        if (x.addOrder()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayOrders() {
        Order x = new Order();
        System.out.println(x.displayAllOrders());
    }
    public double getBill(int customerId) {
        Order x = new Order();
        return x.getBillOfCustomer(customerId);
    }

    public void CancelOrder(int CustomerId) {
        Order x = new Order();
        x.cancelOrder(CustomerId);
        System.out.println("deleted Successfully ... !");
    }
    /*================================End Order Part================================*/
    public void notification() {
        Offer offer = new Offer();
        Meal meal = new Meal();
        System.out.println("All New Meals & Offers");
        System.out.println(offer.CheckOffer());
        System.out.println(meal.checkMeals());
    }
    
    
    @Override
    public boolean login(String user, String pass) {
        loadFromFile();
        for (int i=0;i<Persons.size();i++) {
            if (user.equals((Persons.get(i)).username) && pass.equals((Persons.get(i)).password))
                if (Persons.get(i).flag == 0) return true;
        }
        return false;
        //return user.equals("admin") && pass.equals("admin");
    }
    @Override 
    public String toString() {
        return "ID: " + getId() + ", Name: " + getFname() + " " + getLname() + ", Username: " + getUsername() + " & Password: " + getPassword()  + '\n';
    }

}
