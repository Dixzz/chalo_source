package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import defpackage.t2;
import defpackage.x22;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: f72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class f72 implements y52 {
    public final Context f;
    public final d52 g;
    public final Looper h;
    public final h52 i;
    public final h52 j;
    public final Map<x22.c<?>, h52> k;
    public final Set<a42> l = Collections.newSetFromMap(new WeakHashMap());
    public final x22.f m;
    public Bundle n;
    public ConnectionResult o = null;
    public ConnectionResult p = null;
    public boolean q = false;
    public final Lock r;
    @GuardedBy("mLock")
    public int s = 0;

    public f72(Context context, d52 d52, Lock lock, Looper looper, r22 r22, Map<x22.c<?>, x22.f> map, Map<x22.c<?>, x22.f> map2, x72 x72, x22.a<? extends ni4, zh4> aVar, x22.f fVar, ArrayList<a72> arrayList, ArrayList<a72> arrayList2, Map<x22<?>, Boolean> map3, Map<x22<?>, Boolean> map4) {
        this.f = context;
        this.g = d52;
        this.r = lock;
        this.h = looper;
        this.m = fVar;
        this.i = new h52(context, d52, lock, looper, r22, map2, null, map4, null, arrayList2, new d72(this));
        this.j = new h52(context, d52, lock, looper, r22, map, x72, map3, aVar, arrayList, new e72(this));
        n2 n2Var = new n2();
        Iterator it = ((t2.c) ((n2) map2).keySet()).iterator();
        while (true) {
            t2.a aVar2 = (t2.a) it;
            if (!aVar2.hasNext()) {
                break;
            }
            n2Var.put((x22.c) aVar2.next(), this.i);
        }
        Iterator it2 = ((t2.c) ((n2) map).keySet()).iterator();
        while (true) {
            t2.a aVar3 = (t2.a) it2;
            if (aVar3.hasNext()) {
                n2Var.put((x22.c) aVar3.next(), this.j);
            } else {
                this.k = Collections.unmodifiableMap(n2Var);
                return;
            }
        }
    }

    public static boolean n(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m1();
    }

    public static void p(f72 f72) {
        ConnectionResult connectionResult;
        if (n(f72.o)) {
            if (n(f72.p) || f72.k()) {
                int i2 = f72.s;
                if (i2 != 1) {
                    if (i2 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        f72.s = 0;
                        return;
                    }
                    d52 d52 = f72.g;
                    Objects.requireNonNull(d52, "null reference");
                    d52.a(f72.n);
                }
                f72.j();
                f72.s = 0;
                return;
            }
            ConnectionResult connectionResult2 = f72.p;
            if (connectionResult2 == null) {
                return;
            }
            if (f72.s == 1) {
                f72.j();
                return;
            }
            f72.q(connectionResult2);
            f72.i.c();
        } else if (f72.o == null || !n(f72.p)) {
            ConnectionResult connectionResult3 = f72.o;
            if (connectionResult3 != null && (connectionResult = f72.p) != null) {
                if (f72.j.r < f72.i.r) {
                    connectionResult3 = connectionResult;
                }
                f72.q(connectionResult3);
            }
        } else {
            f72.j.c();
            ConnectionResult connectionResult4 = f72.o;
            Objects.requireNonNull(connectionResult4, "null reference");
            f72.q(connectionResult4);
        }
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final void a() {
        this.s = 2;
        this.q = false;
        this.p = null;
        this.o = null;
        this.i.p.a();
        this.j.p.a();
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final <A extends x22.b, T extends l32<? extends f32, A>> T b(T t) {
        if (!l(t)) {
            return (T) this.i.b(t);
        }
        if (!k()) {
            return (T) this.j.b(t);
        }
        t.n(new Status(4, null, m()));
        return t;
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final void c() {
        this.p = null;
        this.o = null;
        this.s = 0;
        this.i.c();
        this.j.c();
        j();
    }

    @Override // defpackage.y52
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(ProductDiscountsObject.KEY_DELIMITER);
        this.j.d(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(ProductDiscountsObject.KEY_DELIMITER);
        this.i.d(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t) {
        if (!l(t)) {
            this.i.e(t);
            return t;
        } else if (k()) {
            t.n(new Status(4, null, m()));
            return t;
        } else {
            this.j.e(t);
            return t;
        }
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final ConnectionResult f() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.y52
    public final boolean g(a42 a42) {
        this.r.lock();
        try {
            if ((o() || i()) && !(this.j.p instanceof k42)) {
                this.l.add(a42);
                if (this.s == 0) {
                    this.s = 1;
                }
                this.p = null;
                this.j.p.a();
                return true;
            }
            this.r.unlock();
            return false;
        } finally {
            this.r.unlock();
        }
    }

    @Override // defpackage.y52
    public final void h() {
        this.r.lock();
        try {
            boolean o2 = o();
            this.j.c();
            this.p = new ConnectionResult(4);
            if (o2) {
                new ve2(this.h).post(new c72(this));
            } else {
                j();
            }
        } finally {
            this.r.unlock();
        }
    }

    @Override // defpackage.y52
    public final boolean i() {
        this.r.lock();
        try {
            boolean z = false;
            if ((this.i.p instanceof k42) && ((this.j.p instanceof k42) || k() || this.s == 1)) {
                z = true;
            }
            return z;
        } finally {
            this.r.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void j() {
        for (a42 a42 : this.l) {
            a42.a();
        }
        this.l.clear();
    }

    @GuardedBy("mLock")
    public final boolean k() {
        ConnectionResult connectionResult = this.p;
        return connectionResult != null && connectionResult.g == 4;
    }

    public final boolean l(l32<? extends f32, ? extends x22.b> l32) {
        h52 h52 = this.k.get(l32.o);
        gj1.l(h52, "GoogleApiClient is not configured to use the API required for this call.");
        return h52.equals(this.j);
    }

    public final PendingIntent m() {
        if (this.m == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f, System.identityHashCode(this.g), this.m.getSignInIntent(), 134217728);
    }

    public final boolean o() {
        this.r.lock();
        try {
            return this.s == 2;
        } finally {
            this.r.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void q(ConnectionResult connectionResult) {
        int i2 = this.s;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.s = 0;
            }
            this.g.b(connectionResult);
        }
        j();
        this.s = 0;
    }
}
