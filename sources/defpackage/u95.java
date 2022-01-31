package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.zxing.client.android.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: u95  reason: default package */
/* compiled from: CameraPreview */
public class u95 extends ViewGroup {
    public static final String F = u95.class.getSimpleName();
    public boolean A = false;
    public final SurfaceHolder.Callback B = new a();
    public final Handler.Callback C = new b();
    public ca5 D = new c();
    public final e E = new d();
    public ka5 f;
    public WindowManager g;
    public Handler h;
    public boolean i = false;
    public SurfaceView j;
    public TextureView k;
    public boolean l = false;
    public ea5 m;
    public int n = -1;
    public List<e> o = new ArrayList();
    public qa5 p;
    public ma5 q = new ma5();
    public fa5 r;
    public fa5 s;
    public Rect t;
    public fa5 u;
    public Rect v = null;
    public Rect w = null;
    public fa5 x = null;
    public double y = 0.1d;
    public va5 z = null;

    /* renamed from: u95$a */
    /* compiled from: CameraPreview */
    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                String str = u95.F;
                String str2 = u95.F;
                return;
            }
            u95 u95 = u95.this;
            u95.u = new fa5(i2, i3);
            u95.h();
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            u95.this.u = null;
        }
    }

    /* renamed from: u95$b */
    /* compiled from: CameraPreview */
    public class b implements Handler.Callback {
        public b() {
        }

        public boolean handleMessage(Message message) {
            qa5 qa5;
            int i = message.what;
            boolean z = true;
            if (i == R.id.zxing_prewiew_size_ready) {
                u95 u95 = u95.this;
                fa5 fa5 = (fa5) message.obj;
                u95.s = fa5;
                fa5 fa52 = u95.r;
                if (fa52 != null) {
                    if (fa5 == null || (qa5 = u95.p) == null) {
                        u95.w = null;
                        u95.v = null;
                        u95.t = null;
                        throw new IllegalStateException("containerSize or previewSize is not set yet");
                    }
                    int i2 = fa5.f;
                    int i3 = fa5.g;
                    int i4 = fa52.f;
                    int i5 = fa52.g;
                    u95.t = qa5.c.b(fa5, qa5.f2919a);
                    Rect rect = new Rect(0, 0, i4, i5);
                    Rect rect2 = u95.t;
                    Rect rect3 = new Rect(rect);
                    rect3.intersect(rect2);
                    if (u95.x != null) {
                        rect3.inset(Math.max(0, (rect3.width() - u95.x.f) / 2), Math.max(0, (rect3.height() - u95.x.g) / 2));
                    } else {
                        int min = (int) Math.min(((double) rect3.width()) * u95.y, ((double) rect3.height()) * u95.y);
                        rect3.inset(min, min);
                        if (rect3.height() > rect3.width()) {
                            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
                        }
                    }
                    u95.v = rect3;
                    Rect rect4 = new Rect(u95.v);
                    Rect rect5 = u95.t;
                    rect4.offset(-rect5.left, -rect5.top);
                    Rect rect6 = new Rect((rect4.left * i2) / u95.t.width(), (rect4.top * i3) / u95.t.height(), (rect4.right * i2) / u95.t.width(), (rect4.bottom * i3) / u95.t.height());
                    u95.w = rect6;
                    if (rect6.width() <= 0 || u95.w.height() <= 0) {
                        u95.w = null;
                        u95.v = null;
                    } else {
                        u95.E.a();
                    }
                    u95.requestLayout();
                    u95.h();
                }
                return true;
            }
            if (i == R.id.zxing_camera_error) {
                Exception exc = (Exception) message.obj;
                u95 u952 = u95.this;
                if (u952.f == null) {
                    z = false;
                }
                if (z) {
                    u952.d();
                    u95.this.E.b(exc);
                }
            }
            return false;
        }
    }

    /* renamed from: u95$c */
    /* compiled from: CameraPreview */
    public class c implements ca5 {
        public c() {
        }
    }

    /* renamed from: u95$d */
    /* compiled from: CameraPreview */
    public class d implements e {
        public d() {
        }

        @Override // defpackage.u95.e
        public void a() {
            for (e eVar : u95.this.o) {
                eVar.a();
            }
        }

        @Override // defpackage.u95.e
        public void b(Exception exc) {
            for (e eVar : u95.this.o) {
                eVar.b(exc);
            }
        }

        @Override // defpackage.u95.e
        public void c() {
            for (e eVar : u95.this.o) {
                eVar.c();
            }
        }

        @Override // defpackage.u95.e
        public void d() {
            for (e eVar : u95.this.o) {
                eVar.d();
            }
        }
    }

    /* renamed from: u95$e */
    /* compiled from: CameraPreview */
    public interface e {
        void a();

        void b(Exception exc);

        void c();

        void d();
    }

    public u95(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public static void a(u95 u95) {
        if ((u95.f != null) && u95.getDisplayRotation() != u95.n) {
            u95.d();
            u95.f();
        }
    }

    private int getDisplayRotation() {
        return this.g.getDefaultDisplay().getRotation();
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        c(attributeSet);
        this.g = (WindowManager) context.getSystemService("window");
        this.h = new Handler(this.C);
        this.m = new ea5();
    }

    public void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.x = new fa5(dimension, dimension2);
        }
        this.i = obtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = obtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.z = new pa5();
        } else if (integer == 2) {
            this.z = new ra5();
        } else if (integer == 3) {
            this.z = new sa5();
        }
        obtainStyledAttributes.recycle();
    }

    public void d() {
        TextureView textureView;
        SurfaceView surfaceView;
        hd3.g3();
        this.n = -1;
        ka5 ka5 = this.f;
        if (ka5 != null) {
            hd3.g3();
            if (ka5.f) {
                ka5.f2040a.b(ka5.k);
            }
            ka5.f = false;
            this.f = null;
            this.l = false;
        }
        if (this.u == null && (surfaceView = this.j) != null) {
            surfaceView.getHolder().removeCallback(this.B);
        }
        if (this.u == null && (textureView = this.k) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.r = null;
        this.s = null;
        this.w = null;
        ea5 ea5 = this.m;
        OrientationEventListener orientationEventListener = ea5.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        ea5.c = null;
        ea5.b = null;
        ea5.d = null;
        this.E.c();
    }

    public void e() {
    }

    public void f() {
        hd3.g3();
        if (this.f == null) {
            ka5 ka5 = new ka5(getContext());
            this.f = ka5;
            ma5 ma5 = this.q;
            if (!ka5.f) {
                ka5.g = ma5;
                ka5.c.g = ma5;
            }
            ka5.d = this.h;
            hd3.g3();
            ka5.f = true;
            oa5 oa5 = ka5.f2040a;
            Runnable runnable = ka5.h;
            synchronized (oa5.d) {
                oa5.c++;
                oa5.b(runnable);
            }
            this.n = getDisplayRotation();
        }
        if (this.u != null) {
            h();
        } else {
            SurfaceView surfaceView = this.j;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.B);
            } else {
                TextureView textureView = this.k;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(new t95(this));
                }
            }
        }
        requestLayout();
        ea5 ea5 = this.m;
        Context context = getContext();
        ca5 ca5 = this.D;
        OrientationEventListener orientationEventListener = ea5.c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        ea5.c = null;
        ea5.b = null;
        ea5.d = null;
        Context applicationContext = context.getApplicationContext();
        ea5.d = ca5;
        ea5.b = (WindowManager) applicationContext.getSystemService("window");
        da5 da5 = new da5(ea5, applicationContext, 3);
        ea5.c = da5;
        da5.enable();
        ea5.f950a = ea5.b.getDefaultDisplay().getRotation();
    }

    public final void g(na5 na5) {
        ka5 ka5;
        if (!this.l && (ka5 = this.f) != null) {
            ka5.b = na5;
            hd3.g3();
            ka5.b();
            ka5.f2040a.b(ka5.j);
            this.l = true;
            e();
            this.E.d();
        }
    }

    public ka5 getCameraInstance() {
        return this.f;
    }

    public ma5 getCameraSettings() {
        return this.q;
    }

    public Rect getFramingRect() {
        return this.v;
    }

    public fa5 getFramingRectSize() {
        return this.x;
    }

    public double getMarginFraction() {
        return this.y;
    }

    public Rect getPreviewFramingRect() {
        return this.w;
    }

    public va5 getPreviewScalingStrategy() {
        va5 va5 = this.z;
        if (va5 != null) {
            return va5;
        }
        if (this.k != null) {
            return new pa5();
        }
        return new ra5();
    }

    public final void h() {
        Rect rect;
        float f2;
        fa5 fa5 = this.u;
        if (fa5 != null && this.s != null && (rect = this.t) != null) {
            if (this.j == null || !fa5.equals(new fa5(rect.width(), this.t.height()))) {
                TextureView textureView = this.k;
                if (textureView != null && textureView.getSurfaceTexture() != null) {
                    if (this.s != null) {
                        int width = this.k.getWidth();
                        int height = this.k.getHeight();
                        fa5 fa52 = this.s;
                        float f3 = ((float) width) / ((float) height);
                        float f4 = ((float) fa52.f) / ((float) fa52.g);
                        float f5 = 1.0f;
                        if (f3 < f4) {
                            f5 = f4 / f3;
                            f2 = 1.0f;
                        } else {
                            f2 = f3 / f4;
                        }
                        Matrix matrix = new Matrix();
                        matrix.setScale(f5, f2);
                        float f6 = (float) width;
                        float f7 = (float) height;
                        matrix.postTranslate((f6 - (f5 * f6)) / 2.0f, (f7 - (f2 * f7)) / 2.0f);
                        this.k.setTransform(matrix);
                    }
                    g(new na5(this.k.getSurfaceTexture()));
                    return;
                }
                return;
            }
            g(new na5(this.j.getHolder()));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i) {
            TextureView textureView = new TextureView(getContext());
            this.k = textureView;
            textureView.setSurfaceTextureListener(new t95(this));
            addView(this.k);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.j = surfaceView;
        surfaceView.getHolder().addCallback(this.B);
        addView(this.j);
    }

    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        fa5 fa5 = new fa5(i4 - i2, i5 - i3);
        this.r = fa5;
        ka5 ka5 = this.f;
        if (ka5 != null && ka5.e == null) {
            qa5 qa5 = new qa5(getDisplayRotation(), fa5);
            this.p = qa5;
            qa5.c = getPreviewScalingStrategy();
            ka5 ka52 = this.f;
            qa5 qa52 = this.p;
            ka52.e = qa52;
            ka52.c.h = qa52;
            hd3.g3();
            ka52.b();
            ka52.f2040a.b(ka52.i);
            boolean z3 = this.A;
            if (z3) {
                ka5 ka53 = this.f;
                Objects.requireNonNull(ka53);
                hd3.g3();
                if (ka53.f) {
                    ka53.f2040a.b(new ia5(ka53, z3));
                }
            }
        }
        SurfaceView surfaceView = this.j;
        if (surfaceView != null) {
            Rect rect = this.t;
            if (rect == null) {
                surfaceView.layout(0, 0, getWidth(), getHeight());
            } else {
                surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        } else {
            TextureView textureView = this.k;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.A);
        return bundle;
    }

    public void setCameraSettings(ma5 ma5) {
        this.q = ma5;
    }

    public void setFramingRectSize(fa5 fa5) {
        this.x = fa5;
    }

    public void setMarginFraction(double d2) {
        if (d2 < 0.5d) {
            this.y = d2;
            return;
        }
        throw new IllegalArgumentException("The margin fraction must be less than 0.5");
    }

    public void setPreviewScalingStrategy(va5 va5) {
        this.z = va5;
    }

    public void setTorch(boolean z2) {
        this.A = z2;
        ka5 ka5 = this.f;
        if (ka5 != null) {
            hd3.g3();
            if (ka5.f) {
                ka5.f2040a.b(new ia5(ka5, z2));
            }
        }
    }

    public void setUseTextureView(boolean z2) {
        this.i = z2;
    }
}
