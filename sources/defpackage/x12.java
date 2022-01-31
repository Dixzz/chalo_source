package defpackage;

/* renamed from: x12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class x12 implements Runnable {
    public final t12 f;

    public x12(t12 t12) {
        this.f = t12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        java.lang.String.valueOf(r1).length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r3 = r0.f.f3167a;
        r4 = r0.b;
        r5 = android.os.Message.obtain();
        r5.what = r1.c;
        r5.arg1 = r1.f915a;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.d());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.d);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = r0.c;
        r3 = r1.f507a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        if (r3 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        r3.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0087, code lost:
        r1 = r1.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        if (r1 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r1 = r1.f;
        java.util.Objects.requireNonNull(r1);
        r1.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        throw new java.lang.IllegalStateException("Both messengers are null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        r0.a(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x12.run():void");
    }
}
