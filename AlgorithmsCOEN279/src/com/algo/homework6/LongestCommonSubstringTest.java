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
public class LongestCommonSubstringTest {

  @Test
  public void test_01() {
    String a = "ABCDEF";
    String b = "AXYDEF";
    String expected = "DEF";
    LongestCommonSubstring obj = new LongestCommonSubstring();
    String res = obj.getLongestCommonSubstringBrute(a, b);
    assertEquals(expected, res);
  }

  public void test_02() {
    String a = "ABCDEF";
    String b = "AXYDEF";
    String expected = "DEF";
    LongestCommonSubstring obj = new LongestCommonSubstring();
    String res = obj.getLongestCommonSubstringDP(a, b);
    assertEquals(expected, res);
  }
}
