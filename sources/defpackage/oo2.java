package defpackage;

import java.util.Arrays;

/* renamed from: oo2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class oo2 implements Comparable<oo2> {
    public final byte[] f;

    public /* synthetic */ oo2(byte[] bArr) {
        this.f = Arrays.copyOf(bArr, bArr.length);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(oo2 oo2) {
        oo2 oo22 = oo2;
        int length = this.f.length;
        int length2 = oo22.f.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.f;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = oo22.f[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof oo2)) {
            return false;
        }
        return Arrays.equals(this.f, ((oo2) obj).f);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f);
    }

    public final String toString() {
        return gj1.V0(this.f);
    }
}
