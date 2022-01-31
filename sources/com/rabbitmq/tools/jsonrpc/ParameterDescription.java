package com.rabbitmq.tools.jsonrpc;

import com.rabbitmq.tools.json.JSONUtil;
import java.util.Collection;
import java.util.Map;

public class ParameterDescription {
    public String name;
    public String type;

    public ParameterDescription() {
    }

    public static String lookup(Class<?> cls) {
        if (cls == Void.class) {
            return "nil";
        }
        if (cls == Boolean.class) {
            return "bit";
        }
        if (cls == Integer.class || cls == Double.class) {
            return "num";
        }
        if (cls == String.class) {
            return "str";
        }
        if (cls.isArray()) {
            return "arr";
        }
        if (Map.class.isAssignableFrom(cls)) {
            return "obj";
        }
        if (Collection.class.isAssignableFrom(cls)) {
            return "arr";
        }
        return "any";
    }

    public ParameterDescription(Map<String, Object> map) {
        JSONUtil.tryFill(this, map);
    }

    public ParameterDescription(int i, Class<?> cls) {
        this.name = hj1.I("param", i);
        this.type = lookup(cls);
    }
}
