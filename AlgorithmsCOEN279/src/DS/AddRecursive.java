/**
 * 
 */
package DS;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class AddRecursive {

  /**
   * @param args
   */
  public static void main(String[] args) {
    float n = 4;
  float res = addRecursive(n);
//    double res = 1/n;
    System.out.println(res);
  }

  /**
   * @param n
   * @return
   */
  private static float addRecursive(float n) {
    if (n == 1) {
      return 1;
    }

    return (1 / n) + addRecursive(n - 1);
  }

}
