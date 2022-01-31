package com.rabbitmq.client.impl;

import java.net.InetAddress;

public interface NetworkConnection {
    InetAddress getAddress();

    InetAddress getLocalAddress();

    int getLocalPort();

    int getPort();
}
