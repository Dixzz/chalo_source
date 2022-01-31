package com.rabbitmq.client.impl.recovery;

import java.io.IOException;
import java.util.Map;

public abstract class RecordedBinding extends RecordedEntity {
    public Map<String, Object> arguments;
    public String destination;
    public String routingKey;
    public String source;

    public RecordedBinding(AutorecoveringChannel autorecoveringChannel) {
        super(autorecoveringChannel);
    }

    public RecordedBinding arguments(Map<String, Object> map) {
        this.arguments = map;
        return this;
    }

    public RecordedBinding destination(String str) {
        this.destination = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RecordedBinding recordedBinding = (RecordedBinding) obj;
        Map<String, Object> map = this.arguments;
        if (map == null ? recordedBinding.arguments == null : map.equals(recordedBinding.arguments)) {
            return this.destination.equals(recordedBinding.destination) && this.routingKey.equals(recordedBinding.routingKey) && this.source.equals(recordedBinding.source);
        }
        return false;
    }

    public Map<String, Object> getArguments() {
        return this.arguments;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getSource() {
        return this.source;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.routingKey, hj1.r0(this.destination, this.source.hashCode() * 31, 31), 31);
        Map<String, Object> map = this.arguments;
        return r0 + (map != null ? map.hashCode() : 0);
    }

    public void recover() throws IOException {
    }

    public RecordedBinding routingKey(String str) {
        this.routingKey = str;
        return this;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public RecordedBinding source(String str) {
        this.source = str;
        return this;
    }
}
