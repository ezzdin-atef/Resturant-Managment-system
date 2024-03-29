
package resturant.managment.system;

import java.util.ArrayList;

public class Customer{
    protected String fname;
    protected String lname;
    protected int id;
    private final String CustomerFileName = "Customer.txt";
    public static ArrayList <Customer> Customers = new ArrayList<Customer>();
    FileManager FManager = new FileManager();
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
    public void setId(int id) {
        this.id = id;
    }
    public void setFname(String name) {
        this.fname = name;
    }
    public void setLname(String name) {
        this.lname = name;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
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
            return Customers.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    public boolean existCustomer(int id) {
        loadFromFile();
        int index = getCustomerIndex(id);
        return index != -1;
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
        Order o = new Order();
        while (o.cancelOrder(id)) {
            o.cancelOrder(id);
        }
        int index = getCustomerIndex(id);
        Customers.remove(index);
        commitToFile();
    } 
    @Override 
    public String toString() {
        return "ID: " + id + ", Name: " + fname + " " + lname + "\n";
    }
    
}
