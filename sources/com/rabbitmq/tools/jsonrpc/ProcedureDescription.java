package com.rabbitmq.tools.jsonrpc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.rabbitmq.tools.json.JSONUtil;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ProcedureDescription {
    public String help;
    public boolean idempotent;
    private Method method;
    public String name;
    private ParameterDescription[] params;
    private String returnType;
    public String summary;

    public ProcedureDescription(Map<String, Object> map) {
        JSONUtil.tryFill(this, map);
        List<Map> list = (List) map.get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        this.params = new ParameterDescription[list.size()];
        int i = 0;
        for (Map map2 : list) {
            this.params[i] = new ParameterDescription(map2);
            i++;
        }
    }

    public int arity() {
        ParameterDescription[] parameterDescriptionArr = this.params;
        if (parameterDescriptionArr == null) {
            return 0;
        }
        return parameterDescriptionArr.length;
    }

    public ParameterDescription[] getParams() {
        return this.params;
    }

    public String getReturn() {
        return this.returnType;
    }

    public Method internal_getMethod() {
        return this.method;
    }

    public ParameterDescription[] internal_getParams() {
        return this.params;
    }

    public void setReturn(String str) {
        this.returnType = str;
    }

    public ProcedureDescription(Method method2) {
        this.method = method2;
        this.name = method2.getName();
        this.summary = "";
        this.help = "";
        this.idempotent = false;
        Class<?>[] parameterTypes = method2.getParameterTypes();
        this.params = new ParameterDescription[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            this.params[i] = new ParameterDescription(i, parameterTypes[i]);
        }
        this.returnType = ParameterDescription.lookup(method2.getReturnType());
    }

    public ProcedureDescription() {
    }
}
