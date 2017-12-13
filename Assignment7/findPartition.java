/* GOod WOrk
 * SCore 9.5 + extra credit 2; Total score 10
 */
package assignment7;

public class findPartition {
    public static boolean find(int[] arr){
        if(arr == null || arr.length == 0){
            return true;
        }
        int sum = 0;
        for(int i : arr){
            sum = sum + arr[i];
        }
        if(sum % 2 !=0){
            return false;
        }
        int volumn = sum/2;
        boolean[] dp = new boolean[volumn +1];
        dp[0] = true;
        for(int i = 1; i <= arr.length - 1; i++){
            for(int j = volumn; j >= arr[i-1]; j--){
                dp[j] = dp[j] || dp[j - arr[i-1]];
            }
        }
        return dp[volumn];
    }
    public static void main(String[] args){


    }
}
