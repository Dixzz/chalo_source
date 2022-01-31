package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.SuperPassStatus;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: q71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class q71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f2909a;
    public final /* synthetic */ mh b;

    public /* synthetic */ q71(c91 c91, mh mhVar) {
        this.f2909a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f2909a;
        mh mhVar = this.b;
        List<PendingSuperPass> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(b91.f);
            EnumMap d = c91.d(c91);
            for (PendingSuperPass pendingSuperPass : list) {
                BookingItem bookingItem = new BookingItem();
                bookingItem.setPendingSuperPass(pendingSuperPass);
                if (c91.d) {
                    if (pendingSuperPass.getPendingSuperPassProperties().getStatus() == SuperPassStatus.PAYMENT_PROCESSING) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else if (pendingSuperPass.getPendingSuperPassProperties().getStatus() == SuperPassStatus.PAYMENT_FAILED) {
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.PENDING_SUPER_PASS, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
