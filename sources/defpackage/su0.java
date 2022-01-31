package defpackage;

import app.zophop.ui.fragments.HomeScreenMainFragment;

/* renamed from: su0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class su0 extends o86 implements h76<s56> {
    public final /* synthetic */ HomeScreenMainFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public su0(HomeScreenMainFragment homeScreenMainFragment) {
        super(0);
        this.f = homeScreenMainFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public s56 invoke() {
        HomeScreenMainFragment homeScreenMainFragment = this.f;
        if (homeScreenMainFragment.getView() != null) {
            fh viewLifecycleOwner = homeScreenMainFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(homeScreenMainFragment), null, new ru0(homeScreenMainFragment, null, homeScreenMainFragment), 2, null);
        }
        return s56.f3190a;
    }
}
