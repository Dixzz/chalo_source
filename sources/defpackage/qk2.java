package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: qk2  reason: default package */
public final class qk2 extends ak2<qk2> implements Cloneable {
    public byte[][] h = fk2.d;

    public qk2() {
        this.g = null;
        this.f = -1;
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final void a(yj2 yj2) throws IOException {
        byte[] bArr = fk2.e;
        if (!Arrays.equals(bArr, bArr)) {
            yj2.d(1, bArr);
        }
        byte[][] bArr2 = this.h;
        if (bArr2 != null && bArr2.length > 0) {
            int i = 0;
            while (true) {
                byte[][] bArr3 = this.h;
                if (i >= bArr3.length) {
                    break;
                }
                byte[] bArr4 = bArr3[i];
                if (bArr4 != null) {
                    yj2.d(2, bArr4);
                }
                i++;
            }
        }
        super.a(yj2);
    }

    @Override // defpackage.ak2, java.lang.Object, defpackage.ek2
    public final Object clone() throws CloneNotSupportedException {
        try {
            qk2 qk2 = (qk2) super.clone();
            byte[][] bArr = this.h;
            if (bArr != null && bArr.length > 0) {
                qk2.h = (byte[][]) bArr.clone();
            }
            return qk2;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final int d() {
        super.d();
        byte[] bArr = fk2.e;
        int i = 0;
        int i2 = !Arrays.equals(bArr, bArr) ? yj2.i(1, bArr) + 0 : 0;
        byte[][] bArr2 = this.h;
        if (bArr2 == null || bArr2.length <= 0) {
            return i2;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[][] bArr3 = this.h;
            if (i >= bArr3.length) {
                return i2 + i3 + (i4 * 1);
            }
            byte[] bArr4 = bArr3[i];
            if (bArr4 != null) {
                i4++;
                i3 += yj2.t(bArr4.length) + bArr4.length;
            }
            i++;
        }
    }

    @Override // defpackage.ak2, defpackage.ek2
    public final /* synthetic */ ek2 e() throws CloneNotSupportedException {
        return (qk2) clone();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qk2)) {
            return false;
        }
        qk2 qk2 = (qk2) obj;
        byte[] bArr = fk2.e;
        Objects.requireNonNull(qk2);
        if (!Arrays.equals(bArr, bArr)) {
            return false;
        }
        byte[][] bArr2 = this.h;
        byte[][] bArr3 = qk2.h;
        Object obj2 = dk2.f848a;
        int length = bArr2 == null ? 0 : bArr2.length;
        int length2 = bArr3 == null ? 0 : bArr3.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length || bArr2[i] != null) {
                while (i2 < length2 && bArr3[i2] == null) {
                    i2++;
                }
                boolean z2 = i >= length;
                boolean z3 = i2 >= length2;
                if (z2 && z3) {
                    z = true;
                    break;
                } else if (z2 == z3 && Arrays.equals(bArr2[i], bArr3[i2])) {
                    i++;
                    i2++;
                }
            } else {
                i++;
            }
        }
        z = false;
        if (!z) {
            return false;
        }
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            return this.g.equals(qk2.g);
        }
        bk2 bk22 = qk2.g;
        return bk22 == null || bk22.a();
    }

    /* Return type fixed from 'ak2' to match base method */
    @Override // defpackage.ak2
    public final /* synthetic */ qk2 f() throws CloneNotSupportedException {
        return (qk2) clone();
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((Arrays.hashCode(fk2.e) + ((qk2.class.getName().hashCode() + 527) * 31)) * 31) + 0) * 31;
        byte[][] bArr = this.h;
        Object obj = dk2.f848a;
        int length = bArr == null ? 0 : bArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr2 = bArr[i3];
            if (bArr2 != null) {
                i2 = Arrays.hashCode(bArr2) + (i2 * 31);
            }
        }
        int i4 = (((hashCode + i2) * 31) + 1237) * 31;
        bk2 bk2 = this.g;
        if (bk2 != null && !bk2.a()) {
            i = this.g.hashCode();
        }
        return i4 + i;
    }
}
