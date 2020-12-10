public class MaoPao {

  public static void main(String[] args) {
    int[] arr = new int[] {
      123,
      4454,
      554,
      365,
      3412,
      34,
      3,
      54,
      1445,
      1,
      2,
      3,
      213,
      4,
    };

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "\t");
    }
  }
}
