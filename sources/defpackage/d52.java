package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import defpackage.a32;
import defpackage.x22;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: d52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class d52 extends a32 implements x52 {
    public final Lock b;
    public final l92 c;
    public y52 d = null;
    public final int e;
    public final Context f;
    public final Looper g;
    public final Queue<l32<?, ?>> h = new LinkedList();
    public volatile boolean i;
    public long j = 120000;
    public long k = 5000;
    public final b52 l;
    public final q22 m;
    public v52 n;
    public final Map<x22.c<?>, x22.f> o;
    public Set<Scope> p = new HashSet();
    public final x72 q;
    public final Map<x22<?>, Boolean> r;
    public final x22.a<? extends ni4, zh4> s;
    public final u32 t = new u32();
    public final ArrayList<a72> u;
    public Integer v = null;
    public final l62 w;
    public final k92 x;

    public d52(Context context, Lock lock, Looper looper, x72 x72, q22 q22, x22.a<? extends ni4, zh4> aVar, Map<x22<?>, Boolean> map, List<a32.b> list, List<a32.c> list2, Map<x22.c<?>, x22.f> map2, int i2, int i3, ArrayList<a72> arrayList) {
        x42 x42 = new x42(this);
        this.x = x42;
        this.f = context;
        this.b = lock;
        this.c = new l92(looper, x42);
        this.g = looper;
        this.l = new b52(this, looper);
        this.m = q22;
        this.e = i2;
        if (i2 >= 0) {
            this.v = Integer.valueOf(i3);
        }
        this.r = map;
        this.o = map2;
        this.u = arrayList;
        this.w = new l62();
        for (a32.b bVar : list) {
            this.c.b(bVar);
        }
        for (a32.c cVar : list2) {
            this.c.c(cVar);
        }
        this.q = x72;
        this.s = aVar;
    }

    public static int v(Iterable<x22.f> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (x22.f fVar : iterable) {
            z2 |= fVar.requiresSignIn();
            z3 |= fVar.providesSignIn();
        }
        if (z2) {
            return (!z3 || !z) ? 1 : 2;
        }
        return 3;
    }

    public static String w(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    public static /* synthetic */ void x(d52 d52) {
        d52.b.lock();
        try {
            if (d52.i) {
                d52.z();
            }
        } finally {
            d52.b.unlock();
        }
    }

    @Override // defpackage.x52
    @GuardedBy("mLock")
    public final void a(Bundle bundle) {
        while (!this.h.isEmpty()) {
            j(this.h.remove());
        }
        l92 l92 = this.c;
        gj1.g(l92.h, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (l92.i) {
            boolean z = true;
            gj1.n(!l92.g);
            l92.h.removeMessages(1);
            l92.g = true;
            if (l92.c.size() != 0) {
                z = false;
            }
            gj1.n(z);
            ArrayList arrayList = new ArrayList(l92.b);
            int i2 = l92.f.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a32.b bVar = (a32.b) it.next();
                if (!l92.e || !l92.f2190a.isConnected()) {
                    break;
                } else if (l92.f.get() != i2) {
                    break;
                } else if (!l92.c.contains(bVar)) {
                    bVar.L(bundle);
                }
            }
            l92.c.clear();
            l92.g = false;
        }
    }

    @Override // defpackage.x52
    @GuardedBy("mLock")
    public final void b(ConnectionResult connectionResult) {
        q22 q22 = this.m;
        Context context = this.f;
        int i2 = connectionResult.g;
        Objects.requireNonNull(q22);
        if (!u22.isPlayServicesPossiblyUpdating(context, i2)) {
            u();
        }
        if (!this.i) {
            l92 l92 = this.c;
            gj1.g(l92.h, "onConnectionFailure must only be called on the Handler thread");
            l92.h.removeMessages(1);
            synchronized (l92.i) {
                ArrayList arrayList = new ArrayList(l92.d);
                int i3 = l92.f.get();
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a32.c cVar = (a32.c) it.next();
                    if (!l92.e) {
                        break;
                    } else if (l92.f.get() != i3) {
                        break;
                    } else if (l92.d.contains(cVar)) {
                        cVar.F(connectionResult);
                    }
                }
            }
            this.c.a();
        }
    }

    @Override // defpackage.x52
    @GuardedBy("mLock")
    public final void c(int i2, boolean z) {
        if (i2 == 1) {
            if (!z && !this.i) {
                this.i = true;
                if (this.n == null) {
                    try {
                        this.n = this.m.i(this.f.getApplicationContext(), new c52(this));
                    } catch (SecurityException unused) {
                    }
                }
                b52 b52 = this.l;
                b52.sendMessageDelayed(b52.obtainMessage(1), this.j);
                b52 b522 = this.l;
                b522.sendMessageDelayed(b522.obtainMessage(2), this.k);
            }
            i2 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.w.f2180a.toArray(new BasePendingResult[0])) {
            basePendingResult.e(l62.c);
        }
        l92 l92 = this.c;
        gj1.g(l92.h, "onUnintentionalDisconnection must only be called on the Handler thread");
        l92.h.removeMessages(1);
        synchronized (l92.i) {
            l92.g = true;
            ArrayList arrayList = new ArrayList(l92.b);
            int i3 = l92.f.get();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a32.b bVar = (a32.b) it.next();
                if (!l92.e) {
                    break;
                } else if (l92.f.get() != i3) {
                    break;
                } else if (l92.b.contains(bVar)) {
                    bVar.C(i2);
                }
            }
            l92.c.clear();
            l92.g = false;
        }
        this.c.a();
        if (i2 == 2) {
            z();
        }
    }

    @Override // defpackage.a32
    public final ConnectionResult d() {
        boolean z = false;
        gj1.o(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.b.lock();
        try {
            if (this.e >= 0) {
                if (this.v != null) {
                    z = true;
                }
                gj1.o(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.v;
                if (num == null) {
                    this.v = Integer.valueOf(v(this.o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            Integer num2 = this.v;
            Objects.requireNonNull(num2, "null reference");
            y(num2.intValue());
            this.c.e = true;
            y52 y52 = this.d;
            Objects.requireNonNull(y52, "null reference");
            return y52.f();
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.a32
    public final b32<Status> e() {
        gj1.o(n(), "GoogleApiClient is not connected yet.");
        Integer num = this.v;
        gj1.o(num == null || num.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        c42 c42 = new c42(this);
        if (this.o.containsKey(m82.f2338a)) {
            Objects.requireNonNull(m82.d);
            j(new p82(this)).b(new a52(this, c42, false, this));
        } else {
            AtomicReference atomicReference = new AtomicReference();
            y42 y42 = new y42(this, atomicReference, c42);
            z42 z42 = new z42(c42);
            a32.a aVar = new a32.a(this.f);
            aVar.a(m82.b);
            aVar.b(y42);
            aVar.c(z42);
            b52 b52 = this.l;
            gj1.l(b52, "Handler must not be null");
            aVar.k = b52.getLooper();
            a32 d2 = aVar.d();
            atomicReference.set(d2);
            d2.f();
        }
        return c42;
    }

    @Override // defpackage.a32
    public final void f() {
        this.b.lock();
        try {
            int i2 = 2;
            boolean z = false;
            if (this.e >= 0) {
                gj1.o(this.v != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.v;
                if (num == null) {
                    this.v = Integer.valueOf(v(this.o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            Integer num2 = this.v;
            Objects.requireNonNull(num2, "null reference");
            int intValue = num2.intValue();
            this.b.lock();
            if (intValue == 3 || intValue == 1) {
                i2 = intValue;
            } else if (intValue != 2) {
                i2 = intValue;
                StringBuilder sb = new StringBuilder(33);
                sb.append("Illegal sign-in mode: ");
                sb.append(i2);
                gj1.c(z, sb.toString());
                y(i2);
                z();
                this.b.unlock();
            }
            z = true;
            try {
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Illegal sign-in mode: ");
                sb2.append(i2);
                gj1.c(z, sb2.toString());
                y(i2);
                z();
                this.b.unlock();
            } finally {
                this.b.unlock();
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // defpackage.a32
    public final void g() {
        Lock lock;
        this.b.lock();
        try {
            this.w.a();
            y52 y52 = this.d;
            if (y52 != null) {
                y52.c();
            }
            u32 u32 = this.t;
            for (t32<?> t32 : u32.f3445a) {
                t32.b = null;
                t32.c = null;
            }
            u32.f3445a.clear();
            for (l32<?, ?> l32 : this.h) {
                l32.g.set(null);
                l32.a();
            }
            this.h.clear();
            if (this.d == null) {
                lock = this.b;
            } else {
                u();
                this.c.a();
                lock = this.b;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // defpackage.a32
    public final void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.i);
        printWriter.append(" mWorkQueue.size()=").print(this.h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.w.f2180a.size());
        y52 y52 = this.d;
        if (y52 != null) {
            y52.d(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // defpackage.a32
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T i(T t2) {
        Lock lock;
        x22<?> x22 = t2.p;
        boolean containsKey = this.o.containsKey(t2.o);
        String str = x22 != null ? x22.c : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        gj1.c(containsKey, sb.toString());
        this.b.lock();
        try {
            y52 y52 = this.d;
            if (y52 == null) {
                this.h.add(t2);
                lock = this.b;
            } else {
                t2 = (T) y52.e(t2);
                lock = this.b;
            }
            lock.unlock();
            return t2;
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // defpackage.a32
    public final <A extends x22.b, T extends l32<? extends f32, A>> T j(T t2) {
        Lock lock;
        x22<?> x22 = t2.p;
        boolean containsKey = this.o.containsKey(t2.o);
        String str = x22 != null ? x22.c : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(str);
        sb.append(" required for this call.");
        gj1.c(containsKey, sb.toString());
        this.b.lock();
        try {
            y52 y52 = this.d;
            if (y52 != null) {
                if (this.i) {
                    this.h.add(t2);
                    while (!this.h.isEmpty()) {
                        l32<?, ?> remove = this.h.remove();
                        l62 l62 = this.w;
                        l62.f2180a.add(remove);
                        remove.g.set(l62.b);
                        remove.n(Status.m);
                    }
                    lock = this.b;
                } else {
                    t2 = (T) y52.b(t2);
                    lock = this.b;
                }
                lock.unlock();
                return t2;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // defpackage.a32
    public final <C extends x22.f> C k(x22.c<C> cVar) {
        C c2 = (C) this.o.get(cVar);
        gj1.l(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @Override // defpackage.a32
    public final Context l() {
        return this.f;
    }

    @Override // defpackage.a32
    public final Looper m() {
        return this.g;
    }

    @Override // defpackage.a32
    public final boolean n() {
        y52 y52 = this.d;
        return y52 != null && y52.i();
    }

    @Override // defpackage.a32
    public final boolean o(a42 a42) {
        y52 y52 = this.d;
        return y52 != null && y52.g(a42);
    }

    @Override // defpackage.a32
    public final void p() {
        y52 y52 = this.d;
        if (y52 != null) {
            y52.h();
        }
    }

    @Override // defpackage.a32
    public final void q(a32.b bVar) {
        this.c.b(bVar);
    }

    @Override // defpackage.a32
    public final void r(a32.c cVar) {
        this.c.c(cVar);
    }

    @Override // defpackage.a32
    public final void s(a32.b bVar) {
        l92 l92 = this.c;
        Objects.requireNonNull(l92);
        Objects.requireNonNull(bVar, "null reference");
        synchronized (l92.i) {
            if (!l92.b.remove(bVar)) {
                String.valueOf(bVar).length();
            } else if (l92.g) {
                l92.c.add(bVar);
            }
        }
    }

    @Override // defpackage.a32
    public final void t(a32.c cVar) {
        l92 l92 = this.c;
        Objects.requireNonNull(l92);
        Objects.requireNonNull(cVar, "null reference");
        synchronized (l92.i) {
            if (!l92.d.remove(cVar)) {
                String.valueOf(cVar).length();
            }
        }
    }

    @GuardedBy("mLock")
    public final boolean u() {
        if (!this.i) {
            return false;
        }
        this.i = false;
        this.l.removeMessages(2);
        this.l.removeMessages(1);
        v52 v52 = this.n;
        if (v52 != null) {
            v52.a();
            this.n = null;
        }
        return true;
    }

    public final void y(int i2) {
        d52 d52;
        Integer num = this.v;
        if (num == null) {
            this.v = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String w2 = w(i2);
            String w3 = w(this.v.intValue());
            throw new IllegalStateException(hj1.c0(new StringBuilder(w2.length() + 51 + w3.length()), "Cannot use sign-in mode: ", w2, ". Mode was already set to ", w3));
        }
        if (this.d == null) {
            boolean z = false;
            boolean z2 = false;
            for (x22.f fVar : this.o.values()) {
                z |= fVar.requiresSignIn();
                z2 |= fVar.providesSignIn();
            }
            int intValue = this.v.intValue();
            if (intValue == 1) {
                d52 = this;
                if (!z) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                } else if (z2) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            } else if (intValue == 2 && z) {
                Context context = this.f;
                Lock lock = this.b;
                Looper looper = this.g;
                q22 q22 = this.m;
                Map<x22.c<?>, x22.f> map = this.o;
                x72 x72 = this.q;
                Map<x22<?>, Boolean> map2 = this.r;
                x22.a<? extends ni4, zh4> aVar = this.s;
                ArrayList<a72> arrayList = this.u;
                n2 n2Var = new n2();
                n2 n2Var2 = new n2();
                x22.f fVar2 = null;
                for (Iterator<Map.Entry<x22.c<?>, x22.f>> it = map.entrySet().iterator(); it.hasNext(); it = it) {
                    Map.Entry<x22.c<?>, x22.f> next = it.next();
                    x22.f value = next.getValue();
                    if (true == value.providesSignIn()) {
                        fVar2 = value;
                    }
                    if (value.requiresSignIn()) {
                        n2Var.put(next.getKey(), value);
                    } else {
                        n2Var2.put(next.getKey(), value);
                    }
                }
                gj1.o(!n2Var.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
                n2 n2Var3 = new n2();
                n2 n2Var4 = new n2();
                for (Iterator<x22<?>> it2 = map2.keySet().iterator(); it2.hasNext(); it2 = it2) {
                    x22<?> next2 = it2.next();
                    x22.g<?> gVar = next2.b;
                    if (n2Var.containsKey(gVar)) {
                        n2Var3.put(next2, map2.get(next2));
                    } else if (n2Var2.containsKey(gVar)) {
                        n2Var4.put(next2, map2.get(next2));
                    } else {
                        throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    a72 a72 = arrayList.get(i3);
                    if (n2Var3.containsKey(a72.f)) {
                        arrayList2.add(a72);
                    } else if (n2Var4.containsKey(a72.f)) {
                        arrayList3.add(a72);
                    } else {
                        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                    }
                    i3++;
                    size = size;
                    arrayList = arrayList;
                }
                this.d = new f72(context, this, lock, looper, q22, n2Var, n2Var2, x72, aVar, fVar2, arrayList2, arrayList3, n2Var3, n2Var4);
                return;
            } else {
                d52 = this;
            }
            d52.d = new h52(d52.f, this, d52.b, d52.g, d52.m, d52.o, d52.q, d52.r, d52.s, d52.u, this);
        }
    }

    @GuardedBy("mLock")
    public final void z() {
        this.c.e = true;
        y52 y52 = this.d;
        Objects.requireNonNull(y52, "null reference");
        y52.a();
    }
}
