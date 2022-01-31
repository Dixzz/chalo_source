package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.ry1;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends RecyclerView.m implements py1, RecyclerView.w.b {
    public static final Rect V = new Rect();
    public int A = -1;
    public boolean B;
    public boolean C;
    public List<qy1> D = new ArrayList();
    public final ry1 E = new ry1(this);
    public RecyclerView.t F;
    public RecyclerView.x G;
    public c H;
    public b I = new b(null);
    public uk J;
    public uk K;
    public SavedState L;
    public int M = -1;
    public int N = RtlSpacingHelper.UNDEFINED;
    public int O = RtlSpacingHelper.UNDEFINED;
    public int P = RtlSpacingHelper.UNDEFINED;
    public SparseArray<View> Q = new SparseArray<>();
    public final Context R;
    public View S;
    public int T = -1;
    public ry1.b U = new ry1.b();
    public int x;
    public int y;
    public int z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int f;
        public int g;

        public static class a implements Parcelable.Creator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (a) null);
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

        public String toString() {
            StringBuilder i0 = hj1.i0("SavedState{mAnchorPosition=");
            i0.append(this.f);
            i0.append(", mAnchorOffset=");
            return hj1.W(i0, this.g, '}');
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public SavedState(Parcel parcel, a aVar) {
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        public SavedState(SavedState savedState, a aVar) {
            this.f = savedState.f;
            this.g = savedState.g;
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f600a;
        public int b;
        public int c;
        public int d = 0;
        public boolean e;
        public boolean f;
        public boolean g;

        public b(a aVar) {
        }

        public static void a(b bVar) {
            int i;
            int i2;
            if (!FlexboxLayoutManager.this.j()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                if (flexboxLayoutManager.B) {
                    if (bVar.e) {
                        i2 = flexboxLayoutManager.J.g();
                    } else {
                        i2 = flexboxLayoutManager.v - flexboxLayoutManager.J.k();
                    }
                    bVar.c = i2;
                    return;
                }
            }
            if (bVar.e) {
                i = FlexboxLayoutManager.this.J.g();
            } else {
                i = FlexboxLayoutManager.this.J.k();
            }
            bVar.c = i;
        }

        public static void b(b bVar) {
            bVar.f600a = -1;
            bVar.b = -1;
            bVar.c = RtlSpacingHelper.UNDEFINED;
            boolean z = false;
            bVar.f = false;
            bVar.g = false;
            if (FlexboxLayoutManager.this.j()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                int i = flexboxLayoutManager.y;
                if (i == 0) {
                    if (flexboxLayoutManager.x == 1) {
                        z = true;
                    }
                    bVar.e = z;
                    return;
                }
                if (i == 2) {
                    z = true;
                }
                bVar.e = z;
                return;
            }
            FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
            int i2 = flexboxLayoutManager2.y;
            if (i2 == 0) {
                if (flexboxLayoutManager2.x == 3) {
                    z = true;
                }
                bVar.e = z;
                return;
            }
            if (i2 == 2) {
                z = true;
            }
            bVar.e = z;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("AnchorInfo{mPosition=");
            i0.append(this.f600a);
            i0.append(", mFlexLinePosition=");
            i0.append(this.b);
            i0.append(", mCoordinate=");
            i0.append(this.c);
            i0.append(", mPerpendicularCoordinate=");
            i0.append(this.d);
            i0.append(", mLayoutFromEnd=");
            i0.append(this.e);
            i0.append(", mValid=");
            i0.append(this.f);
            i0.append(", mAssignedFromSavedState=");
            i0.append(this.g);
            i0.append('}');
            return i0.toString();
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f601a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h = 1;
        public int i = 1;
        public boolean j;

        public c(a aVar) {
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("LayoutState{mAvailable=");
            i0.append(this.f601a);
            i0.append(", mFlexLinePosition=");
            i0.append(this.c);
            i0.append(", mPosition=");
            i0.append(this.d);
            i0.append(", mOffset=");
            i0.append(this.e);
            i0.append(", mScrollingOffset=");
            i0.append(this.f);
            i0.append(", mLastScrollDelta=");
            i0.append(this.g);
            i0.append(", mItemDirection=");
            i0.append(this.h);
            i0.append(", mLayoutDirection=");
            return hj1.W(i0, this.i, '}');
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.m.d b0 = RecyclerView.m.b0(context, attributeSet, i, i2);
        int i3 = b0.f237a;
        if (i3 != 0) {
            if (i3 == 1) {
                if (b0.c) {
                    F1(3);
                } else {
                    F1(2);
                }
            }
        } else if (b0.c) {
            F1(1);
        } else {
            F1(0);
        }
        int i4 = this.y;
        if (i4 != 1) {
            if (i4 == 0) {
                Q0();
                l1();
            }
            this.y = 1;
            this.J = null;
            this.K = null;
            W0();
        }
        if (this.z != 4) {
            Q0();
            l1();
            this.z = 4;
            W0();
        }
        this.o = true;
        this.R = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    private boolean f1(View view, int i, int i2, RecyclerView.n nVar) {
        return view.isLayoutRequested() || !this.p || !j0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) nVar).width) || !j0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) nVar).height);
    }

    public static boolean j0(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int A(RecyclerView.x xVar) {
        return o1(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void A0(RecyclerView recyclerView, int i, int i2) {
        G1(i);
    }

    public final int A1(int i, RecyclerView.t tVar, RecyclerView.x xVar, boolean z2) {
        int i2;
        int k;
        if (j() || !this.B) {
            int k2 = i - this.J.k();
            if (k2 <= 0) {
                return 0;
            }
            i2 = -B1(k2, tVar, xVar);
        } else {
            int g = this.J.g() - i;
            if (g <= 0) {
                return 0;
            }
            i2 = B1(-g, tVar, xVar);
        }
        int i3 = i + i2;
        if (!z2 || (k = i3 - this.J.k()) <= 0) {
            return i2;
        }
        this.J.p(-k);
        return i2 - k;
    }

    public final int B1(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        int i2;
        if (K() == 0 || i == 0) {
            return 0;
        }
        p1();
        this.H.j = true;
        boolean z2 = !j() && this.B;
        int i3 = (!z2 ? i <= 0 : i >= 0) ? -1 : 1;
        int abs = Math.abs(i);
        this.H.i = i3;
        boolean j = j();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.v, this.t);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.w, this.u);
        boolean z3 = !j && this.B;
        if (i3 == 1) {
            View J2 = J(K() - 1);
            this.H.e = this.J.b(J2);
            int a0 = a0(J2);
            View v1 = v1(J2, this.D.get(this.E.c[a0]));
            c cVar = this.H;
            cVar.h = 1;
            int i4 = a0 + 1;
            cVar.d = i4;
            int[] iArr = this.E.c;
            if (iArr.length <= i4) {
                cVar.c = -1;
            } else {
                cVar.c = iArr[i4];
            }
            if (z3) {
                cVar.e = this.J.e(v1);
                this.H.f = this.J.k() + (-this.J.e(v1));
                c cVar2 = this.H;
                int i5 = cVar2.f;
                if (i5 < 0) {
                    i5 = 0;
                }
                cVar2.f = i5;
            } else {
                cVar.e = this.J.b(v1);
                this.H.f = this.J.b(v1) - this.J.g();
            }
            int i6 = this.H.c;
            if ((i6 == -1 || i6 > this.D.size() - 1) && this.H.d <= getFlexItemCount()) {
                int i7 = abs - this.H.f;
                this.U.a();
                if (i7 > 0) {
                    if (j) {
                        this.E.b(this.U, makeMeasureSpec, makeMeasureSpec2, i7, this.H.d, -1, this.D);
                    } else {
                        this.E.b(this.U, makeMeasureSpec2, makeMeasureSpec, i7, this.H.d, -1, this.D);
                    }
                    this.E.h(makeMeasureSpec, makeMeasureSpec2, this.H.d);
                    this.E.A(this.H.d);
                }
            }
        } else {
            View J3 = J(0);
            this.H.e = this.J.e(J3);
            int a02 = a0(J3);
            View s1 = s1(J3, this.D.get(this.E.c[a02]));
            c cVar3 = this.H;
            cVar3.h = 1;
            int i8 = this.E.c[a02];
            if (i8 == -1) {
                i8 = 0;
            }
            if (i8 > 0) {
                this.H.d = a02 - this.D.get(i8 - 1).h;
            } else {
                cVar3.d = -1;
            }
            c cVar4 = this.H;
            cVar4.c = i8 > 0 ? i8 - 1 : 0;
            if (z3) {
                cVar4.e = this.J.b(s1);
                this.H.f = this.J.b(s1) - this.J.g();
                c cVar5 = this.H;
                int i9 = cVar5.f;
                if (i9 < 0) {
                    i9 = 0;
                }
                cVar5.f = i9;
            } else {
                cVar4.e = this.J.e(s1);
                this.H.f = this.J.k() + (-this.J.e(s1));
            }
        }
        c cVar6 = this.H;
        int i10 = cVar6.f;
        cVar6.f601a = abs - i10;
        int q1 = q1(tVar, xVar, cVar6) + i10;
        if (q1 < 0) {
            return 0;
        }
        if (z2) {
            if (abs > q1) {
                i2 = (-i3) * q1;
                this.J.p(-i2);
                this.H.g = i2;
                return i2;
            }
        } else if (abs > q1) {
            i2 = i3 * q1;
            this.J.p(-i2);
            this.H.g = i2;
            return i2;
        }
        i2 = i;
        this.J.p(-i2);
        this.H.g = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void C0(RecyclerView recyclerView, int i, int i2, int i3) {
        G1(Math.min(i, i2));
    }

    public final int C1(int i) {
        int i2;
        int i3;
        boolean z2 = false;
        if (K() == 0 || i == 0) {
            return 0;
        }
        p1();
        boolean j = j();
        View view = this.S;
        int width = j ? view.getWidth() : view.getHeight();
        if (j) {
            i2 = this.v;
        } else {
            i2 = this.w;
        }
        if (W() == 1) {
            z2 = true;
        }
        if (z2) {
            int abs = Math.abs(i);
            if (i < 0) {
                return -Math.min((i2 + this.I.d) - width, abs);
            }
            i3 = this.I.d;
            if (i3 + i <= 0) {
                return i;
            }
        } else if (i > 0) {
            return Math.min((i2 - this.I.d) - width, i);
        } else {
            i3 = this.I.d;
            if (i3 + i >= 0) {
                return i;
            }
        }
        return -i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void D0(RecyclerView recyclerView, int i, int i2) {
        G1(i);
    }

    public final void D1(RecyclerView.t tVar, c cVar) {
        int K2;
        if (cVar.j) {
            int i = -1;
            if (cVar.i == -1) {
                if (cVar.f >= 0) {
                    this.J.f();
                    int K3 = K();
                    if (K3 != 0) {
                        int i2 = K3 - 1;
                        int i3 = this.E.c[a0(J(i2))];
                        if (i3 != -1) {
                            qy1 qy1 = this.D.get(i3);
                            int i4 = i2;
                            while (true) {
                                if (i4 < 0) {
                                    break;
                                }
                                View J2 = J(i4);
                                int i5 = cVar.f;
                                if (!(j() || !this.B ? this.J.e(J2) >= this.J.f() - i5 : this.J.b(J2) <= i5)) {
                                    break;
                                }
                                if (qy1.o == a0(J2)) {
                                    if (i3 <= 0) {
                                        K3 = i4;
                                        break;
                                    }
                                    i3 += cVar.i;
                                    qy1 = this.D.get(i3);
                                    K3 = i4;
                                }
                                i4--;
                            }
                            while (i2 >= K3) {
                                U0(i2, tVar);
                                i2--;
                            }
                        }
                    }
                }
            } else if (cVar.f >= 0 && (K2 = K()) != 0) {
                int i6 = this.E.c[a0(J(0))];
                if (i6 != -1) {
                    qy1 qy12 = this.D.get(i6);
                    int i7 = 0;
                    while (true) {
                        if (i7 >= K2) {
                            break;
                        }
                        View J3 = J(i7);
                        int i8 = cVar.f;
                        if (!(j() || !this.B ? this.J.b(J3) <= i8 : this.J.f() - this.J.e(J3) <= i8)) {
                            break;
                        }
                        if (qy12.p == a0(J3)) {
                            if (i6 >= this.D.size() - 1) {
                                i = i7;
                                break;
                            }
                            i6 += cVar.i;
                            qy12 = this.D.get(i6);
                            i = i7;
                        }
                        i7++;
                    }
                    while (i >= 0) {
                        U0(i, tVar);
                        i--;
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void E0(RecyclerView recyclerView, int i, int i2) {
        G1(i);
    }

    public final void E1() {
        int i;
        if (j()) {
            i = this.u;
        } else {
            i = this.t;
        }
        this.H.b = i == 0 || i == Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n F() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void F0(RecyclerView recyclerView, int i, int i2, Object obj) {
        E0(recyclerView, i, i2);
        G1(i);
    }

    public void F1(int i) {
        if (this.x != i) {
            Q0();
            this.x = i;
            this.J = null;
            this.K = null;
            l1();
            W0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n G(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x025a  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G0(androidx.recyclerview.widget.RecyclerView.t r20, androidx.recyclerview.widget.RecyclerView.x r21) {
        /*
        // Method dump skipped, instructions count: 1076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.G0(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x):void");
    }

    public final void G1(int i) {
        int t1 = t1();
        int w1 = w1();
        if (i < w1) {
            int K2 = K();
            this.E.j(K2);
            this.E.k(K2);
            this.E.i(K2);
            if (i < this.E.c.length) {
                this.T = i;
                View J2 = J(0);
                if (J2 != null) {
                    if (t1 > i || i > w1) {
                        this.M = a0(J2);
                        if (j() || !this.B) {
                            this.N = this.J.e(J2) - this.J.k();
                            return;
                        }
                        this.N = this.J.h() + this.J.b(J2);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void H0(RecyclerView.x xVar) {
        this.L = null;
        this.M = -1;
        this.N = RtlSpacingHelper.UNDEFINED;
        this.T = -1;
        b.b(this.I);
        this.Q.clear();
    }

    public final void H1(b bVar, boolean z2, boolean z3) {
        int i;
        if (z3) {
            E1();
        } else {
            this.H.b = false;
        }
        if (j() || !this.B) {
            this.H.f601a = this.J.g() - bVar.c;
        } else {
            this.H.f601a = bVar.c - getPaddingRight();
        }
        c cVar = this.H;
        cVar.d = bVar.f600a;
        cVar.h = 1;
        cVar.i = 1;
        cVar.e = bVar.c;
        cVar.f = RtlSpacingHelper.UNDEFINED;
        cVar.c = bVar.b;
        if (z2 && this.D.size() > 1 && (i = bVar.b) >= 0 && i < this.D.size() - 1) {
            c cVar2 = this.H;
            cVar2.c++;
            cVar2.d += this.D.get(bVar.b).h;
        }
    }

    public final void I1(b bVar, boolean z2, boolean z3) {
        int i;
        if (z3) {
            E1();
        } else {
            this.H.b = false;
        }
        if (j() || !this.B) {
            this.H.f601a = bVar.c - this.J.k();
        } else {
            this.H.f601a = (this.S.getWidth() - bVar.c) - this.J.k();
        }
        c cVar = this.H;
        cVar.d = bVar.f600a;
        cVar.h = 1;
        cVar.i = -1;
        cVar.e = bVar.c;
        cVar.f = RtlSpacingHelper.UNDEFINED;
        int i2 = bVar.b;
        cVar.c = i2;
        if (z2 && i2 > 0 && this.D.size() > (i = bVar.b)) {
            c cVar2 = this.H;
            cVar2.c--;
            cVar2.d -= this.D.get(i).h;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void L0(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.L = (SavedState) parcelable;
            W0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable M0() {
        SavedState savedState = this.L;
        if (savedState != null) {
            return new SavedState(savedState, (a) null);
        }
        SavedState savedState2 = new SavedState();
        if (K() > 0) {
            View J2 = J(0);
            savedState2.f = a0(J2);
            savedState2.g = this.J.e(J2) - this.J.k();
        } else {
            savedState2.f = -1;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int X0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (!j()) {
            int B1 = B1(i, tVar, xVar);
            this.Q.clear();
            return B1;
        }
        int C1 = C1(i);
        this.I.d += C1;
        this.K.p(-C1);
        return C1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void Y0(int i) {
        this.M = i;
        this.N = RtlSpacingHelper.UNDEFINED;
        SavedState savedState = this.L;
        if (savedState != null) {
            savedState.f = -1;
        }
        W0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int Z0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        if (j()) {
            int B1 = B1(i, tVar, xVar);
            this.Q.clear();
            return B1;
        }
        int C1 = C1(i);
        this.I.d += C1;
        this.K.p(-C1);
        return C1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
    public PointF a(int i) {
        if (K() == 0) {
            return null;
        }
        int i2 = i < a0(J(0)) ? -1 : 1;
        if (j()) {
            return new PointF(0.0f, (float) i2);
        }
        return new PointF((float) i2, 0.0f);
    }

    @Override // defpackage.py1
    public void b(View view, int i, int i2, qy1 qy1) {
        o(view, V);
        if (j()) {
            int c0 = c0(view) + X(view);
            qy1.e += c0;
            qy1.f += c0;
            return;
        }
        int I2 = I(view) + f0(view);
        qy1.e += I2;
        qy1.f += I2;
    }

    @Override // defpackage.py1
    public void c(qy1 qy1) {
    }

    @Override // defpackage.py1
    public View d(int i) {
        return g(i);
    }

    @Override // defpackage.py1
    public int e(int i, int i2, int i3) {
        return RecyclerView.m.L(this.v, this.t, i2, i3, p());
    }

    @Override // defpackage.py1
    public void f(int i, View view) {
        this.Q.put(i, view);
    }

    @Override // defpackage.py1
    public View g(int i) {
        View view = this.Q.get(i);
        if (view != null) {
            return view;
        }
        return this.F.k(i, false, Long.MAX_VALUE).itemView;
    }

    @Override // defpackage.py1
    public int getAlignContent() {
        return 5;
    }

    @Override // defpackage.py1
    public int getAlignItems() {
        return this.z;
    }

    @Override // defpackage.py1
    public int getFlexDirection() {
        return this.x;
    }

    @Override // defpackage.py1
    public int getFlexItemCount() {
        return this.G.b();
    }

    @Override // defpackage.py1
    public List<qy1> getFlexLinesInternal() {
        return this.D;
    }

    @Override // defpackage.py1
    public int getFlexWrap() {
        return this.y;
    }

    @Override // defpackage.py1
    public int getLargestMainSize() {
        if (this.D.size() == 0) {
            return 0;
        }
        int i = RtlSpacingHelper.UNDEFINED;
        int size = this.D.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.D.get(i2).e);
        }
        return i;
    }

    @Override // defpackage.py1
    public int getMaxLine() {
        return this.A;
    }

    @Override // defpackage.py1
    public int getSumOfCrossSize() {
        int size = this.D.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.D.get(i2).g;
        }
        return i;
    }

    @Override // defpackage.py1
    public int h(View view, int i, int i2) {
        int f0;
        int I2;
        if (j()) {
            f0 = X(view);
            I2 = c0(view);
        } else {
            f0 = f0(view);
            I2 = I(view);
        }
        return I2 + f0;
    }

    @Override // defpackage.py1
    public int i(int i, int i2, int i3) {
        return RecyclerView.m.L(this.w, this.u, i2, i3, q());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i1(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        nk nkVar = new nk(recyclerView.getContext());
        nkVar.f242a = i;
        j1(nkVar);
    }

    @Override // defpackage.py1
    public boolean j() {
        int i = this.x;
        return i == 0 || i == 1;
    }

    @Override // defpackage.py1
    public int k(View view) {
        int i;
        int i2;
        if (j()) {
            i2 = f0(view);
            i = I(view);
        } else {
            i2 = X(view);
            i = c0(view);
        }
        return i + i2;
    }

    public final void l1() {
        this.D.clear();
        b.b(this.I);
        this.I.d = 0;
    }

    public final int m1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        int b2 = xVar.b();
        p1();
        View r1 = r1(b2);
        View u1 = u1(b2);
        if (xVar.b() == 0 || r1 == null || u1 == null) {
            return 0;
        }
        return Math.min(this.J.l(), this.J.b(u1) - this.J.e(r1));
    }

    public final int n1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        int b2 = xVar.b();
        View r1 = r1(b2);
        View u1 = u1(b2);
        if (!(xVar.b() == 0 || r1 == null || u1 == null)) {
            int a0 = a0(r1);
            int a02 = a0(u1);
            int abs = Math.abs(this.J.b(u1) - this.J.e(r1));
            int[] iArr = this.E.c;
            int i = iArr[a0];
            if (!(i == 0 || i == -1)) {
                return Math.round((((float) i) * (((float) abs) / ((float) ((iArr[a02] - i) + 1)))) + ((float) (this.J.k() - this.J.e(r1))));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void o0(RecyclerView.e eVar, RecyclerView.e eVar2) {
        Q0();
    }

    public final int o1(RecyclerView.x xVar) {
        if (K() == 0) {
            return 0;
        }
        int b2 = xVar.b();
        View r1 = r1(b2);
        View u1 = u1(b2);
        if (xVar.b() == 0 || r1 == null || u1 == null) {
            return 0;
        }
        int t1 = t1();
        return (int) ((((float) Math.abs(this.J.b(u1) - this.J.e(r1))) / ((float) ((w1() - t1) + 1))) * ((float) xVar.b()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean p() {
        return !j() || this.v > this.S.getWidth();
    }

    public final void p1() {
        if (this.J == null) {
            if (j()) {
                if (this.y == 0) {
                    this.J = new sk(this);
                    this.K = new tk(this);
                    return;
                }
                this.J = new tk(this);
                this.K = new sk(this);
            } else if (this.y == 0) {
                this.J = new tk(this);
                this.K = new sk(this);
            } else {
                this.J = new sk(this);
                this.K = new tk(this);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean q() {
        return j() || this.w > this.S.getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void q0(RecyclerView recyclerView) {
        this.S = (View) recyclerView.getParent();
    }

    public final int q1(RecyclerView.t tVar, RecyclerView.x xVar, c cVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        qy1 qy1;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        View view;
        int i14;
        int i15 = cVar.f;
        if (i15 != Integer.MIN_VALUE) {
            int i16 = cVar.f601a;
            if (i16 < 0) {
                cVar.f = i15 + i16;
            }
            D1(tVar, cVar);
        }
        int i17 = cVar.f601a;
        boolean j = j();
        int i18 = i17;
        int i19 = 0;
        while (true) {
            if (i18 <= 0 && !this.H.b) {
                break;
            }
            List<qy1> list = this.D;
            int i20 = cVar.d;
            int i21 = 1;
            if (!(i20 >= 0 && i20 < xVar.b() && (i14 = cVar.c) >= 0 && i14 < list.size())) {
                break;
            }
            qy1 qy12 = this.D.get(cVar.c);
            cVar.d = qy12.o;
            if (j()) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i22 = this.v;
                int i23 = cVar.e;
                if (cVar.i == -1) {
                    i23 -= qy12.g;
                }
                int i24 = cVar.d;
                float f2 = (float) (i22 - paddingRight);
                float f3 = (float) this.I.d;
                float f4 = ((float) paddingLeft) - f3;
                float f5 = f2 - f3;
                float max = Math.max(0.0f, 0.0f);
                int i25 = qy12.h;
                int i26 = i24;
                int i27 = 0;
                while (i26 < i24 + i25) {
                    View g = g(i26);
                    if (g == null) {
                        i8 = i23;
                        i12 = i24;
                        i11 = i18;
                        i10 = i19;
                        i9 = i26;
                        i13 = i25;
                    } else {
                        i12 = i24;
                        if (cVar.i == i21) {
                            o(g, V);
                            m(g, -1, false);
                        } else {
                            o(g, V);
                            m(g, i27, false);
                            i27++;
                        }
                        ry1 ry1 = this.E;
                        i11 = i18;
                        i10 = i19;
                        long j2 = ry1.d[i26];
                        int i28 = (int) j2;
                        int m = ry1.m(j2);
                        LayoutParams layoutParams = (LayoutParams) g.getLayoutParams();
                        if (f1(g, i28, m, layoutParams)) {
                            g.measure(i28, m);
                        }
                        float X = f4 + ((float) (X(g) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin));
                        float c0 = f5 - ((float) (c0(g) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
                        int f0 = f0(g) + i23;
                        if (this.B) {
                            i9 = i26;
                            i13 = i25;
                            i8 = i23;
                            view = g;
                            this.E.u(g, qy12, Math.round(c0) - g.getMeasuredWidth(), f0, Math.round(c0), g.getMeasuredHeight() + f0);
                        } else {
                            i8 = i23;
                            i9 = i26;
                            i13 = i25;
                            view = g;
                            this.E.u(view, qy12, Math.round(X), f0, view.getMeasuredWidth() + Math.round(X), view.getMeasuredHeight() + f0);
                        }
                        float c02 = ((float) (c0(view) + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin)) + max + X;
                        f5 = c0 - (((float) (X(view) + (view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) + max);
                        f4 = c02;
                    }
                    i26 = i9 + 1;
                    i25 = i13;
                    i24 = i12;
                    i18 = i11;
                    i19 = i10;
                    i23 = i8;
                    i21 = 1;
                }
                i2 = i18;
                i = i19;
                cVar.c += this.H.i;
                i3 = qy12.g;
            } else {
                i2 = i18;
                i = i19;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int i29 = this.w;
                int i30 = cVar.e;
                if (cVar.i == -1) {
                    int i31 = qy12.g;
                    int i32 = i30 - i31;
                    i4 = i30 + i31;
                    i30 = i32;
                } else {
                    i4 = i30;
                }
                int i33 = cVar.d;
                float f6 = (float) (i29 - paddingBottom);
                float f7 = (float) this.I.d;
                float f8 = ((float) paddingTop) - f7;
                float f9 = f6 - f7;
                float max2 = Math.max(0.0f, 0.0f);
                int i34 = qy12.h;
                int i35 = i33;
                int i36 = 0;
                while (i35 < i33 + i34) {
                    View g2 = g(i35);
                    if (g2 == null) {
                        f = max2;
                        qy1 = qy12;
                        i6 = i35;
                        i7 = i34;
                        i5 = i33;
                    } else {
                        ry1 ry12 = this.E;
                        f = max2;
                        qy1 = qy12;
                        long j3 = ry12.d[i35];
                        int i37 = (int) j3;
                        int m2 = ry12.m(j3);
                        LayoutParams layoutParams2 = (LayoutParams) g2.getLayoutParams();
                        if (f1(g2, i37, m2, layoutParams2)) {
                            g2.measure(i37, m2);
                        }
                        float f02 = f8 + ((float) (f0(g2) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin));
                        float I2 = f9 - ((float) (I(g2) + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin));
                        if (cVar.i == 1) {
                            o(g2, V);
                            m(g2, -1, false);
                        } else {
                            o(g2, V);
                            m(g2, i36, false);
                            i36++;
                        }
                        int X2 = X(g2) + i30;
                        int c03 = i4 - c0(g2);
                        boolean z2 = this.B;
                        if (!z2) {
                            i6 = i35;
                            i7 = i34;
                            i5 = i33;
                            if (this.C) {
                                this.E.v(g2, qy1, z2, X2, Math.round(I2) - g2.getMeasuredHeight(), g2.getMeasuredWidth() + X2, Math.round(I2));
                            } else {
                                this.E.v(g2, qy1, z2, X2, Math.round(f02), g2.getMeasuredWidth() + X2, g2.getMeasuredHeight() + Math.round(f02));
                            }
                        } else if (this.C) {
                            i6 = i35;
                            i7 = i34;
                            i5 = i33;
                            this.E.v(g2, qy1, z2, c03 - g2.getMeasuredWidth(), Math.round(I2) - g2.getMeasuredHeight(), c03, Math.round(I2));
                        } else {
                            i6 = i35;
                            i7 = i34;
                            i5 = i33;
                            this.E.v(g2, qy1, z2, c03 - g2.getMeasuredWidth(), Math.round(f02), c03, g2.getMeasuredHeight() + Math.round(f02));
                        }
                        float I3 = ((float) (I(g2) + g2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin)) + f + f02;
                        f9 = I2 - (((float) (f0(g2) + (g2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin))) + f);
                        f8 = I3;
                        i36 = i36;
                    }
                    i35 = i6 + 1;
                    i34 = i7;
                    qy12 = qy1;
                    max2 = f;
                    i33 = i5;
                }
                cVar.c += this.H.i;
                i3 = qy12.g;
            }
            i19 = i + i3;
            if (j || !this.B) {
                cVar.e = (qy12.g * cVar.i) + cVar.e;
            } else {
                cVar.e -= qy12.g * cVar.i;
            }
            i18 = i2 - qy12.g;
        }
        int i38 = cVar.f601a - i19;
        cVar.f601a = i38;
        int i39 = cVar.f;
        if (i39 != Integer.MIN_VALUE) {
            int i40 = i39 + i19;
            cVar.f = i40;
            if (i38 < 0) {
                cVar.f = i40 + i38;
            }
            D1(tVar, cVar);
        }
        return i17 - cVar.f601a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean r(RecyclerView.n nVar) {
        return nVar instanceof LayoutParams;
    }

    public final View r1(int i) {
        int i2;
        View y1 = y1(0, K(), i);
        if (y1 == null || (i2 = this.E.c[a0(y1)]) == -1) {
            return null;
        }
        return s1(y1, this.D.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView recyclerView, RecyclerView.t tVar) {
        r0();
    }

    public final View s1(View view, qy1 qy1) {
        boolean j = j();
        int i = qy1.h;
        for (int i2 = 1; i2 < i; i2++) {
            View J2 = J(i2);
            if (!(J2 == null || J2.getVisibility() == 8)) {
                if (!this.B || j) {
                    if (this.J.e(view) <= this.J.e(J2)) {
                    }
                } else if (this.J.b(view) >= this.J.b(J2)) {
                }
                view = J2;
            }
        }
        return view;
    }

    @Override // defpackage.py1
    public void setFlexLines(List<qy1> list) {
        this.D = list;
    }

    public int t1() {
        View x1 = x1(0, K(), false);
        if (x1 == null) {
            return -1;
        }
        return a0(x1);
    }

    public final View u1(int i) {
        View y1 = y1(K() - 1, -1, i);
        if (y1 == null) {
            return null;
        }
        return v1(y1, this.D.get(this.E.c[a0(y1)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int v(RecyclerView.x xVar) {
        return m1(xVar);
    }

    public final View v1(View view, qy1 qy1) {
        boolean j = j();
        int K2 = (K() - qy1.h) - 1;
        for (int K3 = K() - 2; K3 > K2; K3--) {
            View J2 = J(K3);
            if (!(J2 == null || J2.getVisibility() == 8)) {
                if (!this.B || j) {
                    if (this.J.b(view) >= this.J.b(J2)) {
                    }
                } else if (this.J.e(view) <= this.J.e(J2)) {
                }
                view = J2;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int w(RecyclerView.x xVar) {
        n1(xVar);
        return n1(xVar);
    }

    public int w1() {
        View x1 = x1(K() - 1, -1, false);
        if (x1 == null) {
            return -1;
        }
        return a0(x1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int x(RecyclerView.x xVar) {
        return o1(xVar);
    }

    public final View x1(int i, int i2, boolean z2) {
        int i3 = i;
        int i4 = i2 > i3 ? 1 : -1;
        while (i3 != i2) {
            View J2 = J(i3);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.v - getPaddingRight();
            int paddingBottom = this.w - getPaddingBottom();
            int P2 = P(J2) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) J2.getLayoutParams())).leftMargin;
            int T2 = T(J2) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) J2.getLayoutParams())).topMargin;
            int S2 = S(J2) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) J2.getLayoutParams())).rightMargin;
            int N2 = N(J2) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.n) J2.getLayoutParams())).bottomMargin;
            boolean z3 = false;
            boolean z4 = paddingLeft <= P2 && paddingRight >= S2;
            boolean z5 = P2 >= paddingRight || S2 >= paddingLeft;
            boolean z6 = paddingTop <= T2 && paddingBottom >= N2;
            boolean z7 = T2 >= paddingBottom || N2 >= paddingTop;
            if (!z2 ? !(!z5 || !z7) : !(!z4 || !z6)) {
                z3 = true;
            }
            if (z3) {
                return J2;
            }
            i3 += i4;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int y(RecyclerView.x xVar) {
        return m1(xVar);
    }

    public final View y1(int i, int i2, int i3) {
        p1();
        View view = null;
        if (this.H == null) {
            this.H = new c(null);
        }
        int k = this.J.k();
        int g = this.J.g();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View J2 = J(i);
            int a0 = a0(J2);
            if (a0 >= 0 && a0 < i3) {
                if (((RecyclerView.n) J2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = J2;
                    }
                } else if (this.J.e(J2) >= k && this.J.b(J2) <= g) {
                    return J2;
                } else {
                    if (view == null) {
                        view = J2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int z(RecyclerView.x xVar) {
        return n1(xVar);
    }

    public final int z1(int i, RecyclerView.t tVar, RecyclerView.x xVar, boolean z2) {
        int i2;
        int g;
        if (!j() && this.B) {
            int k = i - this.J.k();
            if (k <= 0) {
                return 0;
            }
            i2 = B1(k, tVar, xVar);
        } else {
            int g2 = this.J.g() - i;
            if (g2 <= 0) {
                return 0;
            }
            i2 = -B1(-g2, tVar, xVar);
        }
        int i3 = i + i2;
        if (!z2 || (g = this.J.g() - i3) <= 0) {
            return i2;
        }
        this.J.p(g);
        return g + i2;
    }

    public static class LayoutParams extends RecyclerView.n implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        public float j = 0.0f;
        public float k = 1.0f;
        public int l = -1;
        public float m = -1.0f;
        public int n;
        public int o;
        public int p = 16777215;
        public int q = 16777215;
        public boolean r;

        public static class a implements Parcelable.Creator<LayoutParams> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.flexbox.FlexItem
        public float C0() {
            return this.m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int O0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int P() {
            return this.l;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int R0() {
            return this.o;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float T() {
            return this.k;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean W0() {
            return this.r;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int a0() {
            return this.n;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int b1() {
            return this.q;
        }

        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int g0() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int i0() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int i1() {
            return this.p;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int k() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int q0() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float w0() {
            return this.j;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.j);
            parcel.writeFloat(this.k);
            parcel.writeInt(this.l);
            parcel.writeFloat(this.m);
            parcel.writeInt(this.n);
            parcel.writeInt(this.o);
            parcel.writeInt(this.p);
            parcel.writeInt(this.q);
            parcel.writeByte(this.r ? (byte) 1 : 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.j = parcel.readFloat();
            this.k = parcel.readFloat();
            this.l = parcel.readInt();
            this.m = parcel.readFloat();
            this.n = parcel.readInt();
            this.o = parcel.readInt();
            this.p = parcel.readInt();
            this.q = parcel.readInt();
            this.r = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
