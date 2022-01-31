package defpackage;

import android.view.View;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: oq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class oq0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;

    public /* synthetic */ oq0(du0 du0) {
        this.f = du0;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(du0, "$lBottomSheet");
        xt.f3961a.l().put("passExtensionDialogShown", "true");
        du0.dismiss();
    }
}
