package defpackage;

/* renamed from: be1  reason: default package */
/* compiled from: RabbitQueue */
public class be1 implements Runnable {
    public final /* synthetic */ ce1 f;

    public be1(ce1 ce1) {
        this.f = ce1;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(1:17)|(2:3|16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r6.f.d();
        r0 = r6.f;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (defpackage.vn.K0(r0.f556a) != false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r0.n = true;
        java.lang.Thread.sleep(5000);
        r0.n = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        r2 = true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:11:0x002f, LOOP_START, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
        L_0x0000:
            ce1 r0 = r6.f     // Catch:{ InterruptedException -> 0x0000, Exception -> 0x0011 }
            defpackage.ce1.a(r0)     // Catch:{ InterruptedException -> 0x0000, Exception -> 0x0011 }
            ce1 r0 = r6.f     // Catch:{ InterruptedException -> 0x0000, Exception -> 0x0011 }
            com.rabbitmq.client.Connection r0 = r0.g     // Catch:{ InterruptedException -> 0x0000, Exception -> 0x0011 }
            if (r0 == 0) goto L_0x0031
        L_0x000b:
            ce1 r0 = r6.f     // Catch:{ InterruptedException -> 0x0000, Exception -> 0x0011 }
            defpackage.ce1.b(r0)     // Catch:{ InterruptedException -> 0x0000, Exception -> 0x0011 }
            goto L_0x000b
        L_0x0011:
            ce1 r0 = r6.f
            r0.d()
            ce1 r0 = r6.f
            android.content.Context r1 = r0.f556a
            boolean r1 = defpackage.vn.K0(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x002f
            r0.n = r3     // Catch:{ InterruptedException -> 0x002e }
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x002e }
            r0.n = r2     // Catch:{ InterruptedException -> 0x002e }
            r2 = 1
            goto L_0x002f
        L_0x002e:
        L_0x002f:
            if (r2 != 0) goto L_0x0000
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.be1.run():void");
    }
}
