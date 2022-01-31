package com.rabbitmq.client.impl;

public class UnknownChannelException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private final int channelNumber;

    public UnknownChannelException(int i) {
        super(hj1.I("Unknown channel number ", i));
        this.channelNumber = i;
    }

    public int getChannelNumber() {
        return this.channelNumber;
    }
}
