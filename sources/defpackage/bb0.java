package defpackage;

import android.content.Intent;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.AccountLoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import defpackage.xt;
import defpackage.yj1;
import java.util.Objects;
import org.json.JSONException;

/* renamed from: bb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class bb0 implements yj1.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountLoginActivity f403a;

    public bb0(AccountLoginActivity accountLoginActivity) {
        this.f403a = accountLoginActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(String str) {
        try {
            AccountLoginActivity.k0(this.f403a, str);
            String l0 = AccountLoginActivity.l0(this.f403a);
            xt.t1 t1Var = xt.f3961a;
            t1Var.L().h(l0);
            FirebaseAuth.getInstance();
            Objects.requireNonNull(this.f403a);
            Intent intent = new Intent();
            intent.putExtra("phone_no", l0);
            intent.putExtra("user_id", l0);
            intent.putExtra("src", this.f403a.n);
            Objects.requireNonNull(this.f403a);
            AccountLoginActivity accountLoginActivity = this.f403a;
            if (accountLoginActivity.s == null && accountLoginActivity.t == null) {
                if (accountLoginActivity.u == null) {
                    accountLoginActivity.q0();
                    this.f403a.setResult(-1, intent);
                    this.f403a.finish();
                    AccountLoginActivity accountLoginActivity2 = this.f403a;
                    AccountLoginActivity.h0(accountLoginActivity2, "login successful", false, "login call success", AccountLoginActivity.l0(accountLoginActivity2));
                }
            }
            AccountLoginActivity.m0(accountLoginActivity, l0, null, null, null, l0);
            t1Var.L().l(true);
            AccountLoginActivity accountLoginActivity22 = this.f403a;
            AccountLoginActivity.h0(accountLoginActivity22, "login successful", false, "login call success", AccountLoginActivity.l0(accountLoginActivity22));
        } catch (JSONException e) {
            AccountLoginActivity accountLoginActivity3 = this.f403a;
            int i = AccountLoginActivity.E;
            accountLoginActivity3.q0();
            AccountLoginActivity accountLoginActivity4 = this.f403a;
            Toast.makeText(accountLoginActivity4, accountLoginActivity4.getResources().getString(R.string.profile_fetch_please_try_again), 0).show();
            e.printStackTrace();
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
