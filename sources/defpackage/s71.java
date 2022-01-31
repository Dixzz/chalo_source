package defpackage;

import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.MagicSuperPass;
import defpackage.d81;
import java.util.EnumMap;
import java.util.List;

/* renamed from: s71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class s71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c91 f3194a;
    public final /* synthetic */ mh b;

    public /* synthetic */ s71(c91 c91, mh mhVar) {
        this.f3194a = c91;
        this.b = mhVar;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        c91 c91 = this.f3194a;
        mh mhVar = this.b;
        List<MagicSuperPass> list = (List) obj;
        n86.e(c91, "this$0");
        n86.e(mhVar, "$this_apply");
        if (list != null) {
            j56 a2 = hd3.a2(z81.f);
            EnumMap d = c91.d(c91);
            for (MagicSuperPass magicSuperPass : list) {
                BookingItem bookingItem = new BookingItem();
                bookingItem.setMagicSuperPass(magicSuperPass);
                if (c91.d) {
                    if (!magicSuperPass.isExpired()) {
                        ((List) ((o56) a2).getValue()).add(bookingItem);
                    }
                } else if (magicSuperPass.isExpired()) {
                    ((List) ((o56) a2).getValue()).add(bookingItem);
                }
            }
            d.put((Enum) d81.b.SUPER_PASS, (Object) ((List) ((o56) a2).getValue()));
            mhVar.l(d);
        }
    }
}
