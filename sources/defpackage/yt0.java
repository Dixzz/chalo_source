package defpackage;

import app.zophop.ui.fragments.CitySelectionFragment;

/* renamed from: yt0  reason: default package */
/* compiled from: CitySelectionFragment.kt */
public final class yt0 extends o86 implements h76<s56> {
    public final /* synthetic */ CitySelectionFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yt0(CitySelectionFragment citySelectionFragment) {
        super(0);
        this.f = citySelectionFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public s56 invoke() {
        CitySelectionFragment citySelectionFragment = this.f;
        if (citySelectionFragment.getView() != null) {
            fh viewLifecycleOwner = citySelectionFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(citySelectionFragment), null, new xt0(citySelectionFragment, null, citySelectionFragment), 2, null);
        }
        return s56.f3190a;
    }
}
