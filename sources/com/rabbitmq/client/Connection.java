package com.rabbitmq.client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

public interface Connection extends ShutdownNotifier {
    void abort();

    void abort(int i);

    void abort(int i, String str);

    void abort(int i, String str, int i2);

    void addBlockedListener(BlockedListener blockedListener);

    void clearBlockedListeners();

    void close() throws IOException;

    void close(int i) throws IOException;

    void close(int i, String str) throws IOException;

    void close(int i, String str, int i2) throws IOException;

    Channel createChannel() throws IOException;

    Channel createChannel(int i) throws IOException;

    InetAddress getAddress();

    int getChannelMax();

    Map<String, Object> getClientProperties();

    String getClientProvidedName();

    ExceptionHandler getExceptionHandler();

    int getFrameMax();

    int getHeartbeat();

    int getPort();

    Map<String, Object> getServerProperties();

    boolean removeBlockedListener(BlockedListener blockedListener);
}
