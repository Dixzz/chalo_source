package defpackage;

import java.util.List;
import java.util.RandomAccess;

/* renamed from: hn6  reason: default package */
/* compiled from: Options.kt */
public final class hn6 extends v56<zm6> implements RandomAccess {
    public static final a h = new a(null);
    public final zm6[] f;
    public final int[] g;

    /* renamed from: hn6$a */
    /* compiled from: Options.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public final void a(long j, vm6 vm6, int i, List<? extends zm6> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            vm6 vm62;
            int i8 = i;
            if (i2 < i3) {
                for (int i9 = i2; i9 < i3; i9++) {
                    if (!(((zm6) list.get(i9)).g() >= i8)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                zm6 zm6 = (zm6) list.get(i2);
                zm6 zm62 = (zm6) list.get(i3 - 1);
                if (i8 == zm6.g()) {
                    int i10 = i2 + 1;
                    i4 = i10;
                    i5 = list2.get(i2).intValue();
                    zm6 = (zm6) list.get(i10);
                } else {
                    i4 = i2;
                    i5 = -1;
                }
                if (zm6.j(i8) != zm62.j(i8)) {
                    int i11 = 1;
                    for (int i12 = i4 + 1; i12 < i3; i12++) {
                        if (((zm6) list.get(i12 - 1)).j(i8) != ((zm6) list.get(i12)).j(i8)) {
                            i11++;
                        }
                    }
                    long b = b(vm6) + j + ((long) 2) + ((long) (i11 * 2));
                    vm6.J(i11);
                    vm6.J(i5);
                    for (int i13 = i4; i13 < i3; i13++) {
                        byte j2 = ((zm6) list.get(i13)).j(i8);
                        if (i13 == i4 || j2 != ((zm6) list.get(i13 - 1)).j(i8)) {
                            vm6.J(j2 & 255);
                        }
                    }
                    vm6 vm63 = new vm6();
                    while (i4 < i3) {
                        byte j3 = ((zm6) list.get(i4)).j(i8);
                        int i14 = i4 + 1;
                        int i15 = i14;
                        while (true) {
                            if (i15 >= i3) {
                                i6 = i3;
                                break;
                            } else if (j3 != ((zm6) list.get(i15)).j(i8)) {
                                i6 = i15;
                                break;
                            } else {
                                i15++;
                            }
                        }
                        if (i14 == i6 && i8 + 1 == ((zm6) list.get(i4)).g()) {
                            vm6.J(list2.get(i4).intValue());
                            i7 = i6;
                            vm62 = vm63;
                        } else {
                            vm6.J(((int) (b(vm63) + b)) * -1);
                            i7 = i6;
                            vm62 = vm63;
                            a(b, vm63, i8 + 1, list, i4, i6, list2);
                        }
                        vm63 = vm62;
                        i4 = i7;
                    }
                    vm6.t0(vm63);
                    return;
                }
                int min = Math.min(zm6.g(), zm62.g());
                int i16 = i8;
                int i17 = 0;
                while (i16 < min && zm6.j(i16) == zm62.j(i16)) {
                    i17++;
                    i16++;
                }
                long b2 = b(vm6) + j + ((long) 2) + ((long) i17) + 1;
                vm6.J(-i17);
                vm6.J(i5);
                int i18 = i8 + i17;
                while (i8 < i18) {
                    vm6.J(zm6.j(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i3) {
                    if (i18 == ((zm6) list.get(i4)).g()) {
                        vm6.J(list2.get(i4).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                vm6 vm64 = new vm6();
                vm6.J(((int) (b(vm64) + b2)) * -1);
                a(b2, vm64, i18, list, i4, i3, list2);
                vm6.t0(vm64);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final long b(vm6 vm6) {
            return vm6.g / ((long) 4);
        }
    }

    public hn6(zm6[] zm6Arr, int[] iArr, j86 j86) {
        this.f = zm6Arr;
        this.g = iArr;
    }

    @Override // defpackage.u56
    public int b() {
        return this.f.length;
    }

    @Override // j$.util.Collection, defpackage.u56, j$.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof zm6) {
            return super.contains((zm6) obj);
        }
        return false;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, defpackage.v56, j$.util.List
    public zm6 get(int i) {
        return this.f[i];
    }

    @Override // defpackage.v56, j$.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof zm6) {
            return super.indexOf((zm6) obj);
        }
        return -1;
    }

    @Override // defpackage.v56, j$.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof zm6) {
            return super.lastIndexOf((zm6) obj);
        }
        return -1;
    }
}
