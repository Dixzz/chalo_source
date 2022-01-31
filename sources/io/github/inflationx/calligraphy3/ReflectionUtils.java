package io.github.inflationx.calligraphy3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static Method getMethod(Class cls, String str) {
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static void invokeMethod(Object obj, Method method, Object... objArr) {
        if (method != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
