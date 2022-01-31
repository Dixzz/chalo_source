package defpackage;

import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.AccountLoginActivity;
import defpackage.yj1;

/* renamed from: eb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class eb0 implements yj1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountLoginActivity f952a;

    public eb0(AccountLoginActivity accountLoginActivity) {
        this.f952a = accountLoginActivity;
    }

    @Override // defpackage.yj1.a
    public void a(dk1 dk1) {
        AccountLoginActivity accountLoginActivity = this.f952a;
        int i = AccountLoginActivity.E;
        accountLoginActivity.q0();
        AccountLoginActivity accountLoginActivity2 = this.f952a;
        AccountLoginActivity.h0(accountLoginActivity2, "login failed", true, "login call failed", AccountLoginActivity.l0(accountLoginActivity2));
        Toast.makeText(this.f952a.getApplicationContext(), this.f952a.getResources().getString(R.string.profile_fetch_please_try_again), 0).show();
        b00 b00 = b00.f358a;
        b00.a().b(dk1);
        String str = "some error" + dk1.getCause();
    }
}
