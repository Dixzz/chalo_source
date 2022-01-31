package defpackage;

import android.view.View;
import app.zophop.ui.activities.UniversalPassActivity;
import defpackage.xt;

/* renamed from: ya0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ya0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ UniversalPassActivity g;

    public /* synthetic */ ya0(du0 du0, UniversalPassActivity universalPassActivity) {
        this.f = du0;
        this.g = universalPassActivity;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        UniversalPassActivity universalPassActivity = this.g;
        UniversalPassActivity.a aVar = UniversalPassActivity.m;
        n86.e(du0, "$lBottomSheet");
        n86.e(universalPassActivity, "this$0");
        n86.e("get universal pass permission given", "lName");
        n86.e("universal pass activity", "lSource");
        ed1 ed1 = new ed1("get universal pass permission given", Long.MIN_VALUE);
        ed1.a("source", "universal pass activity");
        ui1.m0(ed1);
        du0.dismiss();
        du0.f = true;
        xt.t1 t1Var = xt.f3961a;
        xt.x0.getValue().b();
        universalPassActivity.r0();
    }
}
