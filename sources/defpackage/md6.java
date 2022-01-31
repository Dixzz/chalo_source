package defpackage;

/* renamed from: md6  reason: default package */
/* compiled from: EventLoop.common.kt */
public final class md6 {

    /* renamed from: a  reason: collision with root package name */
    public static final md6 f2360a = null;
    public static final ThreadLocal<bc6> b = new ThreadLocal<>();

    public static final bc6 a() {
        ThreadLocal<bc6> threadLocal = b;
        bc6 bc6 = threadLocal.get();
        if (bc6 != null) {
            return bc6;
        }
        na6 na6 = new na6(Thread.currentThread());
        threadLocal.set(na6);
        return na6;
    }
}
