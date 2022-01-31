package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.MTicketTripReceiptActivity;

/* renamed from: qe0  reason: default package */
/* compiled from: MTicketTripReceiptActivity.kt */
public final class qe0 extends at1<Bitmap> {
    public final /* synthetic */ MTicketTripReceiptActivity i;
    public final /* synthetic */ pz j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qe0(MTicketTripReceiptActivity mTicketTripReceiptActivity, pz pzVar) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = mTicketTripReceiptActivity;
        this.j = pzVar;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        this.i.runOnUiThread(new aa0(this.j, bitmap));
    }
}
