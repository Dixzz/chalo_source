package com.rabbitmq.client;

import com.rabbitmq.utility.SensibleClone;

public class ShutdownSignalException extends RuntimeException implements SensibleClone<ShutdownSignalException> {
    private static final long serialVersionUID = 1;
    private final boolean _hardError;
    private final boolean _initiatedByApplication;
    private final Method _reason;
    private final Object _ref;

    public ShutdownSignalException(boolean z, boolean z2, Method method, Object obj) {
        this(z, z2, method, obj, "", null);
    }

    private static String composeMessage(boolean z, boolean z2, Method method, String str, Throwable th) {
        String str2 = z ? "connection" : "channel";
        String T = hj1.T("clean ", str2, " shutdown");
        String S = hj1.S(str2, " error");
        if (!z2) {
            T = S;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(T);
        if (method != null) {
            sb.append("; protocol method: ");
            sb.append(method);
        }
        if (th != null) {
            sb.append("; cause: ");
            sb.append(th);
        }
        return sb.toString();
    }

    public Method getReason() {
        return this._reason;
    }

    public Object getReference() {
        return this._ref;
    }

    public boolean isHardError() {
        return this._hardError;
    }

    public boolean isInitiatedByApplication() {
        return this._initiatedByApplication;
    }

    public ShutdownSignalException(boolean z, boolean z2, Method method, Object obj, String str, Throwable th) {
        super(composeMessage(z, z2, method, str, th));
        this._hardError = z;
        this._initiatedByApplication = z2;
        this._reason = method;
        this._ref = obj;
    }

    @Override // com.rabbitmq.utility.SensibleClone
    public ShutdownSignalException sensibleClone() {
        try {
            return (ShutdownSignalException) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
