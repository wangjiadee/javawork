###### java反射机制概述

```
通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
直接new的方式 反射的特征：动态性
```

```
反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
不矛盾 看怎么约束 考虑代码风格问题
```

```
关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令（编译命令）以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
    来获取此运行时类。
```



#### **获取Class实例**

```java
        //方式一：调用运行时类的属性：.class
        Class clazz = Person.class;
        System.out.println(clazz);
        //方式二：通过运行时类的对象,调用getClass()
        Person person = new Person();
        Class clazz2 = person.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath) 开发中用的最多
        Class clazz3 = Class.forName("com.ralph.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);
```



###### 类的加载和ClassLoader的理解

```java
        Properties pros =  new Properties();

        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
        FileInputStream fileInputStream = new FileInputStream("jdb.properties");
        //在src中
        FileInputStream fileInputStream = new FileInputStream("src\\jdb.properties");
        pros.load(fileInputStream);

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdb.properties");
        pros.load(is);

        String user = pros.getProperty("Username");
        String password = pros.getProperty("Password");
        System.out.println("user = " + user + ",password = " + password);
```



#### **创建运行时类的对象**

```java
/*
newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。

要想此方法正常的创建运行时类的对象，要求：
1.运行时类必须提供空参的构造器
2.空参的构造器的访问权限得够。通常，设置为public。


在javabean中要求提供一个public的空参构造器。原因：
1.便于通过反射，创建运行时类的对象
2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

 */
 
     public void NewInstanceT() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
```

反射的动态性

```java
@Test
    public void test5() {

        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.ralph.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
        /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception{
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
```



###### 获取运行时类的完整结构

```java
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field f:fields){
            System.out.println(f);
            
            
        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
            
            
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers); // 2 0 1
            System.out.println(Modifier.toString(modifiers));//显示出数字

            //2.数据类型
            Class type = f.getType();
            System.out.println(type.getName() + "\t");

            //3.变量名
            String fname = f.getName();
            System.out.println(fname);

            
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = personClass1.getMethods();
        for (Method m : methods){
            System.out.println(m);   
            
            
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = personClass1.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
            
            
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for(Annotation a : annos){
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0;i < parameterTypes.length;i++){

                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }

            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }


            System.out.println();
            
            
            
            
    /*
    获取构造器结构

     */
    @Test
    public void test1(){

        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }

    }

    /*
    获取运行时类的父类

     */
    @Test
    public void test2(){
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
    获取运行时类的带泛型的父类

     */
    @Test
    public void test3(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
    获取运行时类的带泛型的父类的泛型


    代码：逻辑性代码  vs 功能性代码
     */
    @Test
    public void test4(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }

    }
    /*
        获取运行时类所在的包

     */
    @Test
    public void test6(){
        Class clazz = Person.class;

        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
        获取运行时类声明的注解

     */
    @Test
    public void test7(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }
            
            
   
   
```



#### **调用运行时类的指定结构**

```java
    @Test
    public void RunGetAttributes() throws Exception{
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person person = (Person) personClass.newInstance();

        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);

        //3.获取、设置指定对象的此属性值
        name.set(person,"MDZA");

        System.out.println(name.get(person));

    }


    @Test
    public void RunGetMethod() throws Exception{
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = (Person) personClass.newInstance();
        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
         */
        Method show = personClass.getDeclaredMethod("show", String.class);
        //2.保证当前方法是可访问的
        show.setAccessible(true);
        /*
        3. 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object usa = show.invoke(person, "USA");
        System.out.println(usa);

        System.out.println("*************如何调用静态方法*****************");
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        //如果调用的运行时类中的方法没有返回值，则此invoke()返回null
//        Object returnVal = showDesc.invoke(null);
        Object returnval = showDesc.invoke(Person.class);
        System.out.println(returnval);

    }
```





https://blog.csdn.net/ju_362204801/article/details/90578678









```
1.描述一下JVM加载class文件的原理机制?
答：JVM中类的装载是由ClassLoader和它的子类来实现的,Java ClassLoader 是一个重要的Java运行时系统组件。它负责在运行时查找和装入类文件的类。
```

```

```



```java
1)创建Student类，类中有属性name和age并封装属性
2)重载Student的构造函数，一个是无参构造并，另一个是带两个参数的有参构造，要求在构造函数打印提示信息 
3)创建带main函数的NewInstanceTest类，利用Class类得到Student对象
4)通过上述获取的Class对象分别调用Student有参函数和无参函数

/////////////////////////Student.java：////////////////////////////////////////////////////////
public class Student {
    private String name;
    private int age;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private void show(){
        System.out.println("[Fucking u,student ] :" );
    }
    private String display(String nation){
        System.out.println(" My nation：" + nation);
        return nation;
    }
}
///////////////////////////////////NewInstanceTest.java/////////////////////////////////////
public class NewInstanceTest {
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;

        Student student = (Student) studentClass.newInstance();

        //Call no-argument function
        Method show = studentClass.getDeclaredMethod("show");
        show.setAccessible(true);
        Object returnVal = show.invoke(student);
        System.out.println(returnVal);  // [Fucking u,student ] :  null

        //Call argument function
        Method display = studentClass.getDeclaredMethod("display",String.class);
        display.setAccessible(true);
        Object returnVal1 = display.invoke(student,"CHN");
        System.out.println(returnVal1);  // My nation：CHN CHN
    }
}
```



```java
1)创建Mytxt类，创建myCreate()方法完成创建文件D:\myhello.txt文件的功能。创建带main方法的NewInstanceTest类1，通过Class类获取Mytxt对象，调用myCreat()
///////////////////////////////////////Mytxt.java/////////////////////////////////////////////
public void myCreate() throws IOException {
        File file = new File("./myhello.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("Create File success!");
        }
    }

///////////////////////////////////NewInstanceTest1///////////////////////////////////////////
public class NewInstanceTest1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Mytxt> mytxtClass = Mytxt.class;
        Mytxt mytxt = (Mytxt) mytxtClass.newInstance();

        Method myCreate = mytxtClass.getDeclaredMethod("myCreate");
        myCreate.setAccessible(true);
        Object returnVal = myCreate.invoke(mytxt,null);
        System.out.println(returnVal);
    }
}
```





```java
1)自定义一个有效的Annotation注释名为MyAnnotation，其中有属性myname创建Student类并重写toString()，toString()要求使用三自定义的MyAnnotation注释 
2)创建TestGetAnno类，打印出Student类的toString方法的注释

/////////////////////////////////////MyAnnotation/////////////////////////////////////////////
        Class studentClass = Student.class;
        Method[] declaredMethod = studentClass.getDeclaredMethods();
        for(Method m : declaredMethod){
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }
        }

/////////////////////////////////////Student/////////////////////////////////////////////

    @MyAnnotation(myname = "toNY")
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

/////////////////////////////////////TestGetAnno////////////////////////////////////////////

        Class studentClass = Student.class;
        Method[] declaredMethod = studentClass.getDeclaredMethods();
        for(Method m : declaredMethod){
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations){
                System.out.println(a);
            }
        }
```



```java
利用Class类的forName方法得到File类
在控制台打印File类的所有构造器
通过newInstance的方法创建File对象，并创建D：\mynew.txt文件


	public void Test1() throws Exception{
        //利用Class类的forName方法得到File类
        Class aClass = Class.forName("java.io.File");

        //在控制台打印File类的所有构造器
        Constructor[] declaredConstructor = aClass.getDeclaredConstructors();
        for(Constructor con : declaredConstructor) System.out.println(con);

        //获取File的一个构造器
        Constructor constructor = aClass.getConstructor(String.class);
        //用上面得到构造器创建File对象
        Object instance = constructor.newInstance("./mynew.txt");

        //获取File的createNewFile方法
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(instance);


```

```java
1.定义PrivateTest类，有私有name属性，并且属性值为hellokitty，只提供name的getName的公有方法
2.创建带有main方法ReflectTest的类，利用Class类得到私有的name属性
3.修改私有的name属性值，并调用getName()的方法打印name属性值

/////////////////////////////////////PrivateTest////////////////////////////////////////////
public class PrivateTest {
    private String name = "FuckingWork";

    public String getName() {
        return name;
    }

    public PrivateTest() {
    }

    public PrivateTest(String name) {
        this.name = name;
    }
}


/////////////////////////////////////ReflectTest////////////////////////////////////////////

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class privateTestClass = PrivateTest.class;
        PrivateTest pt = (PrivateTest) privateTestClass.newInstance();

        Field[] declaredFields = privateTestClass.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);

            String fName = f.getName();
            System.out.print(fName);
        }

        System.out.println();
        Method getName = privateTestClass.getDeclaredMethod("getName");
        getName.setAccessible(true);

        Object value = getName.invoke(pt);
        System.out.println(value);

    }
}
```

