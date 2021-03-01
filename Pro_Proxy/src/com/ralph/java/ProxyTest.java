package com.ralph.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class IronMan implements Human{
    @Override
    public String getBelief() {
        return "Fucking Work";
    }

    @Override
    public void eat(String food) {
        System.out.println("Mayble like eat " + food);

    }
}

//动态代理
class ProxyF{
    /**
     * Description: 1.被代理类的(已知的)的对象 通过以下方法返回一个动态生成的代理类和对象
     * parameters: obj 被代理类的对象
     * return     动态生成的代理类和代理类对象
     * Author:     ralph
     **/
    public static Object getProxyInstance(Object obj){//obj 被代理类的对象
        //2.2
        MyInvocationHandler Handler = new MyInvocationHandler();

        Handler.bind(obj); //2.8 进行实际赋值 传入被代理类的对象

        //1.1参数1 obj.getClass().getClassLoader() : 类的加载器
        //1.2参数2 obj.getClass().getInterfaces()  : 代理类和被代理类共同实现的接口
        //2.3参数3 Handler 当动态代理想调用方法（如eat方法）那么传递形参就是Handler，然后Handle才调用2.1的invoke
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),Handler);


    }
}

/**
 * Description: 2.创建一个接口 能让动态代理去调用被代理类的同名方法
 * Class://当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
 *       //将被代理类要执行的方法a的功能就声明在invoke()中
 * Author:     ralph
 **/
//因为1步骤的参数3填写了 就能让下面的invoke起作用 所以要在1中实例化接口类
class MyInvocationHandler implements InvocationHandler {

    private  Object obj;              //2.6 在此声明方法 需要使用被代理类的对象进行赋值

    public void bind(Object obj){     //2.7 通过绑定方法赋值 相当于实例化
        this.obj = obj;
    }

    //2.1
    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a（如eat方法）的功能就声明在invoke()中
    //2.4 参数1 Object proxy  代理类的对象 也就是步骤1 return出来的对象
    //2.5 参数2 Method method 就是代理类所调用的方法 也就是被代理类中的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //2.10 参数3 Object[] args  同名方法名
        //2.11 method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方
        Object invoke = method.invoke(obj, args);  //2.9 obj 被代理类的对象
        return invoke;//2.12 代理类对象调用方法的返回值

    }
}

public class ProxyTest {
    public static void main(String[] args) {
        IronMan ironMan = new IronMan(); //就是2中的obj
        //3. proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyF.getProxyInstance(ironMan);
        proxyInstance.eat("cakes"); //3.1 此步骤执行 就会动态的去带哦用2的invoke方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
    }
}
