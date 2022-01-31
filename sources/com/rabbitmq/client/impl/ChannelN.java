package com.rabbitmq.client.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Command;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.FlowListener;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.Method;
import com.rabbitmq.client.ReturnListener;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.UnexpectedMethodError;
import com.rabbitmq.client.impl.AMQChannel;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.utility.Utility;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

public class ChannelN extends AMQChannel implements Channel {
    private static final String UNSPECIFIED_OUT_OF_BAND = "";
    private final Map<String, Consumer> _consumers = DesugarCollections.synchronizedMap(new HashMap());
    private final Collection<ConfirmListener> confirmListeners = new CopyOnWriteArrayList();
    private volatile Consumer defaultConsumer = null;
    private final ConsumerDispatcher dispatcher;
    private volatile CountDownLatch finishedShutdownFlag = null;
    private final Collection<FlowListener> flowListeners = new CopyOnWriteArrayList();
    private long nextPublishSeqNo = 0;
    private volatile boolean onlyAcksReceived = true;
    private final Collection<ReturnListener> returnListeners = new CopyOnWriteArrayList();
    private final SortedSet<Long> unconfirmedSet = Collections.synchronizedSortedSet(new TreeSet());

    public ChannelN(AMQConnection aMQConnection, int i, ConsumerWorkService consumerWorkService) {
        super(aMQConnection, i);
        this.dispatcher = new ConsumerDispatcher(aMQConnection, this, consumerWorkService);
    }

    private void asyncShutdown(Command command) throws IOException {
        ShutdownSignalException shutdownSignalException = new ShutdownSignalException(false, false, command.getMethod(), this);
        synchronized (this._channelMutex) {
            try {
                processShutdownSignal(shutdownSignalException, true, false);
                quiescingTransmit(new AMQImpl.Channel.CloseOk());
            } finally {
                releaseChannel();
                notifyOutstandingRpc(shutdownSignalException);
            }
        }
        notifyListeners();
    }

    private void broadcastShutdownSignal(ShutdownSignalException shutdownSignalException) {
        HashMap hashMap;
        synchronized (this._consumers) {
            hashMap = new HashMap(this._consumers);
        }
        this.finishedShutdownFlag = this.dispatcher.handleShutdownSignal(hashMap, shutdownSignalException);
    }

    private void callConfirmListeners(Command command, AMQImpl.Basic.Ack ack) {
        try {
            for (ConfirmListener confirmListener : this.confirmListeners) {
                confirmListener.handleAck(ack.getDeliveryTag(), ack.getMultiple());
            }
        } catch (Throwable th) {
            getConnection().getExceptionHandler().handleConfirmListenerException(this, th);
        }
    }

    private void callFlowListeners(Command command, AMQImpl.Channel.Flow flow) {
        try {
            for (FlowListener flowListener : this.flowListeners) {
                flowListener.handleFlow(flow.getActive());
            }
        } catch (Throwable th) {
            getConnection().getExceptionHandler().handleFlowListenerException(this, th);
        }
    }

    private void callReturnListeners(Command command, AMQImpl.Basic.Return r11) {
        try {
            for (ReturnListener returnListener : this.returnListeners) {
                returnListener.handleReturn(r11.getReplyCode(), r11.getReplyText(), r11.getExchange(), r11.getRoutingKey(), (AMQP.BasicProperties) command.getContentHeader(), command.getContentBody());
            }
        } catch (Throwable th) {
            getConnection().getExceptionHandler().handleReturnListenerException(this, th);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishProcessShutdownSignal() {
        this.dispatcher.quiesce();
        broadcastShutdownSignal(getCloseReason());
        synchronized (this.unconfirmedSet) {
            this.unconfirmedSet.notifyAll();
        }
    }

    private void handleAckNack(long j, boolean z, boolean z2) {
        if (z) {
            this.unconfirmedSet.headSet(Long.valueOf(j + 1)).clear();
        } else {
            this.unconfirmedSet.remove(Long.valueOf(j));
        }
        synchronized (this.unconfirmedSet) {
            this.onlyAcksReceived = this.onlyAcksReceived && !z2;
            if (this.unconfirmedSet.isEmpty()) {
                this.unconfirmedSet.notifyAll();
            }
        }
    }

    private void releaseChannel() {
        getConnection().disconnectChannel(this);
    }

    private void startProcessShutdownSignal(ShutdownSignalException shutdownSignalException, boolean z, boolean z2) {
        super.processShutdownSignal(shutdownSignalException, z, z2);
    }

    private void validateQueueNameLength(String str) {
        if (str.length() > 255) {
            throw new IllegalArgumentException("queue name must be no more than 255 characters long");
        }
    }

    @Override // com.rabbitmq.client.Channel
    public void abort() throws IOException {
        abort(AMQP.REPLY_SUCCESS, "OK");
    }

    @Override // com.rabbitmq.client.Channel
    public void addConfirmListener(ConfirmListener confirmListener) {
        this.confirmListeners.add(confirmListener);
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public void addFlowListener(FlowListener flowListener) {
        this.flowListeners.add(flowListener);
    }

    @Override // com.rabbitmq.client.Channel
    public void addReturnListener(ReturnListener returnListener) {
        this.returnListeners.add(returnListener);
    }

    @Override // com.rabbitmq.client.Channel
    public void asyncRpc(Method method) throws IOException {
        transmit(method);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicAck(long j, boolean z) throws IOException {
        transmit(new AMQImpl.Basic.Ack(j, z));
    }

    @Override // com.rabbitmq.client.Channel
    public void basicCancel(final String str) throws IOException {
        final Consumer consumer = this._consumers.get(str);
        if (consumer != null) {
            AnonymousClass3 r1 = new AMQChannel.BlockingRpcContinuation<Consumer>() {
                /* class com.rabbitmq.client.impl.ChannelN.AnonymousClass3 */

                @Override // com.rabbitmq.client.impl.AMQChannel.BlockingRpcContinuation
                public Consumer transformReply(AMQCommand aMQCommand) {
                    aMQCommand.getMethod();
                    ChannelN.this._consumers.remove(str);
                    ChannelN.this.dispatcher.handleCancelOk(consumer, str);
                    return consumer;
                }
            };
            rpc(new AMQImpl.Basic.Cancel(str, false), r1);
            try {
                r1.getReply();
            } catch (ShutdownSignalException e) {
                throw AMQChannel.wrap(e);
            }
        } else {
            throw new IOException("Unknown consumerTag");
        }
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, Consumer consumer) throws IOException {
        return basicConsume(str, false, consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public GetResponse basicGet(String str, boolean z) throws IOException {
        validateQueueNameLength(str);
        AMQCommand exnWrappingRpc = exnWrappingRpc(new AMQP.Basic.Get.Builder().queue(str).noAck(z).build());
        Method method = exnWrappingRpc.getMethod();
        if (method instanceof AMQImpl.Basic.GetOk) {
            AMQImpl.Basic.GetOk getOk = (AMQImpl.Basic.GetOk) method;
            return new GetResponse(new Envelope(getOk.getDeliveryTag(), getOk.getRedelivered(), getOk.getExchange(), getOk.getRoutingKey()), (AMQP.BasicProperties) exnWrappingRpc.getContentHeader(), exnWrappingRpc.getContentBody(), getOk.getMessageCount());
        } else if (method instanceof AMQImpl.Basic.GetEmpty) {
            return null;
        } else {
            throw new UnexpectedMethodError(method);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public void basicNack(long j, boolean z, boolean z2) throws IOException {
        transmit(new AMQImpl.Basic.Nack(j, z, z2));
    }

    @Override // com.rabbitmq.client.Channel
    public void basicPublish(String str, String str2, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        basicPublish(str, str2, false, basicProperties, bArr);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicQos(int i, int i2, boolean z) throws IOException {
        exnWrappingRpc(new AMQImpl.Basic.Qos(i, i2, z));
    }

    @Override // com.rabbitmq.client.Channel
    public void basicReject(long j, boolean z) throws IOException {
        transmit(new AMQImpl.Basic.Reject(j, z));
    }

    @Override // com.rabbitmq.client.Channel
    public void clearConfirmListeners() {
        this.confirmListeners.clear();
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public void clearFlowListeners() {
        this.flowListeners.clear();
    }

    @Override // com.rabbitmq.client.Channel
    public void clearReturnListeners() {
        this.returnListeners.clear();
    }

    @Override // com.rabbitmq.client.Channel
    public void close() throws IOException, TimeoutException {
        close(AMQP.REPLY_SUCCESS, "OK");
    }

    @Override // com.rabbitmq.client.Channel
    public long consumerCount(String str) throws IOException {
        return (long) queueDeclarePassive(str).getConsumerCount();
    }

    @Override // com.rabbitmq.client.impl.AMQChannel
    public void enqueueRpc(AMQChannel.RpcContinuation rpcContinuation) {
        synchronized (this._channelMutex) {
            super.enqueueRpc(rpcContinuation);
            this.dispatcher.setUnlimited(true);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeBindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        transmit(new AMQCommand(new AMQP.Exchange.Bind.Builder().destination(str).source(str2).routingKey(str3).arguments(map).nowait(true).build()));
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeDeclareNoWait(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        transmit(new AMQCommand(new AMQP.Exchange.Declare.Builder().exchange(str).type(str2).durable(z).autoDelete(z2).internal(z3).arguments(map).passive(false).nowait(true).build()));
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeDeleteNoWait(String str, boolean z) throws IOException {
        transmit(new AMQCommand(new AMQP.Exchange.Delete.Builder().exchange(str).ifUnused(z).nowait(true).build()));
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeUnbindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        transmit(new AMQCommand(new AMQP.Exchange.Unbind.Builder().destination(str).source(str2).routingKey(str3).arguments(map).nowait(true).build()));
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public boolean flowBlocked() {
        return this._blockContent;
    }

    @Override // com.rabbitmq.client.Channel, com.rabbitmq.client.impl.AMQChannel
    public /* bridge */ /* synthetic */ Connection getConnection() {
        return super.getConnection();
    }

    @Override // com.rabbitmq.client.Channel
    public Consumer getDefaultConsumer() {
        return this.defaultConsumer;
    }

    @Override // com.rabbitmq.client.Channel
    public long getNextPublishSeqNo() {
        return this.nextPublishSeqNo;
    }

    public CountDownLatch getShutdownLatch() {
        return this.finishedShutdownFlag;
    }

    @Override // com.rabbitmq.client.impl.AMQChannel
    public void markRpcFinished() {
        synchronized (this._channelMutex) {
            this.dispatcher.setUnlimited(false);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public long messageCount(String str) throws IOException {
        return (long) queueDeclarePassive(str).getMessageCount();
    }

    public void open() throws IOException {
        exnWrappingRpc(new AMQImpl.Channel.Open(""));
    }

    @Override // com.rabbitmq.client.impl.AMQChannel
    public boolean processAsync(Command command) throws IOException {
        Method method = command.getMethod();
        if (method instanceof AMQImpl.Channel.Close) {
            asyncShutdown(command);
            return true;
        }
        boolean z = false;
        if (isOpen()) {
            if (method instanceof AMQImpl.Basic.Deliver) {
                processDelivery(command, (AMQImpl.Basic.Deliver) method);
                return true;
            } else if (method instanceof AMQImpl.Basic.Return) {
                callReturnListeners(command, (AMQImpl.Basic.Return) method);
                return true;
            } else if (method instanceof AMQImpl.Channel.Flow) {
                AMQImpl.Channel.Flow flow = (AMQImpl.Channel.Flow) method;
                synchronized (this._channelMutex) {
                    this._blockContent = !flow.getActive();
                    if (!this._blockContent) {
                        z = true;
                    }
                    transmit(new AMQImpl.Channel.FlowOk(z));
                    this._channelMutex.notifyAll();
                }
                callFlowListeners(command, flow);
                return true;
            } else if (method instanceof AMQImpl.Basic.Ack) {
                AMQImpl.Basic.Ack ack = (AMQImpl.Basic.Ack) method;
                callConfirmListeners(command, ack);
                handleAckNack(ack.getDeliveryTag(), ack.getMultiple(), false);
                return true;
            } else if (method instanceof AMQImpl.Basic.Nack) {
                AMQImpl.Basic.Nack nack = (AMQImpl.Basic.Nack) method;
                callConfirmListeners(command, nack);
                handleAckNack(nack.getDeliveryTag(), nack.getMultiple(), true);
                return true;
            } else if (method instanceof AMQImpl.Basic.RecoverOk) {
                for (Map.Entry<String, Consumer> entry : this._consumers.entrySet()) {
                    this.dispatcher.handleRecoverOk(entry.getValue(), entry.getKey());
                }
                return false;
            } else if (!(method instanceof AMQImpl.Basic.Cancel)) {
                return false;
            } else {
                String consumerTag = ((AMQImpl.Basic.Cancel) method).getConsumerTag();
                Consumer remove = this._consumers.remove(consumerTag);
                if (remove == null) {
                    remove = this.defaultConsumer;
                }
                if (remove != null) {
                    try {
                        this.dispatcher.handleCancel(remove, consumerTag);
                    } catch (Throwable th) {
                        getConnection().getExceptionHandler().handleConsumerException(this, th, remove, consumerTag, "handleCancel");
                    }
                }
                return true;
            }
        } else if (method instanceof AMQImpl.Channel.CloseOk) {
            return false;
        } else {
            return true;
        }
    }

    public void processDelivery(Command command, AMQImpl.Basic.Deliver deliver) {
        Consumer consumer = this._consumers.get(deliver.getConsumerTag());
        if (consumer == null) {
            if (this.defaultConsumer != null) {
                consumer = this.defaultConsumer;
            } else {
                throw new IllegalStateException("Unsolicited delivery - see Channel.setDefaultConsumer to handle this case.");
            }
        }
        try {
            this.dispatcher.handleDelivery(consumer, deliver.getConsumerTag(), new Envelope(deliver.getDeliveryTag(), deliver.getRedelivered(), deliver.getExchange(), deliver.getRoutingKey()), (AMQP.BasicProperties) command.getContentHeader(), command.getContentBody());
        } catch (Throwable th) {
            getConnection().getExceptionHandler().handleConsumerException(this, th, consumer, deliver.getConsumerTag(), "handleDelivery");
        }
    }

    @Override // com.rabbitmq.client.impl.AMQChannel
    public void processShutdownSignal(ShutdownSignalException shutdownSignalException, boolean z, boolean z2) {
        startProcessShutdownSignal(shutdownSignalException, z, z2);
        finishProcessShutdownSignal();
    }

    @Override // com.rabbitmq.client.Channel
    public void queueBindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        validateQueueNameLength(str);
        transmit(new AMQCommand(new AMQP.Queue.Bind.Builder().queue(str).exchange(str2).routingKey(str3).arguments(map).build()));
    }

    @Override // com.rabbitmq.client.Channel
    public void queueDeclareNoWait(String str, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        validateQueueNameLength(str);
        transmit(new AMQCommand(new AMQP.Queue.Declare.Builder().queue(str).durable(z).exclusive(z2).autoDelete(z3).arguments(map).passive(false).nowait(true).build()));
    }

    @Override // com.rabbitmq.client.Channel
    public void queueDeleteNoWait(String str, boolean z, boolean z2) throws IOException {
        validateQueueNameLength(str);
        transmit(new AMQCommand(new AMQP.Queue.Delete.Builder().queue(str).ifUnused(z).ifEmpty(z2).nowait(true).build()));
    }

    @Override // com.rabbitmq.client.Channel
    public boolean removeConfirmListener(ConfirmListener confirmListener) {
        return this.confirmListeners.remove(confirmListener);
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public boolean removeFlowListener(FlowListener flowListener) {
        return this.flowListeners.remove(flowListener);
    }

    @Override // com.rabbitmq.client.Channel
    public boolean removeReturnListener(ReturnListener returnListener) {
        return this.returnListeners.remove(returnListener);
    }

    @Override // com.rabbitmq.client.Channel
    public void setDefaultConsumer(Consumer consumer) {
        this.defaultConsumer = consumer;
    }

    @Override // com.rabbitmq.client.Channel
    public boolean waitForConfirms() throws InterruptedException {
        try {
            return waitForConfirms(0);
        } catch (TimeoutException unused) {
            return false;
        }
    }

    @Override // com.rabbitmq.client.Channel
    public void waitForConfirmsOrDie() throws IOException, InterruptedException {
        try {
            waitForConfirmsOrDie(0);
        } catch (TimeoutException unused) {
        }
    }

    @Override // com.rabbitmq.client.Channel
    public void abort(int i, String str) throws IOException {
        try {
            close(i, str, true, null, true);
        } catch (IOException | TimeoutException unused) {
        }
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, Consumer consumer) throws IOException {
        return basicConsume(str, z, "", consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicPublish(String str, String str2, boolean z, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        basicPublish(str, str2, z, false, basicProperties, bArr);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicQos(int i, boolean z) throws IOException {
        basicQos(0, i, z);
    }

    @Override // com.rabbitmq.client.Channel
    public void close(int i, String str) throws IOException, TimeoutException {
        close(i, str, true, null, false);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Confirm.SelectOk confirmSelect() throws IOException {
        if (this.nextPublishSeqNo == 0) {
            this.nextPublishSeqNo = 1;
        }
        return (AMQImpl.Confirm.SelectOk) exnWrappingRpc(new AMQImpl.Confirm.Select(false)).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeclareOk exchangeDeclarePassive(String str) throws IOException {
        return (AMQImpl.Exchange.DeclareOk) exnWrappingRpc(new AMQP.Exchange.Declare.Builder().exchange(str).type("").passive().build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.DeclareOk queueDeclare(String str, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        validateQueueNameLength(str);
        return (AMQImpl.Queue.DeclareOk) exnWrappingRpc(new AMQP.Queue.Declare.Builder().queue(str).durable(z).exclusive(z2).autoDelete(z3).arguments(map).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.DeclareOk queueDeclarePassive(String str) throws IOException {
        validateQueueNameLength(str);
        return (AMQImpl.Queue.DeclareOk) exnWrappingRpc(new AMQP.Queue.Declare.Builder().queue(str).passive().exclusive().autoDelete().build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.PurgeOk queuePurge(String str) throws IOException {
        validateQueueNameLength(str);
        return (AMQImpl.Queue.PurgeOk) exnWrappingRpc(new AMQP.Queue.Purge.Builder().queue(str).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel, com.rabbitmq.client.impl.AMQChannel
    public AMQCommand rpc(Method method) throws IOException {
        return exnWrappingRpc(method);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Tx.CommitOk txCommit() throws IOException {
        return (AMQImpl.Tx.CommitOk) exnWrappingRpc(new AMQImpl.Tx.Commit()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Tx.RollbackOk txRollback() throws IOException {
        return (AMQImpl.Tx.RollbackOk) exnWrappingRpc(new AMQImpl.Tx.Rollback()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Tx.SelectOk txSelect() throws IOException {
        return (AMQImpl.Tx.SelectOk) exnWrappingRpc(new AMQImpl.Tx.Select()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public boolean waitForConfirms(long j) throws InterruptedException, TimeoutException {
        boolean z;
        if (this.nextPublishSeqNo != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.unconfirmedSet) {
                while (getCloseReason() == null) {
                    if (this.unconfirmedSet.isEmpty()) {
                        z = this.onlyAcksReceived;
                        this.onlyAcksReceived = true;
                    } else if (j == 0) {
                        this.unconfirmedSet.wait();
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (j > currentTimeMillis2) {
                            this.unconfirmedSet.wait(j - currentTimeMillis2);
                        } else {
                            throw new TimeoutException();
                        }
                    }
                }
                throw ((ShutdownSignalException) Utility.fixStackTrace(getCloseReason()));
            }
            return z;
        }
        throw new IllegalStateException("Confirms not selected");
    }

    @Override // com.rabbitmq.client.Channel
    public void waitForConfirmsOrDie(long j) throws IOException, InterruptedException, TimeoutException {
        try {
            if (!waitForConfirms(j)) {
                close(AMQP.REPLY_SUCCESS, "NACKS RECEIVED", true, null, false);
                throw new IOException("nacks received");
            }
        } catch (TimeoutException e) {
            close(AMQP.PRECONDITION_FAILED, "TIMEOUT WAITING FOR ACK");
            throw e;
        }
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, Map<String, Object> map, Consumer consumer) throws IOException {
        return basicConsume(str, z, "", false, false, map, consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicPublish(String str, String str2, boolean z, boolean z2, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        if (this.nextPublishSeqNo > 0) {
            this.unconfirmedSet.add(Long.valueOf(getNextPublishSeqNo()));
            this.nextPublishSeqNo++;
        }
        if (basicProperties == null) {
            basicProperties = MessageProperties.MINIMAL_BASIC;
        }
        transmit(new AMQCommand(new AMQP.Basic.Publish.Builder().exchange(str).routingKey(str2).mandatory(z).immediate(z2).build(), basicProperties, bArr));
    }

    @Override // com.rabbitmq.client.Channel
    public void basicQos(int i) throws IOException {
        basicQos(0, i, false);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Basic.RecoverOk basicRecover() throws IOException {
        return basicRecover(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x003f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0044 A[SYNTHETIC, Splitter:B:32:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0048 A[Catch:{ TimeoutException -> 0x004e, ShutdownSignalException -> 0x0045, IOException -> 0x003c, all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x004d A[Catch:{ TimeoutException -> 0x004e, ShutdownSignalException -> 0x0045, IOException -> 0x003c, all -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(int r4, java.lang.String r5, boolean r6, java.lang.Throwable r7, boolean r8) throws java.io.IOException, java.util.concurrent.TimeoutException {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.impl.ChannelN.close(int, java.lang.String, boolean, java.lang.Throwable, boolean):void");
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.BindOk exchangeBind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        return (AMQImpl.Exchange.BindOk) exnWrappingRpc(new AMQP.Exchange.Bind.Builder().destination(str).source(str2).routingKey(str3).arguments(map).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeleteOk exchangeDelete(String str, boolean z) throws IOException {
        return (AMQImpl.Exchange.DeleteOk) exnWrappingRpc(new AMQP.Exchange.Delete.Builder().exchange(str).ifUnused(z).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.UnbindOk exchangeUnbind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        return (AMQImpl.Exchange.UnbindOk) exnWrappingRpc(new AMQP.Exchange.Unbind.Builder().destination(str).source(str2).routingKey(str3).arguments(map).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.BindOk queueBind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        validateQueueNameLength(str);
        return (AMQImpl.Queue.BindOk) exnWrappingRpc(new AMQP.Queue.Bind.Builder().queue(str).exchange(str2).routingKey(str3).arguments(map).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.DeleteOk queueDelete(String str, boolean z, boolean z2) throws IOException {
        validateQueueNameLength(str);
        return (AMQImpl.Queue.DeleteOk) exnWrappingRpc(new AMQP.Queue.Delete.Builder().queue(str).ifUnused(z).ifEmpty(z2).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.UnbindOk queueUnbind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        validateQueueNameLength(str);
        return (AMQImpl.Queue.UnbindOk) exnWrappingRpc(new AMQP.Queue.Unbind.Builder().queue(str).exchange(str2).routingKey(str3).arguments(map).build()).getMethod();
    }

    private void callConfirmListeners(Command command, AMQImpl.Basic.Nack nack) {
        try {
            for (ConfirmListener confirmListener : this.confirmListeners) {
                confirmListener.handleNack(nack.getDeliveryTag(), nack.getMultiple());
            }
        } catch (Throwable th) {
            getConnection().getExceptionHandler().handleConfirmListenerException(this, th);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, String str2, Consumer consumer) throws IOException {
        return basicConsume(str, z, str2, false, false, null, consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Basic.RecoverOk basicRecover(boolean z) throws IOException {
        return (AMQImpl.Basic.RecoverOk) exnWrappingRpc(new AMQImpl.Basic.Recover(z)).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.BindOk exchangeBind(String str, String str2, String str3) throws IOException {
        return exchangeBind(str, str2, str3, (Map<String, Object>) null);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeleteOk exchangeDelete(String str) throws IOException {
        return exchangeDelete(str, false);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.UnbindOk exchangeUnbind(String str, String str2, String str3) throws IOException {
        return exchangeUnbind(str, str2, str3, (Map<String, Object>) null);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.DeclareOk queueDeclare() throws IOException {
        return queueDeclare("", false, true, true, (Map<String, Object>) null);
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, String str2, boolean z2, boolean z3, Map<String, Object> map, final Consumer consumer) throws IOException {
        AnonymousClass2 r0 = new AMQChannel.BlockingRpcContinuation<String>() {
            /* class com.rabbitmq.client.impl.ChannelN.AnonymousClass2 */

            @Override // com.rabbitmq.client.impl.AMQChannel.BlockingRpcContinuation
            public String transformReply(AMQCommand aMQCommand) {
                String consumerTag = ((AMQImpl.Basic.ConsumeOk) aMQCommand.getMethod()).getConsumerTag();
                ChannelN.this._consumers.put(consumerTag, consumer);
                ChannelN.this.dispatcher.handleConsumeOk(consumer, consumerTag);
                return consumerTag;
            }
        };
        rpc(new AMQP.Basic.Consume.Builder().queue(str).consumerTag(str2).noLocal(z2).noAck(z).exclusive(z3).arguments(map).build(), r0);
        try {
            return (String) r0.getReply();
        } catch (ShutdownSignalException e) {
            throw AMQChannel.wrap(e);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z, boolean z2, Map<String, Object> map) throws IOException {
        return exchangeDeclare(str, str2, z, z2, false, map);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.BindOk queueBind(String str, String str2, String str3) throws IOException {
        return queueBind(str, str2, str3, (Map<String, Object>) null);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.DeleteOk queueDelete(String str) throws IOException {
        return queueDelete(str, false, false);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Queue.UnbindOk queueUnbind(String str, String str2, String str3) throws IOException {
        return queueUnbind(str, str2, str3, (Map<String, Object>) null);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        return (AMQImpl.Exchange.DeclareOk) exnWrappingRpc(new AMQP.Exchange.Declare.Builder().exchange(str).type(str2).durable(z).autoDelete(z2).internal(z3).arguments(map).build()).getMethod();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z) throws IOException {
        return exchangeDeclare(str, str2, z, false, (Map<String, Object>) null);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQImpl.Exchange.DeclareOk exchangeDeclare(String str, String str2) throws IOException {
        return exchangeDeclare(str, str2, false, false, (Map<String, Object>) null);
    }
}
