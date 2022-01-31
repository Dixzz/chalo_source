package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

/* renamed from: af5  reason: default package */
/* compiled from: LruCache */
public final class af5 implements oe5 {

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, a> f159a;

    /* renamed from: af5$a */
    /* compiled from: LruCache */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f160a;
        public final int b;

        public a(Bitmap bitmap, int i) {
            this.f160a = bitmap;
            this.b = i;
        }
    }

    public af5(Context context) {
        StringBuilder sb = rf5.f3076a;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f159a = new ze5(this, (int) ((((long) ((context.getApplicationInfo().flags & CommonUtils.BYTES_IN_A_MEGABYTE) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 7));
    }

    @Override // defpackage.oe5
    public Bitmap a(String str) {
        a aVar = this.f159a.get(str);
        if (aVar != null) {
            return aVar.f160a;
        }
        return null;
    }

    @Override // defpackage.oe5
    public int b() {
        return this.f159a.maxSize();
    }

    @Override // defpackage.oe5
    public void c(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int b = rf5.b(bitmap);
        if (b > this.f159a.maxSize()) {
            this.f159a.remove(str);
        } else {
            this.f159a.put(str, new a(bitmap, b));
        }
    }

    @Override // defpackage.oe5
    public int size() {
        return this.f159a.size();
    }
}
