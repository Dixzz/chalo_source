package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;

/* renamed from: eq  reason: default package */
/* compiled from: DefaultRunnableScheduler */
public class eq {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1017a;

    public eq() {
        Handler handler;
        Handler handler2;
        Looper mainLooper = Looper.getMainLooper();
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler.createAsync(mainLooper);
        } else {
            try {
                handler2 = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                handler2 = new Handler(mainLooper);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new RuntimeException(cause);
                }
            }
            handler = handler2;
        }
        this.f1017a = handler;
    }
}
