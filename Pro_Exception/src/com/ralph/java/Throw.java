package com.ralph.java;
/*
*  “throws + 异常类型” 写在方法的声明处，指明此方法执行时，可能会抛出的异常。
*  一旦这个方法体执行时候出现异常，仍会在异常代码出生成一个异常类的对象，此对象满足throws
*  后异常类型时，就会被抛出（向上抛出） 异常代码后续的代码 就不再执行
*
*  try_catch_finally:真正的将异常给处理掉
*  throw的方式只是将异常抛给了方法的调用者。并没有真正将异常处理掉
*
* */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Throw {
    public static void main(String[] args) {
        try{
            method2();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void method2() throws IOException{
        method1();
    }


    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("Fuck.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();
    }
}
