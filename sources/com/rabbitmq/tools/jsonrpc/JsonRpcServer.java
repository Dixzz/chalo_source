package com.rabbitmq.tools.jsonrpc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.StringRpcServer;
import com.rabbitmq.tools.json.JSONReader;
import com.rabbitmq.tools.json.JSONWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonRpcServer extends StringRpcServer {
    public Class<?> interfaceClass;
    public Object interfaceInstance;
    public ServiceDescription serviceDescription;

    public JsonRpcServer(Channel channel, Class<?> cls, Object obj) throws IOException {
        super(channel);
        init(cls, obj);
    }

    public static String errorResponse(Object obj, int i, String str, Object obj2) {
        HashMap m0 = hj1.m0("name", "JSONRPCError");
        m0.put("code", Integer.valueOf(i));
        m0.put("message", str);
        m0.put("error", obj2);
        return response(obj, "error", m0);
    }

    private void init(Class<?> cls, Object obj) {
        this.interfaceClass = cls;
        this.interfaceInstance = obj;
        this.serviceDescription = new ServiceDescription(cls);
    }

    public static String response(Object obj, String str, Object obj2) {
        HashMap m0 = hj1.m0("version", ServiceDescription.JSON_RPC_VERSION);
        if (obj != null) {
            m0.put("id", obj);
        }
        m0.put(str, obj2);
        return new JSONWriter().write(m0);
    }

    public static String resultResponse(Object obj, Object obj2) {
        return response(obj, "result", obj2);
    }

    public String doCall(String str) {
        try {
            Map map = (Map) new JSONReader().read(str);
            if (map == null) {
                return errorResponse(null, 400, "Bad Request", null);
            }
            if (!ServiceDescription.JSON_RPC_VERSION.equals(map.get("version"))) {
                return errorResponse(null, AMQP.UNEXPECTED_FRAME, "JSONRPC version not supported", null);
            }
            Object obj = map.get("id");
            String str2 = (String) map.get("method");
            Object[] array = ((List) map.get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY)).toArray();
            if (str2.equals("system.describe")) {
                return resultResponse(obj, this.serviceDescription);
            }
            if (str2.startsWith("system.")) {
                return errorResponse(obj, AMQP.ACCESS_REFUSED, "System methods forbidden", null);
            }
            try {
                return resultResponse(obj, matchingMethod(str2, array).invoke(this.interfaceInstance, array));
            } catch (Throwable th) {
                return errorResponse(obj, 500, "Internal Server Error", th);
            }
        } catch (ClassCastException unused) {
            return errorResponse(null, 400, "Bad Request", null);
        }
    }

    public ServiceDescription getServiceDescription() {
        return this.serviceDescription;
    }

    @Override // com.rabbitmq.client.StringRpcServer
    public String handleStringCall(String str, AMQP.BasicProperties basicProperties) {
        return doCall(str);
    }

    public Method matchingMethod(String str, Object[] objArr) {
        return this.serviceDescription.getProcedure(str, objArr.length).internal_getMethod();
    }

    public JsonRpcServer(Channel channel, String str, Class<?> cls, Object obj) throws IOException {
        super(channel, str);
        init(cls, obj);
    }
}
