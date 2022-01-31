package com.rabbitmq.client.impl;

import com.rabbitmq.client.BasicProperties;
import java.io.DataInputStream;
import java.io.IOException;

public abstract class AMQBasicProperties extends AMQContentHeader implements BasicProperties {
    public AMQBasicProperties() {
    }

    @Override // java.lang.Object, com.rabbitmq.client.impl.AMQContentHeader
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public AMQBasicProperties(DataInputStream dataInputStream) throws IOException {
        super(dataInputStream);
    }
}
