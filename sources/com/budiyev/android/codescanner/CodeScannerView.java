package com.budiyev.android.codescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import defpackage.qk1;
import java.util.List;

public final class CodeScannerView extends ViewGroup {
    public SurfaceView f;
    public dl1 g;
    public ImageView h;
    public ImageView i;
    public xk1 j;
    public d k;
    public qk1 l;
    public int m;
    public int n;
    public int o;
    public int p;

    public final class b implements View.OnClickListener {
        public b(a aVar) {
        }

        public void onClick(View view) {
            qk1 qk1 = CodeScannerView.this.l;
            if (qk1 != null) {
                vk1 vk1 = qk1.r;
                if (vk1 == null || vk1.h) {
                    boolean z = !qk1.v;
                    qk1.e(z);
                    CodeScannerView.this.setAutoFocusEnabled(z);
                }
            }
        }
    }

    public final class c implements View.OnClickListener {
        public c(a aVar) {
        }

        public void onClick(View view) {
            qk1 qk1 = CodeScannerView.this.l;
            if (qk1 != null) {
                vk1 vk1 = qk1.r;
                boolean z = false;
                if (vk1 == null || vk1.i) {
                    boolean z2 = !qk1.w;
                    synchronized (qk1.f2950a) {
                        if (qk1.w != z2) {
                            z = true;
                        }
                        qk1.w = z2;
                        qk1.d.setFlashEnabled(z2);
                        vk1 vk12 = qk1.r;
                        if (qk1.t && qk1.z && z && vk12 != null && vk12.i) {
                            qk1.g(z2);
                        }
                    }
                    CodeScannerView.this.setFlashEnabled(z2);
                }
            }
        }
    }

    public interface d {
    }

    public CodeScannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceView surfaceView = new SurfaceView(context);
        this.f = surfaceView;
        surfaceView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        dl1 dl1 = new dl1(context);
        this.g = dl1;
        dl1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        float f2 = context.getResources().getDisplayMetrics().density;
        this.m = Math.round(56.0f * f2);
        this.p = Math.round(20.0f * f2);
        ImageView imageView = new ImageView(context);
        this.h = imageView;
        int i2 = this.m;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(i2, i2));
        this.h.setScaleType(ImageView.ScaleType.CENTER);
        this.h.setImageResource(R.drawable.ic_code_scanner_auto_focus_on);
        TypedArray typedArray = null;
        this.h.setOnClickListener(new b(null));
        ImageView imageView2 = new ImageView(context);
        this.i = imageView2;
        int i3 = this.m;
        imageView2.setLayoutParams(new ViewGroup.LayoutParams(i3, i3));
        this.i.setScaleType(ImageView.ScaleType.CENTER);
        this.i.setImageResource(R.drawable.ic_code_scanner_flash_on);
        this.i.setOnClickListener(new c(null));
        if (attributeSet == null) {
            dl1 dl12 = this.g;
            dl12.l = 1.0f;
            dl12.m = 1.0f;
            dl12.a();
            if (dl12.isLaidOut()) {
                dl12.invalidate();
            }
            dl1 dl13 = this.g;
            dl13.f.setColor(1996488704);
            if (dl13.isLaidOut()) {
                dl13.invalidate();
            }
            dl1 dl14 = this.g;
            dl14.g.setColor(-1);
            if (dl14.isLaidOut()) {
                dl14.invalidate();
            }
            dl1 dl15 = this.g;
            dl15.g.setStrokeWidth((float) Math.round(2.0f * f2));
            if (dl15.isLaidOut()) {
                dl15.invalidate();
            }
            dl1 dl16 = this.g;
            dl16.j = Math.round(50.0f * f2);
            if (dl16.isLaidOut()) {
                dl16.invalidate();
            }
            dl1 dl17 = this.g;
            dl17.k = Math.round(f2 * 0.0f);
            if (dl17.isLaidOut()) {
                dl17.invalidate();
            }
            dl1 dl18 = this.g;
            dl18.n = 0.75f;
            dl18.a();
            if (dl18.isLaidOut()) {
                dl18.invalidate();
            }
            this.h.setColorFilter(-1);
            this.i.setColorFilter(-1);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
        } else {
            try {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CodeScannerView, 0, 0);
                setMaskColor(obtainStyledAttributes.getColor(R.styleable.CodeScannerView_maskColor, 1996488704));
                setFrameColor(obtainStyledAttributes.getColor(R.styleable.CodeScannerView_frameColor, -1));
                setFrameThickness(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CodeScannerView_frameThickness, Math.round(2.0f * f2)));
                setFrameCornersSize(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CodeScannerView_frameCornersSize, Math.round(50.0f * f2)));
                setFrameCornersRadius(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.CodeScannerView_frameCornersRadius, Math.round(f2 * 0.0f)));
                float f3 = obtainStyledAttributes.getFloat(R.styleable.CodeScannerView_frameAspectRatioWidth, 1.0f);
                float f4 = obtainStyledAttributes.getFloat(R.styleable.CodeScannerView_frameAspectRatioHeight, 1.0f);
                if (f3 <= 0.0f || f4 <= 0.0f) {
                    throw new IllegalArgumentException("Frame aspect ratio values should be greater than zero");
                }
                dl1 dl19 = this.g;
                dl19.l = f3;
                dl19.m = f4;
                dl19.a();
                if (dl19.isLaidOut()) {
                    dl19.invalidate();
                }
                setFrameSize(obtainStyledAttributes.getFloat(R.styleable.CodeScannerView_frameSize, 0.75f));
                setAutoFocusButtonVisible(obtainStyledAttributes.getBoolean(R.styleable.CodeScannerView_autoFocusButtonVisible, true));
                setFlashButtonVisible(obtainStyledAttributes.getBoolean(R.styleable.CodeScannerView_flashButtonVisible, true));
                setAutoFocusButtonColor(obtainStyledAttributes.getColor(R.styleable.CodeScannerView_autoFocusButtonColor, -1));
                setFlashButtonColor(obtainStyledAttributes.getColor(R.styleable.CodeScannerView_flashButtonColor, -1));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                if (0 != 0) {
                    typedArray.recycle();
                }
                throw th;
            }
        }
        addView(this.f);
        addView(this.g);
        addView(this.h);
        addView(this.i);
    }

    public final void a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        xk1 xk1 = this.j;
        if (xk1 == null) {
            this.f.layout(0, 0, i2, i3);
        } else {
            int i8 = xk1.f3936a;
            if (i8 > i2) {
                int i9 = (i8 - i2) / 2;
                i4 = 0 - i9;
                i5 = i9 + i2;
            } else {
                i5 = i2;
                i4 = 0;
            }
            int i10 = xk1.b;
            if (i10 > i3) {
                int i11 = (i10 - i3) / 2;
                i6 = 0 - i11;
                i7 = i11 + i3;
            } else {
                i7 = i3;
                i6 = 0;
            }
            this.f.layout(i4, i6, i5, i7);
        }
        this.g.layout(0, 0, i2, i3);
        int i12 = this.m;
        this.h.layout(0, 0, i12, i12);
        this.i.layout(i2 - i12, 0, i2, i12);
    }

    public int getAutoFocusButtonColor() {
        return this.n;
    }

    public int getFlashButtonColor() {
        return this.o;
    }

    public float getFrameAspectRatioHeight() {
        return this.g.m;
    }

    public float getFrameAspectRatioWidth() {
        return this.g.l;
    }

    public int getFrameColor() {
        return this.g.g.getColor();
    }

    public int getFrameCornersRadius() {
        return this.g.k;
    }

    public int getFrameCornersSize() {
        return this.g.j;
    }

    public yk1 getFrameRect() {
        return this.g.i;
    }

    public float getFrameSize() {
        return this.g.n;
    }

    public int getFrameThickness() {
        return (int) this.g.g.getStrokeWidth();
    }

    public int getMaskColor() {
        return this.g.f.getColor();
    }

    public SurfaceView getPreviewView() {
        return this.f;
    }

    public dl1 getViewFinderView() {
        return this.g;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a(i4 - i2, i5 - i3);
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        a(i2, i3);
        d dVar = this.k;
        if (dVar != null) {
            qk1.h hVar = (qk1.h) dVar;
            synchronized (qk1.this.f2950a) {
                qk1 qk1 = qk1.this;
                if (!(i2 == qk1.E && i3 == qk1.F)) {
                    boolean z = qk1.z;
                    if (qk1.t) {
                        qk1.this.b();
                    }
                    if (z || qk1.this.C) {
                        qk1.this.a(i2, i3);
                    }
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        qk1 qk1 = this.l;
        yk1 frameRect = getFrameRect();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!(qk1 == null || frameRect == null)) {
            vk1 vk1 = qk1.r;
            if ((vk1 == null || vk1.h) && motionEvent.getAction() == 0) {
                if (frameRect.f4062a < x && frameRect.b < y && frameRect.c > x && frameRect.d > y) {
                    int i2 = this.p;
                    int i3 = x - i2;
                    int i4 = y - i2;
                    int i5 = x + i2;
                    int i6 = y + i2;
                    yk1 yk1 = new yk1(i3, i4, i5, i6);
                    int b2 = yk1.b();
                    int a2 = yk1.a();
                    int i7 = frameRect.f4062a;
                    int i8 = frameRect.b;
                    int i9 = frameRect.c;
                    int i10 = frameRect.d;
                    int b3 = frameRect.b();
                    int a3 = frameRect.a();
                    if (i3 < i7 || i4 < i8 || i5 > i9 || i6 > i10) {
                        int min = Math.min(b2, b3);
                        int min2 = Math.min(a2, a3);
                        if (i3 < i7) {
                            i5 = i7 + min;
                            i3 = i7;
                        } else if (i5 > i9) {
                            i3 = i9 - min;
                            i5 = i9;
                        }
                        if (i4 < i8) {
                            i6 = i8 + min2;
                            i4 = i8;
                        } else if (i6 > i10) {
                            i4 = i10 - min2;
                            i6 = i10;
                        }
                        yk1 = new yk1(i3, i4, i5, i6);
                    }
                    synchronized (qk1.f2950a) {
                        if (qk1.t && qk1.z && !qk1.y) {
                            try {
                                qk1.e(false);
                                vk1 vk12 = qk1.r;
                                if (qk1.z && vk12 != null && vk12.h) {
                                    xk1 xk1 = vk12.c;
                                    int i11 = xk1.f3936a;
                                    int i12 = xk1.b;
                                    int i13 = vk12.f;
                                    if (i13 == 90 || i13 == 270) {
                                        i11 = i12;
                                        i12 = i11;
                                    }
                                    yk1 I = gj1.I(i11, i12, yk1, vk12.d, vk12.e);
                                    Camera camera = vk12.f3658a;
                                    camera.cancelAutoFocus();
                                    Camera.Parameters parameters = camera.getParameters();
                                    gj1.q(parameters, I, i11, i12, i13);
                                    if (!"auto".equals(parameters.getFocusMode())) {
                                        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                                        if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                            parameters.setFocusMode("auto");
                                        }
                                    }
                                    camera.setParameters(parameters);
                                    camera.autoFocus(qk1.h);
                                    qk1.y = true;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAutoFocusButtonColor(int i2) {
        this.n = i2;
        this.h.setColorFilter(i2);
    }

    public void setAutoFocusButtonVisible(boolean z) {
        this.h.setVisibility(z ? 0 : 4);
    }

    public void setAutoFocusEnabled(boolean z) {
        this.h.setImageResource(z ? R.drawable.ic_code_scanner_auto_focus_on : R.drawable.ic_code_scanner_auto_focus_off);
    }

    public void setCodeScanner(qk1 qk1) {
        if (this.l == null) {
            this.l = qk1;
            setAutoFocusEnabled(qk1.v);
            setFlashEnabled(qk1.w);
            return;
        }
        throw new IllegalStateException("Code scanner has already been set");
    }

    public void setFlashButtonColor(int i2) {
        this.o = i2;
        this.i.setColorFilter(i2);
    }

    public void setFlashButtonVisible(boolean z) {
        this.i.setVisibility(z ? 0 : 4);
    }

    public void setFlashEnabled(boolean z) {
        this.i.setImageResource(z ? R.drawable.ic_code_scanner_flash_on : R.drawable.ic_code_scanner_flash_off);
    }

    public void setFrameAspectRatioHeight(float f2) {
        if (f2 > 0.0f) {
            dl1 dl1 = this.g;
            dl1.m = f2;
            dl1.a();
            if (dl1.isLaidOut()) {
                dl1.invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Frame aspect ratio values should be greater than zero");
    }

    public void setFrameAspectRatioWidth(float f2) {
        if (f2 > 0.0f) {
            dl1 dl1 = this.g;
            dl1.l = f2;
            dl1.a();
            if (dl1.isLaidOut()) {
                dl1.invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Frame aspect ratio values should be greater than zero");
    }

    public void setFrameColor(int i2) {
        dl1 dl1 = this.g;
        dl1.g.setColor(i2);
        if (dl1.isLaidOut()) {
            dl1.invalidate();
        }
    }

    public void setFrameCornersRadius(int i2) {
        if (i2 >= 0) {
            dl1 dl1 = this.g;
            dl1.k = i2;
            if (dl1.isLaidOut()) {
                dl1.invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Frame corners radius can't be negative");
    }

    public void setFrameCornersSize(int i2) {
        if (i2 >= 0) {
            dl1 dl1 = this.g;
            dl1.j = i2;
            if (dl1.isLaidOut()) {
                dl1.invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Frame corners size can't be negative");
    }

    public void setFrameSize(float f2) {
        if (((double) f2) < 0.1d || f2 > 1.0f) {
            throw new IllegalArgumentException("Max frame size value should be between 0.1 and 1, inclusive");
        }
        dl1 dl1 = this.g;
        dl1.n = f2;
        dl1.a();
        if (dl1.isLaidOut()) {
            dl1.invalidate();
        }
    }

    public void setFrameThickness(int i2) {
        if (i2 >= 0) {
            dl1 dl1 = this.g;
            dl1.g.setStrokeWidth((float) i2);
            if (dl1.isLaidOut()) {
                dl1.invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Frame thickness can't be negative");
    }

    public void setMaskColor(int i2) {
        dl1 dl1 = this.g;
        dl1.f.setColor(i2);
        if (dl1.isLaidOut()) {
            dl1.invalidate();
        }
    }

    public void setPreviewSize(xk1 xk1) {
        this.j = xk1;
        requestLayout();
    }

    public void setSizeListener(d dVar) {
        this.k = dVar;
    }
}
