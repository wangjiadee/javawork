/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-11-14 15:43:43
 * @LastEditTime: 2020-11-14 16:29:27
 * @FilePath: \javawork\Object\Encapsulation\OrderTest.java
 * @Effect: DO
 */
public class OrderTest{
    public static void main(String[] args) {
        
        Order ralph = new Order();

        ralph.orderDefault = 1;
        ralph.orderPublic = 2;
        // It cannot be used if the Private property of order.java is out 
        ralph.orderPrivate = 3;
    }
} 