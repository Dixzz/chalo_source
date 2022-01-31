package defpackage;

import android.os.Handler;

/* renamed from: w12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class w12 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final t12 f3705a;

    public w12(t12 t12) {
        this.f3705a = t12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r2.b(new defpackage.d22(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r2.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r5 = r5.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            t12 r0 = r4.f3705a
            java.util.Objects.requireNonNull(r0)
            int r1 = r5.arg1
            monitor-enter(r0)
            android.util.SparseArray<e22<?>> r2 = r0.e     // Catch:{ all -> 0x003b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x003b }
            e22 r2 = (defpackage.e22) r2     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            goto L_0x0039
        L_0x0014:
            android.util.SparseArray<e22<?>> r3 = r0.e     // Catch:{ all -> 0x003b }
            r3.remove(r1)     // Catch:{ all -> 0x003b }
            r0.c()     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x0036
            d22 r5 = new d22
            r0 = 4
            java.lang.String r1 = "Not supported by GmsCore"
            r5.<init>(r0, r1)
            r2.b(r5)
            goto L_0x0039
        L_0x0036:
            r2.a(r5)
        L_0x0039:
            r5 = 1
            return r5
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w12.handleMessage(android.os.Message):boolean");
    }
}
