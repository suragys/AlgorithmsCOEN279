/**
 * 
 */
package com.algo.homework6;

/**
 * @author Surag Suresh Yalaburgi
 * 
 *         Homework 6<br>
 *         COEN 279 - Design and analysis of algorithm<br>
 * 
 *         INPUT: two string s and t;
 * 
 *         OUTPUT: a longest string c such that c is a substring of s and c is
 *         also a substring of t.
 *
 */
public class LongestCommonSubstringSubmission {
  public static void main(String[] args) {
    String a = "AXACDEF";
    String b = "YDEFAXAC";
    String res = getLongestCommonSubstringDP(a, b);
    System.out.println(res);
  }

  /**
   * @param s
   * @param t
   * @return
   */
  public static String getLongestCommonSubstringDP(String s, String t) {

    int[][] lcSubstringTable = new int[s.length() + 1][t.length() + 1];
    char[] S = s.toCharArray();
    char[] T = t.toCharArray();

    // if S is null then LCS of S, T =0
    for (int i = 0; i <= T.length; i++)
      lcSubstringTable[0][i] = 0;
    // if T is null then LCS of S, T =0
    for (int i = 0; i <= S.length; i++)
      lcSubstringTable[0][i] = 0;

    // initializing variables that are used to keep track of the longest
    // substring
    int length = 0;
    int x = 0, y = 0;
    for (int i = 1; i <= S.length; i++) {
      for (int j = 1; j <= T.length; j++) {

        // If the String elements are same
        if (S[i - 1] == T[j - 1]) {
          // Then look into the table, get the previous state(Substring Length)
          // of the substring's table and compute the current State
          lcSubstringTable[i][j] = 1 + lcSubstringTable[i - 1][j - 1];

          // If the current state(Substring Length) is greater than the longest
          // substring then update the tracking of longest Substring.
          if (length < lcSubstringTable[i][j]) {
            // Update the length of longest
            length = lcSubstringTable[i][j];
            // Keep track of the largest substring's position in the table
            x = i;
            y = j;
          }
        } else {
          // Reset the current state to zero when the elements are characters
          // are different
          lcSubstringTable[i][j] = 0;
        }
      }
    }

    // Build the Substring by back tracking the table from the position which we
    // have saved in variables X and Y
    StringBuilder sb = new StringBuilder();
    while (lcSubstringTable[x][y] > 0) {
      sb.append(S[x - 1]);
      x--;
      y--;
    }
    String lcSubstring = sb.reverse().toString();
    return lcSubstring;
  }

}
