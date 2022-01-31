package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import java.io.IOException;

public interface ReturnListener {
    void handleReturn(int i, String str, String str2, String str3, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException;
}
