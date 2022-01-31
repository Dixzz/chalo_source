package defpackage;

import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.room.ScanPay;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: n71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class n71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d81 f2519a;
    public final /* synthetic */ mh b;

    public /* synthetic */ n71(d81 d81, mh mhVar) {
        this.f2519a = d81;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        d81 d81 = this.f2519a;
        mh mhVar = this.b;
        List<ScanPay> list = (List) obj;
        n86.e(d81, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(f81.f);
            EnumMap d = d81.d(d81);
            for (ScanPay scanPay : list) {
                ScanPayTicket scanPayTicket = scanPay.scanPayTicket;
                if (!scanPayTicket.isScanPayTicketExpired()) {
                    BookingItem bookingItem = new BookingItem();
                    bookingItem.setScanPayTicket(scanPayTicket);
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.SCAN_PAY_TICKET, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
