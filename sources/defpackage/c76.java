package defpackage;

import java.lang.reflect.Method;

/* renamed from: c76  reason: default package */
/* compiled from: PlatformImplementations.kt */
public class c76 {

    /* renamed from: c76$a */
    /* compiled from: PlatformImplementations.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f530a;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
            if (defpackage.n86.a(r6, java.lang.Throwable.class) != false) goto L_0x0040;
         */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                defpackage.n86.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x000e:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L_0x0047
                r7 = r1[r4]
                defpackage.n86.d(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = defpackage.n86.a(r8, r9)
                r9 = 1
                if (r8 == 0) goto L_0x003f
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r10 = "it.parameterTypes"
                defpackage.n86.d(r8, r10)
                java.lang.String r10 = "$this$singleOrNull"
                defpackage.n86.e(r8, r10)
                int r10 = r8.length
                if (r10 != r9) goto L_0x0038
                r6 = r8[r3]
            L_0x0038:
                boolean r6 = defpackage.n86.a(r6, r0)
                if (r6 == 0) goto L_0x003f
                goto L_0x0040
            L_0x003f:
                r9 = 0
            L_0x0040:
                if (r9 == 0) goto L_0x0044
                r6 = r7
                goto L_0x0047
            L_0x0044:
                int r4 = r4 + 1
                goto L_0x000e
            L_0x0047:
                defpackage.c76.a.f530a = r6
                int r0 = r1.length
            L_0x004a:
                if (r3 >= r0) goto L_0x0061
                r2 = r1[r3]
                defpackage.n86.d(r2, r5)
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = defpackage.n86.a(r2, r4)
                if (r2 == 0) goto L_0x005e
                goto L_0x0061
            L_0x005e:
                int r3 = r3 + 1
                goto L_0x004a
            L_0x0061:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.c76.a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        n86.e(th, "cause");
        n86.e(th2, "exception");
        Method method = a.f530a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public g96 b() {
        return new f96();
    }
}
