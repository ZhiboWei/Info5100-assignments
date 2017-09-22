package com.company;

public class pizzaWith {
    char pizzaType;
    double price;
    double loyaltyPoints;

    public pizzaWith(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public pizzaWith(char pizzaType, double loyaltyPoints) {
        this.pizzaType = pizzaType;
        this.loyaltyPoints = loyaltyPoints;
    }

    public pizzaWith(char pizzaType, double price, double loyaltyPoints) {
        this.pizzaType = pizzaType;
        this.price = price;
        this.loyaltyPoints = loyaltyPoints;
    }

    public pizzaWith(char pizzaType) {

        this.pizzaType = pizzaType;
    }
}
