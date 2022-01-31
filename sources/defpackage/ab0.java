package defpackage;

import android.widget.Toast;
import app.zophop.R;
import app.zophop.ui.activities.AccountLoginActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import org.json.JSONException;

/* renamed from: ab0  reason: default package */
/* compiled from: AccountLoginActivity */
public class ab0 implements ti4<GetTokenResult> {
    public final /* synthetic */ FirebaseUser f;
    public final /* synthetic */ AccountLoginActivity g;

    public ab0(AccountLoginActivity accountLoginActivity, FirebaseUser firebaseUser) {
        this.g = accountLoginActivity;
        this.f = firebaseUser;
    }

    @Override // defpackage.ti4
    public void onComplete(yi4<GetTokenResult> yi4) {
        try {
            AccountLoginActivity.j0(this.g, this.f, yi4.m().getToken());
        } catch (JSONException e) {
            AccountLoginActivity accountLoginActivity = this.g;
            Toast.makeText(accountLoginActivity, accountLoginActivity.getResources().getString(R.string.profile_fetch_please_try_again), 0).show();
            b00 b00 = b00.f358a;
            hj1.W0(e);
        }
    }
}
