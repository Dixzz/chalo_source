package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.ActivatePassScreen;

/* renamed from: rb0  reason: default package */
/* compiled from: ActivatePassScreen */
public class rb0 extends at1<Bitmap> {
    public final /* synthetic */ ActivatePassScreen i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rb0(ActivatePassScreen activatePassScreen) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = activatePassScreen;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.i.D.setVisibility(8);
        this.i.E.setImageBitmap((Bitmap) obj);
    }
}
