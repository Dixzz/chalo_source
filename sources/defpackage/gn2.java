package defpackage;

import sun.misc.Unsafe;

/* renamed from: gn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class gn2 extends kn2 {
    public gn2(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // defpackage.kn2
    public final byte a(Object obj, long j) {
        if (ln2.i) {
            return ln2.e(obj, j);
        }
        return ln2.f(obj, j);
    }

    @Override // defpackage.kn2
    public final void b(Object obj, long j, byte b) {
        if (ln2.i) {
            ln2.g(obj, j, b);
        } else {
            ln2.h(obj, j, b);
        }
    }

    @Override // defpackage.kn2
    public final boolean c(Object obj, long j) {
        if (ln2.i) {
            if (ln2.e(obj, j) != 0) {
                return true;
            }
            return false;
        } else if (ln2.f(obj, j) != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.kn2
    public final void d(Object obj, long j, boolean z) {
        if (ln2.i) {
            ln2.g(obj, j, z);
        } else {
            ln2.h(obj, j, z ? (byte) 1 : 0);
        }
    }

    @Override // defpackage.kn2
    public final float e(Object obj, long j) {
        return Float.intBitsToFloat(j(obj, j));
    }

    @Override // defpackage.kn2
    public final void f(Object obj, long j, float f) {
        k(obj, j, Float.floatToIntBits(f));
    }

    @Override // defpackage.kn2
    public final double g(Object obj, long j) {
        return Double.longBitsToDouble(l(obj, j));
    }

    @Override // defpackage.kn2
    public final void h(Object obj, long j, double d) {
        m(obj, j, Double.doubleToLongBits(d));
    }
}
