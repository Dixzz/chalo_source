package defpackage;

import android.app.Activity;
import android.view.View;
import defpackage.ig1;

/* renamed from: jl0  reason: default package */
/* compiled from: ZophopPickLocationDefaultAdapter */
public class jl0 implements View.OnClickListener {
    public final /* synthetic */ mf1 f;
    public final /* synthetic */ gl0 g;

    public jl0(gl0 gl0, mf1 mf1) {
        this.g = gl0;
        this.f = mf1;
    }

    public void onClick(View view) {
        pn0.c(((Activity) this.g.g).getFragmentManager(), this.f, ig1.a.RECENT);
    }
}
