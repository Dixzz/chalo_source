package defpackage;

import sun.misc.Unsafe;

/* renamed from: jn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jn2 extends kn2 {
    public jn2(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // defpackage.kn2
    public final byte a(Object obj, long j) {
        return this.f2085a.getByte(obj, j);
    }

    @Override // defpackage.kn2
    public final void b(Object obj, long j, byte b) {
        this.f2085a.putByte(obj, j, b);
    }

    @Override // defpackage.kn2
    public final boolean c(Object obj, long j) {
        return this.f2085a.getBoolean(obj, j);
    }

    @Override // defpackage.kn2
    public final void d(Object obj, long j, boolean z) {
        this.f2085a.putBoolean(obj, j, z);
    }

    @Override // defpackage.kn2
    public final float e(Object obj, long j) {
        return this.f2085a.getFloat(obj, j);
    }

    @Override // defpackage.kn2
    public final void f(Object obj, long j, float f) {
        this.f2085a.putFloat(obj, j, f);
    }

    @Override // defpackage.kn2
    public final double g(Object obj, long j) {
        return this.f2085a.getDouble(obj, j);
    }

    @Override // defpackage.kn2
    public final void h(Object obj, long j, double d) {
        this.f2085a.putDouble(obj, j, d);
    }
}
