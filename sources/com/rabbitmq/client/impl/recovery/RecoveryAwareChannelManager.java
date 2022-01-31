package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ChannelManager;
import com.rabbitmq.client.impl.ChannelN;
import com.rabbitmq.client.impl.ConsumerWorkService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class RecoveryAwareChannelManager extends ChannelManager {
    public RecoveryAwareChannelManager(ConsumerWorkService consumerWorkService, int i) {
        this(consumerWorkService, i, Executors.defaultThreadFactory());
    }

    @Override // com.rabbitmq.client.impl.ChannelManager
    public ChannelN instantiateChannel(AMQConnection aMQConnection, int i, ConsumerWorkService consumerWorkService) {
        return new RecoveryAwareChannelN(aMQConnection, i, consumerWorkService);
    }

    public RecoveryAwareChannelManager(ConsumerWorkService consumerWorkService, int i, ThreadFactory threadFactory) {
        super(consumerWorkService, i, threadFactory);
    }
}
