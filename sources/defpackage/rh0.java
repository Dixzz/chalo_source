package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.ZoomedImageViewActivity;

/* renamed from: rh0  reason: default package */
/* compiled from: ZoomedImageViewActivity */
public class rh0 extends at1<Bitmap> {
    public final /* synthetic */ ImageView i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rh0(ZoomedImageViewActivity zoomedImageViewActivity, ImageView imageView) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = imageView;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.i.setImageBitmap((Bitmap) obj);
    }
}
