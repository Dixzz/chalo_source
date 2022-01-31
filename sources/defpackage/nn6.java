package defpackage;

import java.security.MessageDigest;

/* renamed from: nn6  reason: default package */
/* compiled from: SegmentedByteString.kt */
public final class nn6 extends zm6 {
    public final transient byte[][] k;
    public final transient int[] l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nn6(byte[][] bArr, int[] iArr) {
        super(zm6.i.h);
        n86.f(bArr, "segments");
        n86.f(iArr, "directory");
        this.k = bArr;
        this.l = iArr;
    }

    @Override // defpackage.zm6
    public String a() {
        return r().a();
    }

    @Override // defpackage.zm6
    public zm6 c(String str) {
        n86.f(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = this.k.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.l;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            instance.update(this.k[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = instance.digest();
        n86.b(digest, "digest.digest()");
        return new zm6(digest);
    }

    @Override // defpackage.zm6
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zm6) {
            zm6 zm6 = (zm6) obj;
            if (zm6.g() != g() || !k(0, zm6, 0, g())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.zm6
    public int g() {
        return this.l[this.k.length - 1];
    }

    @Override // defpackage.zm6
    public String h() {
        return r().h();
    }

    @Override // defpackage.zm6
    public int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        int length = this.k.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.l;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr = this.k[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f = i3;
        return i3;
    }

    @Override // defpackage.zm6
    public byte[] i() {
        return o();
    }

    @Override // defpackage.zm6
    public byte j(int i) {
        int i2;
        ec6.l((long) this.l[this.k.length - 1], (long) i, 1);
        int v = ec6.v(this, i);
        if (v == 0) {
            i2 = 0;
        } else {
            i2 = this.l[v - 1];
        }
        int[] iArr = this.l;
        byte[][] bArr = this.k;
        return bArr[v][(i - i2) + iArr[bArr.length + v]];
    }

    @Override // defpackage.zm6
    public boolean k(int i, zm6 zm6, int i2, int i3) {
        int i4;
        n86.f(zm6, "other");
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int i5 = i3 + i;
        int v = ec6.v(this, i);
        while (i < i5) {
            if (v == 0) {
                i4 = 0;
            } else {
                i4 = this.l[v - 1];
            }
            int[] iArr = this.l;
            int i6 = iArr[this.k.length + v];
            int min = Math.min(i5, (iArr[v] - i4) + i4) - i;
            if (!zm6.l(i2, this.k[v], (i - i4) + i6, min)) {
                return false;
            }
            i2 += min;
            i += min;
            v++;
        }
        return true;
    }

    @Override // defpackage.zm6
    public boolean l(int i, byte[] bArr, int i2, int i3) {
        int i4;
        n86.f(bArr, "other");
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int v = ec6.v(this, i);
        while (i < i5) {
            if (v == 0) {
                i4 = 0;
            } else {
                i4 = this.l[v - 1];
            }
            int[] iArr = this.l;
            int i6 = iArr[this.k.length + v];
            int min = Math.min(i5, (iArr[v] - i4) + i4) - i;
            if (!ec6.e(this.k[v], (i - i4) + i6, bArr, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            v++;
        }
        return true;
    }

    @Override // defpackage.zm6
    public zm6 m() {
        return r().m();
    }

    @Override // defpackage.zm6
    public byte[] o() {
        byte[] bArr = new byte[g()];
        int length = this.k.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.l;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            y56.b(this.k[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // defpackage.zm6
    public void q(vm6 vm6, int i, int i2) {
        int i3;
        n86.f(vm6, "buffer");
        int i4 = i2 + i;
        int v = ec6.v(this, i);
        while (i < i4) {
            if (v == 0) {
                i3 = 0;
            } else {
                i3 = this.l[v - 1];
            }
            int[] iArr = this.l;
            int i5 = iArr[this.k.length + v];
            int min = Math.min(i4, (iArr[v] - i3) + i3) - i;
            int i6 = (i - i3) + i5;
            ln6 ln6 = new ln6(this.k[v], i6, i6 + min, true, false);
            ln6 ln62 = vm6.f;
            if (ln62 == null) {
                ln6.g = ln6;
                ln6.f = ln6;
                vm6.f = ln6;
            } else {
                ln6 ln63 = ln62.g;
                if (ln63 != null) {
                    ln63.b(ln6);
                } else {
                    n86.k();
                    throw null;
                }
            }
            i += min;
            v++;
        }
        vm6.g += (long) g();
    }

    public final zm6 r() {
        return new zm6(o());
    }

    @Override // defpackage.zm6
    public String toString() {
        return r().toString();
    }
}
