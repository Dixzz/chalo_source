package defpackage;

import app.zophop.R;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import com.google.android.play.core.install.InstallState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* renamed from: gu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class gu0 implements fv4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f1303a;

    public gu0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f1303a = homeScreenMainFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ex4
    public void a(InstallState installState) {
        InstallState installState2 = installState;
        n86.e(installState2, RemoteConfigConstants.ResponseFieldKey.STATE);
        ed1 ed1 = new ed1("appUpdateStateUpdated", Long.MIN_VALUE);
        ed1.a("appUpdateStaus", installState2);
        ui1.m0(ed1);
        if (installState2.c() == 11) {
            String string = this.f1303a.getResources().getString(R.string.inapp_update_message);
            n86.d(string, "resources.getString(R.string.inapp_update_message)");
            HomeScreenMainFragment homeScreenMainFragment = this.f1303a;
            HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
            homeScreenMainFragment.t(string, true);
        } else if (installState2.c() == 4) {
            HomeScreenMainFragment homeScreenMainFragment2 = this.f1303a;
            HomeScreenMainFragment.a aVar2 = HomeScreenMainFragment.v;
            homeScreenMainFragment2.l().e(this);
        }
    }
}
