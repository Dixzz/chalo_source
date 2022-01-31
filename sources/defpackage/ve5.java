package defpackage;

import android.graphics.Bitmap;
import com.squareup.picasso.Picasso;

/* renamed from: ve5  reason: default package */
/* compiled from: FetchAction */
public class ve5 extends le5<Object> {
    public final Object m = new Object();
    public pe5 n;

    public ve5(Picasso picasso, jf5 jf5, int i, int i2, Object obj, String str, pe5 pe5) {
        super(picasso, null, jf5, i, i2, 0, null, str, null, false);
        this.n = pe5;
    }

    @Override // defpackage.le5
    public void a() {
        this.l = true;
        this.n = null;
    }

    @Override // defpackage.le5
    public void b(Bitmap bitmap, Picasso.d dVar) {
        pe5 pe5 = this.n;
        if (pe5 != null) {
            pe5.b();
        }
    }

    @Override // defpackage.le5
    public void c(Exception exc) {
        pe5 pe5 = this.n;
        if (pe5 != null) {
            pe5.a(exc);
        }
    }

    @Override // defpackage.le5
    public Object d() {
        return this.m;
    }
}
