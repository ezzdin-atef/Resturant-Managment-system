
package resturant.managment.system;

import java.util.ArrayList;

public class Meal {
    private double price;
    private double discount = 1;
    private int flag;
    private String name;
    private final String MealFileName = "Meal.txt";
    FileManager FManager = new FileManager();
    public static ArrayList <Meal> Meals = new ArrayList<Meal>();
    public Meal() {}
    public Meal(double price, String name, double discount) {
        setPrice(price);
        setName(name);
        setDiscount(discount);
        setFlag(1);
    }
    public Meal(double price, String name) {
        this(price, name, 1);
    }
    public void setName(String name) {
        this.name = name.toLowerCase();
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public void setFlag(int f) {
        this.flag = f;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public double getDiscount() {
        return this.discount;
    }
    public int getFlag() {
        return this.flag;
    }
    public double getPrice(String name) {
        loadFromFile();
        int index = getMealIndex(name);
        return Meals.get(index).price;
    }
    public double getDiscount(String name) {
        loadFromFile();
        int index = getMealIndex(name);
        return Meals.get(index).discount;
    }
    private String getMealData() {
        return getPrice() + "@" + getName().toLowerCase() + "@" + getDiscount() + "@" + getFlag();
    }
    public boolean addMeal() {
        return FManager.write(getMealData(), MealFileName, true);
    }
    private int getMealIndex(String name) {
        for (int i=0;i<Meals.size();i++)
            if (Meals.get(i).getName().equalsIgnoreCase(name))
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

    
    public void updateMeal(String name, Meal x){
        loadFromFile();
        int index = getMealIndex(name);
        Meals.set(index, x);
        commitToFile();
    } 
    
    public void makeDiscount(String name, double discount) {
        Meal x = new Meal();
        loadFromFile();
        int index = getMealIndex(name);
        x.setDiscount(discount);
        x.setName(name);
        x.setPrice(Meals.get(index).getPrice());
        x.setFlag(1);
        Meals.set(index, x);
        commitToFile();
    }
    
    public void deleteMeal(String name){
        loadFromFile();
        int index = getMealIndex(name);
        Meals.remove(index);
        commitToFile();
    }
    public String checkMeals() {
        loadFromFile();
        String s = "";
        for (Meal o:Meals) {
            if (o.getFlag() == 1) {
                s = s + o.toString();
                o.setFlag(0);
            }
        }
        commitToFile();
        return s;
    }
    @Override 
    public String toString() {
        return "Name: " + getName() + ", Price: " + getPrice() + "  AND Discount with " + getDiscount() * 100 + "%" + "\n";
    }
}
