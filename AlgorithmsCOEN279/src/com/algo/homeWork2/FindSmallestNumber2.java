package com.algo.homeWork2;

/**
 * 
 * @author Surag Suresh Yalaburgi
 */
public class FindSmallestNumber2 {

  public int smallestNumber(int[] array, int left, int right) throws Exception {

    if (left > right) {
      throw new Exception(
          "Please check the parameters passed. Left is greater than right");
    }

    // Find number of elements in the array
    int numberOfElements = right - left + 1;

    // If number of elements is 1. Then return the number as this is smallest.
    if (numberOfElements == 1) {
      return array[0];
    }

    // If there are two elements the compare and return the smallest.
    if (numberOfElements == 2) {
      return array[0] > array[1] ? array[1] : array[0];
    }

    // Divide the array into logical halves if the element is in the array is
    // more than 2
    // Calculate the index of the mid-point of the array
    int mid = (numberOfElements / 2) + left;

    // call recursively and get the smallest numbers of the recursive calls.
    int small1 = smallestNumber(array, left, mid);
    int small2 = smallestNumber(array, mid + 1, right);

    // Merge
    // compare and result returned by the recursive call and return the smallest
    // number.
    return small1 > small2 ? small2 : small1;

  }
}
