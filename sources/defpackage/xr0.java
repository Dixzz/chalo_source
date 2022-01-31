package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.TransitMode;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.activities.UserProfileActivity;
import defpackage.xt;

/* renamed from: xr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xr0 implements View.OnClickListener {
    public final /* synthetic */ kv0 f;

    public /* synthetic */ xr0(kv0 kv0) {
        this.f = kv0;
    }

    public final void onClick(View view) {
        kv0 kv0 = this.f;
        int i = kv0.n;
        n86.e(kv0, "this$0");
        xt.t1 t1Var = xt.f3961a;
        if (!t1Var.L().m()) {
            kv0.h.a(UserProfileActivity.h0(kv0.getContext()), null);
        } else if (ui1.b0(TransitMode.bus, t1Var.k().d())) {
            Intent intent = new Intent(kv0.c(), ProductSelectionActivity.class);
            intent.putExtra("source", "History screen");
            kv0.startActivity(intent);
        }
    }
}
