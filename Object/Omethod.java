/*
"一切都是对象"
    java中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的结构

匿名对象调用 一次
    创建对象没有赋予变量名字 
*/ 
public class Omethod{
    public static void main(String[] args) {
        Phone p =new Phone();
        System.out.println(p);
        p.sendEmail();
        p.playGame();

        new Phone().sendEmail();
        new Phone().playGame();
        new Phone().price = 1999;
        new Phone().showPrice(); // 0.0
    }
}

class Phone{
    double price;
    public void sendEmail() {
        System.out.println("Send email");
    }
    public void playGame() {
        System.out.println("Play!");
    }

    public void showPrice(){
        System.out.println("price"+price);
    }
}