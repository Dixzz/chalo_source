package com.rabbitmq.client;

public interface Recoverable {
    void addRecoveryListener(RecoveryListener recoveryListener);

    void removeRecoveryListener(RecoveryListener recoveryListener);
}
