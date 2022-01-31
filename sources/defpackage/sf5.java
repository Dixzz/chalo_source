package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.theartofdev.edmodo.cropper.CropImageActivity;
import com.theartofdev.edmodo.cropper.CropImageView;
import defpackage.uf5;
import java.lang.ref.WeakReference;

/* renamed from: sf5  reason: default package */
/* compiled from: BitmapCroppingWorkerTask */
public final class sf5 extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<CropImageView> f3208a;
    public final Bitmap b;
    public final Uri c;
    public final Context d;
    public final float[] e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final CropImageView.j p;
    public final Uri q;
    public final Bitmap.CompressFormat r;
    public final int s;

    public sf5(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i2, boolean z, int i3, int i4, int i5, int i6, boolean z2, boolean z3, CropImageView.j jVar, Uri uri, Bitmap.CompressFormat compressFormat, int i7) {
        this.f3208a = new WeakReference<>(cropImageView);
        this.d = cropImageView.getContext();
        this.b = bitmap;
        this.e = fArr;
        this.c = null;
        this.f = i2;
        this.i = z;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = z2;
        this.o = z3;
        this.p = jVar;
        this.q = uri;
        this.r = compressFormat;
        this.s = i7;
        this.g = 0;
        this.h = 0;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public a doInBackground(Void[] voidArr) {
        uf5.a aVar;
        boolean z = true;
        try {
            if (isCancelled()) {
                return null;
            }
            Uri uri = this.c;
            if (uri != null) {
                aVar = uf5.c(this.d, uri, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
            } else {
                Bitmap bitmap = this.b;
                if (bitmap == null) {
                    return new a((Bitmap) null, 1);
                }
                aVar = uf5.e(bitmap, this.e, this.f, this.i, this.j, this.k, this.n, this.o);
            }
            Bitmap u = uf5.u(aVar.f3501a, this.l, this.m, this.p);
            Uri uri2 = this.q;
            if (uri2 == null) {
                return new a(u, aVar.b);
            }
            uf5.v(this.d, u, uri2, this.r, this.s);
            if (u != null) {
                u.recycle();
            }
            return new a(this.q, aVar.b);
        } catch (Exception e2) {
            if (this.q == null) {
                z = false;
            }
            return new a(e2, z);
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
            if (!isCancelled() && (cropImageView = this.f3208a.get()) != null) {
                z = true;
                cropImageView.Q = null;
                cropImageView.h();
                CropImageView.e eVar = cropImageView.F;
                if (eVar != null) {
                    Uri uri = aVar2.b;
                    Exception exc = aVar2.c;
                    cropImageView.getCropPoints();
                    cropImageView.getCropRect();
                    cropImageView.getWholeImageRect();
                    cropImageView.getRotatedDegrees();
                    ((CropImageActivity) eVar).e(uri, exc, aVar2.d);
                }
            }
            if (!z && (bitmap = aVar2.f3209a) != null) {
                bitmap.recycle();
            }
        }
    }

    /* renamed from: sf5$a */
    /* compiled from: BitmapCroppingWorkerTask */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f3209a;
        public final Uri b;
        public final Exception c;
        public final int d;

        public a(Bitmap bitmap, int i) {
            this.f3209a = bitmap;
            this.b = null;
            this.c = null;
            this.d = i;
        }

        public a(Uri uri, int i) {
            this.f3209a = null;
            this.b = uri;
            this.c = null;
            this.d = i;
        }

        public a(Exception exc, boolean z) {
            this.f3209a = null;
            this.b = null;
            this.c = exc;
            this.d = 1;
        }
    }

    public sf5(CropImageView cropImageView, Uri uri, float[] fArr, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, boolean z2, boolean z3, CropImageView.j jVar, Uri uri2, Bitmap.CompressFormat compressFormat, int i9) {
        this.f3208a = new WeakReference<>(cropImageView);
        this.d = cropImageView.getContext();
        this.c = uri;
        this.e = fArr;
        this.f = i2;
        this.i = z;
        this.j = i5;
        this.k = i6;
        this.g = i3;
        this.h = i4;
        this.l = i7;
        this.m = i8;
        this.n = z2;
        this.o = z3;
        this.p = jVar;
        this.q = uri2;
        this.r = compressFormat;
        this.s = i9;
        this.b = null;
    }
}
