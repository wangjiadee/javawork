/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-11-14 16:33:14
 * @LastEditTime: 2020-11-14 16:34:59
 * @FilePath: \javawork\Object\Encapsulation\Class\PersonTest.java
 * @Effect: DO
 */
public class PersonTest{
    public static void main(String[] args) {
        
        Person p =new Person();
        // p.age = 1;

        p.setAge(22);
        System.out.println(p.getAge());
    }
}