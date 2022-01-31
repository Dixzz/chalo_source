package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;

/* renamed from: p21  reason: default package */
/* compiled from: ActivateSuperPassFragment.kt */
public final class p21 extends at1<Bitmap> {
    public final /* synthetic */ ActivateSuperPassFragment i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p21(ActivateSuperPassFragment activateSuperPassFragment) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = activateSuperPassFragment;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        ActivateSuperPassFragment activateSuperPassFragment = this.i;
        if (activateSuperPassFragment.getView() != null) {
            fh viewLifecycleOwner = activateSuperPassFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(activateSuperPassFragment), null, new o21(activateSuperPassFragment, null, activateSuperPassFragment, bitmap), 2, null);
        }
    }
}
