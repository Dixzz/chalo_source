package com.rabbitmq.client;

import java.io.IOException;
import java.net.Socket;

public interface SocketConfigurator {
    void configure(Socket socket) throws IOException;
}
