package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Pair;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: uf5  reason: default package */
/* compiled from: BitmapUtils */
public final class uf5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Rect f3500a = new Rect();
    public static final RectF b = new RectF();
    public static final RectF c = new RectF();
    public static final float[] d = new float[6];
    public static final float[] e = new float[6];
    public static int f;
    public static Pair<String, WeakReference<Bitmap>> g;

    /* renamed from: uf5$a */
    /* compiled from: BitmapUtils */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f3501a;
        public final int b;

        public a(Bitmap bitmap, int i) {
            this.f3501a = bitmap;
            this.b = i;
        }
    }

    /* renamed from: uf5$b */
    /* compiled from: BitmapUtils */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f3502a;
        public final int b;

        public b(Bitmap bitmap, int i) {
            this.f3502a = bitmap;
            this.b = i;
        }
    }

    public static int a(int i, int i2) {
        int i3 = 1;
        if (f == 0) {
            int i4 = 2048;
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, new int[2]);
                int[] iArr = new int[1];
                egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
                EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
                egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
                int[] iArr2 = new int[1];
                int i5 = 0;
                for (int i6 = 0; i6 < iArr[0]; i6++) {
                    egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i6], 12332, iArr2);
                    if (i5 < iArr2[0]) {
                        i5 = iArr2[0];
                    }
                }
                egl10.eglTerminate(eglGetDisplay);
                i4 = Math.max(i5, 2048);
            } catch (Exception unused) {
            }
            f = i4;
        }
        if (f > 0) {
            while (true) {
                int i7 = i2 / i3;
                int i8 = f;
                if (i7 <= i8 && i / i3 <= i8) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    public static int b(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static a c(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        int i8 = 1;
        do {
            try {
                return d(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i8);
            } catch (OutOfMemoryError e2) {
                i8 *= 2;
                if (i8 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e2.getMessage(), e2);
                }
            }
        } while (i8 > 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e2.getMessage(), e2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ed, code lost:
        r17 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0120, code lost:
        throw new java.lang.RuntimeException("Failed to load sampled bitmap: " + r19 + "\r\n" + r0.getMessage(), r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f A[SYNTHETIC, Splitter:B:41:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fd A[ExcHandler: Exception (r0v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:41:0x009f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.uf5.a d(android.content.Context r18, android.net.Uri r19, float[] r20, int r21, int r22, int r23, boolean r24, int r25, int r26, int r27, int r28, boolean r29, boolean r30, int r31) {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf5.d(android.content.Context, android.net.Uri, float[], int, int, int, boolean, int, int, int, int, boolean, boolean, int):uf5$a");
    }

    public static a e(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        int i4 = 1;
        do {
            try {
                return new a(f(bitmap, fArr, i, z, i2, i3, 1.0f / ((float) i4), z2, z3), i4);
            } catch (OutOfMemoryError e2) {
                i4 *= 2;
                if (i4 > 8) {
                    throw e2;
                }
            }
        } while (i4 > 8);
        throw e2;
    }

    public static Bitmap f(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f2, boolean z2, boolean z3) {
        float f3 = f2;
        Rect o = o(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        float f4 = z2 ? -f3 : f3;
        if (z3) {
            f3 = -f3;
        }
        matrix.postScale(f4, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, o.left, o.top, o.width(), o.height(), matrix, true);
        if (createBitmap == bitmap) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i % 90 != 0 ? g(createBitmap, fArr, o, i, z, i2, i3) : createBitmap;
    }

    public static Bitmap g(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians((double) i);
        int i7 = (i < 90 || (i > 180 && i < 270)) ? rect.left : rect.right;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 < fArr.length) {
                if (fArr[i9] >= ((float) (i7 - 1)) && fArr[i9] <= ((float) (i7 + 1))) {
                    int i10 = i9 + 1;
                    int abs = (int) Math.abs(Math.sin(radians) * ((double) (((float) rect.bottom) - fArr[i10])));
                    int abs2 = (int) Math.abs(Math.cos(radians) * ((double) (fArr[i10] - ((float) rect.top))));
                    int abs3 = (int) Math.abs(((double) (((float) rect.bottom) - fArr[i10])) / Math.cos(radians));
                    i6 = abs2;
                    i5 = abs3;
                    i4 = abs;
                    i8 = (int) Math.abs(((double) (fArr[i10] - ((float) rect.top))) / Math.sin(radians));
                    break;
                }
                i9 += 2;
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
                break;
            }
        }
        rect.set(i4, i6, i8 + i4, i5 + i6);
        if (z) {
            k(rect, i2, i3);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0001 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: android.content.ContentResolver */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.graphics.Bitmap] */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|9|10|(2:12|13)|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r0 == null) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b A[SYNTHETIC, Splitter:B:12:0x001b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap h(android.content.ContentResolver r2, android.net.Uri r3, android.graphics.BitmapFactory.Options r4) throws java.io.FileNotFoundException {
        /*
        L_0x0000:
            r0 = 0
            java.io.InputStream r0 = r2.openInputStream(r3)     // Catch:{ OutOfMemoryError -> 0x0013 }
            android.graphics.Rect r1 = defpackage.uf5.f3500a     // Catch:{ OutOfMemoryError -> 0x0013 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r0, r1, r4)     // Catch:{ OutOfMemoryError -> 0x0013 }
            if (r0 == 0) goto L_0x0010
            r0.close()     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            return r2
        L_0x0011:
            r2 = move-exception
            goto L_0x0033
        L_0x0013:
            int r1 = r4.inSampleSize     // Catch:{ all -> 0x0011 }
            int r1 = r1 * 2
            r4.inSampleSize = r1     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0020
            r0.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0020
        L_0x001f:
        L_0x0020:
            int r0 = r4.inSampleSize
            r1 = 512(0x200, float:7.175E-43)
            if (r0 > r1) goto L_0x0027
            goto L_0x0000
        L_0x0027:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r4 = "Failed to decode image: "
            java.lang.String r3 = defpackage.hj1.N(r4, r3)
            r2.<init>(r3)
            throw r2
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            r0.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf5.h(android.content.ContentResolver, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055 A[SYNTHETIC, Splitter:B:22:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.uf5.a i(android.content.Context r4, android.net.Uri r5, int r6, int r7) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf5.i(android.content.Context, android.net.Uri, int, int):uf5$a");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: android.graphics.BitmapRegionDecoder */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: android.graphics.BitmapRegionDecoder */
    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: android.graphics.BitmapRegionDecoder */
    /* JADX DEBUG: Multi-variable search result rejected for r8v4, resolved type: android.graphics.BitmapRegionDecoder */
    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: android.graphics.BitmapRegionDecoder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r5 == null) goto L_0x0033;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047 A[SYNTHETIC, Splitter:B:21:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093 A[SYNTHETIC, Splitter:B:43:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.uf5.a j(android.content.Context r5, android.net.Uri r6, android.graphics.Rect r7, int r8, int r9, int r10) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uf5.j(android.content.Context, android.net.Uri, android.graphics.Rect, int, int, int):uf5$a");
    }

    public static void k(Rect rect, int i, int i2) {
        if (i == i2 && rect.width() != rect.height()) {
            if (rect.height() > rect.width()) {
                rect.bottom -= rect.height() - rect.width();
            } else {
                rect.right -= rect.width() - rect.height();
            }
        }
    }

    public static float l(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static float m(float[] fArr) {
        return (q(fArr) + r(fArr)) / 2.0f;
    }

    public static float n(float[] fArr) {
        return (s(fArr) + l(fArr)) / 2.0f;
    }

    public static Rect o(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, q(fArr))), Math.round(Math.max(0.0f, s(fArr))), Math.round(Math.min((float) i, r(fArr))), Math.round(Math.min((float) i2, l(fArr))));
        if (z) {
            k(rect, i3, i4);
        }
        return rect;
    }

    public static float p(float[] fArr) {
        return l(fArr) - s(fArr);
    }

    public static float q(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float r(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float s(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static float t(float[] fArr) {
        return r(fArr) - q(fArr);
    }

    public static Bitmap u(Bitmap bitmap, int i, int i2, CropImageView.j jVar) {
        if (i > 0 && i2 > 0) {
            try {
                CropImageView.j jVar2 = CropImageView.j.RESIZE_FIT;
                if (jVar == jVar2 || jVar == CropImageView.j.RESIZE_INSIDE || jVar == CropImageView.j.RESIZE_EXACT) {
                    Bitmap bitmap2 = null;
                    if (jVar == CropImageView.j.RESIZE_EXACT) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                    } else {
                        float width = (float) bitmap.getWidth();
                        float height = (float) bitmap.getHeight();
                        float max = Math.max(width / ((float) i), height / ((float) i2));
                        if (max > 1.0f || jVar == jVar2) {
                            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width / max), (int) (height / max), false);
                        }
                    }
                    if (bitmap2 != null) {
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmap2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    public static void v(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i) throws FileNotFoundException {
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i, outputStream);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        }
    }
}
