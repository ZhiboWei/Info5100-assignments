package assignment5;

public class icecream extends dessertItem {
    String name;
    int price;

    public icecream(String name,int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    double getCost() {
        double cost = (double)price/100;
        return cost;
    }

    @Override
    public String toString() {
        String str;
        str = name+"          "+getCost();
        return str;
    }
}
