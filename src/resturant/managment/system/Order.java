
package resturant.managment.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Order implements Serializable {
    Meal meal = new Meal();
    Customer customer = new Customer();
    Scanner in = new Scanner(System.in);
    private final String OrdersFileName = "Order.bin";
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
            setNewOrder(o.toLowerCase());
            payments += meal.getPrice(o.toLowerCase()) * meal.getDiscount(o.toLowerCase());
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
    public void commitToFile() {
        FManager.write(OrdersFileName, Orders);
    }
    public void loadFromFile() {
        Orders = (ArrayList<Order>) (Object) FManager.read(OrdersFileName);
    }
    private String getOrderData() {
        return getCustomerID() + "@" + getPayment() + "@" + getOrder();
    }
    private int getOrderndex(int customerId) {
        for (int i=Orders.size()-1;i>=0;i--)
            if (Orders.get(i).getCustomerID() == customerId)
                return i;
        return -1;
    }
    public boolean addOrder() {
        loadFromFile();
        Orders.add(this);
        return FManager.write(OrdersFileName, Orders);
    }
    public double getBillOfCustomer(int customerId) {
        loadFromFile();
        return Orders.get(getOrderndex(customerId)).getPayment();
    }
    public boolean cancelOrder(int CustomerId){
        loadFromFile();
        if (getOrderndex(CustomerId) != -1) {
            int index = getOrderndex(CustomerId);
            Orders.remove(index);
            commitToFile();
            return true;
        } else {
            return false;
        }
    }
    public String displayAllOrders() {
        loadFromFile();
        String S = "\nAll Orders Data:\n";
        for (Order x : Orders) {
            S = S + x.toString();
        }
        return S;
    }
    public String getAllOrderToCustomer(int customerID) {
        String s = "";
        loadFromFile();
        for (int i=Orders.size()-1;i>=0;i--)
            if (Orders.get(i).getCustomerID() == customerID)
                s  = s + Orders.get(i).toString() + "\n";
        return s;
    }
    @Override 
    public String toString() {
        return "Customer ID: " + getCustomerID() + "\tALL Orders: " + getOrder() + "   All Payment: " + getPayment() + "$" + "\n";
    }
}
