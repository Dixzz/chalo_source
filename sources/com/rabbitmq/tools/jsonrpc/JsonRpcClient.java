package com.rabbitmq.tools.jsonrpc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.RpcClient;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.tools.json.JSONReader;
import com.rabbitmq.tools.json.JSONWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class JsonRpcClient extends RpcClient implements InvocationHandler {
    private ServiceDescription serviceDescription;

    public JsonRpcClient(Channel channel, String str, String str2, int i) throws IOException, JsonRpcException, TimeoutException {
        super(channel, str, str2, i);
        retrieveServiceDescription();
    }

    public static Object checkReply(Map<String, Object> map) throws JsonRpcException {
        if (!map.containsKey("error")) {
            return map.get("result");
        }
        throw new JsonRpcException((Map) map.get("error"));
    }

    public static Object coerce(String str, String str2) throws NumberFormatException {
        if ("bit".equals(str2)) {
            return Boolean.getBoolean(str) ? Boolean.TRUE : Boolean.FALSE;
        }
        if ("num".equals(str2)) {
            try {
                return new Integer(str);
            } catch (NumberFormatException unused) {
                return new Double(str);
            }
        } else if ("str".equals(str2)) {
            return str;
        } else {
            if ("arr".equals(str2) || "obj".equals(str2) || "any".equals(str2)) {
                return new JSONReader().read(str);
            }
            if ("nil".equals(str2)) {
                return null;
            }
            throw new IllegalArgumentException(hj1.S("Bad type: ", str2));
        }
    }

    private void retrieveServiceDescription() throws IOException, JsonRpcException, TimeoutException {
        this.serviceDescription = new ServiceDescription((Map) call("system.describe", null));
    }

    public Object call(String str, Object[] objArr) throws IOException, JsonRpcException, TimeoutException {
        HashMap hashMap = new HashMap();
        hashMap.put("id", null);
        hashMap.put("method", str);
        hashMap.put("version", ServiceDescription.JSON_RPC_VERSION);
        if (objArr == null) {
            objArr = new Object[0];
        }
        hashMap.put(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, objArr);
        try {
            return checkReply((Map) new JSONReader().read(stringCall(new JSONWriter().write(hashMap))));
        } catch (ShutdownSignalException e) {
            throw new IOException(e.getMessage());
        }
    }

    public Object createProxy(Class<?> cls) throws IllegalArgumentException {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
    }

    public ServiceDescription getServiceDescription() {
        return this.serviceDescription;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return call(method.getName(), objArr);
    }

    public JsonRpcClient(Channel channel, String str, String str2) throws IOException, JsonRpcException, TimeoutException {
        this(channel, str, str2, -1);
    }

    public Object call(String[] strArr) throws NumberFormatException, IOException, JsonRpcException, TimeoutException {
        if (strArr.length != 0) {
            int i = 0;
            String str = strArr[0];
            int length = strArr.length - 1;
            ParameterDescription[] params = this.serviceDescription.getProcedure(str, length).getParams();
            Object[] objArr = new Object[length];
            while (i < params.length) {
                int i2 = i + 1;
                objArr[i] = coerce(strArr[i2], params[i].type);
                i = i2;
            }
            return call(str, objArr);
        }
        throw new IllegalArgumentException("First string argument must be method name");
    }
}
