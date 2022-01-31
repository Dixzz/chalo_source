package defpackage;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: d24  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class d24 extends j24 {
    public final AtomicReference<Bundle> f = new AtomicReference<>();
    public boolean g;

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r4 = r4.get("r");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T F(android.os.Bundle r4, java.lang.Class<T> r5) {
        /*
            if (r4 == 0) goto L_0x0031
            java.lang.String r0 = "r"
            java.lang.Object r4 = r4.get(r0)
            if (r4 == 0) goto L_0x0031
            java.lang.Object r4 = r5.cast(r4)     // Catch:{ ClassCastException -> 0x000f }
            return r4
        L_0x000f:
            r0 = move-exception
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received"
            java.lang.String r2 = ": %s, %s"
            java.lang.String r1 = r1.concat(r2)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r4
            java.lang.String.format(r1, r2)
            throw r0
        L_0x0031:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d24.F(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    public final Bundle C1(long j) {
        Bundle bundle;
        synchronized (this.f) {
            if (!this.g) {
                try {
                    this.f.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f.get();
        }
        return bundle;
    }

    public final String L(long j) {
        return (String) F(C1(j), String.class);
    }

    @Override // defpackage.g24
    public final void zza(Bundle bundle) {
        synchronized (this.f) {
            try {
                this.f.set(bundle);
                this.g = true;
                this.f.notify();
            } catch (Throwable th) {
                this.f.notify();
                throw th;
            }
        }
    }
}
