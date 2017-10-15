package assignment5;

import java.text.DecimalFormat;

public class candy extends dessertItem {
    String name;
    double weight;
    int price;
    DecimalFormat df = new DecimalFormat("######0.00");

    public candy(String name, double weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    double getCost() {
        double cost = weight * price;
        cost = cost/100.0;
        return cost;
    }

    @Override
    public String toString() {
        String str;
        str = weight+" lbs. @"+dessertShoppe.centsTodollarsAndCents(price)+" /lb.";
        str = str+"\n"+name+"                     "+df.format(getCost());
        return str;
    }
}
