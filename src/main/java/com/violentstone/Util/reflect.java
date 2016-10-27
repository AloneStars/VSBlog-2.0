package com.violentstone.Util;

import com.violentstone.entity.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/27 创造的作品
 * ********************************************************
 * +描述:通过反射 来获取对象的所有属性和方法
 *********************************************************/
public class Reflect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 根据属性名获取属性值
     * */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            //将属性名首字母取出来，并大写
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            //拼凑该属性的getter方法
            String getter = "get" + firstLetter + fieldName.substring(1);
            //获取到相应的getter方法
            Method method = o.getClass().getDeclaredMethod(getter, new Class[] {});
            //调用getter方法获取他的值
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 获取属性名数组
     * */
    private String[] getFiledName(Object o){
        //获取该对象所有的属性
        Field[] fields=o.getClass().getDeclaredFields();
        //新建一个字符串数组和属性数组等长
        String[] fieldNames=new String[fields.length];
        //利用循环将属性名称取出来放到数组中。
        for(int i=0;i<fields.length;i++){
            System.out.println("类别："+fields[i].getType()+" 属性名："+fields[i].getName());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * */
    private List getFiledsInfo(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        List list = new ArrayList();
        for(int i=0;i<fields.length;i++){
            Map infoMap = new HashMap();
            infoMap.put("type", fields[i].getType());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     **/
    public Object[] getArrayFiledValues(Object o){
        String[] fieldNames=this.getFiledName(o);
        Object[] value=new Object[fieldNames.length];
        for(int i=0;i<fieldNames.length;i++){
            value[i]=this.getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     **/
    public List getListFiledValues(Object o){
        List list = new ArrayList();
        String[] fieldNames=this.getFiledName(o);
        for(int i=0;i<fieldNames.length;i++){
            Map map = new HashMap();
            map.put("parameterName",fieldNames[i]);
            map.put("parameterName",this.getFieldValueByName(fieldNames[i], o));
            list.add(map);
        }
        return list;
    }



    public static void main(String[] args) {

        Reflect ref = new Reflect();

        Object[] objs = ref.getArrayFiledValues(new Blog());

        for (Object obj:objs) {

            System.out.println(obj);

        }
    }

}
