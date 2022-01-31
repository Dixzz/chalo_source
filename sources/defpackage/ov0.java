package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.ProfileFragment;

/* renamed from: ov0  reason: default package */
/* compiled from: ProfileFragment */
public class ov0 extends at1<Bitmap> {
    public final /* synthetic */ int i;
    public final /* synthetic */ ProfileFragment j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ov0(ProfileFragment profileFragment, int i2) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.j = profileFragment;
        this.i = i2;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        ProfileFragment.a(this.j, (Bitmap) obj, this.i);
    }
}
