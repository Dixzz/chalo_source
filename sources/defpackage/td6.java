package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import defpackage.n56;
import java.util.Objects;

/* renamed from: td6  reason: default package */
/* compiled from: HandlerDispatcher.kt */
public final class td6 {
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        Object obj2 = null;
        try {
            obj = new rd6(a(Looper.getMainLooper(), true), null, false);
        } catch (Throwable th) {
            obj = hd3.Z(th);
        }
        if (!(obj instanceof n56.a)) {
            obj2 = obj;
        }
        sd6 sd6 = (sd6) obj2;
    }

    public static final Handler a(Looper looper, boolean z) {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
