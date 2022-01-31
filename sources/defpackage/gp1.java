package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.ip1;
import defpackage.km1;
import java.io.File;
import java.io.FileNotFoundException;

/* renamed from: gp1  reason: default package */
/* compiled from: MediaStoreFileLoader */
public final class gp1 implements ip1<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1294a;

    /* renamed from: gp1$a */
    /* compiled from: MediaStoreFileLoader */
    public static final class a implements jp1<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1295a;

        public a(Context context) {
            this.f1295a = context;
        }

        @Override // defpackage.jp1
        public ip1<Uri, File> b(mp1 mp1) {
            return new gp1(this.f1295a);
        }
    }

    /* renamed from: gp1$b */
    /* compiled from: MediaStoreFileLoader */
    public static class b implements km1<File> {
        public static final String[] h = {"_data"};
        public final Context f;
        public final Uri g;

        public b(Context context, Uri uri) {
            this.f = context;
            this.g = uri;
        }

        @Override // defpackage.km1
        public Class<File> a() {
            return File.class;
        }

        @Override // defpackage.km1
        public void b() {
        }

        @Override // defpackage.km1
        public void cancel() {
        }

        @Override // defpackage.km1
        public xl1 d() {
            return xl1.LOCAL;
        }

        @Override // defpackage.km1
        public void e(kl1 kl1, km1.a<? super File> aVar) {
            Cursor query = this.f.getContentResolver().query(this.g, h, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder i0 = hj1.i0("Failed to find file path for: ");
                i0.append(this.g);
                aVar.c(new FileNotFoundException(i0.toString()));
                return;
            }
            aVar.g(new File(str));
        }
    }

    public gp1(Context context) {
        this.f1294a = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ip1
    public boolean a(Uri uri) {
        return gj1.P(uri);
    }

    /* Return type fixed from 'ip1$a' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.ip1
    public ip1.a<File> b(Uri uri, int i, int i2, fm1 fm1) {
        Uri uri2 = uri;
        return new ip1.a(new jt1(uri2), new b(this.f1294a, uri2));
    }
}
