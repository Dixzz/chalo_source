package com.rabbitmq.client.impl.recovery;

import java.io.IOException;

public class RecordedExchangeBinding extends RecordedBinding {
    public RecordedExchangeBinding(AutorecoveringChannel autorecoveringChannel) {
        super(autorecoveringChannel);
    }

    @Override // com.rabbitmq.client.impl.recovery.RecordedBinding
    public void recover() throws IOException {
        this.channel.getDelegate().exchangeBind(this.destination, this.source, this.routingKey, this.arguments);
    }
}
