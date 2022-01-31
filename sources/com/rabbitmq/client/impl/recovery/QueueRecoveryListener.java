package com.rabbitmq.client.impl.recovery;

public interface QueueRecoveryListener {
    void queueRecovered(String str, String str2);
}
