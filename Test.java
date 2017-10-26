package midterm;

public class Test {
    public static int[] reverseEvenIndices(int[] nums){

        int p1=0;
        int p2;
        int len=nums.length;

        if(len%2==0){
            p2=len-2;
        }else{
            p2=len-1;
        }
        while(p1<p2){
            int temp = nums[p1];
            nums[p1]=nums[p2];
            nums[p2]=temp;
            p1=p1+2;
            p2=p2-2;
        }
        for(int i=0;i<len;i++){
            System.out.print(nums[i]);
        }
        return nums;
    }

    public static int arrangeCoins(int n){
        int rows=1;
        int count=0;
        while(n>=rows){
            count++;
            n=n-rows;
            rows++;
        }
        System.out.println(count);
        return count;

    }

    public int minMoves(int[] nums){
        int min=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            sum = sum+nums[i];
        }
        return sum-min*nums.length;
    }

    public static int countNumberOfPossibleWays(int faces, int dices, int x){
        if(x<1){
            return 0;
        }
       if(dices ==1){
            return x<=faces?1:0;
       }
       int ways=0;
       for(int i=1;i<=faces;i++){
           ways+=countNumberOfPossibleWays(faces,dices-1,x-i);
       }
       System.out.println(ways);
       return ways;
    }

    public static void main(String[] args){
        //int[] arr={1,2,3,4,5};
        //reverseEvenIndices(arr);
        //arrangeCoins(6);
        countNumberOfPossibleWays(4,2,5);
    }
}
