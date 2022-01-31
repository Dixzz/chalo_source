package defpackage;

import defpackage.hh3;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: eh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class eh3 extends xg3 {
    public final byte[] i;

    public eh3(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.i = bArr;
    }

    @Override // defpackage.xg3
    public final int b(int i2, int i3, int i4) {
        byte[] bArr = this.i;
        int y = y();
        Charset charset = zh3.f4175a;
        for (int i5 = y; i5 < y + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    @Override // defpackage.xg3
    public final xg3 d(int i2, int i3) {
        int s = xg3.s(0, i3, size());
        if (s == 0) {
            return xg3.g;
        }
        return new dh3(this.i, y(), s);
    }

    @Override // defpackage.xg3
    public final String e(Charset charset) {
        return new String(this.i, y(), size(), charset);
    }

    @Override // defpackage.xg3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xg3) || size() != ((xg3) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof eh3)) {
            return obj.equals(this);
        }
        eh3 eh3 = (eh3) obj;
        int i2 = this.f;
        int i3 = eh3.f;
        if (i2 != 0 && i3 != 0 && i2 != i3) {
            return false;
        }
        int size = size();
        if (size > eh3.size()) {
            int size2 = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(size);
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        } else if (size <= eh3.size()) {
            byte[] bArr = this.i;
            byte[] bArr2 = eh3.i;
            int y = y() + size;
            int y2 = y();
            int y3 = eh3.y();
            while (y2 < y) {
                if (bArr[y2] != bArr2[y3]) {
                    return false;
                }
                y2++;
                y3++;
            }
            return true;
        } else {
            throw new IllegalArgumentException(hj1.w(59, "Ran off end of other: 0, ", size, ", ", eh3.size()));
        }
    }

    @Override // defpackage.xg3
    public final void k(yg3 yg3) throws IOException {
        ((hh3.b) yg3).V(this.i, y(), size());
    }

    @Override // defpackage.xg3
    public final boolean n() {
        int y = y();
        if (pk3.f2815a.a(0, this.i, y, size() + y) == 0) {
            return true;
        }
        return false;
    }

    @Override // defpackage.xg3
    public int size() {
        return this.i.length;
    }

    @Override // defpackage.xg3
    public byte u(int i2) {
        return this.i[i2];
    }

    @Override // defpackage.xg3
    public byte v(int i2) {
        return this.i[i2];
    }

    public int y() {
        return 0;
    }
}
