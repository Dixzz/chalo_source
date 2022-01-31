package com.rabbitmq.client.impl;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.ExceptionHandler;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

public class StrictExceptionHandler extends ForgivingExceptionHandler implements ExceptionHandler {
    @Override // com.rabbitmq.client.impl.ForgivingExceptionHandler, com.rabbitmq.client.ExceptionHandler
    public void handleBlockedListenerException(Connection connection, Throwable th) {
        handleConnectionKiller(connection, th, "BlockedListener");
    }

    @Override // com.rabbitmq.client.impl.ForgivingExceptionHandler
    public void handleChannelKiller(Channel channel, Throwable th, String str) {
        PrintStream printStream = System.err;
        printStream.println(getClass().getName() + ": " + str + " threw an exception for channel " + channel + ProductDiscountsObject.KEY_DELIMITER);
        th.printStackTrace();
        try {
            channel.close(AMQP.REPLY_SUCCESS, "Closed due to exception from " + str);
        } catch (AlreadyClosedException | TimeoutException unused) {
        } catch (IOException e) {
            PrintStream printStream2 = System.err;
            printStream2.println("Failure during close of channel " + channel + " after " + th + ProductDiscountsObject.KEY_DELIMITER);
            e.printStackTrace();
            Connection connection = channel.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error closing channel for ");
            sb.append(str);
            connection.abort(AMQP.INTERNAL_ERROR, sb.toString());
        }
    }

    @Override // com.rabbitmq.client.impl.ForgivingExceptionHandler, com.rabbitmq.client.ExceptionHandler
    public void handleConfirmListenerException(Channel channel, Throwable th) {
        handleChannelKiller(channel, th, "ConfirmListener.handle{N,A}ck");
    }

    @Override // com.rabbitmq.client.impl.ForgivingExceptionHandler, com.rabbitmq.client.ExceptionHandler
    public void handleConsumerException(Channel channel, Throwable th, Consumer consumer, String str, String str2) {
        handleChannelKiller(channel, th, "Consumer " + consumer + " (" + str + ")" + " method " + str2 + " for channel " + channel);
    }

    @Override // com.rabbitmq.client.impl.ForgivingExceptionHandler, com.rabbitmq.client.ExceptionHandler
    public void handleFlowListenerException(Channel channel, Throwable th) {
        handleChannelKiller(channel, th, "FlowListener.handleFlow");
    }

    @Override // com.rabbitmq.client.impl.ForgivingExceptionHandler, com.rabbitmq.client.ExceptionHandler
    public void handleReturnListenerException(Channel channel, Throwable th) {
        handleChannelKiller(channel, th, "ReturnListener.handleReturn");
    }
}
