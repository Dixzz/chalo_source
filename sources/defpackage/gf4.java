package defpackage;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: gf4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class gf4 implements Runnable {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ zzn j;
    public final /* synthetic */ re4 k;

    public gf4(re4 re4, AtomicReference atomicReference, String str, String str2, String str3, zzn zzn) {
        this.k = re4;
        this.f = atomicReference;
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = zzn;
    }

    public final void run() {
        synchronized (this.f) {
            try {
                re4 re4 = this.k;
                ja4 ja4 = re4.d;
                if (ja4 == null) {
                    re4.g().f.d("(legacy) Failed to get conditional properties; not connected to service", ra4.q(this.g), this.h, this.i);
                    this.f.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.g)) {
                    this.f.set(ja4.s1(this.h, this.i, this.j));
                } else {
                    this.f.set(ja4.q1(this.g, this.h, this.i));
                }
                this.k.E();
                this.f.notify();
            } catch (RemoteException e) {
                this.k.g().f.d("(legacy) Failed to get conditional properties; remote exception", ra4.q(this.g), this.h, e);
                this.f.set(Collections.emptyList());
            } finally {
                this.f.notify();
            }
        }
    }
}
