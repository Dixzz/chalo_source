package defpackage;

/* renamed from: d95  reason: default package */
/* compiled from: FormatInformation */
public final class d95 {
    public static final int[][] c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a  reason: collision with root package name */
    public final c95 f812a;
    public final byte b;

    public d95(int i) {
        this.f812a = c95.forBits((i >> 3) & 3);
        this.b = (byte) (i & 7);
    }

    public static d95 a(int i, int i2) {
        int b2;
        int[][] iArr = c;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr2 : iArr) {
            int i5 = iArr2[0];
            if (i5 == i || i5 == i2) {
                return new d95(iArr2[1]);
            }
            int b3 = b(i, i5);
            if (b3 < i3) {
                i4 = iArr2[1];
                i3 = b3;
            }
            if (i != i2 && (b2 = b(i2, i5)) < i3) {
                i4 = iArr2[1];
                i3 = b2;
            }
        }
        if (i3 <= 3) {
            return new d95(i4);
        }
        return null;
    }

    public static int b(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d95)) {
            return false;
        }
        d95 d95 = (d95) obj;
        if (this.f812a == d95.f812a && this.b == d95.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f812a.ordinal() << 3) | this.b;
    }
}
