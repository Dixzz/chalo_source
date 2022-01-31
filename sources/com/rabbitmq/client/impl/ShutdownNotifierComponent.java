package com.rabbitmq.client.impl;

import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownNotifier;
import com.rabbitmq.client.ShutdownSignalException;
import java.util.ArrayList;
import java.util.List;

public class ShutdownNotifierComponent implements ShutdownNotifier {
    private final Object monitor = new Object();
    private volatile ShutdownSignalException shutdownCause = null;
    private final List<ShutdownListener> shutdownListeners = new ArrayList();

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void addShutdownListener(ShutdownListener shutdownListener) {
        ShutdownSignalException shutdownSignalException;
        synchronized (this.monitor) {
            shutdownSignalException = this.shutdownCause;
            this.shutdownListeners.add(shutdownListener);
        }
        if (shutdownSignalException != null) {
            shutdownListener.shutdownCompleted(shutdownSignalException);
        }
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public ShutdownSignalException getCloseReason() {
        ShutdownSignalException shutdownSignalException;
        synchronized (this.monitor) {
            shutdownSignalException = this.shutdownCause;
        }
        return shutdownSignalException;
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public boolean isOpen() {
        boolean z;
        synchronized (this.monitor) {
            z = this.shutdownCause == null;
        }
        return z;
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void notifyListeners() {
        ShutdownListener[] shutdownListenerArr;
        ShutdownSignalException shutdownSignalException;
        synchronized (this.monitor) {
            List<ShutdownListener> list = this.shutdownListeners;
            shutdownListenerArr = (ShutdownListener[]) list.toArray(new ShutdownListener[list.size()]);
            shutdownSignalException = this.shutdownCause;
        }
        for (ShutdownListener shutdownListener : shutdownListenerArr) {
            try {
                shutdownListener.shutdownCompleted(shutdownSignalException);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void removeShutdownListener(ShutdownListener shutdownListener) {
        synchronized (this.monitor) {
            this.shutdownListeners.remove(shutdownListener);
        }
    }

    public boolean setShutdownCauseIfOpen(ShutdownSignalException shutdownSignalException) {
        synchronized (this.monitor) {
            if (!isOpen()) {
                return false;
            }
            this.shutdownCause = shutdownSignalException;
            return true;
        }
    }
}
