package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;
import app.zophop.R;

/* renamed from: yj0  reason: default package */
/* compiled from: ProductAdapter */
public class yj0 implements qs1<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f4055a;
    public final /* synthetic */ zj0 b;

    public yj0(zj0 zj0, ImageView imageView) {
        this.b = zj0;
        this.f4055a = imageView;
    }

    @Override // defpackage.qs1
    public boolean a(nn1 nn1, Object obj, ct1<Bitmap> ct1, boolean z) {
        this.f4055a.setVisibility(8);
        this.f4055a.setImageDrawable(this.b.f4181a.getResources().getDrawable(R.drawable.net_banking));
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, ct1, xl1, boolean] */
    @Override // defpackage.qs1
    public boolean b(Bitmap bitmap, Object obj, ct1<Bitmap> ct1, xl1 xl1, boolean z) {
        this.f4055a.setVisibility(0);
        return false;
    }
}
