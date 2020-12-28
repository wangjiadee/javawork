package com.ralph.java;
import org.junit.Test;
public class WrapperTest {


    @Test
    public void test5(){
        String str1 = "123";
        //错误的情况：
//		int num1 = (int)str1;
//		Integer in1 = (Integer)str1;
        //可能会报NumberFormatException
        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1);

        String str2 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);
    }


    @Test
    public void test4(){
        int num1 = 10;
        String str1 = num1 + "";

        float f1 = 12.3f;
        String str2 = String.valueOf(f1);
        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3);//"12.4"

    }



    @Test
    public void test3(){
        int num1 = 10;
        method(num1);


        int num2 = 122;
        Integer in1 = num2;

        boolean b1 = true;
        Boolean b2 = b1;

        System.out.println(in1.toString());
        int num3 = in1;
    }

    public  void method(Object obj){
        System.out.println(obj);
    }




    @Test
    public void test2(){
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);
    }

    @Test
    public void test1(){
//        Basic data type --> Packaging class: call the conversion of the packaging class
        int num1 = 10;
        Integer in1 = new Integer(num1);
//        System.out.println(num1.toString());
        System.out.println(in1.toString());

        Integer in2 = new Integer("123");
        System.out.println(in2.toString());

        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);

        Order order = new Order();
        System.out.println(order.isFemale);
        System.out.println(order.isMale);

    }
}

class  Order{
    boolean isMale;
    Boolean isFemale;
}