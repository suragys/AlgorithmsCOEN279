/**
 * 
 */
package com.algo.homeWork5;

/**
 * @author Surag Suresh Yalaburgi
 *
 */
public class CoinChangeSubmitOld {

  public static void main(String[] args) {
    int[] D = { 1, 2, 3 };

    int[] A = { 2, 4, 3 };
    System.out.println(minCoinChangeLimited(D, A, 9));
  }

  public static int minCoinChangeLimited(int[] D, int[] A, int N) {
    int[] C = new int[N + 1];
    // Initialize an array of N+1 elements to keep the minimum coins needed for
    // the value.

    // initialize the frst value to 0 as you dont need any coins if the value
    // is zero.
    C[0] = 0;

    // Initialize an 2D array of N+1 rows and columns equal to number of
    // denominations. Where in keep track of number of coins utilized to make
    // change for the respective value
    int[][] coinsTrack = new int[N + 1][D.length];

    // Initially for value 0 you don't need to use any coins.
    for (int i = 0; i < D.length; i++) {
      coinsTrack[0][i] = A[i];
    }

    // Compute the minimum number of coins required for each value from 1 to N
    for (int j = 1; j <= N; j++) {
      // Initialize the value to be infinity.
      C[j] = Integer.MAX_VALUE;

      for (int k = 0; k < D.length; k++) {

        // If the value is greater than the denomination value
        // AND if there is a value can be computed adding one D[k] denomination
        // AND if the there is D[k] available(which we get to know from the
        // track table)
        // THEN We shall compute the minimum number of coins required
        // OR we just re-initialize the track table for the D[k] considered.
        if (j >= D[k]
            && (C[j - D[k]] < Integer.MAX_VALUE)
            && (coinsTrack[j - D[k]][k] > 0)) {

          if ((C[j] > 1 + C[j - D[k]])) {
            C[j] = 1 + C[j - D[k]];

            // Update the track table
            for (int m = 0; m < D.length; m++) {
              if (m == k) {
                coinsTrack[j][m] = coinsTrack[j - D[k]][m] - 1;
              } else {
                coinsTrack[j][m] = coinsTrack[j - D[k]][m];
              }
            }
            coinsTrack[j][k] = coinsTrack[j - D[k]][k] - 1;
          }

        } // re-initialize the availability of the D[k] in the track table
        else if (j < D[k]) {
          coinsTrack[j][k] = coinsTrack[0][k];
        }
      }
    }

    return C[N];

  }

}
