package defpackage;

import android.graphics.Bitmap;
import android.util.LruCache;

/* renamed from: pd5  reason: default package */
/* compiled from: ImageStore */
public class pd5 extends LruCache<String, Bitmap> {
    public pd5(qd5 qd5, int i) {
        super(i);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.LruCache
    public int sizeOf(String str, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        return (bitmap2.getHeight() * bitmap2.getRowBytes()) / 1024;
    }
}
