package src.com.ralph.Buffer;

import org.junit.Test;

public class BufferTest2 {
    @Test
    public void Test1(){
        String str = null;
        System.out.println(str);  //null
        StringBuffer sb = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。
        sb.append(str);//将null 添加到了char[]里面

        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1 =new StringBuffer(str); //真实的把空指针加到了数字里面
        System.out.println(sb1);//java.lang.NullPointerException 空指针报错
    }

    @Test
    public void Test2(){
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");

        System.out.println(a.equals(b)); //T
        System.out.println(a == b);      //T
        System.out.println(c.equals(d)); //T
        System.out.println(c == d);      //F
        System.out.println(a.equals(c)); //T
        System.out.println(a == c);      //F


    }

}

