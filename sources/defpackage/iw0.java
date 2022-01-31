package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: iw0  reason: default package */
/* compiled from: SoundFragment */
public class iw0 extends at1<Bitmap> {
    public final /* synthetic */ int i;
    public final /* synthetic */ hw0 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public iw0(hw0 hw0, int i2) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.j = hw0;
        this.i = i2;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.j.n.setVisibility(8);
        this.j.e((Bitmap) obj);
    }
}
