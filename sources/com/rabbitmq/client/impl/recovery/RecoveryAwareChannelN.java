package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.Command;
import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.client.impl.ChannelN;
import com.rabbitmq.client.impl.ConsumerWorkService;
import java.io.IOException;

public class RecoveryAwareChannelN extends ChannelN {
    private long activeDeliveryTagOffset = 0;
    private long maxSeenDeliveryTag = 0;

    public RecoveryAwareChannelN(AMQConnection aMQConnection, int i, ConsumerWorkService consumerWorkService) {
        super(aMQConnection, i, consumerWorkService);
    }

    private AMQImpl.Basic.Deliver offsetDeliveryTag(AMQImpl.Basic.Deliver deliver) {
        return new AMQImpl.Basic.Deliver(deliver.getConsumerTag(), deliver.getDeliveryTag() + this.activeDeliveryTagOffset, deliver.getRedelivered(), deliver.getExchange(), deliver.getRoutingKey());
    }

    @Override // com.rabbitmq.client.impl.ChannelN, com.rabbitmq.client.Channel
    public void basicAck(long j, boolean z) throws IOException {
        long j2 = j - this.activeDeliveryTagOffset;
        if (j2 > 0) {
            super.basicAck(j2, z);
        }
    }

    @Override // com.rabbitmq.client.impl.ChannelN, com.rabbitmq.client.Channel
    public void basicNack(long j, boolean z, boolean z2) throws IOException {
        long j2 = j - this.activeDeliveryTagOffset;
        if (j2 > 0) {
            super.basicNack(j2, z, z2);
        }
    }

    @Override // com.rabbitmq.client.impl.ChannelN, com.rabbitmq.client.Channel
    public void basicReject(long j, boolean z) throws IOException {
        long j2 = j - this.activeDeliveryTagOffset;
        if (j2 > 0) {
            super.basicReject(j2, z);
        }
    }

    public long getActiveDeliveryTagOffset() {
        return this.activeDeliveryTagOffset;
    }

    public long getMaxSeenDeliveryTag() {
        return this.maxSeenDeliveryTag;
    }

    public void inheritOffsetFrom(RecoveryAwareChannelN recoveryAwareChannelN) {
        this.activeDeliveryTagOffset = recoveryAwareChannelN.getMaxSeenDeliveryTag() + recoveryAwareChannelN.getActiveDeliveryTagOffset();
        this.maxSeenDeliveryTag = 0;
    }

    @Override // com.rabbitmq.client.impl.ChannelN
    public void processDelivery(Command command, AMQImpl.Basic.Deliver deliver) {
        long deliveryTag = deliver.getDeliveryTag();
        if (deliveryTag > this.maxSeenDeliveryTag) {
            this.maxSeenDeliveryTag = deliveryTag;
        }
        super.processDelivery(command, offsetDeliveryTag(deliver));
    }
}
