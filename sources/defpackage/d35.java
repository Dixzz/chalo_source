package defpackage;

/* renamed from: d35  reason: default package */
/* compiled from: ReaderException */
public abstract class d35 extends Exception {
    public static final boolean f = (System.getProperty("surefire.test.class.path") != null);
    public static final StackTraceElement[] g = new StackTraceElement[0];

    public d35() {
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public d35(Throwable th) {
        super(th);
    }
}
