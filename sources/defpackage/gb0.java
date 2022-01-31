package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import app.zophop.ui.activities.AccountLoginActivity;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.Status;
import com.google.firebase.perf.util.Constants;
import defpackage.uz1;
import java.util.Objects;

/* renamed from: gb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class gb0 implements g32<xz1> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountLoginActivity f1233a;

    public gb0(AccountLoginActivity accountLoginActivity) {
        this.f1233a = accountLoginActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [f32] */
    @Override // defpackage.g32
    public void a(xz1 xz1) {
        xz1 xz12 = xz1;
        if (xz12.M0().m1()) {
            AccountLoginActivity accountLoginActivity = this.f1233a;
            Credential credential = xz12.getCredential();
            int i = AccountLoginActivity.E;
            accountLoginActivity.s0(credential);
            return;
        }
        AccountLoginActivity accountLoginActivity2 = this.f1233a;
        Status M0 = xz12.M0();
        int i2 = AccountLoginActivity.E;
        Objects.requireNonNull(accountLoginActivity2);
        if (M0.l1()) {
            int i3 = M0.g;
            if (i3 == 4) {
                HintRequest hintRequest = new HintRequest(2, new CredentialPickerConfig(2, false, true, false, 1), false, true, new String[0], false, null, null);
                yz1 yz1 = uz1.g;
                a32 a32 = accountLoginActivity2.v;
                Objects.requireNonNull((ce2) yz1);
                gj1.l(a32, "client must not be null");
                gj1.l(hintRequest, "request must not be null");
                uz1.a aVar = ((ge2) a32.k(uz1.f3572a)).f1244a;
                Context l = a32.l();
                gj1.l(l, "context must not be null");
                gj1.l(hintRequest, "request must not be null");
                Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", (String) null);
                gj1.l0(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
                accountLoginActivity2.startIntentSenderForResult(PendingIntent.getActivity(l, Constants.MAX_URL_LENGTH, putExtra, 134217728).getIntentSender(), 2, null, 0, 0, 0);
            } else if (i3 == 6) {
                try {
                    M0.n1(accountLoginActivity2, 1);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }
    }
}
