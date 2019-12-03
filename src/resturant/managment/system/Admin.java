
package resturant.managment.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends Person implements Serializable {
    public Admin() {}
    public Admin(String fname, String lname, String username, String pass) {
        super(fname, lname, username, pass);
        setFlag(1);
    }
    /*================================Start Admin Part================================*/
    
    
    public boolean addAdmin(Admin x) {
        return FManager.write(PersonFileName, Persons);
    }
    public void UpdateAdmin(Admin x){
        loadFromFile();
        x.id = 1;
        Persons.set(0, x);
        commitToFile();
    }
    /*================================End Admin Part================================*/
    /*================================Start Emplyee Part================================*/
    public void addNewEmplyee(String fname, String lname, String username, String pass) {
        Emplyee x = new Emplyee(fname, lname, username, pass);
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
    /*================================Start Meals Part================================*/
    public void addNewMeal(double price, String name) {
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
    public void addDiscount (String name, double discount) {
        Meal m = new Meal();
        m.makeDiscount(name, discount);
        System.out.println("Added Successfully ... !");
    }
    public void deleteMeal(String name) {
        Meal m = new Meal();
        m.deleteMeal(name);
        System.out.println("deleted Successfully ... !");
    }
    /*================================End Meals Part================================*/
    /*================================Start Offer Part================================*/
    public void addNewOffer(String giftName, double maxPyament) {
        Offer offer = new Offer(maxPyament, giftName);
        if (offer.addOffer())
            System.out.println(offer.toString() + "Added Successfully ... !");
        else
            System.out.println("Failed to insert ... !");
    }
    public void updateOffer(String giftName, Offer newOfferValues) {
        Offer offer = new Offer();
        offer.updateOffer(giftName, newOfferValues);
        System.out.println("Updated Successfully ... !");
    }
    public void displayAllOffers() {
        Offer offer = new Offer();
        System.out.println(offer.displayAllOffers());
    }
    public void deleteOffer(String giftName) {
        Offer offer = new Offer();
        offer.deleteOffer(giftName);
        System.out.println("deleted Successfully ... !");
    }
    /*================================End Offer Part================================*/
    @Override
    public boolean login(String user, String pass) {
        loadFromFile();
        for (int i=0;i<Persons.size();i++) {
            if (user.equals((Persons.get(i)).username) && pass.equals((Persons.get(i)).password))
                if (Persons.get(i).flag == 1) return true;
        }
        return false;
        //return user.equals("admin") && pass.equals("admin");
    }
    
}
