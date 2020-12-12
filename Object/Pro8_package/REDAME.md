<!--
 * @Author: Ralph
 * @Type_file[python//GO//json//Yaml//Other]: [python//GO//json//Yaml//Other]
 * @Date: 2020-12-05 13:05:04
 * @LastEditTime: 2020-12-05 13:46:15
 * @FilePath: \javawork\Object\Pro8_package\REDAME.md
 * @Effect: DO
-->

package:
    为了更好的实现项目中类的管理，提供包的概念。
    声明在首行
    包属于标识符--小写
    “.”每点一次 就表示一层文件目录
    同一个包下，不能命名同文件接口、类，不同的包下可以命名同文件

java自带的包
    java.lang
    java.net
    java.io
    java.util
    java.test
    java.sql

import 表示导入

import 关键字的使用：
    XXX.* 表示导入所有
    java.lang 默认导入 可以省略

import static :导入指定类或接口中的静态结构
    