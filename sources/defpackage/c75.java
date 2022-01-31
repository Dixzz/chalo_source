package defpackage;

import com.rabbitmq.client.AMQP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.zophop.logicLayer.CsLogic;

/* renamed from: c75  reason: default package */
/* compiled from: RSSExpandedReader */
public final class c75 extends v65 {
    public static final int[] k = {7, 5, 4, 3, 1};
    public static final int[] l = {4, 20, 52, 104, 204};
    public static final int[] m = {0, 348, 1388, 2948, 3988};
    public static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, CsLogic.ETA_FORCE_UPDATE_REDIS_TTL, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, AMQP.FRAME_END, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, AMQP.REPLY_SUCCESS, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    public static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List<a75> g = new ArrayList(11);
    public final List<b75> h = new ArrayList();
    public final int[] i = new int[2];
    public boolean j;

    public static e35 p(List<a75> list) throws a35, v25 {
        m75 m75;
        int size = (list.size() << 1) - 1;
        if (((a75) hj1.u(list, 1)).b == null) {
            size--;
        }
        e45 e45 = new e45(size * 12);
        int i2 = list.get(0).b.f3736a;
        int i3 = 0;
        for (int i4 = 11; i4 >= 0; i4--) {
            if (((1 << i4) & i2) != 0) {
                e45.k(i3);
            }
            i3++;
        }
        for (int i5 = 1; i5 < list.size(); i5++) {
            a75 a75 = list.get(i5);
            int i6 = a75.f131a.f3736a;
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & i6) != 0) {
                    e45.k(i3);
                }
                i3++;
            }
            w65 w65 = a75.b;
            if (w65 != null) {
                int i8 = w65.f3736a;
                for (int i9 = 11; i9 >= 0; i9--) {
                    if (((1 << i9) & i8) != 0) {
                        e45.k(i3);
                    }
                    i3++;
                }
            }
        }
        if (e45.e(1)) {
            m75 = new j75(e45);
        } else if (!e45.e(2)) {
            m75 = new n75(e45);
        } else {
            int d = v75.d(e45, 1, 4);
            if (d == 4) {
                m75 = new d75(e45);
            } else if (d != 5) {
                int d2 = v75.d(e45, 1, 5);
                if (d2 == 12) {
                    m75 = new f75(e45);
                } else if (d2 != 13) {
                    switch (v75.d(e45, 1, 7)) {
                        case 56:
                            m75 = new h75(e45, "310", "11");
                            break;
                        case 57:
                            m75 = new h75(e45, "320", "11");
                            break;
                        case 58:
                            m75 = new h75(e45, "310", "13");
                            break;
                        case 59:
                            m75 = new h75(e45, "320", "13");
                            break;
                        case 60:
                            m75 = new h75(e45, "310", "15");
                            break;
                        case 61:
                            m75 = new h75(e45, "320", "15");
                            break;
                        case 62:
                            m75 = new h75(e45, "310", "17");
                            break;
                        case 63:
                            m75 = new h75(e45, "320", "17");
                            break;
                        default:
                            throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(e45)));
                    }
                } else {
                    m75 = new g75(e45);
                }
            } else {
                m75 = new e75(e45);
            }
        }
        String a2 = m75.a();
        g35[] g35Arr = list.get(0).c.c;
        g35[] g35Arr2 = ((a75) hj1.u(list, 1)).c.c;
        return new e35(a2, null, new g35[]{g35Arr[0], g35Arr[1], g35Arr2[0], g35Arr2[1]}, o25.RSS_EXPANDED);
    }

    public static void t(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    @Override // defpackage.c35, defpackage.k65
    public void c() {
        this.g.clear();
        this.h.clear();
    }

    @Override // defpackage.k65
    public e35 d(int i2, e45 e45, Map<s25, ?> map) throws a35, v25 {
        this.g.clear();
        this.j = false;
        try {
            return p(r(i2, e45));
        } catch (a35 unused) {
            this.g.clear();
            this.j = true;
            return p(r(i2, e45));
        }
    }

    public final boolean m() {
        a75 a75 = this.g.get(0);
        w65 w65 = a75.f131a;
        w65 w652 = a75.b;
        if (w652 == null) {
            return false;
        }
        int i2 = w652.b;
        int i3 = 2;
        for (int i4 = 1; i4 < this.g.size(); i4++) {
            a75 a752 = this.g.get(i4);
            i2 += a752.f131a.b;
            i3++;
            w65 w653 = a752.b;
            if (w653 != null) {
                i2 += w653.b;
                i3++;
            }
        }
        if (((i3 - 4) * 211) + (i2 % 211) == w65.f3736a) {
            return true;
        }
        return false;
    }

    public final List<a75> n(List<b75> list, int i2) throws a35 {
        boolean z;
        while (i2 < this.h.size()) {
            b75 b75 = this.h.get(i2);
            this.g.clear();
            for (b75 b752 : list) {
                this.g.addAll(b752.f391a);
            }
            this.g.addAll(b75.f391a);
            List<a75> list2 = this.g;
            int[][] iArr = p;
            int length = iArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i3];
                if (list2.size() <= iArr2.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list2.size()) {
                            z = true;
                            break;
                        } else if (list2.get(i4).c.f3893a != iArr2[i4]) {
                            z = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
                i3++;
            }
            if (!z2) {
                i2++;
            } else if (m()) {
                return this.g;
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(b75);
                try {
                    return n(arrayList, i2 + 1);
                } catch (a35 unused) {
                    continue;
                }
            }
        }
        throw a35.h;
    }

    public final List<a75> o(boolean z) {
        List<a75> list = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            list = n(new ArrayList(), 0);
        } catch (a35 unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.w65 q(defpackage.e45 r19, defpackage.x65 r20, boolean r21, boolean r22) throws defpackage.a35 {
        /*
        // Method dump skipped, instructions count: 466
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c75.q(e45, x65, boolean, boolean):w65");
    }

    public List<a75> r(int i2, e45 e45) throws a35 {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        while (!z7) {
            try {
                List<a75> list = this.g;
                list.add(s(e45, list, i2));
            } catch (a35 e) {
                if (!this.g.isEmpty()) {
                    z7 = true;
                } else {
                    throw e;
                }
            }
        }
        if (m()) {
            return this.g;
        }
        boolean z8 = !this.h.isEmpty();
        int i3 = 0;
        boolean z9 = false;
        while (true) {
            if (i3 >= this.h.size()) {
                z = false;
                break;
            }
            b75 b75 = this.h.get(i3);
            if (b75.b > i2) {
                z = b75.f391a.equals(this.g);
                break;
            }
            z9 = b75.f391a.equals(this.g);
            i3++;
        }
        if (!z && !z9) {
            List<a75> list2 = this.g;
            Iterator<T> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                T next = it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        continue;
                        break;
                    }
                    T next2 = it2.next();
                    Iterator<a75> it3 = next.f391a.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z6 = true;
                                continue;
                                break;
                            }
                        } else {
                            z6 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z6) {
                        z5 = false;
                        continue;
                        break;
                    }
                }
                if (z5) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.h.add(i3, new b75(this.g, i2, false));
                List<a75> list3 = this.g;
                Iterator<b75> it4 = this.h.iterator();
                while (it4.hasNext()) {
                    b75 next3 = it4.next();
                    if (next3.f391a.size() != list3.size()) {
                        Iterator<a75> it5 = next3.f391a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            a75 next4 = it5.next();
                            Iterator<a75> it6 = list3.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    if (next4.equals(it6.next())) {
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z4 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (!z4) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            it4.remove();
                        }
                    }
                }
            }
        }
        if (z8) {
            List<a75> o2 = o(false);
            if (o2 != null) {
                return o2;
            }
            List<a75> o3 = o(true);
            if (o3 != null) {
                return o3;
            }
        }
        throw a35.h;
    }

    public a75 s(e45 e45, List<a75> list, int i2) throws a35 {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        x65 x65;
        int i8 = 2;
        int i9 = 0;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int i10 = -1;
        boolean z2 = true;
        while (true) {
            int[] iArr = this.f3611a;
            iArr[i9] = i9;
            iArr[1] = i9;
            iArr[i8] = i9;
            iArr[3] = i9;
            int i11 = e45.g;
            if (i10 >= 0) {
                i3 = i10;
            } else if (list.isEmpty()) {
                i3 = 0;
            } else {
                i3 = ((a75) hj1.u(list, 1)).c.b[1];
            }
            boolean z3 = list.size() % i8 != 0;
            if (this.j) {
                z3 = !z3;
            }
            boolean z4 = false;
            while (i3 < i11) {
                z4 = !e45.e(i3);
                if (!z4) {
                    break;
                }
                i3++;
            }
            boolean z5 = z4;
            int i12 = 0;
            int i13 = i3;
            while (i3 < i11) {
                if (e45.e(i3) != z5) {
                    iArr[i12] = iArr[i12] + 1;
                } else {
                    if (i12 == 3) {
                        if (z3) {
                            t(iArr);
                        }
                        if (v65.k(iArr)) {
                            int[] iArr2 = this.i;
                            iArr2[0] = i13;
                            iArr2[1] = i3;
                            if (z) {
                                int i14 = iArr2[0] - 1;
                                while (i14 >= 0 && !e45.e(i14)) {
                                    i14--;
                                }
                                int i15 = i14 + 1;
                                int[] iArr3 = this.i;
                                i7 = 0;
                                i6 = iArr3[0] - i15;
                                i5 = i15;
                                i4 = iArr3[1];
                            } else {
                                i7 = 0;
                                int i16 = iArr2[0];
                                int g2 = e45.g(iArr2[1] + 1);
                                i6 = g2 - this.i[1];
                                i4 = g2;
                                i5 = i16;
                            }
                            int[] iArr4 = this.f3611a;
                            System.arraycopy(iArr4, i7, iArr4, 1, iArr4.length - 1);
                            iArr4[i7] = i6;
                            w65 w65 = null;
                            try {
                                int l2 = v65.l(iArr4, n);
                                int[] iArr5 = new int[2];
                                iArr5[i7] = i5;
                                iArr5[1] = i4;
                                x65 = new x65(l2, iArr5, i5, i4, i2);
                            } catch (a35 unused) {
                                x65 = null;
                            }
                            if (x65 == null) {
                                int i17 = this.i[0];
                                if (e45.e(i17)) {
                                    i10 = e45.f(e45.g(i17));
                                } else {
                                    i10 = e45.g(e45.f(i17));
                                }
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                w65 q = q(e45, x65, z, true);
                                if (!list.isEmpty()) {
                                    if (((a75) hj1.u(list, 1)).b == null) {
                                        throw a35.h;
                                    }
                                }
                                try {
                                    w65 = q(e45, x65, z, false);
                                } catch (a35 unused2) {
                                }
                                return new a75(q, w65, x65, true);
                            }
                            i8 = 2;
                            i9 = 0;
                        } else {
                            if (z3) {
                                t(iArr);
                            }
                            i13 = iArr[0] + iArr[1] + i13;
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = 0;
                            iArr[3] = 0;
                            i12--;
                        }
                    } else {
                        i12++;
                    }
                    iArr[i12] = 1;
                    z5 = !z5;
                }
                i3++;
            }
            throw a35.h;
        }
    }
}
