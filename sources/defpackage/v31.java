package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: v31  reason: default package */
/* compiled from: BottomSheetDialogFragmentSuperPass.kt */
public final class v31 extends at1<Bitmap> {
    public final /* synthetic */ t31 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v31(t31 t31) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = t31;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        t31 t31 = this.i;
        if (t31.getView() != null) {
            fh viewLifecycleOwner = t31.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            ah b = wg.b(viewLifecycleOwner);
            int i2 = pl0.g;
            xb6 xb6 = xb6.f3911a;
            hd3.Y1(b, hj1.t0(CoroutineExceptionHandler.a.f, xf6.c), null, new u31(t31, null, t31, bitmap), 2, null);
        }
    }
}
