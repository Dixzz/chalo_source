package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.theartofdev.edmodo.cropper.CropOverlayView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class CropImageView extends FrameLayout {
    public static final /* synthetic */ int R = 0;
    public int A;
    public g B;
    public f C;
    public h D;
    public i E;
    public e F;
    public Uri G;
    public int H = 1;
    public float I = 1.0f;
    public float J;
    public float K;
    public RectF L;
    public int M;
    public boolean N;
    public Uri O;
    public WeakReference<tf5> P;
    public WeakReference<sf5> Q;
    public final ImageView f;
    public final CropOverlayView g;
    public final Matrix h = new Matrix();
    public final Matrix i = new Matrix();
    public final ProgressBar j;
    public final float[] k = new float[8];
    public final float[] l = new float[8];
    public xf5 m;
    public Bitmap n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public k v;
    public boolean w = false;
    public boolean x = true;
    public boolean y = true;
    public boolean z = true;

    public class a implements CropOverlayView.b {
        public a() {
        }
    }

    public static class b {
        public final Uri f;
        public final Uri g;
        public final Exception h;
        public final float[] i;
        public final Rect j;
        public final Rect k;
        public final int l;
        public final int m;

        public b(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i2, int i3) {
            this.f = uri;
            this.g = uri2;
            this.h = exc;
            this.i = fArr;
            this.j = rect;
            this.k = rect2;
            this.l = i2;
            this.m = i3;
        }
    }

    public enum c {
        RECTANGLE,
        OVAL
    }

    public enum d {
        OFF,
        ON_TOUCH,
        ON
    }

    public interface e {
    }

    public interface f {
        void a(Rect rect);
    }

    public interface g {
        void a(Rect rect);
    }

    public interface h {
        void a();
    }

    public interface i {
    }

    public enum j {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    public enum k {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bundle bundleExtra;
        CropImageOptions cropImageOptions = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) == null)) {
            cropImageOptions = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (cropImageOptions == null) {
            cropImageOptions = new CropImageOptions();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView, 0, 0);
                try {
                    int i2 = R.styleable.CropImageView_cropFixAspectRatio;
                    cropImageOptions.q = obtainStyledAttributes.getBoolean(i2, cropImageOptions.q);
                    int i3 = R.styleable.CropImageView_cropAspectRatioX;
                    cropImageOptions.r = obtainStyledAttributes.getInteger(i3, cropImageOptions.r);
                    cropImageOptions.s = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropAspectRatioY, cropImageOptions.s);
                    cropImageOptions.j = k.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropScaleType, cropImageOptions.j.ordinal())];
                    cropImageOptions.m = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions.m);
                    cropImageOptions.n = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions.n);
                    cropImageOptions.o = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropMaxZoom, cropImageOptions.o);
                    cropImageOptions.f = c.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropShape, cropImageOptions.f.ordinal())];
                    cropImageOptions.i = d.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropGuidelines, cropImageOptions.i.ordinal())];
                    cropImageOptions.g = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropSnapRadius, cropImageOptions.g);
                    cropImageOptions.h = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropTouchRadius, cropImageOptions.h);
                    cropImageOptions.p = obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions.p);
                    cropImageOptions.t = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderLineThickness, cropImageOptions.t);
                    cropImageOptions.u = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBorderLineColor, cropImageOptions.u);
                    int i4 = R.styleable.CropImageView_cropBorderCornerThickness;
                    cropImageOptions.v = obtainStyledAttributes.getDimension(i4, cropImageOptions.v);
                    cropImageOptions.w = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerOffset, cropImageOptions.w);
                    cropImageOptions.x = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerLength, cropImageOptions.x);
                    cropImageOptions.y = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBorderCornerColor, cropImageOptions.y);
                    cropImageOptions.z = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropGuidelinesThickness, cropImageOptions.z);
                    cropImageOptions.A = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropGuidelinesColor, cropImageOptions.A);
                    cropImageOptions.B = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBackgroundColor, cropImageOptions.B);
                    cropImageOptions.k = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropShowCropOverlay, this.x);
                    cropImageOptions.l = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropShowProgressBar, this.y);
                    cropImageOptions.v = obtainStyledAttributes.getDimension(i4, cropImageOptions.v);
                    cropImageOptions.C = (int) obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropMinCropWindowWidth, (float) cropImageOptions.C);
                    cropImageOptions.D = (int) obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropMinCropWindowHeight, (float) cropImageOptions.D);
                    cropImageOptions.E = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMinCropResultWidthPX, (float) cropImageOptions.E);
                    cropImageOptions.F = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMinCropResultHeightPX, (float) cropImageOptions.F);
                    cropImageOptions.G = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMaxCropResultWidthPX, (float) cropImageOptions.G);
                    cropImageOptions.H = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMaxCropResultHeightPX, (float) cropImageOptions.H);
                    int i5 = R.styleable.CropImageView_cropFlipHorizontally;
                    cropImageOptions.X = obtainStyledAttributes.getBoolean(i5, cropImageOptions.X);
                    cropImageOptions.Y = obtainStyledAttributes.getBoolean(i5, cropImageOptions.Y);
                    this.w = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropSaveBitmapToInstanceState, this.w);
                    if (obtainStyledAttributes.hasValue(i3) && obtainStyledAttributes.hasValue(i3) && !obtainStyledAttributes.hasValue(i2)) {
                        cropImageOptions.q = true;
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        cropImageOptions.a();
        this.v = cropImageOptions.j;
        this.z = cropImageOptions.m;
        this.A = cropImageOptions.o;
        this.x = cropImageOptions.k;
        this.y = cropImageOptions.l;
        this.q = cropImageOptions.X;
        this.r = cropImageOptions.Y;
        View inflate = LayoutInflater.from(context).inflate(R.layout.crop_image_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ImageView_image);
        this.f = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) inflate.findViewById(R.id.CropOverlayView);
        this.g = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new a());
        cropOverlayView.setInitialAttributeValues(cropImageOptions);
        this.j = (ProgressBar) inflate.findViewById(R.id.CropProgressBar);
        h();
    }

    public final void a(float f2, float f3, boolean z2, boolean z3) {
        float f4;
        if (this.n != null) {
            float f5 = 0.0f;
            if (f2 > 0.0f && f3 > 0.0f) {
                this.h.invert(this.i);
                RectF cropWindowRect = this.g.getCropWindowRect();
                this.i.mapRect(cropWindowRect);
                this.h.reset();
                this.h.postTranslate((f2 - ((float) this.n.getWidth())) / 2.0f, (f3 - ((float) this.n.getHeight())) / 2.0f);
                d();
                int i2 = this.p;
                if (i2 > 0) {
                    this.h.postRotate((float) i2, uf5.m(this.k), uf5.n(this.k));
                    d();
                }
                float min = Math.min(f2 / uf5.t(this.k), f3 / uf5.p(this.k));
                k kVar = this.v;
                if (kVar == k.FIT_CENTER || ((kVar == k.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.z))) {
                    this.h.postScale(min, min, uf5.m(this.k), uf5.n(this.k));
                    d();
                }
                float f6 = this.q ? -this.I : this.I;
                float f7 = this.r ? -this.I : this.I;
                this.h.postScale(f6, f7, uf5.m(this.k), uf5.n(this.k));
                d();
                this.h.mapRect(cropWindowRect);
                if (z2) {
                    if (f2 > uf5.t(this.k)) {
                        f4 = 0.0f;
                    } else {
                        f4 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerX(), -uf5.q(this.k)), ((float) getWidth()) - uf5.r(this.k)) / f6;
                    }
                    this.J = f4;
                    if (f3 <= uf5.p(this.k)) {
                        f5 = Math.max(Math.min((f3 / 2.0f) - cropWindowRect.centerY(), -uf5.s(this.k)), ((float) getHeight()) - uf5.l(this.k)) / f7;
                    }
                    this.K = f5;
                } else {
                    this.J = Math.min(Math.max(this.J * f6, -cropWindowRect.left), (-cropWindowRect.right) + f2) / f6;
                    this.K = Math.min(Math.max(this.K * f7, -cropWindowRect.top), (-cropWindowRect.bottom) + f3) / f7;
                }
                this.h.postTranslate(this.J * f6, this.K * f7);
                cropWindowRect.offset(this.J * f6, this.K * f7);
                this.g.setCropWindowRect(cropWindowRect);
                d();
                this.g.invalidate();
                if (z3) {
                    xf5 xf5 = this.m;
                    float[] fArr = this.k;
                    Matrix matrix = this.h;
                    System.arraycopy(fArr, 0, xf5.i, 0, 8);
                    xf5.k.set(xf5.g.getCropWindowRect());
                    matrix.getValues(xf5.m);
                    this.f.startAnimation(this.m);
                } else {
                    this.f.setImageMatrix(this.h);
                }
                j(false);
            }
        }
    }

    public final void b() {
        Bitmap bitmap = this.n;
        if (bitmap != null && (this.u > 0 || this.G != null)) {
            bitmap.recycle();
        }
        this.n = null;
        this.u = 0;
        this.G = null;
        this.H = 1;
        this.p = 0;
        this.I = 1.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.h.reset();
        this.O = null;
        this.f.setImageBitmap(null);
        g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(boolean r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.CropImageView.c(boolean, boolean):void");
    }

    public final void d() {
        float[] fArr = this.k;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = (float) this.n.getWidth();
        float[] fArr2 = this.k;
        fArr2[3] = 0.0f;
        fArr2[4] = (float) this.n.getWidth();
        this.k[5] = (float) this.n.getHeight();
        float[] fArr3 = this.k;
        fArr3[6] = 0.0f;
        fArr3[7] = (float) this.n.getHeight();
        this.h.mapPoints(this.k);
        float[] fArr4 = this.l;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.h.mapPoints(fArr4);
    }

    public void e(int i2) {
        int i3;
        if (this.n != null) {
            if (i2 < 0) {
                i3 = (i2 % 360) + 360;
            } else {
                i3 = i2 % 360;
            }
            CropOverlayView cropOverlayView = this.g;
            boolean z2 = !cropOverlayView.z && ((i3 > 45 && i3 < 135) || (i3 > 215 && i3 < 305));
            RectF rectF = uf5.c;
            rectF.set(cropOverlayView.getCropWindowRect());
            float height = (z2 ? rectF.height() : rectF.width()) / 2.0f;
            float width = (z2 ? rectF.width() : rectF.height()) / 2.0f;
            if (z2) {
                boolean z3 = this.q;
                this.q = this.r;
                this.r = z3;
            }
            this.h.invert(this.i);
            float[] fArr = uf5.d;
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.centerY();
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            this.i.mapPoints(fArr);
            this.p = (this.p + i3) % 360;
            a((float) getWidth(), (float) getHeight(), true, false);
            Matrix matrix = this.h;
            float[] fArr2 = uf5.e;
            matrix.mapPoints(fArr2, fArr);
            float sqrt = (float) (((double) this.I) / Math.sqrt(Math.pow((double) (fArr2[5] - fArr2[3]), 2.0d) + Math.pow((double) (fArr2[4] - fArr2[2]), 2.0d)));
            this.I = sqrt;
            this.I = Math.max(sqrt, 1.0f);
            a((float) getWidth(), (float) getHeight(), true, false);
            this.h.mapPoints(fArr2, fArr);
            double sqrt2 = Math.sqrt(Math.pow((double) (fArr2[5] - fArr2[3]), 2.0d) + Math.pow((double) (fArr2[4] - fArr2[2]), 2.0d));
            float f2 = (float) (((double) height) * sqrt2);
            float f3 = (float) (((double) width) * sqrt2);
            rectF.set(fArr2[0] - f2, fArr2[1] - f3, fArr2[0] + f2, fArr2[1] + f3);
            this.g.h();
            this.g.setCropWindowRect(rectF);
            a((float) getWidth(), (float) getHeight(), true, false);
            c(false, false);
            CropOverlayView cropOverlayView2 = this.g;
            RectF cropWindowRect = cropOverlayView2.getCropWindowRect();
            cropOverlayView2.d(cropWindowRect);
            cropOverlayView2.h.f4044a.set(cropWindowRect);
        }
    }

    public final void f(Bitmap bitmap, int i2, Uri uri, int i3, int i4) {
        Bitmap bitmap2 = this.n;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.f.clearAnimation();
            b();
            this.n = bitmap;
            this.f.setImageBitmap(bitmap);
            this.G = uri;
            this.u = i2;
            this.H = i3;
            this.p = i4;
            a((float) getWidth(), (float) getHeight(), true, false);
            CropOverlayView cropOverlayView = this.g;
            if (cropOverlayView != null) {
                cropOverlayView.h();
                g();
            }
        }
    }

    public final void g() {
        CropOverlayView cropOverlayView = this.g;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.x || this.n == null) ? 4 : 0);
        }
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.g.getAspectRatioX()), Integer.valueOf(this.g.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.g.getCropWindowRect();
        float f2 = cropWindowRect.left;
        float f3 = cropWindowRect.top;
        float f4 = cropWindowRect.right;
        float f5 = cropWindowRect.bottom;
        float[] fArr = {f2, f3, f4, f3, f4, f5, f2, f5};
        this.h.invert(this.i);
        this.i.mapPoints(fArr);
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = fArr[i2] * ((float) this.H);
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i2 = this.H;
        Bitmap bitmap = this.n;
        if (bitmap == null) {
            return null;
        }
        float[] cropPoints = getCropPoints();
        int width = bitmap.getWidth() * i2;
        int height = i2 * bitmap.getHeight();
        CropOverlayView cropOverlayView = this.g;
        return uf5.o(cropPoints, width, height, cropOverlayView.z, cropOverlayView.getAspectRatioX(), this.g.getAspectRatioY());
    }

    public c getCropShape() {
        return this.g.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.g;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        Bitmap bitmap;
        int i2;
        j jVar = j.NONE;
        if (this.n == null) {
            return null;
        }
        this.f.clearAnimation();
        if (this.G == null || (this.H <= 1 && jVar != j.SAMPLING)) {
            i2 = 0;
            Bitmap bitmap2 = this.n;
            float[] cropPoints = getCropPoints();
            int i3 = this.p;
            CropOverlayView cropOverlayView = this.g;
            bitmap = uf5.e(bitmap2, cropPoints, i3, cropOverlayView.z, cropOverlayView.getAspectRatioX(), this.g.getAspectRatioY(), this.q, this.r).f3501a;
        } else {
            int width = this.n.getWidth() * this.H;
            int height = this.n.getHeight() * this.H;
            Context context = getContext();
            Uri uri = this.G;
            float[] cropPoints2 = getCropPoints();
            int i4 = this.p;
            CropOverlayView cropOverlayView2 = this.g;
            i2 = 0;
            bitmap = uf5.c(context, uri, cropPoints2, i4, width, height, cropOverlayView2.z, cropOverlayView2.getAspectRatioX(), this.g.getAspectRatioY(), 0, 0, this.q, this.r).f3501a;
        }
        return uf5.u(bitmap, 0, i2, jVar);
    }

    public void getCroppedImageAsync() {
        j jVar = j.NONE;
        if (this.F != null) {
            i(0, 0, jVar, null, null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public d getGuidelines() {
        return this.g.getGuidelines();
    }

    public int getImageResource() {
        return this.u;
    }

    public Uri getImageUri() {
        return this.G;
    }

    public int getMaxZoom() {
        return this.A;
    }

    public int getRotatedDegrees() {
        return this.p;
    }

    public k getScaleType() {
        return this.v;
    }

    public Rect getWholeImageRect() {
        int i2 = this.H;
        Bitmap bitmap = this.n;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i2, bitmap.getHeight() * i2);
    }

    public final void h() {
        int i2 = 0;
        boolean z2 = this.y && ((this.n == null && this.P != null) || this.Q != null);
        ProgressBar progressBar = this.j;
        if (!z2) {
            i2 = 4;
        }
        progressBar.setVisibility(i2);
    }

    public void i(int i2, int i3, j jVar, Uri uri, Bitmap.CompressFormat compressFormat, int i4) {
        CropImageView cropImageView;
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f.clearAnimation();
            WeakReference<sf5> weakReference = this.Q;
            sf5 sf5 = weakReference != null ? weakReference.get() : null;
            if (sf5 != null) {
                sf5.cancel(true);
            }
            j jVar2 = j.NONE;
            int i5 = jVar != jVar2 ? i2 : 0;
            int i6 = jVar != jVar2 ? i3 : 0;
            int width = bitmap.getWidth() * this.H;
            int height = bitmap.getHeight();
            int i7 = this.H;
            int i8 = height * i7;
            if (this.G == null || (i7 <= 1 && jVar != j.SAMPLING)) {
                float[] cropPoints = getCropPoints();
                int i9 = this.p;
                CropOverlayView cropOverlayView = this.g;
                cropImageView = this;
                cropImageView.Q = new WeakReference<>(new sf5(this, bitmap, cropPoints, i9, cropOverlayView.z, cropOverlayView.getAspectRatioX(), this.g.getAspectRatioY(), i5, i6, this.q, this.r, jVar, uri, compressFormat, i4));
            } else {
                Uri uri2 = this.G;
                float[] cropPoints2 = getCropPoints();
                int i10 = this.p;
                CropOverlayView cropOverlayView2 = this.g;
                this.Q = new WeakReference<>(new sf5(this, uri2, cropPoints2, i10, width, i8, cropOverlayView2.z, cropOverlayView2.getAspectRatioX(), this.g.getAspectRatioY(), i5, i6, this.q, this.r, jVar, uri, compressFormat, i4));
                cropImageView = this;
            }
            cropImageView.Q.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            h();
        }
    }

    public final void j(boolean z2) {
        if (this.n != null && !z2) {
            float t2 = (((float) this.H) * 100.0f) / uf5.t(this.l);
            float p2 = (((float) this.H) * 100.0f) / uf5.p(this.l);
            yf5 yf5 = this.g.h;
            yf5.e = (float) getWidth();
            yf5.f = (float) getHeight();
            yf5.k = t2;
            yf5.l = p2;
        }
        this.g.i(z2 ? null : this.k, getWidth(), getHeight());
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.s <= 0 || this.t <= 0) {
            j(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.s;
        layoutParams.height = this.t;
        setLayoutParams(layoutParams);
        if (this.n != null) {
            float f2 = (float) (i4 - i2);
            float f3 = (float) (i5 - i3);
            a(f2, f3, true, false);
            if (this.L != null) {
                int i6 = this.M;
                if (i6 != this.o) {
                    this.p = i6;
                    a(f2, f3, true, false);
                }
                this.h.mapRect(this.L);
                this.g.setCropWindowRect(this.L);
                c(false, false);
                CropOverlayView cropOverlayView = this.g;
                RectF cropWindowRect = cropOverlayView.getCropWindowRect();
                cropOverlayView.d(cropWindowRect);
                cropOverlayView.h.f4044a.set(cropWindowRect);
                this.L = null;
            } else if (this.N) {
                this.N = false;
                c(false, false);
            }
        } else {
            j(true);
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.n.getWidth() ? ((double) size) / ((double) this.n.getWidth()) : Double.POSITIVE_INFINITY;
            double height = size2 < this.n.getHeight() ? ((double) size2) / ((double) this.n.getHeight()) : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i5 = this.n.getWidth();
                i4 = this.n.getHeight();
            } else if (width <= height) {
                i4 = (int) (((double) this.n.getHeight()) * width);
                i5 = size;
            } else {
                i5 = (int) (((double) this.n.getWidth()) * height);
                i4 = size2;
            }
            if (mode != 1073741824) {
                size = mode == Integer.MIN_VALUE ? Math.min(i5, size) : i5;
            }
            if (mode2 != 1073741824) {
                size2 = mode2 == Integer.MIN_VALUE ? Math.min(i4, size2) : i4;
            }
            this.s = size;
            this.t = size2;
            setMeasuredDimension(size, size2);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.P == null && this.G == null && this.n == null && this.u == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Pair<String, WeakReference<Bitmap>> pair = uf5.g;
                        Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) uf5.g.second).get();
                        uf5.g = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            f(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.G == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i2 = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i2 > 0) {
                        setImageResource(i2);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i3 = bundle.getInt("DEGREES_ROTATED");
                this.M = i3;
                this.p = i3;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.g.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.L = rectF;
                }
                this.g.setCropShape(c.valueOf(bundle.getString("CROP_SHAPE")));
                this.z = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.A = bundle.getInt("CROP_MAX_ZOOM");
                this.q = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.r = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        tf5 tf5;
        boolean z2 = true;
        if (this.G == null && this.n == null && this.u < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.G;
        if (this.w && uri == null && this.u < 1) {
            Context context = getContext();
            Bitmap bitmap = this.n;
            Uri uri2 = this.O;
            Rect rect = uf5.f3500a;
            if (uri2 == null) {
                try {
                    uri2 = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
                } catch (Exception unused) {
                    uri = null;
                }
            } else if (new File(uri2.getPath()).exists()) {
                z2 = false;
            }
            if (z2) {
                uf5.v(context, bitmap, uri2, Bitmap.CompressFormat.JPEG, 95);
            }
            uri = uri2;
            this.O = uri;
        }
        if (!(uri == null || this.n == null)) {
            String uuid = UUID.randomUUID().toString();
            uf5.g = new Pair<>(uuid, new WeakReference(this.n));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<tf5> weakReference = this.P;
        if (!(weakReference == null || (tf5 = weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", tf5.b);
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.u);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.H);
        bundle.putInt("DEGREES_ROTATED", this.p);
        bundle.putParcelable("INITIAL_CROP_RECT", this.g.getInitialCropWindowRect());
        RectF rectF = uf5.c;
        rectF.set(this.g.getCropWindowRect());
        this.h.invert(this.i);
        this.i.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", this.g.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.z);
        bundle.putInt("CROP_MAX_ZOOM", this.A);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.q);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.r);
        return bundle;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.N = i4 > 0 && i5 > 0;
    }

    public void setAutoZoomEnabled(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
            c(false, false);
            this.g.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.g.setInitialCropWindowRect(rect);
    }

    public void setCropShape(c cVar) {
        this.g.setCropShape(cVar);
    }

    public void setFixedAspectRatio(boolean z2) {
        this.g.setFixedAspectRatio(z2);
    }

    public void setFlippedHorizontally(boolean z2) {
        if (this.q != z2) {
            this.q = z2;
            a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public void setGuidelines(d dVar) {
        this.g.setGuidelines(dVar);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.g.setInitialCropWindowRect(null);
        f(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i2) {
        if (i2 != 0) {
            this.g.setInitialCropWindowRect(null);
            f(BitmapFactory.decodeResource(getResources(), i2), i2, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<tf5> weakReference = this.P;
            tf5 tf5 = weakReference != null ? weakReference.get() : null;
            if (tf5 != null) {
                tf5.cancel(true);
            }
            b();
            this.L = null;
            this.M = 0;
            this.g.setInitialCropWindowRect(null);
            WeakReference<tf5> weakReference2 = new WeakReference<>(new tf5(this, uri));
            this.P = weakReference2;
            weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            h();
        }
    }

    public void setMaxZoom(int i2) {
        if (this.A != i2 && i2 > 0) {
            this.A = i2;
            c(false, false);
            this.g.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z2) {
        if (this.g.j(z2)) {
            c(false, false);
            this.g.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(e eVar) {
        this.F = eVar;
    }

    public void setOnCropWindowChangedListener(h hVar) {
        this.D = hVar;
    }

    public void setOnSetCropOverlayMovedListener(f fVar) {
        this.C = fVar;
    }

    public void setOnSetCropOverlayReleasedListener(g gVar) {
        this.B = gVar;
    }

    public void setOnSetImageUriCompleteListener(i iVar) {
        this.E = iVar;
    }

    public void setRotatedDegrees(int i2) {
        int i3 = this.p;
        if (i3 != i2) {
            e(i2 - i3);
        }
    }

    public void setSaveBitmapToInstanceState(boolean z2) {
        this.w = z2;
    }

    public void setScaleType(k kVar) {
        if (kVar != this.v) {
            this.v = kVar;
            this.I = 1.0f;
            this.K = 0.0f;
            this.J = 0.0f;
            this.g.h();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z2) {
        if (this.x != z2) {
            this.x = z2;
            g();
        }
    }

    public void setShowProgressBar(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            h();
        }
    }

    public void setSnapRadius(float f2) {
        if (f2 >= 0.0f) {
            this.g.setSnapRadius(f2);
        }
    }
}
