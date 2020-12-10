/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-12-01 21:19:47
 * @LastEditTime: 2020-12-01 21:39:53
 * @FilePath: \javawork\Object\Pro_this\Boy.java
 * @Effect: DO
 */
public class Boy{
    private String name;
    private int age;

    public Boy(){

    }

    public Boy(String name){
        this.name = name;
    }

    public Boy(String name, int age){
        this.name = name;
        this.age= age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }


    public void marry(Girl girl){
        System.out.println("I like marry " + girl.getName());
    }

    public void shout(){
        if (this.age >= 22){
            System.out.println("u can make love");
        }else{
            System.out.println("do youself!");
        }

    }
}