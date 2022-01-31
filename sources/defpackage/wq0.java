package defpackage;

import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;

/* renamed from: wq0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wq0 implements Runnable {
    public final /* synthetic */ HomeScreenMainFragment f;
    public final /* synthetic */ List g;

    public /* synthetic */ wq0(HomeScreenMainFragment homeScreenMainFragment, List list) {
        this.f = homeScreenMainFragment;
        this.g = list;
    }

    public final void run() {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        List list = this.g;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.e(list, "$lAllBookingItems");
        if (homeScreenMainFragment.getView() != null) {
            fh viewLifecycleOwner = homeScreenMainFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(homeScreenMainFragment), null, new lu0(homeScreenMainFragment, null, list, homeScreenMainFragment), 2, null);
        }
    }
}
