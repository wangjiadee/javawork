package com.ralph.Map;

import java.util.Objects;

public class OPPO implements Comparable{
    private String name;
    private int price;

    public OPPO() {
    }

    public OPPO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OPPO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OPPO oppo = (OPPO) o;

        if (price != oppo.price) return false;
        return name.equals(oppo.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof OPPO){
            OPPO oppo = (OPPO)o;
            int compare = -this.name.compareTo(oppo.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.price,oppo.price);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");

        }
    }
}
