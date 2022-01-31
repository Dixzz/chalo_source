package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: k71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class k71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d81 f2032a;
    public final /* synthetic */ mh b;

    public /* synthetic */ k71(d81 d81, mh mhVar) {
        this.f2032a = d81;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        d81 d81 = this.f2032a;
        mh mhVar = this.b;
        List<PendingSuperPass> list = (List) obj;
        n86.e(d81, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(l81.f);
            EnumMap d = d81.d(d81);
            for (PendingSuperPass pendingSuperPass : list) {
                BookingItem bookingItem = new BookingItem();
                bookingItem.setPendingSuperPass(pendingSuperPass);
                ((List) ((o56) a2).getValue()).add(bookingItem);
            }
            d.put((Enum) d81.b.PENDING_SUPER_PASS, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
