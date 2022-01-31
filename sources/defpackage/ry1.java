package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.android.flexbox.FlexItem;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.rabbitmq.client.LongString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: ry1  reason: default package */
/* compiled from: FlexboxHelper */
public class ry1 {

    /* renamed from: a  reason: collision with root package name */
    public final py1 f3149a;
    public boolean[] b;
    public int[] c;
    public long[] d;
    public long[] e;

    /* renamed from: ry1$b */
    /* compiled from: FlexboxHelper */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<qy1> f3150a;
        public int b;

        public void a() {
            this.f3150a = null;
            this.b = 0;
        }
    }

    /* renamed from: ry1$c */
    /* compiled from: FlexboxHelper */
    public static class c implements Comparable<c> {
        public int f;
        public int g;

        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            int i = this.g;
            int i2 = cVar2.g;
            if (i != i2) {
                return i - i2;
            }
            return this.f - cVar2.f;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Order{order=");
            i0.append(this.g);
            i0.append(", index=");
            return hj1.W(i0, this.f, '}');
        }

        public c(a aVar) {
        }
    }

    public ry1(py1 py1) {
        this.f3149a = py1;
    }

    public void A(int i) {
        View d2;
        if (i < this.f3149a.getFlexItemCount()) {
            int flexDirection = this.f3149a.getFlexDirection();
            if (this.f3149a.getAlignItems() == 4) {
                int[] iArr = this.c;
                List<qy1> flexLinesInternal = this.f3149a.getFlexLinesInternal();
                int size = flexLinesInternal.size();
                for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                    qy1 qy1 = flexLinesInternal.get(i2);
                    int i3 = qy1.h;
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = qy1.o + i4;
                        if (!(i4 >= this.f3149a.getFlexItemCount() || (d2 = this.f3149a.d(i5)) == null || d2.getVisibility() == 8)) {
                            FlexItem flexItem = (FlexItem) d2.getLayoutParams();
                            if (flexItem.P() == -1 || flexItem.P() == 4) {
                                if (flexDirection == 0 || flexDirection == 1) {
                                    z(d2, qy1.g, i5);
                                } else if (flexDirection == 2 || flexDirection == 3) {
                                    y(d2, qy1.g, i5);
                                } else {
                                    throw new IllegalArgumentException(hj1.I("Invalid flex direction: ", flexDirection));
                                }
                            }
                        }
                    }
                }
                return;
            }
            for (qy1 qy12 : this.f3149a.getFlexLinesInternal()) {
                Iterator<Integer> it = qy12.n.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Integer next = it.next();
                        View d3 = this.f3149a.d(next.intValue());
                        if (flexDirection == 0 || flexDirection == 1) {
                            z(d3, qy12.g, next.intValue());
                        } else if (flexDirection == 2 || flexDirection == 3) {
                            y(d3, qy12.g, next.intValue());
                        } else {
                            throw new IllegalArgumentException(hj1.I("Invalid flex direction: ", flexDirection));
                        }
                    }
                }
            }
        }
    }

    public final void B(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = (((long) i2) & LongString.MAX_LENGTH) | (((long) i3) << 32);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = (((long) view.getMeasuredWidth()) & LongString.MAX_LENGTH) | (((long) view.getMeasuredHeight()) << 32);
        }
    }

    public final void a(List<qy1> list, qy1 qy1, int i, int i2) {
        qy1.m = i2;
        this.f3149a.c(qy1);
        qy1.p = i;
        list.add(qy1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ef, code lost:
        if (r2 < (r7 + r11)) goto L_0x01f1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x035b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(defpackage.ry1.b r24, int r25, int r26, int r27, int r28, int r29, java.util.List<defpackage.qy1> r30) {
        /*
        // Method dump skipped, instructions count: 894
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ry1.b(ry1$b, int, int, int, int, int, java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.a0()
            r4 = 1
            if (r1 >= r3) goto L_0x001a
            int r1 = r0.a0()
            goto L_0x0024
        L_0x001a:
            int r3 = r0.i1()
            if (r1 <= r3) goto L_0x0026
            int r1 = r0.i1()
        L_0x0024:
            r3 = 1
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r5 = r0.R0()
            if (r2 >= r5) goto L_0x0032
            int r2 = r0.R0()
            goto L_0x003e
        L_0x0032:
            int r5 = r0.b1()
            if (r2 <= r5) goto L_0x003d
            int r2 = r0.b1()
            goto L_0x003e
        L_0x003d:
            r4 = r3
        L_0x003e:
            if (r4 == 0) goto L_0x0055
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.B(r8, r1, r0, r7)
            py1 r0 = r6.f3149a
            r0.f(r8, r7)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ry1.c(android.view.View, int):void");
    }

    public void d(List<qy1> list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public final List<qy1> e(List<qy1> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        qy1 qy1 = new qy1();
        qy1.g = (i - i2) / 2;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == 0) {
                arrayList.add(qy1);
            }
            arrayList.add(list.get(i3));
            if (i3 == list.size() - 1) {
                arrayList.add(qy1);
            }
        }
        return arrayList;
    }

    public final List<c> f(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            c cVar = new c(null);
            cVar.g = ((FlexItem) this.f3149a.g(i2).getLayoutParams()).getOrder();
            cVar.f = i2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public void g(int i, int i2, int i3) {
        int i4;
        int i5;
        int flexDirection = this.f3149a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            i4 = mode;
            i5 = size;
        } else if (flexDirection == 2 || flexDirection == 3) {
            i4 = View.MeasureSpec.getMode(i);
            i5 = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException(hj1.I("Invalid flex direction: ", flexDirection));
        }
        List<qy1> flexLinesInternal = this.f3149a.getFlexLinesInternal();
        if (i4 == 1073741824) {
            int sumOfCrossSize = this.f3149a.getSumOfCrossSize() + i3;
            int i6 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = i5 - i3;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f3149a.getAlignContent();
                if (alignContent == 1) {
                    int i7 = i5 - sumOfCrossSize;
                    qy1 qy1 = new qy1();
                    qy1.g = i7;
                    flexLinesInternal.add(0, qy1);
                } else if (alignContent == 2) {
                    this.f3149a.setFlexLines(e(flexLinesInternal, i5, sumOfCrossSize));
                } else if (alignContent != 3) {
                    if (alignContent != 4) {
                        if (alignContent == 5 && sumOfCrossSize < i5) {
                            float size2 = ((float) (i5 - sumOfCrossSize)) / ((float) flexLinesInternal.size());
                            int size3 = flexLinesInternal.size();
                            float f = 0.0f;
                            while (i6 < size3) {
                                qy1 qy12 = flexLinesInternal.get(i6);
                                float f2 = ((float) qy12.g) + size2;
                                if (i6 == flexLinesInternal.size() - 1) {
                                    f2 += f;
                                    f = 0.0f;
                                }
                                int round = Math.round(f2);
                                float f3 = (f2 - ((float) round)) + f;
                                if (f3 > 1.0f) {
                                    round++;
                                    f3 -= 1.0f;
                                } else if (f3 < -1.0f) {
                                    round--;
                                    f3 += 1.0f;
                                }
                                f = f3;
                                qy12.g = round;
                                i6++;
                            }
                        }
                    } else if (sumOfCrossSize >= i5) {
                        this.f3149a.setFlexLines(e(flexLinesInternal, i5, sumOfCrossSize));
                    } else {
                        int size4 = (i5 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList = new ArrayList();
                        qy1 qy13 = new qy1();
                        qy13.g = size4;
                        for (qy1 qy14 : flexLinesInternal) {
                            arrayList.add(qy13);
                            arrayList.add(qy14);
                            arrayList.add(qy13);
                        }
                        this.f3149a.setFlexLines(arrayList);
                    }
                } else if (sumOfCrossSize < i5) {
                    float size5 = ((float) (i5 - sumOfCrossSize)) / ((float) (flexLinesInternal.size() - 1));
                    ArrayList arrayList2 = new ArrayList();
                    int size6 = flexLinesInternal.size();
                    float f4 = 0.0f;
                    while (i6 < size6) {
                        arrayList2.add(flexLinesInternal.get(i6));
                        if (i6 != flexLinesInternal.size() - 1) {
                            qy1 qy15 = new qy1();
                            if (i6 == flexLinesInternal.size() - 2) {
                                qy15.g = Math.round(f4 + size5);
                                f4 = 0.0f;
                            } else {
                                qy15.g = Math.round(size5);
                            }
                            int i8 = qy15.g;
                            float f5 = (size5 - ((float) i8)) + f4;
                            if (f5 > 1.0f) {
                                qy15.g = i8 + 1;
                                f5 -= 1.0f;
                            } else if (f5 < -1.0f) {
                                qy15.g = i8 - 1;
                                f5 += 1.0f;
                            }
                            arrayList2.add(qy15);
                            f4 = f5;
                        }
                        i6++;
                    }
                    this.f3149a.setFlexLines(arrayList2);
                }
            }
        }
    }

    public void h(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int flexItemCount = this.f3149a.getFlexItemCount();
        boolean[] zArr = this.b;
        int i7 = 0;
        if (zArr == null) {
            if (flexItemCount < 10) {
                flexItemCount = 10;
            }
            this.b = new boolean[flexItemCount];
        } else if (zArr.length < flexItemCount) {
            int length = zArr.length * 2;
            if (length >= flexItemCount) {
                flexItemCount = length;
            }
            this.b = new boolean[flexItemCount];
        } else {
            Arrays.fill(zArr, false);
        }
        if (i3 < this.f3149a.getFlexItemCount()) {
            int flexDirection = this.f3149a.getFlexDirection();
            int flexDirection2 = this.f3149a.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int mode = View.MeasureSpec.getMode(i);
                i5 = View.MeasureSpec.getSize(i);
                if (mode != 1073741824) {
                    i5 = this.f3149a.getLargestMainSize();
                }
                i6 = this.f3149a.getPaddingLeft();
                i4 = this.f3149a.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int mode2 = View.MeasureSpec.getMode(i2);
                i5 = View.MeasureSpec.getSize(i2);
                if (mode2 != 1073741824) {
                    i5 = this.f3149a.getLargestMainSize();
                }
                i6 = this.f3149a.getPaddingTop();
                i4 = this.f3149a.getPaddingBottom();
            } else {
                throw new IllegalArgumentException(hj1.I("Invalid flex direction: ", flexDirection));
            }
            int i8 = i4 + i6;
            int[] iArr = this.c;
            if (iArr != null) {
                i7 = iArr[i3];
            }
            List<qy1> flexLinesInternal = this.f3149a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            while (i7 < size) {
                qy1 qy1 = flexLinesInternal.get(i7);
                if (qy1.e < i5) {
                    l(i, i2, qy1, i5, i8, false);
                } else {
                    w(i, i2, qy1, i5, i8, false);
                }
                i7++;
            }
        }
    }

    public void i(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.c = Arrays.copyOf(iArr, i);
        }
    }

    public void j(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.d = Arrays.copyOf(jArr, i);
        }
    }

    public void k(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.e = Arrays.copyOf(jArr, i);
        }
    }

    public final void l(int i, int i2, qy1 qy1, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        double d2;
        int i8;
        double d3;
        float f = qy1.j;
        float f2 = 0.0f;
        if (f > 0.0f && i3 >= (i5 = qy1.e)) {
            float f3 = ((float) (i3 - i5)) / f;
            qy1.e = i4 + qy1.f;
            if (!z) {
                qy1.g = RtlSpacingHelper.UNDEFINED;
            }
            int i9 = 0;
            boolean z2 = false;
            int i10 = 0;
            float f4 = 0.0f;
            while (i9 < qy1.h) {
                int i11 = qy1.o + i9;
                View d4 = this.f3149a.d(i11);
                if (d4 == null || d4.getVisibility() == 8) {
                    i6 = i5;
                } else {
                    FlexItem flexItem = (FlexItem) d4.getLayoutParams();
                    int flexDirection = this.f3149a.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        int measuredWidth = d4.getMeasuredWidth();
                        long[] jArr = this.e;
                        if (jArr != null) {
                            measuredWidth = (int) jArr[i11];
                        }
                        int measuredHeight = d4.getMeasuredHeight();
                        long[] jArr2 = this.e;
                        i6 = i5;
                        if (jArr2 != null) {
                            measuredHeight = m(jArr2[i11]);
                        }
                        if (!this.b[i11] && flexItem.w0() > 0.0f) {
                            float w0 = (flexItem.w0() * f3) + ((float) measuredWidth);
                            if (i9 == qy1.h - 1) {
                                w0 += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(w0);
                            if (round > flexItem.i1()) {
                                round = flexItem.i1();
                                this.b[i11] = true;
                                qy1.j -= flexItem.w0();
                                z2 = true;
                            } else {
                                float f5 = (w0 - ((float) round)) + f4;
                                double d5 = (double) f5;
                                if (d5 > 1.0d) {
                                    round++;
                                    d2 = d5 - 1.0d;
                                } else {
                                    if (d5 < -1.0d) {
                                        round--;
                                        d2 = d5 + 1.0d;
                                    }
                                    f4 = f5;
                                }
                                f5 = (float) d2;
                                f4 = f5;
                            }
                            int n = n(i2, flexItem, qy1.m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, CommonUtils.BYTES_IN_A_GIGABYTE);
                            d4.measure(makeMeasureSpec, n);
                            int measuredWidth2 = d4.getMeasuredWidth();
                            int measuredHeight2 = d4.getMeasuredHeight();
                            B(i11, makeMeasureSpec, n, d4);
                            this.f3149a.f(i11, d4);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i10, this.f3149a.k(d4) + flexItem.g0() + flexItem.q0() + measuredHeight);
                        qy1.e = flexItem.O0() + flexItem.i0() + measuredWidth + qy1.e;
                        i7 = max;
                    } else {
                        int measuredHeight3 = d4.getMeasuredHeight();
                        long[] jArr3 = this.e;
                        if (jArr3 != null) {
                            measuredHeight3 = m(jArr3[i11]);
                        }
                        int measuredWidth3 = d4.getMeasuredWidth();
                        long[] jArr4 = this.e;
                        if (jArr4 != null) {
                            measuredWidth3 = (int) jArr4[i11];
                        }
                        if (this.b[i11] || flexItem.w0() <= f2) {
                            i8 = i5;
                        } else {
                            float w02 = (flexItem.w0() * f3) + ((float) measuredHeight3);
                            if (i9 == qy1.h - 1) {
                                w02 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(w02);
                            if (round2 > flexItem.b1()) {
                                round2 = flexItem.b1();
                                this.b[i11] = true;
                                qy1.j -= flexItem.w0();
                                i8 = i5;
                                z2 = true;
                            } else {
                                float f6 = (w02 - ((float) round2)) + f4;
                                i8 = i5;
                                double d6 = (double) f6;
                                if (d6 > 1.0d) {
                                    round2++;
                                    d3 = d6 - 1.0d;
                                } else if (d6 < -1.0d) {
                                    round2--;
                                    d3 = d6 + 1.0d;
                                } else {
                                    f4 = f6;
                                }
                                f4 = (float) d3;
                            }
                            int o = o(i, flexItem, qy1.m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, CommonUtils.BYTES_IN_A_GIGABYTE);
                            d4.measure(o, makeMeasureSpec2);
                            measuredWidth3 = d4.getMeasuredWidth();
                            int measuredHeight4 = d4.getMeasuredHeight();
                            B(i11, o, makeMeasureSpec2, d4);
                            this.f3149a.f(i11, d4);
                            measuredHeight3 = measuredHeight4;
                        }
                        i7 = Math.max(i10, this.f3149a.k(d4) + flexItem.O0() + flexItem.i0() + measuredWidth3);
                        qy1.e = flexItem.g0() + flexItem.q0() + measuredHeight3 + qy1.e;
                        i6 = i8;
                    }
                    qy1.g = Math.max(qy1.g, i7);
                    i10 = i7;
                }
                i9++;
                i5 = i6;
                f2 = 0.0f;
            }
            if (z2 && i5 != qy1.e) {
                l(i, i2, qy1, i3, i4, true);
            }
        }
    }

    public int m(long j) {
        return (int) (j >> 32);
    }

    public final int n(int i, FlexItem flexItem, int i2) {
        py1 py1 = this.f3149a;
        int i3 = py1.i(i, flexItem.g0() + flexItem.q0() + this.f3149a.getPaddingBottom() + py1.getPaddingTop() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(i3);
        if (size > flexItem.b1()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.b1(), View.MeasureSpec.getMode(i3));
        }
        return size < flexItem.R0() ? View.MeasureSpec.makeMeasureSpec(flexItem.R0(), View.MeasureSpec.getMode(i3)) : i3;
    }

    public final int o(int i, FlexItem flexItem, int i2) {
        py1 py1 = this.f3149a;
        int e2 = py1.e(i, flexItem.O0() + flexItem.i0() + this.f3149a.getPaddingRight() + py1.getPaddingLeft() + i2, flexItem.k());
        int size = View.MeasureSpec.getSize(e2);
        if (size > flexItem.i1()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.i1(), View.MeasureSpec.getMode(e2));
        }
        return size < flexItem.a0() ? View.MeasureSpec.makeMeasureSpec(flexItem.a0(), View.MeasureSpec.getMode(e2)) : e2;
    }

    public final int p(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.g0();
        }
        return flexItem.O0();
    }

    public final int q(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.O0();
        }
        return flexItem.g0();
    }

    public final int r(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.q0();
        }
        return flexItem.i0();
    }

    public final int s(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.i0();
        }
        return flexItem.q0();
    }

    public final boolean t(int i, int i2, qy1 qy1) {
        return i == i2 - 1 && qy1.a() != 0;
    }

    public void u(View view, qy1 qy1, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f3149a.getAlignItems();
        if (flexItem.P() != -1) {
            alignItems = flexItem.P();
        }
        int i5 = qy1.g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int q0 = ((flexItem.q0() + (i5 - view.getMeasuredHeight())) - flexItem.g0()) / 2;
                    if (this.f3149a.getFlexWrap() != 2) {
                        int i6 = i2 + q0;
                        view.layout(i, i6, i3, view.getMeasuredHeight() + i6);
                        return;
                    }
                    int i7 = i2 - q0;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else if (alignItems != 3) {
                    if (alignItems != 4) {
                        return;
                    }
                } else if (this.f3149a.getFlexWrap() != 2) {
                    int max = Math.max(qy1.l - view.getBaseline(), flexItem.q0());
                    view.layout(i, i2 + max, i3, i4 + max);
                    return;
                } else {
                    int max2 = Math.max(view.getBaseline() + (qy1.l - view.getMeasuredHeight()), flexItem.g0());
                    view.layout(i, i2 - max2, i3, i4 - max2);
                    return;
                }
            } else if (this.f3149a.getFlexWrap() != 2) {
                int i8 = i2 + i5;
                view.layout(i, (i8 - view.getMeasuredHeight()) - flexItem.g0(), i3, i8 - flexItem.g0());
                return;
            } else {
                view.layout(i, flexItem.q0() + view.getMeasuredHeight() + (i2 - i5), i3, flexItem.q0() + view.getMeasuredHeight() + (i4 - i5));
                return;
            }
        }
        if (this.f3149a.getFlexWrap() != 2) {
            view.layout(i, flexItem.q0() + i2, i3, flexItem.q0() + i4);
        } else {
            view.layout(i, i2 - flexItem.g0(), i3, i4 - flexItem.g0());
        }
    }

    public void v(View view, qy1 qy1, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f3149a.getAlignItems();
        if (flexItem.P() != -1) {
            alignItems = flexItem.P();
        }
        int i5 = qy1.g;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int measuredWidth = (((i5 - view.getMeasuredWidth()) + marginLayoutParams.getMarginStart()) - marginLayoutParams.getMarginEnd()) / 2;
                    if (!z) {
                        view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                        return;
                    } else {
                        view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                        return;
                    }
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!z) {
                view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.O0(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.O0(), i4);
                return;
            } else {
                int i0 = flexItem.i0();
                view.layout(flexItem.i0() + view.getMeasuredWidth() + (i - i5), i2, i0 + view.getMeasuredWidth() + (i3 - i5), i4);
                return;
            }
        }
        if (!z) {
            view.layout(flexItem.i0() + i, i2, flexItem.i0() + i3, i4);
        } else {
            view.layout(i - flexItem.O0(), i2, i3 - flexItem.O0(), i4);
        }
    }

    public final void w(int i, int i2, qy1 qy1, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = qy1.e;
        float f = qy1.k;
        float f2 = 0.0f;
        if (f > 0.0f && i3 <= i9) {
            float f3 = ((float) (i9 - i3)) / f;
            qy1.e = i4 + qy1.f;
            if (!z) {
                qy1.g = RtlSpacingHelper.UNDEFINED;
            }
            int i10 = 0;
            boolean z2 = false;
            int i11 = 0;
            float f4 = 0.0f;
            while (i10 < qy1.h) {
                int i12 = qy1.o + i10;
                View d2 = this.f3149a.d(i12);
                if (d2 == null || d2.getVisibility() == 8) {
                    i6 = i9;
                    i5 = i10;
                } else {
                    FlexItem flexItem = (FlexItem) d2.getLayoutParams();
                    int flexDirection = this.f3149a.getFlexDirection();
                    if (flexDirection == 0 || flexDirection == 1) {
                        i6 = i9;
                        int measuredWidth = d2.getMeasuredWidth();
                        long[] jArr = this.e;
                        if (jArr != null) {
                            measuredWidth = (int) jArr[i12];
                        }
                        int measuredHeight = d2.getMeasuredHeight();
                        long[] jArr2 = this.e;
                        if (jArr2 != null) {
                            measuredHeight = m(jArr2[i12]);
                        }
                        if (this.b[i12] || flexItem.T() <= 0.0f) {
                            i5 = i10;
                        } else {
                            float T = ((float) measuredWidth) - (flexItem.T() * f3);
                            i5 = i10;
                            if (i5 == qy1.h - 1) {
                                T += f4;
                                f4 = 0.0f;
                            }
                            int round = Math.round(T);
                            if (round < flexItem.a0()) {
                                i8 = flexItem.a0();
                                this.b[i12] = true;
                                qy1.k -= flexItem.T();
                                z2 = true;
                            } else {
                                float f5 = (T - ((float) round)) + f4;
                                double d3 = (double) f5;
                                if (d3 > 1.0d) {
                                    round++;
                                    f5 -= 1.0f;
                                } else if (d3 < -1.0d) {
                                    round--;
                                    f5 += 1.0f;
                                }
                                f4 = f5;
                                i8 = round;
                            }
                            int n = n(i2, flexItem, qy1.m);
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, CommonUtils.BYTES_IN_A_GIGABYTE);
                            d2.measure(makeMeasureSpec, n);
                            int measuredWidth2 = d2.getMeasuredWidth();
                            int measuredHeight2 = d2.getMeasuredHeight();
                            B(i12, makeMeasureSpec, n, d2);
                            this.f3149a.f(i12, d2);
                            measuredWidth = measuredWidth2;
                            measuredHeight = measuredHeight2;
                        }
                        int max = Math.max(i11, this.f3149a.k(d2) + flexItem.g0() + flexItem.q0() + measuredHeight);
                        qy1.e = flexItem.O0() + flexItem.i0() + measuredWidth + qy1.e;
                        i7 = max;
                    } else {
                        int measuredHeight3 = d2.getMeasuredHeight();
                        long[] jArr3 = this.e;
                        if (jArr3 != null) {
                            measuredHeight3 = m(jArr3[i12]);
                        }
                        int measuredWidth3 = d2.getMeasuredWidth();
                        long[] jArr4 = this.e;
                        if (jArr4 != null) {
                            measuredWidth3 = (int) jArr4[i12];
                        }
                        if (this.b[i12] || flexItem.T() <= f2) {
                            i6 = i9;
                            i5 = i10;
                        } else {
                            float T2 = ((float) measuredHeight3) - (flexItem.T() * f3);
                            if (i10 == qy1.h - 1) {
                                T2 += f4;
                                f4 = 0.0f;
                            }
                            int round2 = Math.round(T2);
                            if (round2 < flexItem.R0()) {
                                int R0 = flexItem.R0();
                                this.b[i12] = true;
                                qy1.k -= flexItem.T();
                                i5 = i10;
                                round2 = R0;
                                z2 = true;
                                i6 = i9;
                            } else {
                                float f6 = (T2 - ((float) round2)) + f4;
                                i6 = i9;
                                i5 = i10;
                                double d4 = (double) f6;
                                if (d4 > 1.0d) {
                                    round2++;
                                    f6 -= 1.0f;
                                } else if (d4 < -1.0d) {
                                    round2--;
                                    f6 += 1.0f;
                                }
                                f4 = f6;
                            }
                            int o = o(i, flexItem, qy1.m);
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, CommonUtils.BYTES_IN_A_GIGABYTE);
                            d2.measure(o, makeMeasureSpec2);
                            measuredWidth3 = d2.getMeasuredWidth();
                            int measuredHeight4 = d2.getMeasuredHeight();
                            B(i12, o, makeMeasureSpec2, d2);
                            this.f3149a.f(i12, d2);
                            measuredHeight3 = measuredHeight4;
                        }
                        i7 = Math.max(i11, this.f3149a.k(d2) + flexItem.O0() + flexItem.i0() + measuredWidth3);
                        qy1.e = flexItem.g0() + flexItem.q0() + measuredHeight3 + qy1.e;
                    }
                    qy1.g = Math.max(qy1.g, i7);
                    i11 = i7;
                }
                i10 = i5 + 1;
                i9 = i6;
                f2 = 0.0f;
            }
            if (z2 && i9 != qy1.e) {
                w(i, i2, qy1, i3, i4, true);
            }
        }
    }

    public final int[] x(int i, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (c cVar : list) {
            int i3 = cVar.f;
            iArr[i2] = i3;
            sparseIntArray.append(i3, cVar.g);
            i2++;
        }
        return iArr;
    }

    public final void y(View view, int i, int i2) {
        int i3;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.i0()) - flexItem.O0()) - this.f3149a.k(view), flexItem.a0()), flexItem.i1());
        long[] jArr = this.e;
        if (jArr != null) {
            i3 = m(jArr[i2]);
        } else {
            i3 = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, CommonUtils.BYTES_IN_A_GIGABYTE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, CommonUtils.BYTES_IN_A_GIGABYTE);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        B(i2, makeMeasureSpec2, makeMeasureSpec, view);
        this.f3149a.f(i2, view);
    }

    public final void z(View view, int i, int i2) {
        int i3;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i - flexItem.q0()) - flexItem.g0()) - this.f3149a.k(view), flexItem.R0()), flexItem.b1());
        long[] jArr = this.e;
        if (jArr != null) {
            i3 = (int) jArr[i2];
        } else {
            i3 = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, CommonUtils.BYTES_IN_A_GIGABYTE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, CommonUtils.BYTES_IN_A_GIGABYTE);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        B(i2, makeMeasureSpec, makeMeasureSpec2, view);
        this.f3149a.f(i2, view);
    }
}
