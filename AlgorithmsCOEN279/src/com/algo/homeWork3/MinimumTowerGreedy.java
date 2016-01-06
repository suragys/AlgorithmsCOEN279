/**
 * 
 */
package com.algo.homeWork3;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class MinimumTowerGreedy {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // houses[] is array of positions of houses on highway
    double houses[] = { 0.5, 1.2, 1.3, 1.4, 3.2, 3.3, 3.4, 4.5, 4.9 };

    int minTowers = calMinimumTowers(houses);
    System.out.println("Minimum number of towers required is " + minTowers);
  }

  /**
   * @param houses
   * @return
   */
  private static int calMinimumTowers(double[] houses) {
    // houses[] is array of positions of houses on highway
    
    int cnt = 1;
    
    // greedy is build tower at position p0+1
    double towerDis = houses[0] + 1;
    for (int i = 1; i < houses.length; i++) {
      if (towerDis + 1 < houses[i]) {
        cnt++;
        towerDis = houses[i] + 1;
      }
      System.out.println(towerDis);
    }
    return cnt;
  }

}
