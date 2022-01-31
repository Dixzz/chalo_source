package defpackage;

import android.content.Context;
import com.google.android.gms.internal.p000firebaseauthapi.zzvz;
import com.google.android.gms.internal.p000firebaseauthapi.zzwm;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

/* renamed from: p43  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class p43 extends d13<l53> {
    public final Context b;
    public final l53 c;
    public final Future<z03<l53>> d = a();

    public p43(Context context, l53 l53) {
        this.b = context;
        this.c = l53;
    }

    public static zzx e(FirebaseApp firebaseApp, zzvz zzvz) {
        Objects.requireNonNull(firebaseApp, "null reference");
        Objects.requireNonNull(zzvz, "null reference");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzvz, "firebase"));
        List<zzwm> list = zzvz.k.f;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new zzt(list.get(i)));
            }
        }
        zzx zzx = new zzx(firebaseApp, arrayList);
        zzx.zzm(new zzz(zzvz.o, zzvz.n));
        zzx.zzn(zzvz.p);
        zzx.zzp(zzvz.q);
        zzx.zzi(zzba.zzb(zzvz.r));
        return zzx;
    }

    @Override // defpackage.d13
    public final Future<z03<l53>> a() {
        Future<z03<l53>> future = this.d;
        if (future != null) {
            return future;
        }
        return iu2.b.a(2).submit(new q43(this.c, this.b));
    }
}
