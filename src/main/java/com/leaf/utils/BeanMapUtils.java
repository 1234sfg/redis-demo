package com.leaf.utils;

import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

public class BeanMapUtils {
    /**
     * 将对象转化为Map集合
     */
    public static <T> Map<String,Object> beanToMap(T bean){
        Map<String,Object> map=new HashMap<>();
        if (bean!=null){
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key:beanMap.keySet()){
                map.put(key+"",beanMap.get(key));
            }
        }
        return map;
    }
    /**
     *将Map集合转化为对象
     */
    public static <T> T mapToBean(Map<String,Object> map,Class<T> clazz) throws Exception{
        T bean =clazz.newInstance();
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
