/**
 * 
 */
package com.algo.homeWork3;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class SearchK {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int[] b = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 110 };

    int k = 10;

    int res = SearchKth(a, b, 0, a.length - 1, 0, b.length - 1, k);

    System.out.println(res);

  }

  private static int SearchKth(int[] a, int[] b, int leftA, int rightA,
      int leftB, int rightB, int k) {

    int sizeA = rightA - leftA + 1;
    int sizeB = rightB - leftB + 1;

    // Always make the Array A the Smaller
    if (sizeA > sizeB) {
      return SearchKth(b, a, leftB, rightB, leftA, rightA, k);
    }

    // base case
    if (sizeA == 0 && sizeB > 0) {
      return b[k - 1];
    }

    // base case 
    if (k == 1) {
      return a[leftA] > b[leftB] ? b[leftB] : a[leftA];
    }

    // Divide arrays into two parts wrt k
    int i = sizeA < k / 2 ? sizeA : k / 2;
    int j = sizeB < k / 2 ? sizeB : k / 2;

    if (a[i - 1] < b[j - 1]) {
      return SearchKth(a, b, leftA + i, rightA, leftB, rightB - j, k - i);
    } else {
      return SearchKth(a, b, leftA, rightA - i, leftB + j, rightB, k - j);
    }
  }
}
