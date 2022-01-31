package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;
import app.zophop.models.mTicketing.ProofViewInfo;

/* renamed from: c71  reason: default package */
/* compiled from: ViewUtils */
public class c71 extends at1<Bitmap> {
    public final /* synthetic */ ImageView i;
    public final /* synthetic */ ProofViewInfo j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c71(int i2, int i3, ImageView imageView, ProofViewInfo proofViewInfo) {
        super(i2, i3);
        this.i = imageView;
        this.j = proofViewInfo;
    }

    @Override // defpackage.ct1
    public void b(Object obj, ft1 ft1) {
        Bitmap bitmap = (Bitmap) obj;
        this.i.setImageBitmap(bitmap);
        this.j.setImage(bitmap);
    }
}
