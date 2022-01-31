package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.rabbitmq.client.AMQP;
import defpackage.ht5;
import defpackage.qy5;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: jt5  reason: default package */
/* compiled from: ImageRequest */
public abstract class jt5 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f1979a = pj5.f2814a;
    public final kt5 b;
    public final ht5 c;
    public final WeakReference<ImageView> d;
    public final Context e;
    public final uj5 f = new uj5(null);
    public ViewTreeObserver.OnPreDrawListener g;
    public int h;
    public int i;

    /* renamed from: jt5$a */
    /* compiled from: ImageRequest */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            ImageView imageView = jt5.this.d.get();
            if (imageView == null) {
                return true;
            }
            imageView.getViewTreeObserver().removeOnPreDrawListener(this);
            if (!imageView.getViewTreeObserver().isAlive()) {
                return true;
            }
            if (imageView.getHeight() == 0 && imageView.getWidth() == 0) {
                jt5.this.d(imageView);
                return true;
            }
            jt5.this.b();
            return true;
        }
    }

    /* renamed from: jt5$b */
    /* compiled from: ImageRequest */
    public class b implements Runnable {
        public final /* synthetic */ ImageView f;

        /* renamed from: jt5$b$a */
        /* compiled from: ImageRequest */
        public class a implements Runnable {
            public final /* synthetic */ Drawable f;

            public a(Drawable drawable) {
                this.f = drawable;
            }

            public void run() {
                if (!jt5.this.f.b()) {
                    jt5 jt5 = jt5.this;
                    Drawable drawable = this.f;
                    ImageView imageView = jt5.d.get();
                    if (!(drawable == null || imageView == null)) {
                        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(q5.b(jt5.e, 17170445)), drawable});
                        imageView.setImageDrawable(transitionDrawable);
                        transitionDrawable.startTransition(AMQP.REPLY_SUCCESS);
                        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                            ((AnimatedImageDrawable) drawable).start();
                        }
                    }
                    b bVar = b.this;
                    jt5.this.d(bVar.f);
                }
            }
        }

        public b(ImageView imageView) {
            this.f = imageView;
        }

        public void run() {
            if (!jt5.this.f.b()) {
                try {
                    Drawable a2 = jt5.a(jt5.this);
                    if (a2 != null) {
                        jt5.this.f.a(new a(a2));
                        jt5.this.f.run();
                    }
                } catch (IOException e) {
                    yj5.b(e, "Unable to fetch bitmap", new Object[0]);
                }
            }
        }
    }

    public jt5(Context context, ht5 ht5, ImageView imageView, kt5 kt5) {
        this.e = context;
        this.c = ht5;
        this.b = kt5;
        this.d = new WeakReference<>(imageView);
    }

    public static Drawable a(jt5 jt5) throws IOException {
        qy5.b bVar;
        ht5 ht5 = jt5.c;
        Objects.requireNonNull(ht5);
        File file = new File(ht5.b.getApplicationContext().getCacheDir(), "urbanairship-cache");
        if (!file.exists() && !file.mkdirs()) {
            yj5.c("Failed to create the cache.", new Object[0]);
        }
        if (HttpResponseCache.getInstalled() == null) {
            try {
                HttpResponseCache.install(file, 52428800);
            } catch (IOException unused) {
                yj5.c("Unable to install image loader cache", new Object[0]);
            }
        }
        if (jt5.d.get() == null || jt5.b.b == null) {
            return null;
        }
        Context context = jt5.e;
        URL url = new URL(jt5.b.b);
        int i2 = jt5.h;
        int i3 = jt5.i;
        if (Build.VERSION.SDK_INT < 28) {
            Bitmap d2 = qy5.d(context, url, i2, i3);
            if (d2 == null) {
                bVar = null;
            } else {
                bVar = new qy5.b(new BitmapDrawable(context.getResources(), d2), (long) d2.getByteCount(), null);
            }
        } else {
            bVar = (qy5.b) qy5.c(context, url, new oy5(i2, i3));
        }
        if (bVar == null) {
            return null;
        }
        ht5 ht52 = jt5.c;
        String c2 = jt5.c();
        Drawable drawable = bVar.f3010a;
        long j = bVar.b;
        Objects.requireNonNull(ht52);
        if (j <= 1048576) {
            ht52.f1425a.put(c2, new ht5.b(drawable, j));
        }
        return bVar.f3010a;
    }

    public void b() {
        Drawable drawable;
        if (!this.f.b()) {
            ImageView imageView = this.d.get();
            if (imageView == null) {
                d(null);
                return;
            }
            this.h = imageView.getWidth();
            int height = imageView.getHeight();
            this.i = height;
            if (this.h == 0 && height == 0) {
                this.g = new a();
                imageView.getViewTreeObserver().addOnPreDrawListener(this.g);
                return;
            }
            ht5.b bVar = this.c.f1425a.get(c());
            if (bVar == null) {
                drawable = null;
            } else {
                drawable = bVar.b;
            }
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                d(imageView);
                return;
            }
            int i2 = this.b.f2119a;
            if (i2 != 0) {
                imageView.setImageResource(i2);
            } else {
                imageView.setImageDrawable(null);
            }
            this.f1979a.execute(new b(imageView));
        }
    }

    public final String c() {
        if (this.b.b == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.b);
        sb.append(",size(");
        sb.append(this.h);
        sb.append("x");
        return hj1.X(sb, this.i, ")");
    }

    public abstract void d(ImageView imageView);
}
