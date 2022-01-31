package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: kt0  reason: default package */
/* compiled from: BottomSheetFragment */
public class kt0 extends at1<Bitmap> {
    public final /* synthetic */ int i;
    public final /* synthetic */ jt0 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public kt0(jt0 jt0, int i2) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.j = jt0;
        this.i = i2;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.j.j.setVisibility(8);
        this.j.d((Bitmap) obj);
    }
}
