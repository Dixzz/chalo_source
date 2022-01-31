package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* renamed from: ax1  reason: default package */
/* compiled from: Uploader */
public class ax1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f344a;
    public final uv1 b;
    public final xx1 c;
    public final ex1 d;
    public final Executor e;
    public final iy1 f;
    public final jy1 g;

    @Inject
    public ax1(Context context, uv1 uv1, xx1 xx1, ex1 ex1, Executor executor, iy1 iy1, jy1 jy1) {
        this.f344a = context;
        this.b = uv1;
        this.c = xx1;
        this.d = ex1;
        this.e = executor;
        this.f = iy1;
        this.g = jy1;
    }

    public void a(jv1 jv1, int i) {
        wv1 a2;
        cw1 a3 = this.b.a(jv1.b());
        Iterable<cy1> iterable = (Iterable) this.f.a(new sw1(this, jv1));
        if (iterable.iterator().hasNext()) {
            if (a3 == null) {
                gj1.C("Uploader", "Unknown backend for %s, deleting event batch for it...", jv1);
                a2 = wv1.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (cy1 cy1 : iterable) {
                    arrayList.add(cy1.a());
                }
                byte[] c2 = jv1.c();
                if (1 != 0) {
                    a2 = a3.a(new qv1(arrayList, c2, null));
                } else {
                    throw new IllegalStateException(hj1.S("Missing required properties:", ""));
                }
            }
            this.f.a(new qw1(this, a2, iterable, jv1, i));
        }
    }
}
