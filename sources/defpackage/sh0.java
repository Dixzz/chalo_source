package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.ZoomedImageViewActivity;
import app.zophop.ui.views.ZoomableImageView;

/* renamed from: sh0  reason: default package */
/* compiled from: ZoomedImageViewActivity */
public class sh0 extends at1<Bitmap> {
    public final /* synthetic */ ZoomableImageView i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sh0(ZoomedImageViewActivity zoomedImageViewActivity, ZoomableImageView zoomableImageView) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = zoomableImageView;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.i.setImageBitmap((Bitmap) obj);
    }
}
