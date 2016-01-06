/**
 * 
 */
package midTerm;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class FindIndex {

  /**
   * @param args
   */
  static int index = -1;

  public static void main(String[] args) {

    int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9 };

    findIndex(a, 0, a.length - 1);
    System.out.println(index);
  }

  /**
   * @param a
   * @param r
   * @param l
   * @return
   */
  private static int findIndex(int[] a, int l, int r) {
    int n = r - l + 1;
    if (n == 0) {
      return -1;
    }
    while (n > 0) {

      int m = ((n) / 2) + l;
      if (a[m] == m) {
        index = m;
        return m;
      }
      int i = findIndex(a, l, m - 1);

      int j = findIndex(a, m + 1, r);
      if (i != -1) {
        return i;
      } else if (j != -1) {
        return j;
      } else {
        return -1;
      }

    }
    return -1;
  }
}
