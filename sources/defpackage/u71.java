package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: u71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class u71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f3464a;
    public final /* synthetic */ mh b;

    public /* synthetic */ u71(c91 c91, mh mhVar) {
        this.f3464a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f3464a;
        mh mhVar = this.b;
        List<RideBasedSuperPass> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(a91.f);
            EnumMap d = c91.d(c91);
            for (RideBasedSuperPass rideBasedSuperPass : list) {
                BookingItem bookingItem = new BookingItem();
                bookingItem.setRideBasedSuperPass(rideBasedSuperPass);
                if (c91.d) {
                    if (!rideBasedSuperPass.isExpired()) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else if (rideBasedSuperPass.isExpired()) {
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.RIDE_BASED_SUPER_PASS, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
