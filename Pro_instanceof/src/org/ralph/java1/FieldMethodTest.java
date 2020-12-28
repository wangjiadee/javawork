package org.ralph.java1;
/**
 * 若子类中重写了父类的方法，那么就意味着子类里定义的方法彻底覆盖了父类里面的同名方法
 * 系统将不可能把父类里的方法转移到子类中
 * 但对于实例变量却不存在这样的现象
 *
 * */
class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}

public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);//20
        s.display();//20

        Base b = s;//多态性(属性都看左边)
        //==：对于引用数据类型来讲，比较的是两个引用数据类型变量的地址值是否相同
        System.out.println(b == s);//true
        System.out.println(b.count);//10
        b.display();//20
    }
}