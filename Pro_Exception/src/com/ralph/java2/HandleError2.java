package com.ralph.java2;

public class HandleError2 {
    public static void main(String[] args) {
        try {
            Dog d = new Dog();
            d.register(-1001);
            System.out.println(d);
        } catch (Exception e) {
//			e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}


class Dog{
    private int id;
    public void register(int id) throws Exception {
        if (id > 0){
            this.id = id;
        }else {
            throw new MyDiyExceoption("[Info :] Error things");
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }
}