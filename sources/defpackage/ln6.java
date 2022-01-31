package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ln6  reason: default package */
/* compiled from: Segment.kt */
public final class ln6 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2245a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public ln6 f;
    public ln6 g;

    public ln6() {
        this.f2245a = new byte[RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST];
        this.e = true;
        this.d = false;
    }

    public final ln6 a() {
        ln6 ln6 = this.f;
        ln6 ln62 = ln6 != this ? ln6 : null;
        ln6 ln63 = this.g;
        if (ln63 != null) {
            ln63.f = ln6;
            ln6 ln64 = this.f;
            if (ln64 != null) {
                ln64.g = ln63;
                this.f = null;
                this.g = null;
                return ln62;
            }
            n86.k();
            throw null;
        }
        n86.k();
        throw null;
    }

    public final ln6 b(ln6 ln6) {
        n86.f(ln6, "segment");
        ln6.g = this;
        ln6.f = this.f;
        ln6 ln62 = this.f;
        if (ln62 != null) {
            ln62.g = ln6;
            this.f = ln6;
            return ln6;
        }
        n86.k();
        throw null;
    }

    public final ln6 c() {
        this.d = true;
        return new ln6(this.f2245a, this.b, this.c, true, false);
    }

    public final void d(ln6 ln6, int i) {
        n86.f(ln6, "sink");
        if (ln6.e) {
            int i2 = ln6.c;
            if (i2 + i > 8192) {
                if (!ln6.d) {
                    int i3 = ln6.b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = ln6.f2245a;
                        y56.c(bArr, bArr, 0, i3, i2, 2);
                        ln6.c -= ln6.b;
                        ln6.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f2245a;
            byte[] bArr3 = ln6.f2245a;
            int i4 = ln6.c;
            int i5 = this.b;
            y56.b(bArr2, bArr3, i4, i5, i5 + i);
            ln6.c += i;
            this.b += i;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public ln6(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        n86.f(bArr, "data");
        this.f2245a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
