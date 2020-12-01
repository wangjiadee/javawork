/*
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-12-01 21:22:33
 * @LastEditTime: 2020-12-01 21:37:52
 * @FilePath: \javawork\Object\Pro_this\Girl.java
 * @Effect: DO
 */
public class Girl{
    private String name;
    private int age;

    public Girl(){

    }

    public Girl(String name){
        this.name = name;
    }

    public Girl(String name, int age){
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

    public void marry(Boy boy){
        System.out.println("i love " + boy.getName());
        // boy.marry(new Girl());
        boy.marry(this);
    }
    /*
     * Compare the size of two objects
     * param : gril
     * return  positive number：The current object is large
     * return  negative number：Current object is small
     * return 0: The current object and the parameter object are equal

    */
    public int compare(Girl girl){
        if(this.age > girl.age){
            return 1;
        }else if(this.age < girl.age){
            return -1;
        }else{
            return 0;
        }
    }
}