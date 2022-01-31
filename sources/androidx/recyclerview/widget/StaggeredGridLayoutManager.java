package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.lk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;

public class StaggeredGridLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
    public uk A;
    public int B;
    public int C;
    public final mk D;
    public boolean E;
    public boolean F;
    public BitSet G;
    public int H;
    public int I;
    public LazySpanLookup J;
    public int K;
    public boolean L;
    public boolean M;
    public SavedState N;
    public int O;
    public final Rect P;
    public final b Q;
    public boolean R;
    public int[] S;
    public final Runnable T;
    public int x = -1;
    public d[] y;
    public uk z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public int g;
        public int h;
        public int[] i;
        public int j;
        public int[] k;
        public List<LazySpanLookup.FullSpanItem> l;
        public boolean m;
        public boolean n;
        public boolean o;

        public class a implements Parcelable.Creator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            if (this.h > 0) {
                parcel.writeIntArray(this.i);
            }
            parcel.writeInt(this.j);
            if (this.j > 0) {
                parcel.writeIntArray(this.k);
            }
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
            parcel.writeInt(this.o ? 1 : 0);
            parcel.writeList(this.l);
        }

        public SavedState(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            int readInt = parcel.readInt();
            this.h = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.i = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.j = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.k = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.m = parcel.readInt() == 1;
            this.n = parcel.readInt() == 1;
            this.o = parcel.readInt() == 1 ? true : z;
            this.l = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.h = savedState.h;
            this.f = savedState.f;
            this.g = savedState.g;
            this.i = savedState.i;
            this.j = savedState.j;
            this.k = savedState.k;
            this.m = savedState.m;
            this.n = savedState.n;
            this.o = savedState.o;
            this.l = savedState.l;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.m1();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f246a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int[] f;

        public b() {
            b();
        }

        public void a() {
            int i;
            if (this.c) {
                i = StaggeredGridLayoutManager.this.z.g();
            } else {
                i = StaggeredGridLayoutManager.this.z.k();
            }
            this.b = i;
        }

        public void b() {
            this.f246a = -1;
            this.b = RtlSpacingHelper.UNDEFINED;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.n {
        public d j;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f247a = new ArrayList<>();
        public int b = RtlSpacingHelper.UNDEFINED;
        public int c = RtlSpacingHelper.UNDEFINED;
        public int d = 0;
        public final int e;

        public d(int i) {
            this.e = i;
        }

        public void a(View view) {
            c j = j(view);
            j.j = this;
            this.f247a.add(view);
            this.c = RtlSpacingHelper.UNDEFINED;
            if (this.f247a.size() == 1) {
                this.b = RtlSpacingHelper.UNDEFINED;
            }
            if (j.c() || j.b()) {
                this.d = StaggeredGridLayoutManager.this.z.c(view) + this.d;
            }
        }

        public void b() {
            ArrayList<View> arrayList = this.f247a;
            View view = arrayList.get(arrayList.size() - 1);
            c j = j(view);
            this.c = StaggeredGridLayoutManager.this.z.b(view);
            Objects.requireNonNull(j);
        }

        public void c() {
            View view = this.f247a.get(0);
            c j = j(view);
            this.b = StaggeredGridLayoutManager.this.z.e(view);
            Objects.requireNonNull(j);
        }

        public void d() {
            this.f247a.clear();
            this.b = RtlSpacingHelper.UNDEFINED;
            this.c = RtlSpacingHelper.UNDEFINED;
            this.d = 0;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.E) {
                return g(this.f247a.size() - 1, -1, true);
            }
            return g(0, this.f247a.size(), true);
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.E) {
                return g(0, this.f247a.size(), true);
            }
            return g(this.f247a.size() - 1, -1, true);
        }

        public int g(int i, int i2, boolean z) {
            int k = StaggeredGridLayoutManager.this.z.k();
            int g = StaggeredGridLayoutManager.this.z.g();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f247a.get(i);
                int e2 = StaggeredGridLayoutManager.this.z.e(view);
                int b2 = StaggeredGridLayoutManager.this.z.b(view);
                boolean z2 = false;
                boolean z3 = !z ? e2 < g : e2 <= g;
                if (!z ? b2 > k : b2 >= k) {
                    z2 = true;
                }
                if (z3 && z2 && (e2 < k || b2 > g)) {
                    return StaggeredGridLayoutManager.this.a0(view);
                }
                i += i3;
            }
            return -1;
        }

        public int h(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f247a.size() == 0) {
                return i;
            }
            b();
            return this.c;
        }

        public View i(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f247a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f247a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.E && staggeredGridLayoutManager.a0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.E && staggeredGridLayoutManager2.a0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f247a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f247a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.E && staggeredGridLayoutManager3.a0(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.E && staggeredGridLayoutManager4.a0(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public c j(View view) {
            return (c) view.getLayoutParams();
        }

        public int k(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f247a.size() == 0) {
                return i;
            }
            c();
            return this.b;
        }

        public void l() {
            int size = this.f247a.size();
            View remove = this.f247a.remove(size - 1);
            c j = j(remove);
            j.j = null;
            if (j.c() || j.b()) {
                this.d -= StaggeredGridLayoutManager.this.z.c(remove);
            }
            if (size == 1) {
                this.b = RtlSpacingHelper.UNDEFINED;
            }
            this.c = RtlSpacingHelper.UNDEFINED;
        }

        public void m() {
            View remove = this.f247a.remove(0);
            c j = j(remove);
            j.j = null;
            if (this.f247a.size() == 0) {
                this.c = RtlSpacingHelper.UNDEFINED;
            }
            if (j.c() || j.b()) {
                this.d -= StaggeredGridLayoutManager.this.z.c(remove);
            }
            this.b = RtlSpacingHelper.UNDEFINED;
        }

        public void n(View view) {
            c j = j(view);
            j.j = this;
            this.f247a.add(0, view);
            this.b = RtlSpacingHelper.UNDEFINED;
            if (this.f247a.size() == 1) {
                this.c = RtlSpacingHelper.UNDEFINED;
            }
            if (j.c() || j.b()) {
                this.d = StaggeredGridLayoutManager.this.z.c(view) + this.d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.E = false;
        this.F = false;
        this.H = -1;
        this.I = RtlSpacingHelper.UNDEFINED;
        this.J = new LazySpanLookup();
        this.K = 2;
        this.P = new Rect();
        this.Q = new b();
        this.R = true;
        this.T = new a();
        RecyclerView.m.d b0 = RecyclerView.m.b0(context, attributeSet, i, i2);
        int i3 = b0.f237a;
        if (i3 == 0 || i3 == 1) {
            n(null);
            if (i3 != this.B) {
                this.B = i3;
                uk ukVar = this.z;
                this.z = this.A;
                this.A = ukVar;
                W0();
            }
            int i4 = b0.b;
            n(null);
            if (i4 != this.x) {
                this.J.a();
                W0();
                this.x = i4;
                this.G = new BitSet(this.x);
                this.y = new d[this.x];
                for (int i5 = 0; i5 < this.x; i5++) {
                    this.y[i5] = new d(i5);
                }
                W0();
            }
            boolean z2 = b0.c;
            n(null);
            SavedState savedState = this.N;
            if (!(savedState == null || savedState.m == z2)) {
                savedState.m = z2;
            }
            this.E = z2;
            W0();
            this.D = new mk();
            this.z = uk.a(this, this.B);
            this.A = uk.a(this, 1 - this.B);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int A(RecyclerView.x xVar) {
        return p1(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void A0(RecyclerView recyclerView, int i, int i2) {
        z1(i, i2, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
        if (r10 == r11) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cd, code lost:
        if (r10 == r11) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d1, code lost:
        r10 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0098 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View A1() {
        /*
        // Method dump skipped, instructions count: 245
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A1():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void B0(RecyclerView recyclerView) {
        this.J.a();
        W0();
    }

    public boolean B1() {
        return W() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void C0(RecyclerView recyclerView, int i, int i2, int i3) {
        z1(i, i2, 8);
    }

    public final void C1(View view, int i, int i2, boolean z2) {
        boolean z3;
        o(view, this.P);
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.P;
        int P1 = P1(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.P;
        int P12 = P1(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z2) {
            z3 = h1(view, P1, P12, cVar);
        } else {
            z3 = f1(view, P1, P12, cVar);
        }
        if (z3) {
            view.measure(P1, P12);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void D0(RecyclerView recyclerView, int i, int i2) {
        z1(i, i2, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0417, code lost:
        if (m1() != false) goto L_0x041b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D1(androidx.recyclerview.widget.RecyclerView.t r12, androidx.recyclerview.widget.RecyclerView.x r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 1081
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.D1(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, boolean):void");
    }

    public final boolean E1(int i) {
        if (this.B == 0) {
            if ((i == -1) != this.F) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.F) == B1()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n F() {
        if (this.B == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void F0(RecyclerView recyclerView, int i, int i2, Object obj) {
        z1(i, i2, 4);
    }

    public void F1(int i, RecyclerView.x xVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = w1();
            i2 = 1;
        } else {
            i3 = v1();
            i2 = -1;
        }
        this.D.f2388a = true;
        N1(i3, xVar);
        L1(i2);
        mk mkVar = this.D;
        mkVar.c = i3 + mkVar.d;
        mkVar.b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n G(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void G0(RecyclerView.t tVar, RecyclerView.x xVar) {
        D1(tVar, xVar, true);
    }

    public final void G1(RecyclerView.t tVar, mk mkVar) {
        int i;
        int i2;
        if (mkVar.f2388a && !mkVar.i) {
            if (mkVar.b != 0) {
                int i3 = 1;
                if (mkVar.e == -1) {
                    int i4 = mkVar.f;
                    int k = this.y[0].k(i4);
                    while (i3 < this.x) {
                        int k2 = this.y[i3].k(i4);
                        if (k2 > k) {
                            k = k2;
                        }
                        i3++;
                    }
                    int i5 = i4 - k;
                    if (i5 < 0) {
                        i2 = mkVar.g;
                    } else {
                        i2 = mkVar.g - Math.min(i5, mkVar.b);
                    }
                    H1(tVar, i2);
                    return;
                }
                int i6 = mkVar.g;
                int h = this.y[0].h(i6);
                while (i3 < this.x) {
                    int h2 = this.y[i3].h(i6);
                    if (h2 < h) {
                        h = h2;
                    }
                    i3++;
                }
                int i7 = h - mkVar.g;
                if (i7 < 0) {
                    i = mkVar.f;
                } else {
                    i = Math.min(i7, mkVar.b) + mkVar.f;
                }
                I1(tVar, i);
            } else if (mkVar.e == -1) {
                H1(tVar, mkVar.g);
            } else {
                I1(tVar, mkVar.f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n H(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void H0(RecyclerView.x xVar) {
        this.H = -1;
        this.I = RtlSpacingHelper.UNDEFINED;
        this.N = null;
        this.Q.b();
    }

    public final void H1(RecyclerView.t tVar, int i) {
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            View J2 = J(K2);
            if (this.z.e(J2) >= i && this.z.o(J2) >= i) {
                c cVar = (c) J2.getLayoutParams();
                Objects.requireNonNull(cVar);
                if (cVar.j.f247a.size() != 1) {
                    cVar.j.l();
                    T0(J2, tVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void I1(RecyclerView.t tVar, int i) {
        while (K() > 0) {
            View J2 = J(0);
            if (this.z.b(J2) <= i && this.z.n(J2) <= i) {
                c cVar = (c) J2.getLayoutParams();
                Objects.requireNonNull(cVar);
                if (cVar.j.f247a.size() != 1) {
                    cVar.j.m();
                    T0(J2, tVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void J1() {
        if (this.B == 1 || !B1()) {
            this.F = this.E;
        } else {
            this.F = !this.E;
        }
    }

    public int K1(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (K() == 0 || i == 0) {
            return 0;
        }
        F1(i, xVar);
        int q1 = q1(tVar, this.D, xVar);
        if (this.D.b >= q1) {
            i = i < 0 ? -q1 : q1;
        }
        this.z.p(-i);
        this.L = this.F;
        mk mkVar = this.D;
        mkVar.b = 0;
        G1(tVar, mkVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void L0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.N = savedState;
            if (this.H != -1) {
                savedState.i = null;
                savedState.h = 0;
                savedState.f = -1;
                savedState.g = -1;
                savedState.i = null;
                savedState.h = 0;
                savedState.j = 0;
                savedState.k = null;
                savedState.l = null;
            }
            W0();
        }
    }

    public final void L1(int i) {
        mk mkVar = this.D;
        mkVar.e = i;
        int i2 = 1;
        if (this.F != (i == -1)) {
            i2 = -1;
        }
        mkVar.d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable M0() {
        int i;
        View view;
        int i2;
        int i3;
        int[] iArr;
        SavedState savedState = this.N;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.m = this.E;
        savedState2.n = this.L;
        savedState2.o = this.M;
        LazySpanLookup lazySpanLookup = this.J;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f245a) == null) {
            savedState2.j = 0;
        } else {
            savedState2.k = iArr;
            savedState2.j = iArr.length;
            savedState2.l = lazySpanLookup.b;
        }
        int i4 = -1;
        if (K() > 0) {
            if (this.L) {
                i = w1();
            } else {
                i = v1();
            }
            savedState2.f = i;
            if (this.F) {
                view = r1(true);
            } else {
                view = s1(true);
            }
            if (view != null) {
                i4 = a0(view);
            }
            savedState2.g = i4;
            int i5 = this.x;
            savedState2.h = i5;
            savedState2.i = new int[i5];
            for (int i6 = 0; i6 < this.x; i6++) {
                if (this.L) {
                    i2 = this.y[i6].h(RtlSpacingHelper.UNDEFINED);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.z.g();
                    } else {
                        savedState2.i[i6] = i2;
                    }
                } else {
                    i2 = this.y[i6].k(RtlSpacingHelper.UNDEFINED);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.z.k();
                    } else {
                        savedState2.i[i6] = i2;
                    }
                }
                i2 -= i3;
                savedState2.i[i6] = i2;
            }
        } else {
            savedState2.f = -1;
            savedState2.g = -1;
            savedState2.h = 0;
        }
        return savedState2;
    }

    public final void M1(int i, int i2) {
        for (int i3 = 0; i3 < this.x; i3++) {
            if (!this.y[i3].f247a.isEmpty()) {
                O1(this.y[i3], i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void N0(int i) {
        if (i == 0) {
            m1();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void N1(int r5, androidx.recyclerview.widget.RecyclerView.x r6) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.N1(int, androidx.recyclerview.widget.RecyclerView$x):void");
    }

    public final void O1(d dVar, int i, int i2) {
        int i3 = dVar.d;
        if (i == -1) {
            int i4 = dVar.b;
            if (i4 == Integer.MIN_VALUE) {
                dVar.c();
                i4 = dVar.b;
            }
            if (i4 + i3 <= i2) {
                this.G.set(dVar.e, false);
                return;
            }
            return;
        }
        int i5 = dVar.c;
        if (i5 == Integer.MIN_VALUE) {
            dVar.b();
            i5 = dVar.c;
        }
        if (i5 - i3 >= i2) {
            this.G.set(dVar.e, false);
        }
    }

    public final int P1(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int X0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        return K1(i, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void Y0(int i) {
        SavedState savedState = this.N;
        if (!(savedState == null || savedState.f == i)) {
            savedState.i = null;
            savedState.h = 0;
            savedState.f = -1;
            savedState.g = -1;
        }
        this.H = i;
        this.I = RtlSpacingHelper.UNDEFINED;
        W0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int Z0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        return K1(i, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    public PointF a(int i) {
        int l1 = l1(i);
        PointF pointF = new PointF();
        if (l1 == 0) {
            return null;
        }
        if (this.B == 0) {
            pointF.x = (float) l1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) l1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void c1(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.B == 1) {
            i4 = RecyclerView.m.s(i2, rect.height() + paddingBottom, Y());
            i3 = RecyclerView.m.s(i, (this.C * this.x) + paddingRight, Z());
        } else {
            i3 = RecyclerView.m.s(i, rect.width() + paddingRight, Z());
            i4 = RecyclerView.m.s(i2, (this.C * this.x) + paddingBottom, Y());
        }
        this.g.setMeasuredDimension(i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean h0() {
        return this.K != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i1(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        nk nkVar = new nk(recyclerView.getContext());
        nkVar.f242a = i;
        j1(nkVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean k1() {
        return this.N == null;
    }

    public final int l1(int i) {
        if (K() != 0) {
            if ((i < v1()) != this.F) {
                return -1;
            }
            return 1;
        } else if (this.F) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void m0(int i) {
        super.m0(i);
        for (int i2 = 0; i2 < this.x; i2++) {
            d dVar = this.y[i2];
            int i3 = dVar.b;
            if (i3 != Integer.MIN_VALUE) {
                dVar.b = i3 + i;
            }
            int i4 = dVar.c;
            if (i4 != Integer.MIN_VALUE) {
                dVar.c = i4 + i;
            }
        }
    }

    public boolean m1() {
        int i;
        if (!(K() == 0 || this.K == 0 || !this.n)) {
            if (this.F) {
                i = w1();
                v1();
            } else {
                i = v1();
                w1();
            }
            if (i == 0 && A1() != null) {
                this.J.a();
                this.m = true;
                W0();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void n(String str) {
        RecyclerView recyclerView;
        if (this.N == null && (recyclerView = this.g) != null) {
            recyclerView.h(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void n0(int i) {
        super.n0(i);
        for (int i2 = 0; i2 < this.x; i2++) {
            d dVar = this.y[i2];
            int i3 = dVar.b;
            if (i3 != Integer.MIN_VALUE) {
                dVar.b = i3 + i;
            }
            int i4 = dVar.c;
            if (i4 != Integer.MIN_VALUE) {
                dVar.c = i4 + i;
            }
        }
    }

    public final int n1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        return h.t(xVar, this.z, s1(!this.R), r1(!this.R), this, this.R);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void o0(RecyclerView.e eVar, RecyclerView.e eVar2) {
        this.J.a();
        for (int i = 0; i < this.x; i++) {
            this.y[i].d();
        }
    }

    public final int o1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        return h.u(xVar, this.z, s1(!this.R), r1(!this.R), this, this.R, this.F);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean p() {
        return this.B == 0;
    }

    public final int p1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        return h.v(xVar, this.z, s1(!this.R), r1(!this.R), this, this.R);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean q() {
        return this.B == 1;
    }

    public final int q1(RecyclerView.t tVar, mk mkVar, RecyclerView.x xVar) {
        int i;
        int i2;
        int i3;
        d dVar;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        this.G.set(0, this.x, true);
        if (this.D.i) {
            i = mkVar.e == 1 ? Integer.MAX_VALUE : RtlSpacingHelper.UNDEFINED;
        } else {
            if (mkVar.e == 1) {
                i11 = mkVar.g + mkVar.b;
            } else {
                i11 = mkVar.f - mkVar.b;
            }
            i = i11;
        }
        M1(mkVar.e, i);
        if (this.F) {
            i2 = this.z.g();
        } else {
            i2 = this.z.k();
        }
        boolean z3 = false;
        while (true) {
            int i12 = mkVar.c;
            if ((i12 >= 0 && i12 < xVar.b()) && (this.D.i || !this.G.isEmpty())) {
                View e = tVar.e(mkVar.c);
                mkVar.c += mkVar.d;
                c cVar = (c) e.getLayoutParams();
                int a2 = cVar.a();
                int[] iArr = this.J.f245a;
                int i13 = (iArr == null || a2 >= iArr.length) ? -1 : iArr[a2];
                if (i13 == -1) {
                    if (E1(mkVar.e)) {
                        i10 = this.x - 1;
                        i9 = -1;
                        i8 = -1;
                    } else {
                        i9 = this.x;
                        i10 = 0;
                        i8 = 1;
                    }
                    d dVar2 = null;
                    if (mkVar.e == 1) {
                        int k = this.z.k();
                        int i14 = Integer.MAX_VALUE;
                        while (i10 != i9) {
                            d dVar3 = this.y[i10];
                            int h = dVar3.h(k);
                            if (h < i14) {
                                dVar2 = dVar3;
                                i14 = h;
                            }
                            i10 += i8;
                        }
                    } else {
                        int g = this.z.g();
                        int i15 = RtlSpacingHelper.UNDEFINED;
                        while (i10 != i9) {
                            d dVar4 = this.y[i10];
                            int k2 = dVar4.k(g);
                            if (k2 > i15) {
                                dVar2 = dVar4;
                                i15 = k2;
                            }
                            i10 += i8;
                        }
                    }
                    dVar = dVar2;
                    LazySpanLookup lazySpanLookup = this.J;
                    lazySpanLookup.b(a2);
                    lazySpanLookup.f245a[a2] = dVar.e;
                } else {
                    dVar = this.y[i13];
                }
                cVar.j = dVar;
                if (mkVar.e == 1) {
                    z2 = false;
                    m(e, -1, false);
                } else {
                    z2 = false;
                    m(e, 0, false);
                }
                if (this.B == 1) {
                    int i16 = this.C;
                    int i17 = this.t;
                    int i18 = ((ViewGroup.MarginLayoutParams) cVar).width;
                    int i19 = z2 ? 1 : 0;
                    int i20 = z2 ? 1 : 0;
                    int i21 = z2 ? 1 : 0;
                    C1(e, RecyclerView.m.L(i16, i17, i19, i18, z2), RecyclerView.m.L(this.w, this.u, getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
                } else {
                    C1(e, RecyclerView.m.L(this.v, this.t, getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.m.L(this.C, this.u, 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), false);
                }
                if (mkVar.e == 1) {
                    int h2 = dVar.h(i2);
                    i5 = h2;
                    i4 = this.z.c(e) + h2;
                } else {
                    int k3 = dVar.k(i2);
                    i4 = k3;
                    i5 = k3 - this.z.c(e);
                }
                if (mkVar.e == 1) {
                    cVar.j.a(e);
                } else {
                    cVar.j.n(e);
                }
                if (!B1() || this.B != 1) {
                    i6 = this.A.k() + (dVar.e * this.C);
                    i7 = this.A.c(e) + i6;
                } else {
                    i7 = this.A.g() - (((this.x - 1) - dVar.e) * this.C);
                    i6 = i7 - this.A.c(e);
                }
                if (this.B == 1) {
                    l0(e, i6, i5, i7, i4);
                } else {
                    l0(e, i5, i6, i4, i7);
                }
                O1(dVar, this.D.e, i);
                G1(tVar, this.D);
                if (this.D.h && e.hasFocusable()) {
                    this.G.set(dVar.e, false);
                }
                z3 = true;
            }
        }
        if (!z3) {
            G1(tVar, this.D);
        }
        if (this.D.e == -1) {
            i3 = this.z.k() - y1(this.z.k());
        } else {
            i3 = x1(this.z.g()) - this.z.g();
        }
        if (i3 > 0) {
            return Math.min(mkVar.b, i3);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean r(RecyclerView.n nVar) {
        return nVar instanceof c;
    }

    public View r1(boolean z2) {
        int k = this.z.k();
        int g = this.z.g();
        View view = null;
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            View J2 = J(K2);
            int e = this.z.e(J2);
            int b2 = this.z.b(J2);
            if (b2 > k && e < g) {
                if (b2 <= g || !z2) {
                    return J2;
                }
                if (view == null) {
                    view = J2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView recyclerView, RecyclerView.t tVar) {
        r0();
        Runnable runnable = this.T;
        RecyclerView recyclerView2 = this.g;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i = 0; i < this.x; i++) {
            this.y[i].d();
        }
        recyclerView.requestLayout();
    }

    public View s1(boolean z2) {
        int k = this.z.k();
        int g = this.z.g();
        int K2 = K();
        View view = null;
        for (int i = 0; i < K2; i++) {
            View J2 = J(i);
            int e = this.z.e(J2);
            if (this.z.b(J2) > k && e < g) {
                if (e >= k || !z2) {
                    return J2;
                }
                if (view == null) {
                    view = J2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void t(int i, int i2, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        int i3;
        int i4;
        if (this.B != 0) {
            i = i2;
        }
        if (!(K() == 0 || i == 0)) {
            F1(i, xVar);
            int[] iArr = this.S;
            if (iArr == null || iArr.length < this.x) {
                this.S = new int[this.x];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.x; i6++) {
                mk mkVar = this.D;
                if (mkVar.d == -1) {
                    i4 = mkVar.f;
                    i3 = this.y[i6].k(i4);
                } else {
                    i4 = this.y[i6].h(mkVar.g);
                    i3 = this.D.g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.S[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.S, 0, i5);
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = this.D.c;
                if (i9 >= 0 && i9 < xVar.b()) {
                    ((lk.b) cVar).a(this.D.c, this.S[i8]);
                    mk mkVar2 = this.D;
                    mkVar2.c += mkVar2.d;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if (r8.B == 1) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        if (r8.B == 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (B1() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        if (B1() == false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0060  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View t0(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.t r11, androidx.recyclerview.widget.RecyclerView.x r12) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.t0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x):android.view.View");
    }

    public final void t1(RecyclerView.t tVar, RecyclerView.x xVar, boolean z2) {
        int g;
        int x1 = x1(RtlSpacingHelper.UNDEFINED);
        if (x1 != Integer.MIN_VALUE && (g = this.z.g() - x1) > 0) {
            int i = g - (-K1(-g, tVar, xVar));
            if (z2 && i > 0) {
                this.z.p(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void u0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.t tVar = this.g.g;
        v0(accessibilityEvent);
        if (K() > 0) {
            View s1 = s1(false);
            View r1 = r1(false);
            if (s1 != null && r1 != null) {
                int a0 = a0(s1);
                int a02 = a0(r1);
                if (a0 < a02) {
                    accessibilityEvent.setFromIndex(a0);
                    accessibilityEvent.setToIndex(a02);
                    return;
                }
                accessibilityEvent.setFromIndex(a02);
                accessibilityEvent.setToIndex(a0);
            }
        }
    }

    public final void u1(RecyclerView.t tVar, RecyclerView.x xVar, boolean z2) {
        int k;
        int y1 = y1(Integer.MAX_VALUE);
        if (y1 != Integer.MAX_VALUE && (k = y1 - this.z.k()) > 0) {
            int K1 = k - K1(k, tVar, xVar);
            if (z2 && K1 > 0) {
                this.z.p(-K1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int v(RecyclerView.x xVar) {
        return n1(xVar);
    }

    public int v1() {
        if (K() == 0) {
            return 0;
        }
        return a0(J(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int w(RecyclerView.x xVar) {
        return o1(xVar);
    }

    public int w1() {
        int K2 = K();
        if (K2 == 0) {
            return 0;
        }
        return a0(J(K2 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int x(RecyclerView.x xVar) {
        return p1(xVar);
    }

    public final int x1(int i) {
        int h = this.y[0].h(i);
        for (int i2 = 1; i2 < this.x; i2++) {
            int h2 = this.y[i2].h(i);
            if (h2 > h) {
                h = h2;
            }
        }
        return h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int y(RecyclerView.x xVar) {
        return n1(xVar);
    }

    public final int y1(int i) {
        int k = this.y[0].k(i);
        for (int i2 = 1; i2 < this.x; i2++) {
            int k2 = this.y[i2].k(i);
            if (k2 < k) {
                k = k2;
            }
        }
        return k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int z(RecyclerView.x xVar) {
        return o1(xVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z1(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.F
            if (r0 == 0) goto L_0x0009
            int r0 = r6.w1()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.v1()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.J
            r4.d(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.J
            r9.f(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.J
            r7.e(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.J
            r9.f(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.J
            r9.e(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.F
            if (r7 == 0) goto L_0x004d
            int r7 = r6.v1()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.w1()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.W0()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.z1(int, int, int):void");
    }

    public static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        public int[] f245a;
        public List<FullSpanItem> b;

        public void a() {
            int[] iArr = this.f245a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        public void b(int i) {
            int[] iArr = this.f245a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.f245a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f245a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f245a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public FullSpanItem c(int i) {
            List<FullSpanItem> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.b.get(size);
                if (fullSpanItem.f == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.f245a
                r1 = -1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                int r0 = r0.length
                if (r5 < r0) goto L_0x000a
                return r1
            L_0x000a:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.b
                if (r0 != 0) goto L_0x0010
            L_0x000e:
                r0 = -1
                goto L_0x0046
            L_0x0010:
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = r4.c(r5)
                if (r0 == 0) goto L_0x001b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r2 = r4.b
                r2.remove(r0)
            L_0x001b:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.b
                int r0 = r0.size()
                r2 = 0
            L_0x0022:
                if (r2 >= r0) goto L_0x0034
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r4.b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r3 = r3.f
                if (r3 < r5) goto L_0x0031
                goto L_0x0035
            L_0x0031:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0034:
                r2 = -1
            L_0x0035:
                if (r2 == r1) goto L_0x000e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r4.b
                r3.remove(r2)
                int r0 = r0.f
            L_0x0046:
                if (r0 != r1) goto L_0x0052
                int[] r0 = r4.f245a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r5, r2, r1)
                int[] r5 = r4.f245a
                int r5 = r5.length
                return r5
            L_0x0052:
                int r0 = r0 + 1
                int[] r2 = r4.f245a
                int r2 = r2.length
                int r0 = java.lang.Math.min(r0, r2)
                int[] r2 = r4.f245a
                java.util.Arrays.fill(r2, r5, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.d(int):int");
        }

        public void e(int i, int i2) {
            int[] iArr = this.f245a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                b(i3);
                int[] iArr2 = this.f245a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f245a, i, i3, -1);
                List<FullSpanItem> list = this.b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.b.get(size);
                        int i4 = fullSpanItem.f;
                        if (i4 >= i) {
                            fullSpanItem.f = i4 + i2;
                        }
                    }
                }
            }
        }

        public void f(int i, int i2) {
            int[] iArr = this.f245a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                b(i3);
                int[] iArr2 = this.f245a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f245a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                List<FullSpanItem> list = this.b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.b.get(size);
                        int i4 = fullSpanItem.f;
                        if (i4 >= i) {
                            if (i4 < i3) {
                                this.b.remove(size);
                            } else {
                                fullSpanItem.f = i4 - i2;
                            }
                        }
                    }
                }
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();
            public int f;
            public int g;
            public int[] h;
            public boolean i;

            public class a implements Parcelable.Creator<FullSpanItem> {
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f = parcel.readInt();
                this.g = parcel.readInt();
                this.i = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.h = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder i0 = hj1.i0("FullSpanItem{mPosition=");
                i0.append(this.f);
                i0.append(", mGapDir=");
                i0.append(this.g);
                i0.append(", mHasUnwantedGapAfter=");
                i0.append(this.i);
                i0.append(", mGapPerSpan=");
                i0.append(Arrays.toString(this.h));
                i0.append('}');
                return i0.toString();
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f);
                parcel.writeInt(this.g);
                parcel.writeInt(this.i ? 1 : 0);
                int[] iArr = this.h;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.h);
            }

            public FullSpanItem() {
            }
        }
    }
}
