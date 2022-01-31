package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.Objects;

/* renamed from: lf5  reason: default package */
/* compiled from: RequestHandler */
public abstract class lf5 {
    public static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, jf5 jf5) {
        int i5;
        double d;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                d = Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                int floor = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor2 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                if (jf5.j) {
                    i5 = Math.max(floor, floor2);
                } else {
                    i5 = Math.min(floor, floor2);
                }
            }
            i5 = (int) d;
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    public static void b(int i, int i2, BitmapFactory.Options options, jf5 jf5) {
        a(i, i2, options.outWidth, options.outHeight, options, jf5);
    }

    public static BitmapFactory.Options d(jf5 jf5) {
        boolean a2 = jf5.a();
        boolean z = jf5.q != null;
        BitmapFactory.Options options = null;
        if (a2 || z || jf5.p) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = a2;
            boolean z2 = jf5.p;
            options.inInputShareable = z2;
            options.inPurgeable = z2;
            if (z) {
                options.inPreferredConfig = jf5.q;
            }
        }
        return options;
    }

    public abstract boolean c(jf5 jf5);

    public int e() {
        return 0;
    }

    public abstract a f(jf5 jf5, int i) throws IOException;

    public boolean g(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean h() {
        return false;
    }

    /* renamed from: lf5$a */
    /* compiled from: RequestHandler */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Picasso.d f2210a;
        public final Bitmap b;
        public final qn6 c;
        public final int d;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(qn6 qn6, Picasso.d dVar) {
            this(null, qn6, dVar, 0);
            StringBuilder sb = rf5.f3076a;
            Objects.requireNonNull(qn6, "source == null");
        }

        public a(Bitmap bitmap, qn6 qn6, Picasso.d dVar, int i) {
            if ((bitmap != null) != (qn6 == null ? false : true)) {
                this.b = bitmap;
                this.c = qn6;
                StringBuilder sb = rf5.f3076a;
                Objects.requireNonNull(dVar, "loadedFrom == null");
                this.f2210a = dVar;
                this.d = i;
                return;
            }
            throw new AssertionError();
        }
    }
}
