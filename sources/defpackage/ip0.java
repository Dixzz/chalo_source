package defpackage;

import android.content.Context;
import androidx.appcompat.app.AlertController;
import app.zophop.R;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import defpackage.e0;

/* renamed from: ip0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ip0 implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f1549a;

    public /* synthetic */ ip0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f1549a = homeScreenMainFragment;
    }

    @Override // defpackage.q
    public final void a(Object obj) {
        HomeScreenMainFragment homeScreenMainFragment = this.f1549a;
        Boolean bool = (Boolean) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        n86.d(bool, "isGranted");
        if (bool.booleanValue()) {
            homeScreenMainFragment.x();
            return;
        }
        Context context = homeScreenMainFragment.getContext();
        if (context != null) {
            e0.a aVar2 = new e0.a(context);
            String string = homeScreenMainFragment.getString(R.string.location_permission_prompt);
            AlertController.b bVar = aVar2.f908a;
            bVar.f = string;
            bVar.k = true;
            aVar2.c(homeScreenMainFragment.getString(R.string.settings), new uq0(context, homeScreenMainFragment));
            gq0 gq0 = gq0.f;
            AlertController.b bVar2 = aVar2.f908a;
            bVar2.i = "Cancel";
            bVar2.j = gq0;
            e0 a2 = aVar2.a();
            n86.d(a2, "lBuilder.create()");
            a2.show();
        }
    }
}
