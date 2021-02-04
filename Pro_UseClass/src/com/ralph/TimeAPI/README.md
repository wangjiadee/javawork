#### JDK8之前日期时间API

![image-20210204093225268](C:\Users\80288284\AppData\Roaming\Typora\typora-user-images\image-20210204093225268.png)



1. java.lang.System类

   System类提供的public static long currentTimeMillis()用来返回当前时 间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。 

   ```java
       @Test
       public void test1(){
           long time = System.currentTimeMillis();
           //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
           //称为时间戳
           System.out.println(time);
       }
   ```

2.  java.util.Date类 (表示特定的瞬间，精确到毫秒 )具有可用2个构造器：

   构造器1：

   ```java
   //Date()：创建一个对应当前时间的Date对象
   Date date1 = new Date();
   //把此 Date 对象转换为以下形式的 String： dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)，zzz是时间标准。 
   System.out.println(date1.toString());
   // getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象 表示的毫秒数
   System.out.println(date1.getTime());
   ```

   构造器2：

   ```java
   //创建指定毫秒数的Date对象
   Date date2 = new Date(155030620410L);
   System.out.println(date2.toString());
   ```

3. java.sql.Date

```java
//如何实例化？ 
	   Date date6 = new Date();
       java.sql.Date date7 = new java.sql.Date(date6.getTime());
```

4.  java.text.SimpleDateFormat类

   4.1 SimpleDateFormat() ：默认的模式和语言环境创建对象 

   4.2 public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern 指定的格式创建一个对象，该对象调用： 

   4.3 public String format(Date date)：方法格式化时间对象date 

   4.4 public Date parse(String source)：从给定字符串的开始解析文本，以生成 一个日期。

```java
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2019-02-18 11:48:27
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);
```

```java
//Calendar日历类(抽象类）的使用
@Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
```



#### 新时间日期API

- **java.time – 包含值对象的基础包** 
- java.time.chrono – 提供对不同的日历系统的访问 
- **java.time.format – 格式化和解析时间和日期** 
- java.time.temporal – 包括底层框架和扩展特性 
- java.time.zone – 包含时区支持的类

```java
/**
1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
2.类似于Calendar
*/


//now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();  //2021-02-04
        LocalTime localTime = LocalTime.now();  //10:11:34.741
        LocalDateTime localDateTime = LocalDateTime.now();  //2021-02-04T10:11:34.768

//of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);  //2020-10-06T13:23:43

//getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth()); //4 日期
        System.out.println(localDateTime.getDayOfWeek());  //THURSDAY 星期
        System.out.println(localDateTime.getMonth());	   //FEBRUARY 月份	
        System.out.println(localDateTime.getMonthValue()); //2 月份
        System.out.println(localDateTime.getMinute());     //12 分


//体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);  //2021-02-04
        System.out.println(localDate1); //2021-02-22


        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
```

