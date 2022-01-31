package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: vr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vr0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kv0 f3676a;

    public /* synthetic */ vr0(kv0 kv0) {
        this.f3676a = kv0;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        kv0 kv0 = this.f3676a;
        EnumMap<d81.b, List<BookingItem>> enumMap = (EnumMap) obj;
        int i = kv0.n;
        n86.e(kv0, "this$0");
        if (xt.f3961a.L().m()) {
            c91 g = kv0.g();
            n86.d(enumMap, "it");
            List<BookingItem> g2 = g.g(enumMap);
            ((dl0) kv0.j.getValue()).f2701a.b(g2, new yr0(g2, kv0));
        }
    }
}
