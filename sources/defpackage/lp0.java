package defpackage;

import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;

/* renamed from: lp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class lp0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f2253a;

    public /* synthetic */ lp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f2253a = homeScreenMainFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        HomeScreenMainFragment homeScreenMainFragment = this.f2253a;
        List list = (List) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        if (list.size() > 1 && homeScreenMainFragment.n().getItemCount() == 1) {
            homeScreenMainFragment.n().d(null);
        }
        bk0 n = homeScreenMainFragment.n();
        n.f2701a.b(list, new cp0(homeScreenMainFragment, list));
    }
}
