
package resturant.managment.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    Meal meal = new Meal();
    Customer customer = new Customer();
    Scanner in = new Scanner(System.in);
    private final String OrdersFileName = "Order.txt";
    FileManager FManager = new FileManager();
    public static ArrayList <Order> Orders = new ArrayList<Order>();
    private ArrayList<String> newOrder = new ArrayList<String>();
    private int customerID;
    private double payment;
    public Order() {}
    public Order(int customerId,ArrayList<String> orders) {
        double payments = 0;
        setCustomerID(customerId);
        for (String o: orders) {
            setNewOrder(o);
            payments += meal.getPrice(o);
        }
        setPayment(payments);
    }
    public void setCustomerID(int customerId) {
        if (customer.existCustomer(customerId)) 
            this.customerID = customerId;
        else {
            System.out.println("The Customer not found!!\nLet's Create new one");
            System.out.print("Enter his first name: ");
            String fname = in.nextLine();
            System.out.print("Enter his last name: ");
            String lname = in.nextLine();
            Customer newcustomer = new Customer(fname, lname);
            newcustomer.addCustomer();
            System.out.println("The New Customer ID is: " + newcustomer.getId() + "\n");
            this.customerID = newcustomer.getId();
        }
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
    public void setNewOrder(String order) {
        this.newOrder.add(order);
    }
    public int getCustomerID() {
        return this.customerID;
    }
    public double getPayment() {
        return this.payment;
    }
    public ArrayList<String> getOrder() {
        return this.newOrder;
    }
    private void commitToFile() {
        FManager.write(Orders.get(0).getOrderData(), OrdersFileName, false);
        for(int i=1;i<Orders.size();i++) {
            FManager.write(Orders.get(i).getOrderData(), OrdersFileName, true);
        }
    }
    private void loadFromFile() {
        Orders = (ArrayList<Order>) (Object) FManager.read(OrdersFileName);
    }
    private String getOrderData() {
        return getCustomerID() + "@" + getPayment() + "@" + getOrder();
    }
    private int getOrderndex(int customerId) {
        for (int i=0;i<Orders.size();i++)
            if (Orders.get(i).getCustomerID() == customerId)
                return i;
        return -1;
    }
    public boolean addOrder() {
        return FManager.write(getOrderData(), OrdersFileName, true);
    }
    
    public void cancelOrder(int CustomerId){
        loadFromFile();
        int index = getOrderndex(CustomerId);
        Orders.remove(index);
        commitToFile();
    }
    public String displayAllOrders() {
        loadFromFile();
        String S = "\nAll Orders Data:\n";
        for (Order x : Orders) {
            S = S + x.toString();
        }
        return S;
    }
    @Override 
    public String toString() {
        return "Customer ID: " + getCustomerID() + "ALL Orders: " + getOrder() + "All Payment: " + getPayment() + "\n";
    }
}
