package defpackage;

import android.content.Context;
import android.net.Uri;

/* renamed from: cf5  reason: default package */
/* compiled from: MediaStoreRequestHandler */
public class cf5 extends re5 {
    public static final String[] b = {"orientation"};

    /* renamed from: cf5$a */
    /* compiled from: MediaStoreRequestHandler */
    public enum a {
        MICRO(3, 96, 96),
        MINI(1, 512, 384),
        FULL(2, -1, -1);
        
        public final int androidKind;
        public final int height;
        public final int width;

        private a(int i, int i2, int i3) {
            this.androidKind = i;
            this.width = i2;
            this.height = i3;
        }
    }

    public cf5(Context context) {
        super(context);
    }

    @Override // defpackage.re5, defpackage.lf5
    public boolean c(jf5 jf5) {
        Uri uri = jf5.c;
        return "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r3 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r3 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    @Override // defpackage.re5, defpackage.lf5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.lf5.a f(defpackage.jf5 r17, int r18) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cf5.f(jf5, int):lf5$a");
    }
}
