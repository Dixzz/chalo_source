package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.e9;
import defpackage.lk;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public boolean M = false;
    public int N = -1;
    public int[] O;
    public View[] P;
    public final SparseIntArray Q = new SparseIntArray();
    public final SparseIntArray R = new SparseIntArray();
    public c S = new a();
    public final Rect T = new Rect();

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i) {
            return 1;
        }
    }

    public static abstract class c {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        public final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        public final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int getCachedSpanGroupIndex(int i, int i2) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i, i2);
            }
            int i3 = this.mSpanGroupIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanGroupIndex = getSpanGroupIndex(i, i2);
            this.mSpanGroupIndexCache.put(i, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int spanIndex = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i)) == -1) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i4 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i3 = findFirstKeyLessThan + 1;
                i5 = getSpanSize(findFirstKeyLessThan) + getCachedSpanIndex(findFirstKeyLessThan, i2);
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                }
            }
            int spanSize = getSpanSize(i);
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                i5 += spanSize2;
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                } else if (i5 > i2) {
                    i4++;
                    i5 = spanSize2;
                }
                i3++;
            }
            return i5 + spanSize > i2 ? i4 + 1 : i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r4 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r3 = r5.getSpanSize(r2)
                int r4 = r4 + r3
                if (r4 != r7) goto L_0x002d
                r4 = 0
                goto L_0x0030
            L_0x002d:
                if (r4 <= r7) goto L_0x0030
                r4 = r3
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r4
                if (r0 > r7) goto L_0x0037
                return r4
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a2(RecyclerView.m.b0(context, attributeSet, i, i2).b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int A(RecyclerView.x xVar) {
        return p1(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void A0(RecyclerView recyclerView, int i, int i2) {
        this.S.invalidateSpanIndexCache();
        this.S.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void B0(RecyclerView recyclerView) {
        this.S.invalidateSpanIndexCache();
        this.S.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void C0(RecyclerView recyclerView, int i, int i2, int i3) {
        this.S.invalidateSpanIndexCache();
        this.S.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void D0(RecyclerView recyclerView, int i, int i2) {
        this.S.invalidateSpanIndexCache();
        this.S.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public RecyclerView.n F() {
        if (this.x == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void F0(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.S.invalidateSpanIndexCache();
        this.S.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void F1(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        View c2;
        int j = this.z.j();
        boolean z2 = j != 1073741824;
        int i13 = K() > 0 ? this.O[this.N] : 0;
        if (z2) {
            b2();
        }
        boolean z3 = cVar.e == 1;
        int i14 = this.N;
        if (!z3) {
            i14 = W1(tVar, xVar, cVar.d) + X1(tVar, xVar, cVar.d);
        }
        int i15 = 0;
        while (i15 < this.N && cVar.b(xVar) && i14 > 0) {
            int i16 = cVar.d;
            int X1 = X1(tVar, xVar, i16);
            if (X1 <= this.N) {
                i14 -= X1;
                if (i14 < 0 || (c2 = cVar.c(tVar)) == null) {
                    break;
                }
                this.P[i15] = c2;
                i15++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Item at position ");
                sb.append(i16);
                sb.append(" requires ");
                sb.append(X1);
                sb.append(" spans but GridLayoutManager has only ");
                throw new IllegalArgumentException(hj1.X(sb, this.N, " spans."));
            }
        }
        if (i15 == 0) {
            bVar.b = true;
            return;
        }
        if (z3) {
            i4 = 0;
            i3 = i15;
            i2 = 0;
            i = 1;
        } else {
            i4 = i15 - 1;
            i3 = -1;
            i2 = 0;
            i = -1;
        }
        while (i4 != i3) {
            View view = this.P[i4];
            b bVar2 = (b) view.getLayoutParams();
            int X12 = X1(tVar, xVar, a0(view));
            bVar2.k = X12;
            bVar2.j = i2;
            i2 += X12;
            i4 += i;
        }
        float f = 0.0f;
        int i17 = 0;
        for (int i18 = 0; i18 < i15; i18++) {
            View view2 = this.P[i18];
            if (cVar.k != null) {
                z = false;
                if (z3) {
                    m(view2, -1, true);
                } else {
                    m(view2, 0, true);
                }
            } else if (z3) {
                l(view2);
                z = false;
            } else {
                z = false;
                m(view2, 0, false);
            }
            o(view2, this.T);
            Y1(view2, j, z);
            int c3 = this.z.c(view2);
            if (c3 > i17) {
                i17 = c3;
            }
            float d = (((float) this.z.d(view2)) * 1.0f) / ((float) ((b) view2.getLayoutParams()).k);
            if (d > f) {
                f = d;
            }
        }
        if (z2) {
            S1(Math.max(Math.round(f * ((float) this.N)), i13));
            i17 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                View view3 = this.P[i19];
                Y1(view3, CommonUtils.BYTES_IN_A_GIGABYTE, true);
                int c4 = this.z.c(view3);
                if (c4 > i17) {
                    i17 = c4;
                }
            }
        }
        for (int i20 = 0; i20 < i15; i20++) {
            View view4 = this.P[i20];
            if (this.z.c(view4) != i17) {
                b bVar3 = (b) view4.getLayoutParams();
                Rect rect = bVar3.g;
                int i21 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar3).topMargin + ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin;
                int i22 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin + ((ViewGroup.MarginLayoutParams) bVar3).rightMargin;
                int U1 = U1(bVar3.j, bVar3.k);
                if (this.x == 1) {
                    i12 = RecyclerView.m.L(U1, CommonUtils.BYTES_IN_A_GIGABYTE, i22, ((ViewGroup.MarginLayoutParams) bVar3).width, false);
                    i11 = View.MeasureSpec.makeMeasureSpec(i17 - i21, CommonUtils.BYTES_IN_A_GIGABYTE);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i22, CommonUtils.BYTES_IN_A_GIGABYTE);
                    i11 = RecyclerView.m.L(U1, CommonUtils.BYTES_IN_A_GIGABYTE, i21, ((ViewGroup.MarginLayoutParams) bVar3).height, false);
                    i12 = makeMeasureSpec;
                }
                Z1(view4, i12, i11, true);
            }
        }
        bVar.f229a = i17;
        if (this.x == 1) {
            if (cVar.f == -1) {
                i8 = cVar.b;
                i7 = i8 - i17;
            } else {
                i7 = cVar.b;
                i8 = i17 + i7;
            }
            i6 = 0;
            i5 = 0;
        } else {
            if (cVar.f == -1) {
                int i23 = cVar.b;
                i6 = i23;
                i5 = i23 - i17;
            } else {
                int i24 = cVar.b;
                i5 = i24;
                i6 = i17 + i24;
            }
            i7 = 0;
            i8 = 0;
        }
        int i25 = 0;
        while (i25 < i15) {
            View view5 = this.P[i25];
            b bVar4 = (b) view5.getLayoutParams();
            if (this.x == 1) {
                if (E1()) {
                    i6 = getPaddingLeft() + this.O[this.N - bVar4.j];
                    i5 = i6 - this.z.d(view5);
                } else {
                    i5 = this.O[bVar4.j] + getPaddingLeft();
                    i6 = this.z.d(view5) + i5;
                }
                i10 = i8;
                i9 = i7;
            } else {
                int paddingTop = getPaddingTop() + this.O[bVar4.j];
                i9 = paddingTop;
                i10 = this.z.d(view5) + paddingTop;
            }
            l0(view5, i5, i9, i6, i10);
            if (bVar4.c() || bVar4.b()) {
                bVar.c = true;
            }
            bVar.d |= view5.hasFocusable();
            i25++;
            i8 = i10;
            i7 = i9;
            i6 = i6;
            i5 = i5;
        }
        Arrays.fill(this.P, (Object) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n G(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void G0(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (xVar.g) {
            int K = K();
            for (int i = 0; i < K; i++) {
                b bVar = (b) J(i).getLayoutParams();
                int a2 = bVar.a();
                this.Q.put(a2, bVar.k);
                this.R.put(a2, bVar.j);
            }
        }
        super.G0(tVar, xVar);
        this.Q.clear();
        this.R.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void G1(RecyclerView.t tVar, RecyclerView.x xVar, LinearLayoutManager.a aVar, int i) {
        b2();
        if (xVar.b() > 0 && !xVar.g) {
            boolean z = i == 1;
            int W1 = W1(tVar, xVar, aVar.b);
            if (z) {
                while (W1 > 0) {
                    int i2 = aVar.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    aVar.b = i3;
                    W1 = W1(tVar, xVar, i3);
                }
            } else {
                int b2 = xVar.b() - 1;
                int i4 = aVar.b;
                while (i4 < b2) {
                    int i5 = i4 + 1;
                    int W12 = W1(tVar, xVar, i5);
                    if (W12 <= W1) {
                        break;
                    }
                    i4 = i5;
                    W1 = W12;
                }
                aVar.b = i4;
            }
        }
        T1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n H(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void H0(RecyclerView.x xVar) {
        this.H = null;
        this.F = -1;
        this.G = RtlSpacingHelper.UNDEFINED;
        this.I.d();
        this.M = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int M(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.x == 1) {
            return this.N;
        }
        if (xVar.b() < 1) {
            return 0;
        }
        return V1(tVar, xVar, xVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void O1(boolean z) {
        if (!z) {
            n(null);
            if (this.D) {
                this.D = false;
                W0();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final void S1(int i) {
        int i2;
        int[] iArr = this.O;
        int i3 = this.N;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.O = iArr;
    }

    public final void T1() {
        View[] viewArr = this.P;
        if (viewArr == null || viewArr.length != this.N) {
            this.P = new View[this.N];
        }
    }

    public int U1(int i, int i2) {
        if (this.x != 1 || !E1()) {
            int[] iArr = this.O;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.O;
        int i3 = this.N;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int V1(RecyclerView.t tVar, RecyclerView.x xVar, int i) {
        if (!xVar.g) {
            return this.S.getCachedSpanGroupIndex(i, this.N);
        }
        int c2 = tVar.c(i);
        if (c2 == -1) {
            return 0;
        }
        return this.S.getCachedSpanGroupIndex(c2, this.N);
    }

    public final int W1(RecyclerView.t tVar, RecyclerView.x xVar, int i) {
        if (!xVar.g) {
            return this.S.getCachedSpanIndex(i, this.N);
        }
        int i2 = this.R.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int c2 = tVar.c(i);
        if (c2 == -1) {
            return 0;
        }
        return this.S.getCachedSpanIndex(c2, this.N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int X0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        b2();
        T1();
        if (this.x == 1) {
            return 0;
        }
        return L1(i, tVar, xVar);
    }

    public final int X1(RecyclerView.t tVar, RecyclerView.x xVar, int i) {
        if (!xVar.g) {
            return this.S.getSpanSize(i);
        }
        int i2 = this.Q.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int c2 = tVar.c(i);
        if (c2 == -1) {
            return 1;
        }
        return this.S.getSpanSize(c2);
    }

    public final void Y1(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.g;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int U1 = U1(bVar.j, bVar.k);
        if (this.x == 1) {
            i2 = RecyclerView.m.L(U1, i, i5, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i3 = RecyclerView.m.L(this.z.l(), this.u, i4, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int L = RecyclerView.m.L(U1, i, i4, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int L2 = RecyclerView.m.L(this.z.l(), this.t, i5, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i3 = L;
            i2 = L2;
        }
        Z1(view, i2, i3, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int Z0(int i, RecyclerView.t tVar, RecyclerView.x xVar) {
        b2();
        T1();
        if (this.x == 0) {
            return 0;
        }
        return L1(i, tVar, xVar);
    }

    public final void Z1(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        if (z) {
            z2 = h1(view, i, i2, nVar);
        } else {
            z2 = f1(view, i, i2, nVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    public void a2(int i) {
        if (i != this.N) {
            this.M = true;
            if (i >= 1) {
                this.N = i;
                this.S.invalidateSpanIndexCache();
                W0();
                return;
            }
            throw new IllegalArgumentException(hj1.I("Span count should be at least 1. Provided ", i));
        }
    }

    public final void b2() {
        int i;
        int i2;
        if (this.x == 1) {
            i2 = this.v - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = this.w - getPaddingBottom();
            i = getPaddingTop();
        }
        S1(i2 - i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void c1(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.O == null) {
            super.c1(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.x == 1) {
            i4 = RecyclerView.m.s(i2, rect.height() + paddingBottom, Y());
            int[] iArr = this.O;
            i3 = RecyclerView.m.s(i, iArr[iArr.length - 1] + paddingRight, Z());
        } else {
            i3 = RecyclerView.m.s(i, rect.width() + paddingRight, Z());
            int[] iArr2 = this.O;
            i4 = RecyclerView.m.s(i2, iArr2[iArr2.length - 1] + paddingBottom, Y());
        }
        this.g.setMeasuredDimension(i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int d0(RecyclerView.t tVar, RecyclerView.x xVar) {
        if (this.x == 0) {
            return this.N;
        }
        if (xVar.b() < 1) {
            return 0;
        }
        return V1(tVar, xVar, xVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public boolean k1() {
        return this.H == null && !this.M;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void m1(RecyclerView.x xVar, LinearLayoutManager.c cVar, RecyclerView.m.c cVar2) {
        int i = this.N;
        for (int i2 = 0; i2 < this.N && cVar.b(xVar) && i > 0; i2++) {
            int i3 = cVar.d;
            ((lk.b) cVar2).a(i3, Math.max(0, cVar.g));
            i -= this.S.getSpanSize(i3);
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean r(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ca, code lost:
        if (r13 == (r2 > r15)) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e6, code lost:
        if (r13 == (r2 > r8)) goto L_0x00e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View t0(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.t r25, androidx.recyclerview.widget.RecyclerView.x r26) {
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.t0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int w(RecyclerView.x xVar) {
        return o1(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int x(RecyclerView.x xVar) {
        return p1(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void y0(RecyclerView.t tVar, RecyclerView.x xVar, View view, e9 e9Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            x0(view, e9Var);
            return;
        }
        b bVar = (b) layoutParams;
        int V1 = V1(tVar, xVar, bVar.a());
        if (this.x == 0) {
            e9Var.n(e9.c.a(bVar.j, bVar.k, V1, 1, false, false));
        } else {
            e9Var.n(e9.c.a(V1, 1, bVar.j, bVar.k, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int z(RecyclerView.x xVar) {
        return o1(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View z1(RecyclerView.t tVar, RecyclerView.x xVar, boolean z, boolean z2) {
        int i;
        int K = K();
        int i2 = -1;
        int i3 = 1;
        if (z2) {
            i = K() - 1;
            i3 = -1;
        } else {
            i2 = K;
            i = 0;
        }
        int b2 = xVar.b();
        r1();
        int k = this.z.k();
        int g = this.z.g();
        View view = null;
        View view2 = null;
        while (i != i2) {
            View J = J(i);
            int a0 = a0(J);
            if (a0 >= 0 && a0 < b2 && W1(tVar, xVar, a0) == 0) {
                if (((RecyclerView.n) J.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = J;
                    }
                } else if (this.z.e(J) < g && this.z.b(J) >= k) {
                    return J;
                } else {
                    if (view == null) {
                        view = J;
                    }
                }
            }
            i += i3;
        }
        return view != null ? view : view2;
    }

    public static class b extends RecyclerView.n {
        public int j = -1;
        public int k = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(i2, z);
        a2(i);
    }

    public GridLayoutManager(Context context, int i) {
        super(1, false);
        a2(i);
    }
}
