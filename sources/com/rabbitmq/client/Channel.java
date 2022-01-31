package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public interface Channel extends ShutdownNotifier {
    void abort() throws IOException;

    void abort(int i, String str) throws IOException;

    void addConfirmListener(ConfirmListener confirmListener);

    void addFlowListener(FlowListener flowListener);

    void addReturnListener(ReturnListener returnListener);

    void asyncRpc(Method method) throws IOException;

    void basicAck(long j, boolean z) throws IOException;

    void basicCancel(String str) throws IOException;

    String basicConsume(String str, Consumer consumer) throws IOException;

    String basicConsume(String str, boolean z, Consumer consumer) throws IOException;

    String basicConsume(String str, boolean z, String str2, Consumer consumer) throws IOException;

    String basicConsume(String str, boolean z, String str2, boolean z2, boolean z3, Map<String, Object> map, Consumer consumer) throws IOException;

    String basicConsume(String str, boolean z, Map<String, Object> map, Consumer consumer) throws IOException;

    GetResponse basicGet(String str, boolean z) throws IOException;

    void basicNack(long j, boolean z, boolean z2) throws IOException;

    void basicPublish(String str, String str2, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException;

    void basicPublish(String str, String str2, boolean z, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException;

    void basicPublish(String str, String str2, boolean z, boolean z2, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException;

    void basicQos(int i) throws IOException;

    void basicQos(int i, int i2, boolean z) throws IOException;

    void basicQos(int i, boolean z) throws IOException;

    AMQP.Basic.RecoverOk basicRecover() throws IOException;

    AMQP.Basic.RecoverOk basicRecover(boolean z) throws IOException;

    void basicReject(long j, boolean z) throws IOException;

    void clearConfirmListeners();

    void clearFlowListeners();

    void clearReturnListeners();

    void close() throws IOException, TimeoutException;

    void close(int i, String str) throws IOException, TimeoutException;

    AMQP.Confirm.SelectOk confirmSelect() throws IOException;

    long consumerCount(String str) throws IOException;

    AMQP.Exchange.BindOk exchangeBind(String str, String str2, String str3) throws IOException;

    AMQP.Exchange.BindOk exchangeBind(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    void exchangeBindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2) throws IOException;

    AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z) throws IOException;

    AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z, boolean z2, Map<String, Object> map) throws IOException;

    AMQP.Exchange.DeclareOk exchangeDeclare(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException;

    void exchangeDeclareNoWait(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException;

    AMQP.Exchange.DeclareOk exchangeDeclarePassive(String str) throws IOException;

    AMQP.Exchange.DeleteOk exchangeDelete(String str) throws IOException;

    AMQP.Exchange.DeleteOk exchangeDelete(String str, boolean z) throws IOException;

    void exchangeDeleteNoWait(String str, boolean z) throws IOException;

    AMQP.Exchange.UnbindOk exchangeUnbind(String str, String str2, String str3) throws IOException;

    AMQP.Exchange.UnbindOk exchangeUnbind(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    void exchangeUnbindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    boolean flowBlocked();

    int getChannelNumber();

    Connection getConnection();

    Consumer getDefaultConsumer();

    long getNextPublishSeqNo();

    long messageCount(String str) throws IOException;

    AMQP.Queue.BindOk queueBind(String str, String str2, String str3) throws IOException;

    AMQP.Queue.BindOk queueBind(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    void queueBindNoWait(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    AMQP.Queue.DeclareOk queueDeclare() throws IOException;

    AMQP.Queue.DeclareOk queueDeclare(String str, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException;

    void queueDeclareNoWait(String str, boolean z, boolean z2, boolean z3, Map<String, Object> map) throws IOException;

    AMQP.Queue.DeclareOk queueDeclarePassive(String str) throws IOException;

    AMQP.Queue.DeleteOk queueDelete(String str) throws IOException;

    AMQP.Queue.DeleteOk queueDelete(String str, boolean z, boolean z2) throws IOException;

    void queueDeleteNoWait(String str, boolean z, boolean z2) throws IOException;

    AMQP.Queue.PurgeOk queuePurge(String str) throws IOException;

    AMQP.Queue.UnbindOk queueUnbind(String str, String str2, String str3) throws IOException;

    AMQP.Queue.UnbindOk queueUnbind(String str, String str2, String str3, Map<String, Object> map) throws IOException;

    boolean removeConfirmListener(ConfirmListener confirmListener);

    boolean removeFlowListener(FlowListener flowListener);

    boolean removeReturnListener(ReturnListener returnListener);

    Command rpc(Method method) throws IOException;

    void setDefaultConsumer(Consumer consumer);

    AMQP.Tx.CommitOk txCommit() throws IOException;

    AMQP.Tx.RollbackOk txRollback() throws IOException;

    AMQP.Tx.SelectOk txSelect() throws IOException;

    boolean waitForConfirms() throws InterruptedException;

    boolean waitForConfirms(long j) throws InterruptedException, TimeoutException;

    void waitForConfirmsOrDie() throws IOException, InterruptedException;

    void waitForConfirmsOrDie(long j) throws IOException, InterruptedException, TimeoutException;
}
