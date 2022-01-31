package com.rabbitmq.client.impl;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.appindexing.Indexable;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.BlockedListener;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Command;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ExceptionHandler;
import com.rabbitmq.client.Method;
import com.rabbitmq.client.MissedHeartbeatException;
import com.rabbitmq.client.SaslConfig;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.impl.AMQChannel;
import com.rabbitmq.utility.BlockingCell;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import server.zophop.Constants;

public class AMQConnection extends ShutdownNotifierComponent implements Connection, NetworkConnection {
    private static long SOCKET_CLOSE_TIMEOUT = Constants.THRESHOLD_TIMESTAMP;
    private static final Version clientVersion = new Version(0, 9);
    private final BlockingCell<Object> _appContinuation = new BlockingCell<>();
    private volatile boolean _brokerInitiatedShutdown;
    private final AMQChannel _channel0 = new AMQChannel(this, 0) {
        /* class com.rabbitmq.client.impl.AMQConnection.AnonymousClass1 */

        @Override // com.rabbitmq.client.impl.AMQChannel
        public boolean processAsync(Command command) throws IOException {
            return getConnection().processControlCommand(command);
        }
    };
    private volatile ChannelManager _channelManager;
    private final Map<String, Object> _clientProperties;
    private final ExceptionHandler _exceptionHandler;
    private final FrameHandler _frameHandler;
    private volatile int _frameMax = 0;
    private volatile int _heartbeat = 0;
    private HeartbeatSender _heartbeatSender;
    private volatile boolean _inConnectionNegotiation;
    private volatile int _missedHeartbeats = 0;
    private volatile boolean _running = false;
    private volatile Map<String, Object> _serverProperties;
    private final String _virtualHost;
    public ConsumerWorkService _workService = null;
    private final Collection<BlockedListener> blockedListeners = new CopyOnWriteArrayList();
    private final ExecutorService consumerWorkServiceExecutor;
    private final int handshakeTimeout;
    private final ScheduledExecutorService heartbeatExecutor;
    private Thread mainLoopThread;
    private final String password;
    private final int requestedChannelMax;
    private final int requestedFrameMax;
    private final int requestedHeartbeat;
    private final SaslConfig saslConfig;
    private final ExecutorService shutdownExecutor;
    private final int shutdownTimeout;
    private ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private final String username;

    public class MainLoop implements Runnable {
        private MainLoop() {
        }

        public void run() {
            ChannelManager channelManager;
            while (AMQConnection.this._running) {
                try {
                    Frame readFrame = AMQConnection.this._frameHandler.readFrame();
                    if (readFrame != null) {
                        AMQConnection.this._missedHeartbeats = 0;
                        if (readFrame.type != 8) {
                            if (readFrame.channel == 0) {
                                AMQConnection.this._channel0.handleFrame(readFrame);
                            } else if (AMQConnection.this.isOpen() && (channelManager = AMQConnection.this._channelManager) != null) {
                                channelManager.getChannel(readFrame.channel).handleFrame(readFrame);
                            }
                        }
                    } else {
                        AMQConnection.this.handleSocketTimeout();
                    }
                } catch (EOFException e) {
                    if (!AMQConnection.this._brokerInitiatedShutdown) {
                        AMQConnection.this.shutdown(null, false, e, true);
                    }
                } catch (Throwable th) {
                    AMQConnection.this._frameHandler.close();
                    AMQConnection.this._appContinuation.set(null);
                    AMQConnection.this.notifyListeners();
                    throw th;
                }
            }
            AMQConnection.this._frameHandler.close();
            AMQConnection.this._appContinuation.set(null);
            AMQConnection.this.notifyListeners();
        }
    }

    public class SocketCloseWait implements Runnable {
        private final ShutdownSignalException cause;

        public SocketCloseWait(ShutdownSignalException shutdownSignalException) {
            this.cause = shutdownSignalException;
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0022 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                com.rabbitmq.client.impl.AMQConnection r1 = com.rabbitmq.client.impl.AMQConnection.this     // Catch:{ InterruptedException -> 0x0022, TimeoutException -> 0x0011 }
                com.rabbitmq.utility.BlockingCell r1 = com.rabbitmq.client.impl.AMQConnection.access$900(r1)     // Catch:{ InterruptedException -> 0x0022, TimeoutException -> 0x0011 }
                long r2 = com.rabbitmq.client.impl.AMQConnection.access$1000()     // Catch:{ InterruptedException -> 0x0022, TimeoutException -> 0x0011 }
                r1.get(r2)     // Catch:{ InterruptedException -> 0x0022, TimeoutException -> 0x0011 }
                goto L_0x0011
            L_0x000f:
                r1 = move-exception
                goto L_0x002b
            L_0x0011:
                com.rabbitmq.client.impl.AMQConnection r1 = com.rabbitmq.client.impl.AMQConnection.this
                com.rabbitmq.client.impl.AMQConnection.access$102(r1, r0)
                com.rabbitmq.client.impl.AMQConnection r0 = com.rabbitmq.client.impl.AMQConnection.this
                com.rabbitmq.client.impl.AMQChannel r0 = com.rabbitmq.client.impl.AMQConnection.access$400(r0)
                com.rabbitmq.client.ShutdownSignalException r1 = r4.cause
                r0.notifyOutstandingRpc(r1)
                goto L_0x002a
            L_0x0022:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x000f }
                r1.interrupt()     // Catch:{ all -> 0x000f }
                goto L_0x0011
            L_0x002a:
                return
            L_0x002b:
                com.rabbitmq.client.impl.AMQConnection r2 = com.rabbitmq.client.impl.AMQConnection.this
                com.rabbitmq.client.impl.AMQConnection.access$102(r2, r0)
                com.rabbitmq.client.impl.AMQConnection r0 = com.rabbitmq.client.impl.AMQConnection.this
                com.rabbitmq.client.impl.AMQChannel r0 = com.rabbitmq.client.impl.AMQConnection.access$400(r0)
                com.rabbitmq.client.ShutdownSignalException r2 = r4.cause
                r0.notifyOutstandingRpc(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.impl.AMQConnection.SocketCloseWait.run():void");
        }
    }

    public AMQConnection(ConnectionParams connectionParams, FrameHandler frameHandler) {
        checkPreconditions();
        this.username = connectionParams.getUsername();
        this.password = connectionParams.getPassword();
        this._frameHandler = frameHandler;
        this._virtualHost = connectionParams.getVirtualHost();
        this._exceptionHandler = connectionParams.getExceptionHandler();
        this._clientProperties = new HashMap(connectionParams.getClientProperties());
        this.requestedFrameMax = connectionParams.getRequestedFrameMax();
        this.requestedChannelMax = connectionParams.getRequestedChannelMax();
        this.requestedHeartbeat = connectionParams.getRequestedHeartbeat();
        this.handshakeTimeout = connectionParams.getHandshakeTimeout();
        this.shutdownTimeout = connectionParams.getShutdownTimeout();
        this.saslConfig = connectionParams.getSaslConfig();
        this.consumerWorkServiceExecutor = connectionParams.getConsumerWorkServiceExecutor();
        this.heartbeatExecutor = connectionParams.getHeartbeatExecutor();
        this.shutdownExecutor = connectionParams.getShutdownExecutor();
        this.threadFactory = connectionParams.getThreadFactory();
        this._channelManager = null;
        this._brokerInitiatedShutdown = false;
        this._inConnectionNegotiation = true;
    }

    private static void checkPreconditions() {
        AMQCommand.checkPreconditions();
    }

    public static Map<String, Object> defaultClientProperties() {
        HashMap hashMap = new HashMap();
        hashMap.put("product", LongStringHelper.asLongString("RabbitMQ"));
        hashMap.put("version", LongStringHelper.asLongString(ClientVersion.VERSION));
        hashMap.put("platform", LongStringHelper.asLongString("Java"));
        hashMap.put("copyright", LongStringHelper.asLongString(Copyright.COPYRIGHT));
        hashMap.put("information", LongStringHelper.asLongString(Copyright.LICENSE));
        HashMap hashMap2 = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap2.put("publisher_confirms", bool);
        hashMap2.put("exchange_exchange_bindings", bool);
        hashMap2.put("basic.nack", bool);
        hashMap2.put("consumer_cancel_notify", bool);
        hashMap2.put("connection.blocked", bool);
        hashMap2.put("authentication_failure_close", bool);
        hashMap.put("capabilities", hashMap2);
        return hashMap;
    }

    private void ensureIsOpen() throws AlreadyClosedException {
        if (!isOpen()) {
            throw new AlreadyClosedException(getCloseReason());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishShutdown(ShutdownSignalException shutdownSignalException) {
        ChannelManager channelManager = this._channelManager;
        if (channelManager != null) {
            channelManager.handleSignal(shutdownSignalException);
        }
    }

    private String getHostAddress() {
        if (getAddress() == null) {
            return null;
        }
        return getAddress().getHostAddress();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleSocketTimeout() throws SocketTimeoutException {
        if (this._inConnectionNegotiation) {
            throw new SocketTimeoutException("Timeout during Connection negotiation");
        } else if (this._heartbeat != 0) {
            int i = this._missedHeartbeats + 1;
            this._missedHeartbeats = i;
            if (i > 8) {
                throw new MissedHeartbeatException(hj1.X(hj1.i0("Heartbeat missing with heartbeat = "), this._heartbeat, " seconds"));
            }
        }
    }

    private void initializeConsumerWorkService() {
        this._workService = new ConsumerWorkService(this.consumerWorkServiceExecutor, this.threadFactory, this.shutdownTimeout);
    }

    private void initializeHeartbeatSender() {
        this._heartbeatSender = new HeartbeatSender(this._frameHandler, this.heartbeatExecutor, this.threadFactory);
    }

    private static int negotiatedMaxValue(int i, int i2) {
        return (i == 0 || i2 == 0) ? Math.max(i, i2) : Math.min(i, i2);
    }

    private ShutdownSignalException startShutdown(Method method, boolean z, Throwable th, boolean z2) {
        ShutdownSignalException shutdownSignalException = new ShutdownSignalException(true, z, method, this);
        shutdownSignalException.initCause(th);
        if (setShutdownCauseIfOpen(shutdownSignalException) || !z) {
            this._heartbeatSender.shutdown();
            this._channel0.processShutdownSignal(shutdownSignalException, !z, z2);
            return shutdownSignalException;
        }
        throw new AlreadyClosedException(getCloseReason(), th);
    }

    @Override // com.rabbitmq.client.Connection
    public void abort() {
        abort(-1);
    }

    @Override // com.rabbitmq.client.Connection
    public void addBlockedListener(BlockedListener blockedListener) {
        this.blockedListeners.add(blockedListener);
    }

    @Override // com.rabbitmq.client.Connection
    public void clearBlockedListeners() {
        this.blockedListeners.clear();
    }

    @Override // com.rabbitmq.client.Connection
    public void close() throws IOException {
        close(-1);
    }

    @Override // com.rabbitmq.client.Connection
    public Channel createChannel(int i) throws IOException {
        ensureIsOpen();
        ChannelManager channelManager = this._channelManager;
        if (channelManager == null) {
            return null;
        }
        return channelManager.createChannel(this, i);
    }

    public final void disconnectChannel(ChannelN channelN) {
        ChannelManager channelManager = this._channelManager;
        if (channelManager != null) {
            channelManager.releaseChannelNumber(channelN);
        }
    }

    public void flush() throws IOException {
        this._frameHandler.flush();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection, com.rabbitmq.client.Connection
    public InetAddress getAddress() {
        return this._frameHandler.getAddress();
    }

    @Override // com.rabbitmq.client.Connection
    public int getChannelMax() {
        ChannelManager channelManager = this._channelManager;
        if (channelManager == null) {
            return 0;
        }
        return channelManager.getChannelMax();
    }

    @Override // com.rabbitmq.client.Connection
    public Map<String, Object> getClientProperties() {
        return new HashMap(this._clientProperties);
    }

    @Override // com.rabbitmq.client.Connection
    public String getClientProvidedName() {
        return (String) this._clientProperties.get("connection_name");
    }

    @Override // com.rabbitmq.client.Connection
    public ExceptionHandler getExceptionHandler() {
        return this._exceptionHandler;
    }

    public FrameHandler getFrameHandler() {
        return this._frameHandler;
    }

    @Override // com.rabbitmq.client.Connection
    public int getFrameMax() {
        return this._frameMax;
    }

    @Override // com.rabbitmq.client.Connection
    public int getHeartbeat() {
        return this._heartbeat;
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public InetAddress getLocalAddress() {
        return this._frameHandler.getLocalAddress();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public int getLocalPort() {
        return this._frameHandler.getLocalPort();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection, com.rabbitmq.client.Connection
    public int getPort() {
        return this._frameHandler.getPort();
    }

    @Override // com.rabbitmq.client.Connection
    public Map<String, Object> getServerProperties() {
        return this._serverProperties;
    }

    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public void handleConnectionClose(Command command) {
        ShutdownSignalException shutdown = shutdown(command.getMethod(), false, null, this._inConnectionNegotiation);
        try {
            this._channel0.quiescingTransmit(new AMQP.Connection.CloseOk.Builder().build());
        } catch (IOException unused) {
        }
        this._brokerInitiatedShutdown = true;
        SocketCloseWait socketCloseWait = new SocketCloseWait(shutdown);
        ExecutorService executorService = this.shutdownExecutor;
        if (executorService != null) {
            executorService.execute(socketCloseWait);
            return;
        }
        StringBuilder i0 = hj1.i0("RabbitMQ connection shutdown monitor ");
        i0.append(getHostAddress());
        i0.append(ProductDiscountsObject.KEY_DELIMITER);
        i0.append(getPort());
        Environment.newThread(this.threadFactory, socketCloseWait, i0.toString()).start();
    }

    public ChannelManager instantiateChannelManager(int i, ThreadFactory threadFactory2) {
        ChannelManager channelManager = new ChannelManager(this._workService, i, threadFactory2);
        channelManager.setShutdownExecutor(this.shutdownExecutor);
        return channelManager;
    }

    public int negotiateChannelMax(int i, int i2) {
        return negotiatedMaxValue(i, i2);
    }

    public boolean processControlCommand(Command command) throws IOException {
        Method method = command.getMethod();
        if (isOpen()) {
            if (method instanceof AMQP.Connection.Close) {
                handleConnectionClose(command);
                return true;
            } else if (method instanceof AMQP.Connection.Blocked) {
                AMQP.Connection.Blocked blocked = (AMQP.Connection.Blocked) method;
                try {
                    for (BlockedListener blockedListener : this.blockedListeners) {
                        blockedListener.handleBlocked(blocked.getReason());
                    }
                } catch (Throwable th) {
                    getExceptionHandler().handleBlockedListenerException(this, th);
                }
                return true;
            } else if (!(method instanceof AMQP.Connection.Unblocked)) {
                return false;
            } else {
                try {
                    for (BlockedListener blockedListener2 : this.blockedListeners) {
                        blockedListener2.handleUnblocked();
                    }
                } catch (Throwable th2) {
                    getExceptionHandler().handleBlockedListenerException(this, th2);
                }
                return true;
            }
        } else if (method instanceof AMQP.Connection.Close) {
            try {
                this._channel0.quiescingTransmit(new AMQP.Connection.CloseOk.Builder().build());
            } catch (IOException unused) {
            }
            return true;
        } else if (!(method instanceof AMQP.Connection.CloseOk)) {
            return true;
        } else {
            this._running = false;
            return !this._channel0.isOutstandingRpc();
        }
    }

    @Override // com.rabbitmq.client.Connection
    public boolean removeBlockedListener(BlockedListener blockedListener) {
        return this.blockedListeners.remove(blockedListener);
    }

    public void setHeartbeat(int i) {
        try {
            this._heartbeatSender.setHeartbeat(i);
            this._heartbeat = i;
            this._frameHandler.setTimeout((i * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL) / 4);
        } catch (SocketException unused) {
        }
    }

    public void setThreadFactory(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public ShutdownSignalException shutdown(Method method, boolean z, Throwable th, boolean z2) {
        ShutdownSignalException startShutdown = startShutdown(method, z, th, z2);
        finishShutdown(startShutdown);
        return startShutdown;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0168, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0169, code lost:
        r1 = r0.getReason();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x016f, code lost:
        if ((r1 instanceof com.rabbitmq.client.AMQP.Connection.Close) != false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0171, code lost:
        r1 = (com.rabbitmq.client.AMQP.Connection.Close) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0179, code lost:
        if (r1.getReplyCode() == 403) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0184, code lost:
        throw new com.rabbitmq.client.AuthenticationFailureException(r1.getReplyText());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x018a, code lost:
        throw new com.rabbitmq.client.PossibleAuthenticationFailureException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01b1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01b2, code lost:
        r8._frameHandler.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01b7, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01c4, code lost:
        r8._frameHandler.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01c9, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01b1 A[ExcHandler: IOException (r0v6 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:4:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c3 A[ExcHandler: TimeoutException (r0v3 'e' java.util.concurrent.TimeoutException A[CUSTOM_DECLARE]), Splitter:B:4:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() throws java.io.IOException, java.util.concurrent.TimeoutException {
        /*
        // Method dump skipped, instructions count: 465
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.impl.AMQConnection.start():void");
    }

    public String toString() {
        String str;
        if (ConnectionFactory.DEFAULT_VHOST.equals(this._virtualHost)) {
            str = this._virtualHost;
        } else {
            StringBuilder i0 = hj1.i0(ConnectionFactory.DEFAULT_VHOST);
            i0.append(this._virtualHost);
            str = i0.toString();
        }
        StringBuilder i02 = hj1.i0("amqp://");
        i02.append(this.username);
        i02.append("@");
        i02.append(getHostAddress());
        i02.append(ProductDiscountsObject.KEY_DELIMITER);
        i02.append(getPort());
        i02.append(str);
        return i02.toString();
    }

    public boolean willShutDownConsumerExecutor() {
        return this._workService.usesPrivateExecutor();
    }

    public void writeFrame(Frame frame) throws IOException {
        this._frameHandler.writeFrame(frame);
        this._heartbeatSender.signalActivity();
    }

    @Override // com.rabbitmq.client.Connection
    public void abort(int i, String str) {
        abort(i, str, -1);
    }

    @Override // com.rabbitmq.client.Connection
    public void close(int i) throws IOException {
        close(AMQP.REPLY_SUCCESS, "OK", i);
    }

    @Override // com.rabbitmq.client.Connection
    public void abort(int i) {
        abort(AMQP.REPLY_SUCCESS, "OK", i);
    }

    @Override // com.rabbitmq.client.Connection
    public void close(int i, String str) throws IOException {
        close(i, str, -1);
    }

    @Override // com.rabbitmq.client.Connection
    public void abort(int i, String str, int i2) {
        try {
            close(i, str, true, null, i2, true);
        } catch (IOException unused) {
        }
    }

    @Override // com.rabbitmq.client.Connection
    public void close(int i, String str, int i2) throws IOException {
        close(i, str, true, null, i2, false);
    }

    @Override // com.rabbitmq.client.Connection
    public Channel createChannel() throws IOException {
        ensureIsOpen();
        ChannelManager channelManager = this._channelManager;
        if (channelManager == null) {
            return null;
        }
        return channelManager.createChannel(this);
    }

    public void close(int i, String str, boolean z, Throwable th) throws IOException {
        close(i, str, z, th, -1, false);
    }

    public void close(int i, String str, boolean z, Throwable th, int i2, boolean z2) throws IOException {
        boolean z3 = Thread.currentThread() != this.mainLoopThread;
        try {
            AMQP.Connection.Close build = new AMQP.Connection.Close.Builder().replyCode(i).replyText(str).build();
            final ShutdownSignalException startShutdown = startShutdown(build, z, th, true);
            if (z3) {
                AnonymousClass2 r6 = new AMQChannel.BlockingRpcContinuation<AMQCommand>() {
                    /* class com.rabbitmq.client.impl.AMQConnection.AnonymousClass2 */

                    @Override // com.rabbitmq.client.impl.AMQChannel.BlockingRpcContinuation
                    public AMQCommand transformReply(AMQCommand aMQCommand) {
                        AMQConnection.this.finishShutdown(startShutdown);
                        return aMQCommand;
                    }
                };
                this._channel0.quiescingRpc(build, r6);
                r6.getReply(i2);
            } else {
                this._channel0.quiescingTransmit(build);
            }
            if (!z3) {
                return;
            }
        } catch (TimeoutException unused) {
            if (!z2) {
                ShutdownSignalException shutdownSignalException = new ShutdownSignalException(true, true, null, this);
                shutdownSignalException.initCause(th);
                throw shutdownSignalException;
            } else if (!z3) {
                return;
            }
        } catch (ShutdownSignalException e) {
            if (!z2) {
                throw e;
            } else if (!z3) {
                return;
            }
        } catch (IOException e2) {
            if (!z2) {
                throw e2;
            } else if (!z3) {
                return;
            }
        } catch (Throwable th2) {
            if (z3) {
                this._frameHandler.close();
            }
            throw th2;
        }
        this._frameHandler.close();
    }
}
