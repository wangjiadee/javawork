public class Arraytest {
    public static void main(String[] args) {
        int [] arr = new int[10];

        for(int i =0; i<arr.length; i++){
            arr[i] = (int)(Math.random() * (99- 10 +1) +10);
        }
        for(int i = 0;i <arr.length;i++){
            System.out.println(arr[i]);
        }
    System.out.println();

    int maxValue = arr[0];
    for(int i = 1;i < arr.length;i++){
        if(maxValue < arr[i]){
            maxValue = arr[i];
        }
    }
    System.out.println("×î´óÖµ:" + maxValue);
    }
}