package defpackage;

import android.view.View;
import app.zophop.ui.activities.UniversalPassActivity;

/* renamed from: xa0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class xa0 implements View.OnClickListener {
    public final /* synthetic */ UniversalPassActivity f;

    public /* synthetic */ xa0(UniversalPassActivity universalPassActivity) {
        this.f = universalPassActivity;
    }

    public final void onClick(View view) {
        UniversalPassActivity universalPassActivity = this.f;
        UniversalPassActivity.a aVar = UniversalPassActivity.m;
        n86.e(universalPassActivity, "this$0");
        n86.e("retry button clicked", "lName");
        n86.e("universal pass activity", "lSource");
        ed1 ed1 = new ed1("retry button clicked", Long.MIN_VALUE);
        ed1.a("source", "universal pass activity");
        ui1.m0(ed1);
        universalPassActivity.o0();
    }
}
