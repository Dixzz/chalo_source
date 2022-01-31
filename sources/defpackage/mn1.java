package defpackage;

import android.os.Looper;
import java.util.Objects;

/* renamed from: mn1  reason: default package */
/* compiled from: EngineResource */
public class mn1<Z> implements rn1<Z> {
    public final boolean f;
    public a g;
    public dm1 h;
    public int i;
    public boolean j;
    public final rn1<Z> k;

    /* renamed from: mn1$a */
    /* compiled from: EngineResource */
    public interface a {
    }

    public mn1(rn1<Z> rn1, boolean z) {
        Objects.requireNonNull(rn1, "Argument must not be null");
        this.k = rn1;
        this.f = z;
    }

    @Override // defpackage.rn1
    public void a() {
        if (this.i > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.j) {
            this.j = true;
            this.k.a();
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    @Override // defpackage.rn1
    public int b() {
        return this.k.b();
    }

    @Override // defpackage.rn1
    public Class<Z> c() {
        return this.k.c();
    }

    public void d() {
        if (this.j) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.i++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    public void e() {
        if (this.i <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i2 = this.i - 1;
            this.i = i2;
            if (i2 == 0) {
                a aVar = this.g;
                dm1 dm1 = this.h;
                hn1 hn1 = (hn1) aVar;
                Objects.requireNonNull(hn1);
                rt1.a();
                hn1.e.remove(dm1);
                if (this.f) {
                    rn1 rn1 = (rn1) ((qo1) hn1.c).d(dm1, this);
                } else {
                    hn1.f.a(this);
                }
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    @Override // defpackage.rn1
    public Z get() {
        return this.k.get();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("EngineResource{isCacheable=");
        i0.append(this.f);
        i0.append(", listener=");
        i0.append(this.g);
        i0.append(", key=");
        i0.append(this.h);
        i0.append(", acquired=");
        i0.append(this.i);
        i0.append(", isRecycled=");
        i0.append(this.j);
        i0.append(", resource=");
        i0.append(this.k);
        i0.append('}');
        return i0.toString();
    }
}
