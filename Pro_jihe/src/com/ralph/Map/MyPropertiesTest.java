package com.ralph.Map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyPropertiesTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis); //加载流对应的文件

            String Username = pros.getProperty("Username");
            String Password = pros.getProperty("Password");
            System.out.println("N: " + Username + "P :" +Password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
