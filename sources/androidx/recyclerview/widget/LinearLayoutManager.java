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
import com.rabbitmq.client.AMQP;
import defpackage.lk;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public SavedState H;
    public final a I;
    public final b J;
    public int K;
    public int[] L;
    public int x;
    public c y;
    public uk z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public int g;
        public boolean h;

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

        public boolean a() {
            return this.f >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.h = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f = savedState.f;
            this.g = savedState.g;
            this.h = savedState.h;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public uk f228a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        public a() {
            d();
        }

        public void a() {
            int i;
            if (this.d) {
                i = this.f228a.g();
            } else {
                i = this.f228a.k();
            }
            this.c = i;
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.f228a.m() + this.f228a.b(view);
            } else {
                this.c = this.f228a.e(view);
            }
            this.b = i;
        }

        public void c(View view, int i) {
            int m = this.f228a.m();
            if (m >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int g = (this.f228a.g() - m) - this.f228a.b(view);
                this.c = this.f228a.g() - g;
                if (g > 0) {
                    int c2 = this.c - this.f228a.c(view);
                    int k = this.f228a.k();
                    int min = c2 - (Math.min(this.f228a.e(view) - k, 0) + k);
                    if (min < 0) {
                        this.c = Math.min(g, -min) + this.c;
                        return;
                    }
                    return;
                }
                return;
            }
            int e2 = this.f228a.e(view);
            int k2 = e2 - this.f228a.k();
            this.c = e2;
            if (k2 > 0) {
                int g2 = (this.f228a.g() - Math.min(0, (this.f228a.g() - m) - this.f228a.b(view))) - (this.f228a.c(view) + e2);
                if (g2 < 0) {
                    this.c -= Math.min(k2, -g2);
                }
            }
        }

        public void d() {
            this.b = -1;
            this.c = RtlSpacingHelper.UNDEFINED;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("AnchorInfo{mPosition=");
            i0.append(this.b);
            i0.append(", mCoordinate=");
            i0.append(this.c);
            i0.append(", mLayoutFromEnd=");
            i0.append(this.d);
            i0.append(", mValid=");
            i0.append(this.e);
            i0.append('}');
            return i0.toString();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f229a;
        public boolean b;
        public boolean c;
        public boolean d;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f230a = true;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h = 0;
        public int i = 0;
        public int j;
        public List<RecyclerView.a0> k = null;
        public boolean l;

        public void a(View view) {
            int a2;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).itemView;
                RecyclerView.n nVar = (RecyclerView.n) view3.getLayoutParams();
                if (view3 != view && !nVar.c() && (a2 = (nVar.a() - this.d) * this.e) >= 0 && a2 < i2) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i2 = a2;
                }
            }
            if (view2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.n) view2.getLayoutParams()).a();
            }
        }

        public boolean b(RecyclerView.x xVar) {
            int i2 = this.d;
            return i2 >= 0 && i2 < xVar.b();
        }

        public View c(RecyclerView.t tVar) {
            List<RecyclerView.a0> list = this.k;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = this.k.get(i2).itemView;
                    RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
                    if (!nVar.c() && this.d == nVar.a()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View e2 = tVar.e(this.d);
            this.d += this.e;
            return e2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(1, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int A(RecyclerView.x xVar) {
        return p1(xVar);
    }

    public final int A1(int i, RecyclerView.t tVar, RecyclerView.x xVar, boolean z2) {
        int g;
        int g2 = this.z.g() - i;
        if (g2 <= 0) {
            return 0;
        }
        int i2 = -L1(-g2, tVar, xVar);
        int i3 = i + i2;
        if (!z2 || (g = this.z.g() - i3) <= 0) {
            return i2;
        }
        this.z.p(g);
        return g + i2;
    }

    public final int B1(int i, RecyclerView.t tVar, RecyclerView.x xVar, boolean z2) {
        int k;
        int k2 = i - this.z.k();
        if (k2 <= 0) {
            return 0;
        }
        int i2 = -L1(k2, tVar, xVar);
        int i3 = i + i2;
        if (!z2 || (k = i3 - this.z.k()) <= 0) {
            return i2;
        }
        this.z.p(-k);
        return i2 - k;
    }

    public final View C1() {
        return J(this.C ? 0 : K() - 1);
    }

    public final View D1() {
        return J(this.C ? K() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View E(int i) {
        int K2 = K();
        if (K2 == 0) {
            return null;
        }
        int a0 = i - a0(J(0));
        if (a0 >= 0 && a0 < K2) {
            View J2 = J(a0);
            if (a0(J2) == i) {
                return J2;
            }
        }
        return super.E(i);
    }

    public boolean E1() {
        return W() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n F() {
        return new RecyclerView.n(-2, -2);
    }

    public void F1(RecyclerView.t tVar, RecyclerView.x xVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View c2 = cVar.c(tVar);
        if (c2 == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.n nVar = (RecyclerView.n) c2.getLayoutParams();
        if (cVar.k == null) {
            if (this.C == (cVar.f == -1)) {
                m(c2, -1, false);
            } else {
                m(c2, 0, false);
            }
        } else {
            if (this.C == (cVar.f == -1)) {
                m(c2, -1, true);
            } else {
                m(c2, 0, true);
            }
        }
        RecyclerView.n nVar2 = (RecyclerView.n) c2.getLayoutParams();
        Rect L2 = this.g.L(c2);
        int L3 = RecyclerView.m.L(this.v, this.t, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) nVar2).leftMargin + ((ViewGroup.MarginLayoutParams) nVar2).rightMargin + L2.left + L2.right + 0, ((ViewGroup.MarginLayoutParams) nVar2).width, p());
        int L4 = RecyclerView.m.L(this.w, this.u, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) nVar2).topMargin + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin + L2.top + L2.bottom + 0, ((ViewGroup.MarginLayoutParams) nVar2).height, q());
        if (f1(c2, L3, L4, nVar2)) {
            c2.measure(L3, L4);
        }
        bVar.f229a = this.z.c(c2);
        if (this.x == 1) {
            if (E1()) {
                i5 = this.v - getPaddingRight();
                i4 = i5 - this.z.d(c2);
            } else {
                i4 = getPaddingLeft();
                i5 = this.z.d(c2) + i4;
            }
            if (cVar.f == -1) {
                int i6 = cVar.b;
                i = i6;
                i2 = i5;
                i3 = i6 - bVar.f229a;
            } else {
                int i7 = cVar.b;
                i3 = i7;
                i2 = i5;
                i = bVar.f229a + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int d = this.z.d(c2) + paddingTop;
            if (cVar.f == -1) {
                int i8 = cVar.b;
                i2 = i8;
                i3 = paddingTop;
                i = d;
                i4 = i8 - bVar.f229a;
            } else {
                int i9 = cVar.b;
                i3 = paddingTop;
                i2 = bVar.f229a + i9;
                i = d;
                i4 = i9;
            }
        }
        l0(c2, i4, i3, i2, i);
        if (nVar.c() || nVar.b()) {
            bVar.c = true;
        }
        bVar.d = c2.hasFocusable();
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0180  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G0(androidx.recyclerview.widget.RecyclerView.t r17, androidx.recyclerview.widget.RecyclerView.x r18) {
        /*
        // Method dump skipped, instructions count: 1060
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.G0(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x):void");
    }

    public void G1(RecyclerView.t tVar, RecyclerView.x xVar, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void H0(RecyclerView.x xVar) {
        this.H = null;
        this.F = -1;
        this.G = RtlSpacingHelper.UNDEFINED;
        this.I.d();
    }

    public final void H1(RecyclerView.t tVar, c cVar) {
        if (cVar.f230a && !cVar.l) {
            int i = cVar.g;
            int i2 = cVar.i;
            if (cVar.f == -1) {
                int K2 = K();
                if (i >= 0) {
                    int f = (this.z.f() - i) + i2;
                    if (this.C) {
                        for (int i3 = 0; i3 < K2; i3++) {
                            View J2 = J(i3);
                            if (this.z.e(J2) < f || this.z.o(J2) < f) {
                                I1(tVar, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    int i4 = K2 - 1;
                    for (int i5 = i4; i5 >= 0; i5--) {
                        View J3 = J(i5);
                        if (this.z.e(J3) < f || this.z.o(J3) < f) {
                            I1(tVar, i4, i5);
                            return;
                        }
                    }
                }
            } else if (i >= 0) {
                int i6 = i - i2;
                int K3 = K();
                if (this.C) {
                    int i7 = K3 - 1;
                    for (int i8 = i7; i8 >= 0; i8--) {
                        View J4 = J(i8);
                        if (this.z.b(J4) > i6 || this.z.n(J4) > i6) {
                            I1(tVar, i7, i8);
                            return;
                        }
                    }
                    return;
                }
                for (int i9 = 0; i9 < K3; i9++) {
                    View J5 = J(i9);
                    if (this.z.b(J5) > i6 || this.z.n(J5) > i6) {
                        I1(tVar, 0, i9);
                        return;
                    }
                }
            }
        }
    }

    public final void I1(RecyclerView.t tVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    U0(i3, tVar);
                }
                return;
            }
            while (i > i2) {
                U0(i, tVar);
                i--;
            }
        }
    }

    public boolean J1() {
        return this.z.i() == 0 && this.z.f() == 0;
    }

    public final void K1() {
        if (this.x == 1 || !E1()) {
            this.C = this.B;
        } else {
            this.C = !this.B;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void L0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.H = savedState;
            if (this.F != -1) {
                savedState.f = -1;
            }
            W0();
        }
    }

    public int L1(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (K() == 0 || i == 0) {
            return 0;
        }
        r1();
        this.y.f230a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        P1(i2, abs, true, xVar);
        c cVar = this.y;
        int s1 = s1(tVar, cVar, xVar, false) + cVar.g;
        if (s1 < 0) {
            return 0;
        }
        if (abs > s1) {
            i = i2 * s1;
        }
        this.z.p(-i);
        this.y.j = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable M0() {
        SavedState savedState = this.H;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (K() > 0) {
            r1();
            boolean z2 = this.A ^ this.C;
            savedState2.h = z2;
            if (z2) {
                View C1 = C1();
                savedState2.g = this.z.g() - this.z.b(C1);
                savedState2.f = a0(C1);
            } else {
                View D1 = D1();
                savedState2.f = a0(D1);
                savedState2.g = this.z.e(D1) - this.z.k();
            }
        } else {
            savedState2.f = -1;
        }
        return savedState2;
    }

    public void M1(int i) {
        if (i == 0 || i == 1) {
            n(null);
            if (i != this.x || this.z == null) {
                uk a2 = uk.a(this, i);
                this.z = a2;
                this.I.f228a = a2;
                this.x = i;
                W0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(hj1.I("invalid orientation:", i));
    }

    public void N1(boolean z2) {
        n(null);
        if (z2 != this.B) {
            this.B = z2;
            W0();
        }
    }

    public void O1(boolean z2) {
        n(null);
        if (this.D != z2) {
            this.D = z2;
            W0();
        }
    }

    public final void P1(int i, int i2, boolean z2, RecyclerView.x xVar) {
        int i3;
        this.y.l = J1();
        this.y.f = i;
        int[] iArr = this.L;
        boolean z3 = false;
        iArr[0] = 0;
        int i4 = 1;
        iArr[1] = 0;
        l1(xVar, iArr);
        int max = Math.max(0, this.L[0]);
        int max2 = Math.max(0, this.L[1]);
        if (i == 1) {
            z3 = true;
        }
        c cVar = this.y;
        int i5 = z3 ? max2 : max;
        cVar.h = i5;
        if (!z3) {
            max = max2;
        }
        cVar.i = max;
        if (z3) {
            cVar.h = this.z.h() + i5;
            View C1 = C1();
            c cVar2 = this.y;
            if (this.C) {
                i4 = -1;
            }
            cVar2.e = i4;
            int a0 = a0(C1);
            c cVar3 = this.y;
            cVar2.d = a0 + cVar3.e;
            cVar3.b = this.z.b(C1);
            i3 = this.z.b(C1) - this.z.g();
        } else {
            View D1 = D1();
            c cVar4 = this.y;
            cVar4.h = this.z.k() + cVar4.h;
            c cVar5 = this.y;
            if (!this.C) {
                i4 = -1;
            }
            cVar5.e = i4;
            int a02 = a0(D1);
            c cVar6 = this.y;
            cVar5.d = a02 + cVar6.e;
            cVar6.b = this.z.e(D1);
            i3 = (-this.z.e(D1)) + this.z.k();
        }
        c cVar7 = this.y;
        cVar7.c = i2;
        if (z2) {
            cVar7.c = i2 - i3;
        }
        cVar7.g = i3;
    }

    public final void Q1(int i, int i2) {
        this.y.c = this.z.g() - i2;
        c cVar = this.y;
        cVar.e = this.C ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.b = i2;
        cVar.g = RtlSpacingHelper.UNDEFINED;
    }

    public final void R1(int i, int i2) {
        this.y.c = i2 - this.z.k();
        c cVar = this.y;
        cVar.d = i;
        cVar.e = this.C ? 1 : -1;
        cVar.f = -1;
        cVar.b = i2;
        cVar.g = RtlSpacingHelper.UNDEFINED;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int X0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.x == 1) {
            return 0;
        }
        return L1(i, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void Y0(int i) {
        this.F = i;
        this.G = RtlSpacingHelper.UNDEFINED;
        SavedState savedState = this.H;
        if (savedState != null) {
            savedState.f = -1;
        }
        W0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int Z0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.x == 0) {
            return 0;
        }
        return L1(i, tVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    public PointF a(int i) {
        if (K() == 0) {
            return null;
        }
        boolean z2 = false;
        int i2 = 1;
        if (i < a0(J(0))) {
            z2 = true;
        }
        if (z2 != this.C) {
            i2 = -1;
        }
        if (this.x == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean g1() {
        boolean z2;
        if (!(this.u == 1073741824 || this.t == 1073741824)) {
            int K2 = K();
            int i = 0;
            while (true) {
                if (i >= K2) {
                    z2 = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = J(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean h0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i1(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        nk nkVar = new nk(recyclerView.getContext());
        nkVar.f242a = i;
        j1(nkVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean k1() {
        return this.H == null && this.A == this.D;
    }

    public void l1(RecyclerView.x xVar, int[] iArr) {
        int i;
        int l = xVar.f244a != -1 ? this.z.l() : 0;
        if (this.y.f == -1) {
            i = 0;
        } else {
            i = l;
            l = 0;
        }
        iArr[0] = l;
        iArr[1] = i;
    }

    public void m1(RecyclerView.x xVar, c cVar, RecyclerView.m.c cVar2) {
        int i = cVar.d;
        if (i >= 0 && i < xVar.b()) {
            ((lk.b) cVar2).a(i, Math.max(0, cVar.g));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void n(String str) {
        RecyclerView recyclerView;
        if (this.H == null && (recyclerView = this.g) != null) {
            recyclerView.h(str);
        }
    }

    public final int n1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        r1();
        return h.t(xVar, this.z, u1(!this.E, true), t1(!this.E, true), this, this.E);
    }

    public final int o1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        r1();
        return h.u(xVar, this.z, u1(!this.E, true), t1(!this.E, true), this, this.E, this.C);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean p() {
        return this.x == 0;
    }

    public final int p1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        r1();
        return h.v(xVar, this.z, u1(!this.E, true), t1(!this.E, true), this, this.E);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean q() {
        return this.x == 1;
    }

    public int q1(int i) {
        if (i == 1) {
            return (this.x != 1 && E1()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.x != 1 && E1()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i == 130 && this.x == 1) {
                        return 1;
                    }
                    return RtlSpacingHelper.UNDEFINED;
                } else if (this.x == 0) {
                    return 1;
                } else {
                    return RtlSpacingHelper.UNDEFINED;
                }
            } else if (this.x == 1) {
                return -1;
            } else {
                return RtlSpacingHelper.UNDEFINED;
            }
        } else if (this.x == 0) {
            return -1;
        } else {
            return RtlSpacingHelper.UNDEFINED;
        }
    }

    public void r1() {
        if (this.y == null) {
            this.y = new c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView recyclerView, RecyclerView.t tVar) {
        r0();
    }

    public int s1(RecyclerView.t tVar, c cVar, RecyclerView.x xVar, boolean z2) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            H1(tVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.J;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.b(xVar)) {
                break;
            }
            bVar.f229a = 0;
            bVar.b = false;
            bVar.c = false;
            bVar.d = false;
            F1(tVar, xVar, cVar, bVar);
            if (!bVar.b) {
                int i4 = cVar.b;
                int i5 = bVar.f229a;
                cVar.b = (cVar.f * i5) + i4;
                if (!bVar.c || cVar.k != null || !xVar.g) {
                    cVar.c -= i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + i5;
                    cVar.g = i7;
                    int i8 = cVar.c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    H1(tVar, cVar);
                }
                if (z2 && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void t(int i, int i2, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        if (this.x != 0) {
            i = i2;
        }
        if (K() != 0 && i != 0) {
            r1();
            P1(i > 0 ? 1 : -1, Math.abs(i), true, xVar);
            m1(xVar, this.y, cVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View t0(View view, int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        int q1;
        View view2;
        View view3;
        K1();
        if (K() == 0 || (q1 = q1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        r1();
        P1(q1, (int) (((float) this.z.l()) * 0.33333334f), false, xVar);
        c cVar = this.y;
        cVar.g = RtlSpacingHelper.UNDEFINED;
        cVar.f230a = false;
        s1(tVar, cVar, xVar, true);
        if (q1 == -1) {
            if (this.C) {
                view2 = x1(K() - 1, -1);
            } else {
                view2 = x1(0, K());
            }
        } else if (this.C) {
            view2 = x1(0, K());
        } else {
            view2 = x1(K() - 1, -1);
        }
        if (q1 == -1) {
            view3 = D1();
        } else {
            view3 = C1();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public View t1(boolean z2, boolean z3) {
        if (this.C) {
            return y1(0, K(), z2, z3);
        }
        return y1(K() - 1, -1, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void u(int i, RecyclerView.m.c cVar) {
        boolean z2;
        int i2;
        SavedState savedState = this.H;
        int i3 = -1;
        if (savedState == null || !savedState.a()) {
            K1();
            z2 = this.C;
            i2 = this.F;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.H;
            z2 = savedState2.h;
            i2 = savedState2.f;
        }
        if (!z2) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.K && i2 >= 0 && i2 < i; i4++) {
            ((lk.b) cVar).a(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void u0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.t tVar = this.g.g;
        v0(accessibilityEvent);
        if (K() > 0) {
            accessibilityEvent.setFromIndex(v1());
            accessibilityEvent.setToIndex(w1());
        }
    }

    public View u1(boolean z2, boolean z3) {
        if (this.C) {
            return y1(K() - 1, -1, z2, z3);
        }
        return y1(0, K(), z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int v(RecyclerView.x xVar) {
        return n1(xVar);
    }

    public int v1() {
        View y1 = y1(0, K(), false, true);
        if (y1 == null) {
            return -1;
        }
        return a0(y1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int w(RecyclerView.x xVar) {
        return o1(xVar);
    }

    public int w1() {
        View y1 = y1(K() - 1, -1, false, true);
        if (y1 == null) {
            return -1;
        }
        return a0(y1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int x(RecyclerView.x xVar) {
        return p1(xVar);
    }

    public View x1(int i, int i2) {
        int i3;
        int i4;
        r1();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return J(i);
        }
        if (this.z.e(J(i)) < this.z.k()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.x == 0) {
            return this.j.a(i, i2, i4, i3);
        }
        return this.k.a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int y(RecyclerView.x xVar) {
        return n1(xVar);
    }

    public View y1(int i, int i2, boolean z2, boolean z3) {
        r1();
        int i3 = AMQP.CONNECTION_FORCED;
        int i4 = z2 ? 24579 : AMQP.CONNECTION_FORCED;
        if (!z3) {
            i3 = 0;
        }
        if (this.x == 0) {
            return this.j.a(i, i2, i4, i3);
        }
        return this.k.a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int z(RecyclerView.x xVar) {
        return o1(xVar);
    }

    public View z1(RecyclerView.t tVar, RecyclerView.x xVar, boolean z2, boolean z3) {
        int i;
        int i2;
        r1();
        int K2 = K();
        int i3 = -1;
        if (z3) {
            i2 = K() - 1;
            i = -1;
        } else {
            i3 = K2;
            i2 = 0;
            i = 1;
        }
        int b2 = xVar.b();
        int k = this.z.k();
        int g = this.z.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i2 != i3) {
            View J2 = J(i2);
            int a0 = a0(J2);
            int e = this.z.e(J2);
            int b3 = this.z.b(J2);
            if (a0 >= 0 && a0 < b2) {
                if (!((RecyclerView.n) J2.getLayoutParams()).c()) {
                    boolean z4 = b3 <= k && e < k;
                    boolean z5 = e >= g && b3 > g;
                    if (!z4 && !z5) {
                        return J2;
                    }
                    if (z2) {
                        if (!z5) {
                            if (view != null) {
                            }
                            view = J2;
                        }
                    } else if (!z4) {
                        if (view != null) {
                        }
                        view = J2;
                    }
                    view2 = J2;
                } else if (view3 == null) {
                    view3 = J2;
                }
            }
            i2 += i;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    public LinearLayoutManager(int i, boolean z2) {
        this.x = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = RtlSpacingHelper.UNDEFINED;
        this.H = null;
        this.I = new a();
        this.J = new b();
        this.K = 2;
        this.L = new int[2];
        M1(i);
        N1(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.x = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = -1;
        this.G = RtlSpacingHelper.UNDEFINED;
        this.H = null;
        this.I = new a();
        this.J = new b();
        this.K = 2;
        this.L = new int[2];
        RecyclerView.m.d b0 = RecyclerView.m.b0(context, attributeSet, i, i2);
        M1(b0.f237a);
        N1(b0.c);
        O1(b0.d);
    }
}
