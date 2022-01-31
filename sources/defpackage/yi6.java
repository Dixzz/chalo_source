package defpackage;

import defpackage.ci6;

/* renamed from: yi6  reason: default package */
/* compiled from: CacheInterceptor.kt */
public final class yi6 implements ei6 {
    public static final a b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final gh6 f4052a;

    /* renamed from: yi6$a */
    /* compiled from: CacheInterceptor.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public static final ni6 a(a aVar, ni6 ni6) {
            if ((ni6 != null ? ni6.m : null) == null) {
                return ni6;
            }
            n86.f(ni6, "response");
            ji6 ji6 = ni6.g;
            ii6 ii6 = ni6.h;
            int i = ni6.j;
            String str = ni6.i;
            bi6 bi6 = ni6.k;
            ci6.a e = ni6.l.e();
            ni6 ni62 = ni6.n;
            ni6 ni63 = ni6.o;
            ni6 ni64 = ni6.p;
            long j = ni6.q;
            long j2 = ni6.r;
            lj6 lj6 = ni6.s;
            if (!(i >= 0)) {
                throw new IllegalStateException(hj1.I("code < 0: ", i).toString());
            } else if (ji6 == null) {
                throw new IllegalStateException("request == null".toString());
            } else if (ii6 == null) {
                throw new IllegalStateException("protocol == null".toString());
            } else if (str != null) {
                return new ni6(ji6, ii6, str, i, bi6, e.d(), null, ni62, ni63, ni64, j, j2, lj6);
            } else {
                throw new IllegalStateException("message == null".toString());
            }
        }

        public final boolean b(String str) {
            if (ea6.f("Content-Length", str, true) || ea6.f("Content-Encoding", str, true) || ea6.f("Content-Type", str, true)) {
                return true;
            }
            return false;
        }

        public final boolean c(String str) {
            if (ea6.f("Connection", str, true) || ea6.f("Keep-Alive", str, true) || ea6.f("Proxy-Authenticate", str, true) || ea6.f("Proxy-Authorization", str, true) || ea6.f("TE", str, true) || ea6.f("Trailers", str, true) || ea6.f("Transfer-Encoding", str, true) || ea6.f("Upgrade", str, true)) {
                return false;
            }
            return true;
        }
    }

    public yi6(gh6 gh6) {
        this.f4052a = gh6;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [ji6, ni6] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x026d, code lost:
        if (r4 > 0) goto L_0x026f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0499  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x051a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0555  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0579  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x07ad  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x07b3  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x0836  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // defpackage.ei6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.ni6 a(defpackage.ei6.a r45) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2257
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yi6.a(ei6$a):ni6");
    }
}
