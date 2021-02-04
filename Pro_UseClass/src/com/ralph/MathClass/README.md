#### Math类

java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回 值类型一般为double型。 

```
abs     绝对值 
acos,asin,atan,cos,sin,tan  三角函数 
sqrt     平方根 
pow(double a,doble b)     a的b次幂 
log    自然对数 exp    
e为底指数
max(double a,double b) 
min(double a,double b) 
random()      返回0.0到1.0的随机数 
long round(double a)     double型数据a转换为long型（四舍五入） 
toDegrees(double angrad)     弧度—>角度 
toRadians(double angdeg)     角度—>弧度

```

Exer

```
Q:Math.round(11.5)等于多少? Math.round(-11.5)等于多少
A： 12和11  round方法返回与参数最接近的长整数<上升>
```



####  BigInteger类

1. Integer类作为int的包装类，能存储的最大整型值为231-1，Long类也是有限的， 最大为263-1。如果要表示再大的整数，不管是基本数据类型还是他们的包装类 都无能为力，更不用说进行运算了。

2. `java.math包的BigInteger可以表示不可变的任意精度的整数`。BigInteger 提供 所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。 另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、 位操作以及一些其他操作。

3. 构造器: BigInteger(String val)：根据字符串构建BigInteger对象

- public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。 
- BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger 
- BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger 
- BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger 
- BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数 相除只保留整数部分。 
- BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。 
- BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟 (this % val) 的两个 BigInteger 的数组。 
- BigInteger pow(int exponent) ：返回其值为 (thisexponent) 的 BigInteger。

####  BigDecimal类

1.一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中， `要求数字精度比较高，故用到java.math.BigDecimal类`。

2.BigDecimal类支持不可变的、任意精度的有符号十进制定点数。

3.构造器 

- ​	public BigDecimal(double val) 
- ​     public BigDecimal(String val)

常用方法 

- public BigDecimal add(BigDecimal augend) 
- public BigDecimal subtract(BigDecimal subtrahend) 
- public BigDecimal multiply(BigDecimal multiplicand) 
- public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)

```java
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//         System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP)); //25表示精确到小数点后第25位置
```

