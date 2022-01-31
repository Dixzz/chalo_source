package defpackage;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import app.zophop.models.City;
import defpackage.xt;

/* renamed from: c90  reason: default package */
/* compiled from: SyncAdapter */
public class c90 extends AbstractThreadedSyncAdapter {
    public c90(Context context, boolean z) {
        super(context, z);
    }

    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        xt.t1 t1Var = xt.f3961a;
        t1Var.k().g();
        City d = t1Var.k().d();
        if (d != null) {
            t1Var.N().b(true);
            m10 m10 = new m10(getContext(), t1Var.S());
            i30 A = t1Var.A();
            m10.g(d.getName(), A.d(), A.i(), A.h(), true);
        }
    }
}
