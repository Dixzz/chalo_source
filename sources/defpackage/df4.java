package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;

/* renamed from: df4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class df4 implements Runnable {
    public final /* synthetic */ zzaq f;
    public final /* synthetic */ String g;
    public final /* synthetic */ g24 h;
    public final /* synthetic */ re4 i;

    public df4(re4 re4, zzaq zzaq, String str, g24 g24) {
        this.i = re4;
        this.f = zzaq;
        this.g = str;
        this.h = g24;
    }

    public final void run() {
        try {
            re4 re4 = this.i;
            ja4 ja4 = re4.d;
            if (ja4 == null) {
                re4.g().f.a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] R = ja4.R(this.f, this.g);
            this.i.E();
            this.i.h().O(this.h, R);
        } catch (RemoteException e) {
            this.i.g().f.b("Failed to send event to the service to bundle", e);
        } finally {
            this.i.h().O(this.h, null);
        }
    }
}
