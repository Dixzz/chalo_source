package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.superPassHistory.SuperPassTripReceiptFragment;

/* renamed from: k01  reason: default package */
/* compiled from: SuperPassTripReceiptFragment.kt */
public final class k01 extends at1<Bitmap> {
    public final /* synthetic */ SuperPassTripReceiptFragment i;
    public final /* synthetic */ pz j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k01(SuperPassTripReceiptFragment superPassTripReceiptFragment, pz pzVar) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = superPassTripReceiptFragment;
        this.j = pzVar;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        SuperPassTripReceiptFragment superPassTripReceiptFragment = this.i;
        pz pzVar = this.j;
        if (superPassTripReceiptFragment.getView() != null) {
            fh viewLifecycleOwner = superPassTripReceiptFragment.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(superPassTripReceiptFragment), null, new j01(superPassTripReceiptFragment, null, pzVar, bitmap), 2, null);
        }
    }
}
