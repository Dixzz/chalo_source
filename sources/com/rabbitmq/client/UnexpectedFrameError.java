package com.rabbitmq.client;

import com.rabbitmq.client.impl.Frame;

public class UnexpectedFrameError extends Error {
    private static final long serialVersionUID = 1;
    private final int _expectedFrameType;
    private final Frame _frame;

    public UnexpectedFrameError(Frame frame, int i) {
        super("Received frame: " + frame + ", expected type " + i);
        this._frame = frame;
        this._expectedFrameType = i;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getExpectedFrameType() {
        return this._expectedFrameType;
    }

    public Frame getReceivedFrame() {
        return this._frame;
    }
}
