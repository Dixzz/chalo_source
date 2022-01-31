package com.rabbitmq.tools.jsonrpc;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONUtil;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ServiceDescription {
    public static final String JSON_RPC_VERSION = "1.1";
    public String help;
    public String id;
    public String name;
    private Map<String, ProcedureDescription> procedures;
    public String summary;
    public String version;

    public ServiceDescription(Map<String, Object> map) {
        JSONUtil.tryFill(this, map);
    }

    private void addProcedure(ProcedureDescription procedureDescription) {
        Map<String, ProcedureDescription> map = this.procedures;
        map.put(procedureDescription.name + ConnectionFactory.DEFAULT_VHOST + procedureDescription.arity(), procedureDescription);
    }

    public ProcedureDescription getProcedure(String str, int i) {
        Map<String, ProcedureDescription> map = this.procedures;
        ProcedureDescription procedureDescription = map.get(str + ConnectionFactory.DEFAULT_VHOST + i);
        if (procedureDescription != null) {
            return procedureDescription;
        }
        throw new IllegalArgumentException("Procedure not found: " + str + ", arity " + i);
    }

    public Collection<ProcedureDescription> getProcs() {
        return this.procedures.values();
    }

    public void setProcs(Collection<Map<String, Object>> collection) {
        this.procedures = new HashMap();
        for (Map<String, Object> map : collection) {
            addProcedure(new ProcedureDescription(map));
        }
    }

    public ServiceDescription(Class<?> cls) {
        this.procedures = new HashMap();
        for (Method method : cls.getMethods()) {
            addProcedure(new ProcedureDescription(method));
        }
    }

    public ServiceDescription() {
    }
}
