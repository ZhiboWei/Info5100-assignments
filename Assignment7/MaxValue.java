package assignment7;

public class MaxValue extends Thread{
    private int low;
    private int high;
    private int[] arr;
    public int max = Integer.MIN_VALUE;

    public MaxValue(int low, int high, int[] arr){
        this.low = low;
        this.high = high;
        this.arr = arr;
    }
    @Override
    public void run(){
        for(int i = low; i < high; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
    }

    public static int findMaxValue(int[] arr) throws InterruptedException{
        int len = arr.length;
        int maxValue = Integer.MIN_VALUE;
        int[] result = new int[4];

        MaxValue[] mv = new MaxValue[4];
        for(int i = 0; i < 4; i++){
            mv[i] = new MaxValue((i*len)/4,((i + 1)*len/4),arr);
            mv[i].start();
        }

        for(int i = 0; i < 4; i++){
            mv[i].join();
            result[i] = mv[i].max;
        }
        for(int i = 0; i < 4; i++){
            if(result[i] > maxValue){
                maxValue = result[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) throws InterruptedException{
        int[] a = {2,5,4,1,6,7,9,15,3,23};
        int m = findMaxValue(a);
        System.out.println(m);
    }

}
