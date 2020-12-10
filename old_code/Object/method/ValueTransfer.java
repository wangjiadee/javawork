/*
*  形参的传递机制： 传递值
*  实参 和 形参 ：
        形参：方法定义时，声明小括号内的参数
        实参：方法调用时，实际传递形参的数据

* 值传递机制：
    如果参数是基本数据类型，那么实参给形参是实参真实存储的数据值
    如果参数是引用数据类型，那么实参给形参是实参存储数据的的地址值 
 */


public class ValueTransfer {
    public static void main(String[] args) {
        
        // The operation of swapping the values ​​of two variables
        int m = 212;
        int n = 123;
        System.out.println("m= "+ m +",n= " +n);

        // int temp = m;
        // m = n;
        // n = temp;

        ValueTransfer ralph = new ValueTransfer();
        ralph.sawp(m,n);
        
    }


    public void sawp(int m ,int n) {
        int temp = m;
        m = n;
        n = temp;
        System.out.println("m= "+ m +",n= " +n);
    }
}
