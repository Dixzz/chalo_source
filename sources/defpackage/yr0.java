package defpackage;

import java.util.List;

/* renamed from: yr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yr0 implements Runnable {
    public final /* synthetic */ List f;
    public final /* synthetic */ kv0 g;

    public /* synthetic */ yr0(List list, kv0 kv0) {
        this.f = list;
        this.g = kv0;
    }

    public final void run() {
        List list = this.f;
        kv0 kv0 = this.g;
        int i = kv0.n;
        n86.e(list, "$lAllBookingItems");
        n86.e(kv0, "this$0");
        if (!list.isEmpty()) {
            rc6 rc6 = kv0.l;
            if (rc6 != null) {
                ec6.j(rc6, null, 1, null);
            }
            kv0.j();
        }
    }
}
