package defpackage;

import java.io.IOException;
import java.util.List;

/* renamed from: bl6  reason: default package */
/* compiled from: PushObserver.kt */
public final class bl6 implements cl6 {
    @Override // defpackage.cl6
    public boolean a(int i, List<mk6> list) {
        n86.f(list, "requestHeaders");
        return true;
    }

    @Override // defpackage.cl6
    public boolean b(int i, List<mk6> list, boolean z) {
        n86.f(list, "responseHeaders");
        return true;
    }

    @Override // defpackage.cl6
    public void c(int i, lk6 lk6) {
        n86.f(lk6, "errorCode");
    }

    @Override // defpackage.cl6
    public boolean d(int i, ym6 ym6, int i2, boolean z) throws IOException {
        n86.f(ym6, "source");
        ((vm6) ym6).d((long) i2);
        return true;
    }
}
