package defpackage;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import defpackage.a32;
import defpackage.t32;
import defpackage.x22;
import defpackage.x22.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: p52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class p52<O extends x22.d> implements a32.b, a32.c, b72 {
    public final Queue<q62> f = new LinkedList();
    @NotOnlyInitialized
    public final x22.f g;
    public final j32<O> h;
    public final f42 i;
    public final Set<t62> j = new HashSet();
    public final Map<t32.a<?>, e62> k = new HashMap();
    public final int l;
    public final i62 m;
    public boolean n;
    public final List<q52> o = new ArrayList();
    public ConnectionResult p = null;
    public int q = 0;
    public final /* synthetic */ o32 r;

    public p52(o32 o32, z22<O> z22) {
        this.r = o32;
        x22.f zaa = z22.zaa(o32.n.getLooper(), this);
        this.g = zaa;
        this.h = z22.getApiKey();
        this.i = new f42();
        this.l = z22.zab();
        if (zaa.requiresSignIn()) {
            this.m = z22.zac(o32.e, o32.n);
        } else {
            this.m = null;
        }
    }

    @Override // defpackage.n32
    public final void C(int i2) {
        if (Looper.myLooper() == this.r.n.getLooper()) {
            b(i2);
        } else {
            this.r.n.post(new m52(this, i2));
        }
    }

    @Override // defpackage.b72
    public final void C1(ConnectionResult connectionResult, x22<?> x22, boolean z) {
        throw null;
    }

    @Override // defpackage.w32
    public final void F(ConnectionResult connectionResult) {
        n(connectionResult, null);
    }

    @Override // defpackage.n32
    public final void L(Bundle bundle) {
        if (Looper.myLooper() == this.r.n.getLooper()) {
            a();
        } else {
            this.r.n.post(new l52(this));
        }
    }

    public final void a() {
        q();
        l(ConnectionResult.j);
        i();
        Iterator<e62> it = this.k.values().iterator();
        if (!it.hasNext()) {
            d();
            j();
            return;
        }
        Objects.requireNonNull(it.next());
        throw null;
    }

    public final void b(int i2) {
        q();
        this.n = true;
        f42 f42 = this.i;
        String lastDisconnectMessage = this.g.getLastDisconnectMessage();
        Objects.requireNonNull(f42);
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i2 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i2 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        f42.a(true, new Status(20, sb.toString()));
        Handler handler = this.r.n;
        Message obtain = Message.obtain(handler, 9, this.h);
        Objects.requireNonNull(this.r);
        handler.sendMessageDelayed(obtain, 5000);
        Handler handler2 = this.r.n;
        Message obtain2 = Message.obtain(handler2, 11, this.h);
        Objects.requireNonNull(this.r);
        handler2.sendMessageDelayed(obtain2, 120000);
        this.r.g.f2341a.clear();
        for (e62 e62 : this.k.values()) {
            e62.f930a.run();
        }
    }

    public final boolean c(ConnectionResult connectionResult) {
        synchronized (o32.r) {
            o32 o32 = this.r;
            if (o32.k == null || !o32.l.contains(this.h)) {
                return false;
            }
            this.r.k.n(connectionResult, this.l);
            return true;
        }
    }

    public final void d() {
        ArrayList arrayList = new ArrayList(this.f);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            q62 q62 = (q62) arrayList.get(i2);
            if (this.g.isConnected()) {
                if (e(q62)) {
                    this.f.remove(q62);
                }
            } else {
                return;
            }
        }
    }

    public final boolean e(q62 q62) {
        if (!(q62 instanceof c62)) {
            f(q62);
            return true;
        }
        c62 c62 = (c62) q62;
        Feature m2 = m(c62.f(this));
        if (m2 == null) {
            f(q62);
            return true;
        }
        String name = this.g.getClass().getName();
        String str = m2.f;
        name.length();
        String.valueOf(str).length();
        if (!this.r.o || !c62.g(this)) {
            c62.b(new h32(m2));
            return true;
        }
        q52 q52 = new q52(this.h, m2);
        int indexOf = this.o.indexOf(q52);
        if (indexOf >= 0) {
            q52 q522 = this.o.get(indexOf);
            this.r.n.removeMessages(15, q522);
            Handler handler = this.r.n;
            Message obtain = Message.obtain(handler, 15, q522);
            Objects.requireNonNull(this.r);
            handler.sendMessageDelayed(obtain, 5000);
            return false;
        }
        this.o.add(q52);
        Handler handler2 = this.r.n;
        Message obtain2 = Message.obtain(handler2, 15, q52);
        Objects.requireNonNull(this.r);
        handler2.sendMessageDelayed(obtain2, 5000);
        Handler handler3 = this.r.n;
        Message obtain3 = Message.obtain(handler3, 16, q52);
        Objects.requireNonNull(this.r);
        handler3.sendMessageDelayed(obtain3, 120000);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (c(connectionResult)) {
            return false;
        }
        this.r.h(connectionResult, this.l);
        return false;
    }

    public final void f(q62 q62) {
        q62.c(this.i, s());
        try {
            q62.d(this);
        } catch (DeadObjectException unused) {
            C(1);
            this.g.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        } catch (Throwable th) {
            throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.g.getClass().getName()), th);
        }
    }

    public final void g(Status status, Exception exc, boolean z) {
        gj1.f(this.r.n);
        boolean z2 = false;
        boolean z3 = status == null;
        if (exc == null) {
            z2 = true;
        }
        if (z3 != z2) {
            Iterator<q62> it = this.f.iterator();
            while (it.hasNext()) {
                q62 next = it.next();
                if (!z || next.f2904a == 2) {
                    if (status != null) {
                        next.a(status);
                    } else {
                        next.b(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    public final void h(Status status) {
        gj1.f(this.r.n);
        g(status, null, false);
    }

    public final void i() {
        if (this.n) {
            this.r.n.removeMessages(11, this.h);
            this.r.n.removeMessages(9, this.h);
            this.n = false;
        }
    }

    public final void j() {
        this.r.n.removeMessages(12, this.h);
        Handler handler = this.r.n;
        handler.sendMessageDelayed(handler.obtainMessage(12, this.h), this.r.f2644a);
    }

    public final boolean k(boolean z) {
        gj1.f(this.r.n);
        if (!this.g.isConnected() || this.k.size() != 0) {
            return false;
        }
        f42 f42 = this.i;
        if (!f42.f1087a.isEmpty() || !f42.b.isEmpty()) {
            if (z) {
                j();
            }
            return false;
        }
        this.g.disconnect("Timing out service connection.");
        return true;
    }

    public final void l(ConnectionResult connectionResult) {
        Iterator<t62> it = this.j.iterator();
        if (it.hasNext()) {
            t62 next = it.next();
            if (gj1.G(connectionResult, ConnectionResult.j)) {
                this.g.getEndpointPackageName();
            }
            Objects.requireNonNull(next);
            throw null;
        }
        this.j.clear();
    }

    public final Feature m(Feature[] featureArr) {
        if (!(featureArr == null || featureArr.length == 0)) {
            Feature[] availableFeatures = this.g.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            int length = availableFeatures.length;
            n2 n2Var = new n2(length);
            for (Feature feature : availableFeatures) {
                n2Var.put(feature.f, Long.valueOf(feature.l1()));
            }
            for (Feature feature2 : featureArr) {
                Long l2 = (Long) n2Var.get(feature2.f);
                if (l2 == null || l2.longValue() < feature2.l1()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void n(ConnectionResult connectionResult, Exception exc) {
        ni4 ni4;
        gj1.f(this.r.n);
        i62 i62 = this.m;
        if (!(i62 == null || (ni4 = i62.k) == null)) {
            ni4.disconnect();
        }
        q();
        this.r.g.f2341a.clear();
        l(connectionResult);
        if ((this.g instanceof z82) && connectionResult.g != 24) {
            o32 o32 = this.r;
            o32.b = true;
            Handler handler = o32.n;
            handler.sendMessageDelayed(handler.obtainMessage(19), DefaultRefreshIntervals.RESPONSE_TIME_EXPECTATIONS_FETCH_INTERVAL);
        }
        if (connectionResult.g == 4) {
            h(o32.q);
        } else if (this.f.isEmpty()) {
            this.p = connectionResult;
        } else if (exc != null) {
            gj1.f(this.r.n);
            g(null, exc, false);
        } else if (this.r.o) {
            g(o32.c(this.h, connectionResult), null, true);
            if (!this.f.isEmpty() && !c(connectionResult) && !this.r.h(connectionResult, this.l)) {
                if (connectionResult.g == 18) {
                    this.n = true;
                }
                if (this.n) {
                    Handler handler2 = this.r.n;
                    Message obtain = Message.obtain(handler2, 9, this.h);
                    Objects.requireNonNull(this.r);
                    handler2.sendMessageDelayed(obtain, 5000);
                    return;
                }
                Status c = o32.c(this.h, connectionResult);
                gj1.f(this.r.n);
                g(c, null, false);
            }
        } else {
            Status c2 = o32.c(this.h, connectionResult);
            gj1.f(this.r.n);
            g(c2, null, false);
        }
    }

    public final void o(q62 q62) {
        gj1.f(this.r.n);
        if (!this.g.isConnected()) {
            this.f.add(q62);
            ConnectionResult connectionResult = this.p;
            if (connectionResult == null || !connectionResult.l1()) {
                r();
            } else {
                n(this.p, null);
            }
        } else if (e(q62)) {
            j();
        } else {
            this.f.add(q62);
        }
    }

    public final void p() {
        gj1.f(this.r.n);
        Status status = o32.p;
        h(status);
        f42 f42 = this.i;
        Objects.requireNonNull(f42);
        f42.a(false, status);
        for (t32.a aVar : (t32.a[]) this.k.keySet().toArray(new t32.a[0])) {
            o(new p62(aVar, new zi4()));
        }
        l(new ConnectionResult(4));
        if (this.g.isConnected()) {
            this.g.onUserSignOut(new o52(this));
        }
    }

    public final void q() {
        gj1.f(this.r.n);
        this.p = null;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [x22$f, ni4] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r() {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p52.r():void");
    }

    public final boolean s() {
        return this.g.requiresSignIn();
    }
}
