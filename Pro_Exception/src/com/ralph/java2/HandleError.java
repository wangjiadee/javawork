package com.ralph.java2;

public class HandleError {
    public static void main(String[] args) {
        Student s = new Student();
        s.register(-1);
        System.out.println(s);

    }


}

class Student{
    private int id;

    public void register(int id){
        if (id >0){
            this.id = id;
        }else {
            throw new RuntimeException("[Info :] Illegal data");
        }
    }

    @Override
    public String toString(){
        return "Student [id=" + id + "]";
    }
}
