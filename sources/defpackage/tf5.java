package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.theartofdev.edmodo.cropper.CropImageActivity;
import com.theartofdev.edmodo.cropper.CropImageView;
import defpackage.je;
import defpackage.uf5;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import server.zophop.logicLayer.CsLogic;

/* renamed from: tf5  reason: default package */
/* compiled from: BitmapLoadingWorkerTask */
public final class tf5 extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<CropImageView> f3347a;
    public final Uri b;
    public final Context c;
    public final int d;
    public final int e;

    public tf5(CropImageView cropImageView, Uri uri) {
        this.b = uri;
        this.f3347a = new WeakReference<>(cropImageView);
        this.c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        double d2 = f > 1.0f ? (double) (1.0f / f) : 1.0d;
        this.d = (int) (((double) displayMetrics.widthPixels) * d2);
        this.e = (int) (((double) displayMetrics.heightPixels) * d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public a doInBackground(Void[] voidArr) {
        uf5.b bVar;
        try {
            je jeVar = null;
            if (isCancelled()) {
                return null;
            }
            uf5.a i = uf5.i(this.c, this.b, this.d, this.e);
            if (isCancelled()) {
                return null;
            }
            Bitmap bitmap = i.f3501a;
            Context context = this.c;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(this.b);
                if (openInputStream != null) {
                    je jeVar2 = new je(openInputStream);
                    try {
                        openInputStream.close();
                    } catch (Exception unused) {
                    }
                    jeVar = jeVar2;
                }
            } catch (Exception unused2) {
            }
            int i2 = 0;
            if (jeVar != null) {
                je.b d2 = jeVar.d("Orientation");
                int i3 = 1;
                if (d2 != null) {
                    try {
                        i3 = d2.f(jeVar.f);
                    } catch (NumberFormatException unused3) {
                    }
                }
                if (i3 == 3) {
                    i2 = CsLogic.ETA_FORCE_UPDATE_REDIS_TTL;
                } else if (i3 == 6) {
                    i2 = 90;
                } else if (i3 == 8) {
                    i2 = 270;
                }
                bVar = new uf5.b(bitmap, i2);
            } else {
                bVar = new uf5.b(bitmap, 0);
            }
            return new a(this.b, bVar.f3502a, i.b, bVar.b);
        } catch (Exception e2) {
            return new a(this.b, e2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public void onPostExecute(a aVar) {
        Bitmap bitmap;
        CropImageView cropImageView;
        a aVar2 = aVar;
        if (aVar2 != null) {
            boolean z = false;
            if (!isCancelled() && (cropImageView = this.f3347a.get()) != null) {
                cropImageView.P = null;
                cropImageView.h();
                if (aVar2.e == null) {
                    int i = aVar2.d;
                    cropImageView.o = i;
                    cropImageView.f(aVar2.b, 0, aVar2.f3348a, aVar2.c, i);
                }
                CropImageView.i iVar = cropImageView.E;
                if (iVar != null) {
                    Exception exc = aVar2.e;
                    CropImageActivity cropImageActivity = (CropImageActivity) iVar;
                    if (exc == null) {
                        Rect rect = cropImageActivity.h.R;
                        if (rect != null) {
                            cropImageActivity.f.setCropRect(rect);
                        }
                        int i2 = cropImageActivity.h.S;
                        if (i2 > -1) {
                            cropImageActivity.f.setRotatedDegrees(i2);
                        }
                    } else {
                        cropImageActivity.e(null, exc, 1);
                    }
                }
                z = true;
            }
            if (!z && (bitmap = aVar2.b) != null) {
                bitmap.recycle();
            }
        }
    }

    /* renamed from: tf5$a */
    /* compiled from: BitmapLoadingWorkerTask */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f3348a;
        public final Bitmap b;
        public final int c;
        public final int d;
        public final Exception e;

        public a(Uri uri, Bitmap bitmap, int i, int i2) {
            this.f3348a = uri;
            this.b = bitmap;
            this.c = i;
            this.d = i2;
            this.e = null;
        }

        public a(Uri uri, Exception exc) {
            this.f3348a = uri;
            this.b = null;
            this.c = 0;
            this.d = 0;
            this.e = exc;
        }
    }
}
