package com.company;

public class customer {
    String cutomerName;
    int num;
    String pizzaName;
    double singlePrice;

    public customer(String cutomerName, int num, String pizzaName, double singlePrice) {
        this.cutomerName = cutomerName;
        this.num = num;
        this.pizzaName = pizzaName;
        this.singlePrice = singlePrice;
    }

    public double total(){
        return num*singlePrice;
    }
    public static void main(String[] args){
        customer a = new customer("Alice",2,"Chicken",9.8);
        System.out.print("The total money is "+ a.total());
    }

}
