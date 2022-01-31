package com.rabbitmq.client.impl;

import com.rabbitmq.client.ExceptionHandler;
import com.rabbitmq.client.SaslConfig;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ConnectionParams {
    private Map<String, Object> clientProperties;
    private ExecutorService consumerWorkServiceExecutor;
    private ExceptionHandler exceptionHandler;
    private int handshakeTimeout;
    private ScheduledExecutorService heartbeatExecutor;
    private long networkRecoveryInterval;
    private String password;
    private int requestedChannelMax;
    private int requestedFrameMax;
    private int requestedHeartbeat;
    private SaslConfig saslConfig;
    private ExecutorService shutdownExecutor;
    private int shutdownTimeout;
    private ThreadFactory threadFactory;
    private boolean topologyRecovery;
    private String username;
    private String virtualHost;

    public Map<String, Object> getClientProperties() {
        return this.clientProperties;
    }

    public ExecutorService getConsumerWorkServiceExecutor() {
        return this.consumerWorkServiceExecutor;
    }

    public ExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public int getHandshakeTimeout() {
        return this.handshakeTimeout;
    }

    public ScheduledExecutorService getHeartbeatExecutor() {
        return this.heartbeatExecutor;
    }

    public long getNetworkRecoveryInterval() {
        return this.networkRecoveryInterval;
    }

    public String getPassword() {
        return this.password;
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

    public ExecutorService getShutdownExecutor() {
        return this.shutdownExecutor;
    }

    public int getShutdownTimeout() {
        return this.shutdownTimeout;
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

    public boolean isTopologyRecoveryEnabled() {
        return this.topologyRecovery;
    }

    public void setClientProperties(Map<String, Object> map) {
        this.clientProperties = map;
    }

    public void setConsumerWorkServiceExecutor(ExecutorService executorService) {
        this.consumerWorkServiceExecutor = executorService;
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler2) {
        this.exceptionHandler = exceptionHandler2;
    }

    public void setHandshakeTimeout(int i) {
        this.handshakeTimeout = i;
    }

    public void setHeartbeatExecutor(ScheduledExecutorService scheduledExecutorService) {
        this.heartbeatExecutor = scheduledExecutorService;
    }

    public void setNetworkRecoveryInterval(long j) {
        this.networkRecoveryInterval = j;
    }

    public void setPassword(String str) {
        this.password = str;
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

    public void setShutdownExecutor(ExecutorService executorService) {
        this.shutdownExecutor = executorService;
    }

    public void setShutdownTimeout(int i) {
        this.shutdownTimeout = i;
    }

    public void setThreadFactory(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public void setTopologyRecovery(boolean z) {
        this.topologyRecovery = z;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setVirtualHost(String str) {
        this.virtualHost = str;
    }
}
