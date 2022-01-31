package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import java.io.IOException;

public class DefaultConsumer implements Consumer {
    private final Channel _channel;
    private volatile String _consumerTag;

    public DefaultConsumer(Channel channel) {
        this._channel = channel;
    }

    public Channel getChannel() {
        return this._channel;
    }

    public String getConsumerTag() {
        return this._consumerTag;
    }

    @Override // com.rabbitmq.client.Consumer
    public void handleCancel(String str) throws IOException {
    }

    @Override // com.rabbitmq.client.Consumer
    public void handleCancelOk(String str) {
    }

    @Override // com.rabbitmq.client.Consumer
    public void handleConsumeOk(String str) {
        this._consumerTag = str;
    }

    @Override // com.rabbitmq.client.Consumer
    public void handleDelivery(String str, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
    }

    @Override // com.rabbitmq.client.Consumer
    public void handleRecoverOk(String str) {
    }

    @Override // com.rabbitmq.client.Consumer
    public void handleShutdownSignal(String str, ShutdownSignalException shutdownSignalException) {
    }
}
