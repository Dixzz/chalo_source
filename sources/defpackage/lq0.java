package defpackage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import app.zophop.models.City;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: lq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lq0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ lq0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        T t = homeScreenMainFragment.f;
        n86.c(t);
        ((cy) t).t.removeAllViews();
        T t2 = homeScreenMainFragment.f;
        n86.c(t2);
        ((cy) t2).u.setVisibility(8);
        City d = xt.f3961a.k().d();
        n86.c(d);
        String j = n86.j("partner_card_dismissed", d.getName());
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(homeScreenMainFragment.c()).edit();
        edit.putBoolean(j, true);
        edit.commit();
    }
}
