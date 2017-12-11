/* Good Work
 * Score 9 + Extra credit 2; Total score 10
 * Unit tests for ATM are missing
 */
package assignment6;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

class Atm{
    int availableAmountInMachine;
    int transactionFee;
    boolean data;
    Scanner input = new Scanner(System.in);
    Stack<String> transactions = new Stack<String>();
    Map map = new HashMap();
    Vector<User> userData = new Vector<User>();
    int i =0;

    public void askUser(){
        System.out.println("Are you a new user or a current user?");
        System.out.println("1.New user 2.Current user");
        int choice = input.nextInt();
        if(choice==1){
            System.out.println("Do you want to create an account? 1.Yes 2.No");
            int i= input.nextInt();
            if(i==1) {
                createAccount();
                showFunctions();
            }else{
                System.exit(0);
            }
        }
        else if(choice==2){
            logIn();
            showFunctions();

        }else{
            System.out.println("Please input the correct choice!");
        }
    }

    public void createAccount(){
        String accountNumber = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\accountNumber.txt"));
            accountNumber = in.readLine();
        }catch(FileNotFoundException e){
            System.out.println("Cannot find the file!");
        }catch (IOException ie){
            System.out.println("IO exception!");
        }
        int newAccountNumber = Integer.parseInt(accountNumber) +1;
        String AccountNumber = ""+newAccountNumber;
        System.out.println("Your account number is "+newAccountNumber);
        System.out.println("Please set your password!(Must contain both number and letter!)");
        String password = input.next();
        saveInFile("C:\\password.txt",password);
        System.out.println("Please input your phoneNumber!");
        String pn = input.next();
        map.put(pn,password);
        System.out.println("Please input your name!");
        String name = input.next();
        System.out.println("Please input your age!");
        String age = input.next();
        System.out.println("Please input your address!");
        String a = input.next();
        User user = new User(name,age,a,pn,AccountNumber,password);
        userData.add(user);
    }

    public void logIn() {
        System.out.println("Please log in your account!");
        System.out.println("Please input your phone number!");
        String inputPhoneNumber = input.next();
        if (phoneNumberExist(inputPhoneNumber)) {
            System.out.println("Please input your password!");
            String password = input.next();
            if(passwordExist(password)){
                System.out.println("Log in successfully!");
            }else{
                System.out.println("Wrong password!");
                System.out.println("Do you want to retrieve your password ?");
                System.out.println("1.Yes 2.No");
                int c = input.nextInt();
                if(c==1){
                    retrievePassword(inputPhoneNumber);
                }else if(c==2){
                    System.exit(0);
                }else{
                    System.out.println("Please input the correct number !");
                }
            }
        } else {
            System.out.println("Your phoneNumber is not exist");
        }

    }

    public String retrievePassword(String s){
        System.out.println("To retrieve your password please input your name!");
        String name = input.next();
        System.out.println("To retrieve your password please input your age!");
        String age = input.next();
        String password = null;
        for(User user:userData){
            if(user.name.equalsIgnoreCase(name)&&user.age.equalsIgnoreCase(age)){
                System.out.println("Your password is "+user.password);
            }
        }
        return password;
    }

    public boolean phoneNumberExist(String s){
        for(User user: userData){
            if(user.password.equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }

    public boolean passwordExist(String s){
        for(User user: userData){
            if(user.password.equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }


    public void saveInFile(String strFileName,String strBuffer){
        try{
            File fileText = new File(strFileName);
            FileWriter fileWriter = new FileWriter(fileText);
            fileWriter.write(strBuffer);
            fileWriter.close();

        } catch (IOException ie){
            System.out.println("Error！");
        }
    }
    public void showFunctions(){
        System.out.println("1.availableBalance 2.withDrawal 3.deposit 4.recentTransactions 5.changePassword 6.Exit");
        int choice = input.nextInt();
        if(choice == 1){
            AvailableBalance();
        }
        if(choice==2){
            withDrawal();
        }
        if(choice==3){
            deposit();
        }
        if(choice==4){
            recentTransactions();
        }
        if(choice==5){
            changePassword();
        }
        if(choice==6){
            exit();
        }
        else{
            //System.out.println("Please input the correct choice!---");
        }
    }

    public void AvailableBalance(){
        System.out.println("The available balance is"+User.availableBalance);
    }

    public void withDrawal(){
        System.out.println("Please input the amount you want to withdrawal");
        int cash = input.nextInt();
        if(cash > User.availableBalance){
            System.out.println("The amount is over the availableBalance!");
        }else{
            if (cash < availableAmountInMachine) {
                User.availableBalance = User.availableBalance - cash;
                User.availableBalance = User.availableBalance - transactionFee;
                System.out.println("Withdrawal successfully!");
                System.out.println("You are charged a transaction fee!");
                System.out.println("The remaining amount is" + User.availableBalance);
                availableAmountInMachine = availableAmountInMachine - cash;
                int temp = -cash;
                String s = ""+temp;
                transactions.push(s);
            }else{
                System.out.println("The amount of this machine is not enough!");
            }
        }
    }

    public void deposit(){
        System.out.println("Please input the amount you want to deposit!");
        int deposit = input.nextInt();
        User.availableBalance = User.availableBalance + deposit;
        System.out.println("Deposit successfully!");
        System.out.println("You are charged a transaction fee!");
        User.availableBalance = User.availableBalance - transactionFee;
        System.out.println("Now your available balance is "+User.availableBalance);
        String s = ""+deposit;
        transactions.push(s);
    }

    public void recentTransactions(){
        int len= transactions.size();
        System.out.println("The recent 10 transactions:");
        if(len>10) {
            for (int i = 0; i < 10; i++) {
                String output = transactions.peek();
                int a = Integer.parseInt(output);
                if (a < 0) {
                    int temp = -a;
                    System.out.println("Withdrawal:" + temp);
                } else {
                    System.out.println("Deposit:" + a);
                }
            }
        }else if (len==0) {
            System.out.println("No transaction!");
        }
        else{
            for (int i = 0; i < len; i++) {
                String output = transactions.peek();
                int a = Integer.parseInt(output);
                if (a < 0) {
                    int temp = -a;
                    System.out.println("Withdrawal:" + temp);
                } else {
                    System.out.println("Deposit:" + a);
                }
            }
        }
    }

    public void changePassword(){
        System.out.println("Please input your phoneNumber!");
        String inputPhoneNumber = input.next();
        System.out.println("Please input your name!");
        String inputName = input.next();
        System.out.println("Please input your age!");
        String inputAge = input.next();
        for(User user:userData) {
            if (user.phoneNumber.equalsIgnoreCase(inputPhoneNumber)&&user.name.equalsIgnoreCase(inputName)&&user.age.equalsIgnoreCase(inputAge)) {
                System.out.println("Please input your new password!");
                String password = input.next();
                user.password = password;
                System.out.println("Successfully change your password!");

            } else {
                System.out.println("The information of input is wrong!");
            }
        }
    }

    public void exit(){
        System.exit(0);
    }
}

public class User {
    String name;
    String age;
    static int availableBalance;
    String address;
    String phoneNumber;
    String bankAccountNumber;
    String password;

    public User(String name, String age, String address, String phoneNumber, String bankAccountNumber, String password) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bankAccountNumber = bankAccountNumber;
        this.password = password;
    }

    public static void main(String[] args){

        Atm at = new Atm();

        at.askUser();

    }
}
