package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;

/* renamed from: jf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class jf4 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ zzn h;
    public final /* synthetic */ g24 i;
    public final /* synthetic */ re4 j;

    public jf4(re4 re4, String str, String str2, zzn zzn, g24 g24) {
        this.j = re4;
        this.f = str;
        this.g = str2;
        this.h = zzn;
        this.i = g24;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            re4 re4 = this.j;
            ja4 ja4 = re4.d;
            if (ja4 == null) {
                re4.g().f.c("Failed to get conditional properties; not connected to service", this.f, this.g);
                return;
            }
            ArrayList<Bundle> i0 = ug4.i0(ja4.s1(this.f, this.g, this.h));
            this.j.E();
            this.j.h().M(this.i, i0);
        } catch (RemoteException e) {
            this.j.g().f.d("Failed to get conditional properties; remote exception", this.f, this.g, e);
        } finally {
            this.j.h().M(this.i, arrayList);
        }
    }
}
