package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.razorpay.AnalyticsConstants;
import com.squareup.picasso.Picasso;
import defpackage.jf5;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: kf5  reason: default package */
/* compiled from: RequestCreator */
public class kf5 {
    public static final AtomicInteger e = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final Picasso f2052a;
    public final jf5.b b;
    public int c;
    public int d;

    public kf5(Picasso picasso, Uri uri, int i) {
        this.f2052a = picasso;
        this.b = new jf5.b(uri, i, picasso.l);
    }

    public final jf5 a(long j) {
        int andIncrement = e.getAndIncrement();
        jf5.b bVar = this.b;
        if (bVar.e && bVar.c == 0 && bVar.d == 0) {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        }
        if (bVar.h == null) {
            bVar.h = Picasso.e.NORMAL;
        }
        jf5 jf5 = new jf5(bVar.f1918a, bVar.b, null, bVar.f, bVar.c, bVar.d, false, bVar.e, 0, false, 0.0f, 0.0f, 0.0f, false, false, bVar.g, bVar.h, null);
        jf5.f1917a = andIncrement;
        jf5.b = j;
        boolean z = this.f2052a.n;
        if (z) {
            rf5.f("Main", "created", jf5.d(), jf5.toString());
        }
        Objects.requireNonNull((Picasso.f.a) this.f2052a.b);
        if (jf5 != jf5) {
            jf5.f1917a = andIncrement;
            jf5.b = j;
            if (z) {
                String b2 = jf5.b();
                rf5.f("Main", AnalyticsConstants.CHANGED, b2, "into " + jf5);
            }
        }
        return jf5;
    }

    public Bitmap b() throws IOException {
        long nanoTime = System.nanoTime();
        if (rf5.e()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        } else if (!this.b.a()) {
            return null;
        } else {
            jf5 a2 = a(nanoTime);
            xe5 xe5 = new xe5(this.f2052a, a2, 0, 0, null, rf5.a(a2, new StringBuilder()));
            Picasso picasso = this.f2052a;
            return ne5.e(picasso, picasso.f, picasso.g, picasso.h, xe5).f();
        }
    }

    public final Drawable c() {
        int i = this.c;
        if (i != 0) {
            return this.f2052a.e.getDrawable(i);
        }
        return null;
    }

    public void d(ImageView imageView, pe5 pe5) {
        Bitmap e2;
        long nanoTime = System.nanoTime();
        if (!rf5.e()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        } else if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.b.a()) {
            Picasso picasso = this.f2052a;
            Objects.requireNonNull(picasso);
            picasso.a(imageView);
            hf5.c(imageView, c());
        } else {
            jf5 a2 = a(nanoTime);
            StringBuilder sb = rf5.f3076a;
            String a3 = rf5.a(a2, sb);
            sb.setLength(0);
            if (!df5.shouldReadFromMemoryCache(0) || (e2 = this.f2052a.e(a3)) == null) {
                hf5.c(imageView, c());
                this.f2052a.c(new ye5(this.f2052a, imageView, a2, 0, 0, this.d, null, a3, null, pe5, false));
                return;
            }
            Picasso picasso2 = this.f2052a;
            Objects.requireNonNull(picasso2);
            picasso2.a(imageView);
            Picasso picasso3 = this.f2052a;
            Context context = picasso3.e;
            Picasso.d dVar = Picasso.d.MEMORY;
            hf5.b(imageView, context, e2, dVar, false, picasso3.m);
            if (this.f2052a.n) {
                String d2 = a2.d();
                rf5.f("Main", "completed", d2, "from " + dVar);
            }
            if (pe5 != null) {
                pe5.b();
            }
        }
    }
}
