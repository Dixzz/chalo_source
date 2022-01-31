package com.rabbitmq.client;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.impl.AMQConnection;
import com.rabbitmq.client.impl.ConnectionParams;
import com.rabbitmq.client.impl.DefaultExceptionHandler;
import com.rabbitmq.client.impl.FrameHandlerFactory;
import com.rabbitmq.client.impl.recovery.AutorecoveringConnection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeoutException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class ConnectionFactory implements Cloneable {
    public static final int DEFAULT_AMQP_OVER_SSL_PORT = 5671;
    public static final int DEFAULT_AMQP_PORT = 5672;
    public static final int DEFAULT_CHANNEL_MAX = 0;
    public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
    public static final int DEFAULT_FRAME_MAX = 0;
    public static final int DEFAULT_HANDSHAKE_TIMEOUT = 10000;
    public static final int DEFAULT_HEARTBEAT = 60;
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_PASS = "guest";
    public static final int DEFAULT_SHUTDOWN_TIMEOUT = 10000;
    public static final String DEFAULT_USER = "guest";
    public static final String DEFAULT_VHOST = "/";
    private static final String FALLBACK_TLS_PROTOCOL = "TLSv1";
    private static final String PREFERRED_TLS_PROTOCOL = "TLSv1.2";
    public static final int USE_DEFAULT_PORT = -1;
    private Map<String, Object> _clientProperties = AMQConnection.defaultClientProperties();
    private boolean automaticRecovery = false;
    private int connectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    private ExceptionHandler exceptionHandler = new DefaultExceptionHandler();
    private SocketFactory factory = SocketFactory.getDefault();
    private int handshakeTimeout = 10000;
    private ScheduledExecutorService heartbeatExecutor;
    private String host = DEFAULT_HOST;
    private long networkRecoveryInterval = 5000;
    private String password = "guest";
    private int port = -1;
    private int requestedChannelMax = 0;
    private int requestedFrameMax = 0;
    private int requestedHeartbeat = 60;
    private SaslConfig saslConfig = DefaultSaslConfig.PLAIN;
    private ExecutorService sharedExecutor;
    private ExecutorService shutdownExecutor;
    private int shutdownTimeout = 10000;
    private SocketConfigurator socketConf = new DefaultSocketConfigurator();
    private ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private boolean topologyRecovery = true;
    private String username = "guest";
    private String virtualHost = DEFAULT_VHOST;

    public static String computeDefaultTlsProcotol(String[] strArr) {
        if (strArr == null) {
            return FALLBACK_TLS_PROTOCOL;
        }
        for (String str : strArr) {
            if (PREFERRED_TLS_PROTOCOL.equalsIgnoreCase(str)) {
                return str;
            }
        }
        return FALLBACK_TLS_PROTOCOL;
    }

    public static int portOrDefault(int i, boolean z) {
        if (i != -1) {
            return i;
        }
        if (z) {
            return DEFAULT_AMQP_OVER_SSL_PORT;
        }
        return 5672;
    }

    private String uriDecode(String str) {
        try {
            return URLDecoder.decode(str.replace("+", "%2B"), "US-ASCII");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FrameHandlerFactory createFrameHandlerFactory() throws IOException {
        return new FrameHandlerFactory(this.connectionTimeout, this.factory, this.socketConf, isSSL());
    }

    public Map<String, Object> getClientProperties() {
        return this._clientProperties;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public ExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public int getHandshakeTimeout() {
        return this.handshakeTimeout;
    }

    public String getHost() {
        return this.host;
    }

    public long getNetworkRecoveryInterval() {
        return this.networkRecoveryInterval;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPort() {
        return portOrDefault(this.port, isSSL());
    }

    public int getRequestedChannelMax() {
        return this.requestedChannelMax;
    }

    public int getRequestedFrameMax() {
        return this.requestedFrameMax;
    }

    public int getRequestedHeartbeat() {
        return this.requestedHeartbeat;
    }

    public SaslConfig getSaslConfig() {
        return this.saslConfig;
    }

    public int getShutdownTimeout() {
        return this.shutdownTimeout;
    }

    public SocketConfigurator getSocketConfigurator() {
        return this.socketConf;
    }

    public SocketFactory getSocketFactory() {
        return this.factory;
    }

    public ThreadFactory getThreadFactory() {
        return this.threadFactory;
    }

    public String getUsername() {
        return this.username;
    }

    public String getVirtualHost() {
        return this.virtualHost;
    }

    public boolean isAutomaticRecoveryEnabled() {
        return this.automaticRecovery;
    }

    public boolean isSSL() {
        return getSocketFactory() instanceof SSLSocketFactory;
    }

    public boolean isTopologyRecoveryEnabled() {
        return this.topologyRecovery;
    }

    public Connection newConnection(Address[] addressArr) throws IOException, TimeoutException {
        return newConnection(this.sharedExecutor, Arrays.asList(addressArr), (String) null);
    }

    public ConnectionParams params(ExecutorService executorService) {
        ConnectionParams connectionParams = new ConnectionParams();
        connectionParams.setUsername(this.username);
        connectionParams.setPassword(this.password);
        connectionParams.setConsumerWorkServiceExecutor(executorService);
        connectionParams.setVirtualHost(this.virtualHost);
        connectionParams.setClientProperties(getClientProperties());
        connectionParams.setRequestedFrameMax(this.requestedFrameMax);
        connectionParams.setRequestedChannelMax(this.requestedChannelMax);
        connectionParams.setShutdownTimeout(this.shutdownTimeout);
        connectionParams.setSaslConfig(this.saslConfig);
        connectionParams.setNetworkRecoveryInterval(this.networkRecoveryInterval);
        connectionParams.setTopologyRecovery(this.topologyRecovery);
        connectionParams.setExceptionHandler(this.exceptionHandler);
        connectionParams.setThreadFactory(this.threadFactory);
        connectionParams.setHandshakeTimeout(this.handshakeTimeout);
        connectionParams.setRequestedHeartbeat(this.requestedHeartbeat);
        connectionParams.setShutdownExecutor(this.shutdownExecutor);
        connectionParams.setHeartbeatExecutor(this.heartbeatExecutor);
        return connectionParams;
    }

    public void setAutomaticRecoveryEnabled(boolean z) {
        this.automaticRecovery = z;
    }

    public void setClientProperties(Map<String, Object> map) {
        this._clientProperties = map;
    }

    public void setConnectionTimeout(int i) {
        if (i >= 0) {
            this.connectionTimeout = i;
            return;
        }
        throw new IllegalArgumentException("TCP connection timeout cannot be negative");
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler2) {
        if (exceptionHandler2 != null) {
            this.exceptionHandler = exceptionHandler2;
            return;
        }
        throw new IllegalArgumentException("exception handler cannot be null!");
    }

    public void setHandshakeTimeout(int i) {
        if (i >= 0) {
            this.handshakeTimeout = i;
            return;
        }
        throw new IllegalArgumentException("handshake timeout cannot be negative");
    }

    public void setHeartbeatExecutor(ScheduledExecutorService scheduledExecutorService) {
        this.heartbeatExecutor = scheduledExecutorService;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setNetworkRecoveryInterval(int i) {
        this.networkRecoveryInterval = (long) i;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setRequestedChannelMax(int i) {
        this.requestedChannelMax = i;
    }

    public void setRequestedFrameMax(int i) {
        this.requestedFrameMax = i;
    }

    public void setRequestedHeartbeat(int i) {
        this.requestedHeartbeat = i;
    }

    public void setSaslConfig(SaslConfig saslConfig2) {
        this.saslConfig = saslConfig2;
    }

    public void setSharedExecutor(ExecutorService executorService) {
        this.sharedExecutor = executorService;
    }

    public void setShutdownExecutor(ExecutorService executorService) {
        this.shutdownExecutor = executorService;
    }

    public void setShutdownTimeout(int i) {
        this.shutdownTimeout = i;
    }

    public void setSocketConfigurator(SocketConfigurator socketConfigurator) {
        this.socketConf = socketConfigurator;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.factory = socketFactory;
    }

    public void setThreadFactory(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public void setTopologyRecoveryEnabled(boolean z) {
        this.topologyRecovery = z;
    }

    public void setUri(URI uri) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
        if (!"amqp".equals(uri.getScheme().toLowerCase())) {
            if ("amqps".equals(uri.getScheme().toLowerCase())) {
                setPort(DEFAULT_AMQP_OVER_SSL_PORT);
                useSslProtocol();
            } else {
                StringBuilder i0 = hj1.i0("Wrong scheme in AMQP URI: ");
                i0.append(uri.getScheme());
                throw new IllegalArgumentException(i0.toString());
            }
        }
        String host2 = uri.getHost();
        if (host2 != null) {
            setHost(host2);
        }
        int port2 = uri.getPort();
        if (port2 != -1) {
            setPort(port2);
        }
        String rawUserInfo = uri.getRawUserInfo();
        if (rawUserInfo != null) {
            String[] split = rawUserInfo.split(ProductDiscountsObject.KEY_DELIMITER);
            if (split.length <= 2) {
                setUsername(uriDecode(split[0]));
                if (split.length == 2) {
                    setPassword(uriDecode(split[1]));
                }
            } else {
                throw new IllegalArgumentException(hj1.S("Bad user info in AMQP URI: ", rawUserInfo));
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath != null && rawPath.length() > 0) {
            if (rawPath.indexOf(47, 1) == -1) {
                setVirtualHost(uriDecode(uri.getPath().substring(1)));
                return;
            }
            throw new IllegalArgumentException(hj1.S("Multiple segments in path of AMQP URI: ", rawPath));
        }
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setVirtualHost(String str) {
        this.virtualHost = str;
    }

    public void useSslProtocol() throws NoSuchAlgorithmException, KeyManagementException {
        useSslProtocol(computeDefaultTlsProcotol(SSLContext.getDefault().getSupportedSSLParameters().getProtocols()));
    }

    @Override // java.lang.Object
    public ConnectionFactory clone() {
        try {
            return (ConnectionFactory) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    public Connection newConnection(Address[] addressArr, String str) throws IOException, TimeoutException {
        return newConnection(this.sharedExecutor, Arrays.asList(addressArr), str);
    }

    public void setNetworkRecoveryInterval(long j) {
        this.networkRecoveryInterval = j;
    }

    public void useSslProtocol(String str) throws NoSuchAlgorithmException, KeyManagementException {
        useSslProtocol(str, new NullTrustManager());
    }

    public Connection newConnection(List<Address> list) throws IOException, TimeoutException {
        return newConnection(this.sharedExecutor, list, (String) null);
    }

    public void useSslProtocol(String str, TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance(str);
        instance.init(null, new TrustManager[]{trustManager}, null);
        useSslProtocol(instance);
    }

    public Connection newConnection(List<Address> list, String str) throws IOException, TimeoutException {
        return newConnection(this.sharedExecutor, list, str);
    }

    public Connection newConnection(ExecutorService executorService, Address[] addressArr) throws IOException, TimeoutException {
        return newConnection(executorService, Arrays.asList(addressArr), (String) null);
    }

    public Connection newConnection(ExecutorService executorService, Address[] addressArr, String str) throws IOException, TimeoutException {
        return newConnection(executorService, Arrays.asList(addressArr), str);
    }

    public void useSslProtocol(SSLContext sSLContext) {
        setSocketFactory(sSLContext.getSocketFactory());
    }

    public Connection newConnection(ExecutorService executorService, List<Address> list) throws IOException, TimeoutException {
        return newConnection(executorService, list, (String) null);
    }

    public Connection newConnection(ExecutorService executorService, List<Address> list, String str) throws IOException, TimeoutException {
        FrameHandlerFactory createFrameHandlerFactory = createFrameHandlerFactory();
        ConnectionParams params = params(executorService);
        if (str != null) {
            HashMap hashMap = new HashMap(params.getClientProperties());
            hashMap.put("connection_name", str);
            params.setClientProperties(hashMap);
        }
        if (isAutomaticRecoveryEnabled()) {
            AutorecoveringConnection autorecoveringConnection = new AutorecoveringConnection(params, createFrameHandlerFactory, list);
            autorecoveringConnection.init();
            return autorecoveringConnection;
        }
        IOException e = null;
        for (Address address : list) {
            try {
                AMQConnection aMQConnection = new AMQConnection(params, createFrameHandlerFactory.create(address));
                aMQConnection.start();
                return aMQConnection;
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
        throw new IOException("failed to connect");
    }

    public Connection newConnection() throws IOException, TimeoutException {
        return newConnection(this.sharedExecutor, Collections.singletonList(new Address(getHost(), getPort())));
    }

    public Connection newConnection(String str) throws IOException, TimeoutException {
        return newConnection(this.sharedExecutor, Collections.singletonList(new Address(getHost(), getPort())), str);
    }

    public void setUri(String str) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
        setUri(new URI(str));
    }

    public Connection newConnection(ExecutorService executorService) throws IOException, TimeoutException {
        return newConnection(executorService, Collections.singletonList(new Address(getHost(), getPort())));
    }

    public Connection newConnection(ExecutorService executorService, String str) throws IOException, TimeoutException {
        return newConnection(executorService, Collections.singletonList(new Address(getHost(), getPort())), str);
    }
}
