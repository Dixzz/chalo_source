package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import defpackage.km1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: wm1  reason: default package */
/* compiled from: ThumbFetcher */
public class wm1 implements km1<InputStream> {
    public final Uri f;
    public final ym1 g;
    public InputStream h;

    /* renamed from: wm1$a */
    /* compiled from: ThumbFetcher */
    public static class a implements xm1 {
        public static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f3802a;

        public a(ContentResolver contentResolver) {
            this.f3802a = contentResolver;
        }

        @Override // defpackage.xm1
        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f3802a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    /* renamed from: wm1$b */
    /* compiled from: ThumbFetcher */
    public static class b implements xm1 {
        public static final String[] b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        public final ContentResolver f3803a;

        public b(ContentResolver contentResolver) {
            this.f3803a = contentResolver;
        }

        @Override // defpackage.xm1
        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f3803a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, null);
        }
    }

    public wm1(Uri uri, ym1 ym1) {
        this.f = uri;
        this.g = ym1;
    }

    public static wm1 c(Context context, Uri uri, xm1 xm1) {
        return new wm1(uri, new ym1(gl1.b(context).i.c(), xm1, gl1.b(context).j, context.getContentResolver()));
    }

    @Override // defpackage.km1
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // defpackage.km1
    public void b() {
        InputStream inputStream = this.h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.km1
    public void cancel() {
    }

    @Override // defpackage.km1
    public xl1 d() {
        return xl1.LOCAL;
    }

    @Override // defpackage.km1
    public void e(kl1 kl1, km1.a<? super InputStream> aVar) {
        try {
            InputStream f2 = f();
            this.h = f2;
            aVar.g(f2);
        } catch (FileNotFoundException e) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.c(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r1 != null) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream f() throws java.io.FileNotFoundException {
        /*
        // Method dump skipped, instructions count: 182
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wm1.f():java.io.InputStream");
    }
}
