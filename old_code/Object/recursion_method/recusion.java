/*
 * A method calls itself
 * @param n
 * @return sum
 */
public class recusion {
    public static void main(String[] args) {
        recusion ralph = new recusion();
        int sum = ralph.getSum(50);
        System.out.println(sum);
    }
    public int getSum(int n ) {
        if (n == 1){
            return 1;
        }else {
            return n + getSum(n -1);
        }
    }
}