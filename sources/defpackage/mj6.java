package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.wj6;
import java.io.IOException;

/* renamed from: mj6  reason: default package */
/* compiled from: ExchangeFinder.kt */
public final class mj6 {

    /* renamed from: a  reason: collision with root package name */
    public wj6.a f2387a;
    public wj6 b;
    public int c;
    public int d;
    public int e;
    public pi6 f;
    public final tj6 g;
    public final dh6 h;
    public final nj6 i;
    public final xh6 j;

    public mj6(tj6 tj6, dh6 dh6, nj6 nj6, xh6 xh6) {
        n86.f(tj6, "connectionPool");
        n86.f(dh6, "address");
        n86.f(nj6, AnalyticsConstants.CALL);
        n86.f(xh6, "eventListener");
        this.g = tj6;
        this.h = dh6;
        this.i = nj6;
        this.j = xh6;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0321 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.sj6 a(int r16, int r17, int r18, int r19, boolean r20, boolean r21) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 879
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mj6.a(int, int, int, int, boolean, boolean):sj6");
    }

    public final boolean b(di6 di6) {
        n86.f(di6, "url");
        di6 di62 = this.h.f839a;
        return di6.f == di62.f && n86.a(di6.e, di62.e);
    }

    public final void c(IOException iOException) {
        n86.f(iOException, "e");
        this.f = null;
        if ((iOException instanceof el6) && ((el6) iOException).f == lk6.REFUSED_STREAM) {
            this.c++;
        } else if (iOException instanceof kk6) {
            this.d++;
        } else {
            this.e++;
        }
    }
}
