package com.rabbitmq.client.impl.recovery;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Command;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.FlowListener;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.Method;
import com.rabbitmq.client.Recoverable;
import com.rabbitmq.client.RecoveryListener;
import com.rabbitmq.client.ReturnListener;
import com.rabbitmq.client.ShutdownListener;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.impl.AMQImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class AutorecoveringChannel implements Channel, Recoverable {
    private final List<ConfirmListener> confirmListeners = new ArrayList();
    private AutorecoveringConnection connection;
    private RecoveryAwareChannelN delegate;
    private final List<FlowListener> flowListeners = new ArrayList();
    private int prefetchCountConsumer;
    private int prefetchCountGlobal;
    private final List<RecoveryListener> recoveryListeners = new ArrayList();
    private final List<ReturnListener> returnListeners = new ArrayList();
    private final List<ShutdownListener> shutdownHooks = new ArrayList();
    private boolean usesPublisherConfirms;
    private boolean usesTransactions;

    public AutorecoveringChannel(AutorecoveringConnection autorecoveringConnection, RecoveryAwareChannelN recoveryAwareChannelN) {
        this.connection = autorecoveringConnection;
        this.delegate = recoveryAwareChannelN;
    }

    private RecordedConsumer deleteRecordedConsumer(String str) {
        return this.connection.deleteRecordedConsumer(str);
    }

    private void deleteRecordedExchange(String str) {
        this.connection.deleteRecordedExchange(str);
    }

    private boolean deleteRecordedExchangeBinding(String str, String str2, String str3, Map<String, Object> map) {
        return this.connection.deleteRecordedExchangeBinding(this, str, str2, str3, map);
    }

    private void deleteRecordedQueue(String str) {
        this.connection.deleteRecordedQueue(str);
    }

    private boolean deleteRecordedQueueBinding(String str, String str2, String str3, Map<String, Object> map) {
        return this.connection.deleteRecordedQueueBinding(this, str, str2, str3, map);
    }

    private void maybeDeleteRecordedAutoDeleteExchange(String str) {
        this.connection.maybeDeleteRecordedAutoDeleteExchange(str);
    }

    private void maybeDeleteRecordedAutoDeleteQueue(String str) {
        this.connection.maybeDeleteRecordedAutoDeleteQueue(str);
    }

    private void notifyRecoveryListeners() {
        for (RecoveryListener recoveryListener : this.recoveryListeners) {
            recoveryListener.handleRecovery(this);
        }
    }

    private void recordConsumer(String str, String str2, boolean z, boolean z2, Map<String, Object> map, Consumer consumer) {
        this.connection.recordConsumer(str, new RecordedConsumer(this, str2).autoAck(z).consumerTag(str).exclusive(z2).arguments(map).consumer(consumer));
    }

    private void recordExchange(String str, RecordedExchange recordedExchange) {
        this.connection.recordExchange(str, recordedExchange);
    }

    private void recordExchangeBinding(String str, String str2, String str3, Map<String, Object> map) {
        this.connection.recordExchangeBinding(this, str, str2, str3, map);
    }

    private void recordQueue(AMQP.Queue.DeclareOk declareOk, RecordedQueue recordedQueue) {
        this.connection.recordQueue(declareOk, recordedQueue);
    }

    private void recordQueueBinding(String str, String str2, String str3, Map<String, Object> map) {
        this.connection.recordQueueBinding(this, str, str2, str3, map);
    }

    private void recoverConfirmListeners() {
        for (ConfirmListener confirmListener : this.confirmListeners) {
            this.delegate.addConfirmListener(confirmListener);
        }
    }

    @Deprecated
    private void recoverFlowListeners() {
        for (FlowListener flowListener : this.flowListeners) {
            this.delegate.addFlowListener(flowListener);
        }
    }

    private void recoverReturnListeners() {
        for (ReturnListener returnListener : this.returnListeners) {
            this.delegate.addReturnListener(returnListener);
        }
    }

    private void recoverShutdownListeners() {
        for (ShutdownListener shutdownListener : this.shutdownHooks) {
            this.delegate.addShutdownListener(shutdownListener);
        }
    }

    private void recoverState() throws IOException {
        int i = this.prefetchCountConsumer;
        if (i != 0) {
            basicQos(i, false);
        }
        int i2 = this.prefetchCountGlobal;
        if (i2 != 0) {
            basicQos(i2, true);
        }
        if (this.usesPublisherConfirms) {
            confirmSelect();
        }
        if (this.usesTransactions) {
            txSelect();
        }
    }

    @Override // com.rabbitmq.client.Channel
    public void abort() throws IOException {
        this.delegate.abort();
    }

    @Override // com.rabbitmq.client.Channel
    public void addConfirmListener(ConfirmListener confirmListener) {
        this.confirmListeners.add(confirmListener);
        this.delegate.addConfirmListener(confirmListener);
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public void addFlowListener(FlowListener flowListener) {
        this.flowListeners.add(flowListener);
        this.delegate.addFlowListener(flowListener);
    }

    @Override // com.rabbitmq.client.Recoverable
    public void addRecoveryListener(RecoveryListener recoveryListener) {
        this.recoveryListeners.add(recoveryListener);
    }

    @Override // com.rabbitmq.client.Channel
    public void addReturnListener(ReturnListener returnListener) {
        this.returnListeners.add(returnListener);
        this.delegate.addReturnListener(returnListener);
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void addShutdownListener(ShutdownListener shutdownListener) {
        this.shutdownHooks.add(shutdownListener);
        this.delegate.addShutdownListener(shutdownListener);
    }

    @Override // com.rabbitmq.client.Channel
    public void asyncRpc(Method method) throws IOException {
        this.delegate.asyncRpc(method);
    }

    public void automaticallyRecover(AutorecoveringConnection autorecoveringConnection, Connection connection2) throws IOException {
        RecoveryAwareChannelN recoveryAwareChannelN = this.delegate;
        this.connection = autorecoveringConnection;
        RecoveryAwareChannelN recoveryAwareChannelN2 = (RecoveryAwareChannelN) connection2.createChannel(getChannelNumber());
        this.delegate = recoveryAwareChannelN2;
        recoveryAwareChannelN2.inheritOffsetFrom(recoveryAwareChannelN);
        recoverShutdownListeners();
        recoverReturnListeners();
        recoverConfirmListeners();
        recoverFlowListeners();
        recoverState();
        notifyRecoveryListeners();
    }

    @Override // com.rabbitmq.client.Channel
    public void basicAck(long j, boolean z) throws IOException {
        this.delegate.basicAck(j, z);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicCancel(String str) throws IOException {
        RecordedConsumer deleteRecordedConsumer = deleteRecordedConsumer(str);
        if (deleteRecordedConsumer != null) {
            maybeDeleteRecordedAutoDeleteQueue(deleteRecordedConsumer.getQueue());
        }
        this.delegate.basicCancel(str);
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, Consumer consumer) throws IOException {
        return basicConsume(str, false, consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public GetResponse basicGet(String str, boolean z) throws IOException {
        return this.delegate.basicGet(str, z);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicNack(long j, boolean z, boolean z2) throws IOException {
        this.delegate.basicNack(j, z, z2);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicPublish(String str, String str2, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        this.delegate.basicPublish(str, str2, basicProperties, bArr);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicQos(int i, int i2, boolean z) throws IOException {
        if (z) {
            this.prefetchCountGlobal = i2;
        } else {
            this.prefetchCountConsumer = i2;
        }
        this.delegate.basicQos(i, i2, z);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Basic.RecoverOk basicRecover() throws IOException {
        return this.delegate.basicRecover();
    }

    @Override // com.rabbitmq.client.Channel
    public void basicReject(long j, boolean z) throws IOException {
        this.delegate.basicReject(j, z);
    }

    @Override // com.rabbitmq.client.Channel
    public void clearConfirmListeners() {
        this.confirmListeners.clear();
        this.delegate.clearConfirmListeners();
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public void clearFlowListeners() {
        this.flowListeners.clear();
        this.delegate.clearFlowListeners();
    }

    @Override // com.rabbitmq.client.Channel
    public void clearReturnListeners() {
        this.returnListeners.clear();
        this.delegate.clearReturnListeners();
    }

    @Override // com.rabbitmq.client.Channel
    public void close() throws IOException, TimeoutException {
        try {
            this.delegate.close();
        } finally {
            this.connection.unregisterChannel(this);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Confirm.SelectOk confirmSelect() throws IOException {
        this.usesPublisherConfirms = true;
        return this.delegate.confirmSelect();
    }

    @Override // com.rabbitmq.client.Channel
    public long consumerCount(String str) throws IOException {
        return this.delegate.consumerCount(str);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.BindOk exchangeBind(String str, String str2, String str3) throws IOException {
        return exchangeBind(str, str2, str3, null);
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeBindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        this.delegate.exchangeBindNoWait(str, str2, str3, map);
        recordExchangeBinding(str, str2, str3, map);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2) throws IOException {
        return exchangeDeclare(str, str2, false, false, null);
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeDeclareNoWait(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        recordExchange(str, new RecordedExchange(this, str).type(str2).durable(z).autoDelete(z2).arguments(map));
        this.delegate.exchangeDeclareNoWait(str, str2, z, z2, z3, map);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeclareOk exchangeDeclarePassive(String str) throws IOException {
        return this.delegate.exchangeDeclarePassive(str);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeleteOk exchangeDelete(String str, boolean z) throws IOException {
        deleteRecordedExchange(str);
        return this.delegate.exchangeDelete(str, z);
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeDeleteNoWait(String str, boolean z) throws IOException {
        deleteRecordedExchange(str);
        this.delegate.exchangeDeleteNoWait(str, z);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.UnbindOk exchangeUnbind(String str, String str2, String str3) throws IOException {
        return exchangeUnbind(str, str2, str3, null);
    }

    @Override // com.rabbitmq.client.Channel
    public void exchangeUnbindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        this.delegate.exchangeUnbindNoWait(str, str2, str3, map);
        deleteRecordedExchangeBinding(str, str2, str3, map);
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public boolean flowBlocked() {
        return this.delegate.flowBlocked();
    }

    @Override // com.rabbitmq.client.Channel
    public int getChannelNumber() {
        return this.delegate.getChannelNumber();
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public ShutdownSignalException getCloseReason() {
        return this.delegate.getCloseReason();
    }

    @Override // com.rabbitmq.client.Channel
    public Connection getConnection() {
        return this.delegate.getConnection();
    }

    @Override // com.rabbitmq.client.Channel
    public Consumer getDefaultConsumer() {
        return this.delegate.getDefaultConsumer();
    }

    public Channel getDelegate() {
        return this.delegate;
    }

    @Override // com.rabbitmq.client.Channel
    public long getNextPublishSeqNo() {
        return this.delegate.getNextPublishSeqNo();
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // com.rabbitmq.client.Channel
    public long messageCount(String str) throws IOException {
        return this.delegate.messageCount(str);
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void notifyListeners() {
        this.delegate.notifyListeners();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.BindOk queueBind(String str, String str2, String str3) throws IOException {
        return queueBind(str, str2, str3, null);
    }

    @Override // com.rabbitmq.client.Channel
    public void queueBindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        this.delegate.queueBindNoWait(str, str2, str3, map);
        recordQueueBinding(str, str2, str3, map);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.DeclareOk queueDeclare() throws IOException {
        return queueDeclare("", false, true, true, null);
    }

    @Override // com.rabbitmq.client.Channel
    public void queueDeclareNoWait(String str, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        RecordedQueue arguments = new RecordedQueue(this, str).durable(z).exclusive(z2).autoDelete(z3).arguments(map);
        this.delegate.queueDeclareNoWait(str, z, z2, z3, map);
        recordQueue(str, arguments);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.DeclareOk queueDeclarePassive(String str) throws IOException {
        return this.delegate.queueDeclarePassive(str);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.DeleteOk queueDelete(String str) throws IOException {
        return queueDelete(str, false, false);
    }

    @Override // com.rabbitmq.client.Channel
    public void queueDeleteNoWait(String str, boolean z, boolean z2) throws IOException {
        deleteRecordedQueue(str);
        this.delegate.queueDeleteNoWait(str, z, z2);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.PurgeOk queuePurge(String str) throws IOException {
        return this.delegate.queuePurge(str);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.UnbindOk queueUnbind(String str, String str2, String str3) throws IOException {
        return queueUnbind(str, str2, str3, null);
    }

    @Override // com.rabbitmq.client.Channel
    public boolean removeConfirmListener(ConfirmListener confirmListener) {
        this.confirmListeners.remove(confirmListener);
        return this.delegate.removeConfirmListener(confirmListener);
    }

    @Override // com.rabbitmq.client.Channel
    @Deprecated
    public boolean removeFlowListener(FlowListener flowListener) {
        this.flowListeners.remove(flowListener);
        return this.delegate.removeFlowListener(flowListener);
    }

    @Override // com.rabbitmq.client.Recoverable
    public void removeRecoveryListener(RecoveryListener recoveryListener) {
        this.recoveryListeners.remove(recoveryListener);
    }

    @Override // com.rabbitmq.client.Channel
    public boolean removeReturnListener(ReturnListener returnListener) {
        this.returnListeners.remove(returnListener);
        return this.delegate.removeReturnListener(returnListener);
    }

    @Override // com.rabbitmq.client.ShutdownNotifier
    public void removeShutdownListener(ShutdownListener shutdownListener) {
        this.shutdownHooks.remove(shutdownListener);
        this.delegate.removeShutdownListener(shutdownListener);
    }

    @Override // com.rabbitmq.client.Channel
    public Command rpc(Method method) throws IOException {
        return this.delegate.rpc(method);
    }

    @Override // com.rabbitmq.client.Channel
    public void setDefaultConsumer(Consumer consumer) {
        this.delegate.setDefaultConsumer(consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Tx.CommitOk txCommit() throws IOException {
        return this.delegate.txCommit();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Tx.RollbackOk txRollback() throws IOException {
        return this.delegate.txRollback();
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Tx.SelectOk txSelect() throws IOException {
        this.usesTransactions = true;
        return this.delegate.txSelect();
    }

    @Override // com.rabbitmq.client.Channel
    public boolean waitForConfirms() throws InterruptedException {
        return this.delegate.waitForConfirms();
    }

    @Override // com.rabbitmq.client.Channel
    public void waitForConfirmsOrDie() throws IOException, InterruptedException {
        this.delegate.waitForConfirmsOrDie();
    }

    private void recordQueue(String str, RecordedQueue recordedQueue) {
        this.connection.recordQueue(str, recordedQueue);
    }

    @Override // com.rabbitmq.client.Channel
    public void abort(int i, String str) throws IOException {
        this.delegate.abort(i, str);
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, Consumer consumer) throws IOException {
        return basicConsume(str, z, "", consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicPublish(String str, String str2, boolean z, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        this.delegate.basicPublish(str, str2, z, basicProperties, bArr);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Basic.RecoverOk basicRecover(boolean z) throws IOException {
        return this.delegate.basicRecover(z);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.BindOk exchangeBind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        AMQImpl.Exchange.BindOk exchangeBind = this.delegate.exchangeBind(str, str2, str3, map);
        recordExchangeBinding(str, str2, str3, map);
        return exchangeBind;
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z) throws IOException {
        return exchangeDeclare(str, str2, z, false, null);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.UnbindOk exchangeUnbind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        deleteRecordedExchangeBinding(str, str2, str3, map);
        maybeDeleteRecordedAutoDeleteExchange(str2);
        return this.delegate.exchangeUnbind(str, str2, str3, map);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.BindOk queueBind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        AMQImpl.Queue.BindOk queueBind = this.delegate.queueBind(str, str2, str3, map);
        recordQueueBinding(str, str2, str3, map);
        return queueBind;
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.DeclareOk queueDeclare(String str, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        AMQImpl.Queue.DeclareOk queueDeclare = this.delegate.queueDeclare(str, z, z2, z3, map);
        RecordedQueue arguments = new RecordedQueue(this, queueDeclare.getQueue()).durable(z).exclusive(z2).autoDelete(z3).arguments(map);
        if (str.equals("")) {
            arguments.serverNamed(true);
        }
        recordQueue(queueDeclare, arguments);
        return queueDeclare;
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.DeleteOk queueDelete(String str, boolean z, boolean z2) throws IOException {
        deleteRecordedQueue(str);
        return this.delegate.queueDelete(str, z, z2);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Queue.UnbindOk queueUnbind(String str, String str2, String str3, Map<String, Object> map) throws IOException {
        deleteRecordedQueueBinding(str, str2, str3, map);
        maybeDeleteRecordedAutoDeleteExchange(str2);
        return this.delegate.queueUnbind(str, str2, str3, map);
    }

    @Override // com.rabbitmq.client.Channel
    public boolean waitForConfirms(long j) throws InterruptedException, TimeoutException {
        return this.delegate.waitForConfirms(j);
    }

    @Override // com.rabbitmq.client.Channel
    public void waitForConfirmsOrDie(long j) throws IOException, InterruptedException, TimeoutException {
        this.delegate.waitForConfirmsOrDie(j);
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, String str2, Consumer consumer) throws IOException {
        return basicConsume(str, z, str2, false, false, null, consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicPublish(String str, String str2, boolean z, boolean z2, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        this.delegate.basicPublish(str, str2, z, z2, basicProperties, bArr);
    }

    @Override // com.rabbitmq.client.Channel
    public void close(int i, String str) throws IOException, TimeoutException {
        try {
            this.delegate.close(i, str);
        } finally {
            this.connection.unregisterChannel(this);
        }
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z, boolean z2, Map<String, Object> map) throws IOException {
        return exchangeDeclare(str, str2, z, z2, false, map);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeleteOk exchangeDelete(String str) throws IOException {
        return exchangeDelete(str, false);
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, Map<String, Object> map, Consumer consumer) throws IOException {
        return basicConsume(str, z, "", false, false, map, consumer);
    }

    @Override // com.rabbitmq.client.Channel
    public void basicQos(int i) throws IOException {
        basicQos(0, i, false);
    }

    @Override // com.rabbitmq.client.Channel
    public AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException {
        AMQImpl.Exchange.DeclareOk exchangeDeclare = this.delegate.exchangeDeclare(str, str2, z, z2, z3, map);
        recordExchange(str, new RecordedExchange(this, str).type(str2).durable(z).autoDelete(z2).arguments(map));
        return exchangeDeclare;
    }

    @Override // com.rabbitmq.client.Channel
    public String basicConsume(String str, boolean z, String str2, boolean z2, boolean z3, Map<String, Object> map, Consumer consumer) throws IOException {
        String basicConsume = this.delegate.basicConsume(str, z, str2, z2, z3, map, consumer);
        recordConsumer(basicConsume, str, z, z3, map, consumer);
        return basicConsume;
    }

    @Override // com.rabbitmq.client.Channel
    public void basicQos(int i, boolean z) throws IOException {
        basicQos(0, i, z);
    }
}
