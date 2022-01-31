package defpackage;

import app.zophop.ui.fragments.superPassHistory.DigitalTripReceiptHistoryFragment;
import java.util.List;

/* renamed from: wy0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wy0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DigitalTripReceiptHistoryFragment f3859a;

    public /* synthetic */ wy0(DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment) {
        this.f3859a = digitalTripReceiptHistoryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment = this.f3859a;
        List list = (List) obj;
        int i = DigitalTripReceiptHistoryFragment.k;
        n86.e(digitalTripReceiptHistoryFragment, "this$0");
        int i2 = 0;
        if (!(list == null || list.isEmpty())) {
            ed1 ed1 = new ed1("superPass trip receipt history displayed", Long.MIN_VALUE);
            digitalTripReceiptHistoryFragment.i(ed1);
            if (list != null) {
                i2 = list.size();
            }
            hj1.u0(i2, ed1, "receipt list size", ed1);
            nu nuVar = digitalTripReceiptHistoryFragment.i;
            if (nuVar != null) {
                nuVar.f2701a.b(list, null);
            } else {
                n86.l("digitalTripReceiptsAdapter");
                throw null;
            }
        }
    }
}
