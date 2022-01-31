package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: e93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public class e93 extends g93 {
    public final byte[] i;

    public e93(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.i = bArr;
    }

    public int F() {
        return 0;
    }

    @Override // defpackage.g93
    public byte b(int i2) {
        return this.i[i2];
    }

    @Override // defpackage.g93
    public byte d(int i2) {
        return this.i[i2];
    }

    @Override // defpackage.g93
    public int e() {
        return this.i.length;
    }

    @Override // defpackage.g93
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g93) || e() != ((g93) obj).e()) {
            return false;
        }
        if (e() == 0) {
            return true;
        }
        if (!(obj instanceof e93)) {
            return obj.equals(this);
        }
        e93 e93 = (e93) obj;
        int i2 = this.f;
        int i3 = e93.f;
        if (i2 != 0 && i3 != 0 && i2 != i3) {
            return false;
        }
        int e = e();
        if (e > e93.e()) {
            int e2 = e();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(e);
            sb.append(e2);
            throw new IllegalArgumentException(sb.toString());
        } else if (e <= e93.e()) {
            byte[] bArr = this.i;
            byte[] bArr2 = e93.i;
            e93.F();
            int i4 = 0;
            int i5 = 0;
            while (i4 < e) {
                if (bArr[i4] != bArr2[i5]) {
                    return false;
                }
                i4++;
                i5++;
            }
            return true;
        } else {
            int e3 = e93.e();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(0);
            sb2.append(", ");
            sb2.append(e);
            sb2.append(", ");
            sb2.append(e3);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    @Override // defpackage.g93
    public void k(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.i, 0, bArr, 0, i4);
    }

    @Override // defpackage.g93
    public final g93 n(int i2, int i3) {
        int E = g93.E(0, i3, e());
        if (E == 0) {
            return g93.g;
        }
        return new c93(this.i, E);
    }

    @Override // defpackage.g93
    public final void s(y83 y83) throws IOException {
        y83.a(this.i, 0, e());
    }

    @Override // defpackage.g93
    public final String u(Charset charset) {
        return new String(this.i, 0, e(), charset);
    }

    @Override // defpackage.g93
    public final boolean v() {
        return qn2.a(this.i, 0, e());
    }

    @Override // defpackage.g93
    public final int y(int i2, int i3, int i4) {
        byte[] bArr = this.i;
        Charset charset = ka3.f2038a;
        for (int i5 = 0; i5 < i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // defpackage.g93
    public final h93 z() {
        byte[] bArr = this.i;
        int e = e();
        h93 h93 = new h93(bArr, e);
        try {
            h93.j(e);
            return h93;
        } catch (ma3 e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
