package src.com.ralph.StringMethod;

import org.junit.Test;

import java.util.Locale;

public class StringMethodTest {

    @Test
    /**
     * Description: String的常用方法

     * return
     * Author:     ralph
     **/
    public void Test1(){
        String s1 = "Fucking";
        String s2 = "   F U C K      ";
        String s3 = "dev";
        String s4 = "uck";
        System.out.println("int length()：返回字符串的长度： return value.length ");
        System.out.println(s1.length());
        //char charAt(int index)： 返回某索引处的字符return value[index]
        System.out.println(s1.charAt(5));
        //boolean isEmpty()：判断是否是空字符串：return value.length == 0
        System.out.println(s1.isEmpty());
        //String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
        System.out.println(s1.toLowerCase(Locale.ROOT));
        //String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
        System.out.println(s1.toUpperCase(Locale.ROOT));
        //String trim()：返回字符串的副本，忽略前导空白和尾部空白
        System.out.println(s2.trim());
        //boolean equals(Object obj)：比较字符串的内容是否相同
        System.out.println(s1.equals(s2));
        //boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        //String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
        System.out.println(s1.concat(s3));
        //int compareTo(String anotherString)：比较两个字符串的大小
        System.out.println(s1.compareTo(s3));
        //String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        System.out.println(s1.substring(3));
        //String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
        System.out.println(s1.substring(0,4));

        //boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        System.out.println(s1.endsWith("g"));

        System.out.println("-------------------boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始");
        System.out.println(s1.startsWith("F"));

        System.out.println("-------------------boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始");
        System.out.println(s1.startsWith("c",2));

        System.out.println("-------------------boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true");
        System.out.println(s1.contains(s4));

        System.out.println("-------------------int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引");
        System.out.println(s1.indexOf("u"));

        System.out.println("-------------------int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始");
        System.out.println(s1.indexOf("g",4));


        String s5 = "shcinsdfoo";
        System.out.println("-------------------int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引");
        System.out.println(s5.lastIndexOf("in"));


        System.out.println("-------------------int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索");
        System.out.println(s5.lastIndexOf("in",2));
        //注：indexOf和lastIndexOf方法如果未找到都是返回-1
        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str
    }


}
