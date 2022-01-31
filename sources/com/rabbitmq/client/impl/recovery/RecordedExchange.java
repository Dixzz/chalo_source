package com.rabbitmq.client.impl.recovery;

import java.io.IOException;
import java.util.Map;

public class RecordedExchange extends RecordedNamedEntity {
    private Map<String, Object> arguments;
    private boolean autoDelete;
    private boolean durable;
    private String type;

    public RecordedExchange(AutorecoveringChannel autorecoveringChannel, String str) {
        super(autorecoveringChannel, str);
    }

    public RecordedExchange arguments(Map<String, Object> map) {
        this.arguments = map;
        return this;
    }

    public RecordedExchange autoDelete(boolean z) {
        this.autoDelete = z;
        return this;
    }

    public RecordedExchange durable(boolean z) {
        this.durable = z;
        return this;
    }

    public boolean isAutoDelete() {
        return this.autoDelete;
    }

    public void recover() throws IOException {
        this.channel.getDelegate().exchangeDeclare(this.name, this.type, this.durable, this.autoDelete, this.arguments);
    }

    public RecordedExchange type(String str) {
        this.type = str;
        return this;
    }
}
