package com.rabbitmq.client.impl;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.SocketConfigurator;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;

public class FrameHandlerFactory {
    private final SocketConfigurator configurator;
    private final int connectionTimeout;
    private final SocketFactory factory;
    private final boolean ssl;

    public FrameHandlerFactory(int i, SocketFactory socketFactory, SocketConfigurator socketConfigurator, boolean z) {
        this.connectionTimeout = i;
        this.factory = socketFactory;
        this.configurator = socketConfigurator;
        this.ssl = z;
    }

    private static void quietTrySocketClose(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    public FrameHandler create(Address address) throws IOException {
        String host = address.getHost();
        int portOrDefault = ConnectionFactory.portOrDefault(address.getPort(), this.ssl);
        Socket socket = null;
        try {
            socket = this.factory.createSocket();
            this.configurator.configure(socket);
            socket.connect(new InetSocketAddress(host, portOrDefault), this.connectionTimeout);
            return create(socket);
        } catch (IOException e) {
            quietTrySocketClose(socket);
            throw e;
        }
    }

    public FrameHandler create(Socket socket) throws IOException {
        return new SocketFrameHandler(socket);
    }
}
