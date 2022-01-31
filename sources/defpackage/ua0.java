package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.UniversalPassActivity;
import app.zophop.ui.activities.WebViewActivity;

/* renamed from: ua0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ua0 implements View.OnClickListener {
    public final /* synthetic */ UniversalPassActivity f;

    public /* synthetic */ ua0(UniversalPassActivity universalPassActivity) {
        this.f = universalPassActivity;
    }

    public final void onClick(View view) {
        UniversalPassActivity universalPassActivity = this.f;
        UniversalPassActivity.a aVar = UniversalPassActivity.m;
        n86.e(universalPassActivity, "this$0");
        n86.e("generate universal pass button clicked", "lName");
        n86.e("universal pass activity", "lSource");
        ed1 ed1 = new ed1("generate universal pass button clicked", Long.MIN_VALUE);
        ed1.a("source", "universal pass activity");
        ui1.m0(ed1);
        WebViewActivity.h0(universalPassActivity, "https://epassmsdma.mahait.org/login.htm", universalPassActivity.getString(R.string.no_universal_passes_found_cta), false, false);
    }
}
