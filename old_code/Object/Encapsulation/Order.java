/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-11-14 15:39:43
 * @LastEditTime: 2020-11-14 15:43:02
 * @FilePath: \javawork\Object\Encapsulation\Order.java
 * @Effect: DO
 */
public class Order {
    private int orderPrivate;
    int orderDefault;
    public int orderPublic;

    private void methodPrivate(){
        orderPrivate = 111;
        orderDefault = 222;
        orderPublic = 333;
    }

    void methodDefault(){
        orderPrivate = 111;
        orderDefault = 222;
        orderPublic = 333;
    }

    public void methodPublic(){
        orderPrivate = 111;
        orderDefault = 222;
        orderPublic = 333;
    }
}