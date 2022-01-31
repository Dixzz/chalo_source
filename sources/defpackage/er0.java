package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import defpackage.km0;

/* renamed from: er0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class er0 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMainFragment f;

    public /* synthetic */ er0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f = homeScreenMainFragment;
    }

    public final void onClick(View view) {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        FragmentManager parentFragmentManager = homeScreenMainFragment.getParentFragmentManager();
        km0.a aVar2 = km0.a.MANUAL;
        n86.e(aVar2, "checkInEnd");
        km0 km0 = new km0();
        Bundle bundle = new Bundle();
        bundle.putString("check_in_stop_source", aVar2.name());
        km0.setArguments(bundle);
        if (parentFragmentManager != null) {
            km0.show(parentFragmentManager, "confirmation_dialog");
        }
    }
}
