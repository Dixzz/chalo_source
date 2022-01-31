package com.rabbitmq.client;

public interface ExceptionHandler {
    void handleBlockedListenerException(Connection connection, Throwable th);

    void handleChannelRecoveryException(Channel channel, Throwable th);

    void handleConfirmListenerException(Channel channel, Throwable th);

    void handleConnectionRecoveryException(Connection connection, Throwable th);

    void handleConsumerException(Channel channel, Throwable th, Consumer consumer, String str, String str2);

    void handleFlowListenerException(Channel channel, Throwable th);

    void handleReturnListenerException(Channel channel, Throwable th);

    void handleTopologyRecoveryException(Connection connection, Channel channel, TopologyRecoveryException topologyRecoveryException);

    void handleUnexpectedConnectionDriverException(Connection connection, Throwable th);
}
