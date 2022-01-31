package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: te4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class te4 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ zzn i;
    public final /* synthetic */ g24 j;
    public final /* synthetic */ re4 k;

    public te4(re4 re4, String str, String str2, boolean z, zzn zzn, g24 g24) {
        this.k = re4;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = zzn;
        this.j = g24;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            re4 re4 = this.k;
            ja4 ja4 = re4.d;
            if (ja4 == null) {
                re4.g().f.c("Failed to get user properties; not connected to service", this.f, this.g);
                return;
            }
            Bundle z = ug4.z(ja4.L1(this.f, this.g, this.h, this.i));
            this.k.E();
            this.k.h().K(this.j, z);
        } catch (RemoteException e) {
            this.k.g().f.c("Failed to get user properties; remote exception", this.f, e);
        } finally {
            this.k.h().K(this.j, bundle);
        }
    }
}
