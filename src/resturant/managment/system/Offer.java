
package resturant.managment.system;

import java.util.ArrayList;

public class Offer {
    private final String OfferFileName = "Gifts.txt";
    FileManager FManager = new FileManager();
    public static ArrayList <Offer> Offers = new ArrayList<Offer>();
    private double maxPayment;
    private String gift;
    public Offer() {}
    public Offer(double max, String gift) {
        setMaxPayment(max);
        setGift(gift);
    }
    public void setGift(String gift) {
        this.gift = gift.toLowerCase();
    }
    public void setMaxPayment(double payment) {
        this.maxPayment = payment;
    }
    public double getMaxPayment() {
        return this.maxPayment;
    }
    public String getGift() {
        return this.gift;
    }
    private String getOfferData() {
        return getGift() + "@" + getMaxPayment();
    } 
    private void loadFromFile() {
        Offers = (ArrayList<Offer>) (Object) FManager.read(OfferFileName);
    }
    private void commitToFile() {
        FManager.write(Offers.get(0).getOfferData(), OfferFileName, false);
        for (int i=1;i<Offers.size();i++)
            FManager.write(Offers.get(i).getOfferData(), OfferFileName, true);
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
        return FManager.write(getOfferData(), OfferFileName, true);
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
    @Override
    public String toString() {
        return "The Customer Can Get " + getGift() + " After Reach to " + getMaxPayment() + " $ Of Payments\n";
    }
}
