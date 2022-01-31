package com.rabbitmq.client;

import java.io.IOException;
import java.net.Socket;

public class DefaultSocketConfigurator implements SocketConfigurator {
    @Override // com.rabbitmq.client.SocketConfigurator
    public void configure(Socket socket) throws IOException {
        socket.setTcpNoDelay(true);
    }
}
