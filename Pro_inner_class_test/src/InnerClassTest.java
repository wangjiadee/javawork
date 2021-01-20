public class InnerClassTest {
    /*
    * 在局部变量的方法中(show方法) 如果调用局部变量内部类所声明的方法(method)中的局部变量(num)必须是声明一个final
    * 但是java8及其以上不用特意写默认就是
    * 栈的周期较短
    * */
    public void method(){
        final int num = 10;

        class AA{
            public void show(){
                //Variable 'num' is accessed from within inner class, needs to be final or effectively final
                //num = 2;
                System.out.println(num);
            }
        }
    }
}
