package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: qy5  reason: default package */
/* compiled from: ImageUtils */
public class qy5 {

    /* renamed from: qy5$a */
    /* compiled from: ImageUtils */
    public static class a implements c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f3009a;
        public final /* synthetic */ int b;

        public a(int i, int i2) {
            this.f3009a = i;
            this.b = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.qy5.c
        public Bitmap a(File file) throws IOException {
            if (Build.VERSION.SDK_INT >= 28) {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(file), new py5(this));
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            d b2 = qy5.b(i, i2, this.f3009a, this.b);
            options.inSampleSize = qy5.a(i, i2, b2.f3011a, b2.b);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        }
    }

    /* renamed from: qy5$b */
    /* compiled from: ImageUtils */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable f3010a;
        public final long b;

        public b(Drawable drawable, long j, oy5 oy5) {
            this.f3010a = drawable;
            this.b = j;
        }
    }

    /* renamed from: qy5$c */
    /* compiled from: ImageUtils */
    public interface c<T> {
        T a(File file) throws IOException;
    }

    /* renamed from: qy5$d */
    /* compiled from: ImageUtils */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f3011a;
        public final int b;

        public d(int i, int i2) {
            this.f3011a = i;
            this.b = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f3011a == dVar.f3011a && this.b == dVar.b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f3011a), Integer.valueOf(this.b));
        }
    }

    public static int a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 > i4 && i7 / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static d b(int i, int i2, int i3, int i4) {
        int i5;
        if (i == 0 || i2 == 0) {
            throw new IllegalArgumentException("Failed to calculate target size! width and height must be greater than zero.");
        } else if (i3 == 0 && i4 == 0) {
            throw new IllegalArgumentException("Failed to calculate target size! reqWidth and reqHeight may not both be zero.");
        } else {
            if (i3 == 0) {
                i5 = (int) ((((double) i) / ((double) i2)) * ((double) i4));
            } else {
                i5 = i3;
            }
            if (i4 == 0) {
                i4 = (int) ((((double) i2) / ((double) i)) * ((double) i3));
            }
            return new d(i5, i4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T c(android.content.Context r7, java.net.URL r8, defpackage.qy5.c<T> r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qy5.c(android.content.Context, java.net.URL, qy5$c):java.lang.Object");
    }

    public static Bitmap d(Context context, URL url, int i, int i2) throws IOException {
        Bitmap bitmap = (Bitmap) c(context, url, new a(i, i2));
        if (bitmap != null) {
            yj5.a("Fetched image from: %s. Original image size: %dx%d. Requested image size: %dx%d. Bitmap size: %dx%d.", url, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
        }
        return bitmap;
    }

    public static Map<String, List<String>> e(Uri uri) {
        HashMap hashMap = new HashMap();
        String encodedQuery = uri.getEncodedQuery();
        if (hd3.G1(encodedQuery)) {
            return hashMap;
        }
        for (String str : encodedQuery.split("&")) {
            String[] split = str.split("=");
            String str2 = null;
            String decode = split.length >= 1 ? Uri.decode(split[0]) : null;
            if (split.length >= 2) {
                str2 = Uri.decode(split[1]);
            }
            if (!hd3.G1(decode)) {
                List list = (List) hashMap.get(decode);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(decode, list);
                }
                list.add(str2);
            }
        }
        return hashMap;
    }

    public static Uri f(Object obj) {
        if ((obj instanceof String) || (obj instanceof Uri) || (obj instanceof URL)) {
            return Uri.parse(String.valueOf(obj));
        }
        return null;
    }
}
