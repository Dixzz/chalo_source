package com.rabbitmq.client.impl;

import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Command;
import com.rabbitmq.client.Method;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.utility.BlockingValueOrException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class AMQChannel extends ShutdownNotifierComponent {
    private RpcContinuation _activeRpc = null;
    public volatile boolean _blockContent = false;
    public final Object _channelMutex = new Object();
    private final int _channelNumber;
    private AMQCommand _command = new AMQCommand();
    private final AMQConnection _connection;

    public static abstract class BlockingRpcContinuation<T> implements RpcContinuation {
        public final BlockingValueOrException<T, ShutdownSignalException> _blocker = new BlockingValueOrException<>();

        public T getReply() throws ShutdownSignalException {
            return this._blocker.uninterruptibleGetValue();
        }

        @Override // com.rabbitmq.client.impl.AMQChannel.RpcContinuation
        public void handleCommand(AMQCommand aMQCommand) {
            this._blocker.setValue(transformReply(aMQCommand));
        }

        @Override // com.rabbitmq.client.impl.AMQChannel.RpcContinuation
        public void handleShutdownSignal(ShutdownSignalException shutdownSignalException) {
            this._blocker.setException(shutdownSignalException);
        }

        public abstract T transformReply(AMQCommand aMQCommand);

        public T getReply(int i) throws ShutdownSignalException, TimeoutException {
            return this._blocker.uninterruptibleGetValue(i);
        }
    }

    public interface RpcContinuation {
        void handleCommand(AMQCommand aMQCommand);

        void handleShutdownSignal(ShutdownSignalException shutdownSignalException);
    }

    public static class SimpleBlockingRpcContinuation extends BlockingRpcContinuation<AMQCommand> {
        @Override // com.rabbitmq.client.impl.AMQChannel.BlockingRpcContinuation
        public AMQCommand transformReply(AMQCommand aMQCommand) {
            return aMQCommand;
        }
    }

    public AMQChannel(AMQConnection aMQConnection, int i) {
        this._connection = aMQConnection;
        this._channelNumber = i;
    }

    private AMQCommand privateRpc(Method method) throws IOException, ShutdownSignalException {
        SimpleBlockingRpcContinuation simpleBlockingRpcContinuation = new SimpleBlockingRpcContinuation();
        rpc(method, simpleBlockingRpcContinuation);
        return (AMQCommand) simpleBlockingRpcContinuation.getReply();
    }

    public static IOException wrap(ShutdownSignalException shutdownSignalException) {
        return wrap(shutdownSignalException, null);
    }

    public void enqueueRpc(RpcContinuation rpcContinuation) {
        synchronized (this._channelMutex) {
            boolean z = false;
            while (this._activeRpc != null) {
                try {
                    this._channelMutex.wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this._activeRpc = rpcContinuation;
        }
    }

    public void ensureIsOpen() throws AlreadyClosedException {
        if (!isOpen()) {
            throw new AlreadyClosedException(getCloseReason());
        }
    }

    public AMQCommand exnWrappingRpc(Method method) throws IOException {
        try {
            return privateRpc(method);
        } catch (AlreadyClosedException e) {
            throw e;
        } catch (ShutdownSignalException e2) {
            throw wrap(e2);
        }
    }

    public int getChannelNumber() {
        return this._channelNumber;
    }

    public AMQConnection getConnection() {
        return this._connection;
    }

    public void handleCompleteInboundCommand(AMQCommand aMQCommand) throws IOException {
        if (!processAsync(aMQCommand)) {
            nextOutstandingRpc().handleCommand(aMQCommand);
            markRpcFinished();
        }
    }

    public void handleFrame(Frame frame) throws IOException {
        AMQCommand aMQCommand = this._command;
        if (aMQCommand.handleFrame(frame)) {
            this._command = new AMQCommand();
            handleCompleteInboundCommand(aMQCommand);
        }
    }

    public boolean isOutstandingRpc() {
        boolean z;
        synchronized (this._channelMutex) {
            z = this._activeRpc != null;
        }
        return z;
    }

    public void markRpcFinished() {
    }

    public RpcContinuation nextOutstandingRpc() {
        RpcContinuation rpcContinuation;
        synchronized (this._channelMutex) {
            rpcContinuation = this._activeRpc;
            this._activeRpc = null;
            this._channelMutex.notifyAll();
        }
        return rpcContinuation;
    }

    public void notifyOutstandingRpc(ShutdownSignalException shutdownSignalException) {
        RpcContinuation nextOutstandingRpc = nextOutstandingRpc();
        if (nextOutstandingRpc != null) {
            nextOutstandingRpc.handleShutdownSignal(shutdownSignalException);
        }
    }

    public abstract boolean processAsync(Command command) throws IOException;

    public void processShutdownSignal(ShutdownSignalException shutdownSignalException, boolean z, boolean z2) {
        try {
            synchronized (this._channelMutex) {
                if (!setShutdownCauseIfOpen(shutdownSignalException)) {
                    if (!z) {
                        throw new AlreadyClosedException(getCloseReason());
                    }
                }
                this._channelMutex.notifyAll();
            }
        } finally {
            if (z2) {
                notifyOutstandingRpc(shutdownSignalException);
            }
        }
    }

    public void quiescingRpc(Method method, RpcContinuation rpcContinuation) throws IOException {
        synchronized (this._channelMutex) {
            enqueueRpc(rpcContinuation);
            quiescingTransmit(method);
        }
    }

    public void quiescingTransmit(Method method) throws IOException {
        synchronized (this._channelMutex) {
            quiescingTransmit(new AMQCommand(method));
        }
    }

    public AMQCommand rpc(Method method) throws IOException, ShutdownSignalException {
        return privateRpc(method);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("AMQChannel(");
        i0.append(this._connection);
        i0.append(",");
        return hj1.X(i0, this._channelNumber, ")");
    }

    public void transmit(Method method) throws IOException {
        synchronized (this._channelMutex) {
            transmit(new AMQCommand(method));
        }
    }

    public static IOException wrap(ShutdownSignalException shutdownSignalException, String str) {
        IOException iOException = new IOException(str);
        iOException.initCause(shutdownSignalException);
        return iOException;
    }

    public AMQCommand rpc(Method method, int i) throws IOException, ShutdownSignalException, TimeoutException {
        return privateRpc(method, i);
    }

    public void rpc(Method method, RpcContinuation rpcContinuation) throws IOException {
        synchronized (this._channelMutex) {
            ensureIsOpen();
            quiescingRpc(method, rpcContinuation);
        }
    }

    private AMQCommand privateRpc(Method method, int i) throws IOException, ShutdownSignalException, TimeoutException {
        SimpleBlockingRpcContinuation simpleBlockingRpcContinuation = new SimpleBlockingRpcContinuation();
        rpc(method, simpleBlockingRpcContinuation);
        return (AMQCommand) simpleBlockingRpcContinuation.getReply(i);
    }

    public void quiescingTransmit(AMQCommand aMQCommand) throws IOException {
        synchronized (this._channelMutex) {
            if (aMQCommand.getMethod().hasContent()) {
                while (this._blockContent) {
                    try {
                        this._channelMutex.wait();
                    } catch (InterruptedException unused) {
                    }
                    ensureIsOpen();
                }
            }
            aMQCommand.transmit(this);
        }
    }

    public void transmit(AMQCommand aMQCommand) throws IOException {
        synchronized (this._channelMutex) {
            ensureIsOpen();
            quiescingTransmit(aMQCommand);
        }
    }
}
