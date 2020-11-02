/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-11-02 08:16:58
 * @LastEditTime: 2020-11-02 08:17:57
 * @FilePath: /code/Arry/arrayexer.java
 * @Effect: DO
 */
public class arrayexer {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{123,33},{7,0,6,4}};
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                System.out.println(j);
                sum += arr[i][j];
            }
        }
        System.out.println("Sum:"+ sum);
    }
}