package defpackage;

import app.zophop.ui.activities.HomeScreenMapActivity;

/* renamed from: t90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class t90 implements g44 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMapActivity f3321a;

    public /* synthetic */ t90(HomeScreenMapActivity homeScreenMapActivity) {
        this.f3321a = homeScreenMapActivity;
    }

    @Override // defpackage.g44
    public final void a(e44 e44) {
        HomeScreenMapActivity homeScreenMapActivity = this.f3321a;
        int i = HomeScreenMapActivity.o;
        n86.e(homeScreenMapActivity, "this$0");
        e44.k(new o90(homeScreenMapActivity));
        if (ui1.T(homeScreenMapActivity, "android.permission.ACCESS_FINE_LOCATION")) {
            ((dy) homeScreenMapActivity.f0()).b.setMap(e44);
        }
        ((dy) homeScreenMapActivity.f0()).b.setOnClickListener(new q90(homeScreenMapActivity));
    }
}
