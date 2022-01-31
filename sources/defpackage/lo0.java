package defpackage;

import android.view.View;
import app.zophop.ui.fragments.CitySelectionFragment;

/* renamed from: lo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lo0 implements View.OnClickListener {
    public final /* synthetic */ CitySelectionFragment f;

    public /* synthetic */ lo0(CitySelectionFragment citySelectionFragment) {
        this.f = citySelectionFragment;
    }

    public final void onClick(View view) {
        CitySelectionFragment citySelectionFragment = this.f;
        int i = CitySelectionFragment.k;
        n86.e(citySelectionFragment, "this$0");
        T t = citySelectionFragment.f;
        n86.c(t);
        ((uw) t).d.b.setVisibility(8);
        T t2 = citySelectionFragment.f;
        n86.c(t2);
        ((uw) t2).d.d.setVisibility(0);
        citySelectionFragment.f().f();
    }
}
