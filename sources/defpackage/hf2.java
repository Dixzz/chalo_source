package defpackage;

import android.content.SharedPreferences;

/* renamed from: hf2  reason: default package */
public final class hf2 extends af2<T> {
    public final Object k = new Object();
    public String l;
    public T m;
    public final /* synthetic */ jf2 n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hf2(kf2 kf2, String str, Object obj, jf2 jf2) {
        super(kf2, str, obj, null);
        this.n = jf2;
    }

    @Override // defpackage.af2
    public final T b(SharedPreferences sharedPreferences) {
        try {
            return (T) e(sharedPreferences.getString(this.b, ""));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.b);
            if (valueOf.length() != 0) {
                "Invalid byte[] value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid byte[] value in SharedPreferences for ");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        java.lang.String.valueOf(r3.b).length();
        java.lang.String.valueOf(r4).length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        return null;
     */
    @Override // defpackage.af2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T e(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.k
            monitor-enter(r0)
            java.lang.String r1 = r3.l     // Catch:{ all -> 0x0023 }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x001f
            jf2 r1 = r3.n     // Catch:{ all -> 0x0023 }
            r2 = 3
            byte[] r2 = android.util.Base64.decode(r4, r2)     // Catch:{ all -> 0x0023 }
            bl2 r1 = (defpackage.bl2) r1     // Catch:{ all -> 0x0023 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ all -> 0x0023 }
            nk2 r1 = defpackage.nk2.p(r2)     // Catch:{ all -> 0x0023 }
            r3.l = r4     // Catch:{ all -> 0x0023 }
            r3.m = r1     // Catch:{ all -> 0x0023 }
        L_0x001f:
            T r1 = r3.m     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return r1
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1     // Catch:{ IOException | IllegalArgumentException -> 0x0026 }
        L_0x0026:
            java.lang.String r0 = r3.b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r0.length()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r4.length()
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hf2.e(java.lang.String):java.lang.Object");
    }
}
