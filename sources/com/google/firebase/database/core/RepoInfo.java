package com.google.firebase.database.core;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.emulators.EmulatedServiceSettings;
import java.net.URI;

public final class RepoInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    public String host;
    public String internalHost;
    public String namespace;
    public boolean secure;

    public void applyEmulatorSettings(@Nullable EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings != null) {
            String str = emulatedServiceSettings.getHost() + ProductDiscountsObject.KEY_DELIMITER + emulatedServiceSettings.getPort();
            this.host = str;
            this.internalHost = str;
            this.secure = false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RepoInfo.class != obj.getClass()) {
            return false;
        }
        RepoInfo repoInfo = (RepoInfo) obj;
        if (this.secure == repoInfo.secure && this.host.equals(repoInfo.host)) {
            return this.namespace.equals(repoInfo.namespace);
        }
        return false;
    }

    public URI getConnectionURL(String str) {
        StringBuilder k0 = hj1.k0(this.secure ? "wss" : "ws", "://");
        k0.append(this.internalHost);
        k0.append("/.ws?ns=");
        hj1.V0(k0, this.namespace, "&", VERSION_PARAM, "=");
        k0.append("5");
        String sb = k0.toString();
        if (str != null) {
            sb = hj1.T(sb, "&ls=", str);
        }
        return URI.create(sb);
    }

    public int hashCode() {
        return this.namespace.hashCode() + (((this.host.hashCode() * 31) + (this.secure ? 1 : 0)) * 31);
    }

    public boolean isCacheableHost() {
        return this.internalHost.startsWith("s-");
    }

    public boolean isCustomHost() {
        return !this.host.contains(".firebaseio.com") && !this.host.contains(".firebaseio-demo.com");
    }

    public boolean isDemoHost() {
        return this.host.contains(".firebaseio-demo.com");
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toDebugString() {
        StringBuilder i0 = hj1.i0("(host=");
        i0.append(this.host);
        i0.append(", secure=");
        i0.append(this.secure);
        i0.append(", ns=");
        i0.append(this.namespace);
        i0.append(" internal=");
        return hj1.a0(i0, this.internalHost, ")");
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("http");
        i0.append(this.secure ? "s" : "");
        i0.append("://");
        i0.append(this.host);
        return i0.toString();
    }
}
