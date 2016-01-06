/**
 * 
 */
package com.algo.homework6;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class LongestCommonSubstring {

  private String Longest;

  /**
   * @return the longest
   */
  public String getLongest() {
    return Longest;
  }

  /**
   * @param longest
   *          the longest to set
   */
  public void setLongest(String longest) {
    Longest = longest;
  }

  public int getLenghtOfLongest() {
    if (Longest == null) {
      return 0;
    }
    return Longest.length();
  }

  /**
   * @param a
   * @param b
   * @return
   */
  public String getLongestCommonSubstringBrute(String a, String b) {
    int[][] table3 = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i < table3.length; i++) {
      table3[0][i] = 0;
    }
    for (int i = 0; i < table3[0].length; i++) {
      table3[0][i] = 0;
    }
    for (int i = 0; i < a.length(); i++) {
      int k = i;
      for (int j = 0; j < b.length(); j++) {
        String longest = "";
        int l = j;
        while (k < a.length() && l < b.length()) {
          if (a.charAt(k) == b.charAt(l)) {
            longest = longest + a.charAt(k);
            if (longest.length() >= getLenghtOfLongest()) {
              setLongest(longest);
            }
            k++;
            l++;
          } else {
            break;
          }
        }
        table3[i + 1][j + 1] = getLenghtOfLongest();
      }
    }
    LongestCommonSubsequence.print(table3);
    int i = table3.length - 1;
    int j = table3[0].length - 1;
    String subString = "";
    System.out.println(i + " " + j);
    while (i > 0 && j > 0) {
      if (table3[i][j] > table3[i - 1][j - 1]) {
        int k = table3[i][j];
        System.out.println(i + " " + j);
        for (int l = 0; l < k; l++) {
          subString = subString + a.charAt(i + l - 1);
        }
        break;
      }
      i--;
      j--;
    }
    System.out.println(subString);
    return getLongest();
  }

  public static void main(String[] args) {
    String a = "XACDEF";
    String b = "AXYDEF";
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    String res = lcs.getLongestCommonSubstringDP(a, b);
    System.out.println(res);
  }

  /**
   * @param a
   * @param b
   * @return
   */
  public String getLongestCommonSubstringDP(String a, String b) {
    int[][] lcSubstringTable = new int[a.length() + 1][b.length() + 1];
    char[] A = a.toCharArray();
    char[] B = b.toCharArray();

    // if A is null then LCS of A, B =0
    for (int i = 0; i <= B.length; i++)
      lcSubstringTable[0][i] = 0;
    // if B is null then LCS of A, B =0
    for (int i = 0; i <= A.length; i++)
      lcSubstringTable[0][i] = 0;

    int length = 0;
    int x = 0, y = 0;
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        if (A[i - 1] == B[j - 1]) {
          lcSubstringTable[i][j] = 1 + lcSubstringTable[i - 1][j - 1];
          if (length <= lcSubstringTable[i][j]) {
            length = lcSubstringTable[i][j];
            // Keep track of the largest substring's position in the table
            x = i;
            y = j;
          }
        } else {
          lcSubstringTable[i][j] = 0;
        }
      }
    }

    // Build the Substring by back tracking the table
    StringBuilder sb = new StringBuilder();
    while (lcSubstringTable[x][y] > 0) {
      sb.append(A[x - 1]);
      x--;
      y--;
    }
    String lcSubstring = sb.reverse().toString();
    LongestCommonSubsequence.print(lcSubstringTable);
    return lcSubstring;
  }
}
