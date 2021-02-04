package src.com.ralph.StringChange;

import org.junit.Test;

public class StringChangeTest {
    @Test
    public void Test1(){

        String str1 = "1234";
        int ChangeStrNum = Integer.parseInt(str1);
        System.out.println(ChangeStrNum);

        String str2 = String.valueOf(ChangeStrNum);
        String str3 = ChangeStrNum + "";

        System.out.println(str1 == str3);
    }

    @Test
    public void Test2(){
        String s1 = "Fucking live";

        char[] CharArray = s1.toCharArray();
        for (int i = 0; i < CharArray.length; i++) {
            System.out.println(CharArray[i]);
        }

        char[] arr = new char[]{'F','u','c','K'};
        String s2 = new String(arr);
        System.out.println(s2);
    }

    @Test
    public void Test3(){
        String str1 = "abc123尼玛zz";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(bytes);


        String str2 =new String(bytes);
        System.out.println(str2);
    }

}
