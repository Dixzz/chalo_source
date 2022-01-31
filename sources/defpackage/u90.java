package defpackage;

import android.view.View;
import app.zophop.ui.activities.HomeScreenMapActivity;

/* renamed from: u90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class u90 implements View.OnClickListener {
    public final /* synthetic */ HomeScreenMapActivity f;

    public /* synthetic */ u90(HomeScreenMapActivity homeScreenMapActivity) {
        this.f = homeScreenMapActivity;
    }

    public final void onClick(View view) {
        HomeScreenMapActivity homeScreenMapActivity = this.f;
        int i = HomeScreenMapActivity.o;
        n86.e(homeScreenMapActivity, "this$0");
        homeScreenMapActivity.getOnBackPressedDispatcher().b();
    }
}
