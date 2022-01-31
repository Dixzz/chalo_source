package com.rabbitmq.client;

public interface RecoveryListener {
    void handleRecovery(Recoverable recoverable);
}
