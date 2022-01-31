package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: h52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class h52 implements y52, b72 {
    public final Lock f;
    public final Condition g;
    public final Context h;
    public final r22 i;
    public final g52 j;
    public final Map<x22.c<?>, x22.f> k;
    public final Map<x22.c<?>, ConnectionResult> l = new HashMap();
    public final x72 m;
    public final Map<x22<?>, Boolean> n;
    public final x22.a<? extends ni4, zh4> o;
    @NotOnlyInitialized
    public volatile e52 p;
    public ConnectionResult q = null;
    public int r;
    public final d52 s;
    public final x52 t;

    public h52(Context context, d52 d52, Lock lock, Looper looper, r22 r22, Map<x22.c<?>, x22.f> map, x72 x72, Map<x22<?>, Boolean> map2, x22.a<? extends ni4, zh4> aVar, ArrayList<a72> arrayList, x52 x52) {
        this.h = context;
        this.f = lock;
        this.i = r22;
        this.k = map;
        this.m = x72;
        this.n = map2;
        this.o = aVar;
        this.s = d52;
        this.t = x52;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).h = this;
        }
        this.j = new g52(this, looper);
        this.g = lock.newCondition();
        this.p = new w42(this);
    }

    @Override // defpackage.n32
    public final void C(int i2) {
        this.f.lock();
        try {
            this.p.g(i2);
        } finally {
            this.f.unlock();
        }
    }

    @Override // defpackage.b72
    public final void C1(ConnectionResult connectionResult, x22<?> x22, boolean z) {
        this.f.lock();
        try {
            this.p.h(connectionResult, x22, z);
        } finally {
            this.f.unlock();
        }
    }

    @Override // defpackage.n32
    public final void L(Bundle bundle) {
        this.f.lock();
        try {
            this.p.f(bundle);
        } finally {
            this.f.unlock();
        }
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final void a() {
        this.p.a();
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final <A extends x22.b, T extends l32<? extends f32, A>> T b(T t2) {
        t2.j();
        return (T) this.p.b(t2);
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final void c() {
        if (this.p.c()) {
            this.l.clear();
        }
    }

    @Override // defpackage.y52
    public final void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.p);
        for (x22<?> x22 : this.n.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) x22.c).println(ProductDiscountsObject.KEY_DELIMITER);
            x22.f fVar = this.k.get(x22.b);
            Objects.requireNonNull(fVar, "null reference");
            fVar.dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t2) {
        t2.j();
        this.p.e(t2);
        return t2;
    }

    @Override // defpackage.y52
    @GuardedBy("mLock")
    public final ConnectionResult f() {
        this.p.a();
        while (this.p instanceof v42) {
            try {
                this.g.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (this.p instanceof k42) {
            return ConnectionResult.j;
        }
        ConnectionResult connectionResult = this.q;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, null);
    }

    @Override // defpackage.y52
    public final boolean g(a42 a42) {
        return false;
    }

    @Override // defpackage.y52
    public final void h() {
    }

    @Override // defpackage.y52
    public final boolean i() {
        return this.p instanceof k42;
    }

    public final void j(ConnectionResult connectionResult) {
        this.f.lock();
        try {
            this.q = connectionResult;
            this.p = new w42(this);
            this.p.d();
            this.g.signalAll();
        } finally {
            this.f.unlock();
        }
    }
}
