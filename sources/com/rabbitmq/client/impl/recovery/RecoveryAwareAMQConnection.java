package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.FrameHandler;
import java.util.concurrent.ThreadFactory;

public class RecoveryAwareAMQConnection extends AMQConnection {
    public RecoveryAwareAMQConnection(ConnectionParams connectionParams, FrameHandler frameHandler) {
        super(connectionParams, frameHandler);
    }

    @Override // com.rabbitmq.client.impl.AMQConnection
    public RecoveryAwareChannelManager instantiateChannelManager(int i, ThreadFactory threadFactory) {
        return new RecoveryAwareChannelManager(this._workService, i, threadFactory);
    }
}
