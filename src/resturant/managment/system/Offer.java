
package resturant.managment.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Offer implements Serializable {
    private final String OfferFileName = "Gifts.bin";
    FileManager FManager = new FileManager();
    public static ArrayList <Offer> Offers = new ArrayList<Offer>();
    private double maxPayment;
    private String gift;
    private int flag;
    public Offer() {}
    public Offer(double max, String gift) {
        setMaxPayment(max);
        setGift(gift);
        setFlag(1);
    }
    public void setGift(String gift) {
        this.gift = gift.toLowerCase();
    }
    public void setMaxPayment(double payment) {
        this.maxPayment = payment;
    }
    public void setFlag(int f) {
        this.flag = f;
    }
    public double getMaxPayment() {
        return this.maxPayment;
    }
    public String getGift() {
        return this.gift;
    }
    public int getFlag() {
        return this.flag;
    }
    private String getOfferData() {
        return getGift() + "@" + getMaxPayment() + "@" + getFlag();
    } 
    public void loadFromFile() {
        Offers = (ArrayList<Offer>) (Object) FManager.read(OfferFileName);
    }
    public void commitToFile() {
        FManager.write(OfferFileName, Offers);
    }
    public int getOfferIndex(String giftName) {
        for (int i=0;i<Offers.size();i++) {
            if (Offers.get(i).getGift().equalsIgnoreCase(giftName))
                return i;
        }
        return -1;
    }
    public String checkPayment(double payment) {
        for (int i=0;i<Offers.size();i++) {
            if (Offers.get(i).getMaxPayment() <= payment)
                return "Congratulations You Have Got " + Offers.get(i).getGift();
        }
        return "Sorry No Gifts!!";
    }
    public boolean addOffer() {
        Offers.add(this);
        return FManager.write(OfferFileName, Offers);
    }
    public void updateOffer(String giftName, Offer o) {
        loadFromFile();
        int index = getOfferIndex(giftName);
        Offers.set(index, o);
        commitToFile();
    }
    public void deleteOffer(String giftName) {
        loadFromFile();
        int index = getOfferIndex(giftName);
        Offers.remove(index);
        commitToFile();
    }
    public String displayAllOffers() {
        loadFromFile();
        String S = "\nAll Meals Data:\n";
        for (Offer o: Offers)
            S = S + o.toString();
        return S;
    }
    public String CheckOffer() {
        loadFromFile();
        String s = "";
        for (Offer o:Offers) {
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
        return "The Customer Can Get " + getGift() + " After Reach to " + getMaxPayment() + " $ Of Payments\n";
    }
}
