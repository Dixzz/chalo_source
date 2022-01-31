package defpackage;

import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* renamed from: ew3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class ew3<T> implements qw3<T> {
    public static final int[] p = new int[0];
    public static final Unsafe q = kx3.k();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1035a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final cw3 e;
    public final boolean f;
    public final boolean g;
    public final int[] h;
    public final int i;
    public final int j;
    public final iw3 k;
    public final mv3 l;
    public final ex3<?, ?> m;
    public final gu3<?> n;
    public final vv3 o;

    /* JADX WARN: Incorrect args count in method signature: ([I[Ljava/lang/Object;IILcw3;ZZ[IIILiw3;Lmv3;Lex3<**>;Lgu3<*>;Lvv3;)V */
    public ew3(int[] iArr, Object[] objArr, int i2, int i3, cw3 cw3, boolean z, int[] iArr2, int i4, int i5, iw3 iw3, mv3 mv3, ex3 ex3, gu3 gu3, vv3 vv3) {
        this.f1035a = iArr;
        this.b = objArr;
        this.c = i2;
        this.d = i3;
        boolean z2 = cw3 instanceof ru3;
        this.g = z;
        this.f = gu3 != null && gu3.e(cw3);
        this.h = iArr2;
        this.i = i4;
        this.j = i5;
        this.k = iw3;
        this.l = mv3;
        this.m = ex3;
        this.n = gu3;
        this.e = cw3;
        this.o = vv3;
    }

    public static <T> float E(T t, long j2) {
        return ((Float) kx3.r(t, j2)).floatValue();
    }

    public static <T> int I(T t, long j2) {
        return ((Integer) kx3.r(t, j2)).intValue();
    }

    public static <T> long K(T t, long j2) {
        return ((Long) kx3.r(t, j2)).longValue();
    }

    public static dx3 L(Object obj) {
        ru3 ru3 = (ru3) obj;
        dx3 dx3 = ru3.zzb;
        if (dx3 != dx3.f) {
            return dx3;
        }
        dx3 c2 = dx3.c();
        ru3.zzb = c2;
        return c2;
    }

    public static <T> boolean M(T t, long j2) {
        return ((Boolean) kx3.r(t, j2)).booleanValue();
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Law3;Liw3;Lmv3;Lex3<**>;Lgu3<*>;Lvv3;)Lew3<TT;>; */
    public static ew3 m(aw3 aw3, iw3 iw3, mv3 mv3, ex3 ex3, gu3 gu3, vv3 vv3) {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        ow3 ow3;
        int i13;
        String str;
        Object[] objArr;
        boolean z;
        int i14;
        int i15;
        int i16;
        Field field;
        int i17;
        char charAt;
        int i18;
        int i19;
        Field field2;
        Field field3;
        int i20;
        char charAt2;
        int i21;
        char charAt3;
        int i22;
        char charAt4;
        int i23;
        char charAt5;
        int i24;
        char charAt6;
        int i25;
        char charAt7;
        int i26;
        char charAt8;
        int i27;
        char charAt9;
        int i28;
        char charAt10;
        int i29;
        char charAt11;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        if (aw3 instanceof ow3) {
            ow3 ow32 = (ow3) aw3;
            int i32 = 0;
            boolean z2 = ((ow32.d & 1) == 1 ? (char) 1 : 2) == 2;
            String str2 = ow32.b;
            int length = str2.length();
            if (str2.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i2 = i33 + 1;
                    if (str2.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i2;
                }
            } else {
                i2 = 1;
            }
            int i34 = i2 + 1;
            int charAt14 = str2.charAt(i2);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = str2.charAt(i34);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i35 |= (charAt13 & 8191) << i36;
                    i36 += 13;
                    i34 = i31;
                }
                charAt14 = i35 | (charAt13 << i36);
                i34 = i31;
            }
            if (charAt14 == 0) {
                iArr = p;
                i8 = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = str2.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = str2.charAt(i37);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i38 |= (charAt12 & 8191) << i39;
                        i39 += 13;
                        i37 = i30;
                    }
                    charAt15 = i38 | (charAt12 << i39);
                    i37 = i30;
                }
                int i40 = i37 + 1;
                int charAt16 = str2.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = str2.charAt(i40);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i41 |= (charAt11 & 8191) << i42;
                        i42 += 13;
                        i40 = i29;
                    }
                    charAt16 = i41 | (charAt11 << i42);
                    i40 = i29;
                }
                int i43 = i40 + 1;
                i7 = str2.charAt(i40);
                if (i7 >= 55296) {
                    int i44 = i7 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = str2.charAt(i43);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i44 |= (charAt10 & 8191) << i45;
                        i45 += 13;
                        i43 = i28;
                    }
                    i7 = i44 | (charAt10 << i45);
                    i43 = i28;
                }
                int i46 = i43 + 1;
                i6 = str2.charAt(i43);
                if (i6 >= 55296) {
                    int i47 = i6 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = str2.charAt(i46);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i47 |= (charAt9 & 8191) << i48;
                        i48 += 13;
                        i46 = i27;
                    }
                    i6 = i47 | (charAt9 << i48);
                    i46 = i27;
                }
                int i49 = i46 + 1;
                i5 = str2.charAt(i46);
                if (i5 >= 55296) {
                    int i50 = i5 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = str2.charAt(i49);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i50 |= (charAt8 & 8191) << i51;
                        i51 += 13;
                        i49 = i26;
                    }
                    i5 = i50 | (charAt8 << i51);
                    i49 = i26;
                }
                int i52 = i49 + 1;
                int charAt17 = str2.charAt(i49);
                if (charAt17 >= 55296) {
                    int i53 = charAt17 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = str2.charAt(i52);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i53 |= (charAt7 & 8191) << i54;
                        i54 += 13;
                        i52 = i25;
                    }
                    charAt17 = i53 | (charAt7 << i54);
                    i52 = i25;
                }
                int i55 = i52 + 1;
                int charAt18 = str2.charAt(i52);
                if (charAt18 >= 55296) {
                    int i56 = charAt18 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = str2.charAt(i55);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i56 |= (charAt6 & 8191) << i57;
                        i57 += 13;
                        i55 = i24;
                    }
                    charAt18 = i56 | (charAt6 << i57);
                    i55 = i24;
                }
                int i58 = i55 + 1;
                i3 = str2.charAt(i55);
                if (i3 >= 55296) {
                    int i59 = i3 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = str2.charAt(i60);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i59 |= (charAt5 & 8191) << i61;
                        i61 += 13;
                        i60 = i23;
                    }
                    i3 = i59 | (charAt5 << i61);
                    i58 = i23;
                }
                i4 = (charAt15 << 1) + charAt16;
                i8 = charAt17;
                iArr = new int[(i3 + charAt17 + charAt18)];
                i32 = charAt15;
                i34 = i58;
            }
            Unsafe unsafe = q;
            Object[] objArr2 = ow32.c;
            Class<?> cls = ow32.f2737a.getClass();
            int[] iArr2 = new int[(i5 * 3)];
            Object[] objArr3 = new Object[(i5 << 1)];
            int i62 = i3 + i8;
            int i63 = i3;
            int i64 = i34;
            int i65 = i62;
            int i66 = 0;
            int i67 = 0;
            while (i64 < length) {
                int i68 = i64 + 1;
                int charAt19 = str2.charAt(i64);
                if (charAt19 >= 55296) {
                    int i69 = charAt19 & 8191;
                    int i70 = i68;
                    int i71 = 13;
                    while (true) {
                        i22 = i70 + 1;
                        charAt4 = str2.charAt(i70);
                        i9 = i3;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i69 |= (charAt4 & 8191) << i71;
                        i71 += 13;
                        i70 = i22;
                        i3 = i9;
                    }
                    charAt19 = i69 | (charAt4 << i71);
                    i10 = i22;
                } else {
                    i9 = i3;
                    i10 = i68;
                }
                int i72 = i10 + 1;
                int charAt20 = str2.charAt(i10);
                if (charAt20 >= 55296) {
                    int i73 = charAt20 & 8191;
                    int i74 = i72;
                    int i75 = 13;
                    while (true) {
                        i21 = i74 + 1;
                        charAt3 = str2.charAt(i74);
                        i11 = i6;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i73 |= (charAt3 & 8191) << i75;
                        i75 += 13;
                        i74 = i21;
                        i6 = i11;
                    }
                    charAt20 = i73 | (charAt3 << i75);
                    i12 = i21;
                } else {
                    i11 = i6;
                    i12 = i72;
                }
                int i76 = charAt20 & Constants.MAX_HOST_LENGTH;
                if ((charAt20 & 1024) != 0) {
                    iArr[i66] = i67;
                    i66++;
                }
                if (i76 >= 51) {
                    int i77 = i12 + 1;
                    int charAt21 = str2.charAt(i12);
                    char c2 = 55296;
                    if (charAt21 >= 55296) {
                        int i78 = 13;
                        int i79 = charAt21 & 8191;
                        int i80 = i77;
                        while (true) {
                            i20 = i80 + 1;
                            charAt2 = str2.charAt(i80);
                            if (charAt2 < c2) {
                                break;
                            }
                            i79 |= (charAt2 & 8191) << i78;
                            i78 += 13;
                            i80 = i20;
                            c2 = 55296;
                        }
                        charAt21 = i79 | (charAt2 << i78);
                        i19 = i20;
                    } else {
                        i19 = i77;
                    }
                    int i81 = i76 - 51;
                    ow3 = ow32;
                    if (i81 == 9 || i81 == 17) {
                        objArr3[((i67 / 3) << 1) + 1] = objArr2[i4];
                        i4++;
                    } else if (i81 == 12 && !z2) {
                        objArr3[((i67 / 3) << 1) + 1] = objArr2[i4];
                        i4++;
                    }
                    int i82 = charAt21 << 1;
                    Object obj = objArr2[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = o(cls, (String) obj);
                        objArr2[i82] = field2;
                    }
                    i15 = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = objArr2[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = o(cls, (String) obj2);
                        objArr2[i83] = field3;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field3);
                    str = str2;
                    z = z2;
                    i12 = i19;
                    i13 = i4;
                    i16 = objectFieldOffset;
                    objArr = objArr3;
                    i14 = 0;
                } else {
                    ow3 = ow32;
                    int i84 = i4 + 1;
                    Field o2 = o(cls, (String) objArr2[i4]);
                    if (i76 == 9 || i76 == 17) {
                        objArr3[((i67 / 3) << 1) + 1] = o2.getType();
                    } else {
                        if (i76 == 27 || i76 == 49) {
                            i18 = i84 + 1;
                            objArr3[((i67 / 3) << 1) + 1] = objArr2[i84];
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (!z2) {
                                i18 = i84 + 1;
                                objArr3[((i67 / 3) << 1) + 1] = objArr2[i84];
                            }
                        } else if (i76 == 50) {
                            int i85 = i63 + 1;
                            iArr[i63] = i67;
                            int i86 = (i67 / 3) << 1;
                            i18 = i84 + 1;
                            objArr3[i86] = objArr2[i84];
                            if ((charAt20 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr3[i86 + 1] = objArr2[i18];
                                objArr = objArr3;
                                i63 = i85;
                                z = z2;
                                i15 = (int) unsafe.objectFieldOffset(o2);
                                if ((charAt20 & 4096) == 4096 || i76 > 17) {
                                    i13 = i84;
                                    str = str2;
                                    i16 = 1048575;
                                    i14 = 0;
                                } else {
                                    int i87 = i12 + 1;
                                    int charAt22 = str2.charAt(i12);
                                    if (charAt22 >= 55296) {
                                        int i88 = charAt22 & 8191;
                                        int i89 = 13;
                                        while (true) {
                                            i17 = i87 + 1;
                                            charAt = str2.charAt(i87);
                                            if (charAt < 55296) {
                                                break;
                                            }
                                            i88 |= (charAt & 8191) << i89;
                                            i89 += 13;
                                            i87 = i17;
                                        }
                                        charAt22 = i88 | (charAt << i89);
                                        i87 = i17;
                                    }
                                    int i90 = (charAt22 / 32) + (i32 << 1);
                                    Object obj3 = objArr2[i90];
                                    i13 = i84;
                                    if (obj3 instanceof Field) {
                                        field = (Field) obj3;
                                    } else {
                                        field = o(cls, (String) obj3);
                                        objArr2[i90] = field;
                                    }
                                    str = str2;
                                    i16 = (int) unsafe.objectFieldOffset(field);
                                    i14 = charAt22 % 32;
                                    i12 = i87;
                                }
                                if (i76 >= 18 && i76 <= 49) {
                                    iArr[i65] = i15;
                                    i65++;
                                }
                            } else {
                                i63 = i85;
                            }
                        }
                        i84 = i18;
                    }
                    z = z2;
                    objArr = objArr3;
                    i15 = (int) unsafe.objectFieldOffset(o2);
                    if ((charAt20 & 4096) == 4096) {
                    }
                    i13 = i84;
                    str = str2;
                    i16 = 1048575;
                    i14 = 0;
                    iArr[i65] = i15;
                    i65++;
                }
                int i91 = i67 + 1;
                iArr2[i67] = charAt19;
                int i92 = i91 + 1;
                iArr2[i91] = ((charAt20 & 512) != 0 ? 536870912 : 0) | ((charAt20 & 256) != 0 ? 268435456 : 0) | (i76 << 20) | i15;
                i67 = i92 + 1;
                iArr2[i92] = (i14 << 20) | i16;
                z2 = z;
                i64 = i12;
                i7 = i7;
                length = length;
                i3 = i9;
                i6 = i11;
                objArr3 = objArr;
                str2 = str;
                i4 = i13;
                ow32 = ow3;
            }
            return new ew3(iArr2, objArr3, i7, i6, ow32.f2737a, z2, iArr, i3, i62, iw3, mv3, ex3, gu3, vv3);
        }
        zw3 zw3 = (zw3) aw3;
        throw new NoSuchMethodError();
    }

    public static Field o(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(hj1.g0(arrays, name.length() + hj1.g0(str, 40)));
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            throw new RuntimeException(hj1.a0(sb, " not found. Known fields are ", arrays));
        }
    }

    public static List<?> p(Object obj, long j2) {
        return (List) kx3.r(obj, j2);
    }

    public static void q(int i2, Object obj, wx3 wx3) throws IOException {
        if (obj instanceof String) {
            ((du3) wx3).f889a.k(i2, (String) obj);
            return;
        }
        ((du3) wx3).f889a.h(i2, (qt3) obj);
    }

    public static <UT, UB> void r(ex3<UT, UB> ex3, T t, wx3 wx3) throws IOException {
        ex3.c(ex3.e(t), wx3);
    }

    public static <T> double x(T t, long j2) {
        return ((Double) kx3.r(t, j2)).doubleValue();
    }

    public final void A(T t, int i2) {
        int i3 = this.f1035a[i2 + 2];
        long j2 = (long) (1048575 & i3);
        if (j2 != 1048575) {
            kx3.e.e(t, j2, (1 << (i3 >>> 20)) | kx3.b(t, j2));
        }
    }

    public final void B(T t, int i2, int i3) {
        kx3.e.e(t, (long) (this.f1035a[i3 + 2] & 1048575), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C(T r18, defpackage.wx3 r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1488
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew3.C(java.lang.Object, wx3):void");
    }

    public final void D(T t, T t2, int i2) {
        int[] iArr = this.f1035a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (v(t2, i4, i2)) {
            Object obj = null;
            if (v(t, i4, i2)) {
                obj = kx3.r(t, j2);
            }
            Object r = kx3.r(t2, j2);
            if (obj != null && r != null) {
                kx3.f(t, j2, tu3.c(obj, r));
                B(t, i4, i2);
            } else if (r != null) {
                kx3.f(t, j2, r);
                B(t, i4, i2);
            }
        }
    }

    public final yu3 F(int i2) {
        return (yu3) this.b[((i2 / 3) << 1) + 1];
    }

    public final boolean G(T t, T t2, int i2) {
        return u(t, i2) == u(t2, i2);
    }

    public final int H(int i2) {
        return this.f1035a[i2 + 1];
    }

    public final int J(int i2) {
        return this.f1035a[i2 + 2];
    }

    @Override // defpackage.qw3
    public final void a(T t) {
        int i2;
        int i3 = this.i;
        while (true) {
            i2 = this.j;
            if (i3 >= i2) {
                break;
            }
            long H = (long) (H(this.h[i3]) & 1048575);
            Object r = kx3.r(t, H);
            if (r != null) {
                kx3.f(t, H, this.o.g(r));
            }
            i3++;
        }
        int length = this.h.length;
        while (i2 < length) {
            this.l.b(t, (long) this.h[i2]);
            i2++;
        }
        this.m.h(t);
        if (this.f) {
            this.n.g(t);
        }
    }

    @Override // defpackage.qw3
    public final void b(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f1035a.length; i2 += 3) {
            int H = H(i2);
            long j2 = (long) (1048575 & H);
            int i3 = this.f1035a[i2];
            switch ((H & 267386880) >>> 20) {
                case 0:
                    if (u(t2, i2)) {
                        kx3.d(t, j2, kx3.q(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (u(t2, i2)) {
                        kx3.e.d(t, j2, kx3.n(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (u(t2, i2)) {
                        kx3.e(t, j2, kx3.i(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (u(t2, i2)) {
                        kx3.e(t, j2, kx3.i(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (u(t2, i2)) {
                        kx3.e.e(t, j2, kx3.b(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (u(t2, i2)) {
                        kx3.e(t, j2, kx3.i(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (u(t2, i2)) {
                        kx3.e.e(t, j2, kx3.b(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (u(t2, i2)) {
                        kx3.e.g(t, j2, kx3.m(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (u(t2, i2)) {
                        kx3.f(t, j2, kx3.r(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    t(t, t2, i2);
                    break;
                case 10:
                    if (u(t2, i2)) {
                        kx3.f(t, j2, kx3.r(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (u(t2, i2)) {
                        kx3.e.e(t, j2, kx3.b(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (u(t2, i2)) {
                        kx3.e.e(t, j2, kx3.b(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (u(t2, i2)) {
                        kx3.e.e(t, j2, kx3.b(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (u(t2, i2)) {
                        kx3.e(t, j2, kx3.i(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (u(t2, i2)) {
                        kx3.e.e(t, j2, kx3.b(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (u(t2, i2)) {
                        kx3.e(t, j2, kx3.i(t2, j2));
                        A(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    t(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.l.a(t, t2, j2);
                    break;
                case 50:
                    vv3 vv3 = this.o;
                    Class<?> cls = sw3.f3265a;
                    kx3.f(t, j2, vv3.h(kx3.r(t, j2), kx3.r(t2, j2)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (v(t2, i3, i2)) {
                        kx3.f(t, j2, kx3.r(t2, j2));
                        B(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    D(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (v(t2, i3, i2)) {
                        kx3.f(t, j2, kx3.r(t2, j2));
                        B(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    D(t, t2, i2);
                    break;
            }
        }
        ex3<?, ?> ex3 = this.m;
        Class<?> cls2 = sw3.f3265a;
        ex3.d(t, ex3.g(ex3.e(t), ex3.e(t2)));
        if (this.f) {
            sw3.i(this.n, t, t2);
        }
    }

    @Override // defpackage.qw3
    public final int c(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (this.g) {
            Unsafe unsafe = q;
            int i11 = 0;
            for (int i12 = 0; i12 < this.f1035a.length; i12 += 3) {
                int H = H(i12);
                int i13 = (H & 267386880) >>> 20;
                int i14 = this.f1035a[i12];
                long j2 = (long) (H & 1048575);
                if (i13 >= lu3.DOUBLE_LIST_PACKED.zza() && i13 <= lu3.SINT64_LIST_PACKED.zza()) {
                    int i15 = this.f1035a[i12 + 2];
                }
                switch (i13) {
                    case 0:
                        if (u(t, i12)) {
                            i7 = bu3.u(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (u(t, i12)) {
                            i7 = bu3.n(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (u(t, i12)) {
                            i7 = bu3.B(i14, kx3.i(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (u(t, i12)) {
                            i7 = bu3.E(i14, kx3.i(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (u(t, i12)) {
                            i7 = bu3.I(i14, kx3.b(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (u(t, i12)) {
                            i7 = bu3.N(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (u(t, i12)) {
                            i7 = bu3.S(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (u(t, i12)) {
                            i7 = bu3.v(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (u(t, i12)) {
                            Object r = kx3.r(t, j2);
                            if (r instanceof qt3) {
                                i7 = bu3.w(i14, (qt3) r);
                            } else {
                                i7 = bu3.o(i14, (String) r);
                            }
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (u(t, i12)) {
                            i7 = sw3.a(i14, kx3.r(t, j2), n(i12));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (u(t, i12)) {
                            i7 = bu3.w(i14, (qt3) kx3.r(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (u(t, i12)) {
                            i7 = bu3.M(i14, kx3.b(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (u(t, i12)) {
                            i7 = bu3.U(i14, kx3.b(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (u(t, i12)) {
                            i7 = bu3.T(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (u(t, i12)) {
                            i7 = bu3.Q(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (u(t, i12)) {
                            i7 = bu3.P(i14, kx3.b(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (u(t, i12)) {
                            i7 = bu3.J(i14, kx3.i(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (u(t, i12)) {
                            i7 = bu3.x(i14, (cw3) kx3.r(t, j2), n(i12));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i7 = sw3.K(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 19:
                        i7 = sw3.H(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 20:
                        i7 = sw3.k(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 21:
                        i7 = sw3.r(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 22:
                        i7 = sw3.y(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 23:
                        i7 = sw3.K(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 24:
                        i7 = sw3.H(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 25:
                        List<?> p2 = p(t, j2);
                        Class<?> cls = sw3.f3265a;
                        int size = p2.size();
                        if (size == 0) {
                            i7 = 0;
                        } else {
                            i7 = size * bu3.v(i14);
                        }
                        i11 += i7;
                        break;
                    case 26:
                        i7 = sw3.b(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 27:
                        i7 = sw3.c(i14, p(t, j2), n(i12));
                        i11 += i7;
                        break;
                    case 28:
                        i7 = sw3.l(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 29:
                        i7 = sw3.B(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 30:
                        i7 = sw3.v(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 31:
                        i7 = sw3.H(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 32:
                        i7 = sw3.K(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 33:
                        i7 = sw3.E(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 34:
                        i7 = sw3.s(i14, p(t, j2));
                        i11 += i7;
                        break;
                    case 35:
                        i10 = sw3.L((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        i10 = sw3.I((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        i10 = sw3.d((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        i10 = sw3.n((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        i10 = sw3.z((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        i10 = sw3.L((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        i10 = sw3.I((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        Class<?> cls2 = sw3.f3265a;
                        i10 = ((List) unsafe.getObject(t, j2)).size();
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        i10 = sw3.C((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        i10 = sw3.w((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        i10 = sw3.I((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        i10 = sw3.L((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        i10 = sw3.F((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        i10 = sw3.t((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = bu3.D(i14);
                            i8 = bu3.L(i10);
                            i11 = i8 + i9 + i10 + i11;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i7 = sw3.m(i14, p(t, j2), n(i12));
                        i11 += i7;
                        break;
                    case 50:
                        i7 = this.o.i(i14, kx3.r(t, j2), z(i12));
                        i11 += i7;
                        break;
                    case 51:
                        if (v(t, i14, i12)) {
                            i7 = bu3.u(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (v(t, i14, i12)) {
                            i7 = bu3.n(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (v(t, i14, i12)) {
                            i7 = bu3.B(i14, K(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (v(t, i14, i12)) {
                            i7 = bu3.E(i14, K(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (v(t, i14, i12)) {
                            i7 = bu3.I(i14, I(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (v(t, i14, i12)) {
                            i7 = bu3.N(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (v(t, i14, i12)) {
                            i7 = bu3.S(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (v(t, i14, i12)) {
                            i7 = bu3.v(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (v(t, i14, i12)) {
                            Object r2 = kx3.r(t, j2);
                            if (r2 instanceof qt3) {
                                i7 = bu3.w(i14, (qt3) r2);
                            } else {
                                i7 = bu3.o(i14, (String) r2);
                            }
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (v(t, i14, i12)) {
                            i7 = sw3.a(i14, kx3.r(t, j2), n(i12));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (v(t, i14, i12)) {
                            i7 = bu3.w(i14, (qt3) kx3.r(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (v(t, i14, i12)) {
                            i7 = bu3.M(i14, I(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (v(t, i14, i12)) {
                            i7 = bu3.U(i14, I(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (v(t, i14, i12)) {
                            i7 = bu3.T(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (v(t, i14, i12)) {
                            i7 = bu3.Q(i14);
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (v(t, i14, i12)) {
                            i7 = bu3.P(i14, I(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (v(t, i14, i12)) {
                            i7 = bu3.J(i14, K(t, j2));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (v(t, i14, i12)) {
                            i7 = bu3.x(i14, (cw3) kx3.r(t, j2), n(i12));
                            i11 += i7;
                            break;
                        } else {
                            break;
                        }
                }
            }
            ex3<?, ?> ex3 = this.m;
            return ex3.j(ex3.e(t)) + i11;
        }
        Unsafe unsafe2 = q;
        int i16 = 0;
        int i17 = 1048575;
        int i18 = 0;
        for (int i19 = 0; i19 < this.f1035a.length; i19 += 3) {
            int H2 = H(i19);
            int[] iArr = this.f1035a;
            int i20 = iArr[i19];
            int i21 = (H2 & 267386880) >>> 20;
            if (i21 <= 17) {
                int i22 = iArr[i19 + 2];
                int i23 = i22 & 1048575;
                i2 = 1 << (i22 >>> 20);
                if (i23 != i17) {
                    i18 = unsafe2.getInt(t, (long) i23);
                    i17 = i23;
                }
            } else {
                i2 = 0;
            }
            long j3 = (long) (H2 & 1048575);
            switch (i21) {
                case 0:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.u(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.n(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.B(i20, unsafe2.getLong(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.E(i20, unsafe2.getLong(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.I(i20, unsafe2.getInt(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.N(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.S(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.v(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i18 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof qt3) {
                            i3 = bu3.w(i20, (qt3) object);
                        } else {
                            i3 = bu3.o(i20, (String) object);
                        }
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i18 & i2) != 0) {
                        i3 = sw3.a(i20, unsafe2.getObject(t, j3), n(i19));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.w(i20, (qt3) unsafe2.getObject(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.M(i20, unsafe2.getInt(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.U(i20, unsafe2.getInt(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.T(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.Q(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.P(i20, unsafe2.getInt(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.J(i20, unsafe2.getLong(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i18 & i2) != 0) {
                        i3 = bu3.x(i20, (cw3) unsafe2.getObject(t, j3), n(i19));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i3 = sw3.K(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 19:
                    i3 = sw3.H(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 20:
                    i3 = sw3.k(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 21:
                    i3 = sw3.r(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 22:
                    i3 = sw3.y(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 23:
                    i3 = sw3.K(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 24:
                    i3 = sw3.H(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 25:
                    Class<?> cls3 = sw3.f3265a;
                    int size2 = ((List) unsafe2.getObject(t, j3)).size();
                    if (size2 == 0) {
                        i3 = 0;
                    } else {
                        i3 = size2 * bu3.v(i20);
                    }
                    i16 += i3;
                    break;
                case 26:
                    i3 = sw3.b(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 27:
                    i3 = sw3.c(i20, (List) unsafe2.getObject(t, j3), n(i19));
                    i16 += i3;
                    break;
                case 28:
                    i3 = sw3.l(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 29:
                    i3 = sw3.B(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 30:
                    i3 = sw3.v(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 31:
                    i3 = sw3.H(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 32:
                    i3 = sw3.K(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 33:
                    i3 = sw3.E(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 34:
                    i3 = sw3.s(i20, (List) unsafe2.getObject(t, j3));
                    i16 += i3;
                    break;
                case 35:
                    i6 = sw3.L((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i6 = sw3.I((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i6 = sw3.d((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i6 = sw3.n((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i6 = sw3.z((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i6 = sw3.L((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i6 = sw3.I((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    Class<?> cls4 = sw3.f3265a;
                    i6 = ((List) unsafe2.getObject(t, j3)).size();
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i6 = sw3.C((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i6 = sw3.w((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i6 = sw3.I((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i6 = sw3.L((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i6 = sw3.F((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i6 = sw3.t((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = bu3.D(i20);
                        i4 = bu3.L(i6);
                        i16 = i4 + i5 + i6 + i16;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i3 = sw3.m(i20, (List) unsafe2.getObject(t, j3), n(i19));
                    i16 += i3;
                    break;
                case 50:
                    i3 = this.o.i(i20, unsafe2.getObject(t, j3), z(i19));
                    i16 += i3;
                    break;
                case 51:
                    if (v(t, i20, i19)) {
                        i3 = bu3.u(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (v(t, i20, i19)) {
                        i3 = bu3.n(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (v(t, i20, i19)) {
                        i3 = bu3.B(i20, K(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i20, i19)) {
                        i3 = bu3.E(i20, K(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i20, i19)) {
                        i3 = bu3.I(i20, I(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (v(t, i20, i19)) {
                        i3 = bu3.N(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (v(t, i20, i19)) {
                        i3 = bu3.S(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (v(t, i20, i19)) {
                        i3 = bu3.v(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (v(t, i20, i19)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof qt3) {
                            i3 = bu3.w(i20, (qt3) object2);
                        } else {
                            i3 = bu3.o(i20, (String) object2);
                        }
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (v(t, i20, i19)) {
                        i3 = sw3.a(i20, unsafe2.getObject(t, j3), n(i19));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (v(t, i20, i19)) {
                        i3 = bu3.w(i20, (qt3) unsafe2.getObject(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (v(t, i20, i19)) {
                        i3 = bu3.M(i20, I(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i20, i19)) {
                        i3 = bu3.U(i20, I(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (v(t, i20, i19)) {
                        i3 = bu3.T(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (v(t, i20, i19)) {
                        i3 = bu3.Q(i20);
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (v(t, i20, i19)) {
                        i3 = bu3.P(i20, I(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i20, i19)) {
                        i3 = bu3.J(i20, K(t, j3));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (v(t, i20, i19)) {
                        i3 = bu3.x(i20, (cw3) unsafe2.getObject(t, j3), n(i19));
                        i16 += i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        ex3<?, ?> ex32 = this.m;
        int j4 = ex32.j(ex32.e(t)) + i16;
        if (!this.f) {
            return j4;
        }
        ku3<?> b2 = this.n.b(t);
        int i24 = 0;
        for (int i25 = 0; i25 < b2.f2121a.e(); i25++) {
            Map.Entry<T, Object> d2 = b2.f2121a.d(i25);
            i24 += ku3.a(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : b2.f2121a.g()) {
            i24 += ku3.a(entry.getKey(), entry.getValue());
        }
        return j4 + i24;
    }

    @Override // defpackage.qw3
    public final int d(T t) {
        int i2;
        int i3;
        int length = this.f1035a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int H = H(i5);
            int i6 = this.f1035a[i5];
            long j2 = (long) (1048575 & H);
            int i7 = 37;
            switch ((H & 267386880) >>> 20) {
                case 0:
                    i3 = i4 * 53;
                    i2 = tu3.a(Double.doubleToLongBits(kx3.q(t, j2)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    i2 = Float.floatToIntBits(kx3.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i3 = i4 * 53;
                    i2 = tu3.a(kx3.i(t, j2));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i3 = i4 * 53;
                    i2 = tu3.a(kx3.i(t, j2));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i3 = i4 * 53;
                    i2 = kx3.b(t, j2);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i3 = i4 * 53;
                    i2 = tu3.a(kx3.i(t, j2));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i3 = i4 * 53;
                    i2 = kx3.b(t, j2);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    i2 = tu3.b(kx3.m(t, j2));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) kx3.r(t, j2)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object r = kx3.r(t, j2);
                    if (r != null) {
                        i7 = r.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i3 = i4 * 53;
                    i2 = kx3.r(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i3 = i4 * 53;
                    i2 = kx3.b(t, j2);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i3 = i4 * 53;
                    i2 = kx3.b(t, j2);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i3 = i4 * 53;
                    i2 = kx3.b(t, j2);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i3 = i4 * 53;
                    i2 = tu3.a(kx3.i(t, j2));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i3 = i4 * 53;
                    i2 = kx3.b(t, j2);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i3 = i4 * 53;
                    i2 = tu3.a(kx3.i(t, j2));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object r2 = kx3.r(t, j2);
                    if (r2 != null) {
                        i7 = r2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i3 = i4 * 53;
                    i2 = kx3.r(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i3 = i4 * 53;
                    i2 = kx3.r(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.a(Double.doubleToLongBits(x(t, j2)));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = Float.floatToIntBits(E(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.a(K(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.a(K(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = I(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.a(K(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = I(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.b(M(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ((String) kx3.r(t, j2)).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = kx3.r(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = kx3.r(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = I(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = I(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = I(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.a(K(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = I(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = tu3.a(K(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = kx3.r(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.m.e(t).hashCode() + (i4 * 53);
        return this.f ? (hashCode * 53) + this.n.b(t).hashCode() : hashCode;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x059e  */
    @Override // defpackage.qw3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(T r13, defpackage.wx3 r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1610
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew3.e(java.lang.Object, wx3):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0340, code lost:
        if (r0 == r0) goto L_0x0389;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0387, code lost:
        if (r0 == r15) goto L_0x0389;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.qw3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(T r29, byte[] r30, int r31, int r32, defpackage.pt3 r33) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1046
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew3.f(java.lang.Object, byte[], int, int, pt3):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: qw3 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: qw3 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: qw3 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.qw3
    public final boolean g(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 >= this.i) {
                return !this.f || this.n.b(t).m();
            }
            int i7 = this.h[i6];
            int i8 = this.f1035a[i7];
            int H = H(i7);
            int i9 = this.f1035a[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = q.getInt(t, (long) i10);
                }
                i2 = i5;
                i3 = i10;
            } else {
                i3 = i4;
                i2 = i5;
            }
            if (((268435456 & H) != 0) && !w(t, i7, i3, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & H) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (v(t, i8, i7) && !n(i7).g(kx3.r(t, (long) (H & 1048575)))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 == 50 && !this.o.c(kx3.r(t, (long) (H & 1048575))).isEmpty()) {
                            this.o.e(z(i7));
                            throw null;
                        }
                    }
                }
                List list = (List) kx3.r(t, (long) (H & 1048575));
                if (!list.isEmpty()) {
                    qw3 n2 = n(i7);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            break;
                        } else if (!n2.g(list.get(i13))) {
                            z = false;
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (w(t, i7, i3, i2, i11) && !n(i7).g(kx3.r(t, (long) (H & 1048575)))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (defpackage.sw3.j(defpackage.kx3.r(r10, r6), defpackage.kx3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (defpackage.kx3.i(r10, r6) == defpackage.kx3.i(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (defpackage.kx3.b(r10, r6) == defpackage.kx3.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (defpackage.kx3.i(r10, r6) == defpackage.kx3.i(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (defpackage.kx3.b(r10, r6) == defpackage.kx3.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (defpackage.kx3.b(r10, r6) == defpackage.kx3.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (defpackage.kx3.b(r10, r6) == defpackage.kx3.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (defpackage.sw3.j(defpackage.kx3.r(r10, r6), defpackage.kx3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (defpackage.sw3.j(defpackage.kx3.r(r10, r6), defpackage.kx3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (defpackage.sw3.j(defpackage.kx3.r(r10, r6), defpackage.kx3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (defpackage.kx3.m(r10, r6) == defpackage.kx3.m(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (defpackage.kx3.b(r10, r6) == defpackage.kx3.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (defpackage.kx3.i(r10, r6) == defpackage.kx3.i(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (defpackage.kx3.b(r10, r6) == defpackage.kx3.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (defpackage.kx3.i(r10, r6) == defpackage.kx3.i(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (defpackage.kx3.i(r10, r6) == defpackage.kx3.i(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(defpackage.kx3.n(r10, r6)) == java.lang.Float.floatToIntBits(defpackage.kx3.n(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(defpackage.kx3.q(r10, r6)) == java.lang.Double.doubleToLongBits(defpackage.kx3.q(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (defpackage.sw3.j(defpackage.kx3.r(r10, r6), defpackage.kx3.r(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // defpackage.qw3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew3.h(java.lang.Object, java.lang.Object):boolean");
    }

    public final int i(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, pt3 pt3) throws IOException {
        int i10;
        Unsafe unsafe = q;
        long j3 = (long) (this.f1035a[i9 + 2] & 1048575);
        boolean z = true;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(Double.longBitsToDouble(hd3.V3(bArr, i2))));
                    i10 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(Float.intBitsToFloat(hd3.s3(bArr, i2))));
                    i10 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = hd3.U3(bArr, i2, pt3);
                    unsafe.putObject(t, j2, Long.valueOf(pt3.b));
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = hd3.t3(bArr, i2, pt3);
                    unsafe.putObject(t, j2, Integer.valueOf(pt3.f2847a));
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(hd3.V3(bArr, i2)));
                    i10 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(hd3.s3(bArr, i2)));
                    i10 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = hd3.U3(bArr, i2, pt3);
                    if (pt3.b == 0) {
                        z = false;
                    }
                    unsafe.putObject(t, j2, Boolean.valueOf(z));
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int t3 = hd3.t3(bArr, i2, pt3);
                    int i11 = pt3.f2847a;
                    if (i11 == 0) {
                        unsafe.putObject(t, j2, "");
                    } else if ((i7 & 536870912) == 0 || lx3.b(bArr, t3, t3 + i11)) {
                        unsafe.putObject(t, j2, new String(bArr, t3, i11, tu3.f3407a));
                        t3 += i11;
                    } else {
                        throw cv3.e();
                    }
                    unsafe.putInt(t, j3, i5);
                    return t3;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int r3 = hd3.r3(n(i9), bArr, i2, i3, pt3);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, pt3.c);
                    } else {
                        unsafe.putObject(t, j2, tu3.c(object, pt3.c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return r3;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = hd3.c4(bArr, i2, pt3);
                    unsafe.putObject(t, j2, pt3.c);
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int t32 = hd3.t3(bArr, i2, pt3);
                    int i12 = pt3.f2847a;
                    yu3 yu3 = (yu3) this.b[((i9 / 3) << 1) + 1];
                    if (yu3 == null || yu3.j(i12)) {
                        unsafe.putObject(t, j2, Integer.valueOf(i12));
                        i10 = t32;
                        unsafe.putInt(t, j3, i5);
                        return i10;
                    }
                    L(t).a(i4, Long.valueOf((long) i12));
                    return t32;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = hd3.t3(bArr, i2, pt3);
                    unsafe.putObject(t, j2, Integer.valueOf(zt3.b(pt3.f2847a)));
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = hd3.U3(bArr, i2, pt3);
                    unsafe.putObject(t, j2, Long.valueOf(zt3.a(pt3.b)));
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = hd3.q3(n(i9), bArr, i2, i3, (i4 & -8) | 4, pt3);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, pt3.c);
                    } else {
                        unsafe.putObject(t, j2, tu3.c(object2, pt3.c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:263:0x017e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:265:0x018f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:266:0x01b3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:267:0x018f */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x04a8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x04a7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x04a7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01dc  */
    public final int j(T r18, byte[] r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, long r29, defpackage.pt3 r31) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1262
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew3.j(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, pt3):int");
    }

    public final <K, V> int k(T t, byte[] bArr, int i2, int i3, int i4, long j2, pt3 pt3) throws IOException {
        Unsafe unsafe = q;
        Object obj = this.b[(i4 / 3) << 1];
        Object object = unsafe.getObject(t, j2);
        if (this.o.a(object)) {
            Object f2 = this.o.f(obj);
            this.o.h(f2, object);
            unsafe.putObject(t, j2, f2);
            object = f2;
        }
        this.o.e(obj);
        this.o.d(object);
        int t3 = hd3.t3(bArr, i2, pt3);
        int i5 = pt3.f2847a;
        if (i5 < 0 || i5 > i3 - t3) {
            throw cv3.a();
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v20, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x03e6, code lost:
        if (r0 == r10) goto L_0x043f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x043d, code lost:
        if (r0 == r15) goto L_0x043f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x043f, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0449 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04b0  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int l(T r31, byte[] r32, int r33, int r34, int r35, defpackage.pt3 r36) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1460
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew3.l(java.lang.Object, byte[], int, int, int, pt3):int");
    }

    public final qw3 n(int i2) {
        int i3 = (i2 / 3) << 1;
        Object[] objArr = this.b;
        qw3 qw3 = (qw3) objArr[i3];
        if (qw3 != null) {
            return qw3;
        }
        qw3<T> a2 = nw3.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a2;
        return a2;
    }

    public final <K, V> void s(wx3 wx3, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            this.o.e(this.b[(i3 / 3) << 1]);
            Map<?, ?> c2 = this.o.c(obj);
            du3 du3 = (du3) wx3;
            Objects.requireNonNull(du3);
            Iterator<Map.Entry<?, ?>> it = c2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                du3.f889a.f(i2, 2);
                next.getKey();
                next.getValue();
                throw null;
            }
        }
    }

    public final void t(T t, T t2, int i2) {
        long j2 = (long) (this.f1035a[i2 + 1] & 1048575);
        if (u(t2, i2)) {
            Object r = kx3.r(t, j2);
            Object r2 = kx3.r(t2, j2);
            if (r != null && r2 != null) {
                kx3.f(t, j2, tu3.c(r, r2));
                A(t, i2);
            } else if (r2 != null) {
                kx3.f(t, j2, r2);
                A(t, i2);
            }
        }
    }

    public final boolean u(T t, int i2) {
        int[] iArr = this.f1035a;
        int i3 = iArr[i2 + 2];
        long j2 = (long) (i3 & 1048575);
        if (j2 == 1048575) {
            int i4 = iArr[i2 + 1];
            long j3 = (long) (i4 & 1048575);
            switch ((i4 & 267386880) >>> 20) {
                case 0:
                    return kx3.q(t, j3) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return kx3.n(t, j3) != 0.0f;
                case 2:
                    return kx3.i(t, j3) != 0;
                case 3:
                    return kx3.i(t, j3) != 0;
                case 4:
                    return kx3.b(t, j3) != 0;
                case 5:
                    return kx3.i(t, j3) != 0;
                case 6:
                    return kx3.b(t, j3) != 0;
                case 7:
                    return kx3.m(t, j3);
                case 8:
                    Object r = kx3.r(t, j3);
                    if (r instanceof String) {
                        return !((String) r).isEmpty();
                    }
                    if (r instanceof qt3) {
                        return !qt3.g.equals(r);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return kx3.r(t, j3) != null;
                case 10:
                    return !qt3.g.equals(kx3.r(t, j3));
                case 11:
                    return kx3.b(t, j3) != 0;
                case 12:
                    return kx3.b(t, j3) != 0;
                case 13:
                    return kx3.b(t, j3) != 0;
                case 14:
                    return kx3.i(t, j3) != 0;
                case 15:
                    return kx3.b(t, j3) != 0;
                case 16:
                    return kx3.i(t, j3) != 0;
                case 17:
                    return kx3.r(t, j3) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (kx3.b(t, j2) & (1 << (i3 >>> 20))) != 0;
        }
    }

    public final boolean v(T t, int i2, int i3) {
        return kx3.b(t, (long) (this.f1035a[i3 + 2] & 1048575)) == i2;
    }

    public final boolean w(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return u(t, i2);
        }
        return (i4 & i5) != 0;
    }

    public final int y(int i2, int i3) {
        int length = (this.f1035a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f1035a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    public final Object z(int i2) {
        return this.b[(i2 / 3) << 1];
    }

    @Override // defpackage.qw3
    public final T zza() {
        return (T) this.k.d(this.e);
    }
}
