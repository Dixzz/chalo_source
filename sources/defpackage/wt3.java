package defpackage;

import defpackage.bu3;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: wt3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class wt3 extends qt3 {
    public final byte[] i;

    public wt3(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.i = bArr;
    }

    public int A() {
        return 0;
    }

    @Override // defpackage.qt3
    public byte b(int i2) {
        return this.i[i2];
    }

    @Override // defpackage.qt3
    public int d() {
        return this.i.length;
    }

    @Override // defpackage.qt3
    public final int e(int i2, int i3, int i4) {
        byte[] bArr = this.i;
        int A = A();
        Charset charset = tu3.f3407a;
        for (int i5 = A; i5 < A + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // defpackage.qt3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qt3) || d() != ((qt3) obj).d()) {
            return false;
        }
        if (d() == 0) {
            return true;
        }
        if (!(obj instanceof wt3)) {
            return obj.equals(this);
        }
        wt3 wt3 = (wt3) obj;
        int i2 = this.f;
        int i3 = wt3.f;
        if (i2 != 0 && i3 != 0 && i2 != i3) {
            return false;
        }
        int d = d();
        if (d > wt3.d()) {
            int d2 = d();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(d);
            sb.append(d2);
            throw new IllegalArgumentException(sb.toString());
        } else if (d <= wt3.d()) {
            byte[] bArr = this.i;
            byte[] bArr2 = wt3.i;
            int A = A() + d;
            int A2 = A();
            int A3 = wt3.A();
            while (A2 < A) {
                if (bArr[A2] != bArr2[A3]) {
                    return false;
                }
                A2++;
                A3++;
            }
            return true;
        } else {
            throw new IllegalArgumentException(hj1.w(59, "Ran off end of other: 0, ", d, ", ", wt3.d()));
        }
    }

    @Override // defpackage.qt3
    public final qt3 k(int i2, int i3) {
        int y = qt3.y(0, i3, d());
        if (y == 0) {
            return qt3.g;
        }
        return new vt3(this.i, A(), y);
    }

    @Override // defpackage.qt3
    public final String s(Charset charset) {
        return new String(this.i, A(), d(), charset);
    }

    @Override // defpackage.qt3
    public final void u(rt3 rt3) throws IOException {
        ((bu3.b) rt3).Z(this.i, A(), d());
    }

    @Override // defpackage.qt3
    public byte v(int i2) {
        return this.i[i2];
    }

    @Override // defpackage.qt3
    public final boolean z() {
        int A = A();
        return lx3.b(this.i, A, d() + A);
    }
}
