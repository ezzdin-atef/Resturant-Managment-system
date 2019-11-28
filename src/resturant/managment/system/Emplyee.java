
package resturant.managment.system;

import java.util.ArrayList;
public class Emplyee extends Person {
    
    private final String EmplyeeFileName = "Employees.txt";
    public static ArrayList<Emplyee> Emplyees = new ArrayList<Emplyee>();
    
    public Emplyee() {}
    public Emplyee(String firstName, String lastName) {
        loadFromFile();
        setId( Emplyees.get(Emplyees.size()-1).getId()+1 );
        setFname(firstName);
        setLname(lastName);
    }
    
    public boolean addEmplyee() {
        return FManager.write(getEmplyeeData(), EmplyeeFileName, true);
    }
    private String getEmplyeeData() {
        return this.id + "@" + this.fname + "@" + this.lname;
    }
    private int getEmlyeeIndex(int id){
        for (int i = 0; i < Emplyees.size(); i++)
            if(Emplyees.get(i).getId()== id)
                return i;
        
        return -1;
    }
    
    private void commitToFile() {
        FManager.write(Emplyees.get(0).getEmplyeeData(), EmplyeeFileName, false);
        for (int i = 1; i < Emplyees.size(); i++) {
            FManager.write(Emplyees.get(i).getEmplyeeData(), EmplyeeFileName, true);
        }
    }
    
    private void loadFromFile() {
        Emplyees = (ArrayList<Emplyee>) (Object) FManager.read(EmplyeeFileName);
    }
    
    public String displayAllEmplyee() {
        loadFromFile();
        String S = "\nAll Emplyees Data:\n";
        for (Emplyee x : Emplyees) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchEmplyee(int id){
        loadFromFile();
        int index = getEmlyeeIndex(id);
        if(index != -1)
            return "\nFound ...!" + Emplyees.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateEmplyee(int oldID, Emplyee x){
        loadFromFile();
        int index = getEmlyeeIndex(oldID);
        x.id = Emplyees.get(index).id;
        Emplyees.set(index, x);
        commitToFile();
    } 
    
    public void deleteEmplyee(int id){
        loadFromFile();
        int index = getEmlyeeIndex(id);
        Emplyees.remove(index);
        commitToFile();
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

    public void CancelOrder(int CustomerId) {
        Order x = new Order();
        x.cancelOrder(CustomerId);
        System.out.println("deleted Successfully ... !");
    }
    /*================================End Order Part================================*/

    public boolean login(int ID) {
        loadFromFile();
        return getEmlyeeIndex(ID)!= -1;
    }
    
    
    @Override 
    public String toString() {
        return "ID: " + id + ", Name: " + fname + " " + lname + '\n';
    }

}
