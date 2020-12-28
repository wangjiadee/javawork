package org.ralph.java;

public class PersonTest {
    public static void main(String[] args) {
        Person p2 = new Man();
//        Person p2 = new Woman();


        p2.name = "ralph";
//        p2.isSmoking = true;
//  有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，但由于声明变量为父类类型，
//  导致编译的时候，只能调用父类的声明和方法，子类特有的属性和方法不能调用

        Man m1 = (Man)p2;
        m1.earnMoney();
        m1.isSmoking = true;

//       类型转换异常
//        Woman w1 = (Woman).p2;
//        w1.goShopping();

//        if(p2 instanceof Woman){
//        if(p2 instanceof Woman){
//            Woman w1 = (Woman)p2;
//            w1.goShopping();
//            System.out.println("******Woman******");
//        }

//        if(p2 instanceof Man){
//            Man m2 = (Man)p2;
//            m2.earnMoney();
//            System.out.println("******man******");
//        }

//        Person p3 = new Woman();
//        Man m3 = (Man)p3;

//        Person p4 = new Person();
//        Man m4 = (Man)p4;

        Object obj = new Woman();
        Person p = (Person)obj;

//        Man m5 = new Woman();


    }
}
