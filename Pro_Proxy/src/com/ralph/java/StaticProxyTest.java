package com.ralph.java;

/**
 * Description:静态代理举例 代理类和被代理类在编译期间，就确定下来了。
 * Class:
 * Author:     ralph
 **/
interface MakeFactory{
    void produce();
}
//代理类
class ProxyMakeFactory implements  MakeFactory{
    private MakeFactory makefactory;

    public ProxyMakeFactory(MakeFactory makefactory) {
        this.makefactory = makefactory;
    }

    @Override
    public void produce() {
        System.out.println("三方公司准备进行一些操作");

        makefactory.produce();

        System.out.println("授权成功，开始操作");
    }
}

class MoneyCompany implements MakeFactory{
    @Override
    public void produce() {
        System.out.println("同意豁免");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        MoneyCompany moneyCompany = new MoneyCompany();
        ProxyMakeFactory proxyMakeFactory = new ProxyMakeFactory(moneyCompany);
        proxyMakeFactory.produce();


    }
}
