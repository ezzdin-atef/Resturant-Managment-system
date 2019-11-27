
package resturant.managment.system;

import java.util.ArrayList;

public class Admin extends Person {
        
    protected String username;
    protected String password;
    
    private final String AdminFileName = "Admin.txt";
    
    public static ArrayList<Admin> Admins = new ArrayList<Admin>();
    
    public Admin() {}
    
    public void setUsername(String usr) {
        this.username = usr;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    private String getAdminData() {
        return this.id + "@" + this.username + "@" + this.password + "@" + this.fname + "@" + this.lname;
    }
    /*================================Start Admin Part================================*/
    private void commitToFile() {
        FManager.write(Admins.get(0).getAdminData(), AdminFileName, false);
    }
    
    private void loadFromFile() {
        Admins = (ArrayList<Admin>) (Object) FManager.read(AdminFileName);
    }
    
    public void UpdateAdmin(Admin x){
        loadFromFile();
        x.id = 1;
        Admins.set(0, x);
        commitToFile();
    }
    /*================================End Admin Part================================*/
    
    
    /*================================Start Emplyee Part================================*/
    public void addNewEmplyee(String fname, String lname) {
        Emplyee x = new Emplyee(fname, lname);
        if (x.addEmplyee()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public void displayEmplyees() {
        Emplyee x = new Emplyee();
        System.out.println(x.displayAllEmplyee());
    }

    public void searchForEmplyee(int id) {
        Emplyee x = new Emplyee();
        System.out.println(x.searchEmplyee(id));
    }

    public void updateEmplyee(int oldID, Emplyee newEmplyeeValues) {
        Emplyee x = new Emplyee();
        x.updateEmplyee(oldID, newEmplyeeValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteEmplyee(int Id) {
        Emplyee x = new Emplyee();
        x.deleteEmplyee(Id);
        System.out.println("deleted Successfully ... !");
    }
    /*================================End Emplyee Part================================*/
    
    public void addNewMeal(int price, String name) {
        Meal m = new Meal(price, name);
        if (m.addMeal())
            System.out.println(m.toString() + "Added Successfully ... !");
        else
            System.out.println("Failed to insert ... !");
    }
    public void displayMeals() {
        Meal m = new Meal();
        System.out.println(m.displayAllMeal());
    }
    public void searchForMeal(String name) {
        Meal m = new Meal();
        System.out.println(m.searchMeal(name));
    }
    public void updateMeal(String name, Meal newMealValues) {
        Meal m = new Meal();
        m.updateMeal(name, newMealValues);
        System.out.println("Updated Successfully ... !");
    }
    public void deleteMeal(String name) {
        Meal m = new Meal();
        m.deleteMeal(name);
        System.out.println("deleted Successfully ... !");
    }
    
    public boolean login(String user, String pass) {
        loadFromFile();
        return user.equals((Admins.get(0)).username) && pass.equals((Admins.get(0)).password);
        //return user.equals("admin") && pass.equals("admin");
    }
    
}
