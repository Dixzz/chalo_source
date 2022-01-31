package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.ActivePassScreen;

/* renamed from: fc0  reason: default package */
/* compiled from: ActivePassScreen */
public class fc0 extends at1<Bitmap> {
    public final /* synthetic */ int i;
    public final /* synthetic */ ActivePassScreen j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fc0(ActivePassScreen activePassScreen, int i2) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.j = activePassScreen;
        this.i = i2;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.j._profilePictureLoader.setVisibility(8);
        this.j.j0((Bitmap) obj);
    }
}
