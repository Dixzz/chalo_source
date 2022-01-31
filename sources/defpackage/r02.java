package defpackage;

import android.content.Context;

/* renamed from: r02  reason: default package */
public final class r02 {
    public static r02 b;

    /* renamed from: a  reason: collision with root package name */
    public i02 f3019a;

    public r02(Context context) {
        i02 a2 = i02.a(context);
        this.f3019a = a2;
        a2.b();
        this.f3019a.c();
    }

    public static synchronized r02 b(Context context) {
        r02 r02;
        synchronized (r02.class) {
            Context applicationContext = context.getApplicationContext();
            synchronized (r02.class) {
                if (b == null) {
                    b = new r02(applicationContext);
                }
                r02 = b;
            }
            return r02;
        }
        return r02;
    }

    public final synchronized void a() {
        i02 i02 = this.f3019a;
        i02.f1456a.lock();
        try {
            i02.b.edit().clear().apply();
        } finally {
            i02.f1456a.unlock();
        }
    }
}
