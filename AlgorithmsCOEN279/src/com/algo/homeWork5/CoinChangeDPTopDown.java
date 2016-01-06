/**
 * 
 */
package com.algo.homeWork5;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Surag Suresh Yalaburgi
 *
 */
public class CoinChangeDPTopDown {

  /**
   * @param args
   */
  public static void main(String[] args) {

    int total = 30;
    int[] coins = { 25, 10, 20 };
    Map<Integer, Integer> map = new TreeMap<>();

    int minCoins = coinChangeDPTD(total, coins, map);
    System.out.println(minCoins);
    System.out.println(map);
  }

  /**
   * @param total
   * @param coins
   * @return
   */
  private static int coinChangeDPTD(int total, int[] coins,
      Map<Integer, Integer> minCoins) {

    if (total == 0) {
      return 0;
    }

    if (minCoins.get(total) != null) {
      return minCoins.get(total);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] > total)
        continue;
      int coinsRequired = coinChangeDPTD(total - coins[i], coins, minCoins);

      if (coinsRequired < min)
        min = coinsRequired;

    }
    min = (min == Integer.MAX_VALUE ? min : min + 1);
    minCoins.put(total, min);
    return min;
  }

}
