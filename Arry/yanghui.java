/*  面试题目*/

public class yanghui {
    public static void main(String[] args) {
        // 1.初始化二维数组
        int[][] yh = new int[10][];
        // 2.给数组的元素赋值
        for(int i = 0;i< yh.length;i++){
            yh[i] = new int [i+1];
            yh[i][0] =yh[i][i] = 1;
            if(i > 1){
                for(int j = 1;j<yh[i].length -1;j++){
                    yh[i][j] = yh[i-1][j-1] + yh[i-1][j];
                }
            }
        }
        // 3.遍历数组
        for(int i=0;i< yh.length;i++){
            for(int j=0;j < yh[i].length;j++){
                System.out.print(yh[i][j] + " | ");
            }
            System.out.println();
        }

    }
}