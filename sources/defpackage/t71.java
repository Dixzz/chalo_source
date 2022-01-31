package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassApplicationStatus;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: t71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class t71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f3315a;
    public final /* synthetic */ mh b;

    public /* synthetic */ t71(c91 c91, mh mhVar) {
        this.f3315a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f3315a;
        mh mhVar = this.b;
        List<SuperPassApplication> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(y81.f);
            EnumMap d = c91.d(c91);
            for (SuperPassApplication superPassApplication : list) {
                BookingItem bookingItem = new BookingItem();
                bookingItem.setSuperPassApplication(superPassApplication);
                SuperPassApplicationStatus superPassApplicationStatus = superPassApplication.getSuperPassApplicationStatus();
                if (c91.d) {
                    if (superPassApplicationStatus != SuperPassApplicationStatus.REJECTED) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else if (superPassApplicationStatus == SuperPassApplicationStatus.REJECTED) {
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.SUPER_PASS_APPLICATION, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
