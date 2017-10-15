package assignment5;

public class sundae extends icecream {

    String toppingName;
    double toppingPrice;

    public sundae(String name, int price, String toppingName, int toppingPrice) {
        super(name, price);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    @Override
    double getCost() {
        double cost;
        cost = (double)price + (double)toppingPrice;
        cost = cost/100;
        return cost;
    }

    @Override
    public String toString() {
        String str = toppingName+" Sundae with";
        str = str +"\n"+name+"        "+getCost();
        return str;
    }
}
