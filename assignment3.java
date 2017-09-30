package com.company;
import java.util.Scanner;

public class assignment3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please input a string");
        String input = s.nextLine();
        removeVowelsFromString(input);
        checkIfTwoStringsAreAnagrams("abc", "abcdef");
        calculator();
    }
    //1. The constructor has some problem. The first and the third constructor both have one parameter. So when the number of parameter is one,
    // there will be some problems. And the type of name is not private, so we do not need to write setName method.

    //2.The type of name should be private. And the set method should be this.time =t;

    public static void removeVowelsFromString(String input) {

        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                c[i] = 0;
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 0) {
                System.out.print(c[i]);
            }
        }


    }

    public static boolean checkIfTwoStringsAreAnagrams(String str1, String str2) {

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        if (a.length != b.length) {
            System.out.println("Two strings are not anagrams!");
        } else {
            java.util.Arrays.sort(a);
            java.util.Arrays.sort(b);
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    System.out.println("Two strings are not anagrams!");
                    return false;
                }
            }
            System.out.println("Two strings are anagrams!");

        }
        return true;
    }
    public static void calculator(){
        addition(3.2,3.6);
        subtraction(4.5,8.9);
        multiolication(7.8,8.9);
        division(8.7,0);
        squareRoot(-1);
        square(3);
        cube(5);
        temperatureConversion();
        lengthConversion();
        solutionOfQuadraticEquation(1,5,2);

    }
    public static void addition(double a,double b){
        double c= a+b;
        System.out.println(a+"+"+b+"="+c);
    }
    public static void subtraction(double a,double b){
        double c=a-b;
        System.out.println(a+"-"+b+"="+c);
    }
    public static void multiolication(double a,double b){
        double c=a*b;
        System.out.println(a+"*"+b+"="+c);
    }
    public static void division(double a,double b){
        if(b==0){
            System.out.println("The numerator cannot be 0!");
        }else{
            double c=a/b;
            System.out.println(a+"/"+b+"="+c);
        }
    }
    public static void squareRoot(double a){
        if(a<0){
            System.out.println("The number cannot smaller than 0!");
        }else{
            double c=Math.sqrt(a);
            System.out.println("The squareroot of"+a+"is"+c);
        }
    }
    public static void square(double a){
        double b=a*a;
        System.out.println("The square of "+a+" is "+b);
    }
    public static void cube(double a){
        double b=a*a*a;
        System.out.println("The cube of "+a+" is "+b);
    }
    public static void temperatureConversion(){
        System.out.println("Please input the type you want to convert! 1:FahrenheitToCelsius 2:CelsiusToFahrenheit");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if(choose==1){
            System.out.println("Please input the temperature you want to convert!");
            Scanner input2 = new Scanner(System.in);
            double temperature=input2.nextDouble();
            FahrenheitToCelsius(temperature);

        }
        if(choose==2){
            System.out.println("Please input the temperature you want to convert!");
            Scanner input2 = new Scanner(System.in);
            double temperature=input2.nextDouble();
            CelsiusToFahrenheit(temperature);
        }
        if(choose!=1&&choose!=2){
            System.out.println("Please input the right number!");
        }

    }
    public static void lengthConversion(){
        System.out.println("Please input the type you want to convert! 1:feetToInches 2:InchesToFeet");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if(choose==1){
            System.out.println("Please input the length you want to convert!");
            Scanner input2 = new Scanner(System.in);
            double length =input2.nextDouble();
            feetToInches(length);

        }
        if(choose==2){
            System.out.println("Please input the length you want to convert!");
            Scanner input2 = new Scanner(System.in);
            double length=input2.nextDouble();
            InchesToFeet(length);
        }
        if(choose!=1&&choose!=2){
            System.out.println("Please input the right length!");
        }
    }
    public static void FahrenheitToCelsius(double a){
        double b=a*33.8;
        System.out.println("The Celsius temperature is "+b);

    }
    public static void CelsiusToFahrenheit(double a){
        double b=17.22*a;
        System.out.println("The Fahrenheit temperature is "+b);
    }
    public static void feetToInches(double a){
        double b=12*a;
        System.out.println("The length is "+b+" inches");

    }
    public static void InchesToFeet(double a){
        double b=a*0.0833;
        System.out.println("The length is "+b+" feet");
    }
    public static double[] solutionOfQuadraticEquation(double a, double b, double c){
        double k=b*b-4*a*c;
        double[] j={0,0};
        if(k<0){
            System.out.println("This equation doesn't have a solution!");
        }else{
            j[0]=(-b+k)/(2*a);
            j[1]=(-b-k)/(2*a);
            System.out.println("The solutions of equation are "+j[0]+" and "+j[1]);
        }
        return j;
    }
}

