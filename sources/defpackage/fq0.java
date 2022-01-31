package defpackage;

import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;

/* renamed from: fq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fq0 implements Runnable {
    public final /* synthetic */ HomeScreenMainFragment f;
    public final /* synthetic */ List g;

    public /* synthetic */ fq0(HomeScreenMainFragment homeScreenMainFragment, List list) {
        this.f = homeScreenMainFragment;
        this.g = list;
    }

    public final void run() {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        List list = this.g;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        if (homeScreenMainFragment.getView() != null) {
            fh viewLifecycleOwner = homeScreenMainFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(homeScreenMainFragment), null, new ku0(homeScreenMainFragment, null, homeScreenMainFragment, list), 2, null);
        }
    }
}
