package defpackage;

import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassApplicationStatus;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;

/* renamed from: wp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wp0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f3820a;

    public /* synthetic */ wp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f3820a = homeScreenMainFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        HomeScreenMainFragment homeScreenMainFragment = this.f3820a;
        List<SuperPassApplication> list = (List) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        if (list != null) {
            for (SuperPassApplication superPassApplication : list) {
                if (!homeScreenMainFragment.o().f().a(String.valueOf(superPassApplication.getPassStartDate()))) {
                    ed1 ed1 = new ed1("pass status prompt open", Long.MIN_VALUE);
                    ed1.a("pass status", superPassApplication.getSuperPassApplicationStatus().name());
                    ui1.m0(ed1);
                    if (superPassApplication.getSuperPassApplicationStatus() == SuperPassApplicationStatus.REJECTED) {
                        i20 o = xt.f3961a.o();
                        HomeActivity.a aVar2 = HomeActivity.k;
                        o.b("Home Screen", new rn0(80, new fr0(homeScreenMainFragment, superPassApplication)));
                        return;
                    } else if (superPassApplication.getSuperPassApplicationStatus() == SuperPassApplicationStatus.VERIFIED) {
                        i20 o2 = xt.f3961a.o();
                        HomeActivity.a aVar3 = HomeActivity.k;
                        o2.b("Home Screen", new rn0(80, new cr0(homeScreenMainFragment, superPassApplication)));
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
