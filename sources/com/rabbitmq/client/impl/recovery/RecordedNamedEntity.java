package com.rabbitmq.client.impl.recovery;

public class RecordedNamedEntity extends RecordedEntity {
    public String name;

    public RecordedNamedEntity(AutorecoveringChannel autorecoveringChannel, String str) {
        super(autorecoveringChannel);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
