package com.rabbitmq.client.impl.recovery;

import java.io.IOException;
import java.util.Map;

public class RecordedQueue extends RecordedNamedEntity {
    public static final String EMPTY_STRING = "";
    private Map<String, Object> arguments;
    private boolean autoDelete;
    private boolean durable;
    private boolean exclusive;
    private boolean serverNamed;

    public RecordedQueue(AutorecoveringChannel autorecoveringChannel, String str) {
        super(autorecoveringChannel, str);
    }

    public RecordedQueue arguments(Map<String, Object> map) {
        this.arguments = map;
        return this;
    }

    public RecordedQueue autoDelete(boolean z) {
        this.autoDelete = z;
        return this;
    }

    public RecordedQueue durable(boolean z) {
        this.durable = z;
        return this;
    }

    public RecordedQueue exclusive(boolean z) {
        this.exclusive = z;
        return this;
    }

    public String getNameToUseForRecovery() {
        if (isServerNamed()) {
            return "";
        }
        return this.name;
    }

    public boolean isAutoDelete() {
        return this.autoDelete;
    }

    public boolean isServerNamed() {
        return this.serverNamed;
    }

    public void recover() throws IOException {
        this.name = this.channel.queueDeclare(getNameToUseForRecovery(), this.durable, this.exclusive, this.autoDelete, this.arguments).getQueue();
    }

    public RecordedQueue serverNamed(boolean z) {
        this.serverNamed = z;
        return this;
    }
}
