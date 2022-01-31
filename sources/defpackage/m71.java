package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: m71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class m71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d81 f2333a;
    public final /* synthetic */ mh b;

    public /* synthetic */ m71(d81 d81, mh mhVar) {
        this.f2333a = d81;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        d81 d81 = this.f2333a;
        mh mhVar = this.b;
        List<SuperPassApplication> list = (List) obj;
        n86.e(d81, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(i81.f);
            EnumMap d = d81.d(d81);
            for (SuperPassApplication superPassApplication : list) {
                BookingItem bookingItem = new BookingItem();
                bookingItem.setSuperPassApplication(superPassApplication);
                ((List) ((o56) a2).getValue()).add(bookingItem);
            }
            d.put((Enum) d81.b.SUPER_PASS_APPLICATION, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
