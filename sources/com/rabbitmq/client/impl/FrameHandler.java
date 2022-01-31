package com.rabbitmq.client.impl;

import java.io.IOException;
import java.net.SocketException;

public interface FrameHandler extends NetworkConnection {
    void close();

    void flush() throws IOException;

    int getTimeout() throws SocketException;

    Frame readFrame() throws IOException;

    void sendHeader() throws IOException;

    void setTimeout(int i) throws SocketException;

    void writeFrame(Frame frame) throws IOException;
}
