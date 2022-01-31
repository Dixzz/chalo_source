package defpackage;

import android.content.Intent;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.AccountLoginActivity;
import com.truecaller.android.sdk.TrueProfile;
import defpackage.xt;
import defpackage.yj1;
import java.util.Objects;
import org.json.JSONException;

/* renamed from: db0  reason: default package */
/* compiled from: AccountLoginActivity */
public class db0 implements yj1.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrueProfile f816a;
    public final /* synthetic */ AccountLoginActivity b;

    public db0(AccountLoginActivity accountLoginActivity, TrueProfile trueProfile) {
        this.b = accountLoginActivity;
        this.f816a = trueProfile;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(String str) {
        try {
            AccountLoginActivity.k0(this.b, str);
            String substring = this.f816a.phoneNumber.substring(3);
            xt.t1 t1Var = xt.f3961a;
            t1Var.L().h(substring);
            Objects.requireNonNull(this.b);
            Intent intent = new Intent();
            intent.putExtra("first_name", this.f816a.firstName);
            intent.putExtra("last_name", this.f816a.lastName);
            intent.putExtra("user_id", substring);
            intent.putExtra("phone_no", substring);
            intent.putExtra("email_id", this.f816a.email);
            intent.putExtra("src", this.b.n);
            AccountLoginActivity accountLoginActivity = this.b;
            if (accountLoginActivity.s == null && accountLoginActivity.t == null) {
                if (accountLoginActivity.u == null) {
                    accountLoginActivity.q0();
                    this.b.setResult(-1, intent);
                    this.b.finish();
                    AccountLoginActivity accountLoginActivity2 = this.b;
                    AccountLoginActivity.h0(accountLoginActivity2, "login successful", true, "login call success", AccountLoginActivity.l0(accountLoginActivity2));
                }
            }
            TrueProfile trueProfile = this.f816a;
            AccountLoginActivity.m0(accountLoginActivity, substring, trueProfile.firstName, trueProfile.lastName, trueProfile.email, substring);
            t1Var.L().l(true);
            AccountLoginActivity accountLoginActivity22 = this.b;
            AccountLoginActivity.h0(accountLoginActivity22, "login successful", true, "login call success", AccountLoginActivity.l0(accountLoginActivity22));
        } catch (JSONException e) {
            AccountLoginActivity accountLoginActivity3 = this.b;
            Toast.makeText(accountLoginActivity3, accountLoginActivity3.getResources().getString(R.string.profile_fetch_please_try_again), 0).show();
            b00 b00 = b00.f358a;
            b00.a().b(e);
            AccountLoginActivity accountLoginActivity4 = this.b;
            int i = AccountLoginActivity.E;
            accountLoginActivity4.q0();
            e.printStackTrace();
        }
    }
}
