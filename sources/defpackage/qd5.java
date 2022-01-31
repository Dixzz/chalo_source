package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.LruCache;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: qd5  reason: default package */
/* compiled from: ImageStore */
public class qd5 {
    public static LruCache<String, Bitmap> e;

    /* renamed from: a  reason: collision with root package name */
    public final File f2933a;
    public final ud5 b;
    public final MessageDigest c;
    public final jc5 d;

    /* renamed from: qd5$a */
    /* compiled from: ImageStore */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }

    public qd5(Context context, String str) {
        MessageDigest messageDigest;
        String S = hj1.S("MixpanelAPI.Images.", str);
        od5 od5 = new od5();
        this.f2933a = context.getDir(S, 0);
        this.b = od5;
        this.d = jc5.b(context);
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        this.c = messageDigest;
        if (e == null) {
            synchronized (qd5.class) {
                if (e == null) {
                    e = new pd5(this, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / this.d.u);
                }
            }
        }
    }

    public static Bitmap a(String str) {
        Bitmap bitmap;
        synchronized (e) {
            bitmap = e.get(str);
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0056 A[SYNTHETIC, Splitter:B:34:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap b(java.lang.String r8) throws defpackage.qd5.a {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qd5.b(java.lang.String):android.graphics.Bitmap");
    }

    public final File c(String str) {
        MessageDigest messageDigest = this.c;
        if (messageDigest == null) {
            return null;
        }
        byte[] digest = messageDigest.digest(str.getBytes());
        StringBuilder i0 = hj1.i0("MP_IMG_");
        i0.append(Base64.encodeToString(digest, 10));
        return new File(this.f2933a, i0.toString());
    }
}
