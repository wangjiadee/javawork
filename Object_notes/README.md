#### 向下转型 和 向上转型

```
向下转型 就是多态的逆过程
父类强转子类 ----> 目的是使用子类中的属性
使用强转符号：()
    Man m =(Man)p
    
向上转型 就是多态

```

强转要注意的问题：
ClassCastException 的问题

解决方式：
instanceof 进行判断

```java
if(m instanceof Man){
	//m是变量名或者是对象 Man是类型
    //对象m是否是类Man的的实例
    //其中m 和Man要有点关系 子类或者父类
    Man m = (Man)p;
}
```

`如果a instanceof A 返回true 则a instanceof B也是返回true 其中B是A的父类`

#### == 和equals()的区别

`==: `

- 可以使用在基本数据类型和引用数据类型变量中
- 如可以比较的是基本数据类型：比较两个变量保存的数据是否相等（不一定是类型要相同）
- 如果是比较引用数据类型变量: 比较两个对象的地址值是否相同，即两个应用是否指向同一个对象实体
-  == 符号使用时，必须保持符号左右两边变量类型一致



`equals(): 对比对应的内存地址是否相同`

`重写后的equals(): 比较两个实体内容是否相同`

```java

class User{
	String name;
    int age;
    	public boolean equals(Object obj){
            if(obj = this){
                return true;
            }
            if (obj instanceof User){
                User u = (User)obj;
                return this.age == u.age && this.name.equals(u.name);
            }
            return false;
        }
}
```

### 多态性的理解：

```
实现代码的通用性
object类中定义equals的方法
JDBC 使用java程序操作数据库（链接各种类型的数据库）
抽象类和接口的使用
```

多态是运行式





#### toString()方法

```
   1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 
 * 2. Object类中toString()的定义：
 *   public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
 * 
 * 3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 *    使得在调用对象的toString()时，返回"实体内容"信息
 *    
 * 4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
```

重写tostring

```
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
```





#### 包装类

