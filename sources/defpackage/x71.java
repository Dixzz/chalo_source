package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MPass;
import app.zophop.room.PassApplications;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: x71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class x71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f3895a;
    public final /* synthetic */ mh b;

    public /* synthetic */ x71(c91 c91, mh mhVar) {
        this.f3895a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f3895a;
        mh mhVar = this.b;
        List<PassApplications> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(x81.f);
            EnumMap d = c91.d(c91);
            for (PassApplications passApplications : list) {
                MPass mPass = passApplications.pass;
                BookingItem bookingItem = new BookingItem();
                bookingItem.setMagicPass(mPass);
                if (c91.d) {
                    String status = mPass.getStatus();
                    if (!mPass.isPassExpired() && ((mPass.getExpiryTime() == 0 || ui1.Q() <= mPass.getExpiryTime()) && status != null && !n86.a(status, "REJECTED") && !n86.a(status, "EXPIRED") && !n86.a(status, "FAILED"))) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else {
                    String status2 = mPass.getStatus();
                    if (status2 == null) {
                        status2 = "UNUSED";
                    }
                    if (mPass.isPassExpired() || ((n86.a(status2, "UNUSED") && ui1.Q() > mPass.getExpiryTime()) || n86.a(status2, "REJECTED") || n86.a(status2, "FAILED"))) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                }
            }
            d.put((Enum) d81.b.PASS_APPLICATION, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
