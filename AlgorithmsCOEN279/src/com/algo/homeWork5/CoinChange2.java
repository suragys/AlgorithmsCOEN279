package com.algo.homeWork5;

/**
 * @author Surag Suresh Yalaburgi
 */

public class CoinChange2 {
  private static int[] d = { 50, 25, 10, 1 };
  private static int[] limit = { 2, 1, 2, 5 };

  public static void main(String[] args) {

    // ArrayList<Integer> d = new ArrayList<Integer>(
    // Arrays.asList(50, 25, 1, 10));
    // ArrayList<Integer> limit = new ArrayList<Integer>(
    // Arrays.asList(2, 1, 2, 5));
    System.out.println("Minimum number of coin to make 30 is "
        + minimumCoinChange(d, limit, 30));
  }

  /**
   * @param d
   * @param limit
   * @param i
   * @return
   */
  private static String minimumCoinChange(int[] d,
      int[] limit, int i) {
    sortDesc(d, 0, d.length - 1, limit);
    System.out.println(d);
    System.out.println(limit);
    return null;
  }

  public static int makeChangeLimitedCoins(int[] d, int[] limit, int n) {

    int[] c = new int[n + 1];
    c[0] = 0;
    int[][] coinsRemaining = new int[n + 1][d.length];
    for (int i = 0; i < d.length; i++) {
      coinsRemaining[0][i] = limit[i];
    }
    int[] denom = new int[n + 1];
    for (int j = 1; j <= n; j++) {
      c[j] = Integer.MAX_VALUE;
      for (int k = 0; k < d.length; k++) {
        if (j >= d[k] && (c[j - d[k]] < Integer.MAX_VALUE)
            && (coinsRemaining[j - d[k]][k] > 0)) {
          if ((c[j] > 1 + c[j - d[k]])) {
            c[j] = 1 + c[j - d[k]];
            denom[j] = d[k];
            for (int m = 0; m < d.length; m++) {
              if (m == k) {
                coinsRemaining[j][m] = coinsRemaining[j - d[k]][m] - 1;
              } else {
                coinsRemaining[j][m] = coinsRemaining[j - d[k]][m];
              }
            }
            coinsRemaining[j][k] = coinsRemaining[j - d[k]][k] - 1;
          }
        } else if (j < d[k]) {
          coinsRemaining[j][k] = coinsRemaining[0][k];
        }
      }
    }
    System.out.println("Printing Coin Value and Change:");
    for (int i = 1; i <= n; i++) {
      if (c[i] == Integer.MAX_VALUE) {
        System.out.println(i + ":" + " Not Possible");
      } else {
        System.out.println(i + ":" + c[i]);
      }
    }
    System.out.println();

    for (int i = 0; i <= n; i++) {
      System.out.print(i + ": ");
      for (int j = 0; j < d.length; j++) {
        System.out.print(coinsRemaining[i][j] + " ");
      }
      System.out.println();
    }
    return c[n];

  }

  public static void sortDesc(int[] d, int low, int high,
      int[] limit) {
    int N = high - low;
    if (N <= 1)
      return;
    int mid = low + N / 2;
    // recursively sort
    sortDesc(d, low, mid, limit);
    sortDesc(d, mid, high, limit);
    // merge two sorted subarrays
    int[] temp = new int[N];
    int i = low, j = mid;
    for (int k = 0; k < N; k++) {
      if (i == mid)
        temp[k] = d[j++];
      else if (j == high)
        temp[k] = d[i++];
      else if (d[j] < d[i])
        temp[k] = d[j++];
      else
        temp[k] = d[i++];
    }
    for (int k = 0; k < N; k++)
      d[low + k] = temp[k];
  }

}
