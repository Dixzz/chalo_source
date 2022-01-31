package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: uk  reason: default package */
/* compiled from: OrientationHelper */
public abstract class uk {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.m f3515a;
    public int b = RtlSpacingHelper.UNDEFINED;
    public final Rect c = new Rect();

    public uk(RecyclerView.m mVar, sk skVar) {
        this.f3515a = mVar;
    }

    public static uk a(RecyclerView.m mVar, int i) {
        if (i == 0) {
            return new sk(mVar);
        }
        if (i == 1) {
            return new tk(mVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return l() - this.b;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i);
}
