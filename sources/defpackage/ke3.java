package defpackage;

import android.annotation.TargetApi;
import java.lang.reflect.Method;

@TargetApi(24)
/* renamed from: ke3  reason: default package */
public final class ke3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f2048a;
    public static final Method b;
    public static volatile me3 c = le3.f2203a;

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r2 = 0
            r3 = 24
            if (r0 < r3) goto L_0x0025
            java.lang.Class<android.app.job.JobScheduler> r4 = android.app.job.JobScheduler.class
            java.lang.String r5 = "scheduleAsPackage"
            r6 = 4
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0025 }
            r7 = 0
            java.lang.Class<android.app.job.JobInfo> r8 = android.app.job.JobInfo.class
            r6[r7] = r8     // Catch:{ NoSuchMethodException -> 0x0025 }
            r7 = 1
            r6[r7] = r1     // Catch:{ NoSuchMethodException -> 0x0025 }
            r7 = 2
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0025 }
            r6[r7] = r8     // Catch:{ NoSuchMethodException -> 0x0025 }
            r7 = 3
            r6[r7] = r1     // Catch:{ NoSuchMethodException -> 0x0025 }
            java.lang.reflect.Method r1 = r4.getDeclaredMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0025 }
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            defpackage.ke3.f2048a = r1
            if (r0 < r3) goto L_0x0032
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r1 = "myUserId"
            java.lang.reflect.Method r2 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0032 }
        L_0x0032:
            defpackage.ke3.b = r2
            me3 r0 = defpackage.le3.f2203a
            defpackage.ke3.c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ke3.<clinit>():void");
    }
}
