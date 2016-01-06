/**
 * 
 */
package com.algo.homeWork5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class MinimumCoin {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int coins[] = { 9, 6, 2, 1 };
    int numOfCoins[] = { 1, 1, 1, 1 };
    int m = coins.length;
    int V = 11;
    System.out.println("Minimum coins required is "
        + minCoins(coins, m, V, numOfCoins));
  }

  // A Dynamic Programming based C++ program to find minimum of coins
  // to make a given change V

  // m is size of coins array (number of different coins)
  static int minCoins(int coins[], int m, int V, int[] numOfCoins) {
    // table[i] will be storing the minimum number of coins
    // required for i value. So table[V] will have result
    int table[] = new int[V + 1];

    // Base case (If given value V is 0)
    table[0] = 0;

    // Initialize all table values as Infinite
    for (int i = 1; i <= V; i++)
      table[i] = Integer.MAX_VALUE;

    // Compute minimum coins required for all
    // values from 1 to V
    for (int i = 1; i <= V; i++) {
      // Go through all coins smaller than i
      // int tempCoins[] = numOfCoins; // can't do it this way because its array
      int tempCoins[] = new int[numOfCoins.length];
      for (int j = 0; j < numOfCoins.length; j++) {
        tempCoins[j] = numOfCoins[j];
      }
      for (int j = 0; j < m; j++)
        if (coins[j] <= i && tempCoins[j] > 0) {
          int sub_res = table[i - coins[j]];
          if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
            table[i] = sub_res + 1;
            tempCoins[j]--;
          }
        }
    }
    return table[V];
  }
}
