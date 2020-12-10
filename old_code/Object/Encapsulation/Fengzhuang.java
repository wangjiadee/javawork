/*
 * 封装性的体现
 *     将属性私有化
 *     不对外暴露的私有方法
 *     单例模式
 * 
 * 封装的体现需要权限修饰符来配合
 *     private default protected public
 * 
 * 
 * 
 */
public class Fengzhuang{
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "POOPOO";
        // a.age = 19;
        // a.legs = 4;
        a.setLegs(4);
        a.setAge(19);
        a.eat();
        a.show();
    }
}

class Animal{
    String name;
    private int age;
    private int legs;

    public void setAge(int a){
        if (a > 0 && a <= 150){
            age = a;
        }else {
            age = 0;
        }
    }

    public int getAge(){
        return age;
    }

    
    // Attribute settings 
    public void setLegs(int l) {
        if (l > 0 && l % 2 == 0 ){
            legs = l;
        }else {
            legs = 0;
        }
    }
    
    // Property acquisition 
    public int getLegs() {
        return legs;
    }

    public void eat(){
        System.out.println("Eating somethngs");
    }
    public void show(){
        System.out.println("name:"+ name + ",age:" + age + ",legs:" + legs);
    }
}