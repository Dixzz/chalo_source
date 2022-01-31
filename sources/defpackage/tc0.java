package defpackage;

import android.graphics.Bitmap;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;

/* renamed from: tc0  reason: default package */
/* compiled from: BookingSummaryMagicPassActivity */
public class tc0 extends at1<Bitmap> {
    public final /* synthetic */ BookingSummaryMagicPassActivity i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tc0(BookingSummaryMagicPassActivity bookingSummaryMagicPassActivity) {
        super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
        this.i = bookingSummaryMagicPassActivity;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        this.i._progressBar.setVisibility(8);
        this.i._profilePicView.setImageBitmap((Bitmap) obj);
    }
}
