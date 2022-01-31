package defpackage;

import androidx.appcompat.app.AlertController;
import app.zophop.R;
import app.zophop.ui.activities.HomeScreenMapActivity;
import defpackage.e0;

/* renamed from: v90  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class v90 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMapActivity f3619a;

    public /* synthetic */ v90(HomeScreenMapActivity homeScreenMapActivity) {
        this.f3619a = homeScreenMapActivity;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        HomeScreenMapActivity homeScreenMapActivity = this.f3619a;
        Boolean bool = (Boolean) obj;
        int i = HomeScreenMapActivity.o;
        n86.e(homeScreenMapActivity, "this$0");
        n86.d(bool, "isGranted");
        if (bool.booleanValue()) {
            homeScreenMapActivity.r0();
            return;
        }
        e0.a aVar = new e0.a(homeScreenMapActivity);
        String string = homeScreenMapActivity.getString(R.string.location_permission_prompt);
        AlertController.b bVar = aVar.f908a;
        bVar.f = string;
        bVar.k = true;
        aVar.c(homeScreenMapActivity.getString(R.string.settings), new n90(homeScreenMapActivity));
        s90 s90 = s90.f;
        AlertController.b bVar2 = aVar.f908a;
        bVar2.i = "Cancel";
        bVar2.j = s90;
        e0 a2 = aVar.a();
        n86.d(a2, "lBuilder.create()");
        a2.show();
    }
}
