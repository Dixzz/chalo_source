package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.FrameHandlerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class RecoveryAwareAMQConnectionFactory {
    private final List<Address> addrs;
    private final FrameHandlerFactory factory;
    private final ConnectionParams params;

    public RecoveryAwareAMQConnectionFactory(ConnectionParams connectionParams, FrameHandlerFactory frameHandlerFactory, List<Address> list) {
        this.params = connectionParams;
        this.factory = frameHandlerFactory;
        this.addrs = list;
    }

    private List<Address> shuffle(List<Address> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public RecoveryAwareAMQConnection newConnection() throws IOException, TimeoutException {
        IOException e = null;
        for (Address address : shuffle(this.addrs)) {
            try {
                RecoveryAwareAMQConnection recoveryAwareAMQConnection = new RecoveryAwareAMQConnection(this.params, this.factory.create(address));
                recoveryAwareAMQConnection.start();
                return recoveryAwareAMQConnection;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
        throw new IOException("failed to connect");
    }
}
