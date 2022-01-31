package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;

/* renamed from: p31  reason: default package */
/* compiled from: ActiveSuperPassVisualValidationFragment.kt */
public final class p31 extends at1<Bitmap> {
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p31(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = activeSuperPassVisualValidationFragment;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.i;
        if (activeSuperPassVisualValidationFragment.getView() != null) {
            fh viewLifecycleOwner = activeSuperPassVisualValidationFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(activeSuperPassVisualValidationFragment), null, new o31(activeSuperPassVisualValidationFragment, null, activeSuperPassVisualValidationFragment, bitmap), 2, null);
        }
    }
}
