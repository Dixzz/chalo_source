package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.Consumer;
import java.io.IOException;
import java.util.Map;

public class RecordedConsumer extends RecordedEntity {
    private Map<String, Object> arguments;
    private boolean autoAck;
    private Consumer consumer;
    private String consumerTag;
    private boolean exclusive;
    private String queue;

    public RecordedConsumer(AutorecoveringChannel autorecoveringChannel, String str) {
        super(autorecoveringChannel);
        this.queue = str;
    }

    public RecordedConsumer arguments(Map<String, Object> map) {
        this.arguments = map;
        return this;
    }

    public RecordedConsumer autoAck(boolean z) {
        this.autoAck = z;
        return this;
    }

    public RecordedConsumer consumer(Consumer consumer2) {
        this.consumer = consumer2;
        return this;
    }

    public RecordedConsumer consumerTag(String str) {
        this.consumerTag = str;
        return this;
    }

    public RecordedConsumer exclusive(boolean z) {
        this.exclusive = z;
        return this;
    }

    public String getConsumerTag() {
        return this.consumerTag;
    }

    public String getQueue() {
        return this.queue;
    }

    public String recover() throws IOException {
        String basicConsume = this.channel.basicConsume(this.queue, this.autoAck, this.consumerTag, false, this.exclusive, this.arguments, this.consumer);
        this.consumerTag = basicConsume;
        return basicConsume;
    }

    public void setQueue(String str) {
        this.queue = str;
    }
}
