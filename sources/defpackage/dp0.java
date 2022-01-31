package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.CitySelectionActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: dp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class dp0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ HomeScreenMainFragment g;

    public /* synthetic */ dp0(du0 du0, HomeScreenMainFragment homeScreenMainFragment) {
        this.f = du0;
        this.g = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        du0 du0 = this.f;
        HomeScreenMainFragment homeScreenMainFragment = this.g;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(du0, "$lBottomSheet");
        n86.e(homeScreenMainFragment, "this$0");
        du0.dismiss();
        du0.f = true;
        homeScreenMainFragment.startActivity(new Intent(homeScreenMainFragment.getContext(), CitySelectionActivity.class));
    }
}
