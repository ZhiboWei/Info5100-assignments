package com.company;

import java.util.Scanner;

 class Homework {

    public static void main(String[] args) {
        employeeSalary();
        addDigits(89);
        printPerfectNumbers(45);
        printTriangle(6);


}
    public static double employeeSalary(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the working hours:");
        double hour = input.nextDouble();
        double salary =0;
        if(hour<0 || hour>48){
            System.out.println("Please input correct hour");
        }
        if (hour<=36){
            salary=hour*15;
            System.out.println("The salary is "+salary);
        }
        if(hour<=41&&hour>36){
            salary=hour*15*1.5;
            System.out.println("The salary is "+salary);
        }
        if(hour<=48&&hour>41){
            salary=hour*15*2;
            System.out.println("The salary is "+salary);
        }
        return salary;

    }

    public static int addDigits(int input){

    int sum=0;
    int num=input;
        while(num>0){
            sum=sum+num%10;
            num=num/10;
        }
    if(sum<=9){
        System.out.println("The result is "+sum);
    }
    else{
        addDigits(sum);
    }
        return sum;

    }
    public static void printPerfectNumbers(int n){
        int sum=0;
    for(int i=1;i<=n;i++){
        if(n%i==0){
            sum=sum+i;
        }
    }
    if(sum==n){
        System.out.println(n+" is the perfect number");
    }
    else{
        System.out.println(n+" is not the perfect number");
    }

    }

    public static void printTriangle(int length){

         for(int i=1;i<=length;i++){
             for(int j=1;j<=length-1;j++) {
                 System.out.print(" ");
             }
             System.out.print("*");
             if(i!=length){
                 for(int j=1;j<=i-2;j++){
                     System.out.print(" ");
                 }
                 if(i!=1){
                     System.out.print("*");
                 }
                 System.out.println();
             }else {
                 for(int k=1;k<=i-1;k++){
                     System.out.print("*");
                 }
             }

         }

     }
 }





