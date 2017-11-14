package assignment5;

import java.text.DecimalFormat;
import java.util.Vector;

public class checkOut {
    // clear method is missing
    // output doesn't match the given format
    // cost of oatmeal resins is displayed wrong
    DecimalFormat df = new DecimalFormat("######0.00"); // this should not be defined in class level

    Vector<dessertItem> v = new Vector<dessertItem>();

    public  void enterItem(dessertItem i){
        v.add(i);
    }

    public void clearItem(){
        v.removeAllElements();
    }

    public int numberOfItems(){
        int n = v.size();
        return n;
    }

    public double totalCost(){
        double sum = 0;
        for(int i=0;i<v.size();i++){
            sum = sum + v.get(i).getCost();
        }
        return sum;
    }

    public double totalTax(){
        double t;
        t = dessertShoppe.TAX*totalCost();
        return t;
    }

    @Override
    public String toString() {
        String str="     ";
        str = str+dessertShoppe.storeName;
        str = str+"\n     --------------------";
        for(int i=0;i<v.size();i++){
            str= str + "\n"+v.get(i).toString();
        }
       return str;
    }
    public static void main(String[] args){
        checkOut checkout = new checkOut();
        checkout.enterItem(new candy("Peanut",2.25,399));
        checkout.enterItem(new icecream("Vanilla Ice Cream",105));
        checkout.enterItem(new cookie("Oatmeal Raisin Cookies",4,399));


        System.out.println("\nNumber of items:" + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost:" + String.format("%.2f",checkout.totalCost())+"\n");
        System.out.println("\nTotal tax:" + String.format("%.2f",checkout.totalTax()) +"\n");
        System.out.println("\nCost + Tax:" + String.format("%.2f",(checkout.totalCost()+checkout.totalTax())) +"\n");
        System.out.println(checkout);
    }
}
