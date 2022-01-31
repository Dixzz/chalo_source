package defpackage;

import app.zophop.ui.activities.WebViewActivity;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import defpackage.gw0;

/* renamed from: wu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class wu0 implements gw0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f3841a;

    public wu0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f3841a = homeScreenMainFragment;
    }

    @Override // defpackage.gw0.a
    public void a() {
        hj1.O0("seat occupancy bottomsheet rendered on homescreen", Long.MIN_VALUE);
    }

    @Override // defpackage.gw0.a
    public void b() {
        hj1.O0("seat occupancy bottomsheet got it clicked", Long.MIN_VALUE);
        xt.f3961a.l().put("seatOccupancyDialogShown", "true");
    }

    @Override // defpackage.gw0.a
    public void c(String str) {
        xt.f3961a.l().put("seatOccupancyDialogShown", "true");
        hj1.O0("seat occupancy bottomsheet learn more clicked", Long.MIN_VALUE);
        HomeScreenMainFragment homeScreenMainFragment = this.f3841a;
        homeScreenMainFragment.startActivity(WebViewActivity.i0(homeScreenMainFragment.getContext(), str, "Feature Update", false, false));
    }
}
