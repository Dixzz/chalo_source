package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.MethodArgumentReader;
import com.rabbitmq.client.impl.MethodArgumentWriter;
import com.rabbitmq.client.impl.ValueReader;
import com.rabbitmq.client.impl.ValueWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapRpcServer extends RpcServer {
    public MapRpcServer(Channel channel) throws IOException {
        super(channel);
    }

    public static Map<String, Object> decode(byte[] bArr) throws IOException {
        return new MethodArgumentReader(new ValueReader(new DataInputStream(new ByteArrayInputStream(bArr)))).readTable();
    }

    public static byte[] encode(Map<String, Object> map) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MethodArgumentWriter methodArgumentWriter = new MethodArgumentWriter(new ValueWriter(new DataOutputStream(byteArrayOutputStream)));
        methodArgumentWriter.writeTable(map);
        methodArgumentWriter.flush();
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.rabbitmq.client.RpcServer
    public byte[] handleCall(byte[] bArr, AMQP.BasicProperties basicProperties) {
        try {
            return encode(handleMapCall(decode(bArr), basicProperties));
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    @Override // com.rabbitmq.client.RpcServer
    public void handleCast(byte[] bArr) {
        try {
            handleMapCast(decode(bArr));
        } catch (IOException unused) {
        }
    }

    public Map<String, Object> handleMapCall(Map<String, Object> map, AMQP.BasicProperties basicProperties) {
        return handleMapCall(map);
    }

    public void handleMapCast(Map<String, Object> map) {
    }

    public MapRpcServer(Channel channel, String str) throws IOException {
        super(channel, str);
    }

    public Map<String, Object> handleMapCall(Map<String, Object> map) {
        return new HashMap();
    }
}
