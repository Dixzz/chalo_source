package defpackage;

/* renamed from: df2  reason: default package */
public final /* synthetic */ class df2 implements if2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f829a;

    public df2(String str) {
        this.f829a = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (defpackage.dl2.d.matcher(r1).matches() != false) goto L_0x0053;
     */
    @Override // defpackage.if2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f829a
            android.content.Context r1 = defpackage.af2.h
            android.content.ContentResolver r1 = r1.getContentResolver()
            android.net.Uri r2 = defpackage.dl2.f853a
            java.lang.Class<dl2> r2 = defpackage.dl2.class
            monitor-enter(r2)
            defpackage.dl2.c(r1)     // Catch:{ all -> 0x005c }
            java.lang.Object r3 = defpackage.dl2.k     // Catch:{ all -> 0x005c }
            monitor-exit(r2)     // Catch:{ all -> 0x005c }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r2 = defpackage.dl2.g
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            java.lang.Object r5 = defpackage.dl2.a(r2, r0, r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 == 0) goto L_0x0024
            boolean r0 = r5.booleanValue()
            goto L_0x0057
        L_0x0024:
            java.lang.String r1 = defpackage.dl2.b(r1, r0)
            r6 = 0
            if (r1 == 0) goto L_0x0052
            java.lang.String r7 = ""
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x0034
            goto L_0x0052
        L_0x0034:
            java.util.regex.Pattern r7 = defpackage.dl2.c
            java.util.regex.Matcher r7 = r7.matcher(r1)
            boolean r7 = r7.matches()
            if (r7 == 0) goto L_0x0045
            r1 = 1
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r6 = 1
            goto L_0x0053
        L_0x0045:
            java.util.regex.Pattern r7 = defpackage.dl2.d
            java.util.regex.Matcher r1 = r7.matcher(r1)
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r4 = r5
        L_0x0053:
            defpackage.dl2.e(r3, r2, r0, r4)
            r0 = r6
        L_0x0057:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x005c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.df2.f():java.lang.Object");
    }
}
