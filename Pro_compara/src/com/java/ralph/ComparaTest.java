package com.java.ralph;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparaTest {

    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2() {
        AVGrils[] arr = new AVGrils[5];
        arr[0] = new AVGrils("吉泽明步", 65);
        arr[1] = new AVGrils("大桥未久", 45);
        arr[2] = new AVGrils("苍井空", 45);
        arr[3] = new AVGrils("小泽", 40);
        arr[4] = new AVGrils("波多野结衣", 50);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                String s2 = (String) o2;
                return -s1.compareTo(s2);
            }
            throw new RuntimeException("输入的数据类型不一致");
        }
        });
        System.out.println(Arrays.toString(arr));
    }


}
