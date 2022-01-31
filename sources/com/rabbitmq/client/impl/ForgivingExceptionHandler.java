package com.rabbitmq.client.impl;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.ExceptionHandler;
import com.rabbitmq.client.TopologyRecoveryException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;

public class ForgivingExceptionHandler implements ExceptionHandler {
    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleBlockedListenerException(Connection connection, Throwable th) {
        handleConnectionKiller(connection, th, "BlockedListener");
    }

    public void handleChannelKiller(Channel channel, Throwable th, String str) {
        PrintStream printStream = System.err;
        printStream.println(getClass().getName() + ": " + str + " threw an exception for channel " + channel + ProductDiscountsObject.KEY_DELIMITER);
        th.printStackTrace();
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleChannelRecoveryException(Channel channel, Throwable th) {
        PrintStream printStream = System.err;
        StringBuilder i0 = hj1.i0("Caught an exception when recovering channel ");
        i0.append(channel.getChannelNumber());
        printStream.println(i0.toString());
        th.printStackTrace(System.err);
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleConfirmListenerException(Channel channel, Throwable th) {
        handleChannelKiller(channel, th, "ConfirmListener.handle{N,A}ck");
    }

    public void handleConnectionKiller(Connection connection, Throwable th, String str) {
        PrintStream printStream = System.err;
        printStream.println("DefaultExceptionHandler: " + str + " threw an exception for connection " + connection + ProductDiscountsObject.KEY_DELIMITER);
        th.printStackTrace();
        try {
            connection.close(AMQP.REPLY_SUCCESS, "Closed due to exception from " + str);
        } catch (AlreadyClosedException unused) {
        } catch (IOException e) {
            PrintStream printStream2 = System.err;
            printStream2.println("Failure during close of connection " + connection + " after " + th + ProductDiscountsObject.KEY_DELIMITER);
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error closing connection for ");
            sb.append(str);
            connection.abort(AMQP.INTERNAL_ERROR, sb.toString());
        }
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleConnectionRecoveryException(Connection connection, Throwable th) {
        if (!(th instanceof ConnectException)) {
            System.err.println("Caught an exception during connection recovery!");
            th.printStackTrace(System.err);
        }
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleConsumerException(Channel channel, Throwable th, Consumer consumer, String str, String str2) {
        handleChannelKiller(channel, th, "Consumer " + consumer + " (" + str + ")" + " method " + str2 + " for channel " + channel);
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleFlowListenerException(Channel channel, Throwable th) {
        handleChannelKiller(channel, th, "FlowListener.handleFlow");
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleReturnListenerException(Channel channel, Throwable th) {
        handleChannelKiller(channel, th, "ReturnListener.handleReturn");
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleTopologyRecoveryException(Connection connection, Channel channel, TopologyRecoveryException topologyRecoveryException) {
        PrintStream printStream = System.err;
        StringBuilder i0 = hj1.i0("Caught an exception when recovering topology ");
        i0.append(topologyRecoveryException.getMessage());
        printStream.println(i0.toString());
        topologyRecoveryException.printStackTrace(System.err);
    }

    @Override // com.rabbitmq.client.ExceptionHandler
    public void handleUnexpectedConnectionDriverException(Connection connection, Throwable th) {
    }
}
