package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import java.io.IOException;

public class StringRpcServer extends RpcServer {
    public static final String STRING_ENCODING = "UTF-8";

    public StringRpcServer(Channel channel) throws IOException {
        super(channel);
    }

    @Override // com.rabbitmq.client.RpcServer
    public byte[] handleCall(byte[] bArr, AMQP.BasicProperties basicProperties) {
        String str;
        try {
            str = new String(bArr, STRING_ENCODING);
        } catch (IOException unused) {
            str = new String(bArr);
        }
        String handleStringCall = handleStringCall(str, basicProperties);
        try {
            return handleStringCall.getBytes(STRING_ENCODING);
        } catch (IOException unused2) {
            return handleStringCall.getBytes();
        }
    }

    @Override // com.rabbitmq.client.RpcServer
    public void handleCast(byte[] bArr) {
        try {
            handleStringCast(new String(bArr, STRING_ENCODING));
        } catch (IOException unused) {
            handleStringCast(new String(bArr));
        }
    }

    public String handleStringCall(String str) {
        return "";
    }

    public String handleStringCall(String str, AMQP.BasicProperties basicProperties) {
        return handleStringCall(str);
    }

    public void handleStringCast(String str) {
    }

    public StringRpcServer(Channel channel, String str) throws IOException {
        super(channel, str);
    }
}
