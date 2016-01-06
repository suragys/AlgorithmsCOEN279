
package com.algo.homeWork2;


/**
 *
 * @author Surag Suresh Yalaburgi
 */
public class BinaryArray {
    
    public static void main(String[] args) {
   // TODO Complete the implementaion
        int n = 4;
        int[][] tuples;
        int x = (int)Math.pow(2, n);
        tuples = new int[ x][n];
        for (int i = 2, k = n-1; i < x; k--, i = i * 2) {
            for (int j = x-1; j >= 0; j--) {
                if (j % i == 0) {
                    tuples[j][k] = 0;
                } else {
                    tuples[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tuples[i][j]);
            }
            System.out.println();
        }
    }
    
    

    public static int writeZero(int arrayElemnt) {
        return arrayElemnt = 0;
    }
    
    public static int writeOne(int arrayElemnt) {
        return arrayElemnt = 1;
    }
}
