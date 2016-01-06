/**
 * 
 */
package com.algo.homeWork3;

import java.util.ArrayList;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class SearchKthElement {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int[] b = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 110 };

    int k = 10;

    int res = findKth(a, b, 0, a.length - 1, 0, b.length - 1, k);

    System.out.println(res);

  }

  /**
   * @param a
   * @param b
   * @param i
   * @param j
   * @param k
   * @param l
   * @return
   */
  private static int findKth(int[] a, int[] b, int leftA, int rightA,
      int leftB, int rightB, int k) {

    // if (a.length == 0) {
    // return b[k - 1];
    // }else if(b.length == 0){
    // return a[k-1];
    // }
    int midA = (rightA + leftA) / 2 + leftA;
    int midB = (rightB + leftB) / 2 + leftB;

    if (a[midA] >= b[midB]) {
      if (midA + midB < k - 1) {
        return findKth(a, b, leftA, midA, leftB, midB, k);
      } else if (midA + midB == k - 2) {
        if (a[midA] < b[midB]) {
          return a[midA];
        } else {
          return findKth(a, b, leftA, midA, midB + 1, rightB, k);
        }
      } else {
        return findKth(a, b, midA + 1, rightA, midB + 1, rightB, k);
      }
    } else {
      if (midA + midB < k - 1) {
        return findKth(a, b, leftA, midA, leftB, midB, k);
      } else if (midA + midB == k - 2) {
        if (a[midA] > b[midB]) {
          return b[midB];
        } else {
          return findKth(a, b, midA + 1, rightA, leftB, midB, k);
        }
      } else {
        return findKth(a, b, midA + 1, rightA, midB + 1, rightB, k);
      }
    }

  }
}
