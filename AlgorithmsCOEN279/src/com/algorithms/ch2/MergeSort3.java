/**
 * 
 */
package com.algorithms.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class MergeSort3 {

  /**
   * @param args
   * @throws IOException
   * @throws NumberFormatException
   */

  public static void main() throws NumberFormatException, IOException {

    int i, n;
    ArrayList<Integer> arrlist = new ArrayList<Integer>();
    String list = "";
    System.out.println(" write 'STOP' when list is completed ");
    System.out.println("Enter the total number of elements: ");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    while (!(list = bf.readLine()).equalsIgnoreCase("stop")) {
      int intelement = Integer.parseInt(list);
      arrlist.add(intelement);

    }

    int elementlist[] = new int[arrlist.size()];
    Iterator<Integer> iter = arrlist.iterator();
    for (int j = 0; iter.hasNext(); j++) {
      elementlist[j] = iter.next();
    }
    n = elementlist.length;
    partition(elementlist, 0, n - 1);

    System.out.println("After merge sorting elements are: ");
    for (i = 0; i < n; i++) {
      System.out.printf("%d ", elementlist[i]);
    }

  }

  static void partition(int arr[], int low, int high) {

    int mid;

    if (low < high) {
      mid = (low + high) / 2;
      partition(arr, low, mid);
      partition(arr, mid + 1, high);
      mergeSort(arr, low, mid, high);
    }
  }

  static void mergeSort(int arr[], int low, int mid, int high) {

    int i, m, k, l, temp[] = new int[arr.length];

    l = low;
    i = low;
    m = mid + 1;

    while ((l <= mid) && (m <= high)) {

      if (arr[l] <= arr[m]) {
        temp[i] = arr[l];
        l++;
      } else {
        temp[i] = arr[m];
        m++;
      }
      i++;
    }

    if (l > mid) {
      for (k = m; k <= high; k++) {
        temp[i] = arr[k];
        i++;
      }
    } else {
      for (k = l; k <= mid; k++) {
        temp[i] = arr[k];
        i++;
      }
    }

    for (k = low; k <= high; k++) {
      arr[k] = temp[k];
    }
  }
}
