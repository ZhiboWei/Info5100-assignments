/* Good Work
 * score 7 + extra credit 2; total score 9
 */
package assignment5;

import java.util.LinkedList;
import java.util.List;

public class spiral {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new LinkedList<Integer>();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;

        int lvl = (Math.min(m, n) + 1) / 2;
        for(int i = 0; i < lvl; i++){

            int lastRow = m - i - 1;

            int lastCol = n - i - 1;

            if(i == lastRow){
                for(int j = i; j <= lastCol; j++){
                    res.add(matrix[i][j]);
                }

            } else if(i == lastCol){
                for(int j = i; j <= lastRow; j++){
                    res.add(matrix[j][i]);
                }
            } else {

                for(int j = i; j < lastCol; j++){
                    res.add(matrix[i][j]);
                }

                for(int j = i; j < lastRow; j++){
                    res.add(matrix[j][lastCol]);
                }

                for(int j = lastCol; j > i; j--){
                    res.add(matrix[lastRow][j]);
                }

                for(int j = lastRow; j > i; j--){
                    res.add(matrix[j][i]);
                }
            }
        }
        System.out.print(res);
        return res;

    }
    public static void main(String[] args){
        int[][] arr =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        spiralOrder(arr);
    }
}
