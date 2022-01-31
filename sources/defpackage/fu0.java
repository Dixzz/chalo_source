package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.HomeScreenMainFragment;

@y66(c = "app.zophop.ui.fragments.HomeScreenMainFragment", f = "HomeScreenMainFragment.kt", l = {1798}, m = "askForPositiveRatingsIfRequired")
/* renamed from: fu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class fu0 extends w66 {
    public Object f;
    public Object g;
    public Object h;
    public /* synthetic */ Object i;
    public final /* synthetic */ HomeScreenMainFragment j;
    public int k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fu0(HomeScreenMainFragment homeScreenMainFragment, k66<? super fu0> k66) {
        super(k66);
        this.j = homeScreenMainFragment;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.k |= RtlSpacingHelper.UNDEFINED;
        return HomeScreenMainFragment.f(this.j, this);
    }
}
