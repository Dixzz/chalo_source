package defpackage;

import java.util.concurrent.CancellationException;

/* renamed from: sc6  reason: default package */
/* compiled from: Exceptions.kt */
public final class sc6 extends CancellationException {
    public final rc6 f;

    public sc6(String str, Throwable th, rc6 rc6) {
        super(str);
        this.f = rc6;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof sc6) {
                sc6 sc6 = (sc6) obj;
                if (!n86.a(sc6.getMessage(), getMessage()) || !n86.a(sc6.f, this.f) || !n86.a(sc6.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        n86.c(message);
        int hashCode = (this.f.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    public String toString() {
        return super.toString() + "; job=" + this.f;
    }
}
