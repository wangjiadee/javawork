package com.ralph.java2;
/*
* 如何自定义异常类
* 1.继承于现有的异常结构 :RuntimeException Exception
* 2.提供全局常量 序列化UID
* 3.构造器
*
* */
public class MyDiyExceoption extends RuntimeException{
    static final long serialVersionUID = -7034897193246939L;

    public MyDiyExceoption(){

    }

    public MyDiyExceoption(String msg){
        super(msg);
    }

}
