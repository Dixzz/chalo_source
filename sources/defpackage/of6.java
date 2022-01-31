package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: of6  reason: default package */
/* compiled from: Concurrent.kt */
public final class of6 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f2686a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f2686a = method;
    }
}
