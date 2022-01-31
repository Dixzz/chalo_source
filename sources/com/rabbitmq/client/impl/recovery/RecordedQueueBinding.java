package com.rabbitmq.client.impl.recovery;

import java.io.IOException;

public class RecordedQueueBinding extends RecordedBinding {
    public RecordedQueueBinding(AutorecoveringChannel autorecoveringChannel) {
        super(autorecoveringChannel);
    }

    @Override // com.rabbitmq.client.impl.recovery.RecordedBinding
    public void recover() throws IOException {
        this.channel.getDelegate().queueBind(getDestination(), getSource(), this.routingKey, this.arguments);
    }
}
