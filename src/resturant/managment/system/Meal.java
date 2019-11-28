
package resturant.managment.system;

import java.util.ArrayList;

public class Meal {
    private double price;
    private String name;
    private final String MealFileName = "Meal.txt";
    FileManager FManager = new FileManager();
    public static ArrayList <Meal> Meals = new ArrayList<Meal>();
    public Meal() {}
    public Meal(double price, String name) {
        setPrice(price);
        setName(name);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    private String getMealData() {
        return this.price + "@" + this.name;
    }
    public boolean addMeal() {
        return FManager.write(getMealData(), MealFileName, true);
    }
    private int getMealIndex(String name) {
        for (int i=0;i<Meals.size();i++)
            if (Meals.get(i).getName().equals(name))
                return i;
        return -1;
    }
    
    private void commitToFile() {
        FManager.write(Meals.get(0).getMealData(), MealFileName, false);
        for(int i=1;i<Meals.size();i++) {
            FManager.write(Meals.get(i).getMealData(), MealFileName, true);
        }
    }
    private void loadFromFile() {
        Meals = (ArrayList<Meal>) (Object) FManager.read(MealFileName);
    }
    public String displayAllMeal() {
        loadFromFile();
        String S = "\nAll Meals Data:\n";
        for (Meal x : Meals) {
            S = S + x.toString();
        }
        return S;
    }
    
    public String searchMeal(String name){
        loadFromFile();
        int index = getMealIndex(name);
        if(index != -1)
            return "\nFound ...!" + Meals.get(index).toString();
        else 
            return "\nNot Found ...!";
    }
    public double getPrice(String name) {
        loadFromFile();
        int index = getMealIndex(name);
        return Meals.get(index).price;
    }
    
    public void updateMeal(String name, Meal x){
        loadFromFile();
        int index = getMealIndex(name);
        Meals.set(index, x);
        commitToFile();
    } 
    
    public void deleteMeal(String name){
        loadFromFile();
        int index = getMealIndex(name);
        Meals.remove(index);
        commitToFile();
    }
    @Override 
    public String toString() {
        return "Name: " + getName() + ", Price: " + getPrice() + "\n";
    }
}
