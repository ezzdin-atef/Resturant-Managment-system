
package resturant.managment.system;

import java.util.ArrayList;

public class Customer extends Person {

    private final String CustomerFileName = "Customer.txt";
    public static ArrayList <Customer> Customers = new ArrayList<Customer>();
    public Customer() {}
    public Customer(String firstname, String lastname) {
        loadFromFile();
        setId( Customers.get(Customers.size()-1).getId()+1 );
        setFname(firstname);
        setLname(lastname);
    }
    private String getCustomerData() {
        return this.id + "@" + this.fname + "@" + this.lname;
    }
    public boolean addCustomer() {
        return FManager.write(getCustomerData(), CustomerFileName, true);
    }
    private int getCustomerIndex(int id) {
        for (int i=0;i<Customers.size();i++)
            if (Customers.get(i).getId() == id)
                return i;
        return -1;
    }
    
    private void commitToFile() {
        FManager.write(Customers.get(0).getCustomerData(), CustomerFileName, false);
        for(int i=1;i<Customers.size();i++) {
            FManager.write(Customers.get(i).getCustomerData(), CustomerFileName, true);
        }
    }
    private void loadFromFile() {
        Customers = (ArrayList<Customer>) (Object) FManager.read(CustomerFileName);
    }
    public String displayAllCustomer() {
        loadFromFile();
        String S = "\nAll Customers Data:\n";
        for (Customer x : Customers) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchCustomer(int id){
        loadFromFile();
        int index = getCustomerIndex(id);
        if(index != -1)
            return "\nFound ...!" + Customers.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    
    public void updateCustomer(int oldID, Customer x){
        loadFromFile();
        int index = getCustomerIndex(oldID);
        x.id = Customers.get(index).id;
        Customers.set(index, x);
        commitToFile();
    } 
    
    public void deleteCustomer(int id){
        loadFromFile();
        int index = getCustomerIndex(id);
        Customers.remove(index);
        commitToFile();
    } 
    
    
    
    
    @Override 
    public String toString() {
        return "ID: " + id + ", Name: " + fname + " " + lname + "\n";
    }
    
}
