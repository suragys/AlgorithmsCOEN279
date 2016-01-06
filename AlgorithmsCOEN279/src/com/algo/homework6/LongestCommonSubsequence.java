/**
 * 
 */
package com.algo.homework6;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class LongestCommonSubsequence {

//  public static void main(String[] args) {
//    String a = "AGGTAB";
//    String b = "GXTXAYB";
//    LongestCommonSubsequence object = new LongestCommonSubsequence();
//    int ans = object.findLongestPossibleSubsequence(a, b);
//    String lcs = object.getLongestPossibleSubsequence(a, b);
//    System.out.println(ans);
//    System.out.println(lcs);
//  }

  /**
   * @param a
   *          Input String
   * @param b
   *          Input String
   * @return The String which is a longest possible Sub-sequence in a and b
   */
  public String getLongestCommonSubsequence(String a, String b) {
    int[][] table = generateLCSTable(a, b);
    String lcs = "";
    int i = table.length - 1;
    int j = table[0].length - 1;

    // Backtracking the table to generate the Longest Common Subsequencef
    while (i != 0 && j != 0) {
      if (table[i][j] > table[i - 1][j] && table[i][j] > table[i][j - 1]) {
        lcs = a.charAt(i - 1) + lcs;
        i--;
        j--;
      } else if (table[i - 1][j] > table[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    return lcs;
  }

  /**
   * @param a
   *          Input String
   * @param b
   *          Input String
   * @return The length of String which is a longest possible Sub-sequence in a
   *         and b
   */
  public int findLongestPossibleSubsequence(String a, String b) {

    int[][] table = generateLCSTable(a, b);
    print(table);
    return table[table.length - 1][table[0].length - 1];
  }

  /**
   * @param a
   * @param b
   * @return A table which contains the value of longest possible subsequences
   *         for all possible sub-strings of a and b
   */
  private int[][] generateLCSTable(String a, String b) {
    // A structure to keep track of longest subsequence for sub-structures
    int[][] table = new int[a.length() + 1][b.length() + 1];
    // Initialize the first row and column with zero.
    // Because if one of two strings is of length zero then there can't be a
    // subsequence.
    for (int i = 0; i < table[0].length; i++) {
      table[0][i] = 0;
    }
    for (int i = 0; i < table.length; i++) {
      table[i][0] = 0;
    }

    for (int i = 1; i <= a.length(); i++) {
      for (int j = 1; j <= b.length(); j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          table[i][j] = table[i - 1][j - 1] + 1;
        } else {
          table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
        }
      }
    }
    return table;
  }

  /**
   * @param table
   */
  public static void print(int[][] table) {
    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < table[0].length; j++) {
        System.out.print(table[i][j]);
      }
      System.out.println();
    }
    System.out.println("printed table");
  }

}
