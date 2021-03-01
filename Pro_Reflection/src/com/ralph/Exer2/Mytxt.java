package com.ralph.Exer2;


import java.io.File;
import java.io.IOException;

public class Mytxt {
    public void myCreate() throws IOException {
        File file = new File("./myhello.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("Create File success!");
        }
    }
}
