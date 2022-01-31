package defpackage;

import com.razorpay.AnalyticsConstants;
import java.io.Closeable;

/* renamed from: qg  reason: default package */
/* compiled from: ViewModel.kt */
public final class qg implements Closeable, mb6 {
    public final m66 f;

    public qg(m66 m66) {
        n86.e(m66, AnalyticsConstants.CONTEXT);
        this.f = m66;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ec6.i(this.f, null, 1, null);
    }

    @Override // defpackage.mb6
    public m66 n() {
        return this.f;
    }
}
