package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: ma1  reason: default package */
/* compiled from: AlertInfoView */
public class ma1 extends at1<Bitmap> {
    public final /* synthetic */ na1 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ma1(na1 na1) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = na1;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.i.k.setImageBitmap((Bitmap) obj);
    }
}
