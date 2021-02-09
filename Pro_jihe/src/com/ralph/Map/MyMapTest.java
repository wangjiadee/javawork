package com.ralph.Map;

import org.junit.Test;

import java.util.*;

public class MyMapTest {

    @Test
    public void MapTest(){
        //Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        HashMap hashMap = new HashMap();

        hashMap.put("A",123);
        hashMap.put(null,123);
        System.out.println(hashMap);

        HashMap hashMap2 = new HashMap();
        hashMap2.put("c",123);
        hashMap2.put("S",133);
        hashMap.putAll(hashMap2);
        System.out.println(hashMap);

        // Object remove(Object key)：移除指定key的key-value对，并返回value
        System.out.println(hashMap.remove("A"));
        System.out.println(hashMap);

        hashMap2.clear();
        System.out.println(hashMap2);

        hashMap.get("c");
        System.out.println(hashMap.get("c"));

        System.out.println(hashMap.size());
    }

    @Test
    public void Test2(){
        HashMap hashMap3 = new HashMap();
        hashMap3.put("A",321);
        hashMap3.put("b",321);
        hashMap3.put("K",321);
//遍历所有的key集：keySet()
        Set map = hashMap3.keySet();
        Iterator iterator = map.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
//遍历所有的value集：values()
        Collection values = hashMap3.values();
            for (Object obj  : values){
                System.out.println(obj);
            }
//        Set entrySet = hashMap3.entrySet();
        Iterator iterator2 = hashMap3.entrySet().iterator();
        while (iterator2.hasNext()){
            Object obj = iterator2.next();
            Map.Entry n =(Map.Entry)obj;
            System.out.println(n.getKey() +"----"+ n.getValue());
        }


    }


}

