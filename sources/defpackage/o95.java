package defpackage;

import java.lang.reflect.Array;

/* renamed from: o95  reason: default package */
/* compiled from: ByteMatrix */
public final class o95 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[][] f2668a;
    public final int b;
    public final int c;

    public o95(int i, int i2) {
        int[] iArr = new int[2];
        iArr[1] = i;
        iArr[0] = i2;
        this.f2668a = (byte[][]) Array.newInstance(byte.class, iArr);
        this.b = i;
        this.c = i2;
    }

    public byte a(int i, int i2) {
        return this.f2668a[i2][i];
    }

    public void b(int i, int i2, int i3) {
        this.f2668a[i2][i] = (byte) i3;
    }

    public void c(int i, int i2, boolean z) {
        this.f2668a[i2][i] = z ? (byte) 1 : 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            byte[] bArr = this.f2668a[i];
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b2 = bArr[i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
