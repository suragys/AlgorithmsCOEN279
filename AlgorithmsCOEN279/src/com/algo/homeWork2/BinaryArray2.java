package com.algo.homeWork2;

/**
 * 
 * @author Surag Suresh Yalaburgi
 */
public class BinaryArray2 {

  /**
   * For given n. Generate 2^n tuples where each tuples has n elements which is
   * represents the tuple was in n-digit binary.
   * 
   * @param n
   *          The Input.
   * @return tuples[][] Two dimensional array of size 2^n X n.
   */
  public int[][] generateBinaryTuples(int n) {

    int x = (int) Math.pow(2, n);
    int[][] tuples = new int[x][n];

    // Loop from 0 till 2^(n-1)
    for (int i = 0; i < x / 2; i++) {
      int temp = i;
      // Loop from n-1 till 0
      for (int j = n - 1; j >= 0; j--) {

        int result = temp & 1; // bit-wise AND with ONE.

        // If the result is one.
        if (result == 1) {
          // Add one into the to the jth element of ith tuple.
          tuples[i][j] = 1;

          // Add zero into the jth element of (x-i-1)th tuple.
          tuples[x - i - 1][j] = 0;
        } else {
          // Add zero into the to the jth element of ith tuple.
          tuples[i][j] = 0;

          // Add one into the jth element of (x-i-1)th tuple.
          tuples[x - i - 1][j] = 1;
        }

        // Bit-wise Right shift the row(i) value by one.
        temp = temp >> 1;
      }
    }
    return tuples;
  }
}
