package com.rabbitmq.client;

import com.rabbitmq.client.impl.Version;
import java.net.ProtocolException;

public class ProtocolVersionMismatchException extends ProtocolException {
    private static final long serialVersionUID = 1;
    private final Version clientVersion;
    private final Version serverVersion;

    public ProtocolVersionMismatchException(Version version, Version version2) {
        super("Protocol version mismatch: expected " + version + ", got " + version2);
        this.clientVersion = version;
        this.serverVersion = version2;
    }

    public int getClientMajor() {
        return this.clientVersion.getMajor();
    }

    public int getClientMinor() {
        return this.clientVersion.getMinor();
    }

    public Version getClientVersion() {
        return this.clientVersion;
    }

    public int getServerMajor() {
        return this.serverVersion.getMajor();
    }

    public int getServerMinor() {
        return this.serverVersion.getMinor();
    }

    public Version getServerVersion() {
        return this.serverVersion;
    }
}
