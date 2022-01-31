package defpackage;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: l95  reason: default package */
/* compiled from: FinderPatternFinder */
public class l95 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f2192a;
    public final List<k95> b = new ArrayList();
    public boolean c;
    public final int[] d = new int[5];
    public final h35 e;

    /* renamed from: l95$b */
    /* compiled from: FinderPatternFinder */
    public static final class b implements Serializable, Comparator<k95>, j$.util.Comparator {
        public final float f;

        public b(float f2, a aVar) {
            this.f = f2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(k95 k95, k95 k952) {
            k95 k953 = k95;
            k95 k954 = k952;
            int compare = Integer.compare(k954.d, k953.d);
            return compare == 0 ? Float.compare(Math.abs(k953.c - this.f), Math.abs(k954.c - this.f)) : compare;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<k95> reversed() {
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
        public /* synthetic */ java.util.Comparator<k95> thenComparing(java.util.Comparator<? super k95> comparator) {
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

    /* renamed from: l95$c */
    /* compiled from: FinderPatternFinder */
    public static final class c implements Serializable, java.util.Comparator<k95>, j$.util.Comparator {
        public final float f;

        public c(float f2, a aVar) {
            this.f = f2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(k95 k95, k95 k952) {
            return Float.compare(Math.abs(k952.c - this.f), Math.abs(k95.c - this.f));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<k95> reversed() {
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
        public /* synthetic */ java.util.Comparator<k95> thenComparing(java.util.Comparator<? super k95> comparator) {
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

    public l95(f45 f45, h35 h35) {
        this.f2192a = f45;
        this.e = h35;
    }

    public static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    public static boolean c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    public final void b(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    public final int[] d() {
        b(this.d);
        return this.d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0346 A[LOOP:19: B:178:0x02e1->B:192:0x0346, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0322 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:254:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(int[] r18, int r19, int r20) {
        /*
        // Method dump skipped, instructions count: 864
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l95.e(int[], int, int):boolean");
    }

    public final boolean f() {
        int size = this.b.size();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        for (k95 k95 : this.b) {
            if (k95.d >= 2) {
                i++;
                f2 += k95.c;
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (k95 k952 : this.b) {
            f += Math.abs(k952.c - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    public final void g(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
