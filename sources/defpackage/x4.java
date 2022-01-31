package defpackage;

import java.lang.reflect.Method;

/* renamed from: x4  reason: default package */
/* compiled from: ActivityRecreator */
public class x4 implements Runnable {
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public x4(Object obj, Object obj2) {
        this.f = obj;
        this.g = obj2;
    }

    public void run() {
        Boolean bool = Boolean.FALSE;
        try {
            Method method = w4.d;
            if (method != null) {
                method.invoke(this.f, this.g, bool, "AppCompat recreation");
                return;
            }
            w4.e.invoke(this.f, this.g, bool);
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable unused) {
        }
    }
}
