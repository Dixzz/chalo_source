package defpackage;

import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.AccountLoginActivity;
import defpackage.yj1;

/* renamed from: cb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class cb0 implements yj1.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountLoginActivity f542a;

    public cb0(AccountLoginActivity accountLoginActivity) {
        this.f542a = accountLoginActivity;
    }

    @Override // defpackage.yj1.a
    public void a(dk1 dk1) {
        AccountLoginActivity accountLoginActivity = this.f542a;
        int i = AccountLoginActivity.E;
        accountLoginActivity.q0();
        AccountLoginActivity accountLoginActivity2 = this.f542a;
        AccountLoginActivity.h0(accountLoginActivity2, "login failed", false, "login call failed", AccountLoginActivity.l0(accountLoginActivity2));
        AccountLoginActivity accountLoginActivity3 = this.f542a;
        Toast.makeText(accountLoginActivity3, accountLoginActivity3.getResources().getString(R.string.profile_fetch_please_try_again), 0).show();
        b00 b00 = b00.f358a;
        b00.a().b(dk1);
    }
}
