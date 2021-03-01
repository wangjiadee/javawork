```java
    /**
     * Description:开发一个泛型Apple类，要求有一个重量属性weight在测试类中实例化不同的泛型对象，要求对象a1的这一属性是String类型，
     * 对象a2的这一属性是Integer型，a3的这一属性是Double型。
     * 分别为a1，a2，a3的重量属性赋值为：”900克”，900,900.0，在测试类中通过对象调用访问器得到属性值并输出。
     * 另外思考，为什么a2和a3的属性需要是Integer和Double而不是int和double？

     * return
     * Author:     ralph
     **/
    @Test
    public void Test2(){
        Apple<String> a1 = new Apple<>("900克");
        Apple<Integer> a2 = new Apple<>(900);
        Apple<Double> a3 = new Apple<>(900.0);
        System.out.println(a1.getWeight());
        System.out.println(a2.getWeight());
        System.out.println(a3.getWeight());
    }

    
}

class Apple<RAL>{
    private RAL weight;

    public RAL getWeight() {
        return weight;
    }

    public void setWeight(RAL weight) {
        this.weight = weight;
    }

    public Apple(RAL weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}

```



***自己定义一个泛型接口，其中有一个eat方法。用一个Person类实现这个接口，传入的泛型实参是String类型，实现的方法内容自己定义，最后在main中调用eat方法。***

```java
    @Test
    public void Test3(){
        Demo<String> demo = new Person();
        String str = demo.eat("吃饭");
        System.out.println(str);
    }

}


interface Demo<T>{
    public T eat(T t);
}

class Person implements Demo<String>{
    @Override
    public String eat(String s){
        return s;
    }
}
```