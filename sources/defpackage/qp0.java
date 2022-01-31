package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.ProductHistoryActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: qp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qp0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ qp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        ui1.m0(new ed1("home screen your plans see all clicked", Long.MIN_VALUE));
        Intent intent = new Intent(homeScreenMainFragment.getContext(), ProductHistoryActivity.class);
        intent.putExtra("source", "Home Screen");
        homeScreenMainFragment.startActivity(intent);
    }
}
