package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import defpackage.b32;
import defpackage.f32;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class BasePendingResult<R extends f32> extends b32<R> {
    public static final ThreadLocal<Boolean> n = new y62();

    /* renamed from: a  reason: collision with root package name */
    public final Object f603a;
    @RecentlyNonNull
    public final a<R> b;
    @RecentlyNonNull
    public final WeakReference<a32> c;
    public final CountDownLatch d;
    public final ArrayList<b32.a> e;
    public g32<? super R> f;
    public final AtomicReference<k62> g;
    public R h;
    public Status i;
    public volatile boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    @KeepName
    public z62 mResultGuardian;

    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static class a<R extends f32> extends ve2 {
        public a(@RecentlyNonNull Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: g32 */
        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMessage(@RecentlyNonNull Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                g32 g32 = (g32) pair.first;
                f32 f32 = (f32) pair.second;
                try {
                    g32.a(f32);
                } catch (RuntimeException e) {
                    BasePendingResult.k(f32);
                    throw e;
                }
            } else if (i != 2) {
                Log.wtf("BasePendingResult", hj1.v(45, "Don't know how to handle message: ", i), new Exception());
            } else {
                ((BasePendingResult) message.obj).e(Status.n);
            }
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f603a = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList<>();
        this.g = new AtomicReference<>();
        this.m = false;
        this.b = new a<>(Looper.getMainLooper());
        this.c = new WeakReference<>(null);
    }

    public static void k(f32 f32) {
        if (f32 instanceof c32) {
            try {
                ((c32) f32).a();
            } catch (RuntimeException unused) {
                String.valueOf(f32).length();
            }
        }
    }

    @Override // defpackage.b32
    public void a() {
        synchronized (this.f603a) {
            if (!this.k) {
                if (!this.j) {
                    k(this.h);
                    this.k = true;
                    i(d(Status.o));
                }
            }
        }
    }

    @Override // defpackage.b32
    public final void b(g32<? super R> g32) {
        boolean z;
        synchronized (this.f603a) {
            gj1.o(!this.j, "Result has already been consumed.");
            gj1.o(true, "Cannot set callbacks if then() has been called.");
            synchronized (this.f603a) {
                z = this.k;
            }
            if (!z) {
                if (f()) {
                    a<R> aVar = this.b;
                    R h2 = h();
                    Objects.requireNonNull(aVar);
                    aVar.sendMessage(aVar.obtainMessage(1, new Pair(g32, h2)));
                } else {
                    this.f = g32;
                }
            }
        }
    }

    public final void c(@RecentlyNonNull b32.a aVar) {
        gj1.c(true, "Callback cannot be null.");
        synchronized (this.f603a) {
            if (f()) {
                aVar.a(this.i);
            } else {
                this.e.add(aVar);
            }
        }
    }

    public abstract R d(@RecentlyNonNull Status status);

    @Deprecated
    public final void e(@RecentlyNonNull Status status) {
        synchronized (this.f603a) {
            if (!f()) {
                setResult(d(status));
                this.l = true;
            }
        }
    }

    public final boolean f() {
        return this.d.getCount() == 0;
    }

    /* renamed from: g */
    public final void setResult(@RecentlyNonNull R r) {
        synchronized (this.f603a) {
            if (this.l || this.k) {
                k(r);
                return;
            }
            f();
            gj1.o(!f(), "Results have already been set");
            gj1.o(!this.j, "Result has already been consumed");
            i(r);
        }
    }

    public final R h() {
        R r;
        synchronized (this.f603a) {
            gj1.o(!this.j, "Result has already been consumed.");
            gj1.o(f(), "Result is not ready.");
            r = this.h;
            this.h = null;
            this.f = null;
            this.j = true;
        }
        k62 andSet = this.g.getAndSet(null);
        if (andSet != null) {
            andSet.f2029a.f2180a.remove(this);
        }
        Objects.requireNonNull(r, "null reference");
        return r;
    }

    public final void i(R r) {
        this.h = r;
        this.i = r.M0();
        this.d.countDown();
        if (this.k) {
            this.f = null;
        } else {
            g32<? super R> g32 = this.f;
            if (g32 != null) {
                this.b.removeMessages(2);
                a<R> aVar = this.b;
                R h2 = h();
                Objects.requireNonNull(aVar);
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(g32, h2)));
            } else if (this.h instanceof c32) {
                this.mResultGuardian = new z62(this);
            }
        }
        ArrayList<b32.a> arrayList = this.e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).a(this.i);
        }
        this.e.clear();
    }

    public final void j() {
        boolean z = true;
        if (!this.m && !n.get().booleanValue()) {
            z = false;
        }
        this.m = z;
    }

    public BasePendingResult(a32 a32) {
        this.f603a = new Object();
        this.d = new CountDownLatch(1);
        this.e = new ArrayList<>();
        this.g = new AtomicReference<>();
        this.m = false;
        this.b = new a<>(a32 != null ? a32.m() : Looper.getMainLooper());
        this.c = new WeakReference<>(a32);
    }
}
