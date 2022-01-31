package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.room.Ticket;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: r71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class r71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f3053a;
    public final /* synthetic */ mh b;

    public /* synthetic */ r71(c91 c91, mh mhVar) {
        this.f3053a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f3053a;
        mh mhVar = this.b;
        List<Ticket> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(u81.f);
            EnumMap d = c91.d(c91);
            for (Ticket ticket : list) {
                MTicket mTicket = ticket.mTicket;
                BookingItem bookingItem = new BookingItem();
                bookingItem.setMTicket(mTicket);
                if (c91.d) {
                    if (!mTicket.isMTicketExpired() && !n86.a("FAILED", mTicket.getStatus())) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else if (mTicket.isMTicketExpired() || n86.a("FAILED", mTicket.getStatus())) {
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.TICKET, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
