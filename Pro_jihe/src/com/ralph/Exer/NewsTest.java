package com.ralph.Exer;

import java.util.ArrayList;
import java.util.ListIterator;


/**
 *
 * 按要求实现下列问题：
 * 1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；（10分）
 *
 * 2)只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
 * 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
 * 新闻二：春节临近北京“卖房热”
 *
 * 3)将新闻对象添加到ArrayList集合中，并且使用ListIterator倒序遍历；
 *
 * 4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前14个，然后在后边加“…”
 *
 * 5)在控制台打印遍历出经过处理的新闻标题；*/
public class NewsTest {
    public static void main(String[] args) {
        News n1 = new News("新闻一","中国多地遭雾霾笼罩空气质量再成热议话题");
        News n2 = new News("新闻二","春节临近北京“卖房热”");

        ArrayList arrayList = new ArrayList();
        arrayList.add(n1);
        arrayList.add(n2);


        ListIterator<String> li = arrayList.listIterator();
        while (li.hasNext()){
            String s1 = String.valueOf(li.next());
        }
        while (li.hasPrevious()){
            String s2 = String.valueOf(li.previous());
            System.out.println(s2);
        }



    }



}
