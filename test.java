package project;

import java.util.Scanner;

public class test {
    Scanner input = new Scanner(System.in);
    String[] words = {"apple","orange","banana","coconut","blueberry"};
    public test(){
        while(true){
            int num = (int)(Math.random()*5);
            String str = words[num];
            int n = Guess(str);
            System.out.println("The word is "+ str +".You missed "+n+"times.\n");
            System.out.println("Do you want to guess for another word? Entry y or n");
            String s = input.next();
            if(s.equals("n")){
                break;
            }
            System.out.println("Game over!");
        }
    }
        int Guess(String str){
            int count = 0;
            int number = str.length();
            int choice = 8;
            char[] a = new char[number];
            int mistake = 0;

            for(int i=0;i<number;i++){
                a[i]='*';
            }
            while(true){
                System.out.println("Enter a letter in a word!");
                for(int i=0;i<str.length();i++){
                    System.out.print(a[i]);
                }
                System.out.print(">");
                String letter = input.next();
                int m = 0;
                for(int i=0;i<str.length();i++){
                    if(a[i]==letter.charAt(0)){
                        System.out.println(" "+letter+"in the word!");
                        m=1;
                    }
                    else if(str.charAt(i)==letter.charAt(0)){
                        a[i]=letter.charAt(0);
                         choice--;
                        m=1;
                    }
                }
                if(m==0){
                    mistake++;
                    System.out.println("\n"+letter+" is not in the word");
                    printHangman(mistake);
                    choice--;
                    count++;
                }
                if(choice==0) break;
            }
            return count;
    }
    public void printHangman(int i){
        if(i==1){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
        }
        if(i==2){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
        }
        if(i==3){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|     --- ");
        }
        if(i==4){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|     --- ---");
        }
        if(i==5){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|     --- ---");
            System.out.println("|       /");
            System.out.println("|      /");
        }
        if(i==6){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|     --- ---");
            System.out.println("|       / \\");
            System.out.println("|      /   \\");
        }
        if(i==7){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|     --- ---");
            System.out.println("|       / \\");
            System.out.println("|      /   \\");
            System.out.println("|   --");
        }
        if(i==8){
            System.out.println("----------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|     --- ---");
            System.out.println("|       / \\");
            System.out.println("|      /   \\");
            System.out.println("|   --       --");
        }
    }


    public static void main(String[] args){
            new test();
    }

}
