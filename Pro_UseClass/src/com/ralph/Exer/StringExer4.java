package src.com.ralph.Exer;


import java.io.*;
public class StringExer4{
    public static void main(String args[]) {
        String s1=null,s2=null,ss=null,si=null,sf=null;
        int i1=0,i2=0;
        float f1=0.0f,f2=0.0f;

        BufferedReader strin= new  BufferedReader(new InputStreamReader(System.in));
        try{System.out.print ("输入第一个字符串：" );
            s1= strin.readLine();
            System.out.print ("输入第二个字符串：" );
            s2= strin.readLine();
        }catch(Exception e){ System.out.println(e.getMessage());}
        i1 = Integer.parseInt(s1);
        i2 = Integer.parseInt(s2);
        f1 = Float.parseFloat(s1);
        f2 = Float.parseFloat(s2);
        ss = strAdd(s1,s2);
        si = strAdd(i1,i2);
        sf = strAdd(f1,f2);
        System.out.println ("输入的二个字符串相加结果为："+ss );
        System.out.println ("输入字符串转换为整数相加结果为："+si );
        System.out.println ("输入字符串转换为浮点数相加结果为："+sf );
    }
    static String strAdd(String str1,String str2) {
        return str1+str2;
    }
    static String strAdd(int int1,int int2) {
        return  String.valueOf(int1+int2);
    }
    static String strAdd(float flt1,float flt2) {
        return  String.valueOf (flt1+flt2);
    }
}