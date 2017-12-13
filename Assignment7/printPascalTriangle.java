package assignment7;

public class printPascalTriangle {
    public static void printTriangle(int n){ // use long insted of int, for input 100 int overflows // score 1.5
        if(n==0){
            return;
        }
        int[][] triangle = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    triangle[i][j] = 1;
                }
                else{
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        printTriangle(5);
    }
}
