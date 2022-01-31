package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.ActiveMTicketScreen;

/* renamed from: yb0  reason: default package */
/* compiled from: ActiveMTicketScreen */
public class yb0 extends at1<Bitmap> {
    public final /* synthetic */ int i;
    public final /* synthetic */ ActiveMTicketScreen j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yb0(ActiveMTicketScreen activeMTicketScreen, int i2) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.j = activeMTicketScreen;
        this.i = i2;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.j.r.setVisibility(8);
        this.j.k0((Bitmap) obj);
    }
}
