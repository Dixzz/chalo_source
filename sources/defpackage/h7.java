package defpackage;

import defpackage.i7;

/* renamed from: h7  reason: default package */
/* compiled from: FontRequestWorker */
public class h7 implements t7<i7.a> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1344a;

    public h7(String str) {
        this.f1344a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r0 >= r2.size()) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r2.get(r0).a(r5);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0 = 0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.i7.a r5) {
        /*
            r4 = this;
            java.lang.Object r0 = defpackage.i7.c
            monitor-enter(r0)
            u2<java.lang.String, java.util.ArrayList<t7<i7$a>>> r1 = defpackage.i7.d     // Catch:{ all -> 0x002b }
            java.lang.String r2 = r4.f1344a     // Catch:{ all -> 0x002b }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ all -> 0x002b }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x002b }
            if (r2 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0011:
            java.lang.String r3 = r4.f1344a     // Catch:{ all -> 0x002b }
            r1.remove(r3)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            r0 = 0
        L_0x0018:
            int r1 = r2.size()
            if (r0 >= r1) goto L_0x002a
            java.lang.Object r1 = r2.get(r0)
            t7 r1 = (defpackage.t7) r1
            r1.a(r5)
            int r0 = r0 + 1
            goto L_0x0018
        L_0x002a:
            return
        L_0x002b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h7.a(i7$a):void");
    }
}
