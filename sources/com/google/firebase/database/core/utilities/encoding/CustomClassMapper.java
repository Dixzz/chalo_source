package com.google.firebase.database.core.utilities.encoding;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.core.utilities.Utilities;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class CustomClassMapper {
    private static final String LOG_TAG = "ClassMapper";
    private static final ConcurrentMap<Class<?>, BeanMapper<?>> mappers = new ConcurrentHashMap();

    public static class BeanMapper<T> {
        private final Class<T> clazz;
        private final Constructor<T> constructor;
        private final Map<String, Field> fields = new HashMap();
        private final Map<String, Method> getters = new HashMap();
        private final Map<String, String> properties = new HashMap();
        private final Map<String, Method> setters = new HashMap();
        private final boolean throwOnUnknownProperties;
        private final boolean warnOnUnknownProperties;

        public BeanMapper(Class<T> cls) {
            Constructor<T> constructor2;
            this.clazz = cls;
            this.throwOnUnknownProperties = cls.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.warnOnUnknownProperties = !cls.isAnnotationPresent(IgnoreExtraProperties.class);
            try {
                constructor2 = cls.getDeclaredConstructor(new Class[0]);
                constructor2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                constructor2 = null;
            }
            this.constructor = constructor2;
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                if (shouldIncludeGetter(method)) {
                    String propertyName = propertyName(method);
                    addProperty(propertyName);
                    method.setAccessible(true);
                    if (!this.getters.containsKey(propertyName)) {
                        this.getters.put(propertyName, method);
                    } else {
                        StringBuilder i0 = hj1.i0("Found conflicting getters for name: ");
                        i0.append(method.getName());
                        throw new DatabaseException(i0.toString());
                    }
                }
            }
            Field[] fields2 = cls.getFields();
            for (Field field : fields2) {
                if (shouldIncludeField(field)) {
                    addProperty(propertyName(field));
                }
            }
            Class<T> cls2 = cls;
            do {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                for (Method method2 : declaredMethods) {
                    if (shouldIncludeSetter(method2)) {
                        String propertyName2 = propertyName(method2);
                        String str = this.properties.get(propertyName2.toLowerCase(Locale.US));
                        if (str == null) {
                            continue;
                        } else if (str.equals(propertyName2)) {
                            Method method3 = this.setters.get(propertyName2);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.setters.put(propertyName2, method2);
                            } else if (!isSetterOverride(method2, method3)) {
                                StringBuilder i02 = hj1.i0("Found a conflicting setters with name: ");
                                i02.append(method2.getName());
                                i02.append(" (conflicts with ");
                                i02.append(method3.getName());
                                i02.append(" defined on ");
                                i02.append(method3.getDeclaringClass().getName());
                                i02.append(")");
                                throw new DatabaseException(i02.toString());
                            }
                        } else {
                            StringBuilder i03 = hj1.i0("Found setter with invalid case-sensitive name: ");
                            i03.append(method2.getName());
                            throw new DatabaseException(i03.toString());
                        }
                    }
                }
                Field[] declaredFields = cls2.getDeclaredFields();
                for (Field field2 : declaredFields) {
                    String propertyName3 = propertyName(field2);
                    if (this.properties.containsKey(propertyName3.toLowerCase(Locale.US)) && !this.fields.containsKey(propertyName3)) {
                        field2.setAccessible(true);
                        this.fields.put(propertyName3, field2);
                    }
                }
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    break;
                }
            } while (!cls2.equals(Object.class));
            if (this.properties.isEmpty()) {
                StringBuilder i04 = hj1.i0("No properties to serialize found on class ");
                i04.append(cls.getName());
                throw new DatabaseException(i04.toString());
            }
        }

        private void addProperty(String str) {
            Map<String, String> map = this.properties;
            Locale locale = Locale.US;
            String put = map.put(str.toLowerCase(locale), str);
            if (put != null && !str.equals(put)) {
                StringBuilder i0 = hj1.i0("Found two getters or fields with conflicting case sensitivity for property: ");
                i0.append(str.toLowerCase(locale));
                throw new DatabaseException(i0.toString());
            }
        }

        private static String annotatedName(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }

        private static boolean isSetterOverride(Method method, Method method2) {
            Utilities.hardAssert(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            Utilities.hardAssert(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            Utilities.hardAssert(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            Utilities.hardAssert(parameterTypes.length == 1, "Expected exactly one parameter");
            Utilities.hardAssert(parameterTypes2.length == 1, "Expected exactly one parameter");
            if (!method.getName().equals(method2.getName()) || !parameterTypes[0].equals(parameterTypes2[0])) {
                return false;
            }
            return true;
        }

        private static String propertyName(Field field) {
            String annotatedName = annotatedName(field);
            return annotatedName != null ? annotatedName : field.getName();
        }

        private Type resolveType(Type type, Map<TypeVariable<Class<T>>, Type> map) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type type2 = map.get(type);
            if (type2 != null) {
                return type2;
            }
            throw new IllegalStateException("Could not resolve type " + type);
        }

        private static String serializedName(String str) {
            String[] strArr = {"get", "set", "is"};
            int i = 0;
            String str2 = null;
            for (int i2 = 0; i2 < 3; i2++) {
                String str3 = strArr[i2];
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 != null) {
                char[] charArray = str.substring(str2.length()).toCharArray();
                while (i < charArray.length && Character.isUpperCase(charArray[i])) {
                    charArray[i] = Character.toLowerCase(charArray[i]);
                    i++;
                }
                return new String(charArray);
            }
            throw new IllegalArgumentException(hj1.S("Unknown Bean prefix for method: ", str));
        }

        private static boolean shouldIncludeField(Field field) {
            if (!field.getDeclaringClass().equals(Object.class) && Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean shouldIncludeGetter(Method method) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getDeclaringClass().equals(Object.class) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean shouldIncludeSetter(Method method) {
            if (method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        public T deserialize(Map<String, Object> map) {
            return deserialize(map, Collections.emptyMap());
        }

        public Map<String, Object> serialize(T t) {
            Object obj;
            if (this.clazz.isAssignableFrom(t.getClass())) {
                HashMap hashMap = new HashMap();
                for (String str : this.properties.values()) {
                    if (this.getters.containsKey(str)) {
                        try {
                            obj = this.getters.get(str).invoke(t, new Object[0]);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else {
                        Field field = this.fields.get(str);
                        if (field != null) {
                            try {
                                obj = field.get(t);
                            } catch (IllegalAccessException e3) {
                                throw new RuntimeException(e3);
                            }
                        } else {
                            throw new IllegalStateException(hj1.S("Bean property without field or getter:", str));
                        }
                    }
                    hashMap.put(str, CustomClassMapper.serialize(obj));
                }
                return hashMap;
            }
            StringBuilder i0 = hj1.i0("Can't serialize object of class ");
            i0.append(t.getClass());
            i0.append(" with BeanMapper for class ");
            i0.append(this.clazz);
            throw new IllegalArgumentException(i0.toString());
        }

        public T deserialize(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
            Constructor<T> constructor2 = this.constructor;
            if (constructor2 != null) {
                try {
                    T newInstance = constructor2.newInstance(new Object[0]);
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        if (this.setters.containsKey(key)) {
                            Method method = this.setters.get(key);
                            Type[] genericParameterTypes = method.getGenericParameterTypes();
                            if (genericParameterTypes.length == 1) {
                                try {
                                    method.invoke(newInstance, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(genericParameterTypes[0], map2)));
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                } catch (InvocationTargetException e2) {
                                    throw new RuntimeException(e2);
                                }
                            } else {
                                throw new IllegalStateException("Setter does not have exactly one parameter");
                            }
                        } else if (this.fields.containsKey(key)) {
                            Field field = this.fields.get(key);
                            try {
                                field.set(newInstance, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(field.getGenericType(), map2)));
                            } catch (IllegalAccessException e3) {
                                throw new RuntimeException(e3);
                            }
                        } else {
                            StringBuilder l0 = hj1.l0("No setter/field for ", key, " found on class ");
                            l0.append(this.clazz.getName());
                            String sb = l0.toString();
                            if (this.properties.containsKey(key.toLowerCase(Locale.US))) {
                                sb = hj1.S(sb, " (fields/setters are case sensitive!)");
                            }
                            if (this.throwOnUnknownProperties) {
                                throw new DatabaseException(sb);
                            }
                        }
                    }
                    return newInstance;
                } catch (InstantiationException e4) {
                    throw new RuntimeException(e4);
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException(e6);
                }
            } else {
                throw new DatabaseException(hj1.G(this.clazz, hj1.i0("Class "), " does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped."));
            }
        }

        private static String propertyName(Method method) {
            String annotatedName = annotatedName(method);
            return annotatedName != null ? annotatedName : serializedName(method.getName());
        }
    }

    private static <T> T convertBean(Object obj, Class<T> cls) {
        BeanMapper loadOrCreateBeanMapperForClass = loadOrCreateBeanMapperForClass(cls);
        if (obj instanceof Map) {
            return (T) loadOrCreateBeanMapperForClass.deserialize(expectMap(obj));
        }
        StringBuilder i0 = hj1.i0("Can't convert object of type ");
        i0.append(obj.getClass().getName());
        i0.append(" to type ");
        i0.append(cls.getName());
        throw new DatabaseException(i0.toString());
    }

    private static Boolean convertBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        StringBuilder i0 = hj1.i0("Failed to convert value of type ");
        i0.append(obj.getClass().getName());
        i0.append(" to boolean");
        throw new DatabaseException(i0.toString());
    }

    private static Double convertDouble(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf = Double.valueOf(l.doubleValue());
            if (valueOf.longValue() == l.longValue()) {
                return valueOf;
            }
            throw new DatabaseException("Loss of precision while converting number to double: " + obj + ". Did you mean to use a 64-bit long instead?");
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            StringBuilder i0 = hj1.i0("Failed to convert a value of type ");
            i0.append(obj.getClass().getName());
            i0.append(" to double");
            throw new DatabaseException(i0.toString());
        }
    }

    private static Integer convertInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            Number number = (Number) obj;
            double doubleValue = number.doubleValue();
            if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
                return Integer.valueOf(number.intValue());
            }
            throw new DatabaseException("Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
        }
        StringBuilder i0 = hj1.i0("Failed to convert a value of type ");
        i0.append(obj.getClass().getName());
        i0.append(" to int");
        throw new DatabaseException(i0.toString());
    }

    private static Long convertLong(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() >= -9.223372036854776E18d && d.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(d.longValue());
            }
            throw new DatabaseException("Numeric value out of 64-bit long range: " + d + ". Did you mean to use a double instead of a long?");
        }
        StringBuilder i0 = hj1.i0("Failed to convert a value of type ");
        i0.append(obj.getClass().getName());
        i0.append(" to long");
        throw new DatabaseException(i0.toString());
    }

    private static String convertString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        StringBuilder i0 = hj1.i0("Failed to convert value of type ");
        i0.append(obj.getClass().getName());
        i0.append(" to String");
        throw new DatabaseException(i0.toString());
    }

    public static <T> T convertToCustomClass(Object obj, Class<T> cls) {
        return (T) deserializeToClass(obj, cls);
    }

    public static Object convertToPlainJavaTypes(Object obj) {
        return serialize(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T deserializeToClass(Object obj, Class<T> cls) {
        if (obj == 0) {
            return null;
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) {
            return (T) deserializeToPrimitive(obj, cls);
        }
        if (String.class.isAssignableFrom(cls)) {
            return (T) convertString(obj);
        }
        if (cls.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        } else if (cls.getTypeParameters().length > 0) {
            throw new DatabaseException(hj1.G(cls, hj1.i0("Class "), " has generic type parameters, please use GenericTypeIndicator instead"));
        } else if (cls.equals(Object.class)) {
            return obj;
        } else {
            return cls.isEnum() ? (T) deserializeToEnum(obj, cls) : (T) convertBean(obj, cls);
        }
    }

    private static <T> T deserializeToEnum(Object obj, Class<T> cls) {
        if (obj instanceof String) {
            String str = (String) obj;
            try {
                return (T) Enum.valueOf(cls, str);
            } catch (IllegalArgumentException unused) {
                StringBuilder i0 = hj1.i0("Could not find enum value of ");
                i0.append(cls.getName());
                i0.append(" for value \"");
                i0.append(str);
                i0.append("\"");
                throw new DatabaseException(i0.toString());
            }
        } else {
            throw new DatabaseException("Expected a String while deserializing to enum " + cls + " but got a " + obj.getClass());
        }
    }

    private static <T> T deserializeToParameterizedType(Object obj, ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                T t = (T) new ArrayList(list.size());
                for (Object obj2 : list) {
                    t.add(deserializeToType(obj2, type));
                }
                return t;
            }
            StringBuilder i0 = hj1.i0("Expected a List while deserializing, but got a ");
            i0.append(obj.getClass());
            throw new DatabaseException(i0.toString());
        } else if (Map.class.isAssignableFrom(cls)) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (type2.equals(String.class)) {
                Map<String, Object> expectMap = expectMap(obj);
                T t2 = (T) new HashMap();
                for (Map.Entry<String, Object> entry : expectMap.entrySet()) {
                    t2.put(entry.getKey(), deserializeToType(entry.getValue(), type3));
                }
                return t2;
            }
            throw new DatabaseException("Only Maps with string keys are supported, but found Map with key type " + type2);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            Map<String, Object> expectMap2 = expectMap(obj);
            BeanMapper loadOrCreateBeanMapperForClass = loadOrCreateBeanMapperForClass(cls);
            HashMap hashMap = new HashMap();
            TypeVariable<Class<T>>[] typeParameters = loadOrCreateBeanMapperForClass.clazz.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == typeParameters.length) {
                for (int i = 0; i < typeParameters.length; i++) {
                    hashMap.put(typeParameters[i], actualTypeArguments[i]);
                }
                return (T) loadOrCreateBeanMapperForClass.deserialize(expectMap2, hashMap);
            }
            throw new IllegalStateException("Mismatched lengths for type variables and actual types");
        } else {
            throw new DatabaseException("Collections are not supported, please use Lists instead");
        }
    }

    private static <T> T deserializeToPrimitive(Object obj, Class<T> cls) {
        if (Integer.class.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls)) {
            return (T) convertInteger(obj);
        }
        if (Boolean.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
            return (T) convertBoolean(obj);
        }
        if (Double.class.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls)) {
            return (T) convertDouble(obj);
        }
        if (Long.class.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls)) {
            return (T) convertLong(obj);
        }
        if (Float.class.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls)) {
            return (T) Float.valueOf(convertDouble(obj).floatValue());
        }
        throw new DatabaseException(String.format("Deserializing values to %s is not supported", cls.getSimpleName()));
    }

    /* access modifiers changed from: private */
    public static <T> T deserializeToType(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return (T) deserializeToParameterizedType(obj, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return (T) deserializeToClass(obj, (Class) type);
        }
        boolean z = true;
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length <= 0) {
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (upperBounds.length <= 0) {
                    z = false;
                }
                Utilities.hardAssert(z, "Wildcard type " + type + " is not upper bounded.");
                return (T) deserializeToType(obj, upperBounds[0]);
            }
            throw new DatabaseException("Generic lower-bounded wildcard types are not supported");
        } else if (type instanceof TypeVariable) {
            Type[] bounds = ((TypeVariable) type).getBounds();
            if (bounds.length <= 0) {
                z = false;
            }
            Utilities.hardAssert(z, "Wildcard type " + type + " is not upper bounded.");
            return (T) deserializeToType(obj, bounds[0]);
        } else if (type instanceof GenericArrayType) {
            throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
        } else {
            throw new IllegalStateException("Unknown type encountered: " + type);
        }
    }

    private static Map<String, Object> expectMap(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        StringBuilder i0 = hj1.i0("Expected a Map while deserializing, but got a ");
        i0.append(obj.getClass());
        throw new DatabaseException(i0.toString());
    }

    private static <T> BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> cls) {
        ConcurrentMap<Class<?>, BeanMapper<?>> concurrentMap = mappers;
        BeanMapper<?> beanMapper = concurrentMap.get(cls);
        if (beanMapper != null) {
            return beanMapper;
        }
        BeanMapper<T> beanMapper2 = new BeanMapper<>(cls);
        concurrentMap.put(cls, beanMapper2);
        return beanMapper2;
    }

    /* access modifiers changed from: private */
    public static <T> Object serialize(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if ((t instanceof Float) || (t instanceof Double)) {
                T t2 = t;
                double doubleValue = t2.doubleValue();
                if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d || Math.floor(doubleValue) != doubleValue) {
                    return Double.valueOf(doubleValue);
                }
                return Long.valueOf(t2.longValue());
            } else if ((t instanceof Long) || (t instanceof Integer)) {
                return t;
            } else {
                throw new DatabaseException(String.format("Numbers of type %s are not supported, please use an int, long, float or double", t.getClass().getSimpleName()));
            }
        } else if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        } else {
            if (t instanceof Character) {
                throw new DatabaseException("Characters are not supported, please use Strings");
            } else if (t instanceof Map) {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : t.entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, serialize(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            } else if (t instanceof Collection) {
                if (t instanceof List) {
                    T<Object> t3 = t;
                    ArrayList arrayList = new ArrayList(t3.size());
                    for (Object obj : t3) {
                        arrayList.add(serialize(obj));
                    }
                    return arrayList;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (t.getClass().isArray()) {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            } else if (t instanceof Enum) {
                return t.name();
            } else {
                return loadOrCreateBeanMapperForClass(t.getClass()).serialize(t);
            }
        }
    }

    public static <T> T convertToCustomClass(Object obj, GenericTypeIndicator<T> genericTypeIndicator) {
        Type genericSuperclass = genericTypeIndicator.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return (T) deserializeToType(obj, parameterizedType.getActualTypeArguments()[0]);
            }
            throw new DatabaseException("Not a direct subclass of GenericTypeIndicator: " + genericSuperclass);
        }
        throw new DatabaseException("Not a direct subclass of GenericTypeIndicator: " + genericSuperclass);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<String, Object> map) {
        Object serialize = serialize(map);
        Utilities.hardAssert(serialize instanceof Map);
        return (Map) serialize;
    }
}
