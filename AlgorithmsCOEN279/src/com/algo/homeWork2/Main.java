/**
 * 
 */
package com.algo.homeWork2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Surag Suresh Yalaburgi
 *
 */
public class Main {

/*  *//**
   * @param args
   * @throws IOException 
   *//*
  public static void main(String[] args) throws IOException {


    int n =10;

    int x = (int) Math.pow(2, n);
    int[][] tuples = new int[x][n];
    final long startTime = System.currentTimeMillis();
    BinaryArray2 object = new BinaryArray2();
    tuples = object.generateBinaryTuples(n);
    final long endTime = System.currentTimeMillis();
    
    File output = new File("C:\\Users\\Hemantharaju\\eclipseWorkspace\\AlgorithmsCOEN279\\Files\\output.txt");
    FileWriter fw = new FileWriter(output);
    PrintWriter pw = new PrintWriter(fw);
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(tuples[i][j]);
        pw.print(tuples[i][j]);
      }
      System.out.println();
      pw.println();
      pw.flush();
    }
    pw.close();
    System.out.println("Total execution time: " + (endTime - startTime));
  

  }*/
  public static void main(String[] args) {

    int[] input = { 1, 2, 3, 4 };
    boolean result = new Subset().isSubset(input);

    System.out.println(result);
  }

}
