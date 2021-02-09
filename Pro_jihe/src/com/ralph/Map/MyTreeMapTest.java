package com.ralph.Map;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MyTreeMapTest {

    @Test
    public void Test1(){
        TreeMap map = new TreeMap();
        OPPO o1 = new OPPO("A1",1899);
        OPPO o2 = new OPPO("F2",5899);
        OPPO o3 = new OPPO("R1",6899);
        OPPO o4 = new OPPO("E4",899);

        map.put(o1,1);
        map.put(o2,2);
        map.put(o3,3);
        map.put(o4,4);


        Iterator i1 = map.entrySet().iterator();
        while (i1.hasNext()){
            Object obj = i1.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }


    @Test
    public void Test2(){
        TreeMap m = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  OPPO && o2 instanceof OPPO) {
                    OPPO oppo1 = (OPPO) o1;
                    OPPO oppo2 = (OPPO) o2;
                    return Integer.compare(oppo1.getPrice(), oppo2.getPrice());
                }
                throw new RuntimeException("你看看你输入的都是啥");
            }
        });
    OPPO OP1 = new OPPO("f1",12333);
    OPPO OP2 = new OPPO("r5",544);
    OPPO OP3 = new OPPO("a11",3343);
    OPPO OP4 = new OPPO("e9",13);

    m.put(OP1,1);
    m.put(OP2,2);
    m.put(OP3,3);
    m.put(OP4,4);

    Iterator i1 =  m.entrySet().iterator();
    while (i1.hasNext()){
        Object obj = i1.next();
        Map.Entry entry = (Map.Entry) obj;
        System.out.println(entry.getKey() + "===" + entry.getValue());
    }

    }
}
