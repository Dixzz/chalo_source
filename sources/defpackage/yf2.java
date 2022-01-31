package defpackage;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: yf2  reason: default package */
public class yf2 extends uf2 {
    public final byte[] i;

    public yf2(byte[] bArr) {
        this.i = bArr;
    }

    @Override // defpackage.uf2
    public final int b(int i2, int i3, int i4) {
        byte[] bArr = this.i;
        int u = u();
        Charset charset = wg2.f3775a;
        for (int i5 = u; i5 < u + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // defpackage.uf2
    public final String d(Charset charset) {
        return new String(this.i, u(), size(), charset);
    }

    @Override // defpackage.uf2
    public final void e(tf2 tf2) throws IOException {
        tf2.a(this.i, u(), size());
    }

    @Override // defpackage.uf2
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof uf2) || size() != ((uf2) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof yf2)) {
            return obj.equals(this);
        }
        yf2 yf2 = (yf2) obj;
        int i2 = this.f;
        int i3 = yf2.f;
        if (i2 != 0 && i3 != 0 && i2 != i3) {
            return false;
        }
        int size = size();
        if (size > yf2.size()) {
            int size2 = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(size);
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        } else if (size <= yf2.size()) {
            byte[] bArr = this.i;
            byte[] bArr2 = yf2.i;
            int u = u() + size;
            int u2 = u();
            int u3 = yf2.u();
            while (u2 < u) {
                if (bArr[u2] != bArr2[u3]) {
                    return false;
                }
                u2++;
                u3++;
            }
            return true;
        } else {
            throw new IllegalArgumentException(hj1.w(59, "Ran off end of other: 0, ", size, ", ", yf2.size()));
        }
    }

    @Override // defpackage.uf2
    public final boolean k() {
        int u = u();
        return lj2.e(this.i, u, size() + u);
    }

    @Override // defpackage.uf2
    public byte s(int i2) {
        return this.i[i2];
    }

    @Override // defpackage.uf2
    public int size() {
        return this.i.length;
    }

    public int u() {
        return 0;
    }
}
