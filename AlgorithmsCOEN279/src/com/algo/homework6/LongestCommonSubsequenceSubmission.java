/**
 * 
 */
package com.algo.homework6;

/**
 * @author Surag Suresh Yalaburgi
 * 
 *         Homework 6
 *         COEN 279 - Design and analysis of algorithm
 * 
 *         QUESTION 1
 *         We developed in class a dynamic-programming algorithm to
 *         find the length of longest common subsequences of two given strings.
 *         Modify this program to find an actual longest common subsequence, not
 *         just its length.
 * 
 *         INPUT: two string a and b;
 * 
 *         OUTPUT: a longest common subsequence of a and b .
 *
 */
public class LongestCommonSubsequenceSubmission {

  public static void main(String[] args) {
    String a = "AGGTAB";
    String b = "GGXTXAYB";
    LongestCommonSubsequenceSubmission object = new LongestCommonSubsequenceSubmission();
    String lcs = object.getLongestCommonSubsequence(a, b);
    System.out.println(lcs);
  }

  /**
   * @param a
   *          Input String
   * @param b
   *          Input String
   * @return The String which is a longest common Sub-sequence in a and b
   */
  public String getLongestCommonSubsequence(String a, String b) {
    char[] A = a.toCharArray();
    char[] B = b.toCharArray();
    int[][] table = generateLCSTable(A, B);
    String lcs = generateLCS(table, A, B);
    return lcs;
  }

  /**
   * @param A
   * @param B
   * @return A table which contains the value of longest possible subsequences
   *         for all possible sub-strings of a and b
   */
  private int[][] generateLCSTable(char[] A, char[] B) {
    // A structure to keep track of longest subsequence for sub-structures
    int[][] table = new int[A.length + 1][B.length + 1];
    // Initialize the first row and column with zero.
    // Because if one of two strings is of length zero then there can't be a
    // subsequence.
    for (int i = 0; i < table[0].length; i++) {
      table[0][i] = 0;
    }
    for (int i = 0; i < table.length; i++) {
      table[i][0] = 0;
    }

    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        //
        if (A[i - 1] == B[j - 1]) {
          table[i][j] = table[i - 1][j - 1] + 1;
        } else {
          //
          table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
        }
      }
    }
    return table;
  }

  /**
   * @param table
   * @param A
   * @param B
   * @return The string of longest common subsequence of a and b
   */
  private String generateLCS(int[][] table, char[] A, char[] B) {
    StringBuilder lcs = new StringBuilder();
    int i = table.length - 1;
    int j = table[0].length - 1;

    // Backtracking the table to generate the Longest Common Subsequence
    while (i != 0 && j != 0) {
      if (A[i - 1] == B[j - 1]) {
        lcs.insert(0, A[i - 1]);
        i--;
        j--;
      } else if (table[i - 1][j] > table[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    return lcs.toString();
  }
}
