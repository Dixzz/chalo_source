package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.BlockedListener;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ExceptionHandler;
import com.rabbitmq.client.MissedHeartbeatException;
import com.rabbitmq.client.Recoverable;
import com.rabbitmq.client.RecoveryListener;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.TopologyRecoveryException;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.FrameHandlerFactory;
import com.rabbitmq.client.impl.NetworkConnection;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class AutorecoveringConnection implements Connection, Recoverable, NetworkConnection {
    private final List<BlockedListener> blockedListeners = new ArrayList();
    private final RecoveryAwareAMQConnectionFactory cf;
    private final Map<Integer, AutorecoveringChannel> channels;
    private final List<ConsumerRecoveryListener> consumerRecoveryListeners = new ArrayList();
    private final Map<String, RecordedConsumer> consumers = new ConcurrentHashMap();
    private RecoveryAwareAMQConnection delegate;
    private volatile boolean manuallyClosed = false;
    private final ConnectionParams params;
    private final List<QueueRecoveryListener> queueRecoveryListeners = new ArrayList();
    private final List<RecordedBinding> recordedBindings = new ArrayList();
    private final Map<String, RecordedExchange> recordedExchanges = new ConcurrentHashMap();
    private final Map<String, RecordedQueue> recordedQueues = new ConcurrentHashMap();
    private final List<RecoveryListener> recoveryListeners = new ArrayList();
    private final Object recoveryLock = new Object();
    private final List<ShutdownListener> shutdownHooks = new ArrayList();

    public AutorecoveringConnection(ConnectionParams connectionParams, FrameHandlerFactory frameHandlerFactory, List<Address> list) {
        this.cf = new RecoveryAwareAMQConnectionFactory(connectionParams, frameHandlerFactory, list);
        this.params = connectionParams;
        this.channels = new ConcurrentHashMap();
    }

    private void addAutomaticRecoveryListener() {
        AnonymousClass1 r0 = new ShutdownListener() {
            /* class com.rabbitmq.client.impl.recovery.AutorecoveringConnection.AnonymousClass1 */

            @Override // com.rabbitmq.client.ShutdownListener
            public void shutdownCompleted(ShutdownSignalException shutdownSignalException) {
                try {
                    if (AutorecoveringConnection.this.shouldTriggerConnectionRecovery(shutdownSignalException)) {
                        this.beginAutomaticRecovery();
                    }
                } catch (Exception e) {
                    this.delegate.getExceptionHandler().handleConnectionRecoveryException(this, e);
                }
            }
        };
        synchronized (this) {
            if (!this.shutdownHooks.contains(r0)) {
                this.shutdownHooks.add(r0);
            }
            this.delegate.addShutdownListener(r0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void beginAutomaticRecovery() throws InterruptedException, IOException, TopologyRecoveryException {
        Thread.sleep(this.params.getNetworkRecoveryInterval());
        if (recoverConnection()) {
            recoverShutdownListeners();
            recoverBlockedListeners();
            recoverChannels();
            if (this.params.isTopologyRecoveryEnabled()) {
                recoverEntities();
                recoverConsumers();
            }
            notifyRecoveryListeners();
        }
    }

    private void notifyRecoveryListeners() {
        for (RecoveryListener recoveryListener : this.recoveryListeners) {
            recoveryListener.handleRecovery(this);
        }
    }

    private void propagateQueueNameChangeToBindings(String str, String str2) {
        for (RecordedBinding recordedBinding : this.recordedBindings) {
            if (recordedBinding.getDestination().equals(str)) {
                recordedBinding.setDestination(str2);
            }
        }
    }

    private void propagateQueueNameChangeToConsumers(String str, String str2) {
        for (RecordedConsumer recordedConsumer : this.consumers.values()) {
            if (recordedConsumer.getQueue().equals(str)) {
                recordedConsumer.setQueue(str2);
            }
        }
    }

    private void recoverBindings() {
        for (RecordedBinding recordedBinding : this.recordedBindings) {
            try {
                recordedBinding.recover();
            } catch (Exception e) {
                StringBuilder i0 = hj1.i0("Caught an exception while recovering binding between ");
                i0.append(recordedBinding.getSource());
                i0.append(" and ");
                i0.append(recordedBinding.getDestination());
                i0.append(": ");
                i0.append(e.getMessage());
                getExceptionHandler().handleTopologyRecoveryException(this.delegate, recordedBinding.getDelegateChannel(), new TopologyRecoveryException(i0.toString(), e));
            }
        }
    }

    private void recoverBlockedListeners() {
        for (BlockedListener blockedListener : this.blockedListeners) {
            this.delegate.addBlockedListener(blockedListener);
        }
    }

    private void recoverChannels() {
        for (AutorecoveringChannel autorecoveringChannel : this.channels.values()) {
            try {
                autorecoveringChannel.automaticallyRecover(this, this.delegate);
            } catch (Throwable th) {
                this.delegate.getExceptionHandler().handleChannelRecoveryException(autorecoveringChannel, th);
            }
        }
    }

    private boolean recoverConnection() throws IOException, InterruptedException {
        while (!this.manuallyClosed) {
            try {
                RecoveryAwareAMQConnection newConnection = this.cf.newConnection();
                synchronized (this.recoveryLock) {
                    if (!this.manuallyClosed) {
                        this.delegate = newConnection;
                        return true;
                    }
                    newConnection.abort();
                    return false;
                }
            } catch (Exception e) {
                Thread.sleep(this.params.getNetworkRecoveryInterval());
                getExceptionHandler().handleConnectionRecoveryException(this, e);
            }
        }
        return false;
    }

    private void recoverConsumers() {
        for (Map.Entry entry : new HashMap(this.consumers).entrySet()) {
            String str = (String) entry.getKey();
            RecordedConsumer recordedConsumer = (RecordedConsumer) entry.getValue();
            try {
                String recover = recordedConsumer.recover();
                synchronized (this.consumers) {
                    this.consumers.remove(str);
                    this.consumers.put(recover, recordedConsumer);
                }
                for (ConsumerRecoveryListener consumerRecoveryListener : this.consumerRecoveryListeners) {
                    consumerRecoveryListener.consumerRecovered(str, recover);
                }
            } catch (Exception e) {
                StringBuilder l0 = hj1.l0("Caught an exception while recovering consumer ", str, ": ");
                l0.append(e.getMessage());
                getExceptionHandler().handleTopologyRecoveryException(this.delegate, recordedConsumer.getDelegateChannel(), new TopologyRecoveryException(l0.toString(), e));
            }
        }
    }

    private void recoverEntities() throws TopologyRecoveryException {
        recoverExchanges();
        recoverQueues();
        recoverBindings();
    }

    private void recoverExchanges() {
        for (RecordedExchange recordedExchange : this.recordedExchanges.values()) {
            try {
                recordedExchange.recover();
            } catch (Exception e) {
                StringBuilder i0 = hj1.i0("Caught an exception while recovering exchange ");
                i0.append(recordedExchange.getName());
                i0.append(": ");
                i0.append(e.getMessage());
                getExceptionHandler().handleTopologyRecoveryException(this.delegate, recordedExchange.getDelegateChannel(), new TopologyRecoveryException(i0.toString(), e));
            }
        }
    }

    private void recoverQueues() {
        for (Map.Entry entry : new HashMap(this.recordedQueues).entrySet()) {
            String str = (String) entry.getKey();
            RecordedQueue recordedQueue = (RecordedQueue) entry.getValue();
            try {
                recordedQueue.recover();
                String name = recordedQueue.getName();
                synchronized (this.recordedQueues) {
                    propagateQueueNameChangeToBindings(str, name);
                    propagateQueueNameChangeToConsumers(str, name);
                    if (recordedQueue.isServerNamed()) {
                        deleteRecordedQueue(str);
                    }
                    this.recordedQueues.put(name, recordedQueue);
                }
                for (QueueRecoveryListener queueRecoveryListener : this.queueRecoveryListeners) {
                    queueRecoveryListener.queueRecovered(str, name);
                }
            } catch (Exception e) {
                StringBuilder l0 = hj1.l0("Caught an exception while recovering queue ", str, ": ");
                l0.append(e.getMessage());
                getExceptionHandler().handleTopologyRecoveryException(this.delegate, recordedQueue.getDelegateChannel(), new TopologyRecoveryException(l0.toString(), e));
            }
        }
    }

    private void recoverShutdownListeners() {
        for (ShutdownListener shutdownListener : this.shutdownHooks) {
            this.delegate.addShutdownListener(shutdownListener);
        }
    }

    private Channel wrapChannel(RecoveryAwareChannelN recoveryAwareChannelN) {
        AutorecoveringChannel autorecoveringChannel = new AutorecoveringChannel(this, recoveryAwareChannelN);
        if (recoveryAwareChannelN == null) {
            return null;
        }
        registerChannel(autorecoveringChannel);
        return autorecoveringChannel;
    }

    @Override // com.rabbitmq.client.Connection
    public void abort() {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.abort();
    }

    @Override // com.rabbitmq.client.Connection
    public void addBlockedListener(BlockedListener blockedListener) {
        this.blockedListeners.add(blockedListener);
        this.delegate.addBlockedListener(blockedListener);
    }

    public void addConsumerRecoveryListener(ConsumerRecoveryListener consumerRecoveryListener) {
        this.consumerRecoveryListeners.add(consumerRecoveryListener);
    }

    public void addQueueRecoveryListener(QueueRecoveryListener queueRecoveryListener) {
        this.queueRecoveryListeners.add(queueRecoveryListener);
    }

    @Override // com.rabbitmq.client.Recoverable
    public void addRecoveryListener(RecoveryListener recoveryListener) {
        this.recoveryListeners.add(recoveryListener);
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void addShutdownListener(ShutdownListener shutdownListener) {
        this.shutdownHooks.add(shutdownListener);
        this.delegate.addShutdownListener(shutdownListener);
    }

    @Override // com.rabbitmq.client.Connection
    public void clearBlockedListeners() {
        this.blockedListeners.clear();
        this.delegate.clearBlockedListeners();
    }

    @Override // com.rabbitmq.client.Connection
    public void close() throws IOException {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.close();
    }

    @Override // com.rabbitmq.client.Connection
    public Channel createChannel() throws IOException {
        RecoveryAwareChannelN recoveryAwareChannelN = (RecoveryAwareChannelN) this.delegate.createChannel();
        if (recoveryAwareChannelN == null) {
            return null;
        }
        return wrapChannel(recoveryAwareChannelN);
    }

    public RecordedConsumer deleteRecordedConsumer(String str) {
        return this.consumers.remove(str);
    }

    public void deleteRecordedExchange(String str) {
        this.recordedExchanges.remove(str);
        for (RecordedBinding recordedBinding : removeBindingsWithDestination(str)) {
            maybeDeleteRecordedAutoDeleteExchange(recordedBinding.getSource());
        }
    }

    public synchronized boolean deleteRecordedExchangeBinding(AutorecoveringChannel autorecoveringChannel, String str, String str2, String str3, Map<String, Object> map) {
        return this.recordedBindings.remove(new RecordedExchangeBinding(autorecoveringChannel).source(str2).destination(str).routingKey(str3).arguments(map));
    }

    public void deleteRecordedQueue(String str) {
        this.recordedQueues.remove(str);
        for (RecordedBinding recordedBinding : removeBindingsWithDestination(str)) {
            maybeDeleteRecordedAutoDeleteExchange(recordedBinding.getSource());
        }
    }

    public synchronized boolean deleteRecordedQueueBinding(AutorecoveringChannel autorecoveringChannel, String str, String str2, String str3, Map<String, Object> map) {
        return this.recordedBindings.remove(new RecordedQueueBinding(autorecoveringChannel).source(str2).destination(str).routingKey(str3).arguments(map));
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection, com.rabbitmq.client.Connection
    public InetAddress getAddress() {
        return this.delegate.getAddress();
    }

    @Override // com.rabbitmq.client.Connection
    public int getChannelMax() {
        return this.delegate.getChannelMax();
    }

    @Override // com.rabbitmq.client.Connection
    public Map<String, Object> getClientProperties() {
        return this.delegate.getClientProperties();
    }

    @Override // com.rabbitmq.client.Connection
    public String getClientProvidedName() {
        return this.delegate.getClientProvidedName();
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public ShutdownSignalException getCloseReason() {
        return this.delegate.getCloseReason();
    }

    @Override // com.rabbitmq.client.Connection
    public ExceptionHandler getExceptionHandler() {
        return this.delegate.getExceptionHandler();
    }

    @Override // com.rabbitmq.client.Connection
    public int getFrameMax() {
        return this.delegate.getFrameMax();
    }

    @Override // com.rabbitmq.client.Connection
    public int getHeartbeat() {
        return this.delegate.getHeartbeat();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public InetAddress getLocalAddress() {
        return this.delegate.getLocalAddress();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public int getLocalPort() {
        return this.delegate.getLocalPort();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection, com.rabbitmq.client.Connection
    public int getPort() {
        return this.delegate.getPort();
    }

    public Map<String, RecordedExchange> getRecordedExchanges() {
        return this.recordedExchanges;
    }

    public Map<String, RecordedQueue> getRecordedQueues() {
        return this.recordedQueues;
    }

    @Override // com.rabbitmq.client.Connection
    public Map<String, Object> getServerProperties() {
        return this.delegate.getServerProperties();
    }

    public boolean hasMoreConsumersOnQueue(Collection<RecordedConsumer> collection, String str) {
        for (RecordedConsumer recordedConsumer : collection) {
            if (str.equals(recordedConsumer.getQueue())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMoreDestinationsBoundToExchange(List<RecordedBinding> list, String str) {
        for (RecordedBinding recordedBinding : list) {
            if (str.equals(recordedBinding.getSource())) {
                return true;
            }
        }
        return false;
    }

    public void init() throws IOException, TimeoutException {
        this.delegate = this.cf.newConnection();
        addAutomaticRecoveryListener();
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public void maybeDeleteRecordedAutoDeleteExchange(String str) {
        RecordedExchange recordedExchange;
        synchronized (this.recordedExchanges) {
            synchronized (this.consumers) {
                if (!hasMoreDestinationsBoundToExchange(this.recordedBindings, str) && (recordedExchange = this.recordedExchanges.get(str)) != null && recordedExchange.isAutoDelete()) {
                    this.recordedExchanges.remove(str);
                }
            }
        }
    }

    public void maybeDeleteRecordedAutoDeleteQueue(String str) {
        RecordedQueue recordedQueue;
        synchronized (this.recordedQueues) {
            synchronized (this.consumers) {
                if (!hasMoreConsumersOnQueue(this.consumers.values(), str) && (recordedQueue = this.recordedQueues.get(str)) != null && recordedQueue.isAutoDelete()) {
                    this.recordedQueues.remove(str);
                }
            }
        }
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void notifyListeners() {
        this.delegate.notifyListeners();
    }

    public void recordConsumer(String str, RecordedConsumer recordedConsumer) {
        this.consumers.put(str, recordedConsumer);
    }

    public void recordExchange(String str, RecordedExchange recordedExchange) {
        this.recordedExchanges.put(str, recordedExchange);
    }

    public synchronized void recordExchangeBinding(AutorecoveringChannel autorecoveringChannel, String str, String str2, String str3, Map<String, Object> map) {
        RecordedBinding arguments = new RecordedExchangeBinding(autorecoveringChannel).source(str2).destination(str).routingKey(str3).arguments(map);
        if (this.recordedBindings.contains(arguments)) {
            this.recordedBindings.remove(arguments);
        }
        this.recordedBindings.add(arguments);
    }

    public void recordQueue(AMQP.Queue.DeclareOk declareOk, RecordedQueue recordedQueue) {
        this.recordedQueues.put(declareOk.getQueue(), recordedQueue);
    }

    public synchronized void recordQueueBinding(AutorecoveringChannel autorecoveringChannel, String str, String str2, String str3, Map<String, Object> map) {
        RecordedBinding arguments = new RecordedQueueBinding(autorecoveringChannel).source(str2).destination(str).routingKey(str3).arguments(map);
        if (this.recordedBindings.contains(arguments)) {
            this.recordedBindings.remove(arguments);
        }
        this.recordedBindings.add(arguments);
    }

    public void registerChannel(AutorecoveringChannel autorecoveringChannel) {
        this.channels.put(Integer.valueOf(autorecoveringChannel.getChannelNumber()), autorecoveringChannel);
    }

    public synchronized Set<RecordedBinding> removeBindingsWithDestination(String str) {
        HashSet hashSet;
        hashSet = new HashSet();
        Iterator<RecordedBinding> it = this.recordedBindings.iterator();
        while (it.hasNext()) {
            RecordedBinding next = it.next();
            if (next.getDestination().equals(str)) {
                it.remove();
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    @Override // com.rabbitmq.client.Connection
    public boolean removeBlockedListener(BlockedListener blockedListener) {
        this.blockedListeners.remove(blockedListener);
        return this.delegate.removeBlockedListener(blockedListener);
    }

    public void removeConsumerRecoveryListener(ConsumerRecoveryListener consumerRecoveryListener) {
        this.consumerRecoveryListeners.remove(consumerRecoveryListener);
    }

    public void removeQueueRecoveryListener(QueueRecoveryListener queueRecoveryListener) {
        this.queueRecoveryListeners.remove(queueRecoveryListener);
    }

    @Override // com.rabbitmq.client.Recoverable
    public void removeRecoveryListener(RecoveryListener recoveryListener) {
        this.recoveryListeners.remove(recoveryListener);
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void removeShutdownListener(ShutdownListener shutdownListener) {
        this.shutdownHooks.remove(shutdownListener);
        this.delegate.removeShutdownListener(shutdownListener);
    }

    public boolean shouldTriggerConnectionRecovery(ShutdownSignalException shutdownSignalException) {
        return !shutdownSignalException.isInitiatedByApplication() || (shutdownSignalException.getCause() instanceof MissedHeartbeatException);
    }

    public void start() throws IOException {
    }

    public String toString() {
        return this.delegate.toString();
    }

    public void unregisterChannel(AutorecoveringChannel autorecoveringChannel) {
        this.channels.remove(Integer.valueOf(autorecoveringChannel.getChannelNumber()));
    }

    public void recordQueue(String str, RecordedQueue recordedQueue) {
        this.recordedQueues.put(str, recordedQueue);
    }

    @Override // com.rabbitmq.client.Connection
    public Channel createChannel(int i) throws IOException {
        return this.delegate.createChannel(i);
    }

    @Override // com.rabbitmq.client.Connection
    public void abort(int i, String str, int i2) {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.abort(i, str, i2);
    }

    @Override // com.rabbitmq.client.Connection
    public void close(int i) throws IOException {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.close(i);
    }

    @Override // com.rabbitmq.client.Connection
    public void abort(int i, String str) {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.abort(i, str);
    }

    @Override // com.rabbitmq.client.Connection
    public void close(int i, String str, int i2) throws IOException {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.close(i, str, i2);
    }

    @Override // com.rabbitmq.client.Connection
    public void abort(int i) {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.abort(i);
    }

    @Override // com.rabbitmq.client.Connection
    public void close(int i, String str) throws IOException {
        synchronized (this.recoveryLock) {
            this.manuallyClosed = true;
        }
        this.delegate.close(i, str);
    }
}
