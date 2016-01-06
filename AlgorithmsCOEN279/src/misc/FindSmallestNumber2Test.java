/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Surag Suresh Yalaburgi
 */
public class FindSmallestNumber2Test {

  public FindSmallestNumber2Test() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of smallestNumber method, of class FindSmallestNumber2.
   */
  @Test
  public void testSmallestNumber() throws Exception {
    System.out.println("smallestNumber");
    int[] array = { 1, 2, 3, 4 };
    int left = 0;
    int right = array.length - 1;
    FindSmallestNumber2 instance = new FindSmallestNumber2();
    int expResult = 1;
    int result = instance.smallestNumber(array, left, right);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    // fail("The test case is a prototype.");
  }

}
