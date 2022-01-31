package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.ActivateMTicketScreen;

/* renamed from: ob0  reason: default package */
/* compiled from: ActivateMTicketScreen */
public class ob0 extends at1<Bitmap> {
    public final /* synthetic */ ActivateMTicketScreen i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ob0(ActivateMTicketScreen activateMTicketScreen) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = activateMTicketScreen;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.i.v.setVisibility(8);
        this.i.w.setImageBitmap((Bitmap) obj);
    }
}
