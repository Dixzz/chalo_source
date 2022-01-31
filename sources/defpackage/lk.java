package defpackage;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: lk  reason: default package */
/* compiled from: GapWorker */
public final class lk implements Runnable {
    public static final ThreadLocal<lk> j = new ThreadLocal<>();
    public static Comparator<c> k = new a();
    public ArrayList<RecyclerView> f = new ArrayList<>();
    public long g;
    public long h;
    public ArrayList<c> i = new ArrayList<>();

    /* renamed from: lk$a */
    /* compiled from: GapWorker */
    public class a implements Comparator<c>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r0 == null) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            if (r0 != false) goto L_0x0022;
         */
        @Override // j$.util.Comparator, java.util.Comparator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(defpackage.lk.c r7, defpackage.lk.c r8) {
            /*
                r6 = this;
                lk$c r7 = (defpackage.lk.c) r7
                lk$c r8 = (defpackage.lk.c) r8
                androidx.recyclerview.widget.RecyclerView r0 = r7.d
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x000c
                r3 = 1
                goto L_0x000d
            L_0x000c:
                r3 = 0
            L_0x000d:
                androidx.recyclerview.widget.RecyclerView r4 = r8.d
                if (r4 != 0) goto L_0x0013
                r4 = 1
                goto L_0x0014
            L_0x0013:
                r4 = 0
            L_0x0014:
                r5 = -1
                if (r3 == r4) goto L_0x001a
                if (r0 != 0) goto L_0x0022
                goto L_0x0023
            L_0x001a:
                boolean r0 = r7.f2231a
                boolean r3 = r8.f2231a
                if (r0 == r3) goto L_0x0025
                if (r0 == 0) goto L_0x0023
            L_0x0022:
                r1 = -1
            L_0x0023:
                r2 = r1
                goto L_0x0036
            L_0x0025:
                int r0 = r8.b
                int r1 = r7.b
                int r0 = r0 - r1
                if (r0 == 0) goto L_0x002e
                r2 = r0
                goto L_0x0036
            L_0x002e:
                int r7 = r7.c
                int r8 = r8.c
                int r7 = r7 - r8
                if (r7 == 0) goto L_0x0036
                r2 = r7
            L_0x0036:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.lk.a.compare(java.lang.Object, java.lang.Object):int");
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

    @SuppressLint({"VisibleForTests"})
    /* renamed from: lk$b */
    /* compiled from: GapWorker */
    public static class b implements RecyclerView.m.c {

        /* renamed from: a  reason: collision with root package name */
        public int f2230a;
        public int b;
        public int[] c;
        public int d;

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void b(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.m mVar = recyclerView.r;
            if (recyclerView.q != null && mVar != null && mVar.q) {
                if (z) {
                    if (!recyclerView.i.g()) {
                        mVar.u(recyclerView.q.getItemCount(), this);
                    }
                } else if (!recyclerView.M()) {
                    mVar.t(this.f2230a, this.b, recyclerView.n0, this);
                }
                int i = this.d;
                if (i > mVar.r) {
                    mVar.r = i;
                    mVar.s = z;
                    recyclerView.g.m();
                }
            }
        }

        public boolean c(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: lk$c */
    /* compiled from: GapWorker */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2231a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.g == 0) {
            this.g = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.m0;
        bVar.f2230a = i2;
        bVar.b = i3;
    }

    public void b(long j2) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        int size = this.f.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView3 = this.f.get(i3);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.m0.b(recyclerView3, false);
                i2 += recyclerView3.m0.d;
            }
        }
        this.i.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView4 = this.f.get(i5);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar = recyclerView4.m0;
                int abs = Math.abs(bVar.b) + Math.abs(bVar.f2230a);
                for (int i6 = 0; i6 < bVar.d * 2; i6 += 2) {
                    if (i4 >= this.i.size()) {
                        cVar2 = new c();
                        this.i.add(cVar2);
                    } else {
                        cVar2 = this.i.get(i4);
                    }
                    int[] iArr = bVar.c;
                    int i7 = iArr[i6 + 1];
                    cVar2.f2231a = i7 <= abs;
                    cVar2.b = abs;
                    cVar2.c = i7;
                    cVar2.d = recyclerView4;
                    cVar2.e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.i, k);
        int i8 = 0;
        while (i8 < this.i.size() && (recyclerView = (cVar = this.i.get(i8)).d) != null) {
            RecyclerView.a0 c2 = c(recyclerView, cVar.e, cVar.f2231a ? Long.MAX_VALUE : j2);
            if (!(c2 == null || c2.mNestedRecyclerView == null || !c2.isBound() || c2.isInvalid() || (recyclerView2 = c2.mNestedRecyclerView.get()) == null)) {
                if (recyclerView2.J && recyclerView2.j.h() != 0) {
                    recyclerView2.d0();
                }
                b bVar2 = recyclerView2.m0;
                bVar2.b(recyclerView2, true);
                if (bVar2.d != 0) {
                    try {
                        int i9 = y6.f4005a;
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.x xVar = recyclerView2.n0;
                        RecyclerView.e eVar = recyclerView2.q;
                        xVar.d = 1;
                        xVar.e = eVar.getItemCount();
                        xVar.g = false;
                        xVar.h = false;
                        xVar.i = false;
                        for (int i10 = 0; i10 < bVar2.d * 2; i10 += 2) {
                            c(recyclerView2, bVar2.c[i10], j2);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        int i11 = y6.f4005a;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            cVar.f2231a = false;
            cVar.b = 0;
            cVar.c = 0;
            cVar.d = null;
            cVar.e = 0;
            i8++;
        }
    }

    public final RecyclerView.a0 c(RecyclerView recyclerView, int i2, long j2) {
        boolean z;
        int h2 = recyclerView.j.h();
        int i3 = 0;
        while (true) {
            if (i3 >= h2) {
                z = false;
                break;
            }
            RecyclerView.a0 K = RecyclerView.K(recyclerView.j.g(i3));
            if (K.mPosition == i2 && !K.isInvalid()) {
                z = true;
                break;
            }
            i3++;
        }
        if (z) {
            return null;
        }
        RecyclerView.t tVar = recyclerView.g;
        try {
            recyclerView.U();
            RecyclerView.a0 k2 = tVar.k(i2, false, j2);
            if (k2 != null) {
                if (!k2.isBound() || k2.isInvalid()) {
                    tVar.a(k2, false);
                } else {
                    tVar.h(k2.itemView);
                }
            }
            return k2;
        } finally {
            recyclerView.V(false);
        }
    }

    public void run() {
        try {
            int i2 = y6.f4005a;
            Trace.beginSection("RV Prefetch");
            if (this.f.isEmpty()) {
                this.g = 0;
                Trace.endSection();
                return;
            }
            int size = this.f.size();
            long j2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                RecyclerView recyclerView = this.f.get(i3);
                if (recyclerView.getWindowVisibility() == 0) {
                    j2 = Math.max(recyclerView.getDrawingTime(), j2);
                }
            }
            if (j2 == 0) {
                this.g = 0;
                Trace.endSection();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j2) + this.h);
            this.g = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.g = 0;
            int i4 = y6.f4005a;
            Trace.endSection();
            throw th;
        }
    }
}
