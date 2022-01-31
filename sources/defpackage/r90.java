package defpackage;

import app.zophop.ui.activities.HomeScreenMapActivity;
import app.zophop.ui.fragments.HomeScreenMapFragment;

/* renamed from: r90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class r90 implements Runnable {
    public final /* synthetic */ HomeScreenMapActivity f;

    public /* synthetic */ r90(HomeScreenMapActivity homeScreenMapActivity) {
        this.f = homeScreenMapActivity;
    }

    public final void run() {
        HomeScreenMapActivity homeScreenMapActivity = this.f;
        int i = HomeScreenMapActivity.o;
        n86.e(homeScreenMapActivity, "this$0");
        HomeScreenMapFragment p0 = homeScreenMapActivity.p0();
        if (p0 != null) {
            p0.h();
        }
    }
}
