package defpackage;

import android.view.View;
import app.zophop.R;
import defpackage.xt;

/* renamed from: ur0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ur0 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;
    public final /* synthetic */ kv0 g;

    public /* synthetic */ ur0(hm0 hm0, kv0 kv0) {
        this.f = hm0;
        this.g = kv0;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        kv0 kv0 = this.g;
        int i = kv0.n;
        n86.e(kv0, "this$0");
        hm0.dismiss();
        if (kv0.m == null) {
            kv0.m = vn.U(null, kv0.getString(R.string.loading_pass), false, false);
        }
        gv0 gv0 = kv0.m;
        if (gv0 != null) {
            gv0.show(kv0.getParentFragmentManager(), (String) null);
        }
        kv0.k = hj1.H("randomUUID().toString()");
        xt.t1 t1Var = xt.f3961a;
        t1Var.c().f0(kv0.k, t1Var.L().getUserId(), t1Var.n().a());
    }
}
