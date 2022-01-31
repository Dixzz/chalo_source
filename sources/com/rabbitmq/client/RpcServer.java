package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;

public class RpcServer {
    private final Channel _channel;
    private QueueingConsumer _consumer;
    private boolean _mainloopRunning;
    private final String _queueName;

    public RpcServer(Channel channel) throws IOException {
        this(channel, null);
    }

    public void close() throws IOException {
        QueueingConsumer queueingConsumer = this._consumer;
        if (queueingConsumer != null) {
            this._channel.basicCancel(queueingConsumer.getConsumerTag());
            this._consumer = null;
        }
        terminateMainloop();
    }

    public Channel getChannel() {
        return this._channel;
    }

    public String getQueueName() {
        return this._queueName;
    }

    public byte[] handleCall(QueueingConsumer.Delivery delivery, AMQP.BasicProperties basicProperties) {
        return handleCall(delivery.getProperties(), delivery.getBody(), basicProperties);
    }

    public byte[] handleCall(byte[] bArr, AMQP.BasicProperties basicProperties) {
        return new byte[0];
    }

    public void handleCast(QueueingConsumer.Delivery delivery) {
        handleCast(delivery.getProperties(), delivery.getBody());
    }

    public void handleCast(byte[] bArr) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|12|9|0|1) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        return r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0004 A[SYNTHETIC, Splitter:B:3:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.rabbitmq.client.ShutdownSignalException mainloop() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = r4._mainloopRunning     // Catch:{ ShutdownSignalException -> 0x001e }
            if (r0 == 0) goto L_0x001c
            com.rabbitmq.client.QueueingConsumer r0 = r4._consumer     // Catch:{ InterruptedException -> 0x0000 }
            com.rabbitmq.client.QueueingConsumer$Delivery r0 = r0.nextDelivery()     // Catch:{ InterruptedException -> 0x0000 }
            r4.processRequest(r0)
            com.rabbitmq.client.Channel r1 = r4._channel
            com.rabbitmq.client.Envelope r0 = r0.getEnvelope()
            long r2 = r0.getDeliveryTag()
            r0 = 0
            r1.basicAck(r2, r0)
            goto L_0x0000
        L_0x001c:
            r0 = 0
            return r0
        L_0x001e:
            r0 = move-exception
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.RpcServer.mainloop():com.rabbitmq.client.ShutdownSignalException");
    }

    public void processRequest(QueueingConsumer.Delivery delivery) throws IOException {
        AMQP.BasicProperties properties = delivery.getProperties();
        String correlationId = properties.getCorrelationId();
        String replyTo = properties.getReplyTo();
        if (correlationId == null || replyTo == null) {
            handleCast(delivery);
            return;
        }
        AMQP.BasicProperties build = new AMQP.BasicProperties.Builder().correlationId(correlationId).build();
        this._channel.basicPublish("", replyTo, build, handleCall(delivery, build));
    }

    public QueueingConsumer setupConsumer() throws IOException {
        QueueingConsumer queueingConsumer = new QueueingConsumer(this._channel);
        this._channel.basicConsume(this._queueName, queueingConsumer);
        return queueingConsumer;
    }

    public void terminateMainloop() {
        this._mainloopRunning = false;
    }

    public RpcServer(Channel channel, String str) throws IOException {
        this._mainloopRunning = true;
        this._channel = channel;
        if (str == null || str.equals("")) {
            this._queueName = channel.queueDeclare().getQueue();
        } else {
            this._queueName = str;
        }
        this._consumer = setupConsumer();
    }

    public byte[] handleCall(AMQP.BasicProperties basicProperties, byte[] bArr, AMQP.BasicProperties basicProperties2) {
        return handleCall(bArr, basicProperties2);
    }

    public void handleCast(AMQP.BasicProperties basicProperties, byte[] bArr) {
        handleCast(bArr);
    }
}
