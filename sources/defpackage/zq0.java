package defpackage;

import android.view.View;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: zq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class zq0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;

    public /* synthetic */ zq0(du0 du0) {
        this.f = du0;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(du0, "$lBottomSheet");
        du0.dismiss();
    }
}
