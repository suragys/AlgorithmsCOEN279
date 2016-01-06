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
public class LongestCommonSubsequenceTest1 {

  @Test
  public void test_01() throws Exception {
    String a = "ABCDGH";
    String b = "AEDFHR";
    String expected = "ADH";
    LongestCommonSubsequenceSubmission object = new LongestCommonSubsequenceSubmission();
    String ans = object.getLongestCommonSubsequence(a, b);
    assertEquals(expected, ans);
  }

  @Test
  public void test_02() throws Exception {
    String a = "AGGTAB";
    String b = "GXTXAYB";
    String expected = "GTAB";
    LongestCommonSubsequenceSubmission object = new LongestCommonSubsequenceSubmission();
    String ans = object.getLongestCommonSubsequence(a, b);
    assertEquals(expected, ans);
  }

  @Test
  public void test_03() throws Exception {
    String a = "ramendu";
    String b = "rmd";
    String expected = "rmd";
    LongestCommonSubsequenceSubmission object = new LongestCommonSubsequenceSubmission();
    String ans = object.getLongestCommonSubsequence(a, b);
    assertEquals(expected, ans);
  }

}
