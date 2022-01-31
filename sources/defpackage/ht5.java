package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.LruCache;

/* renamed from: ht5  reason: default package */
/* compiled from: ImageCache */
public class ht5 {

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, b> f1425a = new a(this, (int) Math.min(10485760L, Runtime.getRuntime().maxMemory() / 8));
    public final Context b;

    /* renamed from: ht5$a */
    /* compiled from: ImageCache */
    public class a extends LruCache<String, b> {
        public a(ht5 ht5, int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.LruCache
        public int sizeOf(String str, b bVar) {
            long j = bVar.f1426a;
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }
    }

    /* renamed from: ht5$b */
    /* compiled from: ImageCache */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long f1426a;
        public final Drawable b;

        public b(Drawable drawable, long j) {
            this.b = drawable;
            this.f1426a = j;
        }
    }

    public ht5(Context context) {
        this.b = context.getApplicationContext();
    }
}
