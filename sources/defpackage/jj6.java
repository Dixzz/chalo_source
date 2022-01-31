package defpackage;

import com.google.firebase.perf.FirebasePerformance;
import defpackage.ei6;
import java.io.IOException;
import java.util.Objects;

/* renamed from: jj6  reason: default package */
/* compiled from: ConnectInterceptor.kt */
public final class jj6 implements ei6 {

    /* renamed from: a  reason: collision with root package name */
    public static final jj6 f1938a = new jj6();

    @Override // defpackage.ei6
    public ni6 a(ei6.a aVar) throws IOException {
        n86.f(aVar, "chain");
        ek6 ek6 = (ek6) aVar;
        nj6 nj6 = ek6.b;
        Objects.requireNonNull(nj6);
        n86.f(ek6, "chain");
        synchronized (nj6) {
            if (!nj6.q) {
                throw new IllegalStateException("released".toString());
            } else if (!(!nj6.p)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!(!nj6.o)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        mj6 mj6 = nj6.k;
        if (mj6 != null) {
            hi6 hi6 = nj6.u;
            n86.f(hi6, "client");
            n86.f(ek6, "chain");
            try {
                lj6 lj6 = new lj6(nj6, nj6.g, mj6, mj6.a(ek6.g, ek6.h, ek6.i, hi6.G, hi6.k, !n86.a(ek6.f.c, FirebasePerformance.HttpMethod.GET)).k(hi6, ek6));
                nj6.n = lj6;
                nj6.s = lj6;
                synchronized (nj6) {
                    nj6.o = true;
                    nj6.p = true;
                }
                if (!nj6.r) {
                    return ek6.b(ek6, 0, lj6, null, 0, 0, 0, 61).a(ek6.f);
                }
                throw new IOException("Canceled");
            } catch (vj6 e) {
                mj6.c(e.f);
                throw e;
            } catch (IOException e2) {
                mj6.c(e2);
                throw new vj6(e2);
            }
        } else {
            n86.k();
            throw null;
        }
    }
}
