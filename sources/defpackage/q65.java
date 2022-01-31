package defpackage;

import java.util.EnumMap;

/* renamed from: q65  reason: default package */
/* compiled from: UPCEANExtensionSupport */
public final class q65 {
    public static final int[] c = {1, 1, 2};

    /* renamed from: a  reason: collision with root package name */
    public final o65 f2907a = new o65();
    public final p65 b = new p65();

    public e35 a(int i, e45 e45, int i2) throws a35 {
        EnumMap enumMap;
        int[] iArr = c;
        int[] o = r65.o(e45, i2, false, iArr, new int[iArr.length]);
        try {
            return this.b.a(i, e45, o);
        } catch (d35 unused) {
            o65 o65 = this.f2907a;
            StringBuilder sb = o65.b;
            sb.setLength(0);
            int[] iArr2 = o65.f2656a;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int i3 = e45.g;
            int i4 = o[1];
            int i5 = 0;
            for (int i6 = 0; i6 < 2 && i4 < i3; i6++) {
                int k = r65.k(e45, iArr2, i4, r65.h);
                sb.append((char) ((k % 10) + 48));
                for (int i7 : iArr2) {
                    i4 += i7;
                }
                if (k >= 10) {
                    i5 |= 1 << (1 - i6);
                }
                if (i6 != 1) {
                    i4 = e45.g(e45.f(i4));
                }
            }
            if (sb.length() != 2) {
                throw a35.h;
            } else if (Integer.parseInt(sb.toString()) % 4 == i5) {
                String sb2 = sb.toString();
                if (sb2.length() != 2) {
                    enumMap = null;
                } else {
                    enumMap = new EnumMap(f35.class);
                    enumMap.put((Object) f35.ISSUE_NUMBER, (Object) Integer.valueOf(sb2));
                }
                float f = (float) i;
                e35 e35 = new e35(sb2, null, new g35[]{new g35(((float) (o[0] + o[1])) / 2.0f, f), new g35((float) i4, f)}, o25.UPC_EAN_EXTENSION);
                if (enumMap != null) {
                    e35.a(enumMap);
                }
                return e35;
            } else {
                throw a35.h;
            }
        }
    }
}
