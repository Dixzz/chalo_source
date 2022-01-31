package defpackage;

import com.razorpay.AnalyticsConstants;
import java.io.IOException;

/* renamed from: lm6  reason: default package */
/* compiled from: RealWebSocket.kt */
public final class lm6 implements jh6 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ km6 f2240a;
    public final /* synthetic */ ji6 b;

    public lm6(km6 km6, ji6 ji6) {
        this.f2240a = km6;
        this.b = ji6;
    }

    @Override // defpackage.jh6
    public void onFailure(ih6 ih6, IOException iOException) {
        n86.f(ih6, AnalyticsConstants.CALL);
        n86.f(iOException, "e");
        this.f2240a.h(iOException, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e4, code lost:
        if (r15 == null) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0119, code lost:
        if (r16 == null) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011b, code lost:
        r14 = true;
     */
    @Override // defpackage.jh6
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(defpackage.ih6 r22, defpackage.ni6 r23) {
        /*
        // Method dump skipped, instructions count: 506
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lm6.onResponse(ih6, ni6):void");
    }
}
