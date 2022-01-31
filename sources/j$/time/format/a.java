package j$.time.format;

import j$.time.ZoneId;
import j$.time.h;
import j$.time.temporal.d;
import j$.time.temporal.k;
import j$.time.temporal.m;
import j$.time.temporal.n;

public final /* synthetic */ class a implements n {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ a f1600a = new a();

    private /* synthetic */ a() {
    }

    @Override // j$.time.temporal.n
    public final Object a(k kVar) {
        int i = c.f;
        int i2 = m.f1638a;
        ZoneId zoneId = (ZoneId) kVar.n(d.f1629a);
        if (zoneId == null || (zoneId instanceof h)) {
            return null;
        }
        return zoneId;
    }
}
