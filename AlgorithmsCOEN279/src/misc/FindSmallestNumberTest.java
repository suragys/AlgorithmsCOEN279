/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * 
 * @author Hemantharaju
 */
public class FindSmallestNumberTest {

  @Test
  public void UTC01_01() throws Exception {

    int[] input = new int[] { 7, 1, 71 };
    FindSmallestNumber2 object = new FindSmallestNumber2();
    int actual = object.smallestNumber(input, 0, input.length - 1);
    assertEquals(1, actual);

  }

  @Test
  public void UTC01_02() {

    int[] input = new int[] { 11, 1, 1, 1, 1, 1, 71 };
    FindSmallestNumber2 object = new FindSmallestNumber2();
    int actual = 0;
    try {
      actual = object.smallestNumber(input, 0, input.length - 1);
    } catch (Exception ex) {
      Logger.getLogger(FindSmallestNumberTest.class.getName()).log(
          Level.SEVERE, null, ex);
      ex.printStackTrace();
    }
    assertEquals(1, actual);

  }
}
