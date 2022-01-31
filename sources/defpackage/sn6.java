package defpackage;

/* renamed from: sn6  reason: default package */
/* compiled from: Buffer.kt */
public final class sn6 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3231a;

    static {
        n86.f("0123456789abcdef", "$this$asUtf8ToByteArray");
        byte[] bytes = "0123456789abcdef".getBytes(aa6.f144a);
        n86.b(bytes, "(this as java.lang.String).getBytes(charset)");
        f3231a = bytes;
    }

    public static final String a(vm6 vm6, long j) {
        n86.f(vm6, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (vm6.e(j2) == ((byte) 13)) {
                String p = vm6.p(j2);
                vm6.d(2);
                return p;
            }
        }
        String p2 = vm6.p(j);
        vm6.d(1);
        return p2;
    }

    public static final int b(vm6 vm6, hn6 hn6, boolean z) {
        int i;
        int i2;
        int i3;
        ln6 ln6;
        int i4;
        n86.f(vm6, "$this$selectPrefix");
        n86.f(hn6, "options");
        ln6 ln62 = vm6.f;
        if (ln62 != null) {
            byte[] bArr = ln62.f2245a;
            int i5 = ln62.b;
            int i6 = ln62.c;
            int[] iArr = hn6.g;
            ln6 ln63 = ln62;
            int i7 = 0;
            int i8 = -1;
            loop0:
            while (true) {
                int i9 = i7 + 1;
                int i10 = iArr[i7];
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                if (i12 != -1) {
                    i8 = i12;
                }
                if (ln63 == null) {
                    break;
                }
                if (i10 < 0) {
                    int i13 = (i10 * -1) + i11;
                    while (true) {
                        int i14 = i5 + 1;
                        int i15 = i11 + 1;
                        if ((bArr[i5] & 255) != iArr[i11]) {
                            return i8;
                        }
                        boolean z2 = i15 == i13;
                        if (i14 != i6) {
                            i3 = i6;
                            i4 = i14;
                            ln6 = ln63;
                        } else if (ln63 != null) {
                            ln6 ln64 = ln63.f;
                            if (ln64 != null) {
                                i4 = ln64.b;
                                byte[] bArr2 = ln64.f2245a;
                                i3 = ln64.c;
                                if (ln64 != ln62) {
                                    ln6 = ln64;
                                    bArr = bArr2;
                                } else if (!z2) {
                                    break loop0;
                                } else {
                                    bArr = bArr2;
                                    ln6 = null;
                                }
                            } else {
                                n86.k();
                                throw null;
                            }
                        } else {
                            n86.k();
                            throw null;
                        }
                        if (z2) {
                            i2 = iArr[i15];
                            i = i4;
                            i6 = i3;
                            ln63 = ln6;
                            break;
                        }
                        i5 = i4;
                        i6 = i3;
                        i11 = i15;
                        ln63 = ln6;
                    }
                } else {
                    i = i5 + 1;
                    int i16 = bArr[i5] & 255;
                    int i17 = i11 + i10;
                    while (i11 != i17) {
                        if (i16 == iArr[i11]) {
                            i2 = iArr[i11 + i10];
                            if (i == i6) {
                                ln63 = ln63.f;
                                if (ln63 != null) {
                                    i = ln63.b;
                                    bArr = ln63.f2245a;
                                    i6 = ln63.c;
                                    if (ln63 == ln62) {
                                        ln63 = null;
                                    }
                                } else {
                                    n86.k();
                                    throw null;
                                }
                            }
                        } else {
                            i11++;
                        }
                    }
                    return i8;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i7 = -i2;
                i5 = i;
            }
            if (z) {
                return -2;
            }
            return i8;
        } else if (z) {
            return -2;
        } else {
            return -1;
        }
    }
}
