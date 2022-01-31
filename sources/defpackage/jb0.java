package defpackage;

import android.view.View;
import app.zophop.ui.activities.AccountLoginActivity;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.truecaller.android.sdk.TruecallerSDK;
import java.util.Objects;

/* renamed from: jb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class jb0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountLoginActivity f1898a;

    public jb0(AccountLoginActivity accountLoginActivity) {
        this.f1898a = accountLoginActivity;
    }

    public void onFocusChange(View view, boolean z) {
        AccountLoginActivity accountLoginActivity = this.f1898a;
        int i = AccountLoginActivity.E;
        Objects.requireNonNull(accountLoginActivity);
        if (TruecallerSDK.getInstance().isUsable() && xt.f3961a.t().b("shouldEnableAutoFill") && accountLoginActivity.x) {
            AccountLoginActivity accountLoginActivity2 = this.f1898a;
            if (!accountLoginActivity2.w) {
                accountLoginActivity2.w = true;
                CredentialRequest credentialRequest = new CredentialRequest(4, true, new String[]{"https://accounts.google.com"}, null, null, false, null, null, false);
                yz1 yz1 = uz1.g;
                a32 a32 = accountLoginActivity2.v;
                Objects.requireNonNull((ce2) yz1);
                gj1.l(a32, "client must not be null");
                gj1.l(credentialRequest, "request must not be null");
                a32.i(new de2(a32, credentialRequest)).b(new gb0(accountLoginActivity2));
            }
        }
    }
}
