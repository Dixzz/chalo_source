package com.rabbitmq.client;

public class TopologyRecoveryException extends Exception {
    public TopologyRecoveryException(String str, Throwable th) {
        super(str, th);
    }
}
