package com.rabbitmq.tools.jsonrpc;

import com.rabbitmq.tools.json.JSONWriter;
import java.util.Map;

public class JsonRpcException extends Exception {
    private static final long serialVersionUID = 1;
    public int code;
    public Object error;
    public String message;
    public String name;

    public JsonRpcException() {
    }

    public JsonRpcException(Map<String, Object> map) {
        super(new JSONWriter().write(map));
        this.name = (String) map.get("name");
        this.code = 0;
        if (map.get("code") != null) {
            this.code = ((Integer) map.get("code")).intValue();
        }
        this.message = (String) map.get("message");
        this.error = map.get("error");
    }
}
