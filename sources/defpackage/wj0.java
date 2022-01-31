package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;
import app.zophop.R;

/* renamed from: wj0  reason: default package */
/* compiled from: PaymentItemAdapter */
public class wj0 implements qs1<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f3790a;
    public final /* synthetic */ vj0 b;

    public wj0(vj0 vj0, ImageView imageView) {
        this.b = vj0;
        this.f3790a = imageView;
    }

    @Override // defpackage.qs1
    public boolean a(nn1 nn1, Object obj, ct1<Bitmap> ct1, boolean z) {
        this.f3790a.setImageDrawable(this.b.f.getResources().getDrawable(R.drawable.net_banking));
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, ct1, xl1, boolean] */
    @Override // defpackage.qs1
    public /* bridge */ /* synthetic */ boolean b(Bitmap bitmap, Object obj, ct1<Bitmap> ct1, xl1 xl1, boolean z) {
        return false;
    }
}
