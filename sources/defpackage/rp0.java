package defpackage;

import android.content.IntentSender;
import app.zophop.R;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import defpackage.xt;

/* renamed from: rp0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class rp0 implements px4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeScreenMainFragment f3108a;

    public /* synthetic */ rp0(HomeScreenMainFragment homeScreenMainFragment) {
        this.f3108a = homeScreenMainFragment;
    }

    @Override // defpackage.px4
    public final void onSuccess(Object obj) {
        long j;
        HomeScreenMainFragment homeScreenMainFragment = this.f3108a;
        nq4 nq4 = (nq4) obj;
        HomeScreenMainFragment.a aVar = HomeScreenMainFragment.v;
        n86.e(homeScreenMainFragment, "this$0");
        int t = homeScreenMainFragment.o().t();
        if (nq4.o() == 2) {
            if (nq4.j(pq4.c(t)) != null) {
                if (t != 1) {
                    if (t == 0) {
                        try {
                            xt.t1 t1Var = xt.f3961a;
                            if (t1Var.l().h.has("appSessionCount")) {
                                String optString = t1Var.l().h.optString("appSessionCount", null);
                                n86.c(optString);
                                n86.d(optString, "getPropertiesMap()[Zopho…tion.APP_SESSION_COUNT]!!");
                                j = Long.parseLong(optString);
                            } else {
                                j = 0;
                            }
                            if (j % ((long) ((int) t1Var.t().c("updateFrequency"))) != 0) {
                                return;
                            }
                        } catch (IntentSender.SendIntentException e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                }
                ve activity = homeScreenMainFragment.c();
                if (activity != null) {
                    homeScreenMainFragment.l().d(nq4, t, activity, 12345);
                }
                ed1 ed1 = new ed1("app update available", Long.MIN_VALUE);
                ed1.a("updateType", Integer.valueOf(t));
                ui1.m0(ed1);
                return;
            }
        }
        if (nq4.l() == 11) {
            ed1 ed12 = new ed1("app update downloaded", Long.MIN_VALUE);
            ed12.a("updateType", Integer.valueOf(t));
            ui1.m0(ed12);
            String string = homeScreenMainFragment.getResources().getString(R.string.inapp_update_message);
            n86.d(string, "resources.getString(R.string.inapp_update_message)");
            homeScreenMainFragment.t(string, true);
        } else if (nq4.o() == 3) {
            try {
                ed1 ed13 = new ed1("app update download processing", Long.MIN_VALUE);
                ed13.a("updateType", Integer.valueOf(t));
                ui1.m0(ed13);
                ve activity2 = homeScreenMainFragment.c();
                if (activity2 != null) {
                    homeScreenMainFragment.l().d(nq4, t, activity2, 12345);
                }
            } catch (IntentSender.SendIntentException e2) {
                e2.printStackTrace();
            }
        } else {
            ed1 ed14 = new ed1("app update error", Long.MIN_VALUE);
            hj1.u0(t, ed14, "updateType", ed14);
        }
    }
}
