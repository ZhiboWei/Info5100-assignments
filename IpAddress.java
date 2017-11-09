package com.company;

public class IpAddress { // score 2
    String DottedDecimal;
    int firstOctet;
    int secondOctet;
    int thirdOctet;
    int fourthOctet;

    public void setDottedDecimal(String dottedDecimal) {
        DottedDecimal = dottedDecimal;
    }

    public String getDottedDecimal() {
        System.out.println(DottedDecimal);
        return DottedDecimal;
    }

    public  void getOctet(int k) {
        if (k > 4 || k < 0) {
            System.out.println("Error!");
        } else {
            IpAddress ip = new IpAddress();
            String a[] = DottedDecimal.split("\\."); // refactor this block to another method to cleaner code
            ip.firstOctet = Integer.parseInt(a[0]);
            ip.secondOctet = Integer.parseInt(a[1]);
            ip.thirdOctet = Integer.parseInt(a[2]);
            ip.fourthOctet = Integer.parseInt(a[3]);
            if(k==1){
                System.out.println(a[0]);
            }
            if(k==2){
                System.out.println(a[1]);
            }
            if(k==3){
                System.out.println(a[2]);
            }
            if(k==4){
                System.out.println(a[3]);
            }

        }

    }

    public static void main(String[] args){
        IpAddress ip = new IpAddress();
        ip.setDottedDecimal("216.27.6.136");
        ip.getDottedDecimal();
        ip.getOctet(4);
        ip.getOctet(1);
        ip.getOctet(3);
        ip.getOctet(2);

    }
}
