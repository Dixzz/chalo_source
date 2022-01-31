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

/* renamed from: jj3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class jj3<T> implements sj3<T> {
    public static final int[] n = new int[0];
    public static final Unsafe o = mk3.g();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1936a;
    public final Object[] b;
    public final gj3 c;
    public final boolean d;
    public final boolean e;
    public final int[] f;
    public final int g;
    public final int h;
    public final kj3 i;
    public final pi3 j;
    public final gk3<?, ?> k;
    public final kh3<?> l;
    public final zi3 m;

    /* JADX WARN: Incorrect args count in method signature: ([I[Ljava/lang/Object;IILgj3;ZZ[IIILkj3;Lpi3;Lgk3<**>;Lkh3<*>;Lzi3;)V */
    public jj3(int[] iArr, Object[] objArr, int i2, int i3, gj3 gj3, boolean z, int[] iArr2, int i4, int i5, kj3 kj3, pi3 pi3, gk3 gk3, kh3 kh3, zi3 zi3) {
        this.f1936a = iArr;
        this.b = objArr;
        boolean z2 = gj3 instanceof uh3;
        this.e = z;
        this.d = kh3 != null && kh3.e(gj3);
        this.f = iArr2;
        this.g = i4;
        this.h = i5;
        this.i = kj3;
        this.j = pi3;
        this.k = gk3;
        this.l = kh3;
        this.c = gj3;
        this.m = zi3;
    }

    public static <T> double A(T t, long j2) {
        return ((Double) mk3.r(t, j2)).doubleValue();
    }

    public static <T> float B(T t, long j2) {
        return ((Float) mk3.r(t, j2)).floatValue();
    }

    public static <T> int C(T t, long j2) {
        return ((Integer) mk3.r(t, j2)).intValue();
    }

    public static <T> long D(T t, long j2) {
        return ((Long) mk3.r(t, j2)).longValue();
    }

    public static <T> boolean E(T t, long j2) {
        return ((Boolean) mk3.r(t, j2)).booleanValue();
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lej3;Lkj3;Lpi3;Lgk3<**>;Lkh3<*>;Lzi3;)Ljj3<TT;>; */
    public static jj3 a(ej3 ej3, kj3 kj3, pi3 pi3, gk3 gk3, kh3 kh3, zi3 zi3) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        int[] iArr2;
        int i12;
        int i13;
        tj3 tj3;
        String str;
        int i14;
        int i15;
        int i16;
        int i17;
        Field field;
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
        int i24;
        char charAt5;
        int i25;
        char charAt6;
        int i26;
        char charAt7;
        int i27;
        char charAt8;
        int i28;
        char charAt9;
        int i29;
        char charAt10;
        int i30;
        char charAt11;
        int i31;
        char charAt12;
        int i32;
        char charAt13;
        char charAt14;
        if (ej3 instanceof tj3) {
            tj3 tj32 = (tj3) ej3;
            int i33 = 0;
            boolean z2 = ((tj32.d & 1) == 1 ? (char) 1 : 2) == 2;
            String str2 = tj32.b;
            int length = str2.length();
            int charAt15 = str2.charAt(0);
            if (charAt15 >= 55296) {
                int i34 = charAt15 & 8191;
                int i35 = 1;
                int i36 = 13;
                while (true) {
                    i2 = i35 + 1;
                    charAt14 = str2.charAt(i35);
                    if (charAt14 < 55296) {
                        break;
                    }
                    i34 |= (charAt14 & 8191) << i36;
                    i36 += 13;
                    i35 = i2;
                }
                charAt15 = i34 | (charAt14 << i36);
            } else {
                i2 = 1;
            }
            int i37 = i2 + 1;
            int charAt16 = str2.charAt(i2);
            if (charAt16 >= 55296) {
                int i38 = charAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i32 = i37 + 1;
                    charAt13 = str2.charAt(i37);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i38 |= (charAt13 & 8191) << i39;
                    i39 += 13;
                    i37 = i32;
                }
                charAt16 = i38 | (charAt13 << i39);
                i37 = i32;
            }
            if (charAt16 == 0) {
                iArr = n;
                i8 = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                int i40 = i37 + 1;
                int charAt17 = str2.charAt(i37);
                if (charAt17 >= 55296) {
                    int i41 = charAt17 & 8191;
                    int i42 = 13;
                    while (true) {
                        i31 = i40 + 1;
                        charAt12 = str2.charAt(i40);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i41 |= (charAt12 & 8191) << i42;
                        i42 += 13;
                        i40 = i31;
                    }
                    charAt17 = i41 | (charAt12 << i42);
                    i40 = i31;
                }
                int i43 = i40 + 1;
                int charAt18 = str2.charAt(i40);
                if (charAt18 >= 55296) {
                    int i44 = charAt18 & 8191;
                    int i45 = 13;
                    while (true) {
                        i30 = i43 + 1;
                        charAt11 = str2.charAt(i43);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i44 |= (charAt11 & 8191) << i45;
                        i45 += 13;
                        i43 = i30;
                    }
                    charAt18 = i44 | (charAt11 << i45);
                    i43 = i30;
                }
                int i46 = i43 + 1;
                i6 = str2.charAt(i43);
                if (i6 >= 55296) {
                    int i47 = i6 & 8191;
                    int i48 = 13;
                    while (true) {
                        i29 = i46 + 1;
                        charAt10 = str2.charAt(i46);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i47 |= (charAt10 & 8191) << i48;
                        i48 += 13;
                        i46 = i29;
                    }
                    i6 = i47 | (charAt10 << i48);
                    i46 = i29;
                }
                int i49 = i46 + 1;
                int charAt19 = str2.charAt(i46);
                if (charAt19 >= 55296) {
                    int i50 = charAt19 & 8191;
                    int i51 = 13;
                    while (true) {
                        i28 = i49 + 1;
                        charAt9 = str2.charAt(i49);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i50 |= (charAt9 & 8191) << i51;
                        i51 += 13;
                        i49 = i28;
                    }
                    charAt19 = i50 | (charAt9 << i51);
                    i49 = i28;
                }
                int i52 = i49 + 1;
                i5 = str2.charAt(i49);
                if (i5 >= 55296) {
                    int i53 = i5 & 8191;
                    int i54 = 13;
                    while (true) {
                        i27 = i52 + 1;
                        charAt8 = str2.charAt(i52);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i53 |= (charAt8 & 8191) << i54;
                        i54 += 13;
                        i52 = i27;
                    }
                    i5 = i53 | (charAt8 << i54);
                    i52 = i27;
                }
                int i55 = i52 + 1;
                int charAt20 = str2.charAt(i52);
                if (charAt20 >= 55296) {
                    int i56 = charAt20 & 8191;
                    int i57 = 13;
                    while (true) {
                        i26 = i55 + 1;
                        charAt7 = str2.charAt(i55);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i56 |= (charAt7 & 8191) << i57;
                        i57 += 13;
                        i55 = i26;
                    }
                    charAt20 = i56 | (charAt7 << i57);
                    i55 = i26;
                }
                int i58 = i55 + 1;
                int charAt21 = str2.charAt(i55);
                if (charAt21 >= 55296) {
                    int i59 = charAt21 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i25 = i60 + 1;
                        charAt6 = str2.charAt(i60);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i59 |= (charAt6 & 8191) << i61;
                        i61 += 13;
                        i60 = i25;
                    }
                    charAt21 = i59 | (charAt6 << i61);
                    i23 = i25;
                } else {
                    i23 = i58;
                }
                int i62 = i23 + 1;
                int charAt22 = str2.charAt(i23);
                if (charAt22 >= 55296) {
                    int i63 = charAt22 & 8191;
                    int i64 = i62;
                    int i65 = 13;
                    while (true) {
                        i24 = i64 + 1;
                        charAt5 = str2.charAt(i64);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i63 |= (charAt5 & 8191) << i65;
                        i65 += 13;
                        i64 = i24;
                    }
                    charAt22 = i63 | (charAt5 << i65);
                    i62 = i24;
                }
                i3 = (charAt17 << 1) + charAt18;
                i7 = charAt19;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                i8 = charAt20;
                i4 = charAt22;
                i33 = charAt17;
                i37 = i62;
            }
            Unsafe unsafe = o;
            Object[] objArr = tj32.c;
            Class<?> cls = tj32.f3366a.getClass();
            int i66 = i3;
            int[] iArr3 = new int[(i5 * 3)];
            Object[] objArr2 = new Object[(i5 << 1)];
            int i67 = i4 + i8;
            int i68 = i4;
            int i69 = i37;
            int i70 = i67;
            int i71 = 0;
            int i72 = 0;
            while (i69 < length) {
                int i73 = i69 + 1;
                int charAt23 = str2.charAt(i69);
                if (charAt23 >= 55296) {
                    int i74 = charAt23 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i22 = i75 + 1;
                        charAt4 = str2.charAt(i75);
                        i9 = i4;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i74 |= (charAt4 & 8191) << i76;
                        i76 += 13;
                        i75 = i22;
                        i4 = i9;
                    }
                    charAt23 = i74 | (charAt4 << i76);
                    i10 = i22;
                } else {
                    i9 = i4;
                    i10 = i73;
                }
                int i77 = i10 + 1;
                int charAt24 = str2.charAt(i10);
                if (charAt24 >= 55296) {
                    int i78 = charAt24 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i21 = i79 + 1;
                        charAt3 = str2.charAt(i79);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i78 |= (charAt3 & 8191) << i80;
                        i80 += 13;
                        i79 = i21;
                        z2 = z;
                    }
                    charAt24 = i78 | (charAt3 << i80);
                    i11 = i21;
                } else {
                    z = z2;
                    i11 = i77;
                }
                int i81 = charAt24 & Constants.MAX_HOST_LENGTH;
                if ((charAt24 & 1024) != 0) {
                    iArr[i71] = i72;
                    i71++;
                }
                if (i81 >= 51) {
                    int i82 = i11 + 1;
                    int charAt25 = str2.charAt(i11);
                    char c2 = 55296;
                    if (charAt25 >= 55296) {
                        int i83 = 13;
                        int i84 = charAt25 & 8191;
                        int i85 = i82;
                        while (true) {
                            i20 = i85 + 1;
                            charAt2 = str2.charAt(i85);
                            if (charAt2 < c2) {
                                break;
                            }
                            i84 |= (charAt2 & 8191) << i83;
                            i83 += 13;
                            i85 = i20;
                            c2 = 55296;
                        }
                        charAt25 = i84 | (charAt2 << i83);
                        i19 = i20;
                    } else {
                        i19 = i82;
                    }
                    int i86 = i81 - 51;
                    i12 = i6;
                    if (i86 == 9 || i86 == 17) {
                        objArr2[((i72 / 3) << 1) + 1] = objArr[i66];
                        i66++;
                    } else if (i86 == 12 && (charAt15 & 1) == 1) {
                        objArr2[((i72 / 3) << 1) + 1] = objArr[i66];
                        i66++;
                    }
                    int i87 = charAt25 << 1;
                    Object obj = objArr[i87];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = d(cls, (String) obj);
                        objArr[i87] = field2;
                    }
                    iArr2 = iArr3;
                    i15 = (int) unsafe.objectFieldOffset(field2);
                    int i88 = i87 + 1;
                    Object obj2 = objArr[i88];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = d(cls, (String) obj2);
                        objArr[i88] = field3;
                    }
                    i16 = (int) unsafe.objectFieldOffset(field3);
                    str = str2;
                    i13 = i19;
                    i14 = 0;
                    tj3 = tj32;
                } else {
                    i12 = i6;
                    iArr2 = iArr3;
                    int i89 = i66 + 1;
                    Field d2 = d(cls, (String) objArr[i66]);
                    if (i81 == 9 || i81 == 17) {
                        tj3 = tj32;
                        objArr2[((i72 / 3) << 1) + 1] = d2.getType();
                    } else {
                        if (i81 == 27 || i81 == 49) {
                            tj3 = tj32;
                            i18 = i89 + 1;
                            objArr2[((i72 / 3) << 1) + 1] = objArr[i89];
                        } else if (i81 == 12 || i81 == 30 || i81 == 44) {
                            tj3 = tj32;
                            if ((charAt15 & 1) == 1) {
                                i18 = i89 + 1;
                                objArr2[((i72 / 3) << 1) + 1] = objArr[i89];
                            }
                        } else {
                            if (i81 == 50) {
                                int i90 = i68 + 1;
                                iArr[i68] = i72;
                                int i91 = (i72 / 3) << 1;
                                int i92 = i89 + 1;
                                objArr2[i91] = objArr[i89];
                                if ((charAt24 & 2048) != 0) {
                                    i89 = i92 + 1;
                                    objArr2[i91 + 1] = objArr[i92];
                                    tj3 = tj32;
                                    i68 = i90;
                                } else {
                                    i68 = i90;
                                    i89 = i92;
                                }
                            }
                            tj3 = tj32;
                        }
                        str = str2;
                        i89 = i18;
                        i15 = (int) unsafe.objectFieldOffset(d2);
                        if ((charAt15 & 1) == 1 || i81 > 17) {
                            i13 = i11;
                            i17 = 0;
                            i14 = 0;
                        } else {
                            int i93 = i11 + 1;
                            int charAt26 = str.charAt(i11);
                            if (charAt26 >= 55296) {
                                int i94 = charAt26 & 8191;
                                int i95 = 13;
                                while (true) {
                                    i13 = i93 + 1;
                                    charAt = str.charAt(i93);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i94 |= (charAt & 8191) << i95;
                                    i95 += 13;
                                    i93 = i13;
                                }
                                charAt26 = i94 | (charAt << i95);
                            } else {
                                i13 = i93;
                            }
                            int i96 = (charAt26 / 32) + (i33 << 1);
                            Object obj3 = objArr[i96];
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = d(cls, (String) obj3);
                                objArr[i96] = field;
                            }
                            str = str;
                            i17 = (int) unsafe.objectFieldOffset(field);
                            i14 = charAt26 % 32;
                        }
                        if (i81 >= 18 && i81 <= 49) {
                            iArr[i70] = i15;
                            i70++;
                        }
                        i66 = i89;
                        i16 = i17;
                    }
                    str = str2;
                    i15 = (int) unsafe.objectFieldOffset(d2);
                    if ((charAt15 & 1) == 1) {
                    }
                    i13 = i11;
                    i17 = 0;
                    i14 = 0;
                    iArr[i70] = i15;
                    i70++;
                    i66 = i89;
                    i16 = i17;
                }
                int i97 = i72 + 1;
                iArr2[i72] = charAt23;
                int i98 = i97 + 1;
                iArr2[i97] = ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (i81 << 20) | i15;
                i72 = i98 + 1;
                iArr2[i98] = (i14 << 20) | i16;
                str2 = str;
                i7 = i7;
                length = length;
                tj32 = tj3;
                i4 = i9;
                z2 = z;
                i69 = i13;
                i6 = i12;
                iArr3 = iArr2;
            }
            return new jj3(iArr3, objArr2, i6, i7, tj32.f3366a, z2, iArr, i4, i67, kj3, pi3, gk3, kh3, zi3);
        }
        ek3 ek3 = (ek3) ej3;
        throw new NoSuchMethodError();
    }

    public static Field d(Class<?> cls, String str) {
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

    public static void j(int i2, Object obj, al3 al3) throws IOException {
        if (obj instanceof String) {
            ((jh3) al3).f1925a.f(i2, (String) obj);
            return;
        }
        ((jh3) al3).f1925a.c(i2, (xg3) obj);
    }

    public static <UT, UB> void k(gk3<UT, UB> gk3, T t, al3 al3) throws IOException {
        gk3.a(gk3.g(t), al3);
    }

    public static List<?> z(Object obj, long j2) {
        return (List) mk3.r(obj, j2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (defpackage.uj3.s(defpackage.mk3.r(r10, r6), defpackage.mk3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (defpackage.mk3.n(r10, r6) == defpackage.mk3.n(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (defpackage.mk3.l(r10, r6) == defpackage.mk3.l(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (defpackage.mk3.n(r10, r6) == defpackage.mk3.n(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (defpackage.mk3.l(r10, r6) == defpackage.mk3.l(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (defpackage.mk3.l(r10, r6) == defpackage.mk3.l(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (defpackage.mk3.l(r10, r6) == defpackage.mk3.l(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (defpackage.uj3.s(defpackage.mk3.r(r10, r6), defpackage.mk3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (defpackage.uj3.s(defpackage.mk3.r(r10, r6), defpackage.mk3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (defpackage.uj3.s(defpackage.mk3.r(r10, r6), defpackage.mk3.r(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (defpackage.mk3.o(r10, r6) == defpackage.mk3.o(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (defpackage.mk3.l(r10, r6) == defpackage.mk3.l(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (defpackage.mk3.n(r10, r6) == defpackage.mk3.n(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (defpackage.mk3.l(r10, r6) == defpackage.mk3.l(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (defpackage.mk3.n(r10, r6) == defpackage.mk3.n(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (defpackage.mk3.n(r10, r6) == defpackage.mk3.n(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(defpackage.mk3.p(r10, r6)) == java.lang.Float.floatToIntBits(defpackage.mk3.p(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(defpackage.mk3.q(r10, r6)) == java.lang.Double.doubleToLongBits(defpackage.mk3.q(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (defpackage.uj3.s(defpackage.mk3.r(r10, r6), defpackage.mk3.r(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // defpackage.sj3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj3.b(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // defpackage.sj3
    public final int c(T t) {
        int i2;
        int i3;
        int length = this.f1936a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int s = s(i5);
            int i6 = this.f1936a[i5];
            long j2 = (long) (1048575 & s);
            int i7 = 37;
            switch ((s & 267386880) >>> 20) {
                case 0:
                    i3 = i4 * 53;
                    i2 = zh3.c(Double.doubleToLongBits(mk3.q(t, j2)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    i2 = Float.floatToIntBits(mk3.p(t, j2));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i3 = i4 * 53;
                    i2 = zh3.c(mk3.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i3 = i4 * 53;
                    i2 = zh3.c(mk3.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i3 = i4 * 53;
                    i2 = mk3.l(t, j2);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i3 = i4 * 53;
                    i2 = zh3.c(mk3.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i3 = i4 * 53;
                    i2 = mk3.l(t, j2);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    i2 = zh3.b(mk3.o(t, j2));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) mk3.r(t, j2)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object r = mk3.r(t, j2);
                    if (r != null) {
                        i7 = r.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i3 = i4 * 53;
                    i2 = mk3.r(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i3 = i4 * 53;
                    i2 = mk3.l(t, j2);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i3 = i4 * 53;
                    i2 = mk3.l(t, j2);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i3 = i4 * 53;
                    i2 = mk3.l(t, j2);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i3 = i4 * 53;
                    i2 = zh3.c(mk3.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i3 = i4 * 53;
                    i2 = mk3.l(t, j2);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i3 = i4 * 53;
                    i2 = zh3.c(mk3.n(t, j2));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object r2 = mk3.r(t, j2);
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
                    i2 = mk3.r(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i3 = i4 * 53;
                    i2 = mk3.r(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.c(Double.doubleToLongBits(A(t, j2)));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = Float.floatToIntBits(B(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.c(D(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.c(D(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = C(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.c(D(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = C(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.b(E(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = ((String) mk3.r(t, j2)).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mk3.r(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mk3.r(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = C(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = C(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = C(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.c(D(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = C(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = zh3.c(D(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (o(t, i6, i5)) {
                        i3 = i4 * 53;
                        i2 = mk3.r(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.k.g(t).hashCode() + (i4 * 53);
        return this.d ? (hashCode * 53) + this.l.c(t).hashCode() : hashCode;
    }

    @Override // defpackage.sj3
    public final void e(T t) {
        int i2;
        int i3 = this.g;
        while (true) {
            i2 = this.h;
            if (i3 >= i2) {
                break;
            }
            long s = (long) (s(this.f[i3]) & 1048575);
            Object r = mk3.r(t, s);
            if (r != null) {
                mk3.d(t, s, this.m.d(r));
            }
            i3++;
        }
        int length = this.f.length;
        while (i2 < length) {
            this.j.a(t, (long) this.f[i2]);
            i2++;
        }
        this.k.e(t);
        if (this.d) {
            this.l.f(t);
        }
    }

    @Override // defpackage.sj3
    public final void f(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i2 = 0; i2 < this.f1936a.length; i2 += 3) {
            int s = s(i2);
            long j2 = (long) (1048575 & s);
            int i3 = this.f1936a[i2];
            switch ((s & 267386880) >>> 20) {
                case 0:
                    if (n(t2, i2)) {
                        mk3.f.a(t, j2, mk3.q(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (n(t2, i2)) {
                        mk3.f.b(t, j2, mk3.p(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (n(t2, i2)) {
                        mk3.c(t, j2, mk3.n(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (n(t2, i2)) {
                        mk3.c(t, j2, mk3.n(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (n(t2, i2)) {
                        mk3.f.c(t, j2, mk3.l(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (n(t2, i2)) {
                        mk3.c(t, j2, mk3.n(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (n(t2, i2)) {
                        mk3.f.c(t, j2, mk3.l(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (n(t2, i2)) {
                        mk3.f.e(t, j2, mk3.o(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (n(t2, i2)) {
                        mk3.d(t, j2, mk3.r(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    m(t, t2, i2);
                    break;
                case 10:
                    if (n(t2, i2)) {
                        mk3.d(t, j2, mk3.r(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (n(t2, i2)) {
                        mk3.f.c(t, j2, mk3.l(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (n(t2, i2)) {
                        mk3.f.c(t, j2, mk3.l(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (n(t2, i2)) {
                        mk3.f.c(t, j2, mk3.l(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (n(t2, i2)) {
                        mk3.c(t, j2, mk3.n(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (n(t2, i2)) {
                        mk3.f.c(t, j2, mk3.l(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (n(t2, i2)) {
                        mk3.c(t, j2, mk3.n(t2, j2));
                        u(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    m(t, t2, i2);
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
                    this.j.b(t, t2, j2);
                    break;
                case 50:
                    zi3 zi3 = this.m;
                    Class<?> cls = uj3.f3513a;
                    mk3.d(t, j2, zi3.b(mk3.r(t, j2), mk3.r(t2, j2)));
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
                    if (o(t2, i3, i2)) {
                        mk3.d(t, j2, mk3.r(t2, j2));
                        v(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    x(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (o(t2, i3, i2)) {
                        mk3.d(t, j2, mk3.r(t2, j2));
                        v(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    x(t, t2, i2);
                    break;
            }
        }
        gk3<?, ?> gk3 = this.k;
        Class<?> cls2 = uj3.f3513a;
        gk3.c(t, gk3.d(gk3.g(t), gk3.g(t2)));
        if (this.d) {
            uj3.e(this.l, t, t2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: sj3 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: sj3 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: sj3 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.sj3
    public final boolean g(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= this.g) {
                return !this.d || this.l.c(t).a();
            }
            int i6 = this.f[i4];
            int i7 = this.f1936a[i6];
            int s = s(i6);
            if (!this.e) {
                int i8 = this.f1936a[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = o.getInt(t, (long) i9);
                    i3 = i9;
                }
            } else {
                i2 = 0;
            }
            if (((268435456 & s) != 0) && !p(t, i6, i5, i2)) {
                return false;
            }
            int i10 = (267386880 & s) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (o(t, i7, i6) && !q(i6).g(mk3.r(t, (long) (s & 1048575)))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 == 50 && !this.m.f(mk3.r(t, (long) (s & 1048575))).isEmpty()) {
                            this.m.c(r(i6));
                            throw null;
                        }
                    }
                }
                List list = (List) mk3.r(t, (long) (s & 1048575));
                if (!list.isEmpty()) {
                    sj3 q = q(i6);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        } else if (!q.g(list.get(i11))) {
                            z = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (p(t, i6, i5, i2) && !q(i6).g(mk3.r(t, (long) (s & 1048575)))) {
                return false;
            }
            i4++;
        }
    }

    @Override // defpackage.sj3
    public final int h(T t) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 267386880;
        if (this.e) {
            Unsafe unsafe = o;
            int i12 = 0;
            for (int i13 = 0; i13 < this.f1936a.length; i13 += 3) {
                int s = s(i13);
                int i14 = (s & 267386880) >>> 20;
                int i15 = this.f1936a[i13];
                long j2 = (long) (s & 1048575);
                if (i14 >= qh3.DOUBLE_LIST_PACKED.id() && i14 <= qh3.SINT64_LIST_PACKED.id()) {
                    int i16 = this.f1936a[i13 + 2];
                }
                switch (i14) {
                    case 0:
                        if (n(t, i13)) {
                            i7 = hh3.o(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (n(t, i13)) {
                            i7 = hh3.i(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (n(t, i13)) {
                            i7 = hh3.v(i15, mk3.n(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (n(t, i13)) {
                            i7 = hh3.y(i15, mk3.n(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (n(t, i13)) {
                            i7 = hh3.D(i15, mk3.l(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (n(t, i13)) {
                            i7 = hh3.C(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (n(t, i13)) {
                            i7 = hh3.I(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (n(t, i13)) {
                            i7 = hh3.p(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (n(t, i13)) {
                            Object r = mk3.r(t, j2);
                            if (r instanceof xg3) {
                                i7 = hh3.q(i15, (xg3) r);
                            } else {
                                i7 = hh3.j(i15, (String) r);
                            }
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (n(t, i13)) {
                            i7 = uj3.j(i15, mk3.r(t, j2), q(i13));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (n(t, i13)) {
                            i7 = hh3.q(i15, (xg3) mk3.r(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (n(t, i13)) {
                            i7 = hh3.G(i15, mk3.l(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (n(t, i13)) {
                            i7 = hh3.L(i15, mk3.l(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (n(t, i13)) {
                            i7 = hh3.K(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (n(t, i13)) {
                            i7 = hh3.F(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (n(t, i13)) {
                            i7 = hh3.H(i15, mk3.l(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (n(t, i13)) {
                            i7 = hh3.z(i15, mk3.n(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (n(t, i13)) {
                            i7 = hh3.r(i15, (gj3) mk3.r(t, j2), q(i13));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i7 = uj3.R(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 19:
                        i7 = uj3.Q(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 20:
                        i7 = uj3.J(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 21:
                        i7 = uj3.K(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 22:
                        i7 = uj3.N(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 23:
                        i7 = uj3.R(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 24:
                        i7 = uj3.Q(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 25:
                        List<?> z = z(t, j2);
                        Class<?> cls = uj3.f3513a;
                        int size = z.size();
                        if (size == 0) {
                            i7 = 0;
                        } else {
                            i7 = size * hh3.p(i15);
                        }
                        i12 += i7;
                        break;
                    case 26:
                        i7 = uj3.k(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 27:
                        i7 = uj3.l(i15, z(t, j2), q(i13));
                        i12 += i7;
                        break;
                    case 28:
                        i7 = uj3.o(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 29:
                        i7 = uj3.O(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 30:
                        i7 = uj3.M(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 31:
                        i7 = uj3.Q(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 32:
                        i7 = uj3.R(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 33:
                        i7 = uj3.P(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 34:
                        i7 = uj3.L(i15, z(t, j2));
                        i12 += i7;
                        break;
                    case 35:
                        i10 = uj3.C((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        i10 = uj3.z((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        i10 = uj3.a((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        i10 = uj3.f((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        i10 = uj3.t((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        i10 = uj3.C((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        i10 = uj3.z((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        Class<?> cls2 = uj3.f3513a;
                        i10 = ((List) unsafe.getObject(t, j2)).size();
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        i10 = uj3.v((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        i10 = uj3.q((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        i10 = uj3.z((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        i10 = uj3.C((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        i10 = uj3.x((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        i10 = uj3.m((List) unsafe.getObject(t, j2));
                        if (i10 > 0) {
                            i9 = hh3.Q(i15);
                            i8 = hh3.S(i10);
                            i12 = i8 + i9 + i10 + i12;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i7 = uj3.p(i15, z(t, j2), q(i13));
                        i12 += i7;
                        break;
                    case 50:
                        i7 = this.m.e(i15, mk3.r(t, j2), r(i13));
                        i12 += i7;
                        break;
                    case 51:
                        if (o(t, i15, i13)) {
                            i7 = hh3.o(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (o(t, i15, i13)) {
                            i7 = hh3.i(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (o(t, i15, i13)) {
                            i7 = hh3.v(i15, D(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (o(t, i15, i13)) {
                            i7 = hh3.y(i15, D(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (o(t, i15, i13)) {
                            i7 = hh3.D(i15, C(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (o(t, i15, i13)) {
                            i7 = hh3.C(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (o(t, i15, i13)) {
                            i7 = hh3.I(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (o(t, i15, i13)) {
                            i7 = hh3.p(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (o(t, i15, i13)) {
                            Object r2 = mk3.r(t, j2);
                            if (r2 instanceof xg3) {
                                i7 = hh3.q(i15, (xg3) r2);
                            } else {
                                i7 = hh3.j(i15, (String) r2);
                            }
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (o(t, i15, i13)) {
                            i7 = uj3.j(i15, mk3.r(t, j2), q(i13));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (o(t, i15, i13)) {
                            i7 = hh3.q(i15, (xg3) mk3.r(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (o(t, i15, i13)) {
                            i7 = hh3.G(i15, C(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (o(t, i15, i13)) {
                            i7 = hh3.L(i15, C(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (o(t, i15, i13)) {
                            i7 = hh3.K(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (o(t, i15, i13)) {
                            i7 = hh3.F(i15);
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (o(t, i15, i13)) {
                            i7 = hh3.H(i15, C(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (o(t, i15, i13)) {
                            i7 = hh3.z(i15, D(t, j2));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (o(t, i15, i13)) {
                            i7 = hh3.r(i15, (gj3) mk3.r(t, j2), q(i13));
                            i12 += i7;
                            break;
                        } else {
                            break;
                        }
                }
            }
            gk3<?, ?> gk3 = this.k;
            return gk3.f(gk3.g(t)) + i12;
        }
        Unsafe unsafe2 = o;
        int i17 = -1;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i18 < this.f1936a.length) {
            int s2 = s(i18);
            int[] iArr = this.f1936a;
            int i21 = iArr[i18];
            int i22 = (i11 & s2) >>> 20;
            if (i22 <= 17) {
                int i23 = iArr[i18 + 2];
                int i24 = i23 & 1048575;
                i2 = 1 << (i23 >>> 20);
                if (i24 != i17) {
                    i20 = unsafe2.getInt(t, (long) i24);
                    i17 = i24;
                }
            } else {
                i2 = 0;
            }
            long j3 = (long) (s2 & 1048575);
            switch (i22) {
                case 0:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.o(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.i(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.v(i21, unsafe2.getLong(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.y(i21, unsafe2.getLong(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.D(i21, unsafe2.getInt(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.C(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.I(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.p(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i20 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof xg3) {
                            i3 = hh3.q(i21, (xg3) object);
                        } else {
                            i3 = hh3.j(i21, (String) object);
                        }
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i20 & i2) != 0) {
                        i3 = uj3.j(i21, unsafe2.getObject(t, j3), q(i18));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.q(i21, (xg3) unsafe2.getObject(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.G(i21, unsafe2.getInt(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.L(i21, unsafe2.getInt(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.K(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.F(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.H(i21, unsafe2.getInt(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.z(i21, unsafe2.getLong(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i20 & i2) != 0) {
                        i3 = hh3.r(i21, (gj3) unsafe2.getObject(t, j3), q(i18));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i3 = uj3.R(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 19:
                    i3 = uj3.Q(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 20:
                    i3 = uj3.J(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 21:
                    i3 = uj3.K(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 22:
                    i3 = uj3.N(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 23:
                    i3 = uj3.R(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 24:
                    i3 = uj3.Q(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 25:
                    Class<?> cls3 = uj3.f3513a;
                    int size2 = ((List) unsafe2.getObject(t, j3)).size();
                    if (size2 == 0) {
                        i3 = 0;
                    } else {
                        i3 = size2 * hh3.p(i21);
                    }
                    i19 += i3;
                    break;
                case 26:
                    i3 = uj3.k(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 27:
                    i3 = uj3.l(i21, (List) unsafe2.getObject(t, j3), q(i18));
                    i19 += i3;
                    break;
                case 28:
                    i3 = uj3.o(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 29:
                    i3 = uj3.O(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 30:
                    i3 = uj3.M(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 31:
                    i3 = uj3.Q(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 32:
                    i3 = uj3.R(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 33:
                    i3 = uj3.P(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 34:
                    i3 = uj3.L(i21, (List) unsafe2.getObject(t, j3));
                    i19 += i3;
                    break;
                case 35:
                    i6 = uj3.C((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i6 = uj3.z((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i6 = uj3.a((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i6 = uj3.f((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i6 = uj3.t((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i6 = uj3.C((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i6 = uj3.z((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    Class<?> cls4 = uj3.f3513a;
                    i6 = ((List) unsafe2.getObject(t, j3)).size();
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i6 = uj3.v((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i6 = uj3.q((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i6 = uj3.z((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i6 = uj3.C((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i6 = uj3.x((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i6 = uj3.m((List) unsafe2.getObject(t, j3));
                    if (i6 > 0) {
                        i5 = hh3.Q(i21);
                        i4 = hh3.S(i6);
                        i19 = i4 + i5 + i6 + i19;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i3 = uj3.p(i21, (List) unsafe2.getObject(t, j3), q(i18));
                    i19 += i3;
                    break;
                case 50:
                    i3 = this.m.e(i21, unsafe2.getObject(t, j3), r(i18));
                    i19 += i3;
                    break;
                case 51:
                    if (o(t, i21, i18)) {
                        i3 = hh3.o(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (o(t, i21, i18)) {
                        i3 = hh3.i(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (o(t, i21, i18)) {
                        i3 = hh3.v(i21, D(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (o(t, i21, i18)) {
                        i3 = hh3.y(i21, D(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (o(t, i21, i18)) {
                        i3 = hh3.D(i21, C(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (o(t, i21, i18)) {
                        i3 = hh3.C(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (o(t, i21, i18)) {
                        i3 = hh3.I(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (o(t, i21, i18)) {
                        i3 = hh3.p(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (o(t, i21, i18)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof xg3) {
                            i3 = hh3.q(i21, (xg3) object2);
                        } else {
                            i3 = hh3.j(i21, (String) object2);
                        }
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (o(t, i21, i18)) {
                        i3 = uj3.j(i21, unsafe2.getObject(t, j3), q(i18));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (o(t, i21, i18)) {
                        i3 = hh3.q(i21, (xg3) unsafe2.getObject(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (o(t, i21, i18)) {
                        i3 = hh3.G(i21, C(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (o(t, i21, i18)) {
                        i3 = hh3.L(i21, C(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (o(t, i21, i18)) {
                        i3 = hh3.K(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (o(t, i21, i18)) {
                        i3 = hh3.F(i21);
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (o(t, i21, i18)) {
                        i3 = hh3.H(i21, C(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (o(t, i21, i18)) {
                        i3 = hh3.z(i21, D(t, j3));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (o(t, i21, i18)) {
                        i3 = hh3.r(i21, (gj3) unsafe2.getObject(t, j3), q(i18));
                        i19 += i3;
                        break;
                    } else {
                        break;
                    }
            }
            i18 += 3;
            i11 = 267386880;
        }
        gk3<?, ?> gk32 = this.k;
        int f2 = gk32.f(gk32.g(t)) + i19;
        if (!this.d) {
            return f2;
        }
        ph3<?> c2 = this.l.c(t);
        int i25 = 0;
        for (int i26 = 0; i26 < c2.f2805a.f(); i26++) {
            Map.Entry<T, Object> d2 = c2.f2805a.d(i26);
            i25 += ph3.h(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : c2.f2805a.g()) {
            i25 += ph3.h(entry.getKey(), entry.getValue());
        }
        return f2 + i25;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x059e  */
    @Override // defpackage.sj3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(T r13, defpackage.al3 r14) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1610
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj3.i(java.lang.Object, al3):void");
    }

    public final <K, V> void l(al3 al3, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            this.m.c(this.b[(i3 / 3) << 1]);
            Map<?, ?> f2 = this.m.f(obj);
            jh3 jh3 = (jh3) al3;
            Objects.requireNonNull(jh3);
            Iterator<Map.Entry<?, ?>> it = f2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                jh3.f1925a.l(i2, 2);
                next.getKey();
                next.getValue();
                throw null;
            }
        }
    }

    public final void m(T t, T t2, int i2) {
        long j2 = (long) (this.f1936a[i2 + 1] & 1048575);
        if (n(t2, i2)) {
            Object r = mk3.r(t, j2);
            Object r2 = mk3.r(t2, j2);
            if (r != null && r2 != null) {
                mk3.d(t, j2, zh3.a(r, r2));
                u(t, i2);
            } else if (r2 != null) {
                mk3.d(t, j2, r2);
                u(t, i2);
            }
        }
    }

    public final boolean n(T t, int i2) {
        if (this.e) {
            int i3 = this.f1936a[i2 + 1];
            long j2 = (long) (i3 & 1048575);
            switch ((i3 & 267386880) >>> 20) {
                case 0:
                    return mk3.q(t, j2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return mk3.p(t, j2) != 0.0f;
                case 2:
                    return mk3.n(t, j2) != 0;
                case 3:
                    return mk3.n(t, j2) != 0;
                case 4:
                    return mk3.l(t, j2) != 0;
                case 5:
                    return mk3.n(t, j2) != 0;
                case 6:
                    return mk3.l(t, j2) != 0;
                case 7:
                    return mk3.o(t, j2);
                case 8:
                    Object r = mk3.r(t, j2);
                    if (r instanceof String) {
                        return !((String) r).isEmpty();
                    }
                    if (r instanceof xg3) {
                        return !xg3.g.equals(r);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return mk3.r(t, j2) != null;
                case 10:
                    return !xg3.g.equals(mk3.r(t, j2));
                case 11:
                    return mk3.l(t, j2) != 0;
                case 12:
                    return mk3.l(t, j2) != 0;
                case 13:
                    return mk3.l(t, j2) != 0;
                case 14:
                    return mk3.n(t, j2) != 0;
                case 15:
                    return mk3.l(t, j2) != 0;
                case 16:
                    return mk3.n(t, j2) != 0;
                case 17:
                    return mk3.r(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f1936a[i2 + 2];
            return (mk3.l(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0;
        }
    }

    public final boolean o(T t, int i2, int i3) {
        return mk3.l(t, (long) (this.f1936a[i3 + 2] & 1048575)) == i2;
    }

    public final boolean p(T t, int i2, int i3, int i4) {
        if (this.e) {
            return n(t, i2);
        }
        return (i3 & i4) != 0;
    }

    public final sj3 q(int i2) {
        int i3 = (i2 / 3) << 1;
        Object[] objArr = this.b;
        sj3 sj3 = (sj3) objArr[i3];
        if (sj3 != null) {
            return sj3;
        }
        sj3<T> a2 = rj3.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a2;
        return a2;
    }

    public final Object r(int i2) {
        return this.b[(i2 / 3) << 1];
    }

    public final int s(int i2) {
        return this.f1936a[i2 + 1];
    }

    public final int t(int i2) {
        return this.f1936a[i2 + 2];
    }

    public final void u(T t, int i2) {
        if (!this.e) {
            int i3 = this.f1936a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            mk3.f.c(t, j2, mk3.l(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void v(T t, int i2, int i3) {
        mk3.f.c(t, (long) (this.f1936a[i3 + 2] & 1048575), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(T r19, defpackage.al3 r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1494
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jj3.w(java.lang.Object, al3):void");
    }

    public final void x(T t, T t2, int i2) {
        int[] iArr = this.f1936a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (o(t2, i4, i2)) {
            Object r = mk3.r(t, j2);
            Object r2 = mk3.r(t2, j2);
            if (r != null && r2 != null) {
                mk3.d(t, j2, zh3.a(r, r2));
                v(t, i4, i2);
            } else if (r2 != null) {
                mk3.d(t, j2, r2);
                v(t, i4, i2);
            }
        }
    }

    public final boolean y(T t, T t2, int i2) {
        return n(t, i2) == n(t2, i2);
    }
}
