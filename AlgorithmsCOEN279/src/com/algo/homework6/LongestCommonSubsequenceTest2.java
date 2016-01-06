/**
 * 
 */
package com.algo.homework6;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class LongestCommonSubsequenceTest2 {

  @Test
  public void test_01() {
    String a = "ABCDGH";
    String b = "AEDFHR";
    int expected = 3;
    LongestCommonSubsequence object = new LongestCommonSubsequence();
    int ans = object.findLongestPossibleSubsequence(a, b);
    assertEquals(expected, ans);

  }

  @Test
  public void test_02() {
    String a = "AGGTAB";
    String b = "GXTXAYB";
    int expected = 4;
    LongestCommonSubsequence object = new LongestCommonSubsequence();
    int ans = object.findLongestPossibleSubsequence(a, b);
    assertEquals(expected, ans);
  }

}
