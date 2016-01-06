package misc;

/**
 *
 * @author Surag
 */
public class Subset {

    public static void main(String[] args) {

       
        int[] input = {1, 2, 3,4,5};
         int n = input.length;
        int[][] tuples;
        int x = (int) Math.pow(2, n);
        tuples = new int[(x/2)-1][n];
        boolean result = false;
        for (int i = 1; i < x / 2; i++) {
            Integer temp = i;
            int subSum1 = 0;
            int subSum2 = 0;
            for (int j = n - 1; j >= 0; j--) {
                int y = temp & 1;
                if (y == 1) {
                    tuples[i-1][j] = 1;
                    subSum1 += input[j];
                    //tuples[x - i - 1][j] = 0;
                } else {
                    tuples[i-1 ][j] = 0;
                    subSum2 += input[j];
                    //tuples[x - i - 1][j] = 1;
                }
                temp = temp >> 1;
            }
//            if (subSum1 == subSum2) {
//                result = true;
//                break;
//            }
        }
        System.out.println(result);
        System.out.println(tuples.length);
        
        for (int i = 0; i < (x/2)-1; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tuples[i][j]);
            }
            System.out.println();
        }
    }
}
