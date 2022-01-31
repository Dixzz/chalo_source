package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MPass;
import app.zophop.room.PassApplications;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: p71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class p71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d81 f2775a;
    public final /* synthetic */ mh b;

    public /* synthetic */ p71(d81 d81, mh mhVar) {
        this.f2775a = d81;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        d81 d81 = this.f2775a;
        mh mhVar = this.b;
        List<PassApplications> list = (List) obj;
        n86.e(d81, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(h81.f);
            EnumMap d = d81.d(d81);
            for (PassApplications passApplications : list) {
                MPass mPass = passApplications.pass;
                BookingItem bookingItem = new BookingItem();
                bookingItem.setMagicPass(mPass);
                ((List) ((o56) a2).getValue()).add(bookingItem);
            }
            d.put((Enum) d81.b.PASS_APPLICATION, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
