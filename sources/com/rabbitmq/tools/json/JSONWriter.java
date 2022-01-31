package com.rabbitmq.tools.json;

import com.razorpay.AnalyticsConstants;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.StringCharacterIterator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class JSONWriter {
    public static final char[] hex = "0123456789ABCDEF".toCharArray();
    private final StringBuilder buf = new StringBuilder();
    private int indentLevel = 0;
    private boolean indentMode = false;

    public JSONWriter() {
    }

    private void add(String str, Object obj) {
        add('\"');
        add(str);
        add("\":");
        value(obj);
    }

    private void array(Iterator<?> it) {
        add('[');
        if (it.hasNext()) {
            value(it.next());
        }
        while (it.hasNext()) {
            add(',');
            value(it.next());
        }
        add(']');
    }

    private void bean(Object obj) {
        writeLimited(obj.getClass(), obj, null);
    }

    private void bool(boolean z) {
        add(z ? "true" : "false");
    }

    private void map(Map<String, Object> map) {
        add('{');
        this.indentLevel += 2;
        newline();
        Iterator<String> it = map.keySet().iterator();
        if (it.hasNext()) {
            mapEntry(it.next(), map);
        }
        while (it.hasNext()) {
            add(',');
            newline();
            String next = it.next();
            value(next);
            add(':');
            value(map.get(next));
        }
        this.indentLevel -= 2;
        newline();
        add('}');
    }

    private void mapEntry(Object obj, Map<String, Object> map) {
        value(obj);
        add(':');
        value(map.get(obj));
    }

    private void newline() {
        if (this.indentMode) {
            add('\n');
            for (int i = 0; i < this.indentLevel; i++) {
                add(' ');
            }
        }
    }

    private void string(Object obj) {
        add('\"');
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(obj.toString());
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '\"') {
                add("\\\"");
            } else if (first == '\\') {
                add("\\\\");
            } else if (first == '/') {
                add("\\/");
            } else if (first == '\b') {
                add("\\b");
            } else if (first == '\f') {
                add("\\f");
            } else if (first == '\n') {
                add("\\n");
            } else if (first == '\r') {
                add("\\r");
            } else if (first == '\t') {
                add("\\t");
            } else if (Character.isISOControl(first)) {
                unicode(first);
            } else {
                add(first);
            }
        }
        add('\"');
    }

    private void unicode(char c) {
        add("\\u");
        int i = 0;
        char c2 = c;
        while (i < 4) {
            add(hex[(61440 & (c2 == 1 ? 1 : 0)) >> 12]);
            i++;
            c2 = (c2 == 1 ? 1 : 0) << 4;
        }
    }

    private void value(Object obj) {
        if (obj == null) {
            add(AnalyticsConstants.NULL);
        } else if (obj instanceof JSONSerializable) {
            ((JSONSerializable) obj).jsonSerialize(this);
        } else if (obj instanceof Class) {
            string(obj);
        } else if (obj instanceof Boolean) {
            bool(((Boolean) obj).booleanValue());
        } else if (obj instanceof Number) {
            add(obj);
        } else if (obj instanceof String) {
            string(obj);
        } else if (obj instanceof Character) {
            string(obj);
        } else if (obj instanceof Map) {
            map((Map) obj);
        } else if (obj.getClass().isArray()) {
            array(obj);
        } else if (obj instanceof Collection) {
            array(((Collection) obj).iterator());
        } else {
            bean(obj);
        }
    }

    public boolean getIndentMode() {
        return this.indentMode;
    }

    public void setIndentMode(boolean z) {
        this.indentMode = z;
    }

    public String write(Object obj) {
        this.buf.setLength(0);
        value(obj);
        return this.buf.toString();
    }

    public void writeLimited(Class<?> cls, Object obj, String[] strArr) {
        HashSet hashSet;
        BeanInfo beanInfo;
        boolean z;
        Method readMethod;
        if (strArr != null) {
            hashSet = new HashSet();
            for (String str : strArr) {
                hashSet.add(str);
            }
        } else {
            hashSet = null;
        }
        add('{');
        this.indentLevel += 2;
        newline();
        try {
            beanInfo = Introspector.getBeanInfo(cls);
        } catch (IntrospectionException unused) {
            beanInfo = null;
        }
        if (beanInfo != null) {
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            z = false;
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if ((hashSet != null || !name.equals("class")) && ((hashSet == null || hashSet.contains(name)) && (readMethod = propertyDescriptor.getReadMethod()) != null && !Modifier.isStatic(readMethod.getModifiers()))) {
                    try {
                        Object invoke = readMethod.invoke(obj, null);
                        if (z) {
                            add(',');
                            newline();
                        }
                        try {
                            add(name, invoke);
                        } catch (Exception unused2) {
                        }
                        z = true;
                    } catch (Exception unused3) {
                    }
                }
            }
        } else {
            z = false;
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            String name2 = field.getName();
            if ((hashSet == null || hashSet.contains(name2)) && !Modifier.isStatic(modifiers)) {
                try {
                    Object obj2 = field.get(obj);
                    if (z) {
                        add(',');
                        newline();
                    }
                    try {
                        add(name2, obj2);
                    } catch (Exception unused4) {
                    }
                    z = true;
                } catch (Exception unused5) {
                }
            }
        }
        this.indentLevel -= 2;
        newline();
        add('}');
    }

    public String write(long j) {
        return write(new Long(j));
    }

    public JSONWriter(boolean z) {
        this.indentMode = z;
    }

    private void add(Object obj) {
        this.buf.append(obj);
    }

    public Object write(double d) {
        return write(new Double(d));
    }

    private void add(char c) {
        this.buf.append(c);
    }

    public String write(char c) {
        return write(new Character(c));
    }

    private void array(Object obj) {
        add('[');
        int length = Array.getLength(obj);
        if (length > 0) {
            value(Array.get(obj, 0));
        }
        for (int i = 1; i < length; i++) {
            add(',');
            value(Array.get(obj, i));
        }
        add(']');
    }

    public String write(boolean z) {
        return write(Boolean.valueOf(z));
    }
}
