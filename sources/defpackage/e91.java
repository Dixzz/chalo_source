package defpackage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ContentResolver;
import android.os.Bundle;
import app.zophop.R;
import defpackage.xt;

@y66(c = "app.zophop.ui.viewmodels.SplashScreenViewModel$initializeProcess$1", f = "SplashScreenViewModel.kt", l = {}, m = "invokeSuspend")
/* renamed from: e91  reason: default package */
/* compiled from: SplashScreenViewModel.kt */
public final class e91 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public final /* synthetic */ d91 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e91(d91 d91, k66<? super e91> k66) {
        super(2, k66);
        this.f = d91;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new e91(this.f, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        e91 e91 = new e91(this.f, k66);
        s56 s56 = s56.f3190a;
        e91.invokeSuspend(s56);
        return s56;
    }

    @Override // defpackage.u66
    public final Object invokeSuspend(Object obj) {
        p66 p66 = p66.COROUTINE_SUSPENDED;
        hd3.Y2(obj);
        ui1.h0("");
        xt.t1 t1Var = xt.f3961a;
        t1Var.n0().a();
        t1Var.p().a();
        if (!((rf1) this.f.e.getValue()).b.contains("appOpenTime")) {
            rf1 rf1 = (rf1) this.f.e.getValue();
            rf1.f3075a.putLong("appOpenTime", ui1.Q());
            rf1.f3075a.commit();
        }
        Application application = this.f.c;
        Account account = new Account("SyncAdapterAccount", application.getResources().getString(R.string.account_details));
        ((AccountManager) application.getSystemService("account")).addAccountExplicitly(account, null, null);
        ContentResolver.setSyncAutomatically(account, "app.zophop.provider", true);
        ContentResolver.addPeriodicSync(account, "app.zophop.provider", new Bundle(), 43200);
        ui1.h0("splash screen handler time");
        return s56.f3190a;
    }
}
