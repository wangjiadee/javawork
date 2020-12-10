/*
 * @Author: your name
 * @Date: 2020-10-27 16:00:10
 * @LastEditTime: 2020-10-27 16:23:57
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Workbenchu:\work\java\arr\arrtest.java
 */
public class arrtest  {
    public static void main(String[] args) {
        int num;
        num =10;
        int id =10003;

        // 定义数组内元素的类型
        int[] ids;
        ids = new int[]{101,102,203,304};
        // 动态初始化
        String[] names = new String[3];


        // 调用数组指定的元素
        names[0] =  "ads";
        names[1] =  "a2s";
        names[2] =  "ssss";

        // 获取数组的长度 length
        System.out.println(names.length);


        // 遍历数组
        for(int i =0;i<names.length;i++){
            System.out.println(names[i]);
        }

    }
}