package defpackage;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: if4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class if4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ zzn k;
    public final /* synthetic */ re4 l;

    public if4(re4 re4, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzn zzn) {
        this.l = re4;
        this.f = atomicReference;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = z;
        this.k = zzn;
    }

    public final void run() {
        synchronized (this.f) {
            try {
                re4 re4 = this.l;
                ja4 ja4 = re4.d;
                if (ja4 == null) {
                    re4.g().f.d("(legacy) Failed to get user properties; not connected to service", ra4.q(this.g), this.h, this.i);
                    this.f.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.g)) {
                    this.f.set(ja4.L1(this.h, this.i, this.j, this.k));
                } else {
                    this.f.set(ja4.p0(this.g, this.h, this.i, this.j));
                }
                this.l.E();
                this.f.notify();
            } catch (RemoteException e) {
                this.l.g().f.d("(legacy) Failed to get user properties; remote exception", ra4.q(this.g), this.h, e);
                this.f.set(Collections.emptyList());
            } finally {
                this.f.notify();
            }
        }
    }
}
