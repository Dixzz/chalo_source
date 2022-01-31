package defpackage;

import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.room.ScanPay;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: v71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class v71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f3612a;
    public final /* synthetic */ mh b;

    public /* synthetic */ v71(c91 c91, mh mhVar) {
        this.f3612a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f3612a;
        mh mhVar = this.b;
        List<ScanPay> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(v81.f);
            EnumMap d = c91.d(c91);
            for (ScanPay scanPay : list) {
                ScanPayTicket scanPayTicket = scanPay.scanPayTicket;
                BookingItem bookingItem = new BookingItem();
                bookingItem.setScanPayTicket(scanPayTicket);
                if (c91.d) {
                    if (!scanPayTicket.isScanPayTicketExpired() && !n86.a("FAILED", scanPayTicket.get_status())) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else if (scanPayTicket.isScanPayTicketExpired() || n86.a("FAILED", scanPayTicket.get_status())) {
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.SCAN_PAY_TICKET, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
