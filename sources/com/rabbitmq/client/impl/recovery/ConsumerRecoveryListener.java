package com.rabbitmq.client.impl.recovery;

public interface ConsumerRecoveryListener {
    void consumerRecovered(String str, String str2);
}
