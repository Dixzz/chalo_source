package defpackage;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: jk  reason: default package */
/* compiled from: DiffUtil */
public class jk {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<c> f1939a = new a();

    /* renamed from: jk$a */
    /* compiled from: DiffUtil */
    public class a implements Comparator<c>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.f1940a - cVar2.f1940a;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<c> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<c> thenComparing(java.util.Comparator<? super c> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: jk$b */
    /* compiled from: DiffUtil */
    public static abstract class b {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* renamed from: jk$c */
    /* compiled from: DiffUtil */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f1940a;
        public final int b;
        public final int c;

        public c(int i, int i2, int i3) {
            this.f1940a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* renamed from: jk$d */
    /* compiled from: DiffUtil */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final List<c> f1941a;
        public final int[] b;
        public final int[] c;
        public final b d;
        public final int e;
        public final int f;
        public final boolean g;

        public d(b bVar, List<c> list, int[] iArr, int[] iArr2, boolean z) {
            int i;
            c cVar;
            int i2;
            this.f1941a = list;
            this.b = iArr;
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = bVar;
            int oldListSize = bVar.getOldListSize();
            this.e = oldListSize;
            int newListSize = bVar.getNewListSize();
            this.f = newListSize;
            this.g = z;
            c cVar2 = list.isEmpty() ? null : list.get(0);
            if (!(cVar2 != null && cVar2.f1940a == 0 && cVar2.b == 0)) {
                list.add(0, new c(0, 0, 0));
            }
            list.add(new c(oldListSize, newListSize, 0));
            for (c cVar3 : list) {
                for (int i3 = 0; i3 < cVar3.c; i3++) {
                    int i4 = cVar3.f1940a + i3;
                    int i5 = cVar3.b + i3;
                    int i6 = this.d.areContentsTheSame(i4, i5) ? 1 : 2;
                    this.b[i4] = (i5 << 4) | i6;
                    this.c[i5] = (i4 << 4) | i6;
                }
            }
            if (this.g) {
                int i7 = 0;
                for (c cVar4 : this.f1941a) {
                    while (true) {
                        i = cVar4.f1940a;
                        if (i7 >= i) {
                            break;
                        }
                        if (this.b[i7] == 0) {
                            int size = this.f1941a.size();
                            int i8 = 0;
                            int i9 = 0;
                            while (true) {
                                if (i8 >= size) {
                                    break;
                                }
                                cVar = this.f1941a.get(i8);
                                while (true) {
                                    i2 = cVar.b;
                                    if (i9 >= i2) {
                                        break;
                                    } else if (this.c[i9] != 0 || !this.d.areItemsTheSame(i7, i9)) {
                                        i9++;
                                    } else {
                                        int i10 = this.d.areContentsTheSame(i7, i9) ? 8 : 4;
                                        this.b[i7] = (i9 << 4) | i10;
                                        this.c[i9] = i10 | (i7 << 4);
                                    }
                                }
                                i9 = cVar.c + i2;
                                i8++;
                            }
                        }
                        i7++;
                    }
                    i7 = cVar4.c + i;
                }
            }
        }

        public static f b(Collection<f> collection, int i, boolean z) {
            f fVar;
            Iterator<f> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = it.next();
                if (fVar.f1942a == i && fVar.c == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                f next = it.next();
                if (z) {
                    next.b--;
                } else {
                    next.b++;
                }
            }
            return fVar;
        }

        public void a(pk pkVar) {
            wj wjVar;
            int i;
            if (pkVar instanceof wj) {
                wjVar = (wj) pkVar;
            } else {
                wjVar = new wj(pkVar);
            }
            int i2 = this.e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.e;
            int i4 = this.f;
            for (int size = this.f1941a.size() - 1; size >= 0; size--) {
                c cVar = this.f1941a.get(size);
                int i5 = cVar.f1940a;
                int i6 = cVar.c;
                int i7 = i5 + i6;
                int i8 = cVar.b + i6;
                while (true) {
                    if (i3 <= i7) {
                        break;
                    }
                    i3--;
                    int i9 = this.b[i3];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        f b2 = b(arrayDeque, i10, false);
                        if (b2 != null) {
                            int i11 = (i2 - b2.b) - 1;
                            wjVar.onMoved(i3, i11);
                            if ((i9 & 4) != 0) {
                                wjVar.onChanged(i11, 1, this.d.getChangePayload(i3, i10));
                            }
                        } else {
                            arrayDeque.add(new f(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        wjVar.onRemoved(i3, 1);
                        i2--;
                    }
                }
                while (i4 > i8) {
                    i4--;
                    int i12 = this.c[i4];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        f b3 = b(arrayDeque, i13, true);
                        if (b3 == null) {
                            arrayDeque.add(new f(i4, i2 - i3, false));
                        } else {
                            wjVar.onMoved((i2 - b3.b) - 1, i3);
                            if ((i12 & 4) != 0) {
                                wjVar.onChanged(i3, 1, this.d.getChangePayload(i13, i4));
                            }
                        }
                    } else {
                        wjVar.onInserted(i3, 1);
                        i2++;
                    }
                }
                int i14 = cVar.f1940a;
                int i15 = cVar.b;
                for (i = 0; i < cVar.c; i++) {
                    if ((this.b[i14] & 15) == 2) {
                        wjVar.onChanged(i14, 1, this.d.getChangePayload(i14, i15));
                    }
                    i14++;
                    i15++;
                }
                i3 = cVar.f1940a;
                i4 = cVar.b;
            }
            wjVar.a();
        }
    }

    /* renamed from: jk$e */
    /* compiled from: DiffUtil */
    public static abstract class e<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);
    }

    /* renamed from: jk$f */
    /* compiled from: DiffUtil */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f1942a;
        public int b;
        public boolean c;

        public f(int i, int i2, boolean z) {
            this.f1942a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* renamed from: jk$g */
    /* compiled from: DiffUtil */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public int f1943a;
        public int b;
        public int c;
        public int d;

        public g() {
        }

        public int a() {
            return this.d - this.c;
        }

        public int b() {
            return this.b - this.f1943a;
        }

        public g(int i, int i2, int i3, int i4) {
            this.f1943a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    /* renamed from: jk$h */
    /* compiled from: DiffUtil */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public int f1944a;
        public int b;
        public int c;
        public int d;
        public boolean e;

        public int a() {
            return Math.min(this.c - this.f1944a, this.d - this.b);
        }
    }

    public static d a(b bVar) {
        g gVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        h hVar;
        ArrayList arrayList3;
        ArrayList arrayList4;
        g gVar2;
        g gVar3;
        c cVar;
        int i;
        h hVar2;
        h hVar3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int oldListSize = bVar.getOldListSize();
        int newListSize = bVar.getNewListSize();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new g(0, oldListSize, 0, newListSize));
        int i8 = oldListSize + newListSize;
        int i9 = 1;
        int i10 = (((i8 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i10];
        int i11 = i10 / 2;
        int[] iArr2 = new int[i10];
        ArrayList arrayList7 = new ArrayList();
        while (!arrayList6.isEmpty()) {
            g gVar4 = (g) arrayList6.remove(arrayList6.size() - i9);
            if (gVar4.b() >= i9 && gVar4.a() >= i9) {
                int a2 = ((gVar4.a() + gVar4.b()) + i9) / 2;
                int i12 = i9 + i11;
                iArr[i12] = gVar4.f1943a;
                iArr2[i12] = gVar4.b;
                int i13 = 0;
                while (true) {
                    if (i13 >= a2) {
                        break;
                    }
                    boolean z2 = Math.abs(gVar4.b() - gVar4.a()) % 2 == i9;
                    int b2 = gVar4.b() - gVar4.a();
                    int i14 = -i13;
                    int i15 = i14;
                    while (true) {
                        if (i15 > i13) {
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            i = a2;
                            hVar2 = null;
                            break;
                        }
                        if (i15 == i14 || (i15 != i13 && iArr[i15 + 1 + i11] > iArr[(i15 - 1) + i11])) {
                            i6 = iArr[i15 + 1 + i11];
                            i5 = i6;
                        } else {
                            i6 = iArr[(i15 - 1) + i11];
                            i5 = i6 + 1;
                        }
                        i = a2;
                        arrayList2 = arrayList6;
                        int i16 = ((i5 - gVar4.f1943a) + gVar4.c) - i15;
                        if (i13 == 0 || i5 != i6) {
                            arrayList = arrayList7;
                            i7 = i16;
                        } else {
                            i7 = i16 - 1;
                            arrayList = arrayList7;
                        }
                        while (i5 < gVar4.b && i16 < gVar4.d && bVar.areItemsTheSame(i5, i16)) {
                            i5++;
                            i16++;
                        }
                        iArr[i15 + i11] = i5;
                        if (z2) {
                            int i17 = b2 - i15;
                            z = z2;
                            if (i17 >= i14 + 1 && i17 <= i13 - 1 && iArr2[i17 + i11] <= i5) {
                                hVar2 = new h();
                                hVar2.f1944a = i6;
                                hVar2.b = i7;
                                hVar2.c = i5;
                                hVar2.d = i16;
                                hVar2.e = false;
                                break;
                            }
                        } else {
                            z = z2;
                        }
                        i15 += 2;
                        a2 = i;
                        arrayList6 = arrayList2;
                        arrayList7 = arrayList;
                        z2 = z;
                    }
                    if (hVar2 != null) {
                        hVar = hVar2;
                        gVar = gVar4;
                        break;
                    }
                    boolean z3 = (gVar4.b() - gVar4.a()) % 2 == 0;
                    int b3 = gVar4.b() - gVar4.a();
                    int i18 = i14;
                    while (true) {
                        if (i18 > i13) {
                            gVar = gVar4;
                            hVar3 = null;
                            break;
                        }
                        if (i18 == i14 || (i18 != i13 && iArr2[i18 + 1 + i11] < iArr2[(i18 - 1) + i11])) {
                            i3 = iArr2[i18 + 1 + i11];
                            i2 = i3;
                        } else {
                            i3 = iArr2[(i18 - 1) + i11];
                            i2 = i3 - 1;
                        }
                        int i19 = gVar4.d - ((gVar4.b - i2) - i18);
                        int i20 = (i13 == 0 || i2 != i3) ? i19 : i19 + 1;
                        while (true) {
                            if (i2 > gVar4.f1943a && i19 > gVar4.c) {
                                int i21 = i2 - 1;
                                gVar = gVar4;
                                int i22 = i19 - 1;
                                if (!bVar.areItemsTheSame(i21, i22)) {
                                    break;
                                }
                                i2 = i21;
                                i19 = i22;
                                gVar4 = gVar;
                            } else {
                                gVar = gVar4;
                            }
                        }
                        gVar = gVar4;
                        iArr2[i18 + i11] = i2;
                        if (z3 && (i4 = b3 - i18) >= i14 && i4 <= i13 && iArr[i4 + i11] >= i2) {
                            hVar3 = new h();
                            hVar3.f1944a = i2;
                            hVar3.b = i19;
                            hVar3.c = i3;
                            hVar3.d = i20;
                            hVar3.e = true;
                            break;
                        }
                        i18 += 2;
                        gVar4 = gVar;
                    }
                    if (hVar3 != null) {
                        hVar = hVar3;
                        break;
                    }
                    i13++;
                    a2 = i;
                    arrayList6 = arrayList2;
                    arrayList7 = arrayList;
                    gVar4 = gVar;
                    i9 = 1;
                }
            }
            arrayList = arrayList7;
            arrayList2 = arrayList6;
            gVar = gVar4;
            hVar = null;
            if (hVar != null) {
                if (hVar.a() > 0) {
                    int i23 = hVar.d;
                    int i24 = hVar.b;
                    int i25 = i23 - i24;
                    int i26 = hVar.c;
                    int i27 = hVar.f1944a;
                    int i28 = i26 - i27;
                    if (!(i25 != i28)) {
                        cVar = new c(i27, i24, i28);
                    } else if (hVar.e) {
                        cVar = new c(i27, i24, hVar.a());
                    } else {
                        if (i25 > i28) {
                            cVar = new c(i27, i24 + 1, hVar.a());
                        } else {
                            cVar = new c(i27 + 1, i24, hVar.a());
                        }
                    }
                    arrayList5.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    gVar3 = new g();
                    arrayList4 = arrayList;
                    gVar2 = gVar;
                    i9 = 1;
                } else {
                    i9 = 1;
                    arrayList4 = arrayList;
                    gVar3 = (g) arrayList4.remove(arrayList.size() - 1);
                    gVar2 = gVar;
                }
                gVar3.f1943a = gVar2.f1943a;
                gVar3.c = gVar2.c;
                gVar3.b = hVar.f1944a;
                gVar3.d = hVar.b;
                arrayList3 = arrayList2;
                arrayList3.add(gVar3);
                gVar2.b = gVar2.b;
                gVar2.d = gVar2.d;
                gVar2.f1943a = hVar.c;
                gVar2.c = hVar.d;
                arrayList3.add(gVar2);
            } else {
                arrayList3 = arrayList2;
                arrayList4 = arrayList;
                i9 = 1;
                arrayList4.add(gVar);
            }
            arrayList7 = arrayList4;
            arrayList6 = arrayList3;
        }
        Collections.sort(arrayList5, f1939a);
        return new d(bVar, arrayList5, iArr, iArr2, true);
    }
}
