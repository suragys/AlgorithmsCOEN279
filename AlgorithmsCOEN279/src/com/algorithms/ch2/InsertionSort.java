package com.algorithms.ch2;

import java.util.Scanner;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class InsertionSort {

  /**
   * @param args
   * 
   */
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int length = s.nextInt();
    int[] list = new int[length];
    for (int i = 0; i < list.length; i++) {
      // have to validation before assign
      // throw exception. stating the problem
      list[i] = s.nextInt();
    }
    s.close();
    sort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i]);
    }

  }

  /**
   * @param list
   */
  private static void sort(int[] list) {
    for (int j = 1; j < list.length; j++) {
      int key = list[j];
      int i = j - 1;
      while (i >= 0 && list[i] > key) {
        list[i + 1] = list[i];
        i = i - 1;
        list[i + 1] = key;
      }
    }
  }
}
