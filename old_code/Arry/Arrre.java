public class Arrre {

  public static void main(String[] args) {
    String[] arr = new String[] { "GG", "DD", "CC", "MM" };

    String[] arr1 = new String[arr.length];
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = arr[i];
    }

    for (int i = 0; i < arr.length / 2; i++) {
      String temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "\t");
    }

    // Linear search
    String dest = "DD";
    boolean isFlag = true;
    for (int i = 0; i < arr.length; i++) {
      if (dest.equals(arr[i])) {
        System.out.println("find success:" + i);
        isFlag = false;
        break;
      }
    }
    if (isFlag) {
      System.out.println("ERROR: CAN'T FIND DEST");
    }

    // dichotomy

    int arr2[] = new int[] { -222, 3, 5775, 234, -304, 555, 63, -32 };

    int dest1 = 552;
    int head_index = 0;
    int end_index = arr2.length - 1;
    boolean isFlag2 = true;
    while (head_index <= end_index) {
      int middle = (head_index + end_index) / 2;
      if (dest1 == arr2[middle]) {
        System.out.println("Find success:" + middle);
        isFlag2 = false;
        break;
      } else if (dest1 < arr2[middle]) {
        end_index = middle - 1;
      } else {
        head_index = middle + 1;
      }
    }
    if (isFlag2) {
      System.out.println("ERROR:CAN'T FIND DEST!");
    }
  }
}
