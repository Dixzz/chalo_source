package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.ui.activities.WebViewActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: vq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vq0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ vq0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        String string = homeScreenMainFragment.getString(R.string.partners);
        n86.d(string, "getString(R.string.partners)");
        ve activity = homeScreenMainFragment.c();
        City d = xt.f3961a.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        homeScreenMainFragment.startActivity(WebViewActivity.i0(activity, n86.j("https://www.chalo.com/inapp/partners/", lowerCase), string, false, false));
    }
}
