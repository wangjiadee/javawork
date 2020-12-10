import java.util.Arrays;

public class Arraystest {

  public static void main(String[] args) {
    int[] arr1 = new int[] { 1, 2, 3, 4 };
    int[] arr2 = new int[] { 1, 2, 3, 4 };

    // Compare whether the arrays are the same
    boolean isEquals = Arrays.equals(arr1, arr2);
    System.out.println(isEquals);

    // Automatically traverse the array
    System.out.println(Arrays.toString(arr1));
  }
}
