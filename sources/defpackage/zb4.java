package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzn;
import defpackage.uq3;
import defpackage.wq3;
import java.util.Iterator;

/* renamed from: zb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zb4 implements Runnable {
    public final ac4 f;
    public final zzn g;
    public final Bundle h;

    public zb4(ac4 ac4, zzn zzn, Bundle bundle) {
        this.f = ac4;
        this.g = zzn;
        this.h = bundle;
    }

    public final void run() {
        zzap zzap;
        ac4 ac4 = this.f;
        zzn zzn = this.g;
        Bundle bundle = this.h;
        h64 K = ac4.f.K();
        String str = zzn.f;
        K.b();
        K.k();
        vb4 vb4 = K.f3331a;
        gj1.j(str);
        gj1.j("dep");
        TextUtils.isEmpty("");
        if (bundle == null || bundle.isEmpty()) {
            zzap = new zzap(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    vb4.g().f.a("Param name can't be null");
                    it.remove();
                } else {
                    Object C = vb4.t().C(next, bundle2.get(next));
                    if (C == null) {
                        vb4.g().i.b("Param value can't be null", vb4.u().w(next));
                        it.remove();
                    } else {
                        vb4.t().H(bundle2, next, C);
                    }
                }
            }
            zzap = new zzap(bundle2);
        }
        rg4 j = K.j();
        uq3.a L = uq3.L();
        if (L.h) {
            L.i();
            L.h = false;
        }
        uq3.D((uq3) L.g, 0);
        for (String str2 : zzap.f.keySet()) {
            wq3.a P = wq3.P();
            P.o(str2);
            j.E(P, zzap.l1(str2));
            L.o(P);
        }
        byte[] h2 = ((uq3) ((ru3) L.k())).h();
        K.g().n.c("Saving default event parameters, appId, data size", K.d().t(str), Integer.valueOf(h2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", h2);
        try {
            if (K.s().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                K.g().f.b("Failed to insert default event parameters (got -1). appId", ra4.q(str));
            }
        } catch (SQLiteException e) {
            K.g().f.c("Error storing default event parameters. appId", ra4.q(str), e);
        }
    }
}
