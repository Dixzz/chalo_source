package com.google.firebase.database.connection;

import java.net.URI;

public class HostInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    private final String host;
    private final String namespace;
    private final boolean secure;

    public HostInfo(String str, String str2, boolean z) {
        this.host = str;
        this.namespace = str2;
        this.secure = z;
    }

    public static URI getConnectionUrl(String str, boolean z, String str2, String str3) {
        String str4 = z ? "wss" : "ws";
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append("://");
        sb.append(str);
        sb.append("/.ws?ns=");
        sb.append(str2);
        String c0 = hj1.c0(sb, "&", VERSION_PARAM, "=", "5");
        if (str3 != null) {
            c0 = hj1.T(c0, "&ls=", str3);
        }
        return URI.create(c0);
    }

    public String getHost() {
        return this.host;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("http");
        i0.append(this.secure ? "s" : "");
        i0.append("://");
        i0.append(this.host);
        return i0.toString();
    }
}
