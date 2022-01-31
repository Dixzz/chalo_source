package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: le5  reason: default package */
/* compiled from: Action */
public abstract class le5<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Picasso f2204a;
    public final jf5 b;
    public final WeakReference<T> c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final Drawable h;
    public final String i;
    public final Object j;
    public boolean k;
    public boolean l;

    /* renamed from: le5$a */
    /* compiled from: Action */
    public static class a<M> extends WeakReference<M> {

        /* renamed from: a  reason: collision with root package name */
        public final le5 f2205a;

        public a(le5 le5, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f2205a = le5;
        }
    }

    public le5(Picasso picasso, T t, jf5 jf5, int i2, int i3, int i4, Drawable drawable, String str, Object obj, boolean z) {
        a aVar;
        this.f2204a = picasso;
        this.b = jf5;
        if (t == null) {
            aVar = null;
        } else {
            aVar = new a(this, t, picasso.k);
        }
        this.c = aVar;
        this.e = i2;
        this.f = i3;
        this.d = z;
        this.g = i4;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    public void a() {
        this.l = true;
    }

    public abstract void b(Bitmap bitmap, Picasso.d dVar);

    public abstract void c(Exception exc);

    public T d() {
        WeakReference<T> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
