package assignment5;

public class dessertShoppe {
    final static double TAX = 0.02;
    final static String storeName = "M & M Dessert Shoppe";

    public static String centsTodollarsAndCents(int c){
        String s;
        double d = (double)c/100;
        s = String.valueOf(d);
        return s;
    }
}
