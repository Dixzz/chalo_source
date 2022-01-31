package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: z31  reason: default package */
/* compiled from: SoundFragmentSuperPass.kt */
public final class z31 extends at1<Bitmap> {
    public final /* synthetic */ SoundFragmentSuperPass i;
    public final /* synthetic */ ez j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z31(SoundFragmentSuperPass soundFragmentSuperPass, ez ezVar) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = soundFragmentSuperPass;
        this.j = ezVar;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        n86.e(bitmap, "resource");
        n86.e(ft1, "transition");
        SoundFragmentSuperPass soundFragmentSuperPass = this.i;
        ez ezVar = this.j;
        if (soundFragmentSuperPass.getView() != null) {
            fh viewLifecycleOwner = soundFragmentSuperPass.getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            hd3.Y1(wg.b(viewLifecycleOwner), rl0.d(soundFragmentSuperPass), null, new y31(soundFragmentSuperPass, null, ezVar, bitmap), 2, null);
        }
    }
}
