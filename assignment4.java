package com.company;

public class assignment4 {
    public static void main(String[] args) {
        licenseKeyFormatting("2-4A0r7-4k",4);
        intToRoman(3456);
        int[] a={1,2,3,4,5};
        int[] b={3,4,5};
        findMedianSortedArrays(a,b);


    }

    public static String licenseKeyFormatting(String S, int K) {
        char[] sArr = S.toCharArray();
        String result = "";
        StringBuffer sBuffer = new StringBuffer(result);
        int length = 0;
        for (int i = sArr.length-1; i >= 0; i--) {
            if (sArr[i] - '-' == 0)
                continue;

            if (sArr[i] - 'a' >= 0)
                sArr[i] = (char)(sArr[i] - 32);
            sBuffer.append(sArr[i]);
            length ++;

            if (length == K) {
                sBuffer.append('-');
                length = 0;
            }
        }
        if (sBuffer.length() > 0 && sBuffer.charAt(sBuffer.length()-1) - '-' == 0)
            sBuffer.delete(sBuffer.length()-1, sBuffer.length());
        sBuffer.reverse();
        result = sBuffer.toString();
        System.out.println(result);
        return result;
    }
    public static String intToRoman(int num){
        String[] digit={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] ten={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundred={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousand={"","M","MM","MMM"};
        String str="";
        String str1=str+thousand[num/1000]+hundred[num%1000/100]+ten[num%100/10]+digit[num%10];
        System.out.println(str1);
        return str1;
    }
    public static double findMedianSortedArrays(int[]nums1,int[]nums2){
        int m=nums1.length;
        int n=nums2.length;
        double[] nums=new double[m+n];
        double median;
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                nums[k++]=nums1[i++];
            }
            else{
                nums[k++]=nums2[j++];
            }
        }
        while(i<m){
            nums[k++]=nums1[i++];
        }
        while(j<n){
            nums[k++]=nums2[j++];
        }
        if((m+n)%2==0){
            median=(nums[(n+m)/2-1]+nums[(m+n)/2])/2;
        }
        else {
            median=nums[(m+n)/2];
        }
        System.out.println(nums[3]);
        System.out.println(nums[4]);
        System.out.println(median);
        return median;
        }



    }

