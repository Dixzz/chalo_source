package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;

/* renamed from: b31  reason: default package */
/* compiled from: ActiveSuperPassFragment.kt */
public final class b31 extends at1<Bitmap> {
    public final /* synthetic */ ActiveSuperPassFragment i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b31(ActiveSuperPassFragment activeSuperPassFragment) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = activeSuperPassFragment;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        ActiveSuperPassFragment activeSuperPassFragment = this.i;
        if (activeSuperPassFragment.getView() != null) {
            fh viewLifecycleOwner = activeSuperPassFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(activeSuperPassFragment), null, new a31(activeSuperPassFragment, null, activeSuperPassFragment, bitmap), 2, null);
        }
    }
}
