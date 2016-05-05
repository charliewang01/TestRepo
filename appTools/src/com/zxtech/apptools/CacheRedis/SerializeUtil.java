package com.zxtech.apptools.CacheRedis;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SerializeUtil {
	 public static byte[] serialize(Object object) {
         ObjectOutputStream oos = null;
          ByteArrayOutputStream baos = null;
          try {
               // 序列化
              baos = new ByteArrayOutputStream();
              oos = new ObjectOutputStream(baos);
              oos.writeObject(object);
               byte[] bytes = baos.toByteArray();
               return bytes;
         } catch (Exception e) {

         }
          return null;
   }

    public static Object unserialize( byte[] bytes) {
         ByteArrayInputStream bais = null;
          try {
               // 反序列化
              bais = new ByteArrayInputStream(bytes);
              ObjectInputStream ois = new ObjectInputStream(bais);
               return ois.readObject();
         } catch (Exception e) {

         }
          return null;
   }
    
    public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null){    
            return null;    
        }   
        Map<String, Object> map = new HashMap<String, Object>();    
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            map.put(field.getName(), field.get(obj));  
        }    
        return map;  
    }   
    
    
	
	public  static Object convert2Bean(Map<String, Object> map, Object obj) {  
        Class class1 = obj.getClass();  
        Method[] methods = class1.getMethods();  
        for (Method method : methods) {  
            String methodName = method.getName(); 
            if (methodName.startsWith("set")) {  
                String propertyName = methodName.substring(3).toUpperCase(  
                        Locale.getDefault());  
                Object value = map.get(propertyName);  
                try {  
                    method.invoke(obj, value);  
                }  catch (Exception e) {  
                    e.printStackTrace();  
                }
            }  
        }  
        return obj;  
    }  

		    public static Map<String, Object> transBean2Map(Object obj) {  
		    	  
		        if(obj == null){  
		            return null;  
		        }          
		        Map<String, Object> map = new HashMap<String, Object>();  
		        try {  
		            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
		            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
		            for (PropertyDescriptor property : propertyDescriptors) {  
		                String key = property.getName().toUpperCase();  
		  
		                // 过滤class属性  
		                if (!key.equals("class")) {  
		                    // 得到property对应的getter方法  
		                	java.lang.reflect.Method getter = property.getReadMethod();  
		                    Object value = getter.invoke(obj);  
		  
		                    map.put(key, value);  
		                }  
		  
		            }  
		        } catch (Exception e) {  
		        }  
		  
		        return map;  
		  
		    } 
}
