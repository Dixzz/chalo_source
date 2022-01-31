package defpackage;

import android.util.DisplayMetrics;
import java.util.Locale;

/* renamed from: ed3  reason: default package */
public final class ed3 extends yb3 {
    public ed3(ac3 ac3) {
        super(ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
    }

    public final te3 i0() {
        g0();
        DisplayMetrics displayMetrics = w().f1998a.getResources().getDisplayMetrics();
        te3 te3 = new te3();
        te3.f3340a = ie3.a(Locale.getDefault());
        te3.c = displayMetrics.widthPixels;
        te3.d = displayMetrics.heightPixels;
        return te3;
    }
}
