package defpackage;

import android.view.View;
import app.zophop.ui.activities.UniversalPassActivity;

/* renamed from: za0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class za0 implements View.OnClickListener {
    public final /* synthetic */ UniversalPassActivity f;
    public final /* synthetic */ du0 g;

    public /* synthetic */ za0(UniversalPassActivity universalPassActivity, du0 du0) {
        this.f = universalPassActivity;
        this.g = du0;
    }

    public final void onClick(View view) {
        UniversalPassActivity universalPassActivity = this.f;
        du0 du0 = this.g;
        UniversalPassActivity.a aVar = UniversalPassActivity.m;
        n86.e(universalPassActivity, "this$0");
        n86.e(du0, "$lBottomSheet");
        n86.e("get universal pass permission denied", "lName");
        n86.e("universal pass activity", "lSource");
        ed1 ed1 = new ed1("get universal pass permission denied", Long.MIN_VALUE);
        ed1.a("source", "universal pass activity");
        ui1.m0(ed1);
        universalPassActivity.finish();
        du0.dismiss();
    }
}
