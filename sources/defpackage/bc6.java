package defpackage;

/* renamed from: bc6  reason: default package */
/* compiled from: EventLoop.common.kt */
public abstract class bc6 extends kb6 {
    public long g;
    public boolean h;
    public lf6<vb6<?>> i;

    public final void A(boolean z) {
        long D = this.g - D(z);
        this.g = D;
        if (D <= 0 && this.h) {
            shutdown();
        }
    }

    public final long D(boolean z) {
        return z ? 4294967296L : 1;
    }

    public final void E(vb6<?> vb6) {
        lf6<vb6<?>> lf6 = this.i;
        if (lf6 == null) {
            lf6 = new lf6<>();
            this.i = lf6;
        }
        Object[] objArr = lf6.f2211a;
        int i2 = lf6.c;
        objArr[i2] = vb6;
        int length = (objArr.length - 1) & (i2 + 1);
        lf6.c = length;
        int i3 = lf6.b;
        if (length == i3) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[(length2 << 1)];
            y56.d(objArr, objArr2, 0, i3, 0, 10);
            Object[] objArr3 = lf6.f2211a;
            int length3 = objArr3.length;
            int i4 = lf6.b;
            y56.d(objArr3, objArr2, length3 - i4, 0, i4, 4);
            lf6.f2211a = objArr2;
            lf6.b = 0;
            lf6.c = length2;
        }
    }

    public final void J(boolean z) {
        this.g = D(z) + this.g;
        if (!z) {
            this.h = true;
        }
    }

    public final boolean K() {
        return this.g >= D(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean L() {
        /*
            r7 = this;
            lf6<vb6<?>> r0 = r7.i
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r2 = r0.b
            int r3 = r0.c
            r4 = 0
            r5 = 1
            if (r2 != r3) goto L_0x000f
            goto L_0x0022
        L_0x000f:
            java.lang.Object[] r3 = r0.f2211a
            r6 = r3[r2]
            r3[r2] = r4
            int r2 = r2 + r5
            int r3 = r3.length
            int r3 = r3 + -1
            r2 = r2 & r3
            r0.b = r2
            java.lang.String r0 = "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue"
            java.util.Objects.requireNonNull(r6, r0)
            r4 = r6
        L_0x0022:
            vb6 r4 = (defpackage.vb6) r4
            if (r4 != 0) goto L_0x0027
            return r1
        L_0x0027:
            r4.run()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bc6.L():boolean");
    }

    public void shutdown() {
    }
}
