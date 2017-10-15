package assignment5;

public class cookie extends dessertItem {
    String name;
    int number;
    int price;

    public cookie(String name, int number, int price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    @Override
    double getCost() {
        double cost;
        cost = (number/12)*price;
        cost = cost/100.0;
        return cost;
    }

    @Override
    public String toString() {
        String str;
        str = number+" @"+dessertShoppe.centsTodollarsAndCents(price)+"/dz.";
        str = str+"\n"+name+"     "+getCost();
        return str;
    }
}
