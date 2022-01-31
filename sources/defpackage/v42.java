package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: v42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class v42 implements e52 {

    /* renamed from: a  reason: collision with root package name */
    public final h52 f3596a;
    public final Lock b;
    public final Context c;
    public final r22 d;
    public ConnectionResult e;
    public int f;
    public int g = 0;
    public int h;
    public final Bundle i = new Bundle();
    public final Set<x22.c> j = new HashSet();
    public ni4 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c82 o;
    public boolean p;
    public boolean q;
    public final x72 r;
    public final Map<x22<?>, Boolean> s;
    public final x22.a<? extends ni4, zh4> t;
    public final ArrayList<Future<?>> u = new ArrayList<>();

    public v42(h52 h52, x72 x72, Map<x22<?>, Boolean> map, r22 r22, x22.a<? extends ni4, zh4> aVar, Lock lock, Context context) {
        this.f3596a = h52;
        this.r = x72;
        this.s = map;
        this.d = r22;
        this.t = aVar;
        this.b = lock;
        this.c = context;
    }

    @Override // defpackage.e52
    public final void a() {
    }

    @Override // defpackage.e52
    public final <A extends x22.b, T extends l32<? extends f32, A>> T b(T t2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // defpackage.e52
    @GuardedBy("mLock")
    public final boolean c() {
        o();
        n(true);
        this.f3596a.j(null);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [x22$f, ni4] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.e52
    @javax.annotation.concurrent.GuardedBy("mLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v42.d():void");
    }

    @Override // defpackage.e52
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t2) {
        this.f3596a.s.h.add(t2);
        return t2;
    }

    @Override // defpackage.e52
    @GuardedBy("mLock")
    public final void f(Bundle bundle) {
        if (p(1)) {
            if (bundle != null) {
                this.i.putAll(bundle);
            }
            if (q()) {
                j();
            }
        }
    }

    @Override // defpackage.e52
    @GuardedBy("mLock")
    public final void g(int i2) {
        m(new ConnectionResult(8, null));
    }

    @Override // defpackage.e52
    @GuardedBy("mLock")
    public final void h(ConnectionResult connectionResult, x22<?> x22, boolean z) {
        if (p(1)) {
            k(connectionResult, x22, z);
            if (q()) {
                j();
            }
        }
    }

    @GuardedBy("mLock")
    public final void i() {
        if (this.h == 0) {
            if (!this.m || this.n) {
                ArrayList arrayList = new ArrayList();
                this.g = 1;
                this.h = this.f3596a.k.size();
                for (x22.c<?> cVar : this.f3596a.k.keySet()) {
                    if (!this.f3596a.l.containsKey(cVar)) {
                        arrayList.add(this.f3596a.k.get(cVar));
                    } else if (q()) {
                        j();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.u.add(i52.f1480a.submit(new q42(this, arrayList)));
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @GuardedBy("mLock")
    public final void j() {
        Bundle bundle;
        h52 h52 = this.f3596a;
        h52.f.lock();
        try {
            h52.s.u();
            h52.p = new k42(h52);
            h52.p.d();
            h52.g.signalAll();
            h52.f.unlock();
            i52.f1480a.execute(new l42(this));
            ni4 ni4 = this.k;
            if (ni4 != null) {
                if (this.p) {
                    c82 c82 = this.o;
                    Objects.requireNonNull(c82, "null reference");
                    ni4.a(c82, this.q);
                }
                n(false);
            }
            for (x22.c<?> cVar : this.f3596a.l.keySet()) {
                x22.f fVar = this.f3596a.k.get(cVar);
                Objects.requireNonNull(fVar, "null reference");
                fVar.disconnect();
            }
            if (this.i.isEmpty()) {
                bundle = null;
            } else {
                bundle = this.i;
            }
            this.f3596a.t.a(bundle);
        } catch (Throwable th) {
            h52.f.unlock();
            throw th;
        }
    }

    @GuardedBy("mLock")
    public final void k(ConnectionResult connectionResult, x22<?> x22, boolean z) {
        int priority = x22.f3873a.getPriority();
        if ((!z || connectionResult.l1() || this.d.a(null, connectionResult.g, null) != null) && (this.e == null || priority < this.f)) {
            this.e = connectionResult;
            this.f = priority;
        }
        this.f3596a.l.put(x22.b, connectionResult);
    }

    @GuardedBy("mLock")
    public final void l() {
        this.m = false;
        this.f3596a.s.p = Collections.emptySet();
        for (x22.c<?> cVar : this.j) {
            if (!this.f3596a.l.containsKey(cVar)) {
                this.f3596a.l.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    @GuardedBy("mLock")
    public final void m(ConnectionResult connectionResult) {
        o();
        n(!connectionResult.l1());
        this.f3596a.j(connectionResult);
        this.f3596a.t.b(connectionResult);
    }

    @GuardedBy("mLock")
    public final void n(boolean z) {
        ni4 ni4 = this.k;
        if (ni4 != null) {
            if (ni4.isConnected() && z) {
                ni4.b();
            }
            ni4.disconnect();
            Objects.requireNonNull(this.r, "null reference");
            this.o = null;
        }
    }

    public final void o() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).cancel(true);
        }
        this.u.clear();
    }

    @GuardedBy("mLock")
    public final boolean p(int i2) {
        if (this.g == i2) {
            return true;
        }
        d52 d52 = this.f3596a.s;
        Objects.requireNonNull(d52);
        StringWriter stringWriter = new StringWriter();
        d52.h("", null, new PrintWriter(stringWriter), null);
        stringWriter.toString();
        String.valueOf(this).length();
        String str = "STEP_GETTING_REMOTE_SERVICE";
        String str2 = this.g != 0 ? str : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
        if (i2 == 0) {
            str = "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
        }
        str2.length();
        str.length();
        new Exception();
        m(new ConnectionResult(8, null));
        return false;
    }

    @GuardedBy("mLock")
    public final boolean q() {
        int i2 = this.h - 1;
        this.h = i2;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            d52 d52 = this.f3596a.s;
            Objects.requireNonNull(d52);
            StringWriter stringWriter = new StringWriter();
            d52.h("", null, new PrintWriter(stringWriter), null);
            stringWriter.toString();
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.e;
        if (connectionResult == null) {
            return true;
        }
        this.f3596a.r = this.f;
        m(connectionResult);
        return false;
    }
}
