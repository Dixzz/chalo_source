package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.room.Ticket;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: o71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d81 f2659a;
    public final /* synthetic */ mh b;

    public /* synthetic */ o71(d81 d81, mh mhVar) {
        this.f2659a = d81;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        d81 d81 = this.f2659a;
        mh mhVar = this.b;
        List<Ticket> list = (List) obj;
        n86.e(d81, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(e81.f);
            EnumMap d = d81.d(d81);
            for (Ticket ticket : list) {
                MTicket mTicket = ticket.mTicket;
                if (!mTicket.isMTicketExpired()) {
                    BookingItem bookingItem = new BookingItem();
                    bookingItem.setMTicket(mTicket);
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.TICKET, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
