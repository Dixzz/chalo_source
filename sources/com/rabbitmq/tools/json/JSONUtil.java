package com.rabbitmq.tools.json;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

public class JSONUtil {
    public static Object fill(Object obj, Map<String, Object> map) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        return fill(obj, map, true);
    }

    public static void tryFill(Object obj, Map<String, Object> map) {
        try {
            fill(obj, map);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static Object fill(Object obj, Map<String, Object> map, boolean z) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        if (z) {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                Method writeMethod = propertyDescriptor.getWriteMethod();
                if (writeMethod != null && !Modifier.isStatic(writeMethod.getModifiers())) {
                    writeMethod.invoke(obj, map.get(name));
                }
            }
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers) && !Modifier.isFinal(modifiers) && !Modifier.isStatic(modifiers)) {
                try {
                    field.set(obj, map.get(field.getName()));
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return obj;
    }
}
