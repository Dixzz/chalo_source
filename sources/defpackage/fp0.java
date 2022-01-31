package defpackage;

import android.view.View;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: fp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fp0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ fp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ed1 ed1 = new ed1("app update install clicked", Long.MIN_VALUE);
        ed1.a("updateType", Integer.valueOf(homeScreenMainFragment.o().t()));
        ui1.m0(ed1);
        homeScreenMainFragment.l().a();
    }
}
