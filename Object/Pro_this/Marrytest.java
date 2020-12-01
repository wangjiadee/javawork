/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-12-01 21:36:40
 * @LastEditTime: 2020-12-01 21:43:43
 * @FilePath: \javawork\Object\Pro_this\Marrytest.java
 * @Effect: DO
 */
public class Marrytest{
    public static void main(String[] args) {
        
        Boy boy = new Boy("Tom",21);
        boy.shout();

        Girl girl = new Girl("Jenny",18);
        girl.marry(boy);

        Girl foo = new Girl("ppig",18);
        int compare = girl.compare(foo);
        if(compare > 0){
            System.out.println(girl.getName() + " big");
        }else if(compare < 0){
            System.out.println(foo.getName() + " big");
        }else{
            System.out.println("as soon as");
        }
    }
}