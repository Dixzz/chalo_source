package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.MethodArgumentReader;
import com.rabbitmq.client.impl.MethodArgumentWriter;
import com.rabbitmq.client.impl.ValueReader;
import com.rabbitmq.client.impl.ValueWriter;
import com.rabbitmq.utility.BlockingCell;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class RpcClient {
    public static final int NO_TIMEOUT = -1;
    private final Channel _channel;
    private DefaultConsumer _consumer;
    private final Map<String, BlockingCell<Object>> _continuationMap;
    private int _correlationId;
    private final String _exchange;
    private final String _replyTo;
    private final String _routingKey;
    private final int _timeout;

    public RpcClient(Channel channel, String str, String str2, String str3, int i) throws IOException {
        this._continuationMap = new HashMap();
        this._channel = channel;
        this._exchange = str;
        this._routingKey = str2;
        this._replyTo = str3;
        if (i >= -1) {
            this._timeout = i;
            this._correlationId = 0;
            this._consumer = setupConsumer();
            return;
        }
        throw new IllegalArgumentException("Timeout arguument must be NO_TIMEOUT(-1) or non-negative.");
    }

    public void checkConsumer() throws IOException {
        if (this._consumer == null) {
            throw new EOFException("RpcClient is closed");
        }
    }

    public void close() throws IOException {
        DefaultConsumer defaultConsumer = this._consumer;
        if (defaultConsumer != null) {
            this._channel.basicCancel(defaultConsumer.getConsumerTag());
            this._consumer = null;
        }
    }

    public Channel getChannel() {
        return this._channel;
    }

    public Consumer getConsumer() {
        return this._consumer;
    }

    public Map<String, BlockingCell<Object>> getContinuationMap() {
        return this._continuationMap;
    }

    public int getCorrelationId() {
        return this._correlationId;
    }

    public String getExchange() {
        return this._exchange;
    }

    public String getRoutingKey() {
        return this._routingKey;
    }

    public Map<String, Object> mapCall(Map<String, Object> map) throws IOException, ShutdownSignalException, TimeoutException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MethodArgumentWriter methodArgumentWriter = new MethodArgumentWriter(new ValueWriter(new DataOutputStream(byteArrayOutputStream)));
        methodArgumentWriter.writeTable(map);
        methodArgumentWriter.flush();
        return new MethodArgumentReader(new ValueReader(new DataInputStream(new ByteArrayInputStream(primitiveCall(byteArrayOutputStream.toByteArray()))))).readTable();
    }

    public byte[] primitiveCall(AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException, ShutdownSignalException, TimeoutException {
        AMQP.BasicProperties build;
        checkConsumer();
        BlockingCell<Object> blockingCell = new BlockingCell<>();
        synchronized (this._continuationMap) {
            this._correlationId++;
            String str = "" + this._correlationId;
            build = (basicProperties == null ? new AMQP.BasicProperties.Builder() : basicProperties.builder()).correlationId(str).replyTo(this._replyTo).build();
            this._continuationMap.put(str, blockingCell);
        }
        publish(build, bArr);
        Object uninterruptibleGet = blockingCell.uninterruptibleGet(this._timeout);
        if (!(uninterruptibleGet instanceof ShutdownSignalException)) {
            return (byte[]) uninterruptibleGet;
        }
        ShutdownSignalException shutdownSignalException = (ShutdownSignalException) uninterruptibleGet;
        ShutdownSignalException shutdownSignalException2 = new ShutdownSignalException(shutdownSignalException.isHardError(), shutdownSignalException.isInitiatedByApplication(), shutdownSignalException.getReason(), shutdownSignalException.getReference());
        shutdownSignalException2.initCause(shutdownSignalException);
        throw shutdownSignalException2;
    }

    public void publish(AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        this._channel.basicPublish(this._exchange, this._routingKey, basicProperties, bArr);
    }

    public DefaultConsumer setupConsumer() throws IOException {
        AnonymousClass1 r0 = new DefaultConsumer(this._channel) {
            /* class com.rabbitmq.client.RpcClient.AnonymousClass1 */

            @Override // com.rabbitmq.client.DefaultConsumer, com.rabbitmq.client.Consumer
            public void handleDelivery(String str, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
                synchronized (RpcClient.this._continuationMap) {
                    String correlationId = basicProperties.getCorrelationId();
                    RpcClient.this._continuationMap.remove(correlationId);
                    ((BlockingCell) RpcClient.this._continuationMap.get(correlationId)).set(bArr);
                }
            }

            @Override // com.rabbitmq.client.DefaultConsumer, com.rabbitmq.client.Consumer
            public void handleShutdownSignal(String str, ShutdownSignalException shutdownSignalException) {
                synchronized (RpcClient.this._continuationMap) {
                    for (Map.Entry entry : RpcClient.this._continuationMap.entrySet()) {
                        ((BlockingCell) entry.getValue()).set(shutdownSignalException);
                    }
                    RpcClient.this._consumer = null;
                }
            }
        };
        this._channel.basicConsume(this._replyTo, true, r0);
        return r0;
    }

    public String stringCall(String str) throws IOException, ShutdownSignalException, TimeoutException {
        byte[] bArr;
        try {
            bArr = str.getBytes(StringRpcServer.STRING_ENCODING);
        } catch (IOException unused) {
            bArr = str.getBytes();
        }
        byte[] primitiveCall = primitiveCall(bArr);
        try {
            return new String(primitiveCall, StringRpcServer.STRING_ENCODING);
        } catch (IOException unused2) {
            return new String(primitiveCall);
        }
    }

    public Map<String, Object> mapCall(Object[] objArr) throws IOException, ShutdownSignalException, TimeoutException {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < objArr.length; i += 2) {
            hashMap.put((String) objArr[i], objArr[i + 1]);
        }
        return mapCall(hashMap);
    }

    public RpcClient(Channel channel, String str, String str2, String str3) throws IOException {
        this(channel, str, str2, str3, -1);
    }

    public RpcClient(Channel channel, String str, String str2) throws IOException {
        this(channel, str, str2, "amq.rabbitmq.reply-to", -1);
    }

    public RpcClient(Channel channel, String str, String str2, int i) throws IOException {
        this(channel, str, str2, "amq.rabbitmq.reply-to", i);
    }

    public byte[] primitiveCall(byte[] bArr) throws IOException, ShutdownSignalException, TimeoutException {
        return primitiveCall(null, bArr);
    }
}
