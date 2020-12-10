/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-11-14 16:30:11
 * @LastEditTime: 2020-11-14 16:36:34
 * @FilePath: \javawork\Object\Encapsulation\Class\Person.java
 * @Effect: DO
 */
public class Person{
    private int age;

    public void setAge(int a){
        if(a < 0 || a > 130){
            System.out.println("Error: Incoming illegal data!");
            return;
        }
        age = a;
    }
    public int getAge() {
        return age;
    }
}