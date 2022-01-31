package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: hp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class hp0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ hp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ui1.m0(new ed1("home screen products see all clicked", Long.MIN_VALUE));
        Intent intent = new Intent(homeScreenMainFragment.getContext(), ProductSelectionActivity.class);
        intent.putExtra("source", "Home Screen");
        Context context = homeScreenMainFragment.getContext();
        if (context != null) {
            context.startActivity(intent);
        }
    }
}
