package defpackage;

import android.content.Context;
import defpackage.cv1;
import defpackage.jv1;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* renamed from: nv1  reason: default package */
/* compiled from: TransportRuntime */
public class nv1 implements mv1 {
    public static volatile ov1 e;

    /* renamed from: a  reason: collision with root package name */
    public final jy1 f2608a;
    public final jy1 b;
    public final kw1 c;
    public final ax1 d;

    @Inject
    public nv1(jy1 jy1, jy1 jy12, kw1 kw1, ax1 ax1, cx1 cx1) {
        this.f2608a = jy1;
        this.b = jy12;
        this.c = kw1;
        this.d = ax1;
        cx1.f765a.execute(new vw1(cx1));
    }

    public static nv1 a() {
        ov1 ov1 = e;
        if (ov1 != null) {
            return ((dv1) ov1).q.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (nv1.class) {
                if (e == null) {
                    Objects.requireNonNull(context);
                    e = new dv1(context, null);
                }
            }
        }
    }

    public eu1 c(ev1 ev1) {
        Set set;
        if (ev1 instanceof ev1) {
            Objects.requireNonNull((iu1) ev1);
            set = Collections.unmodifiableSet(iu1.f);
        } else {
            set = Collections.singleton(new zt1("proto"));
        }
        jv1.a a2 = jv1.a();
        Objects.requireNonNull(ev1);
        a2.b("cct");
        cv1.b bVar = (cv1.b) a2;
        bVar.b = ((iu1) ev1).b();
        return new kv1(set, bVar.a(), this);
    }
}
