package com.algo.homeWork2;

/**
 * 
 * @author Surag Suresh Yalaburgi
 */
public class Subset {

  /**
   * For a given input Set X of n positive numbers returns TRUE if there is a
   * subset Y of X such that the total sum of elements in Y equal the total sum
   * of elements in X−Y. FALSE otherwise.
   * 
   * @param input
   *          The set of positive numbers.
   * @return {@link Boolean} True is condition satisfies.
   */
  public boolean isSubset(int[] input) {
    int n = input.length;
    int x = (int) Math.pow(2, n);

    // Solve using Binary digit pattern for finding sum of all possible subsets.

    // For a given set of n numbers. If we want to divide it into two unique
    // subsets. We can do it (2^(n-1))-1 ways.
    // All combination are generated by generating binary series of n-digit
    // binary number from 1 to 2^(n-1)-1
    // Adding all numbers which corresponds to zero as SumSubSet1.
    // Adding all numbers which corresponds to ones as SumSubSet2.
    // If any one such combination satisfies SumSubSet1 = SumSubSet2. We have
    // found the subset, return true. else return false.

    // Loop from 1 till 2^(n-1)-1
    for (int i = 1; i < x / 2; i++) {
      Integer temp = i;
      int subSetSum1 = 0;
      int subSetSum2 = 0;

      // Loop from n-1 to 0
      // To read each bit of n-digit binary value of number.
      for (int j = n - 1; j >= 0; j--) {

        // Bit-wise AND to Get the value LSB.
        int y = temp & 1;
        if (y == 0) {
          // If the bit is zero add it to subSetSum1
          subSetSum1 += input[j];
        } else {
          // If the bit is zero add it to subSetSum2
          subSetSum2 += input[j];
        }
        // right shift by 1 two read the next bit.
        temp = temp >> 1;
      }
      // If the sum is equal return true.
      if (subSetSum1 == subSetSum2) {
        return true;
      }
    }
    return false;
  }
}