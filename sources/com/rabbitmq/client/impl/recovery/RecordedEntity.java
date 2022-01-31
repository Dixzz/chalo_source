package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.Channel;

public class RecordedEntity {
    public final AutorecoveringChannel channel;

    public RecordedEntity(AutorecoveringChannel autorecoveringChannel) {
        this.channel = autorecoveringChannel;
    }

    public AutorecoveringChannel getChannel() {
        return this.channel;
    }

    public Channel getDelegateChannel() {
        return this.channel.getDelegate();
    }
}
