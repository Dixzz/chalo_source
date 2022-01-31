package defpackage;

import android.view.View;
import app.zophop.ui.fragments.CitySelectionFragment;

/* renamed from: po0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class po0 implements View.OnClickListener {
    public final /* synthetic */ CitySelectionFragment f;

    public /* synthetic */ po0(CitySelectionFragment citySelectionFragment) {
        this.f = citySelectionFragment;
    }

    public final void onClick(View view) {
        CitySelectionFragment citySelectionFragment = this.f;
        int i = CitySelectionFragment.k;
        n86.e(citySelectionFragment, "this$0");
        citySelectionFragment.i();
        ui1.m0(new ed1("city selection search icon clicked", Long.MIN_VALUE));
    }
}
