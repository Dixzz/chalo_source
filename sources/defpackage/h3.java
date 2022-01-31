package defpackage;

import defpackage.d3;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: h3  reason: default package */
/* compiled from: PriorityGoalRow */
public class h3 extends d3 {
    public int f = 128;
    public i3[] g = new i3[128];
    public i3[] h = new i3[128];
    public int i = 0;
    public b j = new b(this);

    /* renamed from: h3$a */
    /* compiled from: PriorityGoalRow */
    public class a implements Comparator<i3>, j$.util.Comparator {
        public a(h3 h3Var) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(i3 i3Var, i3 i3Var2) {
            return i3Var.b - i3Var2.b;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<i3> reversed() {
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
        public /* synthetic */ java.util.Comparator<i3> thenComparing(java.util.Comparator<? super i3> comparator) {
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

    /* renamed from: h3$b */
    /* compiled from: PriorityGoalRow */
    public class b implements Comparable {
        public i3 f;

        public b(h3 h3Var) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f.b - ((i3) obj).b;
        }

        public String toString() {
            String str = "[ ";
            if (this.f != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder i0 = hj1.i0(str);
                    i0.append(this.f.h[i]);
                    i0.append(" ");
                    str = i0.toString();
                }
            }
            StringBuilder k0 = hj1.k0(str, "] ");
            k0.append(this.f);
            return k0.toString();
        }
    }

    public h3(e3 e3Var) {
        super(e3Var);
    }

    @Override // defpackage.f3.a, defpackage.d3
    public void a(i3 i3Var) {
        this.j.f = i3Var;
        Arrays.fill(i3Var.h, 0.0f);
        i3Var.h[i3Var.d] = 1.0f;
        m(i3Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r8 < r7) goto L_0x0057;
     */
    @Override // defpackage.f3.a, defpackage.d3
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.i3 b(defpackage.f3 r11, boolean[] r12) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h3.b(f3, boolean[]):i3");
    }

    @Override // defpackage.f3.a, defpackage.d3
    public void clear() {
        this.i = 0;
        this.b = 0.0f;
    }

    @Override // defpackage.d3
    public void l(d3 d3Var, boolean z) {
        i3 i3Var = d3Var.f781a;
        if (i3Var != null) {
            d3.a aVar = d3Var.d;
            int a2 = aVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                i3 b2 = aVar.b(i2);
                float d = aVar.d(i2);
                b bVar = this.j;
                bVar.f = b2;
                boolean z2 = true;
                if (b2.f1468a) {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float[] fArr = bVar.f.h;
                        fArr[i3] = (i3Var.h[i3] * d) + fArr[i3];
                        if (Math.abs(fArr[i3]) < 1.0E-4f) {
                            bVar.f.h[i3] = 0.0f;
                        } else {
                            z2 = false;
                        }
                    }
                    if (z2) {
                        h3.this.n(bVar.f);
                    }
                    z2 = false;
                } else {
                    for (int i4 = 0; i4 < 9; i4++) {
                        float f2 = i3Var.h[i4];
                        if (f2 != 0.0f) {
                            float f3 = f2 * d;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            bVar.f.h[i4] = f3;
                        } else {
                            bVar.f.h[i4] = 0.0f;
                        }
                    }
                }
                if (z2) {
                    m(b2);
                }
                this.b = (d3Var.b * d) + this.b;
            }
            n(i3Var);
        }
    }

    public final void m(i3 i3Var) {
        int i2;
        int i3 = this.i + 1;
        i3[] i3VarArr = this.g;
        if (i3 > i3VarArr.length) {
            i3[] i3VarArr2 = (i3[]) Arrays.copyOf(i3VarArr, i3VarArr.length * 2);
            this.g = i3VarArr2;
            this.h = (i3[]) Arrays.copyOf(i3VarArr2, i3VarArr2.length * 2);
        }
        i3[] i3VarArr3 = this.g;
        int i4 = this.i;
        i3VarArr3[i4] = i3Var;
        int i5 = i4 + 1;
        this.i = i5;
        if (i5 > 1 && i3VarArr3[i5 - 1].b > i3Var.b) {
            int i6 = 0;
            while (true) {
                i2 = this.i;
                if (i6 >= i2) {
                    break;
                }
                this.h[i6] = this.g[i6];
                i6++;
            }
            Arrays.sort(this.h, 0, i2, new a(this));
            for (int i7 = 0; i7 < this.i; i7++) {
                this.g[i7] = this.h[i7];
            }
        }
        i3Var.f1468a = true;
        i3Var.a(this);
    }

    public final void n(i3 i3Var) {
        int i2 = 0;
        while (i2 < this.i) {
            if (this.g[i2] == i3Var) {
                while (true) {
                    int i3 = this.i;
                    if (i2 < i3 - 1) {
                        i3[] i3VarArr = this.g;
                        int i4 = i2 + 1;
                        i3VarArr[i2] = i3VarArr[i4];
                        i2 = i4;
                    } else {
                        this.i = i3 - 1;
                        i3Var.f1468a = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // defpackage.d3
    public String toString() {
        StringBuilder k0 = hj1.k0("", " goal -> (");
        k0.append(this.b);
        k0.append(") : ");
        String sb = k0.toString();
        for (int i2 = 0; i2 < this.i; i2++) {
            this.j.f = this.g[i2];
            StringBuilder i0 = hj1.i0(sb);
            i0.append(this.j);
            i0.append(" ");
            sb = i0.toString();
        }
        return sb;
    }
}
