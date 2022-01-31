package defpackage;

import android.content.Context;
import android.net.Uri;
import defpackage.ip1;
import defpackage.wm1;
import java.io.InputStream;

/* renamed from: wp1  reason: default package */
/* compiled from: MediaStoreVideoThumbLoader */
public class wp1 implements ip1<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3821a;

    /* renamed from: wp1$a */
    /* compiled from: MediaStoreVideoThumbLoader */
    public static class a implements jp1<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f3822a;

        public a(Context context) {
            this.f3822a = context;
        }

        @Override // defpackage.jp1
        public ip1<Uri, InputStream> b(mp1 mp1) {
            return new wp1(this.f3822a);
        }
    }

    public wp1(Context context) {
        this.f3821a = context.getApplicationContext();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(Uri uri) {
        Uri uri2 = uri;
        return gj1.P(uri2) && uri2.getPathSegments().contains("video");
    }

    /* Return type fixed from 'ip1$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a<InputStream> b(Uri uri, int i, int i2, fm1 fm1) {
        Uri uri2 = uri;
        boolean z = false;
        if (i <= 512 && i2 <= 384) {
            Long l = (Long) fm1.c(rq1.c);
            if (l != null && l.longValue() == -1) {
                z = true;
            }
            if (z) {
                jt1 jt1 = new jt1(uri2);
                Context context = this.f3821a;
                return new ip1.a(jt1, wm1.c(context, uri2, new wm1.b(context.getContentResolver())));
            }
        }
        return null;
    }
}
