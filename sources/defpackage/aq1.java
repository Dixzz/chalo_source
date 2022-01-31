package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;

/* renamed from: aq1  reason: default package */
/* compiled from: BitmapDrawableEncoder */
public class aq1 implements hm1<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final zn1 f320a;
    public final hm1<Bitmap> b;

    public aq1(zn1 zn1, hm1<Bitmap> hm1) {
        this.f320a = zn1;
        this.b = hm1;
    }

    @Override // defpackage.am1
    public boolean a(Object obj, File file, fm1 fm1) {
        return this.b.a(new dq1(((BitmapDrawable) ((rn1) obj).get()).getBitmap(), this.f320a), file, fm1);
    }

    @Override // defpackage.hm1
    public zl1 b(fm1 fm1) {
        return this.b.b(fm1);
    }
}
