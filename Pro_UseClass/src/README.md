#### String的特性

-  String类：代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作 为此类的实例实现
- String是一个final类，代表不可变的字符序列
- 字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改。
-  String对象的字符内容是存储在一个字符数组value[]中的。 



```java
String str1  = “abc”  与   String str2 = new String(“abc”) 的区别
1.字符串常量存储在字符串常量池，目的是共享
2.字符串非常量对象存储在堆中。
```

![image-20210201141931127](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210201141931127.png)



String 和 new String具体解析：

1.String 定义在方法区的常量池里面  new 是定义在堆中的一个内存地址里面value 然后再指向常量池中

```java
        String s11 = "javaEE";
        String s22 = "javaEE";
        String s33 = new String("javaEE");
        String s44 = new String("javaEE");

        System.out.println(s11 == s22);//true
         System.out.println(s11 == s33);//false  一个在堆中 一个在常量池中
         System.out.println(s11 == s44);//false  一个在堆中 一个在常量池中
         System.out.println(s33 == s44);//false  两个都在堆中 但是内存地址不一样
```

![image-20210201142741294](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210201142741294.png)



String 和 new String+ equals 和 == 具体解析：

```
        Person p1 = new Person();
        p1.name = "Tom";
        Person p2 = new Person();
        p2.name = "Tom";
        System.out.println(p1.name .equals( p2.name)); // true
        System.out.println(p1.name == p2.name); // true
        System.out.println(p1.name == "Tom"); //true
        String s10 = new String("bcde");
        String s20 = new String("bcde");
        System.out.println(s10==s20); // false 堆当中的是否相等
```

![image-20210201150158666](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210201150158666.png)

```java
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");

        System.out.println(a.equals(b)); //T
        System.out.println(a == b);      //T
        System.out.println(c.equals(d)); //T
        System.out.println(c == d);      //F 引用数据类型 没有执行同一个实体
        System.out.println(a.equals(c)); //T
        System.out.println(a == c);      //F
```





```
面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
       两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"
```



#### 字符串的特性@

- 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。 
- 只要其中有一个是变量，结果就在堆中 
-  如果拼接的结果调用intern()方法，返回值就在常量池中

```java
        String s1 = "hello"; // 在常量池中创建了一个hello
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world"; //在堆空间中创建了新的字符 原来的s1已经在常量池中
        String s5 = s1 + s2;
        String s6 = (s1 + s2).intern();

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);
        System.out.println(s3 == s6);
```

![image-20210201151402739](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210201151402739.png)



Exer：

```java

   public void Test5(){
        String s = "0";
        for (int i =1;i<=5;i++){
            s += i;
        }
        System.out.println(s);
    }
    
        public void Test6(){
        String s1 = new String("1");
        for (int i =1;i<=5;i++){
            s1 += i;
        }
        System.out.println(s1);
    }
```

Exer图解：

<img src="C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210201163850813.png" alt="image-20210201163850813" style="zoom: 67%;" />

<img src="C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210201163822439.png" alt="image-20210201163822439" style="zoom:67%;" />

Exer2：

- 基本数据类型 ：传递的是存储的数据
- 引用数据类型：传递的是地址值

```java
public class StringTest1 {
    String str = new String("good");  //str创建在方法区中的常量池中 固定不变
    char[] ch = {'t', 'e', 's', 't'}; //创建在了堆中

    public void change(String str, char ch[]) { //指向了一个内存地址
        str = "test ok";  //不变
        ch[0] = 'b';      //变
    }

    public static void main(String[] args) {
        StringTest1 ex = new StringTest1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch); 
		//good and best
    }
}
```

#### string中常用的方法

```java
    public void Test1(){
        String s1 = "Fucking";
        String s2 = "   F U C K      ";
        String s3 = "dev";
        String s4 = "uck";
        System.out.println("int length()：返回字符串的长度： return value.length ");
        System.out.println(s1.length());
        //char charAt(int index)： 返回某索引处的字符return value[index]
        System.out.println(s1.charAt(5));
        //boolean isEmpty()：判断是否是空字符串：return value.length == 0
        System.out.println(s1.isEmpty());
        //String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
        System.out.println(s1.toLowerCase(Locale.ROOT));
        //String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
        System.out.println(s1.toUpperCase(Locale.ROOT));
        //String trim()：返回字符串的副本，忽略前导空白和尾部空白
        System.out.println(s2.trim());
        //boolean equals(Object obj)：比较字符串的内容是否相同
        System.out.println(s1.equals(s2));
        //boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        //String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
        System.out.println(s1.concat(s3));
        //int compareTo(String anotherString)：比较两个字符串的大小
        System.out.println(s1.compareTo(s3));
        //String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        System.out.println(s1.substring(3));
        //String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
        System.out.println(s1.substring(0,4));

        //boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        System.out.println(s1.endsWith("g"));

        System.out.println("-------------------boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始");
        System.out.println(s1.startsWith("F"));

        System.out.println("-------------------boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始");
        System.out.println(s1.startsWith("c",2));

        System.out.println("-------------------boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true");
        System.out.println(s1.contains(s4));

        System.out.println("-------------------int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引");
        System.out.println(s1.indexOf("u"));

        System.out.println("-------------------int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始");
        System.out.println(s1.indexOf("g",4));


        String s5 = "shcinsdfoo";
        System.out.println("-------------------int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引");
        System.out.println(s5.lastIndexOf("in"));


        System.out.println("-------------------int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索");
        System.out.println(s5.lastIndexOf("in",2));
        //注：indexOf和lastIndexOf方法如果未找到都是返回-1
    }
```



#### indexOf(str)和lastIndexOf(str)返回值相同？

```
情况一：存在唯一的一个str   
情况二：不存在str
```



#### String和基本数据类型转换

- 字符串 --> 基本数据类型、包装类 

```java
//String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
        String str1 = "1234";
        int ChangeStrNum = Integer.parseInt(str1);
        System.out.println(ChangeStrNum);

```

- 基本数据类型、包装类  --> 字符串

```java
//基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
	String str2 = String.valueOf(ChangeStrNum);
```

- 字符数组 --> 字符串

```java
//char[] --> String:调用String的构造器
		char[] arr = new char[]{'F','u','c','K'};
        String s2 = new String(arr);
        System.out.println(s2);
```

- 字符串 --> 字符数组 

```java
//String --> char[]:调用String的toCharArray()
		String s1 = "Fucking live";

        char[] CharArray = s1.toCharArray();
        for (int i = 0; i < CharArray.length; i++) {
            System.out.println(CharArray[i]);
        }
```

- 字节数组 --> 字符串

```java
//解码：byte[] --> String:调用String的构造器
        String str2 =new String(bytes);
        System.out.println(str2);

```

- 字符串 --> 字节数组 

```java
//编码：String --> byte[]:调用String的getBytes()
		String str1 = "abc123尼玛zz";
        byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
        System.out.println(bytes);
```

#### Exer

```java
//模拟一个String字符串的trim方法，去除字符串两端的空格。
public class StringExer {
    public static void main(String[] args) {

        String str1 = "  12312312  ";
        System.out.println(MyTrim(str1));

    }

    public static String MyTrim(String str){
        if (str != null) {
            int start = 0;// 用于记录从前往后首次索引位置不是空格的位置的索引
            int end = str.length() - 1;// 用于记录从后往前首次索引位置不是空格的位置的索引

            while (start < end && str.charAt(start) == ' ') {
                start++;
            }

            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }

            return str.substring(start, end + 1);
        }
        return null;

    }
}

///////////////////////////////////////方法二/////////////////////////////////////////////////
public static String myTrim(String str){
	int start = 0;
	int end = str.length() - 1;
	while(start < end && str.charAt(start) == ' '){
		start++;
	}
	while(start < end && str.charAt(end) == ' '){
		end--;
	}
	if(start == end){
		return "";
	}
	return str.substring(start, end + 1);
}
```



```java
//将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
String Str1 = “abcdefg”;

//直接定义成StringBuffer格式，调用StringBuffer里面的reverse方法倒置字符串

StringBuffer Str2=new StringBuffer(Str1.substring(2, 6));
```



```java
 //获取一个字符串在另一个字符串中出现的次数。 比如：获取“ab”在“abkkcadkabkebfkabkskab” 中出现的次数
 		String S1 = "abkkcadkabkebfkabkskab";
        String S2=S1.replace("ab","");
        System.out.println(S2);
        System.out.println("ab出现的次数为："+(S1.length()-S2.length())/2);

```

#### String、StringBuffer、StringBuilder三者的异同？三个效率问题

```
String:不可变的字符序列；底层使用char[]存储
StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储

效率从高到低：
StringBuilder > StringBuffer >String
```



#### StringBuffer 和StringBuilder

StringBuffer类不同于String

```
1.其对象必须使用构造器生成。有三个构造器： 
StringBuffer()：初始容量为16的字符串缓冲区 
StringBuffer(int size)：构造指定容量的字符串缓冲区 
StringBuffer(String str)：将内容初始化为指定字符串内容
```

StringBuffer常用的方法

- StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接 

  ```java
          StringBuffer s1 = new StringBuffer("abc");
          s1.append(1);
          s1.append('1');
          System.out.println(s1);
  ```

- StringBuffer delete(int start,int end)：删除指定位置的内容 

  ```java
  s1.delete(2,4);
  ```

  

- StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str 

  ```java
  s1.replace(2,4,"hello");
  ```

- StringBuffer insert(int offset, xxx)：在指定位置插入xxx StringBuffer reverse() ：把当前字符序列逆转

  ```java
  s1.insert(2,false);
  ```

- 当append和insert时，如果原来value数组长度不够，可扩容 ，以上方法都可以支持方法链的操作

StringBuilder常用的方法

- public int indexOf(String str)
- public String substring(int start,int end) 
- public int length()
- public char charAt(int n ) 
- public void setCharAt(int n ,char ch)

#### 面试题

```java
        String str = null;
        System.out.println(str);  //null
        StringBuffer sb = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。
        sb.append(str);//将null 添加到了char[]里面

        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1 =new StringBuffer(str); //真实的把空指针加到了数字里面 
        System.out.println(sb1);//java.lang.NullPointerException 空指针报错
```



Exer：

```java
        String str1 = "尚硅谷";
        String str2 = "尚硅谷";
        String str3 = new String("尚硅谷");
        System.out.println(str1 == str2);// 都是再常量池中的同一个对象 true
        System.out.println(str1 == str3);// 一个是再常量池的对象 一个是堆中的字符串对象 false
        System.out.println(str1.equals(str3));//String重写后的equals表示对象的具体值是否一样 true
        str1 = "尚硅谷atguigu.com"; //上面有一个Str1 现在这里就是堆赋予的了
        String str4 = "atguigu.com";
        String str5 = "尚硅谷" + "atguigu.com"; // 有+号 都是再堆里面
        System.out.println(str1 == str5);//true 两个都是再堆里面的对象

        String str6 = (str2 + str4).intern();
        System.out.println(str1 == str6);//拼接调用intern()方法，返回值就在常量池中 false  ---->true
```

```
Q：是否可以继承String类
A：String类是final类故不可以继承
```

```
Q:String与StringBuffer的区别
A：String被定义成final类型不可变 StringBuffer的长度是可变的，如果需要经常操作需改的内容使用StringBuffer
```

```
Q：String str = new String(“hello”);创建了哪些对象？
A：字符串常量池中有一个对象，堆中有一个字符串对象。
```

```
Q:用运算符“==”比较字符串对象时，只要两个字符串包含的是同一个值，结果便为true?
A:不是， ==比较字符串对象，实际上是比较并确定他们是否为内存中的同一个对象
```

```
Q：String 类字符串在创建后可以被修改
A：放屁，被定义了final 怎么修改？
```

```
方法 replace (String srt1, String srt2)将当前字符串中所有 srt1 子串换成 srt2子串
方法compareTo在所比较的字符串相等时返回 0。
```

```
1.下面哪个选项正确地声明了一个字符串数组：C
A char str[] 
B char str[][]
C String str[] 
D String str[10]

C 声明数组时，不允许在数组名后面的括号内指定数组元素的个数。
```

```
2. 请看下面的程序段：
public class class1{ 
    public static void main(String a[]) {
        int x [] = new int[8]; 
        System .out .println(x [1]); 
} } 
当编译和执行这段代码时会出现： D
A 有一个编译错误为“possible reference before assignment” 
B 有一个编译错误为“illegal array declaration syntax” 
C 有异常出现为“Null Pointer Exception”
D 正确执行并且输出 0 
```

```
3．已知 String 对象 s="abcdefg"，则s.substring(2, 5)的返回值为__B__。 //顾头不顾尾
A "bcde"  
B "cde" 
C "cdef"
D "def" 
```

```
4.请看下面的代码 String s = “people”; String t = “people”; String c[ ] = {“p”,”e”,”o”,”p”,”l” ,”e”}; 
下面哪一选项的语句返回值为真：
A s .equals(t);  //对比值是否相等
B t .equals(c);  //值不相同 
C s==t;          //指向的对象是否相同 都是常量池中的
D t .equals(new String(“people”));  //值是否相同
```

```
5．已知 s 为一个 String 对象，s="abcdefg"，则s.charAt(1)的返回值为__b__。 步长从0开始
A a 
B b 
C f b
D g 
```

```
6.请看下面的代码 String s = “good”; 下面选项语句书写正确的是： AD
A s += “student”; 
B char c = s[1]; 
C intlen = s .length; 
D String t = s.toLowerCase( ); 
```

```
7.正确创建一个含有 5 个元素的字符串数组的选项是： AB
A String s[ ] = new String[5]; for(int i=0;i<5;s[i++]=“”); 
B String s[ ]={“”, “”, “”, “”, “”}; 
C String s[5];
D String [5]s; 
```

```
8.请看下面的代码
public class class1{ 
	String str = new String("Girl"); 
	charch[ ]={'d','b','c'}; 
	public static void main(String args[ ]){
        class1 x=new class1( );
        x.change(x.str,x.ch);
        System .out .println(x.str +" and "+x.ch[0]+x.ch[1]+x.ch[2]); 
} 
public void change(String str,charch[ ]){
    str="Boy"; ch[0]='a'; 
} }
该程序的输出结果是： D
A Boy and dbc
B Boy and abc 
C Girl and dbc 
D Girl and abc
```

```
如何将String类型转化Number类型？举例说明String str = “123”;
答任意一个都对：
		Integer num1 = new Integer(str);
		或
		int num2 = Integer.parseInt(str);
		或
		Integer num3 = Integer.valueOf(str);
```

```
1．已知sb为StringBuffer的一个实例，且sb= "abcde "，则sB reverse()后sb的值为__edcba__。
2．已知sb为StringBuffer的一个实例，且sb= "abcde "，则sB delete(1,2)后sb的值为 __acde__。
```

```java
/*实现如下功能：接受命令行中给出的一个字母串，先将该串原样输出，然后判断该串的第一个字母是否为大写，若是大写则统计该串中大写字母的个数，并将所有大写字母输出；否则输出信息串”第一个字母不是大写字母!”*/

public class AllTest {

    public static void main(String[] args) {
        System.out.println("随便输入点东西吧");
        Scanner UserInput = new Scanner(System.in);
        String s = UserInput.nextLine();
        if (s.length() != 0){
            System.out.println(s);
            char X = s.charAt(0);
            if (X >= 65 && X<=90){ //换成字符用ASCII码来确定
                int n = 0;
                char[] Arr = s.toCharArray();//字符串换数组
                for(int i = 0;i<=s.length()-1;i++){//防止数组越界
                    if (Arr[i] >= 'A' && Arr[i] <= 'Z'){
                        System.out.println("[Input ]: " + Arr[i]);
                        n++;
                    }
                }
                System.out.println("[Input ]: " + n);

            }else {
                System.out.println("[Error] : 首字母非大写ZZ");
            }

        }else {
            System.out.println("[Error] : 什么都不输入吗？ZZ");
        }
    }
```



```java
//一个应用程序，接受用户输入的一行字符串，统计字符个数，然后反序输出。
        System.out.println("随便输入点东西吧");
        Scanner UserInput = new Scanner(System.in);
        String s = UserInput.nextLine();
        if (s.length() != 0){
            System.out.println(s.length());
            int j = s.length();
            for (int i = j-1 ;i >= 0;i--){
                System.out.println(s.charAt(i));
            }
        }else {
            System.out.println("[Error] : 什么都不输入吗？ZZ");
        }
    }
```

```java
//创建BigDecimalDemo类，在类中分别定义add(),sub(),mul()和div()方法实现加、减、乘、除运算，并输出运算结果。要求除法，可以处理商的精度。
static final int location = 10;

    public static BigDecimal add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2);
    }

    public static BigDecimal sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double value1, double value2) {
        return div(value1, value2, location);
    }

    public static BigDecimal div(double value1, double value2, int b) {
        if (b < 0) {
            System.out.println("b值必须大于等于0");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.divide(b2, b, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        StringExer3 b=new StringExer3();
        System.out.println("两个数字相加结果："+b.add(-7.5, 8.9));
        System.out.println("两个数字相减结果："+b.sub(-7.5, 8.9));
        System.out.println("两个数字相乘结果："+b.mul(-7.5, 8.9));
        System.out.println("两个数字相除结果，结果小数后保留10位："+b.div(10, 2));
        System.out.println("两个数字相除，结果保留小数后5位："+b.div(-7.5, 8.9,5));
    }

```

```java
编写一个Java应用程序，从键盘读取用户输入两个字符串，并重载3个函数分别实现这两个字符串的拼接、整数相加和浮点数相加。要进行异常处理，对输入的不符合要求的字符串提示给用户，不能使程序崩溃。
只能输入数字型的字符串，如果含字母会报错，需要用到正则表达式。这里没有体现。
    
import java.io.*;
public class StringExer4{
    public static void main(String args[]) {
        String s1=null,s2=null,ss=null,si=null,sf=null;
        int i1=0,i2=0;
        float f1=0.0f,f2=0.0f;
        
        BufferedReader strin= new  BufferedReader(new InputStreamReader(System.in));
        try{System.out.print ("输入第一个字符串：" );
            s1= strin.readLine();
            System.out.print ("输入第二个字符串：" );
            s2= strin.readLine();
        }catch(Exception e){ System.out.println(e.getMessage());}
        i1 = Integer.parseInt(s1);
        i2 = Integer.parseInt(s2);
        f1 = Float.parseFloat(s1);
        f2 = Float.parseFloat(s2);
        ss = strAdd(s1,s2);
        si = strAdd(i1,i2);
        sf = strAdd(f1,f2);
        System.out.println ("输入的二个字符串相加结果为："+ss );
        System.out.println ("输入字符串转换为整数相加结果为："+si );
        System.out.println ("输入字符串转换为浮点数相加结果为："+sf );
    }
    static String strAdd(String str1,String str2) {
        return str1+str2;
    }
    static String strAdd(int int1,int int2) {
        return  String.valueOf(int1+int2);
    }
    static String strAdd(float flt1,float flt2) {
        return  String.valueOf (flt1+flt2);
    }
}
```

```java
//获取一个字符串在另一个字符串中出现的次数。判断str2在str1中出现的次数

public static int getTime(String str1,String str2){
	int count = 0;
	int len;
	while((len = str1.indexOf(str2)) != -1){
		count++;
		str1 = str1.substring(len + str2.length());
	}
	
	return count;
}
```

```java
//获取两个字符串中最大相同子串。
public static List<String> getMaxSubString(String str1,String str2){
	String maxStr = (str1.length() > str2.length())? str1 : str2;
	String minStr = (str1.length() < str2.length())? str1 : str2;
	int len = minStr.length();
	List<String> list = new ArrayList<>();
	for(int i = 0;i < len;i++){
		for(int x = 0,y = len - i;y <= len;x++,y++){
			String str = minStr.substring(x, y);
			if(maxStr.contains(str)){
				list.add(str);
			}
		}
		if(list.size() != 0){
			return list;
		}
	}
	return null;
}
```

```java
//对字符串中字符进行自然顺序排序
public static String sort(String str){
	char[] c = str.toCharArray();
	Arrays.sort(c);
	return new String(c);
}
```



```java
//中国有句俗语叫“三天打鱼两天晒网”。如果从1990年1月1日起开始执行“三天打鱼两天晒网”。如何判断在以后的某一天中是“打鱼”还是“晒网”？
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFish {

	public static void main(String[] args) {
		String date1 = "1990/1/1"; // 开始“三天打鱼两天晒网”的日期
		String date2 = "1990/1/10"; // 手动输入的日期
		long day = getQuot(date1, date2);// 传入值计算时间差
		if (day % 5 == 0 || day % 5 == 4) {
			System.out.println("今天是休息日，可以晒晒网");
		} else {
			System.out.println("今天要工作，打鱼了！");
		}

	}

	public static long getQuot(String time1, String time2) {
		long dayDistance = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			dayDistance = date2.getTime() - date1.getTime();
			dayDistance = dayDistance / 1000 / 60 / 60 / 24 + 1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dayDistance;
	}

}
```

```
//输出字符串"ddejidsEFALDFfnef2357 3ed"里的大写字母数，小写英文字母数，非英文字母数

解题思路：
1.将字符串转换成数组  ---> toCharArray();
2.循环数组
3.通过ASCII码来判断
if(a[i]>='A'&&a[i]<='Z'){对应++}
else if(a[i]>='A'+32&&a[i]<='Z'+32){对应++}
else{对应++}
```

```java
//根据传入得路径，获取文件的类型名。例如：D:\myfile\hello.java取出.java
	   String str = "D:\\myfile\\hello.java";
        String strCh [] = str.split("[.]");
        String fileName = strCh[strCh.length-1];
        String file = ".";
        System.out.println(file.concat(fileName));
```

