/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package misc;

/**
 * Write a divide-conquer algorithm to find the minimum value in an array
 * A[left..right] of size n = right-left+1.
 *
 * @author Surag Suresh Yalaburgi
 */
public class FindSmallestNumber {

    public static void main(String[] args) throws Exception {
        int[] input = new int[]{11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 71};

        int smallest = findSmallest(input);

        System.out.println(smallest);

    }

    private static int findSmallest(int[] input) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet.");
        if (input.length == 0) {
            throw new Exception("Input array must contain atleast one element");
        }
        if (input.length == 1) {
            return input[0];
        }
        if (input.length == 2) {
            return input[0] > input[1] ? input[1] : input[0];
        } else {
            int middle = input.length / 2;
            int subInput1[] = new int[middle];
            int subInput2[] = new int[input.length - middle];
            System.arraycopy(input, 0, subInput1, 0, subInput1.length);
            System.arraycopy(input, subInput1.length, subInput2, 0, subInput2.length);
            int small1 = findSmallest(subInput1);
            int small2 = findSmallest(subInput2);
            if (small1 > small2) {
                return small2;
            } else {
                return small1;
            }

        }
    }
}
