package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: nk  reason: default package */
/* compiled from: LinearSmoothScroller */
public class nk extends RecyclerView.w {
    public final LinearInterpolator i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public PointF k;
    public final DisplayMetrics l;
    public boolean m = false;
    public float n;
    public int o = 0;
    public int p = 0;

    public nk(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void b(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        int i2;
        int i3;
        PointF pointF = this.k;
        int i4 = 0;
        int i5 = (pointF == null || pointF.x == 0.0f) ? 0 : i3 > 0 ? 1 : -1;
        RecyclerView.m mVar = this.c;
        if (mVar == null || !mVar.p()) {
            i2 = 0;
        } else {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            i2 = d(mVar.P(view) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, mVar.S(view) + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, mVar.getPaddingLeft(), mVar.v - mVar.getPaddingRight(), i5);
        }
        int g = g();
        RecyclerView.m mVar2 = this.c;
        if (mVar2 != null && mVar2.q()) {
            RecyclerView.n nVar2 = (RecyclerView.n) view.getLayoutParams();
            i4 = d(mVar2.T(view) - ((ViewGroup.MarginLayoutParams) nVar2).topMargin, mVar2.N(view) + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin, mVar2.getPaddingTop(), mVar2.w - mVar2.getPaddingBottom(), g);
        }
        int ceil = (int) Math.ceil(((double) f((int) Math.sqrt((double) ((i4 * i4) + (i2 * i2))))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(-i2, -i4, ceil, this.j);
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public float e(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int f(int i2) {
        float abs = (float) Math.abs(i2);
        if (!this.m) {
            this.n = e(this.l);
            this.m = true;
        }
        return (int) Math.ceil((double) (abs * this.n));
    }

    public int g() {
        PointF pointF = this.k;
        if (pointF != null) {
            float f = pointF.y;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
