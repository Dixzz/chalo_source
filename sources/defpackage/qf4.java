package defpackage;

import android.content.Context;
import android.content.Intent;
import defpackage.uf4;

/* renamed from: qf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class qf4<T extends Context & uf4> {

    /* renamed from: a  reason: collision with root package name */
    public final T f2940a;

    public qf4(T t) {
        this.f2940a = t;
    }

    public final boolean a(Intent intent) {
        if (intent == null) {
            b().f.a("onUnbind called with null intent");
            return true;
        }
        b().n.b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final ra4 b() {
        return vb4.b(this.f2940a, null, null).g();
    }

    public final void c(Intent intent) {
        if (intent == null) {
            b().f.a("onRebind called with null intent");
            return;
        }
        b().n.b("onRebind called. action", intent.getAction());
    }
}
