package defpackage;

import android.content.DialogInterface;
import app.zophop.ui.activities.AccountLoginActivity;

/* renamed from: kb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class kb0 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ AccountLoginActivity f;

    public kb0(AccountLoginActivity accountLoginActivity) {
        this.f = accountLoginActivity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f.finish();
    }
}
