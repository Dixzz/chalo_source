package defpackage;

import android.view.View;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: bq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bq0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ bq0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ui1.m0(new ed1("home screen profile icon clicked", Long.MIN_VALUE));
        T t = homeScreenMainFragment.f;
        n86.c(t);
        ((cy) t).f.p(8388611, true);
    }
}
